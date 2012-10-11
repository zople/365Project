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
@Table(name = "tbl_qualification_certificate")
@NamedQueries({
    @NamedQuery(name = "TblQualificationCertificate.findAll", query = "SELECT t FROM TblQualificationCertificate t"),
    @NamedQuery(name = "TblQualificationCertificate.findById", query = "SELECT t FROM TblQualificationCertificate t WHERE t.id = :id"),
    @NamedQuery(name = "TblQualificationCertificate.findByEnterpriseId", query = "SELECT t FROM TblQualificationCertificate t WHERE t.enterpriseId = :enterpriseId"),
    @NamedQuery(name = "TblQualificationCertificate.findByCertificateType", query = "SELECT t FROM TblQualificationCertificate t WHERE t.certificateType = :certificateType"),
    @NamedQuery(name = "TblQualificationCertificate.findByCertificatePath", query = "SELECT t FROM TblQualificationCertificate t WHERE t.certificatePath = :certificatePath"),
    @NamedQuery(name = "TblQualificationCertificate.findByIsCertificate", query = "SELECT t FROM TblQualificationCertificate t WHERE t.isCertificate = :isCertificate"),
    @NamedQuery(name = "TblQualificationCertificate.findByCreator", query = "SELECT t FROM TblQualificationCertificate t WHERE t.creator = :creator"),
    @NamedQuery(name = "TblQualificationCertificate.findByUpdateUser", query = "SELECT t FROM TblQualificationCertificate t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TblQualificationCertificate.findByUpdateTime", query = "SELECT t FROM TblQualificationCertificate t WHERE t.updateTime = :updateTime"),
    @NamedQuery(name = "TblQualificationCertificate.findByCreateTime", query = "SELECT t FROM TblQualificationCertificate t WHERE t.createTime = :createTime")})
public class TblQualificationCertificate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "enterprise_id")
    private BigInteger enterpriseId;
    @Size(max = 20)
    @Column(name = "certificate_type", length = 20)
    private String certificateType;
    @Size(max = 20)
    @Column(name = "certificate_path", length = 20)
    private String certificatePath;
    @Column(name = "is_certificate")
    private BigInteger isCertificate;
    @Size(max = 20)
    @Column(name = "creator", length = 20)
    private String creator;
    @Size(max = 20)
    @Column(name = "update_user", length = 20)
    private String updateUser;
    @Column(name = "update_time")
    @Temporal(TemporalType.DATE)
    private Date updateTime;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;

    public TblQualificationCertificate() {
    }

    public TblQualificationCertificate(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(BigInteger enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificatePath() {
        return certificatePath;
    }

    public void setCertificatePath(String certificatePath) {
        this.certificatePath = certificatePath;
    }

    public BigInteger getIsCertificate() {
        return isCertificate;
    }

    public void setIsCertificate(BigInteger isCertificate) {
        this.isCertificate = isCertificate;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblQualificationCertificate)) {
            return false;
        }
        TblQualificationCertificate other = (TblQualificationCertificate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.TblQualificationCertificate[ id=" + id + " ]";
    }
    
}
