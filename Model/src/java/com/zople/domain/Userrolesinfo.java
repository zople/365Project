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
 * @author wangxiu
 *,2，用户角色实体
 */
@Entity
@Table(name = "tbl_userrolesinfo")
@NamedQueries({
    @NamedQuery(name = "Userrolesinfo.findAll", query = "SELECT u FROM Userrolesinfo u"),
    @NamedQuery(name = "Userrolesinfo.findByUserroleid", query = "SELECT u FROM Userrolesinfo u WHERE u.userroleid = :userroleid"),
    @NamedQuery(name = "Userrolesinfo.findByRoleid", query = "SELECT u FROM Userrolesinfo u WHERE u.roleid = :roleid"),
    @NamedQuery(name = "Userrolesinfo.findByUserid", query = "SELECT u FROM Userrolesinfo u WHERE u.userid = :userid"),
    @NamedQuery(name = "Userrolesinfo.findByStatus", query = "SELECT u FROM Userrolesinfo u WHERE u.status = :status"),
    @NamedQuery(name = "Userrolesinfo.findBySorts", query = "SELECT u FROM Userrolesinfo u WHERE u.sorts = :sorts"),
    @NamedQuery(name = "Userrolesinfo.findByCreator", query = "SELECT u FROM Userrolesinfo u WHERE u.creator = :creator"),
    @NamedQuery(name = "Userrolesinfo.findByUpdateuser", query = "SELECT u FROM Userrolesinfo u WHERE u.updateuser = :updateuser"),
    @NamedQuery(name = "Userrolesinfo.findByUpdatetime", query = "SELECT u FROM Userrolesinfo u WHERE u.updatetime = :updatetime"),
    @NamedQuery(name = "Userrolesinfo.findByCreatetime", query = "SELECT u FROM Userrolesinfo u WHERE u.createtime = :createtime")})
public class Userrolesinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "userroleid")
    private Long userroleid;
    @Column(name = "roleid")
    private BigInteger roleid;
    @Column(name = "userid")
    private BigInteger userid;
    @Column(name = "status")
    private Integer status;
    @Column(name = "sorts")
    private Integer sorts;
    @Size(max = 50)
    @Column(name = "creator")
    private String creator;
    @Size(max = 50)
    @Column(name = "updateuser")
    private String updateuser;
    @Column(name = "updatetime")
    @Temporal(TemporalType.DATE)
    private Date updatetime;
    @Column(name = "createtime")
    @Temporal(TemporalType.DATE)
    private Date createtime;

    public Userrolesinfo() {
    }

    public Userrolesinfo(Long userroleid) {
        this.userroleid = userroleid;
    }

    public Long getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(Long userroleid) {
        this.userroleid = userroleid;
    }

    public BigInteger getRoleid() {
        return roleid;
    }

    public void setRoleid(BigInteger roleid) {
        this.roleid = roleid;
    }

    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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
        if (!(object instanceof Userrolesinfo)) {
            return false;
        }
        Userrolesinfo other = (Userrolesinfo) object;
        if ((this.userroleid == null && other.userroleid != null) || (this.userroleid != null && !this.userroleid.equals(other.userroleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.Userrolesinfo[ userroleid=" + userroleid + " ]";
    }
    
}
