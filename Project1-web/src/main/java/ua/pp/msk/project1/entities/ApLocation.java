/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author maskimko
 */
@Entity
public class ApLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Basic(optional = false)
    @Min(value = 0x0L)
    @Max(value = 0xffffffffffffL)
    @NotNull
    @Column(name = "mac_address")
    private Long macaddr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String ssid;
    @Basic(optional = false)
    @Min(value = -90L)
    @Max(value = 90L)
    @Column(name = "latitude")
    @NotNull
    private Long latitude;
    @Basic(optional = false)
    @Min(value = -180L)
    @Max(value = 180L)
    @Column(name = "longitude")
    @NotNull
    private Long longitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accuracy")
    private Integer accuracy;
    @Basic(optional = false)
    @Min(value = 0x0)
    @Max(value = 0xffffffff)
    @NotNull
    @Column(name = "ip_address")
    private Integer ipAddr;
    @Basic
    @Column(name = "popularity")
    private Integer popularity;
    @OneToMany(mappedBy = "apId")
    private List<ApInterface> interfaces;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getMacaddr() {
        return macaddr;
    }

    public void setMacaddr(Long macaddr) {
        this.macaddr = macaddr;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
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

    public Integer getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(Integer ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public List<ApInterface> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(List<ApInterface> interfaces) {
        this.interfaces = interfaces;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.macaddr != null ? this.macaddr.hashCode() : 0);
        hash = 97 * hash + (this.ssid != null ? this.ssid.hashCode() : 0);
        hash = 97 * hash + (this.latitude != null ? this.latitude.hashCode() : 0);
        hash = 97 * hash + (this.longitude != null ? this.longitude.hashCode() : 0);
        hash = 97 * hash + (this.ipAddr != null ? this.ipAddr.hashCode() : 0);
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
        final ApLocation other = (ApLocation) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.macaddr != other.macaddr && (this.macaddr == null || !this.macaddr.equals(other.macaddr))) {
            return false;
        }
        if ((this.ssid == null) ? (other.ssid != null) : !this.ssid.equals(other.ssid)) {
            return false;
        }
        if (this.latitude != other.latitude && (this.latitude == null || !this.latitude.equals(other.latitude))) {
            return false;
        }
        if (this.longitude != other.longitude && (this.longitude == null || !this.longitude.equals(other.longitude))) {
            return false;
        }
        if (this.ipAddr != other.ipAddr && (this.ipAddr == null || !this.ipAddr.equals(other.ipAddr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.pp.msk.project1.entities.NewEntity[ id=" + id + " ]";
    }

}
