/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "tbl_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCategory.findAll", query = "SELECT t FROM TblCategory t"),
    @NamedQuery(name = "TblCategory.findById", query = "SELECT t FROM TblCategory t WHERE t.id = :id"),
    @NamedQuery(name = "TblCategory.findByName", query = "SELECT t FROM TblCategory t WHERE t.name = :name"),
    @NamedQuery(name = "TblCategory.findByPid", query = "SELECT t FROM TblCategory t WHERE t.pid = :pid")})
public class TblCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @SequenceGenerator(name = "category_serial", allocationSize = 1, initialValue = 1, sequenceName = "category_serial")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_serial")
    private Long id;
    @Size(max = 30)
    @Column(name = "name")
    private String name;
    @Column(name = "pid")
    private Long pid;
    @OneToMany(mappedBy = "categoryId")
    private List<TblProduct> tblProductList;
    @OneToMany(mappedBy = "categoryId",cascade={CascadeType.ALL})
    private List<Property> propertyList;

    public TblCategory() {
    }

    public TblCategory(Long id) {
        this.id = id;
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

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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
        if (!(object instanceof TblCategory)) {
            return false;
        }
        TblCategory other = (TblCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.TblCategory[ id=" + id + " ]";
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }
    
}
