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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "en_authentication")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Authentication.findAll", query = "SELECT e FROM Authentication e"),
    @NamedQuery(name = "Authentication.findById", query = "SELECT e FROM Authentication e WHERE e.id = :id"),
    @NamedQuery(name = "Authentication.findByAptitudeCertifications", query = "SELECT e FROM Authentication e WHERE e.aptitudeCertifications = :aptitudeCertifications"),
    @NamedQuery(name = "Authentication.findByDescription", query = "SELECT e FROM Authentication e WHERE e.description = :description"),
    @NamedQuery(name = "Authentication.findByIntegrityCertifications", query = "SELECT e FROM Authentication e WHERE e.integrityCertifications = :integrityCertifications"),
    @NamedQuery(name = "Authentication.findByName", query = "SELECT e FROM Authentication e WHERE e.name = :name")})
public class Authentication implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 100)
    @Column(name = "aptitude_certifications")
    private String aptitudeCertifications;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 100)
    @Column(name = "integrity_certifications")
    private String integrityCertifications;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "en_enterprise_id", referencedColumnName = "id")
    @ManyToOne
    private EnEnterprise enEnterpriseId;

    public Authentication() {
    }

    public Authentication(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAptitudeCertifications() {
        return aptitudeCertifications;
    }

    public void setAptitudeCertifications(String aptitudeCertifications) {
        this.aptitudeCertifications = aptitudeCertifications;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIntegrityCertifications() {
        return integrityCertifications;
    }

    public void setIntegrityCertifications(String integrityCertifications) {
        this.integrityCertifications = integrityCertifications;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnEnterprise getEnEnterpriseId() {
        return enEnterpriseId;
    }

    public void setEnEnterpriseId(EnEnterprise enEnterpriseId) {
        this.enEnterpriseId = enEnterpriseId;
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
        if (!(object instanceof Authentication)) {
            return false;
        }
        Authentication other = (Authentication) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.EnAuthentication[ id=" + id + " ]";
    }
    
}
