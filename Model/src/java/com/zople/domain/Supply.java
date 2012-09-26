/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author think
 */
@Entity
@Table(name = "tbl_supply")
@NamedQueries({
    @NamedQuery(name = "Supply.findAll", query = "SELECT s FROM Supply s")})
public class Supply implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "supply_serial", allocationSize = 1, initialValue = 1, sequenceName = "supply_serial")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supply_serial")
    @Column(name = "id")
    private Long id;
    @Size(max = 100)
    @Column(name = "title")
    private String title;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "en_enterprise_id",referencedColumnName = "id")
    private EnEnterprise company;

    public Supply() {
    }

    public Supply(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Supply)) {
            return false;
        }
        Supply other = (Supply) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.Supply[ id=" + id + " ]";
    }

    public EnEnterprise getCompany() {
        return company;
    }

    public void setCompany(EnEnterprise company) {
        this.company = company;
    }

    
}
