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
public class RouteTableRecordImpl implements RouteTableRecord{

    private Inet4Address destination;
    private Inet4Address gateway;
    private Inet4Address mask;
    private String flags;
    private String ifName;
    private int metric;
    private int uses;
    private int references;
    
    static final long serialVersionUID = 1L;
    
    @Override
    public Inet4Address getDestinationInetAddress() {
        return destination;
    }

    @Override
    public Inet4Address getGatewayInetAddress() {
        return gateway;
    }

    @Override
    public Inet4Address getGenmaskInetAddress() {
        return mask;
    }

    @Override
    public String getFlags() {
        return flags;
    }

    @Override
    public int getMetric() {
        return metric;
    }

    @Override
    public int getReferences() {
        return references;
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public String getIfName() {
        return ifName;
    }

    @Override
    public void setDestinationInetAddress(Inet4Address addr) {
        this.destination = addr;
    }

    @Override
    public void setGatewayInetAddress(Inet4Address addr) {
        this.gateway = addr;
    }

    @Override
    public void setGenmaskInetAddress(Inet4Address addr) {
        this.mask = addr;
    }

    @Override
    public void setFlags(String flags) {
        this.flags = flags;
                
    }

    @Override
    public void setMetric(int metric) {
        this.metric = metric;
    }

    @Override
    public void setReferences(int refs) {
        this.references = refs;
    }

    @Override
    public void setUses(int uses) {
        this.uses = uses;
    }

    @Override
    public void setIfName(String ifName) {
        this.ifName = ifName;
    }
    
}
