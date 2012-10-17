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

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "spgl_productCategory")
@NamedQueries({
    @NamedQuery(name = "SpglproductCategory.findAll", query = "SELECT s FROM SpglproductCategory s"),
    @NamedQuery(name = "SpglproductCategory.findById", query = "SELECT s FROM SpglproductCategory s WHERE s.id = :id"),
    @NamedQuery(name = "SpglproductCategory.findByProductId", query = "SELECT s FROM SpglproductCategory s WHERE s.productId = :productId"),
    @NamedQuery(name = "SpglproductCategory.findByCateId", query = "SELECT s FROM SpglproductCategory s WHERE s.cateId = :cateId"),
    @NamedQuery(name = "SpglproductCategory.findByCatetypeId", query = "SELECT s FROM SpglproductCategory s WHERE s.catetypeId = :catetypeId"),
    @NamedQuery(name = "SpglproductCategory.findBySorts", query = "SELECT s FROM SpglproductCategory s WHERE s.sorts = :sorts"),
    @NamedQuery(name = "SpglproductCategory.findByCreator", query = "SELECT s FROM SpglproductCategory s WHERE s.creator = :creator"),
    @NamedQuery(name = "SpglproductCategory.findByUpdateUser", query = "SELECT s FROM SpglproductCategory s WHERE s.updateUser = :updateUser"),
    @NamedQuery(name = "SpglproductCategory.findByCreateTime", query = "SELECT s FROM SpglproductCategory s WHERE s.createTime = :createTime"),
    @NamedQuery(name = "SpglproductCategory.findByUpdateTime", query = "SELECT s FROM SpglproductCategory s WHERE s.updateTime = :updateTime")})
public class SpglproductCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "product_id")
    private BigInteger productId;
    @Column(name = "cate_id")
    private BigInteger cateId;
    @Column(name = "catetype_id")
    private BigInteger catetypeId;
    @Column(name = "sorts")
    private Short sorts;
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

    public SpglproductCategory() {
    }

    public SpglproductCategory(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    public BigInteger getCateId() {
        return cateId;
    }

    public void setCateId(BigInteger cateId) {
        this.cateId = cateId;
    }

    public BigInteger getCatetypeId() {
        return catetypeId;
    }

    public void setCatetypeId(BigInteger catetypeId) {
        this.catetypeId = catetypeId;
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
        if (!(object instanceof SpglproductCategory)) {
            return false;
        }
        SpglproductCategory other = (SpglproductCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.SpglproductCategory[ id=" + id + " ]";
    }
    
}
