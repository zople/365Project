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
@Table(name = "tbl_userrolesinfo")
@NamedQueries({
    @NamedQuery(name = "TblUserrolesinfo.findAll", query = "SELECT t FROM TblUserrolesinfo t"),
    @NamedQuery(name = "TblUserrolesinfo.findByUserroleid", query = "SELECT t FROM TblUserrolesinfo t WHERE t.userroleid = :userroleid"),
    @NamedQuery(name = "TblUserrolesinfo.findByCreatetime", query = "SELECT t FROM TblUserrolesinfo t WHERE t.createtime = :createtime"),
    @NamedQuery(name = "TblUserrolesinfo.findByCreator", query = "SELECT t FROM TblUserrolesinfo t WHERE t.creator = :creator"),
    @NamedQuery(name = "TblUserrolesinfo.findByRoleid", query = "SELECT t FROM TblUserrolesinfo t WHERE t.roleid = :roleid"),
    @NamedQuery(name = "TblUserrolesinfo.findBySorts", query = "SELECT t FROM TblUserrolesinfo t WHERE t.sorts = :sorts"),
    @NamedQuery(name = "TblUserrolesinfo.findByStatus", query = "SELECT t FROM TblUserrolesinfo t WHERE t.status = :status"),
    @NamedQuery(name = "TblUserrolesinfo.findByUpdatetime", query = "SELECT t FROM TblUserrolesinfo t WHERE t.updatetime = :updatetime"),
    @NamedQuery(name = "TblUserrolesinfo.findByUpdateuser", query = "SELECT t FROM TblUserrolesinfo t WHERE t.updateuser = :updateuser"),
    @NamedQuery(name = "TblUserrolesinfo.findByUserid", query = "SELECT t FROM TblUserrolesinfo t WHERE t.userid = :userid")})
public class TblUserrolesinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "userroleid", nullable = false)
    private Long userroleid;
    @Column(name = "createtime")
    @Temporal(TemporalType.DATE)
    private Date createtime;
    @Size(max = 50)
    @Column(name = "creator", length = 50)
    private String creator;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "roleid", precision = 19, scale = 2)
    private BigDecimal roleid;
    @Column(name = "sorts")
    private Integer sorts;
    @Column(name = "status")
    private Integer status;
    @Column(name = "updatetime")
    @Temporal(TemporalType.DATE)
    private Date updatetime;
    @Size(max = 50)
    @Column(name = "updateuser", length = 50)
    private String updateuser;
    @Column(name = "userid", precision = 19, scale = 2)
    private BigDecimal userid;

    public TblUserrolesinfo() {
    }

    public TblUserrolesinfo(Long userroleid) {
        this.userroleid = userroleid;
    }

    public Long getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(Long userroleid) {
        this.userroleid = userroleid;
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

    public BigDecimal getRoleid() {
        return roleid;
    }

    public void setRoleid(BigDecimal roleid) {
        this.roleid = roleid;
    }

    public Integer getSorts() {
        return sorts;
    }

    public void setSorts(Integer sorts) {
        this.sorts = sorts;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public BigDecimal getUserid() {
        return userid;
    }

    public void setUserid(BigDecimal userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userroleid != null ? userroleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUserrolesinfo)) {
            return false;
        }
        TblUserrolesinfo other = (TblUserrolesinfo) object;
        if ((this.userroleid == null && other.userroleid != null) || (this.userroleid != null && !this.userroleid.equals(other.userroleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.TblUserrolesinfo[ userroleid=" + userroleid + " ]";
    }
    
}
