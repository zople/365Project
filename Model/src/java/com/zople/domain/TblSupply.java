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
@Table(name = "tbl_supply")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblSupply.findAll", query = "SELECT t FROM TblSupply t"),
    @NamedQuery(name = "TblSupply.findById", query = "SELECT t FROM TblSupply t WHERE t.id = :id"),
    @NamedQuery(name = "TblSupply.findByDescription", query = "SELECT t FROM TblSupply t WHERE t.description = :description"),
    @NamedQuery(name = "TblSupply.findByTitle", query = "SELECT t FROM TblSupply t WHERE t.title = :title"),
    @NamedQuery(name = "TblSupply.findByUserId", query = "SELECT t FROM TblSupply t WHERE t.userId = :userId")})
public class TblSupply implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 100)
    @Column(name = "title")
    private String title;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "user_id")
    private BigDecimal userId;

    public TblSupply() {
    }

    public TblSupply(Long id) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
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
        if (!(object instanceof TblSupply)) {
            return false;
        }
        TblSupply other = (TblSupply) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.TblSupply[ id=" + id + " ]";
    }
    
}
