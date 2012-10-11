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
@Table(name = "tbl_system_datainfo")
@NamedQueries({
    @NamedQuery(name = "TblSystemDatainfo.findAll", query = "SELECT t FROM TblSystemDatainfo t"),
    @NamedQuery(name = "TblSystemDatainfo.findBySystemdataId", query = "SELECT t FROM TblSystemDatainfo t WHERE t.systemdataId = :systemdataId"),
    @NamedQuery(name = "TblSystemDatainfo.findByCname", query = "SELECT t FROM TblSystemDatainfo t WHERE t.cname = :cname"),
    @NamedQuery(name = "TblSystemDatainfo.findBySorts", query = "SELECT t FROM TblSystemDatainfo t WHERE t.sorts = :sorts"),
    @NamedQuery(name = "TblSystemDatainfo.findByCreator", query = "SELECT t FROM TblSystemDatainfo t WHERE t.creator = :creator"),
    @NamedQuery(name = "TblSystemDatainfo.findByUpdateUser", query = "SELECT t FROM TblSystemDatainfo t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TblSystemDatainfo.findByUpdateTime", query = "SELECT t FROM TblSystemDatainfo t WHERE t.updateTime = :updateTime"),
    @NamedQuery(name = "TblSystemDatainfo.findByCreateTime", query = "SELECT t FROM TblSystemDatainfo t WHERE t.createTime = :createTime")})
public class TblSystemDatainfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "systemdata_id", nullable = false)
    private Long systemdataId;
    @Size(max = 50)
    @Column(name = "cname", length = 50)
    private String cname;
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

    public TblSystemDatainfo() {
    }

    public TblSystemDatainfo(Long systemdataId) {
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
        if (!(object instanceof TblSystemDatainfo)) {
            return false;
        }
        TblSystemDatainfo other = (TblSystemDatainfo) object;
        if ((this.systemdataId == null && other.systemdataId != null) || (this.systemdataId != null && !this.systemdataId.equals(other.systemdataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.TblSystemDatainfo[ systemdataId=" + systemdataId + " ]";
    }
    
}
