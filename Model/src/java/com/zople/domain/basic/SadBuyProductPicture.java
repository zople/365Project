/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain.basic;

import java.io.Serializable;
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
@Table(name = "sad_buy_product_picture")
@NamedQueries({
    @NamedQuery(name = "SadBuyProductPicture.findAll", query = "SELECT s FROM SadBuyProductPicture s"),
    @NamedQuery(name = "SadBuyProductPicture.findByBuyProductPicId", query = "SELECT s FROM SadBuyProductPicture s WHERE s.buyProductPicId = :buyProductPicId"),
    @NamedQuery(name = "SadBuyProductPicture.findByPicName", query = "SELECT s FROM SadBuyProductPicture s WHERE s.picName = :picName"),
    @NamedQuery(name = "SadBuyProductPicture.findByPicPath", query = "SELECT s FROM SadBuyProductPicture s WHERE s.picPath = :picPath"),
    @NamedQuery(name = "SadBuyProductPicture.findByBuyProductId", query = "SELECT s FROM SadBuyProductPicture s WHERE s.buyProductId = :buyProductId"),
    @NamedQuery(name = "SadBuyProductPicture.findByCreator", query = "SELECT s FROM SadBuyProductPicture s WHERE s.creator = :creator"),
    @NamedQuery(name = "SadBuyProductPicture.findByUpdateUser", query = "SELECT s FROM SadBuyProductPicture s WHERE s.updateUser = :updateUser"),
    @NamedQuery(name = "SadBuyProductPicture.findByUpdateTime", query = "SELECT s FROM SadBuyProductPicture s WHERE s.updateTime = :updateTime"),
    @NamedQuery(name = "SadBuyProductPicture.findByCreateTime", query = "SELECT s FROM SadBuyProductPicture s WHERE s.createTime = :createTime")})
public class SadBuyProductPicture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "buy_product_pic_id")
    private Long buyProductPicId;
    @Size(max = 50)
    @Column(name = "pic_name")
    private String picName;
    @Size(max = 100)
    @Column(name = "pic_path")
    private String picPath;
    @Basic(optional = false)
    @NotNull
    @Column(name = "buy_product_id")
    private long buyProductId;
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

    public SadBuyProductPicture() {
    }

    public SadBuyProductPicture(Long buyProductPicId) {
        this.buyProductPicId = buyProductPicId;
    }

    public SadBuyProductPicture(Long buyProductPicId, long buyProductId) {
        this.buyProductPicId = buyProductPicId;
        this.buyProductId = buyProductId;
    }

    public Long getBuyProductPicId() {
        return buyProductPicId;
    }

    public void setBuyProductPicId(Long buyProductPicId) {
        this.buyProductPicId = buyProductPicId;
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

    public long getBuyProductId() {
        return buyProductId;
    }

    public void setBuyProductId(long buyProductId) {
        this.buyProductId = buyProductId;
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
        hash += (buyProductPicId != null ? buyProductPicId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SadBuyProductPicture)) {
            return false;
        }
        SadBuyProductPicture other = (SadBuyProductPicture) object;
        if ((this.buyProductPicId == null && other.buyProductPicId != null) || (this.buyProductPicId != null && !this.buyProductPicId.equals(other.buyProductPicId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.service.common.SadBuyProductPicture[ buyProductPicId=" + buyProductPicId + " ]";
    }
    
}
