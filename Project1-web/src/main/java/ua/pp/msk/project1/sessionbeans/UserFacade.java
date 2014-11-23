/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.sessionbeans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import org.apache.log4j.Logger;
import ua.pp.msk.project1.entities.User;

/**
 *
 * @author maskimko
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {
    @PersistenceContext(unitName = "project1")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    public User findByLogin(String name){
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        ParameterExpression<String> parameterExpression = criteriaBuilder.parameter(String.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("login"), parameterExpression));
        TypedQuery<User> typedQuery = getEntityManager().createQuery(criteriaQuery);
        typedQuery.setParameter(parameterExpression, name);
        List<User> resultList = typedQuery.getResultList();
        if (resultList.size() > 1) {
            Logger.getLogger(this.getClass()).warn("Found " + resultList.size() + " users with login " + name + " It should never happen!");
            Logger.getLogger(this.getClass()).warn("Anyway will return first user: " + resultList.get(0).toString());
        }else 
        if (resultList.isEmpty()) {
            Logger.getLogger(this.getClass()).warn("Cannot find user with login: " + name);
            return null;
        }
        return resultList.get(0);
    }
    
}
