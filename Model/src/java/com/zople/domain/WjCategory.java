/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "wj_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WjCategory.findAll", query = "SELECT w FROM WjCategory w"),
    @NamedQuery(name = "WjCategory.findByCategoryId", query = "SELECT w FROM WjCategory w WHERE w.categoryId = :categoryId"),
    @NamedQuery(name = "WjCategory.findByCategoryName", query = "SELECT w FROM WjCategory w WHERE w.categoryName = :categoryName"),
    @NamedQuery(name = "WjCategory.findByFatherId", query = "SELECT w FROM WjCategory w WHERE w.fatherId = :fatherId"),
    @NamedQuery(name = "WjCategory.findBySortOrder", query = "SELECT w FROM WjCategory w WHERE w.sortOrder = :sortOrder")})
public class WjCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "category_id")
    private Long categoryId;
    @Size(max = 100)
    @Column(name = "category_name")
    private String categoryName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "father_id")
    private long fatherId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sort_order")
    private BigDecimal sortOrder;

    public WjCategory() {
    }

    public WjCategory(Long categoryId) {
        this.categoryId = categoryId;
    }

    public WjCategory(Long categoryId, long fatherId) {
        this.categoryId = categoryId;
        this.fatherId = fatherId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getFatherId() {
        return fatherId;
    }

    public void setFatherId(long fatherId) {
        this.fatherId = fatherId;
    }

    public BigDecimal getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(BigDecimal sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WjCategory)) {
            return false;
        }
        WjCategory other = (WjCategory) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.WjCategory[ categoryId=" + categoryId + " ]";
    }
    
}
