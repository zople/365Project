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
 * @author wangxiu
 * 组内用户 
 */
@Entity
@Table(name = "tbl_group_user")
@NamedQueries({
    @NamedQuery(name = "GroupUser.findAll", query = "SELECT g FROM GroupUser g"),
    @NamedQuery(name = "GroupUser.findByGroupUserId", query = "SELECT g FROM GroupUser g WHERE g.groupUserId = :groupUserId"),
    @NamedQuery(name = "GroupUser.findByGroupId", query = "SELECT g FROM GroupUser g WHERE g.groupId = :groupId"),
    @NamedQuery(name = "GroupUser.findByUserId", query = "SELECT g FROM GroupUser g WHERE g.userId = :userId"),
    @NamedQuery(name = "GroupUser.findBySorts", query = "SELECT g FROM GroupUser g WHERE g.sorts = :sorts"),
    @NamedQuery(name = "GroupUser.findByCreator", query = "SELECT g FROM GroupUser g WHERE g.creator = :creator"),
    @NamedQuery(name = "GroupUser.findByUpdateUser", query = "SELECT g FROM GroupUser g WHERE g.updateUser = :updateUser"),
    @NamedQuery(name = "GroupUser.findByUpdateTime", query = "SELECT g FROM GroupUser g WHERE g.updateTime = :updateTime"),
    @NamedQuery(name = "GroupUser.findByCreateTime", query = "SELECT g FROM GroupUser g WHERE g.createTime = :createTime")})
public class GroupUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_user_id")
    private Long groupUserId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_id")
    private long groupId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private long userId;
    @Column(name = "sorts")
    private Integer sorts;
    @Size(max = 100)
    @Column(name = "creator")
    private String creator;
    @Size(max = 50)
    @Column(name = "update_user")
    private String updateUser;
    @Column(name = "update_time")
    @Temporal(TemporalType.DATE)
    private Date updateTime;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;

    public GroupUser() {
    }

    public GroupUser(Long groupUserId) {
        this.groupUserId = groupUserId;
    }

    public GroupUser(Long groupUserId, long groupId, long userId) {
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

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
        hash += (groupUserId != null ? groupUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupUser)) {
            return false;
        }
        GroupUser other = (GroupUser) object;
        if ((this.groupUserId == null && other.groupUserId != null) || (this.groupUserId != null && !this.groupUserId.equals(other.groupUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.GroupUser[ groupUserId=" + groupUserId + " ]";
    }
    
}
