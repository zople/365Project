/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @Size(max = 32)
    @Column(name = "website")
    private String website;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "phone")
    private String phone;
    @Size(max = 20)
    @Column(name = "en_type")
    private String enType;
    @Column(name = "personnel_numeric")
    private BigInteger personnelNumeric;
    @Size(max = 20)
    @Column(name = "en_synopsis")
    private String enSynopsis;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "email")
    private String email;
    @Column(name = "found_time")
    @Temporal(TemporalType.DATE)
    private Date foundTime;
    @Size(max = 100)
    @Column(name = "registered_region")
    private String registeredRegion;
    @Size(max = 20)
    @Column(name = "legal_person")
    private String legalPerson;
    @Size(max = 20)
    @Column(name = "turnover_year")
    private String turnoverYear;
    @Size(max = 20)
    @Column(name = "business_model")
    private String businessModel;
    @Size(max = 20)
    @Column(name = "customer_base")
    private String customerBase;
    @Size(max = 20)
    @Column(name = "exports_year")
    private String exportsYear;
    @Size(max = 20)
    @Column(name = "sell_year")
    private String sellYear;
    @Size(max = 20)
    @Column(name = "certification_system")
    private String certificationSystem;
    @Size(max = 20)
    @Column(name = "oem")
    private String oem;
    @Column(name = "authenticate")
    private BigInteger authenticate;
    @Size(max = 20)
    @Column(name = "creator")
    private String creator;
    @Size(max = 20)
    @Column(name = "update_user")
    private String updateUser;
    @Column(name = "update_time")
    @Temporal(TemporalType.DATE)
    private Date updateTime;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;
    @Column(name = "user_id")
    private BigInteger userId;
    @Size(max = 100)
    @Column(name = "main_product")
    private String mainProduct;
    @Size(max = 100)
    @Column(name = "main_sort")
    private String mainSort;
    @Size(max = 255)
    @Column(name = "faxes")
    private String faxes;
    @Size(max = 255)
    @Column(name = "telphone")
    private String telphone;
    @Size(max = 255)
    @Column(name = "homepage")
    private String homepage;
    @Size(max = 20)
    @Column(name = "qq")
    private String qq;
    @Size(max = 50)
    @Column(name = "linkman")
    private String linkman;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEnType() {
        return enType;
    }

    public void setEnType(String enType) {
        this.enType = enType;
    }

    public BigInteger getPersonnelNumeric() {
        return personnelNumeric;
    }

    public void setPersonnelNumeric(BigInteger personnelNumeric) {
        this.personnelNumeric = personnelNumeric;
    }

    public String getEnSynopsis() {
        return enSynopsis;
    }

    public void setEnSynopsis(String enSynopsis) {
        this.enSynopsis = enSynopsis;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFoundTime() {
        return foundTime;
    }

    public void setFoundTime(Date foundTime) {
        this.foundTime = foundTime;
    }

    public String getRegisteredRegion() {
        return registeredRegion;
    }

    public void setRegisteredRegion(String registeredRegion) {
        this.registeredRegion = registeredRegion;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getTurnoverYear() {
        return turnoverYear;
    }

    public void setTurnoverYear(String turnoverYear) {
        this.turnoverYear = turnoverYear;
    }

    public String getBusinessModel() {
        return businessModel;
    }

    public void setBusinessModel(String businessModel) {
        this.businessModel = businessModel;
    }

    public String getCustomerBase() {
        return customerBase;
    }

    public void setCustomerBase(String customerBase) {
        this.customerBase = customerBase;
    }

    public String getExportsYear() {
        return exportsYear;
    }

    public void setExportsYear(String exportsYear) {
        this.exportsYear = exportsYear;
    }

    public String getSellYear() {
        return sellYear;
    }

    public void setSellYear(String sellYear) {
        this.sellYear = sellYear;
    }

    public String getCertificationSystem() {
        return certificationSystem;
    }

    public void setCertificationSystem(String certificationSystem) {
        this.certificationSystem = certificationSystem;
    }

    public String getOem() {
        return oem;
    }

    public void setOem(String oem) {
        this.oem = oem;
    }

    public BigInteger getAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(BigInteger authenticate) {
        this.authenticate = authenticate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getMainProduct() {
        return mainProduct;
    }

    public void setMainProduct(String mainProduct) {
        this.mainProduct = mainProduct;
    }

    public String getMainSort() {
        return mainSort;
    }

    public void setMainSort(String mainSort) {
        this.mainSort = mainSort;
    }

    public String getFaxes() {
        return faxes;
    }

    public void setFaxes(String faxes) {
        this.faxes = faxes;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }
    
}
