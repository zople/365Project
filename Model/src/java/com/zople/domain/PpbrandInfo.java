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
@Table(name = "pp_brandInfo")
@NamedQueries({
    @NamedQuery(name = "PpbrandInfo.findAll", query = "SELECT p FROM PpbrandInfo p"),
    @NamedQuery(name = "PpbrandInfo.findById", query = "SELECT p FROM PpbrandInfo p WHERE p.id = :id"),
    @NamedQuery(name = "PpbrandInfo.findByPcode", query = "SELECT p FROM PpbrandInfo p WHERE p.pcode = :pcode"),
    @NamedQuery(name = "PpbrandInfo.findByName", query = "SELECT p FROM PpbrandInfo p WHERE p.name = :name"),
    @NamedQuery(name = "PpbrandInfo.findByBrandcode", query = "SELECT p FROM PpbrandInfo p WHERE p.brandcode = :brandcode"),
    @NamedQuery(name = "PpbrandInfo.findByEname", query = "SELECT p FROM PpbrandInfo p WHERE p.ename = :ename"),
    @NamedQuery(name = "PpbrandInfo.findByLogopic", query = "SELECT p FROM PpbrandInfo p WHERE p.logopic = :logopic"),
    @NamedQuery(name = "PpbrandInfo.findByRemark", query = "SELECT p FROM PpbrandInfo p WHERE p.remark = :remark"),
    @NamedQuery(name = "PpbrandInfo.findBySorts", query = "SELECT p FROM PpbrandInfo p WHERE p.sorts = :sorts"),
    @NamedQuery(name = "PpbrandInfo.findByCreator", query = "SELECT p FROM PpbrandInfo p WHERE p.creator = :creator"),
    @NamedQuery(name = "PpbrandInfo.findByUpdateUser", query = "SELECT p FROM PpbrandInfo p WHERE p.updateUser = :updateUser"),
    @NamedQuery(name = "PpbrandInfo.findByCreateTime", query = "SELECT p FROM PpbrandInfo p WHERE p.createTime = :createTime"),
    @NamedQuery(name = "PpbrandInfo.findByUpdateTime", query = "SELECT p FROM PpbrandInfo p WHERE p.updateTime = :updateTime")})
public class PpbrandInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "pcode", nullable = false, length = 6)
    private String pcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "name", nullable = false, length = 40)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "brandcode", nullable = false, length = 6)
    private String brandcode;
    @Size(max = 40)
    @Column(name = "ename", length = 40)
    private String ename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "logopic", nullable = false, length = 200)
    private String logopic;
    @Size(max = 600)
    @Column(name = "remark", length = 600)
    private String remark;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sorts", nullable = false)
    private short sorts;
    @Size(max = 20)
    @Column(name = "creator", length = 20)
    private String creator;
    @Size(max = 30)
    @Column(name = "update_user", length = 30)
    private String updateUser;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public PpbrandInfo() {
    }

    public PpbrandInfo(Long id) {
        this.id = id;
    }

    public PpbrandInfo(Long id, String pcode, String name, String brandcode, String logopic, short sorts) {
        this.id = id;
        this.pcode = pcode;
        this.name = name;
        this.brandcode = brandcode;
        this.logopic = logopic;
        this.sorts = sorts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandcode() {
        return brandcode;
    }

    public void setBrandcode(String brandcode) {
        this.brandcode = brandcode;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getLogopic() {
        return logopic;
    }

    public void setLogopic(String logopic) {
        this.logopic = logopic;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public short getSorts() {
        return sorts;
    }

    public void setSorts(short sorts) {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        if (!(object instanceof PpbrandInfo)) {
            return false;
        }
        PpbrandInfo other = (PpbrandInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.PpbrandInfo[ id=" + id + " ]";
    }
    
}
