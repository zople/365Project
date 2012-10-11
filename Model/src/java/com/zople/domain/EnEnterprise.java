/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zople.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *@描   述:   
 *@ author:  Expression yuzhijian_yuxia2217@163 is undefined on line 12, column 16 in Templates/Classes/Class.java.
 *@version: 1.0
 */
@Entity
@Table(name = "en_enterprise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnEnterprise.findAll", query = "SELECT e FROM EnEnterprise e"),
    @NamedQuery(name = "EnEnterprise.findById", query = "SELECT e FROM EnEnterprise e WHERE e.id = :id"),
    @NamedQuery(name = "EnEnterprise.findByBusinessPattern", query = "SELECT e FROM EnEnterprise e WHERE e.businessPattern = :businessPattern"),
    @NamedQuery(name = "EnEnterprise.findByMainProduct", query = "SELECT e FROM EnEnterprise e WHERE e.mainProduct = :mainProduct"),
    @NamedQuery(name = "EnEnterprise.findByMainSort", query = "SELECT e FROM EnEnterprise e WHERE e.mainSort = :mainSort"),
    @NamedQuery(name = "EnEnterprise.findByName", query = "SELECT e FROM EnEnterprise e WHERE e.name = :name"),
    @NamedQuery(name = "EnEnterprise.findByAddress", query = "SELECT e FROM EnEnterprise e WHERE e.address = :address"),
    @NamedQuery(name = "EnEnterprise.findByFaxes", query = "SELECT e FROM EnEnterprise e WHERE e.faxes = :faxes"),
    @NamedQuery(name = "EnEnterprise.findByPhone", query = "SELECT e FROM EnEnterprise e WHERE e.phone = :phone"),
    @NamedQuery(name = "EnEnterprise.findByTelphone", query = "SELECT e FROM EnEnterprise e WHERE e.telphone = :telphone"),
    @NamedQuery(name = "EnEnterprise.findByUrl", query = "SELECT e FROM EnEnterprise e WHERE e.url = :url")})
public class EnEnterprise implements Serializable {
    
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;
    @ManyToMany(mappedBy = "enEnterpriseList")
    private List<AdminStyle> adminStyleList;
    @JoinColumn(name = "tbl_user_id", referencedColumnName = "userid")
    @ManyToOne
    private TblUserinfo tblUserId;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 100)
    @Column(name = "business_pattern")
    private String businessPattern;
    @OneToOne
    @JoinColumn(name ="image_id")
    private Image logo;
    @Size(max = 100)
    @Column(name = "main_product")
    private String mainProduct;
    @Size(max = 100)
    @Column(name = "main_sort")
    private String mainSort;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "faxes")
    private String faxes;
    @Size(max = 255)
    @Column(name = "phone")
    private String phone;
    @Size(max = 255)
    @Column(name = "telphone")
    private String telphone;
    @Size(max = 255)
    @Column(name = "url")
    private String url;
    @OneToMany(mappedBy = "company",cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    private List<Supply> supplyList = new ArrayList();
//    @OneToMany(mappedBy = "company_id")
//    private List<Buy> buyList = new ArrayList();
    public EnEnterprise() {
    }

    public EnEnterprise(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessPattern() {
        return businessPattern;
    }

    public void setBusinessPattern(String businessPattern) {
        this.businessPattern = businessPattern;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFaxes() {
        return faxes;
    }

    public void setFaxes(String faxes) {
        this.faxes = faxes;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        if (!(object instanceof EnEnterprise)) {
            return false;
        }
        EnEnterprise other = (EnEnterprise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.EnEnterprise[ id=" + id + " ]";
    }

    public List<Supply> getSupplyList() {
        return supplyList;
    }

    public void setSupplyList(List<Supply> supplyList) {
        this.supplyList = supplyList;
    }

//    public List<Buy> getBuyList() {
//        return buyList;
//    }
//
//    public void setBuyList(List<Buy> buyList) {
//        this.buyList = buyList;
//    }

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

    public List<AdminStyle> getAdminStyleList() {
        return adminStyleList;
    }

    public void setAdminStyleList(List<AdminStyle> adminStyleList) {
        this.adminStyleList = adminStyleList;
    }

    public TblUserinfo getTblUserId() {
        return tblUserId;
    }

    public void setTblUserId(TblUserinfo tblUserId) {
        this.tblUserId = tblUserId;
    }

 
    
}
