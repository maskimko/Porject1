/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.jsf;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author maskimko
 */
@ManagedBean
public class MarkersView implements Serializable {
    
    private MapModel simpleModel;
  
    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();
          
        //Shared coordinates
        LatLng coord1 = new LatLng(50.423612, 30.477896);
        LatLng edemsHouse = new LatLng(50.431691, 30.431006);
          
        //Basic marker
        simpleModel.addOverlay(new Marker(coord1, "Maks'es House"));
        simpleModel.addOverlay(new Marker(edemsHouse, "Edem's House"));
        
    }
  
    public MapModel getSimpleModel() {
        return simpleModel;
    }
}