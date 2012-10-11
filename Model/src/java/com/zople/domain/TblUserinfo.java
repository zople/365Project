/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "tbl_userinfo")
@NamedQueries({
    @NamedQuery(name = "TblUserinfo.findAll", query = "SELECT t FROM TblUserinfo t"),
    @NamedQuery(name = "TblUserinfo.findByUserid", query = "SELECT t FROM TblUserinfo t WHERE t.userid = :userid"),
    @NamedQuery(name = "TblUserinfo.findByPassword", query = "SELECT t FROM TblUserinfo t WHERE t.password = :password")})
public class TblUserinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "userid", nullable = false)
    private Long userid;
    @Size(max = 255)
    @Column(name = "password", length = 255)
    private String password;
    @OneToMany(mappedBy = "tblUserId")
    private List<EnEnterprise> enEnterpriseList;

    public TblUserinfo() {
    }

    public TblUserinfo(Long userid) {
        this.userid = userid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<EnEnterprise> getEnEnterpriseList() {
        return enEnterpriseList;
    }

    public void setEnEnterpriseList(List<EnEnterprise> enEnterpriseList) {
        this.enEnterpriseList = enEnterpriseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUserinfo)) {
            return false;
        }
        TblUserinfo other = (TblUserinfo) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.TblUserinfo[ userid=" + userid + " ]";
    }
    
}
