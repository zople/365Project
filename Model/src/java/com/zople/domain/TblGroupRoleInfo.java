/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tbl_group_role_info")
@NamedQueries({
    @NamedQuery(name = "TblGroupRoleInfo.findAll", query = "SELECT t FROM TblGroupRoleInfo t"),
    @NamedQuery(name = "TblGroupRoleInfo.findByGroupRolesId", query = "SELECT t FROM TblGroupRoleInfo t WHERE t.groupRolesId = :groupRolesId"),
    @NamedQuery(name = "TblGroupRoleInfo.findByCreateTime", query = "SELECT t FROM TblGroupRoleInfo t WHERE t.createTime = :createTime"),
    @NamedQuery(name = "TblGroupRoleInfo.findByCreator", query = "SELECT t FROM TblGroupRoleInfo t WHERE t.creator = :creator"),
    @NamedQuery(name = "TblGroupRoleInfo.findByGroupId", query = "SELECT t FROM TblGroupRoleInfo t WHERE t.groupId = :groupId"),
    @NamedQuery(name = "TblGroupRoleInfo.findByRoleId", query = "SELECT t FROM TblGroupRoleInfo t WHERE t.roleId = :roleId"),
    @NamedQuery(name = "TblGroupRoleInfo.findBySorts", query = "SELECT t FROM TblGroupRoleInfo t WHERE t.sorts = :sorts"),
    @NamedQuery(name = "TblGroupRoleInfo.findByUpdateTime", query = "SELECT t FROM TblGroupRoleInfo t WHERE t.updateTime = :updateTime"),
    @NamedQuery(name = "TblGroupRoleInfo.findByUpdateUser", query = "SELECT t FROM TblGroupRoleInfo t WHERE t.updateUser = :updateUser")})
public class TblGroupRoleInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_roles_id", nullable = false)
    private Long groupRolesId;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;
    @Size(max = 100)
    @Column(name = "creator", length = 100)
    private String creator;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "group_id", precision = 19, scale = 2)
    private BigDecimal groupId;
    @Column(name = "role_id", precision = 19, scale = 2)
    private BigDecimal roleId;
    @Column(name = "sorts")
    private Integer sorts;
    @Column(name = "update_time")
    @Temporal(TemporalType.DATE)
    private Date updateTime;
    @Size(max = 100)
    @Column(name = "update_user", length = 100)
    private String updateUser;

    public TblGroupRoleInfo() {
    }

    public TblGroupRoleInfo(Long groupRolesId) {
        this.groupRolesId = groupRolesId;
    }

    public Long getGroupRolesId() {
        return groupRolesId;
    }

    public void setGroupRolesId(Long groupRolesId) {
        this.groupRolesId = groupRolesId;
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

    public BigDecimal getGroupId() {
        return groupId;
    }

    public void setGroupId(BigDecimal groupId) {
        this.groupId = groupId;
    }

    public BigDecimal getRoleId() {
        return roleId;
    }

    public void setRoleId(BigDecimal roleId) {
        this.roleId = roleId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupRolesId != null ? groupRolesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblGroupRoleInfo)) {
            return false;
        }
        TblGroupRoleInfo other = (TblGroupRoleInfo) object;
        if ((this.groupRolesId == null && other.groupRolesId != null) || (this.groupRolesId != null && !this.groupRolesId.equals(other.groupRolesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.TblGroupRoleInfo[ groupRolesId=" + groupRolesId + " ]";
    }
    
}
