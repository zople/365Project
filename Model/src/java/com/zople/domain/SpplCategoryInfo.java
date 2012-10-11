/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

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
@Table(name = "sppl_CategoryInfo")
@NamedQueries({
    @NamedQuery(name = "SpplCategoryInfo.findAll", query = "SELECT s FROM SpplCategoryInfo s"),
    @NamedQuery(name = "SpplCategoryInfo.findById", query = "SELECT s FROM SpplCategoryInfo s WHERE s.id = :id"),
    @NamedQuery(name = "SpplCategoryInfo.findByCategoryTypeId", query = "SELECT s FROM SpplCategoryInfo s WHERE s.categoryTypeId = :categoryTypeId"),
    @NamedQuery(name = "SpplCategoryInfo.findByPcode", query = "SELECT s FROM SpplCategoryInfo s WHERE s.pcode = :pcode"),
    @NamedQuery(name = "SpplCategoryInfo.findByName", query = "SELECT s FROM SpplCategoryInfo s WHERE s.name = :name"),
    @NamedQuery(name = "SpplCategoryInfo.findByCode", query = "SELECT s FROM SpplCategoryInfo s WHERE s.code = :code"),
    @NamedQuery(name = "SpplCategoryInfo.findByDescription", query = "SELECT s FROM SpplCategoryInfo s WHERE s.description = :description"),
    @NamedQuery(name = "SpplCategoryInfo.findByAttrtype", query = "SELECT s FROM SpplCategoryInfo s WHERE s.attrtype = :attrtype"),
    @NamedQuery(name = "SpplCategoryInfo.findByRemark", query = "SELECT s FROM SpplCategoryInfo s WHERE s.remark = :remark"),
    @NamedQuery(name = "SpplCategoryInfo.findBySorts", query = "SELECT s FROM SpplCategoryInfo s WHERE s.sorts = :sorts"),
    @NamedQuery(name = "SpplCategoryInfo.findByCreator", query = "SELECT s FROM SpplCategoryInfo s WHERE s.creator = :creator"),
    @NamedQuery(name = "SpplCategoryInfo.findByUpdateUser", query = "SELECT s FROM SpplCategoryInfo s WHERE s.updateUser = :updateUser"),
    @NamedQuery(name = "SpplCategoryInfo.findByCreateTime", query = "SELECT s FROM SpplCategoryInfo s WHERE s.createTime = :createTime"),
    @NamedQuery(name = "SpplCategoryInfo.findByUpdateTime", query = "SELECT s FROM SpplCategoryInfo s WHERE s.updateTime = :updateTime")})
public class SpplCategoryInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "category_type_id", nullable = false, length = 32)
    private String categoryTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "pcode", nullable = false, length = 12)
    private String pcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "name", nullable = false, length = 40)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "code", nullable = false, length = 12)
    private String code;
    @Size(max = 400)
    @Column(name = "description", length = 400)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "attrtype", nullable = false)
    private short attrtype;
    @Size(max = 600)
    @Column(name = "remark", length = 600)
    private String remark;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sorts", nullable = false)
    private short sorts;
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

    public SpplCategoryInfo() {
    }

    public SpplCategoryInfo(Long id) {
        this.id = id;
    }

    public SpplCategoryInfo(Long id, String categoryTypeId, String pcode, String name, String code, short attrtype, short sorts) {
        this.id = id;
        this.categoryTypeId = categoryTypeId;
        this.pcode = pcode;
        this.name = name;
        this.code = code;
        this.attrtype = attrtype;
        this.sorts = sorts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryTypeId() {
        return categoryTypeId;
    }

    public void setCategoryTypeId(String categoryTypeId) {
        this.categoryTypeId = categoryTypeId;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getAttrtype() {
        return attrtype;
    }

    public void setAttrtype(short attrtype) {
        this.attrtype = attrtype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public short getSorts() {
        return sorts;
    }

    public void setSorts(short sorts) {
        this.sorts = sorts;
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
        if (!(object instanceof SpplCategoryInfo)) {
            return false;
        }
        SpplCategoryInfo other = (SpplCategoryInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.SpplCategoryInfo[ id=" + id + " ]";
    }
    
}
