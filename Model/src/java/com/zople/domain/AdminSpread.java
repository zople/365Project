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
@Table(name = "admin_spread")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminSpread.findAll", query = "SELECT a FROM AdminSpread a"),
    @NamedQuery(name = "AdminSpread.findById", query = "SELECT a FROM AdminSpread a WHERE a.id = :id"),
    @NamedQuery(name = "AdminSpread.findByBrandName", query = "SELECT a FROM AdminSpread a WHERE a.brandName = :brandName"),
    @NamedQuery(name = "AdminSpread.findByDescription", query = "SELECT a FROM AdminSpread a WHERE a.description = :description")})
public class AdminSpread implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 100)
    @Column(name = "brand_name")
    private String brandName;
    @Size(max = 255)
    @Column(name = "description")
    private String description;

    public AdminSpread() {
    }

    public AdminSpread(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof AdminSpread)) {
            return false;
        }
        AdminSpread other = (AdminSpread) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.AdminSpread[ id=" + id + " ]";
    }
    
}
