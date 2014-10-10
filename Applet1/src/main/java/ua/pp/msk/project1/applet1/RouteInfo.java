/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.applet1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
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

    private final JTextField arpField;
    private final JTextField routeField;
    private final JTextField defaultGatewayIpField;
    private final JTextField defaultGatewayMacField;
    private final JTextField defaultGatewayIfField;
    private DefaultTableModel routeModel;
    private DefaultTableModel arpModel;

    public RouteInfo() {
        super(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        //Constructing bottom panel
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel defaultGatewayIpLabel = new JLabel("Gateway IP: ");
        JLabel defaultGatewayMacLabel = new JLabel("Gateway MAC: ");
        JLabel defaultGatewayIfLabel = new JLabel("Gateway Inteface: ");
        defaultGatewayIfField = new JTextField();
        defaultGatewayIpField = new JTextField();
        defaultGatewayMacField = new JTextField();
        bottomPanel.add(defaultGatewayIpLabel);
        bottomPanel.add(defaultGatewayIpField);
        bottomPanel.add(defaultGatewayMacLabel);
        bottomPanel.add(defaultGatewayMacField);
        bottomPanel.add(defaultGatewayIfLabel);
        bottomPanel.add(defaultGatewayIfField);

        JLabel routeLabel = new JLabel("Number of routes: ");
        routeField = new JTextField(4);
        routeField.setEditable(false);
        JLabel arpLabel = new JLabel("Number of arp records: ");
        arpField = new JTextField(4);
        arpField.setEditable(false);
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
        JLabel routeHeading = new JLabel("Routes");

        JLabel arpHeading = new JLabel("ARP");

        topPanel.add(routeLabel);
        topPanel.add(routeField);
        topPanel.add(arpLabel);
        topPanel.add(arpField);
        infoPanel.add(routeHeading);
        JTable routeTable = createRouteTable();
        infoPanel.add(new JScrollPane(routeTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        infoPanel.add(arpHeading);
        JTable arpTable = createArpTable();
        infoPanel.add(new JScrollPane(arpTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        add(topPanel, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

    }

    private JTable createRouteTable() {
        int[] columnWidth = new int[]{60, 80, 80, 20, 25, 15, 25, 80};
        String[] colnames = new String[]{"Interface", "Destination", "Gateway", "Flags", "RefCnt", "Use", "Metric", "Mask"};
        routeModel = new DefaultTableModel(null, colnames);

        JTable table = new JTable(routeModel);
        int width = this.getSize().width;
        table.setPreferredScrollableViewportSize(new Dimension(width, 100));
        TableColumn column = null;
        for (int i = 0; i < columnWidth.length; i++) {
            column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidth[i]);
        }
        return table;
    }

    private JTable createArpTable() {
        int[] columnWidth = new int[]{80, 40, 30, 100, 25, 60};
        String[] colnames = new String[]{"IP address", "HW type", "Flags", "HW address", "Mask", "Device"};
        arpModel = new DefaultTableModel(colnames, 0);
        JTable table = new JTable(arpModel);
        int width = this.getSize().width;
        table.setPreferredScrollableViewportSize(new Dimension(width, 100));
        TableColumn column = null;
        for (int i = 0; i < columnWidth.length; i++) {
            column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidth[i]);
        }
        return table;
    }

    public void setRouteNumber(int ammount) {
        routeField.setText("" + ammount);
    }

    public void setArpNumber(int ammount) {
        arpField.setText("" + ammount);
    }

    public void addArp(ArpTableRecord atr) {
//        String result = String.format("%1$-20s\t%2$-10s\t%3$-10s\t%4$-20s\t%5$-10s\t%6$-12s\n",
//                atr.getInetAddress().toString().replaceFirst("/", ""),
//                atr.getHwType(),
//                atr.getFlag(),
//                Converter.macToString(atr.getHwAddress()),
//                Arrays.toString(atr.getMask()),
//                atr.getIfName());
//        arpArea.append(result);
        arpModel.addRow(arpTableRecordToArray(atr));
    }

    public void addRoute(RouteTableRecord rtr) {
//        String result = String.format("%1$-20s\t%2$-20s\t%3$-20s\t%4$-12s\n",
//                rtr.getDestinationInetAddress().toString().replaceFirst("/", ""),
//                rtr.getGatewayInetAddress().toString().replaceFirst("/", ""),
//                rtr.getGenmaskInetAddress().toString().replaceFirst("/", ""),
//                rtr.getIfName());
        //routeArea.append(result);
        routeModel.addRow(routeTableRecordToArray(rtr));
    }

    private Object[] routeTableRecordToArray(RouteTableRecord rtr) {
        Object[] fields = new Object[8];
        fields[0] = rtr.getIfName();
        fields[1] = rtr.getDestinationInetAddress().toString().replaceFirst("/", "");
        fields[2] = rtr.getGatewayInetAddress().toString().replaceFirst("/", "");
        fields[3] = Integer.toHexString(rtr.getFlags());
        fields[4] = rtr.getReferences();
        fields[5] = rtr.getUses();
        fields[6] = rtr.getMetric();
        fields[7] = rtr.getGenmaskInetAddress().toString().replaceFirst("/", "");
        return fields;
    }

    private Object[] arpTableRecordToArray(ArpTableRecord atr) {
        Object[] fields = new Object[6];
        fields[5] = atr.getIfName();
        fields[0] = atr.getInetAddress().toString().replaceFirst("/", "");
        fields[1] = Integer.toHexString(atr.getHwType());
        fields[2] = Integer.toHexString(atr.getFlag());
        fields[3] = Converter.macToString(atr.getHwAddress());
        fields[4] = Arrays.toString(atr.getMask());
        return fields;
    }

    // TODO overwrite start(), stop() and destroy() methods
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void setDefaultGatewayIpField(RouteTableRecord routeTableRecord) {
        defaultGatewayIpField.setText(routeTableRecord.getGatewayInetAddress().toString().replaceFirst("/", ""));
    }

    private void setDefaultGatewayIfField(RouteTableRecord routeTableRecord) {
        defaultGatewayIfField.setText(routeTableRecord.getIfName());
    }

    private void setDefaultGatewayMacField(String mac) {
        defaultGatewayMacField.setText(mac);
    }

    protected static void fillTheContent(RouteInfo routeInfo) {
        ArpTableInformation ati = new ArpTableInformationImpl();
        List<ArpTableRecord> arpTable = ati.getArpTable();
        routeInfo.setArpNumber(arpTable.size());
        for (ArpTableRecord atr : arpTable) {
            routeInfo.addArp(atr);
        }

        RouteTableInformation rti = new RouteTableInformationImpl();
        List<? extends RouteTableRecord> routes = rti.getRoutes();
        routeInfo.setRouteNumber(routes.size());
        for (RouteTableRecord rtr : routes) {
            routeInfo.addRoute(rtr);
        }

        RouteTableRecord defaultRoute = rti.getDefaultRoute();
        routeInfo.setDefaultGatewayIpField(defaultRoute);
        routeInfo.setDefaultGatewayIfField(defaultRoute);
        Inet4Address gatewayInetAddress = defaultRoute.getGatewayInetAddress();
        byte[] hwAddress = ati.getArpRecordByIp(gatewayInetAddress).getHwAddress();
        if (hwAddress == null) {
            routeInfo.setDefaultGatewayMacField("empty");
        } else {
            routeInfo.setDefaultGatewayMacField(Converter.macToString(hwAddress));
        }

    }

    public static void createAndShowGui() {
        JFrame frame = new JFrame("Routes and arp's");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RouteInfo routeInfo = new RouteInfo();
        routeInfo.setOpaque(true);

        fillTheContent(routeInfo);

        frame.setContentPane(routeInfo);
        frame.pack();
        frame.setVisible(true);
    }
}
