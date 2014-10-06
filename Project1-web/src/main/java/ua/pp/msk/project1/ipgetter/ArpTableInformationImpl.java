/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.ipgetter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

/**
 *
 * @author maskimko
 */
public class ArpTableInformationImpl implements ArpTableInformation{

    public static final String LINUXARP = "/proc/net/arp";
    public static final String ARPPATTERNLINE = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5]))\\s+(0x\\d+)\\s+(0x\\d+)\\s+((\\w{2}:){5}\\w{2})\\s+([*\\w]+)\\s+(\\w+)\\s*";
    
    @Override
    public List<ArpTableRecord> getArpTable() {
         List<String> arpLines = new ArrayList<String>();
        List<ArpTableRecord> arpRecords = new ArrayList<ArpTableRecord>();
        Pattern arpPattern = Pattern.compile(ARPPATTERNLINE);
        Matcher arpMatcher = null;
        try {
            File route = new File(LINUXARP);
            BufferedReader bf = new BufferedReader(new FileReader(route));
            String currentLine;
            if (route.canRead()) {
                while ((currentLine = bf.readLine()) != null) {
                    ArpTableRecord arpRecord = getArpRecordFromString(currentLine, arpPattern);
                   if (arpRecord != null ){
                       arpRecords.add(arpRecord);
                   }
                }

            } else {
                Logger.getLogger(GetIpList.class.getName()).error("Cannot read file " + LINUXARP);
            }
        } catch (IOException ex) {
            Logger.getLogger(GetIpList.class.getName()).error("Cannot get information from file " + LINUXARP);
        } catch (Exception ex) {
            Logger.getLogger(this.getClass()).warn(ex.getMessage());
        }
        
        return arpRecords;

    }
    
    
     private ArpTableRecord getArpRecordFromString(String line, Pattern routePattern) throws UnknownHostException, IllegalArgumentException, IllegalStateException {
        Matcher arpMatcher = routePattern.matcher(line);
        ArpTableRecord arpRecord = null;
        if (arpMatcher.matches()) {
            arpRecord = new ArpTableRecordImpl();
            arpRecord.setInetAddress((Inet4Address) Inet4Address.getByName(arpMatcher.group(1)));
            arpRecord.setHwType(Integer.decode(arpMatcher.group(6)));
            arpRecord.setFlag(Integer.decode(arpMatcher.group(7)));
            arpRecord.setHwAddress(getHwBytesFromString(arpMatcher.group(8)));
            arpRecord.setMask(getMaskFromString(arpMatcher.group(10)));
            arpRecord.setIfName(arpMatcher.group(11));
        }
        return arpRecord;
    }
     
     private byte[] getHwBytesFromString(String mac) throws IllegalArgumentException{
         byte[] macBytes = new byte[6];
         String[] macStrings = mac.split(":");
         if (macStrings.length != 6) {
             throw new IllegalArgumentException("Error: wrong format of mac address " + mac);
         } else {
             for (int i=0; i < 6; i++){
                 Integer hex = Integer.parseInt(macStrings[i], 16);
                 macBytes[i] = hex.byteValue();
             }
         }
         return macBytes;
     }
     
     private byte[] getMaskFromString(String mask) throws IllegalStateException{
         if (mask.equals("*")) {
             return null;
         } else {
             Logger.getLogger(this.getClass()).warn("Cannot process mask value " + mask + "\nYou should never see it!");
             throw new IllegalStateException("Cannot process mask value " + mask + "\nYou should never see it!");
         }
     }
}
