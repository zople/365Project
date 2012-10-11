/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

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
 * @author 王文彦
 */
@Entity
@Table(name = "tbl_group_user")
@NamedQueries({
    @NamedQuery(name = "TblGroupUser.findAll", query = "SELECT t FROM TblGroupUser t"),
    @NamedQuery(name = "TblGroupUser.findByGroupUserId", query = "SELECT t FROM TblGroupUser t WHERE t.groupUserId = :groupUserId"),
    @NamedQuery(name = "TblGroupUser.findByCreateTime", query = "SELECT t FROM TblGroupUser t WHERE t.createTime = :createTime"),
    @NamedQuery(name = "TblGroupUser.findByCreator", query = "SELECT t FROM TblGroupUser t WHERE t.creator = :creator"),
    @NamedQuery(name = "TblGroupUser.findByGroupId", query = "SELECT t FROM TblGroupUser t WHERE t.groupId = :groupId"),
    @NamedQuery(name = "TblGroupUser.findBySorts", query = "SELECT t FROM TblGroupUser t WHERE t.sorts = :sorts"),
    @NamedQuery(name = "TblGroupUser.findByUpdateTime", query = "SELECT t FROM TblGroupUser t WHERE t.updateTime = :updateTime"),
    @NamedQuery(name = "TblGroupUser.findByUpdateUser", query = "SELECT t FROM TblGroupUser t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TblGroupUser.findByUserId", query = "SELECT t FROM TblGroupUser t WHERE t.userId = :userId")})
public class TblGroupUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_user_id", nullable = false)
    private Long groupUserId;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;
    @Size(max = 100)
    @Column(name = "creator", length = 100)
    private String creator;
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_id", nullable = false)
    private long groupId;
    @Column(name = "sorts")
    private Integer sorts;
    @Column(name = "update_time")
    @Temporal(TemporalType.DATE)
    private Date updateTime;
    @Size(max = 50)
    @Column(name = "update_user", length = 50)
    private String updateUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id", nullable = false)
    private long userId;

    public TblGroupUser() {
    }

    public TblGroupUser(Long groupUserId) {
        this.groupUserId = groupUserId;
    }

    public TblGroupUser(Long groupUserId, long groupId, long userId) {
        this.groupUserId = groupUserId;
        this.groupId = groupId;
        this.userId = userId;
    }

    public Long getGroupUserId() {
        return groupUserId;
    }

    public void setGroupUserId(Long groupUserId) {
        this.groupUserId = groupUserId;
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

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public Integer getSorts() {
        return sorts;
    }

    public void setSorts(Integer sorts) {
        this.sorts = sorts;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupUserId != null ? groupUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblGroupUser)) {
            return false;
        }
        TblGroupUser other = (TblGroupUser) object;
        if ((this.groupUserId == null && other.groupUserId != null) || (this.groupUserId != null && !this.groupUserId.equals(other.groupUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.TblGroupUser[ groupUserId=" + groupUserId + " ]";
    }
    
}
