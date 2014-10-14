package ua.pp.msk.project1.jsfclasses;

import ua.pp.msk.project1.entities.DeviceLocation;
import ua.pp.msk.project1.jsfclasses.util.JsfUtil;
import ua.pp.msk.project1.jsfclasses.util.JsfUtil.PersistAction;
import ua.pp.msk.project1.sessionbeans.DeviceLocationFacade;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@ManagedBean(name="deviceLocationController")
@SessionScoped
public class DeviceLocationController implements Serializable {


    @EJB private ua.pp.msk.project1.sessionbeans.DeviceLocationFacade ejbFacade;
    private List<DeviceLocation> items = null;
    private DeviceLocation selected;

    public DeviceLocationController() {
    }

    public DeviceLocation getSelected() {
        return selected;
    }

    public void setSelected(DeviceLocation selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setId(new ua.pp.msk.project1.entities.DeviceLocationPK());
    }

    private DeviceLocationFacade getFacade() {
        return ejbFacade;
    }

    public DeviceLocation prepareCreate() {
        selected = new DeviceLocation();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DeviceLocationCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DeviceLocationUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DeviceLocationDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<DeviceLocation> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }


    public List<DeviceLocation> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<DeviceLocation> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass=DeviceLocation.class)
    public static class DeviceLocationControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DeviceLocationController controller = (DeviceLocationController)facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "deviceLocationController");
            return controller.getFacade().find(getKey(value));
        }

        ua.pp.msk.project1.entities.DeviceLocationPK getKey(String value) {
            ua.pp.msk.project1.entities.DeviceLocationPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new ua.pp.msk.project1.entities.DeviceLocationPK();
            key.setDeviceId(Integer.valueOf(values[0]));
            java.sql.Date date = new Date(Long.parseLong(values[1]));
            key.setTimestamp(date);
            return key;
        }

        String getStringKey(ua.pp.msk.project1.entities.DeviceLocationPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getDeviceId());
            sb.append(SEPARATOR);
            sb.append(value.getTimestamp());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof DeviceLocation) {
                DeviceLocation o = (DeviceLocation) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), DeviceLocation.class.getName()});
                return null;
            }
        }

    }

}
