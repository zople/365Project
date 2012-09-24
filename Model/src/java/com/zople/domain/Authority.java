/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "tbl_authority")
@NamedQueries({
    @NamedQuery(name = "Authority.findAll", query = "SELECT a FROM Authority a"),
    @NamedQuery(name = "Authority.findById", query = "SELECT a FROM Authority a WHERE a.id = :id"),
    @NamedQuery(name = "Authority.findByName", query = "SELECT a FROM Authority a WHERE a.name = :name")})
public class Authority implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name="AUTHORITY_GEN",table="TBL_PRIMARY_KEY_GENERATOR",pkColumnName="KEY",valueColumnName="VALUE",pkColumnValue="AUTHORITY_ID",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="AUTHORITY_GEN")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "authoritySet",cascade = CascadeType.REFRESH)
    private Set<Role> roleSet;

    public Authority() {
    }

    public Authority(Long id) {
        this.id = id;
    }

    public Authority(Long id, String name) {
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

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
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
        if (!(object instanceof Authority)) {
            return false;
        }
        Authority other = (Authority) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.Authority[ id=" + id + " ]";
    }
    
}
