/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.applet1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import ua.pp.msk.project1.lib.routelibrary.ArpTableInformation;
import ua.pp.msk.project1.lib.routelibrary.ArpTableInformationImpl;
import ua.pp.msk.project1.lib.routelibrary.ArpTableRecord;
import ua.pp.msk.project1.lib.routelibrary.Converter;
import ua.pp.msk.project1.lib.routelibrary.RouteTableInformation;
import ua.pp.msk.project1.lib.routelibrary.RouteTableInformationImpl;
import ua.pp.msk.project1.lib.routelibrary.RouteTableRecord;

/**
 *
 * @author maskimko
 */
public class RouteInfo extends JPanel implements ActionListener {

    private final JTextArea routeArea;
    private final JTextField arpField;
    private final JTextField routeField;
    private final JTextArea arpArea;

    public RouteInfo() {
        super(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel routeLabel = new JLabel("Number of routes: ");
        routeField = new JTextField(4);
        routeField.setEditable(false);
        JLabel arpLabel = new JLabel("Number of arp records: ");
        arpField = new JTextField(4);
        arpField.setEditable(false);
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
        JLabel routeHeading = new JLabel("Routes");
        routeArea = new JTextArea();
        JLabel arpHeading = new JLabel("ARP");
        arpArea = new JTextArea();
        topPanel.add(routeLabel);
        topPanel.add(routeField);
        topPanel.add(arpLabel);
        topPanel.add(arpField);
        infoPanel.add(routeHeading);
        infoPanel.add(routeArea);
        infoPanel.add(arpHeading);
        infoPanel.add(arpArea);
        add(topPanel, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.CENTER);

    }

  public void setRouteNumber(int ammount){
      routeField.setText(""+ammount);
  }
    public void setArpNumber(int ammount) {
        arpField.setText(""+ammount);
    }
    

   public void addArp(ArpTableRecord atr){
       String result = String.format("%1$-20s\t%2$-10s\t%3$-10s\t%4$-20s\t%5$-10s\t%6$-12s\n", 
               atr.getInetAddress().toString().replaceFirst("/", ""),
               atr.getHwType(),
               atr.getFlag(),
               Converter.macToString(atr.getHwAddress()),
               Arrays.toString(atr.getMask()),
               atr.getIfName());
       arpArea.append(result);
   }

    public void addRoute(RouteTableRecord rtr) {
        String result = String.format("%1$-20s\t%2$-20s\t%3$-20s\t%4$-12s\n", 
                rtr.getDestinationInetAddress().toString().replaceFirst("/", ""), 
                rtr.getGatewayInetAddress().toString().replaceFirst("/", ""),
                rtr.getGenmaskInetAddress().toString().replaceFirst("/", ""),
                rtr.getIfName());
        routeArea.append(result);
    }

    // TODO overwrite start(), stop() and destroy() methods
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void createAndShowGui() {
        JFrame frame = new JFrame("Routes and arp's");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RouteInfo routeInfo = new RouteInfo();
        routeInfo.setOpaque(true);

        ArpTableInformation ati = new ArpTableInformationImpl();
        List<ArpTableRecord> arpTable = ati.getArpTable();
        routeInfo.setArpNumber(arpTable.size());
        for (ArpTableRecord atr: arpTable){
            routeInfo.addArp(atr);
        }
        
        RouteTableInformation rti = new RouteTableInformationImpl();
        List<? extends RouteTableRecord> routes = rti.getRoutes();
        routeInfo.setRouteNumber(routes.size());
        for (RouteTableRecord rtr : routes) {
            routeInfo.addRoute(rtr);
        }

        frame.setContentPane(routeInfo);
        frame.pack();
        frame.setVisible(true);
    }
}
