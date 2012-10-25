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
@Table(name = "industry_news")
@NamedQueries({
    @NamedQuery(name = "IndustryNews.findAll", query = "SELECT i FROM IndustryNews i"),
    @NamedQuery(name = "IndustryNews.findByIndustryNewsId", query = "SELECT i FROM IndustryNews i WHERE i.industryNewsId = :industryNewsId"),
    @NamedQuery(name = "IndustryNews.findByNewsType", query = "SELECT i FROM IndustryNews i WHERE i.newsType = :newsType"),
    @NamedQuery(name = "IndustryNews.findByNewsTitle", query = "SELECT i FROM IndustryNews i WHERE i.newsTitle = :newsTitle"),
    @NamedQuery(name = "IndustryNews.findByNewsContent", query = "SELECT i FROM IndustryNews i WHERE i.newsContent = :newsContent"),
    @NamedQuery(name = "IndustryNews.findByCreator", query = "SELECT i FROM IndustryNews i WHERE i.creator = :creator"),
    @NamedQuery(name = "IndustryNews.findByUpdateUser", query = "SELECT i FROM IndustryNews i WHERE i.updateUser = :updateUser"),
    @NamedQuery(name = "IndustryNews.findByUpdateTime", query = "SELECT i FROM IndustryNews i WHERE i.updateTime = :updateTime"),
    @NamedQuery(name = "IndustryNews.findByCreateTime", query = "SELECT i FROM IndustryNews i WHERE i.createTime = :createTime")})
public class IndustryNews implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name="INDUSTRYNEWS_GEN",table="TBL_PRIMARY_KEY_GENERATOR",pkColumnName="KEY",valueColumnName="VALUE",pkColumnValue="INDUSTRYNEWS_ID",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="INDUSTRYNEWS_GEN")
    @Basic(optional = false)
    @NotNull
    @Column(name = "industry_news_id")
    private Long industryNewsId;
    @Column(name = "news_type")
    private Long newsType;
    @Size(max = 100)
    @Column(name = "news_title")
    private String newsTitle;
    @Size(max = 200)
    @Column(name = "news_content")
    private String newsContent;
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

    public IndustryNews() {
    }

    public IndustryNews(Long industryNewsId) {
        this.industryNewsId = industryNewsId;
    }

    public Long getIndustryNewsId() {
        return industryNewsId;
    }

    public void setIndustryNewsId(Long industryNewsId) {
        this.industryNewsId = industryNewsId;
    }

    public Long getNewsType() {
        return newsType;
    }

    public void setNewsType(Long newsType) {
        this.newsType = newsType;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
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
        hash += (industryNewsId != null ? industryNewsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndustryNews)) {
            return false;
        }
        IndustryNews other = (IndustryNews) object;
        if ((this.industryNewsId == null && other.industryNewsId != null) || (this.industryNewsId != null && !this.industryNewsId.equals(other.industryNewsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.service.common.IndustryNews[ industryNewsId=" + industryNewsId + " ]";
    }
    
}
