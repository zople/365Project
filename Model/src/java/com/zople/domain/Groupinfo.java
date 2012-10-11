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
 * 组信息实体
 */
@Entity
@Table(name = "tbl_groupinfo")
@NamedQueries({
    @NamedQuery(name = "Groupinfo.findAll", query = "SELECT g FROM Groupinfo g"),
    @NamedQuery(name = "Groupinfo.findByGroupid", query = "SELECT g FROM Groupinfo g WHERE g.groupid = :groupid"),
    @NamedQuery(name = "Groupinfo.findByPid", query = "SELECT g FROM Groupinfo g WHERE g.pid = :pid"),
    @NamedQuery(name = "Groupinfo.findByGroupcname", query = "SELECT g FROM Groupinfo g WHERE g.groupcname = :groupcname"),
    @NamedQuery(name = "Groupinfo.findByDescription", query = "SELECT g FROM Groupinfo g WHERE g.description = :description"),
    @NamedQuery(name = "Groupinfo.findByTreeid", query = "SELECT g FROM Groupinfo g WHERE g.treeid = :treeid"),
    @NamedQuery(name = "Groupinfo.findBySorts", query = "SELECT g FROM Groupinfo g WHERE g.sorts = :sorts"),
    @NamedQuery(name = "Groupinfo.findByCreator", query = "SELECT g FROM Groupinfo g WHERE g.creator = :creator"),
    @NamedQuery(name = "Groupinfo.findByUpdateuser", query = "SELECT g FROM Groupinfo g WHERE g.updateuser = :updateuser"),
    @NamedQuery(name = "Groupinfo.findByUpdatetime", query = "SELECT g FROM Groupinfo g WHERE g.updatetime = :updatetime"),
    @NamedQuery(name = "Groupinfo.findByCreatetime", query = "SELECT g FROM Groupinfo g WHERE g.createtime = :createtime")})
public class Groupinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "groupid")
    private Long groupid;
    @Column(name = "pid")
    private BigInteger pid;
    @Size(max = 100)
    @Column(name = "groupcname")
    private String groupcname;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @Column(name = "treeid")
    private BigInteger treeid;
    @Column(name = "sorts")
    private Integer sorts;
    @Size(max = 50)
    @Column(name = "creator")
    private String creator;
    @Size(max = 100)
    @Column(name = "updateuser")
    private String updateuser;
    @Column(name = "updatetime")
    @Temporal(TemporalType.DATE)
    private Date updatetime;
    @Column(name = "createtime")
    @Temporal(TemporalType.DATE)
    private Date createtime;

    public Groupinfo() {
    }

    public Groupinfo(Long groupid) {
        this.groupid = groupid;
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public BigInteger getPid() {
        return pid;
    }

    public void setPid(BigInteger pid) {
        this.pid = pid;
    }

    public String getGroupcname() {
        return groupcname;
    }

    public void setGroupcname(String groupcname) {
        this.groupcname = groupcname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getTreeid() {
        return treeid;
    }

    public void setTreeid(BigInteger treeid) {
        this.treeid = treeid;
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
        hash += (groupid != null ? groupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupinfo)) {
            return false;
        }
        Groupinfo other = (Groupinfo) object;
        if ((this.groupid == null && other.groupid != null) || (this.groupid != null && !this.groupid.equals(other.groupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.Groupinfo[ groupid=" + groupid + " ]";
    }
    
}
