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
import javax.xml.bind.DatatypeConverter;
import org.apache.log4j.Logger;

/**
 *
 * @author maskimko
 */
public class RouteTableInformationImpl implements RouteTableInformation {

    public static final String LINUXROUTE = "/proc/net/route";
    public static final String LINUXARP = "/proc/net/route";
    public static final String ROUTEPATTERNLINE = "(\\w+\\d+)\\s+([0-9A-F]{8})\\s+([0-9A-F]{8})\\s+([0-9A-F]{4})\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+([0-9A-F]{8})\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)";

    @Override
    public List<RouteTableLinuxRecord> getRoutes() {
        List<String> routeLines = new ArrayList<String>();
        List<RouteTableLinuxRecord> routes = new ArrayList<RouteTableLinuxRecord>();
        Pattern routePattern = Pattern.compile(ROUTEPATTERNLINE);
        Matcher routeMatcher = null;
        try {
            File route = new File(LINUXROUTE);
            BufferedReader bf = new BufferedReader(new FileReader(route));
            String currentLine;
            if (route.canRead()) {
                while ((currentLine = bf.readLine()) != null) {

                   routes.add(getRouteRecordFromString(currentLine, routePattern));

                }

            } else {
                Logger.getLogger(GetIpList.class.getName()).error("Cannot read file " + LINUXROUTE);
            }
        } catch (IOException ex) {
            Logger.getLogger(GetIpList.class.getName()).error("Cannot get information from file " + LINUXROUTE);
        }
        return routes;

    }

    private byte[] getByteArray(String input) {
        byte[] byteArray;
        byteArray = DatatypeConverter.parseHexBinary(input);
        return byteArray;
    }

    public RouteTableLinuxRecord getRouteRecordFromString(String line, Pattern routePattern) throws UnknownHostException {
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

}
