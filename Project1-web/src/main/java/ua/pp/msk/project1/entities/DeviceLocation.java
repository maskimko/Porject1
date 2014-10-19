/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maskimko
 */
@Entity
@XmlRootElement
public class DeviceLocation implements Serializable {

   
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private DeviceLocationPK id;
    @Min(value = -90L)
    @Max(value = 90L)
    @Column(name = "latitude")
    @NotNull
    private Long latitude;
    @Min(value = -180L)
    @Max(value = 180L)
    @Column(name = "longitude")
    @NotNull
    private Long longitude;
    @NotNull
    @Column(name = "accuracy")
    private Integer accuracy;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_id", insertable = false, updatable = false )
    private Device device;

    public DeviceLocationPK getId() {
        return id;
    }

    public void setTime(String dateString) {
        Date parsedDate = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/mm/yyyy");
        try {
            parsedDate = dateFormat.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(DeviceLocation.class.getName()).log(Level.SEVERE, null, ex);
        }
        getId().setTimestamp(parsedDate);
    }
    
    public String getTime(){
        Date parsedDate = getId().getTimestamp();
        if (parsedDate == null) { return ""; }
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/mm/yyyy");
        return dateFormat.format(parsedDate, null, null).toString();
    }

    public void setId(DeviceLocationPK id) {
        this.id = id;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 29 * hash + (this.latitude != null ? this.latitude.hashCode() : 0);
        hash = 29 * hash + (this.longitude != null ? this.longitude.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DeviceLocation other = (DeviceLocation) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.latitude != other.latitude && (this.latitude == null || !this.latitude.equals(other.latitude))) {
            return false;
        }
        if (this.longitude != other.longitude && (this.longitude == null || !this.longitude.equals(other.longitude))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.pp.msk.project1.entities.DeviceLocation[ id=" + id + " ]";
    }

}
