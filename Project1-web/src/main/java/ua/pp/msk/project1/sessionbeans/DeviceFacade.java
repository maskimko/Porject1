/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ua.pp.msk.project1.entities.Device;

/**
 *
 * @author maskimko
 */
@Stateless
public class DeviceFacade extends AbstractFacade<Device> {
    @PersistenceContext(unitName = "project1_test")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeviceFacade() {
        super(Device.class);
    }
    
}
