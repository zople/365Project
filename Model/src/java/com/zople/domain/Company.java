/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author think
 */
@Entity
@Table(name = "company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findById", query = "SELECT c FROM Company c WHERE c.id = :id"),
    @NamedQuery(name = "Company.findByCompanyName", query = "SELECT c FROM Company c WHERE c.companyName = :companyName"),
    @NamedQuery(name = "Company.findByCompanyIntroduction", query = "SELECT c FROM Company c WHERE c.companyIntroduction = :companyIntroduction"),
    @NamedQuery(name = "Company.findByCompanyPhone", query = "SELECT c FROM Company c WHERE c.companyPhone = :companyPhone"),
    @NamedQuery(name = "Company.findByCompanyFax", query = "SELECT c FROM Company c WHERE c.companyFax = :companyFax"),
    @NamedQuery(name = "Company.findByCompanyAddress", query = "SELECT c FROM Company c WHERE c.companyAddress = :companyAddress")})
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 225)
    @Column(name = "company_name")
    private String companyName;
    @Size(max = 225)
    @Column(name = "company_introduction")
    private String companyIntroduction;
    @Size(max = 225)
    @Column(name = "company_phone")
    private String companyPhone;
    @Size(max = 225)
    @Column(name = "company_fax")
    private String companyFax;
    @Size(max = 225)
    @Column(name = "company_address")
    private String companyAddress;
    @OneToMany(mappedBy = "companyId",cascade={CascadeType.ALL})
    private Collection<Position> positionCollection=new ArrayList();
    @OneToMany(mappedBy = "companyId")
    private Collection<Contact> contactCollection;

    public Company() {
    }

    public Company(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyIntroduction() {
        return companyIntroduction;
    }

    public void setCompanyIntroduction(String companyIntroduction) {
        this.companyIntroduction = companyIntroduction;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyFax() {
        return companyFax;
    }

    public void setCompanyFax(String companyFax) {
        this.companyFax = companyFax;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    @XmlTransient
    public Collection<Position> getPositionCollection() {
        return positionCollection;
    }

    public void setPositionCollection(Collection<Position> positionCollection) {
        this.positionCollection = positionCollection;
    }

    @XmlTransient
    public Collection<Contact> getContactCollection() {
        return contactCollection;
    }

    public void setContactCollection(Collection<Contact> contactCollection) {
        this.contactCollection = contactCollection;
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
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.Company[ id=" + id + " ]";
    }
    
}
