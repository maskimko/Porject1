/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.webservices;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;
import ua.pp.msk.project1.entities.DeviceLocation;
import ua.pp.msk.project1.entities.DeviceLocationPK;

/**
 *
 * @author maskimko
 */
@Stateless
@Path("ua.pp.msk.project1.entities.devicelocation")
public class DeviceLocationFacadeREST extends AbstractFacade<DeviceLocation> {
    @PersistenceContext(unitName = "project1_test")
    private EntityManager em;

    private DeviceLocationPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;deviceId=deviceIdValue;timestamp=timestampValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ua.pp.msk.project1.entities.DeviceLocationPK key = new ua.pp.msk.project1.entities.DeviceLocationPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> deviceId = map.get("deviceId");
        if (deviceId != null && !deviceId.isEmpty()) {
            key.setDeviceId(new java.lang.Integer(deviceId.get(0)));
        }
        java.util.List<String> timestamp = map.get("timestamp");
        if (timestamp != null && !timestamp.isEmpty()) {
            key.setTimestamp(new java.util.Date(timestamp.get(0)));
        }
        return key;
    }

    public DeviceLocationFacadeREST() {
        super(DeviceLocation.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(DeviceLocation entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, DeviceLocation entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        ua.pp.msk.project1.entities.DeviceLocationPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public DeviceLocation find(@PathParam("id") PathSegment id) {
        ua.pp.msk.project1.entities.DeviceLocationPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<DeviceLocation> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<DeviceLocation> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
