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
 * 产品主数据实体
 * @author 王文彦
 */
@Entity
@Table(name = "spgl_productinfo")
public class ProductMainInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(max = 20)
    @Column(name = "product_code", length = 20)
    private String productCode;
    @Size(max = 20)
    @Column(name = "long_desc", length = 20)
    private String longDesc;
    @Column(name = "pro_type")
    private Character proType;
    @Column(name = "brand_id")
    private BigInteger brandId;
    @Size(max = 40)
    @Column(name = "name", length = 40)
    private String name;
    @Size(max = 40)
    @Column(name = "english_name", length = 40)
    private String englishName;
    @Size(max = 20)
    @Column(name = "units", length = 20)
    private String units;
    @Column(name = "output_rate")
    private Short outputRate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "product_width", precision = 10, scale = 2)
    private BigDecimal productWidth;
    @Column(name = "product_height", precision = 10, scale = 2)
    private BigDecimal productHeight;
    @Size(max = 20)
    @Column(name = "product_type", length = 20)
    private String productType;
    @Size(max = 20)
    @Column(name = "is_stored", length = 20)
    private String isStored;
    @Column(name = "stack_height")
    private Integer stackHeight;
    @Column(name = "gross_weight", precision = 14, scale = 4)
    private BigDecimal grossWeight;
    @Size(max = 100)
    @Column(name = "manufacturer", length = 100)
    private String manufacturer;
    @Size(max = 600)
    @Column(name = "remark", length = 600)
    private String remark;
    @Column(name = "sorts")
    private Short sorts;
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

    public ProductMainInfo() {
    }

    public ProductMainInfo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public Character getProType() {
        return proType;
    }

    public void setProType(Character proType) {
        this.proType = proType;
    }

    public BigInteger getBrandId() {
        return brandId;
    }

    public void setBrandId(BigInteger brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Short getOutputRate() {
        return outputRate;
    }

    public void setOutputRate(Short outputRate) {
        this.outputRate = outputRate;
    }

    public BigDecimal getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(BigDecimal productWidth) {
        this.productWidth = productWidth;
    }

    public BigDecimal getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(BigDecimal productHeight) {
        this.productHeight = productHeight;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getIsStored() {
        return isStored;
    }

    public void setIsStored(String isStored) {
        this.isStored = isStored;
    }

    public Integer getStackHeight() {
        return stackHeight;
    }

    public void setStackHeight(Integer stackHeight) {
        this.stackHeight = stackHeight;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Short getSorts() {
        return sorts;
    }

    public void setSorts(Short sorts) {
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
        if (!(object instanceof ProductMainInfo)) {
            return false;
        }
        ProductMainInfo other = (ProductMainInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.SpglProductinfo[ id=" + id + " ]";
    }
    
}
