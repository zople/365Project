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
@Table(name = "tbl_role_info")
@NamedQueries({
    @NamedQuery(name = "TblRoleInfo.findAll", query = "SELECT t FROM TblRoleInfo t"),
    @NamedQuery(name = "TblRoleInfo.findById", query = "SELECT t FROM TblRoleInfo t WHERE t.id = :id"),
    @NamedQuery(name = "TblRoleInfo.findByName", query = "SELECT t FROM TblRoleInfo t WHERE t.name = :name"),
    @NamedQuery(name = "TblRoleInfo.findByDescription", query = "SELECT t FROM TblRoleInfo t WHERE t.description = :description"),
    @NamedQuery(name = "TblRoleInfo.findBySorts", query = "SELECT t FROM TblRoleInfo t WHERE t.sorts = :sorts"),
    @NamedQuery(name = "TblRoleInfo.findByCreator", query = "SELECT t FROM TblRoleInfo t WHERE t.creator = :creator"),
    @NamedQuery(name = "TblRoleInfo.findByUpdateUser", query = "SELECT t FROM TblRoleInfo t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TblRoleInfo.findByUpdateTime", query = "SELECT t FROM TblRoleInfo t WHERE t.updateTime = :updateTime"),
    @NamedQuery(name = "TblRoleInfo.findByCreateTime", query = "SELECT t FROM TblRoleInfo t WHERE t.createTime = :createTime")})
public class TblRoleInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Size(max = 100)
    @Column(name = "description", length = 100)
    private String description;
    @Column(name = "sorts")
    private Integer sorts;
    @Size(max = 50)
    @Column(name = "creator", length = 50)
    private String creator;
    @Size(max = 50)
    @Column(name = "update_user", length = 50)
    private String updateUser;
    @Column(name = "update_time")
    @Temporal(TemporalType.DATE)
    private Date updateTime;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;

    public TblRoleInfo() {
    }

    public TblRoleInfo(Long id) {
        this.id = id;
    }

    public TblRoleInfo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof TblRoleInfo)) {
            return false;
        }
        TblRoleInfo other = (TblRoleInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.TblRoleInfo[ id=" + id + " ]";
    }
    
}
