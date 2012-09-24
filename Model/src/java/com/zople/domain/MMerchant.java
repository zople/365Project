/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "m_merchant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MMerchant.findAll", query = "SELECT m FROM MMerchant m"),
    @NamedQuery(name = "MMerchant.findById", query = "SELECT m FROM MMerchant m WHERE m.id = :id"),
    @NamedQuery(name = "MMerchant.findByDescribes", query = "SELECT m FROM MMerchant m WHERE m.describes = :describes"),
    @NamedQuery(name = "MMerchant.findByName", query = "SELECT m FROM MMerchant m WHERE m.name = :name")})
public class MMerchant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "describes")
    private String describes;
    @Size(max = 100)
    @Column(name = "name")
    private String name;

    public MMerchant() {
    }

    public MMerchant(Long id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof MMerchant)) {
            return false;
        }
        MMerchant other = (MMerchant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.MMerchant[ id=" + id + " ]";
    }
    
}
