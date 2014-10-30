package ua.pp.msk.project1.jsf;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ua.pp.msk.project1.entities.User;
import ua.pp.msk.project1.sessionbeans.UserFacade;

@ManagedBean(name="users")
@SessionScoped
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Users() {
	}
	
	private User current = null;
	@EJB
	private UserFacade userFacade;
	
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
	
}
