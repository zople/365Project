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
 * @author 王文彦
 */
@Entity
@Table(name = "tbl_dataitems_info")
@NamedQueries({
    @NamedQuery(name = "TblDataitemsInfo.findAll", query = "SELECT t FROM TblDataitemsInfo t"),
    @NamedQuery(name = "TblDataitemsInfo.findByDataitemsId", query = "SELECT t FROM TblDataitemsInfo t WHERE t.dataitemsId = :dataitemsId"),
    @NamedQuery(name = "TblDataitemsInfo.findBySystemdataId", query = "SELECT t FROM TblDataitemsInfo t WHERE t.systemdataId = :systemdataId"),
    @NamedQuery(name = "TblDataitemsInfo.findByCname", query = "SELECT t FROM TblDataitemsInfo t WHERE t.cname = :cname"),
    @NamedQuery(name = "TblDataitemsInfo.findByDataValue", query = "SELECT t FROM TblDataitemsInfo t WHERE t.dataValue = :dataValue"),
    @NamedQuery(name = "TblDataitemsInfo.findBySorts", query = "SELECT t FROM TblDataitemsInfo t WHERE t.sorts = :sorts"),
    @NamedQuery(name = "TblDataitemsInfo.findByCreator", query = "SELECT t FROM TblDataitemsInfo t WHERE t.creator = :creator"),
    @NamedQuery(name = "TblDataitemsInfo.findByUpdateUser", query = "SELECT t FROM TblDataitemsInfo t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TblDataitemsInfo.findByUpdateTime", query = "SELECT t FROM TblDataitemsInfo t WHERE t.updateTime = :updateTime"),
    @NamedQuery(name = "TblDataitemsInfo.findByCreateTime", query = "SELECT t FROM TblDataitemsInfo t WHERE t.createTime = :createTime")})
public class TblDataitemsInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataitems_id", nullable = false)
    private Long dataitemsId;
    @Column(name = "systemdata_id")
    private BigInteger systemdataId;
    @Size(max = 50)
    @Column(name = "cname", length = 50)
    private String cname;
    @Size(max = 100)
    @Column(name = "data_value", length = 100)
    private String dataValue;
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

    public TblDataitemsInfo() {
    }

    public TblDataitemsInfo(Long dataitemsId) {
        this.dataitemsId = dataitemsId;
    }

    public Long getDataitemsId() {
        return dataitemsId;
    }

    public void setDataitemsId(Long dataitemsId) {
        this.dataitemsId = dataitemsId;
    }

    public BigInteger getSystemdataId() {
        return systemdataId;
    }

    public void setSystemdataId(BigInteger systemdataId) {
        this.systemdataId = systemdataId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
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
        hash += (dataitemsId != null ? dataitemsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDataitemsInfo)) {
            return false;
        }
        TblDataitemsInfo other = (TblDataitemsInfo) object;
        if ((this.dataitemsId == null && other.dataitemsId != null) || (this.dataitemsId != null && !this.dataitemsId.equals(other.dataitemsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.TblDataitemsInfo[ dataitemsId=" + dataitemsId + " ]";
    }
    
}
