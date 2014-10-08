/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.applet1;

import java.util.List;
import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import ua.pp.msk.project1.lib.routelibrary.RouteTableInformation;
import ua.pp.msk.project1.lib.routelibrary.RouteTableInformationImpl;
import ua.pp.msk.project1.lib.routelibrary.RouteTableRecord;

/**
 *
 * @author maskimko
 */
public class Applet1 extends JApplet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    @Override
    public void init() {
        // TODO start asynchronous download of heavy resources
         try {
            SwingUtilities.invokeAndWait(new Runnable() {

                @Override
                public void run() {
                   createGui();
                }
            });
        } catch (Exception ex) {
            System.err.println("createGUI didn't complete successfully");
        }
    }

    public static void main(String[] args) {
       // SomePanel.createAndShowGui();
        RouteInfo.createAndShowGui();
    }
        
    public void createGui(){
//        SomePanel sp = new SomePanel();
//        sp.setOpaque(true);
//        setContentPane(sp);
//        setVisible(true);
        RouteInfo routeInfo = new RouteInfo();
        
         RouteTableInformation rti = new RouteTableInformationImpl();
        List<? extends RouteTableRecord> routes = rti.getRoutes();
        routeInfo.setRouteNumber(routes.size());
        for (RouteTableRecord rtr : routes) {
            routeInfo.addRoute(rtr);
        }
        
        routeInfo.setOpaque(true);
        setContentPane(routeInfo);
        setVisible(true);
        
    }
}
