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
 * @author wangxiu
 * 组角色
 */
@Entity
@Table(name = "tbl_group_role_info")
@NamedQueries({
    @NamedQuery(name = "GroupRoleInfo.findAll", query = "SELECT g FROM GroupRoleInfo g"),
    @NamedQuery(name = "GroupRoleInfo.findByGroupRolesId", query = "SELECT g FROM GroupRoleInfo g WHERE g.groupRolesId = :groupRolesId"),
    @NamedQuery(name = "GroupRoleInfo.findByGroupId", query = "SELECT g FROM GroupRoleInfo g WHERE g.groupId = :groupId"),
    @NamedQuery(name = "GroupRoleInfo.findByRoleId", query = "SELECT g FROM GroupRoleInfo g WHERE g.roleId = :roleId"),
    @NamedQuery(name = "GroupRoleInfo.findBySorts", query = "SELECT g FROM GroupRoleInfo g WHERE g.sorts = :sorts"),
    @NamedQuery(name = "GroupRoleInfo.findByCreator", query = "SELECT g FROM GroupRoleInfo g WHERE g.creator = :creator"),
    @NamedQuery(name = "GroupRoleInfo.findByUpdateUser", query = "SELECT g FROM GroupRoleInfo g WHERE g.updateUser = :updateUser"),
    @NamedQuery(name = "GroupRoleInfo.findByUpdateTime", query = "SELECT g FROM GroupRoleInfo g WHERE g.updateTime = :updateTime"),
    @NamedQuery(name = "GroupRoleInfo.findByCreateTime", query = "SELECT g FROM GroupRoleInfo g WHERE g.createTime = :createTime")})
public class GroupRoleInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_roles_id")
    private Long groupRolesId;
    @Column(name = "group_id")
    private BigInteger groupId;
    @Column(name = "role_id")
    private BigInteger roleId;
    @Column(name = "sorts")
    private Integer sorts;
    @Size(max = 100)
    @Column(name = "creator")
    private String creator;
    @Size(max = 100)
    @Column(name = "update_user")
    private String updateUser;
    @Column(name = "update_time")
    @Temporal(TemporalType.DATE)
    private Date updateTime;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;

    public GroupRoleInfo() {
    }

    public GroupRoleInfo(Long groupRolesId) {
        this.groupRolesId = groupRolesId;
    }

    public Long getGroupRolesId() {
        return groupRolesId;
    }

    public void setGroupRolesId(Long groupRolesId) {
        this.groupRolesId = groupRolesId;
    }

    public BigInteger getGroupId() {
        return groupId;
    }

    public void setGroupId(BigInteger groupId) {
        this.groupId = groupId;
    }

    public BigInteger getRoleId() {
        return roleId;
    }

    public void setRoleId(BigInteger roleId) {
        this.roleId = roleId;
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
        hash += (groupRolesId != null ? groupRolesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupRoleInfo)) {
            return false;
        }
        GroupRoleInfo other = (GroupRoleInfo) object;
        if ((this.groupRolesId == null && other.groupRolesId != null) || (this.groupRolesId != null && !this.groupRolesId.equals(other.groupRolesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.GroupRoleInfo[ groupRolesId=" + groupRolesId + " ]";
    }
    
}
