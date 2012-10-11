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
 * 角色权限
 */
@Entity
@Table(name = "tbl_rightsfor_rolesinfo")
@NamedQueries({
    @NamedQuery(name = "RoleAuthority.findAll", query = "SELECT r FROM RoleAuthority r"),
    @NamedQuery(name = "RoleAuthority.findById", query = "SELECT r FROM RoleAuthority r WHERE r.id = :id"),
    @NamedQuery(name = "RoleAuthority.findByRightType", query = "SELECT r FROM RoleAuthority r WHERE r.rightType = :rightType"),
    @NamedQuery(name = "RoleAuthority.findBySorts", query = "SELECT r FROM RoleAuthority r WHERE r.sorts = :sorts"),
    @NamedQuery(name = "RoleAuthority.findByCreator", query = "SELECT r FROM RoleAuthority r WHERE r.creator = :creator"),
    @NamedQuery(name = "RoleAuthority.findByUpdateUser", query = "SELECT r FROM RoleAuthority r WHERE r.updateUser = :updateUser"),
    @NamedQuery(name = "RoleAuthority.findByUpdateTime", query = "SELECT r FROM RoleAuthority r WHERE r.updateTime = :updateTime"),
    @NamedQuery(name = "RoleAuthority.findByCreateTime", query = "SELECT r FROM RoleAuthority r WHERE r.createTime = :createTime")})
public class RoleAuthority implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Column(name = "right_type")
    private Integer rightType;
    @Column(name = "sorts")
    private Integer sorts;
    @Size(max = 50)
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

    public RoleAuthority() {
    }

    public RoleAuthority(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRightType() {
        return rightType;
    }

    public void setRightType(Integer rightType) {
        this.rightType = rightType;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleAuthority)) {
            return false;
        }
        RoleAuthority other = (RoleAuthority) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.RoleAuthority[ id=" + id + " ]";
    }
    
}
