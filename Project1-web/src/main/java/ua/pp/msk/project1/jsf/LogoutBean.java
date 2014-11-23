/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author maskimko
 */
@ManagedBean(name = "logout")
@SessionScoped
public class LogoutBean {

    public boolean isLoggedIn() {
        String userName = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        boolean result = !(userName == null || userName.isEmpty());
        return result;
    }
    
    
}
