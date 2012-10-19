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
@Table(name = "sad_buy_product")
@NamedQueries({
    @NamedQuery(name = "SadBuyProduct.findAll", query = "SELECT s FROM SadBuyProduct s"),
    @NamedQuery(name = "SadBuyProduct.findByBuyProductId", query = "SELECT s FROM SadBuyProduct s WHERE s.buyProductId = :buyProductId"),
    @NamedQuery(name = "SadBuyProduct.findByBuyTitle", query = "SELECT s FROM SadBuyProduct s WHERE s.buyTitle = :buyTitle"),
    @NamedQuery(name = "SadBuyProduct.findByBuyProduct", query = "SELECT s FROM SadBuyProduct s WHERE s.buyProduct = :buyProduct"),
    @NamedQuery(name = "SadBuyProduct.findByCategoryId", query = "SELECT s FROM SadBuyProduct s WHERE s.categoryId = :categoryId"),
    @NamedQuery(name = "SadBuyProduct.findByBuyNum", query = "SELECT s FROM SadBuyProduct s WHERE s.buyNum = :buyNum"),
    @NamedQuery(name = "SadBuyProduct.findByBuyTypee", query = "SELECT s FROM SadBuyProduct s WHERE s.buyTypee = :buyTypee"),
    @NamedQuery(name = "SadBuyProduct.findByBuyScale", query = "SELECT s FROM SadBuyProduct s WHERE s.buyScale = :buyScale"),
    @NamedQuery(name = "SadBuyProduct.findByInformationDate", query = "SELECT s FROM SadBuyProduct s WHERE s.informationDate = :informationDate"),
    @NamedQuery(name = "SadBuyProduct.findByMoreInformation", query = "SELECT s FROM SadBuyProduct s WHERE s.moreInformation = :moreInformation"),
    @NamedQuery(name = "SadBuyProduct.findByIsSystemSuppliers", query = "SELECT s FROM SadBuyProduct s WHERE s.isSystemSuppliers = :isSystemSuppliers"),
    @NamedQuery(name = "SadBuyProduct.findByEnterpriseId", query = "SELECT s FROM SadBuyProduct s WHERE s.enterpriseId = :enterpriseId"),
    @NamedQuery(name = "SadBuyProduct.findByCreator", query = "SELECT s FROM SadBuyProduct s WHERE s.creator = :creator"),
    @NamedQuery(name = "SadBuyProduct.findByUpdateUser", query = "SELECT s FROM SadBuyProduct s WHERE s.updateUser = :updateUser"),
    @NamedQuery(name = "SadBuyProduct.findByUpdateTime", query = "SELECT s FROM SadBuyProduct s WHERE s.updateTime = :updateTime"),
    @NamedQuery(name = "SadBuyProduct.findByCreateTime", query = "SELECT s FROM SadBuyProduct s WHERE s.createTime = :createTime")})
public class SadBuyProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "buy_product_id")
    private Long buyProductId;
    @Size(max = 50)
    @Column(name = "buy_title")
    private String buyTitle;
    @Size(max = 50)
    @Column(name = "buy_product")
    private String buyProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "category_id")
    private long categoryId;
    @Column(name = "buy_num")
    private Integer buyNum;
    @Column(name = "buy_typee")
    private Integer buyTypee;
    @Column(name = "buy_scale")
    private Integer buyScale;
    @Column(name = "information_date")
    @Temporal(TemporalType.DATE)
    private Date informationDate;
    @Size(max = 2147483647)
    @Column(name = "more_information")
    private String moreInformation;
    @Column(name = "is_system_suppliers")
    private BigInteger isSystemSuppliers;
    @Column(name = "enterprise_id")
    private BigInteger enterpriseId;
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

    public SadBuyProduct() {
    }

    public SadBuyProduct(Long buyProductId) {
        this.buyProductId = buyProductId;
    }

    public SadBuyProduct(Long buyProductId, long categoryId) {
        this.buyProductId = buyProductId;
        this.categoryId = categoryId;
    }

    public Long getBuyProductId() {
        return buyProductId;
    }

    public void setBuyProductId(Long buyProductId) {
        this.buyProductId = buyProductId;
    }

    public String getBuyTitle() {
        return buyTitle;
    }

    public void setBuyTitle(String buyTitle) {
        this.buyTitle = buyTitle;
    }

    public String getBuyProduct() {
        return buyProduct;
    }

    public void setBuyProduct(String buyProduct) {
        this.buyProduct = buyProduct;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public Integer getBuyTypee() {
        return buyTypee;
    }

    public void setBuyTypee(Integer buyTypee) {
        this.buyTypee = buyTypee;
    }

    public Integer getBuyScale() {
        return buyScale;
    }

    public void setBuyScale(Integer buyScale) {
        this.buyScale = buyScale;
    }

    public Date getInformationDate() {
        return informationDate;
    }

    public void setInformationDate(Date informationDate) {
        this.informationDate = informationDate;
    }

    public String getMoreInformation() {
        return moreInformation;
    }

    public void setMoreInformation(String moreInformation) {
        this.moreInformation = moreInformation;
    }

    public BigInteger getIsSystemSuppliers() {
        return isSystemSuppliers;
    }

    public void setIsSystemSuppliers(BigInteger isSystemSuppliers) {
        this.isSystemSuppliers = isSystemSuppliers;
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
        hash += (buyProductId != null ? buyProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SadBuyProduct)) {
            return false;
        }
        SadBuyProduct other = (SadBuyProduct) object;
        if ((this.buyProductId == null && other.buyProductId != null) || (this.buyProductId != null && !this.buyProductId.equals(other.buyProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.service.common.SadBuyProduct[ buyProductId=" + buyProductId + " ]";
    }
    
}
