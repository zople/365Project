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
 * @author 王文彦
 */
@Entity
@Table(name = "tbl_product_property")
@NamedQueries({
    @NamedQuery(name = "TblProductProperty.findAll", query = "SELECT t FROM TblProductProperty t"),
    @NamedQuery(name = "TblProductProperty.findById", query = "SELECT t FROM TblProductProperty t WHERE t.id = :id"),
    @NamedQuery(name = "TblProductProperty.findByCategoryId", query = "SELECT t FROM TblProductProperty t WHERE t.categoryId = :categoryId"),
    @NamedQuery(name = "TblProductProperty.findByName", query = "SELECT t FROM TblProductProperty t WHERE t.name = :name"),
    @NamedQuery(name = "TblProductProperty.findByDescription", query = "SELECT t FROM TblProductProperty t WHERE t.description = :description"),
    @NamedQuery(name = "TblProductProperty.findByCreateTime", query = "SELECT t FROM TblProductProperty t WHERE t.createTime = :createTime")})
public class TblProductProperty implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "category_id")
    private BigInteger categoryId;
    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;
    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;

    public TblProductProperty() {
    }

    public TblProductProperty(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigInteger categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        if (!(object instanceof TblProductProperty)) {
            return false;
        }
        TblProductProperty other = (TblProductProperty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.TblProductProperty[ id=" + id + " ]";
    }
    
}
