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
@Table(name = "industry_news_picture")
@NamedQueries({
    @NamedQuery(name = "IndustryNewsPicture.findAll", query = "SELECT i FROM IndustryNewsPicture i"),
    @NamedQuery(name = "IndustryNewsPicture.findByIndustryNewsPictureId", query = "SELECT i FROM IndustryNewsPicture i WHERE i.industryNewsPictureId = :industryNewsPictureId"),
    @NamedQuery(name = "IndustryNewsPicture.findByPictureName", query = "SELECT i FROM IndustryNewsPicture i WHERE i.pictureName = :pictureName"),
    @NamedQuery(name = "IndustryNewsPicture.findByPicturePah", query = "SELECT i FROM IndustryNewsPicture i WHERE i.picturePah = :picturePah"),
    @NamedQuery(name = "IndustryNewsPicture.findByDescription", query = "SELECT i FROM IndustryNewsPicture i WHERE i.description = :description"),
    @NamedQuery(name = "IndustryNewsPicture.findByCreator", query = "SELECT i FROM IndustryNewsPicture i WHERE i.creator = :creator"),
    @NamedQuery(name = "IndustryNewsPicture.findByUpdateUser", query = "SELECT i FROM IndustryNewsPicture i WHERE i.updateUser = :updateUser"),
    @NamedQuery(name = "IndustryNewsPicture.findByUpdateTime", query = "SELECT i FROM IndustryNewsPicture i WHERE i.updateTime = :updateTime"),
    @NamedQuery(name = "IndustryNewsPicture.findByCreateTime", query = "SELECT i FROM IndustryNewsPicture i WHERE i.createTime = :createTime")})
public class IndustryNewsPicture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "industry_news_picture_id")
    private Long industryNewsPictureId;
    @Size(max = 20)
    @Column(name = "picture_name")
    private String pictureName;
    @Size(max = 100)
    @Column(name = "picture_pah")
    private String picturePah;
    @Size(max = 200)
    @Column(name = "description")
    private String description;
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

    public IndustryNewsPicture() {
    }

    public IndustryNewsPicture(Long industryNewsPictureId) {
        this.industryNewsPictureId = industryNewsPictureId;
    }

    public Long getIndustryNewsPictureId() {
        return industryNewsPictureId;
    }

    public void setIndustryNewsPictureId(Long industryNewsPictureId) {
        this.industryNewsPictureId = industryNewsPictureId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPicturePah() {
        return picturePah;
    }

    public void setPicturePah(String picturePah) {
        this.picturePah = picturePah;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (industryNewsPictureId != null ? industryNewsPictureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndustryNewsPicture)) {
            return false;
        }
        IndustryNewsPicture other = (IndustryNewsPicture) object;
        if ((this.industryNewsPictureId == null && other.industryNewsPictureId != null) || (this.industryNewsPictureId != null && !this.industryNewsPictureId.equals(other.industryNewsPictureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.service.common.IndustryNewsPicture[ industryNewsPictureId=" + industryNewsPictureId + " ]";
    }
    
}
