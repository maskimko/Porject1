/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.ipgetter;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maskimko
 */
@Entity
@Table(name = "entitytest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entitytest.findAll", query = "SELECT e FROM Entitytest e"),
    @NamedQuery(name = "Entitytest.findByUserId", query = "SELECT e FROM Entitytest e WHERE e.userId = :userId"),
    @NamedQuery(name = "Entitytest.findByLogin", query = "SELECT e FROM Entitytest e WHERE e.login = :login"),
    @NamedQuery(name = "Entitytest.findByMail", query = "SELECT e FROM Entitytest e WHERE e.mail = :mail"),
    @NamedQuery(name = "Entitytest.findByPasswd", query = "SELECT e FROM Entitytest e WHERE e.passwd = :passwd")})
public class Entitytest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "passwd")
    private String passwd;

    public Entitytest() {
    }

    public Entitytest(Integer userId) {
        this.userId = userId;
    }

    public Entitytest(Integer userId, String login, String mail, String passwd) {
        this.userId = userId;
        this.login = login;
        this.mail = mail;
        this.passwd = passwd;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entitytest)) {
            return false;
        }
        Entitytest other = (Entitytest) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.pp.msk.project1.ipgetter.Entitytest[ userId=" + userId + " ]";
    }
    
}
