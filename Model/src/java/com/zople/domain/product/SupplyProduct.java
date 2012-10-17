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
 * @author 王文彦
 */
@Entity
@Table(name = "sad_supply_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplyProduct.findAll", query = "SELECT s FROM SupplyProduct s"),
    @NamedQuery(name = "SupplyProduct.findById", query = "SELECT s FROM SupplyProduct s WHERE s.id = :id"),
    @NamedQuery(name = "SupplyProduct.findByEnterpriseId", query = "SELECT s FROM SupplyProduct s WHERE s.enterpriseId = :enterpriseId"),
    @NamedQuery(name = "SupplyProduct.findByProductId", query = "SELECT s FROM SupplyProduct s WHERE s.productId = :productId"),
    @NamedQuery(name = "SupplyProduct.findByProductName", query = "SELECT s FROM SupplyProduct s WHERE s.productName = :productName"),
    @NamedQuery(name = "SupplyProduct.findByProductNameSegmentation", query = "SELECT s FROM SupplyProduct s WHERE s.productNameSegmentation = :productNameSegmentation"),
    @NamedQuery(name = "SupplyProduct.findByCategoryIdPath", query = "SELECT s FROM SupplyProduct s WHERE s.categoryIdPath = :categoryIdPath"),
    @NamedQuery(name = "SupplyProduct.findByCategoryNamePath", query = "SELECT s FROM SupplyProduct s WHERE s.categoryNamePath = :categoryNamePath"),
    @NamedQuery(name = "SupplyProduct.findByPassed", query = "SELECT s FROM SupplyProduct s WHERE s.passed = :passed"),
    @NamedQuery(name = "SupplyProduct.findByDescription", query = "SELECT s FROM SupplyProduct s WHERE s.description = :description"),
    @NamedQuery(name = "SupplyProduct.findByDescriptionSegmentation", query = "SELECT s FROM SupplyProduct s WHERE s.descriptionSegmentation = :descriptionSegmentation"),
    @NamedQuery(name = "SupplyProduct.findByMinOrderAmount", query = "SELECT s FROM SupplyProduct s WHERE s.minOrderAmount = :minOrderAmount"),
    @NamedQuery(name = "SupplyProduct.findByInventoryAmount", query = "SELECT s FROM SupplyProduct s WHERE s.inventoryAmount = :inventoryAmount"),
    @NamedQuery(name = "SupplyProduct.findByInformationValidDate", query = "SELECT s FROM SupplyProduct s WHERE s.informationValidDate = :informationValidDate"),
    @NamedQuery(name = "SupplyProduct.findByPcpServices", query = "SELECT s FROM SupplyProduct s WHERE s.pcpServices = :pcpServices"),
    @NamedQuery(name = "SupplyProduct.findByPricingType", query = "SELECT s FROM SupplyProduct s WHERE s.pricingType = :pricingType"),
    @NamedQuery(name = "SupplyProduct.findByStatus", query = "SELECT s FROM SupplyProduct s WHERE s.status = :status"),
    @NamedQuery(name = "SupplyProduct.findBySorts", query = "SELECT s FROM SupplyProduct s WHERE s.sorts = :sorts"),
    @NamedQuery(name = "SupplyProduct.findByCreator", query = "SELECT s FROM SupplyProduct s WHERE s.creator = :creator"),
    @NamedQuery(name = "SupplyProduct.findByUpdateUser", query = "SELECT s FROM SupplyProduct s WHERE s.updateUser = :updateUser"),
    @NamedQuery(name = "SupplyProduct.findByCreateTime", query = "SELECT s FROM SupplyProduct s WHERE s.createTime = :createTime"),
    @NamedQuery(name = "SupplyProduct.findByUpdateTime", query = "SELECT s FROM SupplyProduct s WHERE s.updateTime = :updateTime")})
public class SupplyProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Column(name = "enterprise_id")
    private BigInteger enterpriseId;
    @Column(name = "product_id")
    private BigInteger productId;
    @Size(max = 50)
    @Column(name = "product_name")
    private String productName;
    @Size(max = 2147483647)
    @Column(name = "product_name_segmentation")
    private String productNameSegmentation;
    @Size(max = 60)
    @Column(name = "category_id_path")
    private String categoryIdPath;
    @Size(max = 100)
    @Column(name = "category_name_path")
    private String categoryNamePath;
    @Column(name = "passed")
    private Boolean passed;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Size(max = 2147483647)
    @Column(name = "description_segmentation")
    private String descriptionSegmentation;
    @Column(name = "min_order_amount")
    private Long minOrderAmount;
    @Column(name = "inventory_amount")
    private Long inventoryAmount;
    @Column(name = "information_valid_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date informationValidDate;
    @Column(name = "pcp_services")
    private Integer pcpServices;
    @Size(max = 32)
    @Column(name = "pricing_type")
    private String pricingType;
    @Column(name = "status")
    private Integer status;
    @Column(name = "sorts")
    private Integer sorts;
    @Size(max = 20)
    @Column(name = "creator")
    private String creator;
    @Size(max = 30)
    @Column(name = "update_user")
    private String updateUser;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public SupplyProduct() {
    }

    public SupplyProduct(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(BigInteger enterpriseId) {
        this.enterpriseId = enterpriseId;
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

    public Boolean getPassed() {
        return passed;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
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

    public Long getMinOrderAmount() {
        return minOrderAmount;
    }

    public void setMinOrderAmount(Long minOrderAmount) {
        this.minOrderAmount = minOrderAmount;
    }

    public Long getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(Long inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }

    public Date getInformationValidDate() {
        return informationValidDate;
    }

    public void setInformationValidDate(Date informationValidDate) {
        this.informationValidDate = informationValidDate;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSorts() {
        return sorts;
    }

    public void setSorts(Integer sorts) {
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
        if (!(object instanceof SupplyProduct)) {
            return false;
        }
        SupplyProduct other = (SupplyProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.product.SupplyProduct[ id=" + id + " ]";
    }
    
}
