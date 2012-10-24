/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain.basic;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author wangxiu
 */
@Entity
@Table(name = "merchants_info")
@NamedQueries({
    @NamedQuery(name = "MerchantsInfo.findAll", query = "SELECT m FROM MerchantsInfo m"),
    @NamedQuery(name = "MerchantsInfo.findByMerchantsInfoId", query = "SELECT m FROM MerchantsInfo m WHERE m.merchantsInfoId = :merchantsInfoId"),
    @NamedQuery(name = "MerchantsInfo.findByMerchantsTitle", query = "SELECT m FROM MerchantsInfo m WHERE m.merchantsTitle = :merchantsTitle"),
    @NamedQuery(name = "MerchantsInfo.findByMerchantsType", query = "SELECT m FROM MerchantsInfo m WHERE m.merchantsType = :merchantsType"),
    @NamedQuery(name = "MerchantsInfo.findByMerchantsArea", query = "SELECT m FROM MerchantsInfo m WHERE m.merchantsArea = :merchantsArea"),
    @NamedQuery(name = "MerchantsInfo.findByEndTime", query = "SELECT m FROM MerchantsInfo m WHERE m.endTime = :endTime"),
    @NamedQuery(name = "MerchantsInfo.findByDescription", query = "SELECT m FROM MerchantsInfo m WHERE m.description = :description"),
    @NamedQuery(name = "MerchantsInfo.findByProductPackage", query = "SELECT m FROM MerchantsInfo m WHERE m.productPackage = :productPackage"),
    @NamedQuery(name = "MerchantsInfo.findByProductSpe", query = "SELECT m FROM MerchantsInfo m WHERE m.productSpe = :productSpe"),
    @NamedQuery(name = "MerchantsInfo.findByCreator", query = "SELECT m FROM MerchantsInfo m WHERE m.creator = :creator"),
    @NamedQuery(name = "MerchantsInfo.findByUpdateUser", query = "SELECT m FROM MerchantsInfo m WHERE m.updateUser = :updateUser"),
    @NamedQuery(name = "MerchantsInfo.findByUpdateTime", query = "SELECT m FROM MerchantsInfo m WHERE m.updateTime = :updateTime"),
    @NamedQuery(name = "MerchantsInfo.findByEnterpriseId", query = "SELECT m FROM MerchantsInfo m WHERE m.enterpriseId = :enterpriseId"),
    @NamedQuery(name = "MerchantsInfo.findByentErpriseContactId", query = "SELECT m FROM MerchantsInfo m WHERE m.enterpriseContactId = :enterpriseContactId"),
    @NamedQuery(name = "MerchantsInfo.findByCreateTime", query = "SELECT m FROM MerchantsInfo m WHERE m.createTime = :createTime")})
   
public class MerchantsInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @TableGenerator(name="MERCHANTSINFO_GEN",table="TBL_PRIMARY_KEY_GENERATOR",pkColumnName="KEY",valueColumnName="VALUE",pkColumnValue="MERCHANTSINFO_ID",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="MERCHANTSINFO_GEN")
    @Column(name = "merchants_info_id")
    private Long merchantsInfoId;
    @Size(max = 100)
    @Column(name = "merchants_title")    
    private String merchantsTitle;
    @Column(name = "enterprise_id")
    private Long enterpriseId;
    @Column(name = "enterprise_contact_id")
    private Long enterpriseContactId;
    @Column(name = "merchants_type")
    private Integer merchantsType;
    @Size(max = 100)
    @Column(name = "merchants_area")
    private String merchantsArea;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @Size(max = 100)
    @Column(name = "product_package")
    private String productPackage;
    @Size(max = 100)
    @Column(name = "product_spe")
    private String productSpe;   
    @Size(max = 50)
    @Column(name = "creator")
    private String creator;
    @Size(max = 50)
    @Column(name = "update_user")
    private String updateUser;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    
    public MerchantsInfo() {
    }

    public MerchantsInfo(Long merchantsInfoId) {
        this.merchantsInfoId = merchantsInfoId;
    }

    public Long getMerchantsInfoId() {
        return merchantsInfoId;
    }

    public void setMerchantsInfoId(Long merchantsInfoId) {
        this.merchantsInfoId = merchantsInfoId;
    }

    public String getMerchantsTitle() {
        return merchantsTitle;
    }

    public void setMerchantsTitle(String merchantsTitle) {
        this.merchantsTitle = merchantsTitle;
    }

    public Integer getMerchantsType() {
        return merchantsType;
    }

    public void setMerchantsType(Integer merchantsType) {
        this.merchantsType = merchantsType;
    }

    public String getMerchantsArea() {
        return merchantsArea;
    }

    public void setMerchantsArea(String merchantsArea) {
        this.merchantsArea = merchantsArea;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductPackage() {
        return productPackage;
    }

    public void setProductPackage(String productPackage) {
        this.productPackage = productPackage;
    }

    public String getProductSpe() {
        return productSpe;
    }

    public void setProductSpe(String productSpe) {
        this.productSpe = productSpe;
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

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getEnterpriseContactId() {
        return enterpriseContactId;
    }

    public void setEnterpriseContactId(Long enterpriseContactId) {
        this.enterpriseContactId = enterpriseContactId;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (merchantsInfoId != null ? merchantsInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MerchantsInfo)) {
            return false;
        }
        MerchantsInfo other = (MerchantsInfo) object;
        if ((this.merchantsInfoId == null && other.merchantsInfoId != null) || (this.merchantsInfoId != null && !this.merchantsInfoId.equals(other.merchantsInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.service.common.MerchantsInfo[ merchantsInfoId=" + merchantsInfoId + " ]";
    }
    
}
