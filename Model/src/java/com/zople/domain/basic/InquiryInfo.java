/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain.basic;

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
 * @author wangxiu
 */
@Entity
@Table(name = "inquiry_info")
@NamedQueries({
    @NamedQuery(name = "InquiryInfo.findAll", query = "SELECT i FROM InquiryInfo i"),
    @NamedQuery(name = "InquiryInfo.findByInquiryId", query = "SELECT i FROM InquiryInfo i WHERE i.inquiryId = :inquiryId"),
    @NamedQuery(name = "InquiryInfo.findByContentId", query = "SELECT i FROM InquiryInfo i WHERE i.contentId = :contentId"),
    @NamedQuery(name = "InquiryInfo.findByInquiryType", query = "SELECT i FROM InquiryInfo i WHERE i.inquiryType = :inquiryType"),
    @NamedQuery(name = "InquiryInfo.findByInquiryTitle", query = "SELECT i FROM InquiryInfo i WHERE i.inquiryTitle = :inquiryTitle"),
    @NamedQuery(name = "InquiryInfo.findByInquiryContent", query = "SELECT i FROM InquiryInfo i WHERE i.inquiryContent = :inquiryContent"),
    @NamedQuery(name = "InquiryInfo.findByQuestionerId", query = "SELECT i FROM InquiryInfo i WHERE i.questionerId = :questionerId"),
    @NamedQuery(name = "InquiryInfo.findByAnswerId", query = "SELECT i FROM InquiryInfo i WHERE i.answerId = :answerId"),
    @NamedQuery(name = "InquiryInfo.findByReply", query = "SELECT i FROM InquiryInfo i WHERE i.reply = :reply"),
    @NamedQuery(name = "InquiryInfo.findByCreator", query = "SELECT i FROM InquiryInfo i WHERE i.creator = :creator"),
    @NamedQuery(name = "InquiryInfo.findByUpdateUser", query = "SELECT i FROM InquiryInfo i WHERE i.updateUser = :updateUser"),
    @NamedQuery(name = "InquiryInfo.findByUpdateTime", query = "SELECT i FROM InquiryInfo i WHERE i.updateTime = :updateTime"),
    @NamedQuery(name = "InquiryInfo.findByCreateTime", query = "SELECT i FROM InquiryInfo i WHERE i.createTime = :createTime")})
public class InquiryInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "inquiry_id")
    private Long inquiryId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "content_id")
    private long contentId;
    @Column(name = "inquiry_type")
    private Integer inquiryType;
    @Size(max = 50)
    @Column(name = "inquiry_title")
    private String inquiryTitle;
    @Size(max = 200)
    @Column(name = "inquiry_content")
    private String inquiryContent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "questioner_id")
    private long questionerId;
    @Column(name = "answer_id")
    private BigInteger answerId;
    @Size(max = 200)
    @Column(name = "reply")
    private String reply;
    @Size(max = 50)
    @Column(name = "creator")
    private String creator;
    @Size(max = 50)
    @Column(name = "update_user")
    private String updateUser;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIME)
    private Date updateTime;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    public InquiryInfo() {
    }

    public InquiryInfo(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    public InquiryInfo(Long inquiryId, long contentId, long questionerId) {
        this.inquiryId = inquiryId;
        this.contentId = contentId;
        this.questionerId = questionerId;
    }

    public Long getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    public long getContentId() {
        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    public Integer getInquiryType() {
        return inquiryType;
    }

    public void setInquiryType(Integer inquiryType) {
        this.inquiryType = inquiryType;
    }

    public String getInquiryTitle() {
        return inquiryTitle;
    }

    public void setInquiryTitle(String inquiryTitle) {
        this.inquiryTitle = inquiryTitle;
    }

    public String getInquiryContent() {
        return inquiryContent;
    }

    public void setInquiryContent(String inquiryContent) {
        this.inquiryContent = inquiryContent;
    }

    public long getQuestionerId() {
        return questionerId;
    }

    public void setQuestionerId(long questionerId) {
        this.questionerId = questionerId;
    }

    public BigInteger getAnswerId() {
        return answerId;
    }

    public void setAnswerId(BigInteger answerId) {
        this.answerId = answerId;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
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
        hash += (inquiryId != null ? inquiryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InquiryInfo)) {
            return false;
        }
        InquiryInfo other = (InquiryInfo) object;
        if ((this.inquiryId == null && other.inquiryId != null) || (this.inquiryId != null && !this.inquiryId.equals(other.inquiryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.service.common.InquiryInfo[ inquiryId=" + inquiryId + " ]";
    }
    
}
