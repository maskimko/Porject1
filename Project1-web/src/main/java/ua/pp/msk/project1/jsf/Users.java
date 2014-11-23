package ua.pp.msk.project1.jsf;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import ua.pp.msk.project1.entities.Role;

import ua.pp.msk.project1.entities.User;
import ua.pp.msk.project1.sessionbeans.UserFacade;

@ManagedBean(name="users")
@SessionScoped
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User current = null;
	@EJB
	private UserFacade userFacade;
	
        public Users() {
	}
        
        @PostConstruct
        public void pickUserUp(){
            String remoteUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
            current = userFacade.findByLogin(remoteUser);
            if (current != null){
                Logger.getLogger(this.getClass()).info("Setting current " + remoteUser + " initially selected");
            } else {
                Logger.getLogger(this.getClass()).warn("Something goes wrong!!! Cannot find logged in user " + remoteUser + " in database!\nIt should never happened!");
            }
            
        }
	public User getSelected(){
		return current;
	}
	
	public void setSelected(User selected){
		current = selected;
	}
	
	public List<User> getAllUsers(){
		return userFacade.findAll();
	}
	
	public boolean isSelectedEmpty(){
		return (current == null);
	}
        
        public boolean isAdmin(){
            boolean result = false;
            String remoteUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
            Logger.getLogger(this.getClass()).debug("Quering admin role of remoteUser: " + remoteUser);
            User foundUser = userFacade.findByLogin(remoteUser);
            Set<Role> roles = foundUser.getRoles();
            for ( Role currentRole : roles){
                if (currentRole.getName().equals("administrator")) {
                    result = true;
                    break;
                }
            }
            return result;
        }
	
}
