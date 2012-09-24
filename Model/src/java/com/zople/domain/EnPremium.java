/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "en_premium")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnPremium.findAll", query = "SELECT e FROM EnPremium e"),
    @NamedQuery(name = "EnPremium.findById", query = "SELECT e FROM EnPremium e WHERE e.id = :id"),
    @NamedQuery(name = "EnPremium.findByDescription", query = "SELECT e FROM EnPremium e WHERE e.description = :description"),
    @NamedQuery(name = "EnPremium.findByName", query = "SELECT e FROM EnPremium e WHERE e.name = :name"),
    @NamedQuery(name = "EnPremium.findByUserId", query = "SELECT e FROM EnPremium e WHERE e.userId = :userId"),
    @NamedQuery(name = "EnPremium.findByUserName", query = "SELECT e FROM EnPremium e WHERE e.userName = :userName")})
public class EnPremium implements Serializable {
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "user_id")
    private BigDecimal userId;
    @Size(max = 100)
    @Column(name = "user_name")
    private String userName;
    @JoinColumn(name = "en_enterprise_id", referencedColumnName = "id")
    @ManyToOne
    private EnEnterprise enEnterpriseId;

    public EnPremium() {
    }

    public EnPremium(Long id) {
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

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        if (!(object instanceof EnPremium)) {
            return false;
        }
        EnPremium other = (EnPremium) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.EnPremium[ id=" + id + " ]";
    }
    
}
