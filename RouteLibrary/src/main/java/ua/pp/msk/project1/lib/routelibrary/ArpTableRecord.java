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
public interface ArpTableRecord extends Serializable {
    public Inet4Address getInetAddress();
    public int   getHwType();
    public byte[] getHwAddress();
    public int getFlag();
    public byte[] getMask();
    public String getIfName();
    
    public void setInetAddress(Inet4Address addr);
    public void setHwAddress(byte[] mac);
    public void setHwType(int hwType);
    public void setFlag(int flag);
    public void setMask(byte[] mask);
    public void setIfName(String ifName);
}
