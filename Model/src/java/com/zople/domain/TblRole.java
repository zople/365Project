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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "tbl_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRole.findAll", query = "SELECT t FROM TblRole t"),
    @NamedQuery(name = "TblRole.findById", query = "SELECT t FROM TblRole t WHERE t.id = :id"),
    @NamedQuery(name = "TblRole.findByName", query = "SELECT t FROM TblRole t WHERE t.name = :name")})
public class TblRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "tblRoleList")
    private List<TblAuthority> tblAuthorityList;

    public TblRole() {
    }

    public TblRole(Long id) {
        this.id = id;
    }

    public TblRole(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<TblAuthority> getTblAuthorityList() {
        return tblAuthorityList;
    }

    public void setTblAuthorityList(List<TblAuthority> tblAuthorityList) {
        this.tblAuthorityList = tblAuthorityList;
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
        if (!(object instanceof TblRole)) {
            return false;
        }
        TblRole other = (TblRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.TblRole[ id=" + id + " ]";
    }
    
}
