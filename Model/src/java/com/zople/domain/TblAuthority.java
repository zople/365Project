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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "tbl_authority")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAuthority.findAll", query = "SELECT t FROM TblAuthority t"),
    @NamedQuery(name = "TblAuthority.findById", query = "SELECT t FROM TblAuthority t WHERE t.id = :id"),
    @NamedQuery(name = "TblAuthority.findByName", query = "SELECT t FROM TblAuthority t WHERE t.name = :name")})
public class TblAuthority implements Serializable {
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
    @JoinTable(name = "tbl_role_authority", joinColumns = {
        @JoinColumn(name = "authority_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "id")})
    @ManyToMany
    private List<TblRole> tblRoleList;

    public TblAuthority() {
    }

    public TblAuthority(Long id) {
        this.id = id;
    }

    public TblAuthority(Long id, String name) {
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
    public List<TblRole> getTblRoleList() {
        return tblRoleList;
    }

    public void setTblRoleList(List<TblRole> tblRoleList) {
        this.tblRoleList = tblRoleList;
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
        if (!(object instanceof TblAuthority)) {
            return false;
        }
        TblAuthority other = (TblAuthority) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.TblAuthority[ id=" + id + " ]";
    }
    
}
