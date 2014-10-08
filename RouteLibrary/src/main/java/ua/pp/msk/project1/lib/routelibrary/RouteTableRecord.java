/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.lib.routelibrary;

import java.io.Serializable;
import java.net.Inet4Address;

/**
 *
 * @author maskimko
 */
public interface RouteTableRecord extends Serializable{
    public Inet4Address getDestinationInetAddress();
    public Inet4Address getGatewayInetAddress();
    public Inet4Address getGenmaskInetAddress();
    public int getFlags();
    public int getMetric();
    public int getReferences();
    public int getUses(); 
    public String getIfName();
    public void setDestinationInetAddress(Inet4Address addr);
    public void setGatewayInetAddress(Inet4Address addr);
    public void setGenmaskInetAddress(Inet4Address addr);
    public void setFlags(int flags);
    public void setMetric(int metric);
    public void setReferences(int refs);
    public void setUses(int uses); 
    public void setIfName(String ifName);
}
