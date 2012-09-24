/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "admin_catalogue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminCatalogue.findAll", query = "SELECT a FROM AdminCatalogue a"),
    @NamedQuery(name = "AdminCatalogue.findById", query = "SELECT a FROM AdminCatalogue a WHERE a.id = :id"),
    @NamedQuery(name = "AdminCatalogue.findByClassName", query = "SELECT a FROM AdminCatalogue a WHERE a.className = :className"),
    @NamedQuery(name = "AdminCatalogue.findByDescription", query = "SELECT a FROM AdminCatalogue a WHERE a.description = :description"),
    @NamedQuery(name = "AdminCatalogue.findByLevel", query = "SELECT a FROM AdminCatalogue a WHERE a.level = :level")})
public class AdminCatalogue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 100)
    @Column(name = "class_name")
    private String className;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "level")
    private BigDecimal level;
    @OneToMany(mappedBy = "parentId")
    private List<AdminCatalogue> adminCatalogueList;
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @ManyToOne
    private AdminCatalogue parentId;
    @OneToMany(mappedBy = "adminCatalogueId")
    private List<AdminProducet> adminProducetList;

    public AdminCatalogue() {
    }

    public AdminCatalogue(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getLevel() {
        return level;
    }

    public void setLevel(BigDecimal level) {
        this.level = level;
    }

    @XmlTransient
    public List<AdminCatalogue> getAdminCatalogueList() {
        return adminCatalogueList;
    }

    public void setAdminCatalogueList(List<AdminCatalogue> adminCatalogueList) {
        this.adminCatalogueList = adminCatalogueList;
    }

    public AdminCatalogue getParentId() {
        return parentId;
    }

    public void setParentId(AdminCatalogue parentId) {
        this.parentId = parentId;
    }

    @XmlTransient
    public List<AdminProducet> getAdminProducetList() {
        return adminProducetList;
    }

    public void setAdminProducetList(List<AdminProducet> adminProducetList) {
        this.adminProducetList = adminProducetList;
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
        if (!(object instanceof AdminCatalogue)) {
            return false;
        }
        AdminCatalogue other = (AdminCatalogue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.AdminCatalogue[ id=" + id + " ]";
    }
    
}
