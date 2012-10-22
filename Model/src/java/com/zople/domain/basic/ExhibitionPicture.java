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
@Table(name = "exhibition_picture")
@NamedQueries({
    @NamedQuery(name = "ExhibitionPicture.findAll", query = "SELECT e FROM ExhibitionPicture e"),
    @NamedQuery(name = "ExhibitionPicture.findByExhibitionPictureId", query = "SELECT e FROM ExhibitionPicture e WHERE e.exhibitionPictureId = :exhibitionPictureId"),
    @NamedQuery(name = "ExhibitionPicture.findByPictureName", query = "SELECT e FROM ExhibitionPicture e WHERE e.pictureName = :pictureName"),
    @NamedQuery(name = "ExhibitionPicture.findByPicturePath", query = "SELECT e FROM ExhibitionPicture e WHERE e.picturePath = :picturePath"),
    @NamedQuery(name = "ExhibitionPicture.findByDescription", query = "SELECT e FROM ExhibitionPicture e WHERE e.description = :description"),
    @NamedQuery(name = "ExhibitionPicture.findByCreator", query = "SELECT e FROM ExhibitionPicture e WHERE e.creator = :creator"),
    @NamedQuery(name = "ExhibitionPicture.findByUpdateUser", query = "SELECT e FROM ExhibitionPicture e WHERE e.updateUser = :updateUser"),
    @NamedQuery(name = "ExhibitionPicture.findByUpdateTime", query = "SELECT e FROM ExhibitionPicture e WHERE e.updateTime = :updateTime"),
    @NamedQuery(name = "ExhibitionPicture.findByCreateTime", query = "SELECT e FROM ExhibitionPicture e WHERE e.createTime = :createTime")})
public class ExhibitionPicture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "exhibition_picture_id")
    private Long exhibitionPictureId;
    @Size(max = 50)
    @Column(name = "picture_name")
    private String pictureName;
    @Size(max = 100)
    @Column(name = "picture_path")
    private String picturePath;
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

    public ExhibitionPicture() {
    }

    public ExhibitionPicture(Long exhibitionPictureId) {
        this.exhibitionPictureId = exhibitionPictureId;
    }

    public Long getExhibitionPictureId() {
        return exhibitionPictureId;
    }

    public void setExhibitionPictureId(Long exhibitionPictureId) {
        this.exhibitionPictureId = exhibitionPictureId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
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
        hash += (exhibitionPictureId != null ? exhibitionPictureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExhibitionPicture)) {
            return false;
        }
        ExhibitionPicture other = (ExhibitionPicture) object;
        if ((this.exhibitionPictureId == null && other.exhibitionPictureId != null) || (this.exhibitionPictureId != null && !this.exhibitionPictureId.equals(other.exhibitionPictureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.service.common.ExhibitionPicture[ exhibitionPictureId=" + exhibitionPictureId + " ]";
    }
    
}
