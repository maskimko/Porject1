/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.lib.routelibrary;

import java.net.Inet4Address;
import java.util.List;

/**
 *
 * @author maskimko
 */
public interface ArpTableInformation {
    
    public List<ArpTableRecord> getArpTable();
    public ArpTableRecord getArpRecordByIp(Inet4Address ip);
   
}
