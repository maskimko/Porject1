/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ua.pp.msk.project1.ipgetter.Entitytest;

/**
 *
 * @author maskimko
 */
@Stateless
public class EntitytestFacade extends AbstractFacade<Entitytest> {
    @PersistenceContext(unitName = "ua.pp.msk.project1_Project1-web_war_0.01PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntitytestFacade() {
        super(Entitytest.class);
    }
    
}
