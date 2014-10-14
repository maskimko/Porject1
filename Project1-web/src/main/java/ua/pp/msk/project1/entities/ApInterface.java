/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author maskimko
 */
@Embeddable
public class ApInterface implements Serializable {
    public static final Long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ip_address")
    /**
    * White internet ip address
    */
    public Integer ipAddress;
     @Basic(optional = false)
    @NotNull
    @Column(name = "mac_address")
    public Long macAddress;
  
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ap_id")
    public Integer apId;
}
