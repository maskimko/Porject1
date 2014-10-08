/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.lib.routelibrary;

/**
 *
 * @author maskimko
 */
public interface RouteTableLinuxRecord extends RouteTableRecord {
    
    
    public int getMtu();
    public int getWindow();
    public int getIrtt();
    public void setMtu(int mtu);
    public void setWindow(int window);
      public void serIrtt(int irtt);
}
