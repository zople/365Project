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
@Table(name = "merchants_picture")
@NamedQueries({
    @NamedQuery(name = "MerchantsPicture.findAll", query = "SELECT m FROM MerchantsPicture m"),
    @NamedQuery(name = "MerchantsPicture.findByMerhantePictureId", query = "SELECT m FROM MerchantsPicture m WHERE m.merhantePictureId = :merhantePictureId"),
    @NamedQuery(name = "MerchantsPicture.findByMerchantsInfoId", query = "SELECT m FROM MerchantsPicture m WHERE m.merchantsInfoId = :merchantsInfoId"),
    @NamedQuery(name = "MerchantsPicture.findByMerchantsPath", query = "SELECT m FROM MerchantsPicture m WHERE m.merchantsPath = :merchantsPath"),
    @NamedQuery(name = "MerchantsPicture.findByCreator", query = "SELECT m FROM MerchantsPicture m WHERE m.creator = :creator"),
    @NamedQuery(name = "MerchantsPicture.findByUpdateUser", query = "SELECT m FROM MerchantsPicture m WHERE m.updateUser = :updateUser"),
    @NamedQuery(name = "MerchantsPicture.findByUpdateTime", query = "SELECT m FROM MerchantsPicture m WHERE m.updateTime = :updateTime"),
    @NamedQuery(name = "MerchantsPicture.findByCreateTime", query = "SELECT m FROM MerchantsPicture m WHERE m.createTime = :createTime")})
public class MerchantsPicture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "merhante_picture_id")
    private Long merhantePictureId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "merchants_info_id")
    private long merchantsInfoId;
    @Size(max = 100)
    @Column(name = "merchants_path")
    private String merchantsPath;
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

    public MerchantsPicture() {
    }

    public MerchantsPicture(Long merhantePictureId) {
        this.merhantePictureId = merhantePictureId;
    }

    public MerchantsPicture(Long merhantePictureId, long merchantsInfoId) {
        this.merhantePictureId = merhantePictureId;
        this.merchantsInfoId = merchantsInfoId;
    }

    public Long getMerhantePictureId() {
        return merhantePictureId;
    }

    public void setMerhantePictureId(Long merhantePictureId) {
        this.merhantePictureId = merhantePictureId;
    }

    public long getMerchantsInfoId() {
        return merchantsInfoId;
    }

    public void setMerchantsInfoId(long merchantsInfoId) {
        this.merchantsInfoId = merchantsInfoId;
    }

    public String getMerchantsPath() {
        return merchantsPath;
    }

    public void setMerchantsPath(String merchantsPath) {
        this.merchantsPath = merchantsPath;
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
        hash += (merhantePictureId != null ? merhantePictureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MerchantsPicture)) {
            return false;
        }
        MerchantsPicture other = (MerchantsPicture) object;
        if ((this.merhantePictureId == null && other.merhantePictureId != null) || (this.merhantePictureId != null && !this.merhantePictureId.equals(other.merhantePictureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.service.common.MerchantsPicture[ merhantePictureId=" + merhantePictureId + " ]";
    }
    
}
