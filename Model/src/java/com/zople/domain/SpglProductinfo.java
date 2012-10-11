/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

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
 * @author 王文彦
 */
@Entity
@Table(name = "spgl_productinfo")
@NamedQueries({
    @NamedQuery(name = "SpglProductinfo.findAll", query = "SELECT s FROM SpglProductinfo s"),
    @NamedQuery(name = "SpglProductinfo.findById", query = "SELECT s FROM SpglProductinfo s WHERE s.id = :id"),
    @NamedQuery(name = "SpglProductinfo.findByProductCode", query = "SELECT s FROM SpglProductinfo s WHERE s.productCode = :productCode"),
    @NamedQuery(name = "SpglProductinfo.findByLongDesc", query = "SELECT s FROM SpglProductinfo s WHERE s.longDesc = :longDesc"),
    @NamedQuery(name = "SpglProductinfo.findByProType", query = "SELECT s FROM SpglProductinfo s WHERE s.proType = :proType"),
    @NamedQuery(name = "SpglProductinfo.findByBrandId", query = "SELECT s FROM SpglProductinfo s WHERE s.brandId = :brandId"),
    @NamedQuery(name = "SpglProductinfo.findByName", query = "SELECT s FROM SpglProductinfo s WHERE s.name = :name"),
    @NamedQuery(name = "SpglProductinfo.findByEnglishName", query = "SELECT s FROM SpglProductinfo s WHERE s.englishName = :englishName"),
    @NamedQuery(name = "SpglProductinfo.findByUnits", query = "SELECT s FROM SpglProductinfo s WHERE s.units = :units"),
    @NamedQuery(name = "SpglProductinfo.findByOutputRate", query = "SELECT s FROM SpglProductinfo s WHERE s.outputRate = :outputRate"),
    @NamedQuery(name = "SpglProductinfo.findByProductWidth", query = "SELECT s FROM SpglProductinfo s WHERE s.productWidth = :productWidth"),
    @NamedQuery(name = "SpglProductinfo.findByProductHeight", query = "SELECT s FROM SpglProductinfo s WHERE s.productHeight = :productHeight"),
    @NamedQuery(name = "SpglProductinfo.findByProductType", query = "SELECT s FROM SpglProductinfo s WHERE s.productType = :productType"),
    @NamedQuery(name = "SpglProductinfo.findByIsStored", query = "SELECT s FROM SpglProductinfo s WHERE s.isStored = :isStored"),
    @NamedQuery(name = "SpglProductinfo.findByStackHeight", query = "SELECT s FROM SpglProductinfo s WHERE s.stackHeight = :stackHeight"),
    @NamedQuery(name = "SpglProductinfo.findByGrossWeight", query = "SELECT s FROM SpglProductinfo s WHERE s.grossWeight = :grossWeight"),
    @NamedQuery(name = "SpglProductinfo.findByManufacturer", query = "SELECT s FROM SpglProductinfo s WHERE s.manufacturer = :manufacturer"),
    @NamedQuery(name = "SpglProductinfo.findByRemark", query = "SELECT s FROM SpglProductinfo s WHERE s.remark = :remark"),
    @NamedQuery(name = "SpglProductinfo.findBySorts", query = "SELECT s FROM SpglProductinfo s WHERE s.sorts = :sorts"),
    @NamedQuery(name = "SpglProductinfo.findByCreator", query = "SELECT s FROM SpglProductinfo s WHERE s.creator = :creator"),
    @NamedQuery(name = "SpglProductinfo.findByUpdateUser", query = "SELECT s FROM SpglProductinfo s WHERE s.updateUser = :updateUser"),
    @NamedQuery(name = "SpglProductinfo.findByUpdateTime", query = "SELECT s FROM SpglProductinfo s WHERE s.updateTime = :updateTime"),
    @NamedQuery(name = "SpglProductinfo.findByCreateTime", query = "SELECT s FROM SpglProductinfo s WHERE s.createTime = :createTime")})
public class SpglProductinfo implements Serializable {
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

    public SpglProductinfo() {
    }

    public SpglProductinfo(Long id) {
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
        if (!(object instanceof SpglProductinfo)) {
            return false;
        }
        SpglProductinfo other = (SpglProductinfo) object;
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
