/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.ipgetter;

import java.io.Serializable;
import java.net.Inet4Address;

/**
 *
 * @author maskimko
 */
public interface ArpTableRecord extends Serializable {
    public Inet4Address getInetAddress();
    public String   getHwType();
    public String getHwAddress();
    public String getFlag();
    public String getMask();
    public String getIfName();
    
    public void setInetAddress(Inet4Address addr);
    public void setHwAddress(String mac);
    public void setHwType(String hwType);
    public void setFlag(String flag);
    public void setMask(String mask);
    public void setIfName(String ifName);
}
