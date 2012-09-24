/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "admin_producet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminProducet.findAll", query = "SELECT a FROM AdminProducet a"),
    @NamedQuery(name = "AdminProducet.findById", query = "SELECT a FROM AdminProducet a WHERE a.id = :id"),
    @NamedQuery(name = "AdminProducet.findByCreateTime", query = "SELECT a FROM AdminProducet a WHERE a.createTime = :createTime"),
    @NamedQuery(name = "AdminProducet.findByDescription", query = "SELECT a FROM AdminProducet a WHERE a.description = :description"),
    @NamedQuery(name = "AdminProducet.findByEndTime", query = "SELECT a FROM AdminProducet a WHERE a.endTime = :endTime"),
    @NamedQuery(name = "AdminProducet.findByName", query = "SELECT a FROM AdminProducet a WHERE a.name = :name")})
public class AdminProducet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "end_time")
    @Temporal(TemporalType.DATE)
    private Date endTime;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "adminProducetId")
    private List<AdminOrderItem> adminOrderItemList;
    @JoinColumn(name = "en_enterprise_id", referencedColumnName = "id")
    @ManyToOne
    private EnEnterprise enEnterpriseId;
    @JoinColumn(name = "admin_catalogue_id", referencedColumnName = "id")
    @ManyToOne
    private AdminCatalogue adminCatalogueId;

    public AdminProducet() {
    }

    public AdminProducet(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<AdminOrderItem> getAdminOrderItemList() {
        return adminOrderItemList;
    }

    public void setAdminOrderItemList(List<AdminOrderItem> adminOrderItemList) {
        this.adminOrderItemList = adminOrderItemList;
    }

    public EnEnterprise getEnEnterpriseId() {
        return enEnterpriseId;
    }

    public void setEnEnterpriseId(EnEnterprise enEnterpriseId) {
        this.enEnterpriseId = enEnterpriseId;
    }

    public AdminCatalogue getAdminCatalogueId() {
        return adminCatalogueId;
    }

    public void setAdminCatalogueId(AdminCatalogue adminCatalogueId) {
        this.adminCatalogueId = adminCatalogueId;
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
        if (!(object instanceof AdminProducet)) {
            return false;
        }
        AdminProducet other = (AdminProducet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.AdminProducet[ id=" + id + " ]";
    }
    
}
