/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.lib.routelibrary;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author maskimko
 */
public interface RouteTableInformation extends Serializable {

    public List<? extends RouteTableRecord> getRoutes();

    public RouteTableRecord getDefaultRoute();

   

}
