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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yucongjun
 */
@Entity
@Table(name = "sad_supply_productprice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SadSupplyProductprice.findAll", query = "SELECT s FROM SadSupplyProductprice s"),
    @NamedQuery(name = "SadSupplyProductprice.findById", query = "SELECT s FROM SadSupplyProductprice s WHERE s.id = :id"),
    @NamedQuery(name = "SadSupplyProductprice.findBySupplyProductId", query = "SELECT s FROM SadSupplyProductprice s WHERE s.supplyProductId = :supplyProductId"),
    @NamedQuery(name = "SadSupplyProductprice.findByStartNum", query = "SELECT s FROM SadSupplyProductprice s WHERE s.startNum = :startNum"),
    @NamedQuery(name = "SadSupplyProductprice.findByEntNum", query = "SELECT s FROM SadSupplyProductprice s WHERE s.entNum = :entNum"),
    @NamedQuery(name = "SadSupplyProductprice.findByNumTypePrice", query = "SELECT s FROM SadSupplyProductprice s WHERE s.numTypePrice = :numTypePrice"),
    @NamedQuery(name = "SadSupplyProductprice.findBySpecifications", query = "SELECT s FROM SadSupplyProductprice s WHERE s.specifications = :specifications"),
    @NamedQuery(name = "SadSupplyProductprice.findBySpecificationsPrice", query = "SELECT s FROM SadSupplyProductprice s WHERE s.specificationsPrice = :specificationsPrice"),
    @NamedQuery(name = "SadSupplyProductprice.findBySpeStockQuantity", query = "SELECT s FROM SadSupplyProductprice s WHERE s.speStockQuantity = :speStockQuantity"),
    @NamedQuery(name = "SadSupplyProductprice.findByCreator", query = "SELECT s FROM SadSupplyProductprice s WHERE s.creator = :creator"),
    @NamedQuery(name = "SadSupplyProductprice.findByUpdateUser", query = "SELECT s FROM SadSupplyProductprice s WHERE s.updateUser = :updateUser"),
    @NamedQuery(name = "SadSupplyProductprice.findByUpdateTime", query = "SELECT s FROM SadSupplyProductprice s WHERE s.updateTime = :updateTime"),
    @NamedQuery(name = "SadSupplyProductprice.findByCreateTime", query = "SELECT s FROM SadSupplyProductprice s WHERE s.createTime = :createTime")})
public class SadSupplyProductprice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Column(name = "supply_product_id")
    private BigInteger supplyProductId;
    @Column(name = "start_num")
    private Integer startNum;
    @Column(name = "ent_num")
    private Integer entNum;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "num_type_price")
    private BigDecimal numTypePrice;
    @Column(name = "specifications")
    private Integer specifications;
    @Column(name = "specifications_price")
    private BigDecimal specificationsPrice;
    @Column(name = "spe_stock_quantity")
    private BigInteger speStockQuantity;
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

    public SadSupplyProductprice() {
    }

    public SadSupplyProductprice(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getSupplyProductId() {
        return supplyProductId;
    }

    public void setSupplyProductId(BigInteger supplyProductId) {
        this.supplyProductId = supplyProductId;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Integer getEntNum() {
        return entNum;
    }

    public void setEntNum(Integer entNum) {
        this.entNum = entNum;
    }

    public BigDecimal getNumTypePrice() {
        return numTypePrice;
    }

    public void setNumTypePrice(BigDecimal numTypePrice) {
        this.numTypePrice = numTypePrice;
    }

    public Integer getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Integer specifications) {
        this.specifications = specifications;
    }

    public BigDecimal getSpecificationsPrice() {
        return specificationsPrice;
    }

    public void setSpecificationsPrice(BigDecimal specificationsPrice) {
        this.specificationsPrice = specificationsPrice;
    }

    public BigInteger getSpeStockQuantity() {
        return speStockQuantity;
    }

    public void setSpeStockQuantity(BigInteger speStockQuantity) {
        this.speStockQuantity = speStockQuantity;
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
        if (!(object instanceof SadSupplyProductprice)) {
            return false;
        }
        SadSupplyProductprice other = (SadSupplyProductprice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.product.SadSupplyProductprice[ id=" + id + " ]";
    }
    
}
