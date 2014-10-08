/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.lib.routelibrary;

import java.net.Inet4Address;

/**
 *
 * @author maskimko
 */
public class ArpTableRecordImpl implements ArpTableRecord{
    private Inet4Address ip;
    private int hwType;
    private byte[] hwAddress;
    private int flag;
    private byte[] mask;
    private String ifName;
    
    static final long serialVersionUID = 1L;
    
    public Inet4Address getInetAddress(){
        return ip;
    }
    public int   getHwType(){
        return hwType;
    }
    public byte[] getHwAddress(){
        return hwAddress;
    }
    
    public int getFlag(){
        return flag;
    }
    public byte[] getMask(){
        return mask;
    }
    public String getIfName(){
        return ifName;
    }
    
    public void setInetAddress(Inet4Address addr){
        this.ip = addr;
    }
    public void setHwAddress(byte[] hwAddress){
        this.hwAddress = hwAddress;
    }
    public void setHwType(int hwType){
        this.hwType = hwType;
    }
    public void setFlag(int flag){
        this.flag = flag;
    }
    public void setMask(byte[] mask){
        this.mask = mask;
    }
    public void setIfName(String ifName){
        this.ifName = ifName;
    }
}
