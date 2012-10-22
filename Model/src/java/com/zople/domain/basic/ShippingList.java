/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain.basic;

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
 * @author wangxiu
 */
@Entity
@Table(name = "shipping_list")
@NamedQueries({
    @NamedQuery(name = "ShippingList.findAll", query = "SELECT s FROM ShippingList s"),
    @NamedQuery(name = "ShippingList.findByShippingListId", query = "SELECT s FROM ShippingList s WHERE s.shippingListId = :shippingListId"),
    @NamedQuery(name = "ShippingList.findBySupplyProductId", query = "SELECT s FROM ShippingList s WHERE s.supplyProductId = :supplyProductId"),
    @NamedQuery(name = "ShippingList.findByUserId", query = "SELECT s FROM ShippingList s WHERE s.userId = :userId"),
    @NamedQuery(name = "ShippingList.findByAddTime", query = "SELECT s FROM ShippingList s WHERE s.addTime = :addTime"),
    @NamedQuery(name = "ShippingList.findByCreator", query = "SELECT s FROM ShippingList s WHERE s.creator = :creator"),
    @NamedQuery(name = "ShippingList.findByUpdateTime", query = "SELECT s FROM ShippingList s WHERE s.updateTime = :updateTime"),
    @NamedQuery(name = "ShippingList.findByCreateTime", query = "SELECT s FROM ShippingList s WHERE s.createTime = :createTime")})
public class ShippingList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "shipping_list_id")
    private Long shippingListId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supply_product_id")
    private long supplyProductId;
    @Column(name = "user_id")
    private BigInteger userId;
    @Column(name = "add_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addTime;
    @Size(max = 50)
    @Column(name = "creator")
    private String creator;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    public ShippingList() {
    }

    public ShippingList(Long shippingListId) {
        this.shippingListId = shippingListId;
    }

    public ShippingList(Long shippingListId, long supplyProductId) {
        this.shippingListId = shippingListId;
        this.supplyProductId = supplyProductId;
    }

    public Long getShippingListId() {
        return shippingListId;
    }

    public void setShippingListId(Long shippingListId) {
        this.shippingListId = shippingListId;
    }

    public long getSupplyProductId() {
        return supplyProductId;
    }

    public void setSupplyProductId(long supplyProductId) {
        this.supplyProductId = supplyProductId;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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
        hash += (shippingListId != null ? shippingListId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShippingList)) {
            return false;
        }
        ShippingList other = (ShippingList) object;
        if ((this.shippingListId == null && other.shippingListId != null) || (this.shippingListId != null && !this.shippingListId.equals(other.shippingListId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.service.common.ShippingList[ shippingListId=" + shippingListId + " ]";
    }
    
}
