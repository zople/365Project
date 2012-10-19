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
@Table(name = "machining_picture")
@NamedQueries({
    @NamedQuery(name = "MachiningPicture.findAll", query = "SELECT m FROM MachiningPicture m"),
    @NamedQuery(name = "MachiningPicture.findByMachiningPicId", query = "SELECT m FROM MachiningPicture m WHERE m.machiningPicId = :machiningPicId"),
    @NamedQuery(name = "MachiningPicture.findByMerchantsInfoId", query = "SELECT m FROM MachiningPicture m WHERE m.merchantsInfoId = :merchantsInfoId"),
    @NamedQuery(name = "MachiningPicture.findByMachiningPath", query = "SELECT m FROM MachiningPicture m WHERE m.machiningPath = :machiningPath"),
    @NamedQuery(name = "MachiningPicture.findByCreator", query = "SELECT m FROM MachiningPicture m WHERE m.creator = :creator"),
    @NamedQuery(name = "MachiningPicture.findByUpdateUser", query = "SELECT m FROM MachiningPicture m WHERE m.updateUser = :updateUser"),
    @NamedQuery(name = "MachiningPicture.findByUpdateTime", query = "SELECT m FROM MachiningPicture m WHERE m.updateTime = :updateTime"),
    @NamedQuery(name = "MachiningPicture.findByCreateTime", query = "SELECT m FROM MachiningPicture m WHERE m.createTime = :createTime")})
public class MachiningPicture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "machining_pic_id")
    private Long machiningPicId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "merchants_info_id")
    private long merchantsInfoId;
    @Size(max = 100)
    @Column(name = "machining_path")
    private String machiningPath;
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

    public MachiningPicture() {
    }

    public MachiningPicture(Long machiningPicId) {
        this.machiningPicId = machiningPicId;
    }

    public MachiningPicture(Long machiningPicId, long merchantsInfoId) {
        this.machiningPicId = machiningPicId;
        this.merchantsInfoId = merchantsInfoId;
    }

    public Long getMachiningPicId() {
        return machiningPicId;
    }

    public void setMachiningPicId(Long machiningPicId) {
        this.machiningPicId = machiningPicId;
    }

    public long getMerchantsInfoId() {
        return merchantsInfoId;
    }

    public void setMerchantsInfoId(long merchantsInfoId) {
        this.merchantsInfoId = merchantsInfoId;
    }

    public String getMachiningPath() {
        return machiningPath;
    }

    public void setMachiningPath(String machiningPath) {
        this.machiningPath = machiningPath;
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
        hash += (machiningPicId != null ? machiningPicId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MachiningPicture)) {
            return false;
        }
        MachiningPicture other = (MachiningPicture) object;
        if ((this.machiningPicId == null && other.machiningPicId != null) || (this.machiningPicId != null && !this.machiningPicId.equals(other.machiningPicId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.service.common.MachiningPicture[ machiningPicId=" + machiningPicId + " ]";
    }
    
}
