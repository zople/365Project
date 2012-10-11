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
 * 系统数据字典
 */
@Entity
@Table(name = "tbl_system_datainfo")
@NamedQueries({
    @NamedQuery(name = "SystemDatainfo.findAll", query = "SELECT s FROM SystemDatainfo s"),
    @NamedQuery(name = "SystemDatainfo.findBySystemdataId", query = "SELECT s FROM SystemDatainfo s WHERE s.systemdataId = :systemdataId"),
    @NamedQuery(name = "SystemDatainfo.findByCname", query = "SELECT s FROM SystemDatainfo s WHERE s.cname = :cname"),
    @NamedQuery(name = "SystemDatainfo.findBySorts", query = "SELECT s FROM SystemDatainfo s WHERE s.sorts = :sorts"),
    @NamedQuery(name = "SystemDatainfo.findByCreator", query = "SELECT s FROM SystemDatainfo s WHERE s.creator = :creator"),
    @NamedQuery(name = "SystemDatainfo.findByUpdateUser", query = "SELECT s FROM SystemDatainfo s WHERE s.updateUser = :updateUser"),
    @NamedQuery(name = "SystemDatainfo.findByUpdateTime", query = "SELECT s FROM SystemDatainfo s WHERE s.updateTime = :updateTime"),
    @NamedQuery(name = "SystemDatainfo.findByCreateTime", query = "SELECT s FROM SystemDatainfo s WHERE s.createTime = :createTime")})
public class SystemDatainfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "systemdata_id")
    private Long systemdataId;
    @Size(max = 50)
    @Column(name = "cname")
    private String cname;
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

    public SystemDatainfo() {
    }

    public SystemDatainfo(Long systemdataId) {
        this.systemdataId = systemdataId;
    }

    public Long getSystemdataId() {
        return systemdataId;
    }

    public void setSystemdataId(Long systemdataId) {
        this.systemdataId = systemdataId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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
        hash += (systemdataId != null ? systemdataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SystemDatainfo)) {
            return false;
        }
        SystemDatainfo other = (SystemDatainfo) object;
        if ((this.systemdataId == null && other.systemdataId != null) || (this.systemdataId != null && !this.systemdataId.equals(other.systemdataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.SystemDatainfo[ systemdataId=" + systemdataId + " ]";
    }
    
}
