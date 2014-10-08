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
public class RouteTableRecordImpl implements RouteTableLinuxRecord{

    private Inet4Address destination;
    private Inet4Address gateway;
    private Inet4Address mask;
    private int flags;
    private String ifName;
    private int metric;
    private int uses;
    private int references;
    private int mtu;
    private int window;
    private int irtt;
    
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
    public int getFlags() {
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
    public void setFlags(int flags) {
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

    @Override
    public int getMtu() {
        return mtu;
    }

    @Override
    public int getWindow() {
        return window;
    }

    @Override
    public int getIrtt() {
        return irtt;
    }

    @Override
    public void setMtu(int mtu) {
        this.mtu = mtu;
    }

    @Override
    public void setWindow(int window) {
        this.window = window;
    }

    @Override
    public void serIrtt(int irtt) {
        this.irtt = irtt;
    }
    
}
