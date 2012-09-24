/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "m_mall")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MMall.findAll", query = "SELECT m FROM MMall m"),
    @NamedQuery(name = "MMall.findById", query = "SELECT m FROM MMall m WHERE m.id = :id"),
    @NamedQuery(name = "MMall.findByDescribes", query = "SELECT m FROM MMall m WHERE m.describes = :describes"),
    @NamedQuery(name = "MMall.findByEmail", query = "SELECT m FROM MMall m WHERE m.email = :email"),
    @NamedQuery(name = "MMall.findByLogo", query = "SELECT m FROM MMall m WHERE m.logo = :logo"),
    @NamedQuery(name = "MMall.findByName", query = "SELECT m FROM MMall m WHERE m.name = :name"),
    @NamedQuery(name = "MMall.findByPhone", query = "SELECT m FROM MMall m WHERE m.phone = :phone")})
public class MMall implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "describes")
    private String describes;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @OneToOne
    private Image logo;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "phone")
    private String phone;
    @JoinColumn(name = "en_user_id", referencedColumnName = "id")
    @ManyToOne
    private EnUser enUserId;

    public MMall() {
    }

    public MMall(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EnUser getEnUserId() {
        return enUserId;
    }

    public void setEnUserId(EnUser enUserId) {
        this.enUserId = enUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MMall)) {
            return false;
        }
        MMall other = (MMall) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.MMall[ id=" + id + " ]";
    }
    
}
