/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.lib.routelibrary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

/**
 *
 * @author maskimko
 */
public class RouteTableInformationImpl implements RouteTableInformation {

    public static final String LINUXROUTE = "/proc/net/route";
    public static final String LINUXARP = "/proc/net/route";
    public static final String ROUTEPATTERNLINE = "^(\\w+)\\s+([0-9A-F]{8})\\s+([0-9A-F]{8})\\s+([0-9A-F]{4})\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+([0-9A-F]{8})\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s*";

    @Override
    public List<RouteTableLinuxRecord> getRoutes() {
        List<String> routeLines = new ArrayList<String>();
        List<RouteTableLinuxRecord> routes = new ArrayList<RouteTableLinuxRecord>();
        Pattern routePattern = Pattern.compile(ROUTEPATTERNLINE);
        Matcher routeMatcher = null;
        File route = new File(LINUXROUTE);
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(route));
            String currentLine;
            if (route.canRead()) {
                while ((currentLine = bf.readLine()) != null) {
                    RouteTableLinuxRecord routeRecord = getRouteRecordFromString(currentLine, routePattern);
                   if (routeRecord != null) {
                       routes.add(routeRecord);
                   }
                }

            } else {
                Logger.getLogger(this.getClass()).error("Cannot read file " + LINUXROUTE);
            }
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).error("Cannot get information from file " + LINUXROUTE);
        }
        finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(RouteTableInformationImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return routes;

    }
/*
    In routing table ip addresses is in reverse order.
    */
    private byte[] getByteArray(String input) throws IllegalArgumentException{
        byte[] byteArray = new byte[4];
        if (input.length() == 8) {
            for (int i = 0; i < 4; i++){
                String octet = input.substring(i * 2, (i+1) * 2 );
                Integer hex  = Integer.parseInt(octet, 16);
                byteArray[3-i] = hex.byteValue();
        }
        } else {
            throw new IllegalArgumentException("IP address String representation must contain 8 chars.");
        }
        return byteArray;
    }

    private RouteTableLinuxRecord getRouteRecordFromString(String line, Pattern routePattern) throws UnknownHostException {
        Matcher routeMatcher = routePattern.matcher(line);
        RouteTableLinuxRecord routeRecord = null;
        if (routeMatcher.matches()) {
            routeRecord = new RouteTableRecordImpl();
            routeRecord.setIfName(routeMatcher.group(1));
            routeRecord.setDestinationInetAddress((Inet4Address) Inet4Address.getByAddress(getByteArray(routeMatcher.group(2))));
            routeRecord.setGatewayInetAddress((Inet4Address) Inet4Address.getByAddress(getByteArray(routeMatcher.group(3))));
            routeRecord.setGenmaskInetAddress((Inet4Address) Inet4Address.getByAddress(getByteArray(routeMatcher.group(8))));
            routeRecord.setFlags(Integer.decode(routeMatcher.group(4)));
            routeRecord.setReferences(Integer.parseInt(routeMatcher.group(5)));
            routeRecord.setUses(Integer.parseInt(routeMatcher.group(6)));
            routeRecord.setMetric(Integer.parseInt(routeMatcher.group(7)));
            routeRecord.setMtu(Integer.parseInt(routeMatcher.group(9)));
            routeRecord.setWindow(Integer.parseInt(routeMatcher.group(10)));
            routeRecord.serIrtt(Integer.parseInt(routeMatcher.group(11)));
        }
        return routeRecord;
    }

    @Override
    public RouteTableRecord getDefaultRoute() {
        List<RouteTableLinuxRecord> routes = getRoutes();
        for (RouteTableRecord route : routes){
            try {
                if (route.getDestinationInetAddress().equals(Inet4Address.getByAddress(new byte[]{0,0,0,0}))){
                    return route;
                }
            } catch (UnknownHostException ex) {
                Logger.getLogger(RouteTableInformationImpl.class.getName()).error("Error: cannot compare ip addresses. You should never see it!");
            }
        }
        return null;
    }

    
    public String macToString(byte[] mac) {
     return Converter.macToString(mac);
    }

}
