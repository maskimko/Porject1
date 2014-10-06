/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.ipgetter;

import java.util.List;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maskimko
 */
public class RouteTableInformationImplTest {
    
    
    public RouteTableInformationImplTest() {
    }

  

    /**
     * Test of getRouteRecordFromString method, of class RouteTableInformationImpl.
     */
    @Test
    public void testGetRouteRecordFromString() throws Exception {
        
        System.out.println("getRouteRecordFromString");
        String line = "virbr0	007AA8C0	00000000	0001	0	0	0	00FFFFFF	0	0	0 ";
         //Pattern routePattern = Pattern.compile("^(\\w+)\\s+");
        Pattern routePattern = Pattern.compile(RouteTableInformationImpl.ROUTEPATTERNLINE);
        RouteTableInformationImpl instance = new RouteTableInformationImpl();
        RouteTableLinuxRecord result = instance.getRouteRecordFromString(line, routePattern);
        assertNotNull(result);
        
    }
    
    

}
