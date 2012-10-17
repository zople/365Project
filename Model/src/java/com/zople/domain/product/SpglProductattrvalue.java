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
@Table(name = "spgl_productattrvalue")
@NamedQueries({
    @NamedQuery(name = "SpglProductattrvalue.findAll", query = "SELECT s FROM SpglProductattrvalue s"),
    @NamedQuery(name = "SpglProductattrvalue.findById", query = "SELECT s FROM SpglProductattrvalue s WHERE s.id = :id"),
    @NamedQuery(name = "SpglProductattrvalue.findByProductId", query = "SELECT s FROM SpglProductattrvalue s WHERE s.productId = :productId"),
    @NamedQuery(name = "SpglProductattrvalue.findByCategoryAttrid", query = "SELECT s FROM SpglProductattrvalue s WHERE s.categoryAttrid = :categoryAttrid"),
    @NamedQuery(name = "SpglProductattrvalue.findByAttrvalues", query = "SELECT s FROM SpglProductattrvalue s WHERE s.attrvalues = :attrvalues"),
    @NamedQuery(name = "SpglProductattrvalue.findBySorts", query = "SELECT s FROM SpglProductattrvalue s WHERE s.sorts = :sorts"),
    @NamedQuery(name = "SpglProductattrvalue.findByCreator", query = "SELECT s FROM SpglProductattrvalue s WHERE s.creator = :creator"),
    @NamedQuery(name = "SpglProductattrvalue.findByUpdateUser", query = "SELECT s FROM SpglProductattrvalue s WHERE s.updateUser = :updateUser"),
    @NamedQuery(name = "SpglProductattrvalue.findByCreateTime", query = "SELECT s FROM SpglProductattrvalue s WHERE s.createTime = :createTime"),
    @NamedQuery(name = "SpglProductattrvalue.findByUpdateTime", query = "SELECT s FROM SpglProductattrvalue s WHERE s.updateTime = :updateTime")})
public class SpglProductattrvalue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "product_id", nullable = false, length = 32)
    private String productId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "category_attrid", nullable = false, length = 32)
    private String categoryAttrid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "attrvalues", nullable = false, length = 200)
    private String attrvalues;
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

    public SpglProductattrvalue() {
    }

    public SpglProductattrvalue(Long id) {
        this.id = id;
    }

    public SpglProductattrvalue(Long id, String productId, String categoryAttrid, String attrvalues, short sorts) {
        this.id = id;
        this.productId = productId;
        this.categoryAttrid = categoryAttrid;
        this.attrvalues = attrvalues;
        this.sorts = sorts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategoryAttrid() {
        return categoryAttrid;
    }

    public void setCategoryAttrid(String categoryAttrid) {
        this.categoryAttrid = categoryAttrid;
    }

    public String getAttrvalues() {
        return attrvalues;
    }

    public void setAttrvalues(String attrvalues) {
        this.attrvalues = attrvalues;
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
        if (!(object instanceof SpglProductattrvalue)) {
            return false;
        }
        SpglProductattrvalue other = (SpglProductattrvalue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.SpglProductattrvalue[ id=" + id + " ]";
    }
    
}
