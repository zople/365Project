/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "tbl_friendly_link")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblFriendlyLink.findAll", query = "SELECT t FROM TblFriendlyLink t"),
    @NamedQuery(name = "TblFriendlyLink.findById", query = "SELECT t FROM TblFriendlyLink t WHERE t.id = :id"),
    @NamedQuery(name = "TblFriendlyLink.findByContent", query = "SELECT t FROM TblFriendlyLink t WHERE t.content = :content"),
    @NamedQuery(name = "TblFriendlyLink.findByCreateTime", query = "SELECT t FROM TblFriendlyLink t WHERE t.createTime = :createTime"),
    @NamedQuery(name = "TblFriendlyLink.findByDescription", query = "SELECT t FROM TblFriendlyLink t WHERE t.description = :description"),
    @NamedQuery(name = "TblFriendlyLink.findByName", query = "SELECT t FROM TblFriendlyLink t WHERE t.name = :name")})
public class TblFriendlyLink implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 100)
    @Column(name = "content")
    private String content;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 100)
    @Column(name = "name")
    private String name;

    public TblFriendlyLink() {
    }

    public TblFriendlyLink(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFriendlyLink)) {
            return false;
        }
        TblFriendlyLink other = (TblFriendlyLink) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.TblFriendlyLink[ id=" + id + " ]";
    }
    
}
