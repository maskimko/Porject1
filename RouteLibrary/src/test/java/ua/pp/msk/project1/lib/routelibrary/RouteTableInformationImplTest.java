/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.lib.routelibrary;

import ua.pp.msk.project1.lib.routelibrary.RouteTableLinuxRecord;
import ua.pp.msk.project1.lib.routelibrary.RouteTableInformationImpl;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maskimko
 */
public class RouteTableInformationImplTest {
    
    
    public RouteTableInformationImplTest() {
    }

  

//    /**
//     * Test of getRouteRecordFromString method, of class RouteTableInformationImpl.
//     */
//    @Test
//    public void testGetRouteRecordFromString1() throws Exception {
//        
//        System.out.println("getRouteRecordFromString");
//        String route1 = "virbr0	007AA8C0	00000000	0001	0	0	0	00FFFFFF	0	0	0 ";
//      
//        Pattern routePattern = Pattern.compile(RouteTableInformationImpl.ROUTEPATTERNLINE);
//        RouteTableInformationImpl instance = new RouteTableInformationImpl();
//        RouteTableLinuxRecord result1 = instance.getRouteRecordFromString(route1, routePattern);
//        assertNotNull(result1);
//     
//        
//    }
//    
//       @Test
//    public void testGetRouteRecordFromStringHeading() throws Exception {
//        
//        System.out.println("getRouteRecordFromString (Heading)");
//        String routeHeading = "Iface	Destination	Gateway 	Flags	RefCnt	Use	Metric	Mask		MTU	Window	IRTT  ";
//       
//        Pattern routePattern = Pattern.compile(RouteTableInformationImpl.ROUTEPATTERNLINE);
//        RouteTableInformationImpl instance = new RouteTableInformationImpl();
//       
//         RouteTableLinuxRecord resultHeading = instance.getRouteRecordFromString(routeHeading, routePattern);
//        assertNull(resultHeading);
//       
//        
//    }
//    
//       @Test
//    public void testGetRouteRecordFromString2() throws Exception {
//        
//        System.out.println("getRouteRecordFromString");
//        String route2 = "enp0s25	00000000	013316AC	0003	0	0	1024	00000000	0	0	0                                                                         ";
//        Pattern routePattern = Pattern.compile(RouteTableInformationImpl.ROUTEPATTERNLINE);
//        RouteTableInformationImpl instance = new RouteTableInformationImpl();
//          RouteTableLinuxRecord result2 = instance.getRouteRecordFromString(route2, routePattern);
//        assertNotNull(result2);
//      
//    }
//    
//       @Test
//    public void testGetRouteRecordFromString3() throws Exception {
//        
//        System.out.println("getRouteRecordFromString");
//        String route3 = "ppp0	010E800A	00000000	0005	0	0	0	FFFFFFFF	0	0	0    ";
//        Pattern routePattern = Pattern.compile(RouteTableInformationImpl.ROUTEPATTERNLINE);
//        RouteTableInformationImpl instance = new RouteTableInformationImpl();
//     
//         RouteTableLinuxRecord result3 = instance.getRouteRecordFromString(route3, routePattern);
//        assertNotNull(result3);
//      
//        
//    }
//       @Test
//    public void testGetRouteRecordFromString4() throws Exception {
//        
//        System.out.println("getRouteRecordFromString");
//        String route4 = "ppp0	0010800A	00000000	0001	0	0	0	00FFFFFF	0	0	0      ";
//        Pattern routePattern = Pattern.compile(RouteTableInformationImpl.ROUTEPATTERNLINE);
//        RouteTableInformationImpl instance = new RouteTableInformationImpl();
//
//         RouteTableLinuxRecord result4 = instance.getRouteRecordFromString(route4, routePattern);
//        assertNotNull(result4);
//  
//        
//    }
//       @Test
//    public void testGetRouteRecordFromString5() throws Exception {
//        
//        System.out.println("getRouteRecordFromString");
//       String route5 = "enp0s25	AF6A9F42	013316AC	0007	0	0	0	FFFFFFFF	0	0	0      ";
//        Pattern routePattern = Pattern.compile(RouteTableInformationImpl.ROUTEPATTERNLINE);
//        RouteTableInformationImpl instance = new RouteTableInformationImpl();
// 
//         RouteTableLinuxRecord result5 = instance.getRouteRecordFromString(route5, routePattern);
//        assertNotNull(result5);
//
//        
//    }
//       @Test
//    public void testGetRouteRecordFromString6() throws Exception {
//        
//        System.out.println("getRouteRecordFromString");
//        String route6 = "enp0s25	243011AC	013316AC	0007	0	0	1	FFFFFFFF	0	0	0     ";
//        Pattern routePattern = Pattern.compile(RouteTableInformationImpl.ROUTEPATTERNLINE);
//        RouteTableInformationImpl instance = new RouteTableInformationImpl();
//
//         RouteTableLinuxRecord result6 = instance.getRouteRecordFromString(route6, routePattern);
//        assertNotNull(result6);
//       
//        
//    }
//       @Test
//    public void testGetRouteRecordFromString7() throws Exception {
//        
//        System.out.println("getRouteRecordFromString");
//        String route7 = "enp0s25	003316AC	00000000	0001	0	0	0	00FFFFFF	0	0	0       ";
//        Pattern routePattern = Pattern.compile(RouteTableInformationImpl.ROUTEPATTERNLINE);
//        RouteTableInformationImpl instance = new RouteTableInformationImpl();
//
//        RouteTableLinuxRecord result7 = instance.getRouteRecordFromString(route7, routePattern);
//        assertNotNull(result7);
//  
//        
//    }
//       @Test
//    public void testGetRouteRecordFromString8() throws Exception {
//        
//        System.out.println("getRouteRecordFromString");
//      String route8 = "ppp0	00001EAC	00000000	0001	0	0	0	0000FFFF	0	0	0      ";
//        Pattern routePattern = Pattern.compile(RouteTableInformationImpl.ROUTEPATTERNLINE);
//        RouteTableInformationImpl instance = new RouteTableInformationImpl();
//      
//         RouteTableLinuxRecord result8 = instance.getRouteRecordFromString(route8, routePattern);
//        assertNotNull(result8);
//
//        
//    }   @Test
//    public void testGetRouteRecordFromString9() throws Exception {
//        
//        System.out.println("getRouteRecordFromString");
//       String route9 = "virbr0	007CA8C0	00000000	0001	0	0	0	00FFFFFF	0	0	0";
//        Pattern routePattern = Pattern.compile(RouteTableInformationImpl.ROUTEPATTERNLINE);
//        RouteTableInformationImpl instance = new RouteTableInformationImpl();
//       
//        RouteTableLinuxRecord result9 = instance.getRouteRecordFromString(route9, routePattern);
//        assertNotNull(result9);
//        
//    }  
//    
//    
//    

    /**
     * Test of getRoutes method, of class RouteTableInformationImpl.
     */
    @Test
    public void testGetRoutes() {
        System.out.println("getRoutes");
        RouteTableInformationImpl instance = new RouteTableInformationImpl();
        List<RouteTableLinuxRecord> result = instance.getRoutes();
        assertTrue(result.size() > 0);
     
    }

}
