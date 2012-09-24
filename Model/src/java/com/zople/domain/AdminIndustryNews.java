/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
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
@Table(name = "admin_industry_news")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminIndustryNews.findAll", query = "SELECT a FROM AdminIndustryNews a"),
    @NamedQuery(name = "AdminIndustryNews.findById", query = "SELECT a FROM AdminIndustryNews a WHERE a.id = :id"),
    @NamedQuery(name = "AdminIndustryNews.findByClassName", query = "SELECT a FROM AdminIndustryNews a WHERE a.className = :className"),
    @NamedQuery(name = "AdminIndustryNews.findByClassTitle", query = "SELECT a FROM AdminIndustryNews a WHERE a.classTitle = :classTitle"),
    @NamedQuery(name = "AdminIndustryNews.findByContent", query = "SELECT a FROM AdminIndustryNews a WHERE a.content = :content"),
    @NamedQuery(name = "AdminIndustryNews.findByDescription", query = "SELECT a FROM AdminIndustryNews a WHERE a.description = :description")})
public class AdminIndustryNews implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 100)
    @Column(name = "class_name")
    private String className;
    @Size(max = 100)
    @Column(name = "class_title")
    private String classTitle;
    @Size(max = 255)
    @Column(name = "content")
    private String content;
    @Size(max = 255)
    @Column(name = "description")
    private String description;

    public AdminIndustryNews() {
    }

    public AdminIndustryNews(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassTitle() {
        return classTitle;
    }

    public void setClassTitle(String classTitle) {
        this.classTitle = classTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        if (!(object instanceof AdminIndustryNews)) {
            return false;
        }
        AdminIndustryNews other = (AdminIndustryNews) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.AdminIndustryNews[ id=" + id + " ]";
    }
    
}
