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
@Table(name = "tbl_groupinfo")
@NamedQueries({
    @NamedQuery(name = "TblGroupinfo.findAll", query = "SELECT t FROM TblGroupinfo t"),
    @NamedQuery(name = "TblGroupinfo.findByGroupid", query = "SELECT t FROM TblGroupinfo t WHERE t.groupid = :groupid"),
    @NamedQuery(name = "TblGroupinfo.findByCreatetime", query = "SELECT t FROM TblGroupinfo t WHERE t.createtime = :createtime"),
    @NamedQuery(name = "TblGroupinfo.findByCreator", query = "SELECT t FROM TblGroupinfo t WHERE t.creator = :creator"),
    @NamedQuery(name = "TblGroupinfo.findByDescription", query = "SELECT t FROM TblGroupinfo t WHERE t.description = :description"),
    @NamedQuery(name = "TblGroupinfo.findByGroupcname", query = "SELECT t FROM TblGroupinfo t WHERE t.groupcname = :groupcname"),
    @NamedQuery(name = "TblGroupinfo.findByPid", query = "SELECT t FROM TblGroupinfo t WHERE t.pid = :pid"),
    @NamedQuery(name = "TblGroupinfo.findBySorts", query = "SELECT t FROM TblGroupinfo t WHERE t.sorts = :sorts"),
    @NamedQuery(name = "TblGroupinfo.findByTreeid", query = "SELECT t FROM TblGroupinfo t WHERE t.treeid = :treeid"),
    @NamedQuery(name = "TblGroupinfo.findByUpdatetime", query = "SELECT t FROM TblGroupinfo t WHERE t.updatetime = :updatetime"),
    @NamedQuery(name = "TblGroupinfo.findByUpdateuser", query = "SELECT t FROM TblGroupinfo t WHERE t.updateuser = :updateuser")})
public class TblGroupinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "groupid", nullable = false)
    private Long groupid;
    @Column(name = "createtime")
    @Temporal(TemporalType.DATE)
    private Date createtime;
    @Size(max = 50)
    @Column(name = "creator", length = 50)
    private String creator;
    @Size(max = 100)
    @Column(name = "description", length = 100)
    private String description;
    @Size(max = 100)
    @Column(name = "groupcname", length = 100)
    private String groupcname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pid", precision = 19, scale = 2)
    private BigDecimal pid;
    @Column(name = "sorts")
    private Integer sorts;
    @Column(name = "treeid", precision = 19, scale = 2)
    private BigDecimal treeid;
    @Column(name = "updatetime")
    @Temporal(TemporalType.DATE)
    private Date updatetime;
    @Size(max = 100)
    @Column(name = "updateuser", length = 100)
    private String updateuser;

    public TblGroupinfo() {
    }

    public TblGroupinfo(Long groupid) {
        this.groupid = groupid;
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroupcname() {
        return groupcname;
    }

    public void setGroupcname(String groupcname) {
        this.groupcname = groupcname;
    }

    public BigDecimal getPid() {
        return pid;
    }

    public void setPid(BigDecimal pid) {
        this.pid = pid;
    }

    public Integer getSorts() {
        return sorts;
    }

    public void setSorts(Integer sorts) {
        this.sorts = sorts;
    }

    public BigDecimal getTreeid() {
        return treeid;
    }

    public void setTreeid(BigDecimal treeid) {
        this.treeid = treeid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupid != null ? groupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblGroupinfo)) {
            return false;
        }
        TblGroupinfo other = (TblGroupinfo) object;
        if ((this.groupid == null && other.groupid != null) || (this.groupid != null && !this.groupid.equals(other.groupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.TblGroupinfo[ groupid=" + groupid + " ]";
    }
    
}
