/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 * @描   述:企业新闻   
 * @author yuzhijian
 */
@Entity
@Table(name = "en_news")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnNews.findAll", query = "SELECT e FROM EnNews e"),
    @NamedQuery(name = "EnNews.findById", query = "SELECT e FROM EnNews e WHERE e.id = :id"),
    @NamedQuery(name = "EnNews.findByName", query = "SELECT e FROM EnNews e WHERE e.name = :name"),
    @NamedQuery(name = "EnNews.findByDescription", query = "SELECT e FROM EnNews e WHERE e.description = :description")})
public class EnNews implements Serializable {
    private static final long serialVersionUID = 1L;
   
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Size(max = 8)
    @Column(name = "addtime")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date addtime;
    @ManyToOne
    @JoinColumn(name = "en_enterprise_id", referencedColumnName = "id")
    private Enterprise enEnterpriseId;

    public Enterprise getEnEnterpriseId() {
        return enEnterpriseId;
    }

    public void setEnEnterpriseId(Enterprise enEnterpriseId) {
        this.enEnterpriseId = enEnterpriseId;
    }

    public EnNews() {
    }

    public EnNews(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnNews)) {
            return false;
        }
        EnNews other = (EnNews) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.EnNews[ id=" + id + " ]";
    }

  
}
