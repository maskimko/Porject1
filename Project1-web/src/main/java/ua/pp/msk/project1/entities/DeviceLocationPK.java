/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author maskimko
 */
@Embeddable
public class DeviceLocationPK implements Serializable {
    public static final long serialVersionUID = 1L;
    @Basic
    @Column(name="device_id")
    private Integer deviceId;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="timestamp")
    private Date timestamp;
    
    public DeviceLocationPK() {}
    public DeviceLocationPK(Integer deviceId, Date timestamp){
        this.timestamp = timestamp;
        this.deviceId = deviceId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.deviceId != null ? this.deviceId.hashCode() : 0);
        hash = 13 * hash + (this.timestamp != null ? this.timestamp.hashCode() : 0);
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
        final DeviceLocationPK other = (DeviceLocationPK) obj;
        if (this.deviceId != other.deviceId && (this.deviceId == null || !this.deviceId.equals(other.deviceId))) {
            return false;
        }
        if (this.timestamp != other.timestamp && (this.timestamp == null || !this.timestamp.equals(other.timestamp))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return deviceId.toString() +" at "+ timestamp.toString();
    }
}
