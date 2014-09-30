/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.ipgetter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author maskimko
 */
public class RouteTableInformationImpl implements RouteTableInformation{

    
    @Override
    public List<RouteTableRecord> getRoutes() {

        List<RouteTableRecord> routes = new ArrayList<RouteTableRecord>();
        try {
            
            Process exec = Runtime.getRuntime().exec("route -n");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            String routeLine = null;
            do {
                routeLine = bufferedReader.readLine();
                String[] routeFields =routeLine.split("\\s*");
                
            } while (routeLine != null);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(GetIpList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return routes;
 
    }
    
    private RouteTableRecord getRecord(String[] fields) throws UnknownHostException{
        RouteTableRecord record = new RouteTableRecordImpl();
        record.setDestinationInetAddress((Inet4Address) InetAddress.getByName(fields[0]));
        record.setGatewayInetAddress(InetAddress.getByName(fields[1]));
        
    }
    

}
