/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author maskimko
 */
@Entity
public class ApInterface implements Serializable {

    public static final Long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ip_address")
    /**
     * White internet ip address
     */
    public Integer ipAddress;
    @Id
    @NotNull
    @Column(name = "mac_address")
    /**
     * This is an interface id
     */
    public Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ap_location")
    public ApLocation apLocation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(Integer ipAddress) {
        this.ipAddress = ipAddress;
    }

    public ApLocation getApLocation() {
        return apLocation;
    }

    public void setApLocation(ApLocation apLocation) {
        this.apLocation = apLocation;
    }

   

}
