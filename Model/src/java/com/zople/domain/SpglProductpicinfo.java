/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

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
@Table(name = "spgl_productpicinfo")
@NamedQueries({
    @NamedQuery(name = "SpglProductpicinfo.findAll", query = "SELECT s FROM SpglProductpicinfo s"),
    @NamedQuery(name = "SpglProductpicinfo.findById", query = "SELECT s FROM SpglProductpicinfo s WHERE s.id = :id"),
    @NamedQuery(name = "SpglProductpicinfo.findByProductId", query = "SELECT s FROM SpglProductpicinfo s WHERE s.productId = :productId"),
    @NamedQuery(name = "SpglProductpicinfo.findByPicName", query = "SELECT s FROM SpglProductpicinfo s WHERE s.picName = :picName"),
    @NamedQuery(name = "SpglProductpicinfo.findByPicPath", query = "SELECT s FROM SpglProductpicinfo s WHERE s.picPath = :picPath"),
    @NamedQuery(name = "SpglProductpicinfo.findBySorts", query = "SELECT s FROM SpglProductpicinfo s WHERE s.sorts = :sorts"),
    @NamedQuery(name = "SpglProductpicinfo.findByCreator", query = "SELECT s FROM SpglProductpicinfo s WHERE s.creator = :creator"),
    @NamedQuery(name = "SpglProductpicinfo.findByUpdateUser", query = "SELECT s FROM SpglProductpicinfo s WHERE s.updateUser = :updateUser"),
    @NamedQuery(name = "SpglProductpicinfo.findByUpdateTime", query = "SELECT s FROM SpglProductpicinfo s WHERE s.updateTime = :updateTime"),
    @NamedQuery(name = "SpglProductpicinfo.findByCreateTime", query = "SELECT s FROM SpglProductpicinfo s WHERE s.createTime = :createTime")})
public class SpglProductpicinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "product_id")
    private BigInteger productId;
    @Size(max = 32)
    @Column(name = "pic_name", length = 32)
    private String picName;
    @Size(max = 32)
    @Column(name = "pic_path", length = 32)
    private String picPath;
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

    public SpglProductpicinfo() {
    }

    public SpglProductpicinfo(Long id) {
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

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
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
        if (!(object instanceof SpglProductpicinfo)) {
            return false;
        }
        SpglProductpicinfo other = (SpglProductpicinfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.SpglProductpicinfo[ id=" + id + " ]";
    }
    
}
