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
@Table(name = "admin_exhibition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminExhibition.findAll", query = "SELECT a FROM AdminExhibition a"),
    @NamedQuery(name = "AdminExhibition.findById", query = "SELECT a FROM AdminExhibition a WHERE a.id = :id"),
    @NamedQuery(name = "AdminExhibition.findByDescription", query = "SELECT a FROM AdminExhibition a WHERE a.description = :description"),
    @NamedQuery(name = "AdminExhibition.findByName", query = "SELECT a FROM AdminExhibition a WHERE a.name = :name")})
public class AdminExhibition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 100)
    @Column(name = "name")
    private String name;

    public AdminExhibition() {
    }

    public AdminExhibition(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof AdminExhibition)) {
            return false;
        }
        AdminExhibition other = (AdminExhibition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.AdminExhibition[ id=" + id + " ]";
    }
    
}
