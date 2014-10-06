/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.ipgetter;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.faces.bean.ManagedBean;
import org.apache.log4j.Logger;

/**
 *
 * @author maskimko
 */
@ManagedBean
public class GetIpList {
    
    public List<String> getIpAddresses(){
        List<String> ipAddresses = new ArrayList<String>();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface currentInterface = networkInterfaces.nextElement();
                if (currentInterface.isUp()) {
                    Enumeration<InetAddress> inetAddresses = currentInterface.getInetAddresses();
                    while (inetAddresses.hasMoreElements()){
                        InetAddress currentAddress = inetAddresses.nextElement();
                        
                        ipAddresses.add(currentAddress.getHostAddress());
                    }
                }
            }
        } catch (SocketException ex) {
            Logger.getLogger(GetIpList.class.getName()).warn("Cannot get interfaces " + ex.getMessage());
        }
        
        return ipAddresses;
    }
    
    public int getQuantityOfAddresses(){
    return getIpAddresses().size();
    }
    
    public List<String> getRoutingTable(){
        List<String> routes = new ArrayList<String>();
       RouteTableInformation rti = new RouteTableInformationImpl();
        List<? extends RouteTableRecord> routeRecords = rti.getRoutes();
       for (RouteTableRecord rr : routeRecords){
           StringBuilder sb = new StringBuilder(rr.getIfName());
           sb.append(" ").append(rr.getDestinationInetAddress());
           routes.add(sb.toString());
       }
        return routes;
    }
    
    public Inet4Address getGatewayIp(){
        RouteTableInformation rti =new RouteTableInformationImpl();
        RouteTableRecord defaultRoute = rti.getDefaultRoute();
        return defaultRoute.getGatewayInetAddress();
    }
    
    public byte[] getGatewayMac(){
        ArpTableInformation ati = new ArpTableInformationImpl();
        ArpTableRecord arpRecordByIp = ati.getArpRecordByIp(getGatewayIp());
        return arpRecordByIp.getHwAddress();
    }
    
    public String getGatewayMacString(){
        StringBuilder sb = new StringBuilder();
        for (byte b : getGatewayMac()){
            sb.append(Integer.toHexString((b < 0) ? b+128 : b));
            
        }
        return sb.toString();
    }
    
}
