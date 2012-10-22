/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain.basic;

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
@Table(name = "sad_buy_product_price")
@NamedQueries({
    @NamedQuery(name = "SadBuyProductPrice.findAll", query = "SELECT s FROM SadBuyProductPrice s"),
    @NamedQuery(name = "SadBuyProductPrice.findByBuyProductPriceId", query = "SELECT s FROM SadBuyProductPrice s WHERE s.buyProductPriceId = :buyProductPriceId"),
    @NamedQuery(name = "SadBuyProductPrice.findByBuyProductId", query = "SELECT s FROM SadBuyProductPrice s WHERE s.buyProductId = :buyProductId"),
    @NamedQuery(name = "SadBuyProductPrice.findByPrice", query = "SELECT s FROM SadBuyProductPrice s WHERE s.price = :price"),
    @NamedQuery(name = "SadBuyProductPrice.findByProductName", query = "SELECT s FROM SadBuyProductPrice s WHERE s.productName = :productName"),
    @NamedQuery(name = "SadBuyProductPrice.findByProductAdvantages", query = "SELECT s FROM SadBuyProductPrice s WHERE s.productAdvantages = :productAdvantages"),
    @NamedQuery(name = "SadBuyProductPrice.findByProductPrice", query = "SELECT s FROM SadBuyProductPrice s WHERE s.productPrice = :productPrice"),
    @NamedQuery(name = "SadBuyProductPrice.findByDescription", query = "SELECT s FROM SadBuyProductPrice s WHERE s.description = :description"),
    @NamedQuery(name = "SadBuyProductPrice.findByEnterpriseId", query = "SELECT s FROM SadBuyProductPrice s WHERE s.enterpriseId = :enterpriseId"),
    @NamedQuery(name = "SadBuyProductPrice.findByCreator", query = "SELECT s FROM SadBuyProductPrice s WHERE s.creator = :creator"),
    @NamedQuery(name = "SadBuyProductPrice.findByUpdateUser", query = "SELECT s FROM SadBuyProductPrice s WHERE s.updateUser = :updateUser"),
    @NamedQuery(name = "SadBuyProductPrice.findByUpdateTime", query = "SELECT s FROM SadBuyProductPrice s WHERE s.updateTime = :updateTime"),
    @NamedQuery(name = "SadBuyProductPrice.findByCreateTime", query = "SELECT s FROM SadBuyProductPrice s WHERE s.createTime = :createTime")})
public class SadBuyProductPrice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "buy_product_price_id")
    private Long buyProductPriceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "buy_product_id")
    private long buyProductId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @Size(max = 50)
    @Column(name = "product_name")
    private String productName;
    @Size(max = 100)
    @Column(name = "product_advantages")
    private String productAdvantages;
    @Column(name = "product_price")
    private BigDecimal productPrice;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @Column(name = "enterprise_id")
    private BigInteger enterpriseId;
    @Size(max = 50)
    @Column(name = "creator")
    private String creator;
    @Size(max = 50)
    @Column(name = "update_user")
    private String updateUser;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    public SadBuyProductPrice() {
    }

    public SadBuyProductPrice(Long buyProductPriceId) {
        this.buyProductPriceId = buyProductPriceId;
    }

    public SadBuyProductPrice(Long buyProductPriceId, long buyProductId) {
        this.buyProductPriceId = buyProductPriceId;
        this.buyProductId = buyProductId;
    }

    public Long getBuyProductPriceId() {
        return buyProductPriceId;
    }

    public void setBuyProductPriceId(Long buyProductPriceId) {
        this.buyProductPriceId = buyProductPriceId;
    }

    public long getBuyProductId() {
        return buyProductId;
    }

    public void setBuyProductId(long buyProductId) {
        this.buyProductId = buyProductId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductAdvantages() {
        return productAdvantages;
    }

    public void setProductAdvantages(String productAdvantages) {
        this.productAdvantages = productAdvantages;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(BigInteger enterpriseId) {
        this.enterpriseId = enterpriseId;
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
        hash += (buyProductPriceId != null ? buyProductPriceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SadBuyProductPrice)) {
            return false;
        }
        SadBuyProductPrice other = (SadBuyProductPrice) object;
        if ((this.buyProductPriceId == null && other.buyProductPriceId != null) || (this.buyProductPriceId != null && !this.buyProductPriceId.equals(other.buyProductPriceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.service.common.SadBuyProductPrice[ buyProductPriceId=" + buyProductPriceId + " ]";
    }
    
}
