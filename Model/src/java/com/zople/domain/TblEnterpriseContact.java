/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "tbl_enterprise_contact")
@NamedQueries({
    @NamedQuery(name = "TblEnterpriseContact.findAll", query = "SELECT t FROM TblEnterpriseContact t"),
    @NamedQuery(name = "TblEnterpriseContact.findById", query = "SELECT t FROM TblEnterpriseContact t WHERE t.id = :id"),
    @NamedQuery(name = "TblEnterpriseContact.findByEnterpriseId", query = "SELECT t FROM TblEnterpriseContact t WHERE t.enterpriseId = :enterpriseId"),
    @NamedQuery(name = "TblEnterpriseContact.findByContactName", query = "SELECT t FROM TblEnterpriseContact t WHERE t.contactName = :contactName"),
    @NamedQuery(name = "TblEnterpriseContact.findByContactPhone", query = "SELECT t FROM TblEnterpriseContact t WHERE t.contactPhone = :contactPhone"),
    @NamedQuery(name = "TblEnterpriseContact.findByCreator", query = "SELECT t FROM TblEnterpriseContact t WHERE t.creator = :creator"),
    @NamedQuery(name = "TblEnterpriseContact.findByUpdateUser", query = "SELECT t FROM TblEnterpriseContact t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TblEnterpriseContact.findByUpdateTime", query = "SELECT t FROM TblEnterpriseContact t WHERE t.updateTime = :updateTime"),
    @NamedQuery(name = "TblEnterpriseContact.findByCreateTime", query = "SELECT t FROM TblEnterpriseContact t WHERE t.createTime = :createTime")})
public class TblEnterpriseContact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "enterprise_id")
    private BigInteger enterpriseId;
    @Size(max = 20)
    @Column(name = "contact_name", length = 20)
    private String contactName;
    @Size(max = 20)
    @Column(name = "contact_phone", length = 20)
    private String contactPhone;
    @Size(max = 20)
    @Column(name = "creator", length = 20)
    private String creator;
    @Size(max = 20)
    @Column(name = "update_user", length = 20)
    private String updateUser;
    @Column(name = "update_time")
    @Temporal(TemporalType.DATE)
    private Date updateTime;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;

    public TblEnterpriseContact() {
    }

    public TblEnterpriseContact(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(BigInteger enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        if (!(object instanceof TblEnterpriseContact)) {
            return false;
        }
        TblEnterpriseContact other = (TblEnterpriseContact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.TblEnterpriseContact[ id=" + id + " ]";
    }
    
}
