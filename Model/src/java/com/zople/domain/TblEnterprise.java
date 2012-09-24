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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "tbl_enterprise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEnterprise.findAll", query = "SELECT t FROM TblEnterprise t"),
    @NamedQuery(name = "TblEnterprise.findById", query = "SELECT t FROM TblEnterprise t WHERE t.id = :id"),
    @NamedQuery(name = "TblEnterprise.findByDescription", query = "SELECT t FROM TblEnterprise t WHERE t.description = :description"),
    @NamedQuery(name = "TblEnterprise.findByName", query = "SELECT t FROM TblEnterprise t WHERE t.name = :name")})
public class TblEnterprise implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "logo_id", referencedColumnName = "id")
    @ManyToOne
    private TblImage logoId;
    @OneToMany(mappedBy = "enterpriseId")
    private List<TblProduct> tblProductList;

    public TblEnterprise() {
    }

    public TblEnterprise(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TblImage getLogoId() {
        return logoId;
    }

    public void setLogoId(TblImage logoId) {
        this.logoId = logoId;
    }

    @XmlTransient
    public List<TblProduct> getTblProductList() {
        return tblProductList;
    }

    public void setTblProductList(List<TblProduct> tblProductList) {
        this.tblProductList = tblProductList;
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
        if (!(object instanceof TblEnterprise)) {
            return false;
        }
        TblEnterprise other = (TblEnterprise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.TblEnterprise[ id=" + id + " ]";
    }
    
}
