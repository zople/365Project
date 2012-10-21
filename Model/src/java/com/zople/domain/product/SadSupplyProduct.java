/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain.product;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "sad_supply_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SadSupplyProduct.findAll", query = "SELECT s FROM SadSupplyProduct s"),
    @NamedQuery(name = "SadSupplyProduct.findById", query = "SELECT s FROM SadSupplyProduct s WHERE s.id = :id"),
    @NamedQuery(name = "SadSupplyProduct.findByCategoryIdPath", query = "SELECT s FROM SadSupplyProduct s WHERE s.categoryIdPath = :categoryIdPath"),
    @NamedQuery(name = "SadSupplyProduct.findByCategoryNamePath", query = "SELECT s FROM SadSupplyProduct s WHERE s.categoryNamePath = :categoryNamePath"),
    @NamedQuery(name = "SadSupplyProduct.findByCreateTime", query = "SELECT s FROM SadSupplyProduct s WHERE s.createTime = :createTime"),
    @NamedQuery(name = "SadSupplyProduct.findByCreator", query = "SELECT s FROM SadSupplyProduct s WHERE s.creator = :creator"),
    @NamedQuery(name = "SadSupplyProduct.findByDescription", query = "SELECT s FROM SadSupplyProduct s WHERE s.description = :description"),
    @NamedQuery(name = "SadSupplyProduct.findByDescriptionSegmentation", query = "SELECT s FROM SadSupplyProduct s WHERE s.descriptionSegmentation = :descriptionSegmentation"),
    @NamedQuery(name = "SadSupplyProduct.findByEnterpriseId", query = "SELECT s FROM SadSupplyProduct s WHERE s.enterpriseId = :enterpriseId"),
    @NamedQuery(name = "SadSupplyProduct.findByInformationValidDate", query = "SELECT s FROM SadSupplyProduct s WHERE s.informationValidDate = :informationValidDate"),
    @NamedQuery(name = "SadSupplyProduct.findByInventoryAmount", query = "SELECT s FROM SadSupplyProduct s WHERE s.inventoryAmount = :inventoryAmount"),
    @NamedQuery(name = "SadSupplyProduct.findByMinOrderAmount", query = "SELECT s FROM SadSupplyProduct s WHERE s.minOrderAmount = :minOrderAmount"),
    @NamedQuery(name = "SadSupplyProduct.findByPassed", query = "SELECT s FROM SadSupplyProduct s WHERE s.passed = :passed"),
    @NamedQuery(name = "SadSupplyProduct.findByPcpServices", query = "SELECT s FROM SadSupplyProduct s WHERE s.pcpServices = :pcpServices"),
    @NamedQuery(name = "SadSupplyProduct.findByPricingType", query = "SELECT s FROM SadSupplyProduct s WHERE s.pricingType = :pricingType"),
    @NamedQuery(name = "SadSupplyProduct.findByProductId", query = "SELECT s FROM SadSupplyProduct s WHERE s.productId = :productId"),
    @NamedQuery(name = "SadSupplyProduct.findByProductName", query = "SELECT s FROM SadSupplyProduct s WHERE s.productName = :productName"),
    @NamedQuery(name = "SadSupplyProduct.findByProductNameSegmentation", query = "SELECT s FROM SadSupplyProduct s WHERE s.productNameSegmentation = :productNameSegmentation"),
    @NamedQuery(name = "SadSupplyProduct.findBySorts", query = "SELECT s FROM SadSupplyProduct s WHERE s.sorts = :sorts"),
    @NamedQuery(name = "SadSupplyProduct.findByStatus", query = "SELECT s FROM SadSupplyProduct s WHERE s.status = :status"),
    @NamedQuery(name = "SadSupplyProduct.findByUpdateTime", query = "SELECT s FROM SadSupplyProduct s WHERE s.updateTime = :updateTime"),
    @NamedQuery(name = "SadSupplyProduct.findByUpdateUser", query = "SELECT s FROM SadSupplyProduct s WHERE s.updateUser = :updateUser")})
public class SadSupplyProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 60)
    @Column(name = "category_id_path")
    private String categoryIdPath;
    @Size(max = 100)
    @Column(name = "category_name_path")
    private String categoryNamePath;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Size(max = 20)
    @Column(name = "creator")
    private String creator;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "description_segmentation")
    private String descriptionSegmentation;
    @Column(name = "enterprise_id")
    private BigInteger enterpriseId;
    @Column(name = "information_valid_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date informationValidDate;
    @Column(name = "inventory_amount")
    private BigInteger inventoryAmount;
    @Column(name = "min_order_amount")
    private BigInteger minOrderAmount;
    @Column(name = "passed")
    private Boolean passed;
    @Column(name = "pcp_services")
    private Integer pcpServices;
    @Size(max = 32)
    @Column(name = "pricing_type")
    private String pricingType;
    @Column(name = "product_id")
    private BigInteger productId;
    @Size(max = 50)
    @Column(name = "product_name")
    private String productName;
    @Size(max = 255)
    @Column(name = "product_name_segmentation")
    private String productNameSegmentation;
    @Column(name = "sorts")
    private Integer sorts;
    @Column(name = "status")
    private Integer status;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Size(max = 30)
    @Column(name = "update_user")
    private String updateUser;

    public SadSupplyProduct() {
    }

    public SadSupplyProduct(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryIdPath() {
        return categoryIdPath;
    }

    public void setCategoryIdPath(String categoryIdPath) {
        this.categoryIdPath = categoryIdPath;
    }

    public String getCategoryNamePath() {
        return categoryNamePath;
    }

    public void setCategoryNamePath(String categoryNamePath) {
        this.categoryNamePath = categoryNamePath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionSegmentation() {
        return descriptionSegmentation;
    }

    public void setDescriptionSegmentation(String descriptionSegmentation) {
        this.descriptionSegmentation = descriptionSegmentation;
    }

    public BigInteger getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(BigInteger enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Date getInformationValidDate() {
        return informationValidDate;
    }

    public void setInformationValidDate(Date informationValidDate) {
        this.informationValidDate = informationValidDate;
    }

    public BigInteger getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(BigInteger inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }

    public BigInteger getMinOrderAmount() {
        return minOrderAmount;
    }

    public void setMinOrderAmount(BigInteger minOrderAmount) {
        this.minOrderAmount = minOrderAmount;
    }

    public Boolean getPassed() {
        return passed;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
    }

    public Integer getPcpServices() {
        return pcpServices;
    }

    public void setPcpServices(Integer pcpServices) {
        this.pcpServices = pcpServices;
    }

    public String getPricingType() {
        return pricingType;
    }

    public void setPricingType(String pricingType) {
        this.pricingType = pricingType;
    }

    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNameSegmentation() {
        return productNameSegmentation;
    }

    public void setProductNameSegmentation(String productNameSegmentation) {
        this.productNameSegmentation = productNameSegmentation;
    }

    public Integer getSorts() {
        return sorts;
    }

    public void setSorts(Integer sorts) {
        this.sorts = sorts;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
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
        if (!(object instanceof SadSupplyProduct)) {
            return false;
        }
        SadSupplyProduct other = (SadSupplyProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.product.SadSupplyProduct[ id=" + id + " ]";
    }
    
}
