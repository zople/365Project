/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain.product;

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
@Table(name = "sppl_cateattrrvinfo")
@NamedQueries({
    @NamedQuery(name = "SpplCateattrrvinfo.findAll", query = "SELECT s FROM SpplCateattrrvinfo s"),
    @NamedQuery(name = "SpplCateattrrvinfo.findById", query = "SELECT s FROM SpplCateattrrvinfo s WHERE s.id = :id"),
    @NamedQuery(name = "SpplCateattrrvinfo.findByCateattrId", query = "SELECT s FROM SpplCateattrrvinfo s WHERE s.cateattrId = :cateattrId"),
    @NamedQuery(name = "SpplCateattrrvinfo.findByRangeCode", query = "SELECT s FROM SpplCateattrrvinfo s WHERE s.rangeCode = :rangeCode"),
    @NamedQuery(name = "SpplCateattrrvinfo.findByRangeDesc", query = "SELECT s FROM SpplCateattrrvinfo s WHERE s.rangeDesc = :rangeDesc"),
    @NamedQuery(name = "SpplCateattrrvinfo.findBySorts", query = "SELECT s FROM SpplCateattrrvinfo s WHERE s.sorts = :sorts"),
    @NamedQuery(name = "SpplCateattrrvinfo.findByStatus", query = "SELECT s FROM SpplCateattrrvinfo s WHERE s.status = :status"),
    @NamedQuery(name = "SpplCateattrrvinfo.findByCreator", query = "SELECT s FROM SpplCateattrrvinfo s WHERE s.creator = :creator"),
    @NamedQuery(name = "SpplCateattrrvinfo.findByUpdateUser", query = "SELECT s FROM SpplCateattrrvinfo s WHERE s.updateUser = :updateUser"),
    @NamedQuery(name = "SpplCateattrrvinfo.findByCreateTime", query = "SELECT s FROM SpplCateattrrvinfo s WHERE s.createTime = :createTime"),
    @NamedQuery(name = "SpplCateattrrvinfo.findByUpdateTime", query = "SELECT s FROM SpplCateattrrvinfo s WHERE s.updateTime = :updateTime")})
public class SpplCateattrrvinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cateattr_id", nullable = false)
    private long cateattrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "range_code", nullable = false, length = 8)
    private String rangeCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "range_desc", nullable = false, length = 60)
    private String rangeDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sorts", nullable = false)
    private short sorts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status", nullable = false)
    private short status;
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

    public SpplCateattrrvinfo() {
    }

    public SpplCateattrrvinfo(Long id) {
        this.id = id;
    }

    public SpplCateattrrvinfo(Long id, long cateattrId, String rangeCode, String rangeDesc, short sorts, short status) {
        this.id = id;
        this.cateattrId = cateattrId;
        this.rangeCode = rangeCode;
        this.rangeDesc = rangeDesc;
        this.sorts = sorts;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCateattrId() {
        return cateattrId;
    }

    public void setCateattrId(long cateattrId) {
        this.cateattrId = cateattrId;
    }

    public String getRangeCode() {
        return rangeCode;
    }

    public void setRangeCode(String rangeCode) {
        this.rangeCode = rangeCode;
    }

    public String getRangeDesc() {
        return rangeDesc;
    }

    public void setRangeDesc(String rangeDesc) {
        this.rangeDesc = rangeDesc;
    }

    public short getSorts() {
        return sorts;
    }

    public void setSorts(short sorts) {
        this.sorts = sorts;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
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
        if (!(object instanceof SpplCateattrrvinfo)) {
            return false;
        }
        SpplCateattrrvinfo other = (SpplCateattrrvinfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.SpplCateattrrvinfo[ id=" + id + " ]";
    }
    
}
