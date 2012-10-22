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
@Table(name = "exhibition_info")
@NamedQueries({
    @NamedQuery(name = "ExhibitionInfo.findAll", query = "SELECT e FROM ExhibitionInfo e"),
    @NamedQuery(name = "ExhibitionInfo.findByExhibitionId", query = "SELECT e FROM ExhibitionInfo e WHERE e.exhibitionId = :exhibitionId"),
    @NamedQuery(name = "ExhibitionInfo.findByExhibitionTime", query = "SELECT e FROM ExhibitionInfo e WHERE e.exhibitionTime = :exhibitionTime"),
    @NamedQuery(name = "ExhibitionInfo.findByExhibitionArea", query = "SELECT e FROM ExhibitionInfo e WHERE e.exhibitionArea = :exhibitionArea"),
    @NamedQuery(name = "ExhibitionInfo.findByExhibitonTitle", query = "SELECT e FROM ExhibitionInfo e WHERE e.exhibitonTitle = :exhibitonTitle"),
    @NamedQuery(name = "ExhibitionInfo.findByExhibitionContent", query = "SELECT e FROM ExhibitionInfo e WHERE e.exhibitionContent = :exhibitionContent"),
    @NamedQuery(name = "ExhibitionInfo.findByCreator", query = "SELECT e FROM ExhibitionInfo e WHERE e.creator = :creator"),
    @NamedQuery(name = "ExhibitionInfo.findByUpdateUser", query = "SELECT e FROM ExhibitionInfo e WHERE e.updateUser = :updateUser"),
    @NamedQuery(name = "ExhibitionInfo.findByUpdateTime", query = "SELECT e FROM ExhibitionInfo e WHERE e.updateTime = :updateTime"),
    @NamedQuery(name = "ExhibitionInfo.findByCreateTime", query = "SELECT e FROM ExhibitionInfo e WHERE e.createTime = :createTime")})
public class ExhibitionInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "exhibition_id")
    private Long exhibitionId;
    @Column(name = "exhibition_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exhibitionTime;
    @Column(name = "exhibition_area")
    private Serializable exhibitionArea;
    @Size(max = 100)
    @Column(name = "exhibiton_title")
    private String exhibitonTitle;
    @Size(max = 200)
    @Column(name = "exhibition_content")
    private String exhibitionContent;
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

    public ExhibitionInfo() {
    }

    public ExhibitionInfo(Long exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    public Long getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(Long exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    public Date getExhibitionTime() {
        return exhibitionTime;
    }

    public void setExhibitionTime(Date exhibitionTime) {
        this.exhibitionTime = exhibitionTime;
    }

    public Serializable getExhibitionArea() {
        return exhibitionArea;
    }

    public void setExhibitionArea(Serializable exhibitionArea) {
        this.exhibitionArea = exhibitionArea;
    }

    public String getExhibitonTitle() {
        return exhibitonTitle;
    }

    public void setExhibitonTitle(String exhibitonTitle) {
        this.exhibitonTitle = exhibitonTitle;
    }

    public String getExhibitionContent() {
        return exhibitionContent;
    }

    public void setExhibitionContent(String exhibitionContent) {
        this.exhibitionContent = exhibitionContent;
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
        hash += (exhibitionId != null ? exhibitionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExhibitionInfo)) {
            return false;
        }
        ExhibitionInfo other = (ExhibitionInfo) object;
        if ((this.exhibitionId == null && other.exhibitionId != null) || (this.exhibitionId != null && !this.exhibitionId.equals(other.exhibitionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.service.common.ExhibitionInfo[ exhibitionId=" + exhibitionId + " ]";
    }
    
}
