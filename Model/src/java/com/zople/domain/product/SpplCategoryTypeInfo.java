/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain.product;

import java.io.Serializable;
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
@Table(name = "sppl_CategoryTypeInfo")
@NamedQueries({
    @NamedQuery(name = "SpplCategoryTypeInfo.findAll", query = "SELECT s FROM SpplCategoryTypeInfo s"),
    @NamedQuery(name = "SpplCategoryTypeInfo.findById", query = "SELECT s FROM SpplCategoryTypeInfo s WHERE s.id = :id"),
    @NamedQuery(name = "SpplCategoryTypeInfo.findByName", query = "SELECT s FROM SpplCategoryTypeInfo s WHERE s.name = :name"),
    @NamedQuery(name = "SpplCategoryTypeInfo.findByCode", query = "SELECT s FROM SpplCategoryTypeInfo s WHERE s.code = :code"),
    @NamedQuery(name = "SpplCategoryTypeInfo.findByIsUsed", query = "SELECT s FROM SpplCategoryTypeInfo s WHERE s.isUsed = :isUsed"),
    @NamedQuery(name = "SpplCategoryTypeInfo.findByIsStd", query = "SELECT s FROM SpplCategoryTypeInfo s WHERE s.isStd = :isStd"),
    @NamedQuery(name = "SpplCategoryTypeInfo.findByDescription", query = "SELECT s FROM SpplCategoryTypeInfo s WHERE s.description = :description"),
    @NamedQuery(name = "SpplCategoryTypeInfo.findByRemark", query = "SELECT s FROM SpplCategoryTypeInfo s WHERE s.remark = :remark"),
    @NamedQuery(name = "SpplCategoryTypeInfo.findByCreator", query = "SELECT s FROM SpplCategoryTypeInfo s WHERE s.creator = :creator"),
    @NamedQuery(name = "SpplCategoryTypeInfo.findByUpdateUser", query = "SELECT s FROM SpplCategoryTypeInfo s WHERE s.updateUser = :updateUser"),
    @NamedQuery(name = "SpplCategoryTypeInfo.findByCreateTime", query = "SELECT s FROM SpplCategoryTypeInfo s WHERE s.createTime = :createTime"),
    @NamedQuery(name = "SpplCategoryTypeInfo.findByUpdateTime", query = "SELECT s FROM SpplCategoryTypeInfo s WHERE s.updateTime = :updateTime")})
public class SpplCategoryTypeInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "name", nullable = false, length = 40)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "code", nullable = false, length = 6)
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_used", nullable = false)
    private boolean isUsed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_std", nullable = false)
    private boolean isStd;
    @Size(max = 400)
    @Column(name = "description", length = 400)
    private String description;
    @Size(max = 600)
    @Column(name = "remark", length = 600)
    private String remark;
    @Size(max = 20)
    @Column(name = "creator", length = 20)
    private String creator;
    @Size(max = 30)
    @Column(name = "update_user", length = 30)
    private String updateUser;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public SpplCategoryTypeInfo() {
    }

    public SpplCategoryTypeInfo(Long id) {
        this.id = id;
    }

    public SpplCategoryTypeInfo(Long id, String name, String code, boolean isUsed, boolean isStd) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.isUsed = isUsed;
        this.isStd = isStd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public boolean getIsStd() {
        return isStd;
    }

    public void setIsStd(boolean isStd) {
        this.isStd = isStd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        if (!(object instanceof SpplCategoryTypeInfo)) {
            return false;
        }
        SpplCategoryTypeInfo other = (SpplCategoryTypeInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.SpplCategoryTypeInfo[ id=" + id + " ]";
    }
    
}
