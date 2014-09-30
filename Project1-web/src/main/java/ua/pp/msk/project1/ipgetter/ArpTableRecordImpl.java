/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.ipgetter;

import java.net.Inet4Address;

/**
 *
 * @author maskimko
 */
public class ArpTableRecordImpl {
    private Inet4Address ip;
    private String hwType;
    private String hwAddress;
    private String flag;
    private String mask;
    private String ifName;
    
    static final long serialVersionUID = 1L;
    
    public Inet4Address getInetAddress(){
        return ip;
    }
    public String   getHwType(){
        return hwType;
    }
    public String getHwAddress(){
        return hwAddress;
    }
    
    public String getFlag(){
        return flag;
    }
    public String getMask(){
        return mask;
    }
    public String getIfName(){
        return ifName;
    }
    
    public void setInetAddress(Inet4Address addr){
        this.ip = addr;
    }
    public void setHwAddress(String hwAddress){
        this.hwAddress = hwAddress;
    }
    public void setHwType(String hwType){
        this.hwType = hwType;
    }
    public void setFlag(String flag){
        this.flag = flag;
    }
    public void setMask(String mask){
        this.mask = mask;
    }
    public void setIfName(String ifName){
        this.ifName = ifName;
    }
}
