
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain.product;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "en_shipping_costs")
@NamedQueries({
    @NamedQuery(name = "ShippingCosts.findAll", query = "SELECT s FROM ShippingCosts s"),
    @NamedQuery(name = "ShippingCosts.findByLogisticName", query = "SELECT s FROM ShippingCosts s WHERE s.logisticName = :logisticName"),
    @NamedQuery(name = "ShippingCosts.findByFirstPrice", query = "SELECT s FROM ShippingCosts s WHERE s.firstPrice = :firstPrice"),
    @NamedQuery(name = "ShippingCosts.findByFollowPrice", query = "SELECT s FROM ShippingCosts s WHERE s.followPrice = :followPrice"),
    @NamedQuery(name = "ShippingCosts.findByEnterpriseId", query = "SELECT s FROM ShippingCosts s WHERE s.enterpriseId = :enterpriseId"),
    @NamedQuery(name = "ShippingCosts.findByStartArea", query = "SELECT s FROM ShippingCosts s WHERE s.startArea = :startArea"),
    @NamedQuery(name = "ShippingCosts.findByIsVisit", query = "SELECT s FROM ShippingCosts s WHERE s.isVisit = :isVisit"),
    @NamedQuery(name = "ShippingCosts.findByCreator", query = "SELECT s FROM ShippingCosts s WHERE s.creator = :creator"),
    @NamedQuery(name = "ShippingCosts.findByUpdateUser", query = "SELECT s FROM ShippingCosts s WHERE s.updateUser = :updateUser"),
    @NamedQuery(name = "ShippingCosts.findByUpdateTime", query = "SELECT s FROM ShippingCosts s WHERE s.updateTime = :updateTime"),
    @NamedQuery(name = "ShippingCosts.findByCreateTime", query = "SELECT s FROM ShippingCosts s WHERE s.createTime = :createTime"),
    @NamedQuery(name = "ShippingCosts.findByShippingCostsId", query = "SELECT s FROM ShippingCosts s WHERE s.shippingCostsId = :shippingCostsId")})
public class ShippingCosts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 100)
    @Column(name = "logistic_name")
    private String logisticName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "first_price")
    private BigDecimal firstPrice;
    @Column(name = "follow_price")
    private BigDecimal followPrice;
    @Column(name = "enterprise_id")
    private BigInteger enterpriseId;
    @Size(max = 100)
    @Column(name = "start_area")
    private String startArea;
    @Column(name = "is_visit")
    private Integer isVisit;
    @Size(max = 50)
    @Column(name = "creator")
    private String creator;
    @Size(max = 50)
    @Column(name = "update_user")
    private String updateUser;
    @Column(name = "update_time")
    @Temporal(TemporalType.DATE)
    private Date updateTime;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "shipping_costs_id")
    private Long shippingCostsId;

    public ShippingCosts() {
    }

    public ShippingCosts(Long shippingCostsId) {
        this.shippingCostsId = shippingCostsId;
    }

    public String getLogisticName() {
        return logisticName;
    }

    public void setLogisticName(String logisticName) {
        this.logisticName = logisticName;
    }

    public BigDecimal getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(BigDecimal firstPrice) {
        this.firstPrice = firstPrice;
    }

    public BigDecimal getFollowPrice() {
        return followPrice;
    }

    public void setFollowPrice(BigDecimal followPrice) {
        this.followPrice = followPrice;
    }

    public BigInteger getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(BigInteger enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getStartArea() {
        return startArea;
    }

    public void setStartArea(String startArea) {
        this.startArea = startArea;
    }

    public Integer getIsVisit() {
        return isVisit;
    }

    public void setIsVisit(Integer isVisit) {
        this.isVisit = isVisit;
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

    public Long getShippingCostsId() {
        return shippingCostsId;
    }

    public void setShippingCostsId(Long shippingCostsId) {
        this.shippingCostsId = shippingCostsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shippingCostsId != null ? shippingCostsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShippingCosts)) {
            return false;
        }
        ShippingCosts other = (ShippingCosts) object;
        if ((this.shippingCostsId == null && other.shippingCostsId != null) || (this.shippingCostsId != null && !this.shippingCostsId.equals(other.shippingCostsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.product.ShippingCosts[ shippingCostsId=" + shippingCostsId + " ]";
    }
    
}
