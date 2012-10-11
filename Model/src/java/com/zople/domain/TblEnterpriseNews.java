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
@Table(name = "tbl_enterprise_news")
@NamedQueries({
    @NamedQuery(name = "TblEnterpriseNews.findAll", query = "SELECT t FROM TblEnterpriseNews t"),
    @NamedQuery(name = "TblEnterpriseNews.findById", query = "SELECT t FROM TblEnterpriseNews t WHERE t.id = :id"),
    @NamedQuery(name = "TblEnterpriseNews.findByEnterpriseId", query = "SELECT t FROM TblEnterpriseNews t WHERE t.enterpriseId = :enterpriseId"),
    @NamedQuery(name = "TblEnterpriseNews.findByContentTitle", query = "SELECT t FROM TblEnterpriseNews t WHERE t.contentTitle = :contentTitle"),
    @NamedQuery(name = "TblEnterpriseNews.findByNewsContent", query = "SELECT t FROM TblEnterpriseNews t WHERE t.newsContent = :newsContent"),
    @NamedQuery(name = "TblEnterpriseNews.findByCreator", query = "SELECT t FROM TblEnterpriseNews t WHERE t.creator = :creator"),
    @NamedQuery(name = "TblEnterpriseNews.findByUpdateUser", query = "SELECT t FROM TblEnterpriseNews t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TblEnterpriseNews.findByUpdateTime", query = "SELECT t FROM TblEnterpriseNews t WHERE t.updateTime = :updateTime"),
    @NamedQuery(name = "TblEnterpriseNews.findByCreateTime", query = "SELECT t FROM TblEnterpriseNews t WHERE t.createTime = :createTime")})
public class TblEnterpriseNews implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "enterprise_id")
    private BigInteger enterpriseId;
    @Size(max = 20)
    @Column(name = "content_title", length = 20)
    private String contentTitle;
    @Size(max = 500)
    @Column(name = "news_content", length = 500)
    private String newsContent;
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

    public TblEnterpriseNews() {
    }

    public TblEnterpriseNews(Long id) {
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

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
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
        if (!(object instanceof TblEnterpriseNews)) {
            return false;
        }
        TblEnterpriseNews other = (TblEnterpriseNews) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.TblEnterpriseNews[ id=" + id + " ]";
    }
    
}
