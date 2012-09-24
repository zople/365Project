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
@Table(name = "admin_help")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminHelp.findAll", query = "SELECT a FROM AdminHelp a"),
    @NamedQuery(name = "AdminHelp.findById", query = "SELECT a FROM AdminHelp a WHERE a.id = :id"),
    @NamedQuery(name = "AdminHelp.findByClassName", query = "SELECT a FROM AdminHelp a WHERE a.className = :className"),
    @NamedQuery(name = "AdminHelp.findByContent", query = "SELECT a FROM AdminHelp a WHERE a.content = :content"),
    @NamedQuery(name = "AdminHelp.findByCreateTime", query = "SELECT a FROM AdminHelp a WHERE a.createTime = :createTime"),
    @NamedQuery(name = "AdminHelp.findByDescription", query = "SELECT a FROM AdminHelp a WHERE a.description = :description"),
    @NamedQuery(name = "AdminHelp.findByName", query = "SELECT a FROM AdminHelp a WHERE a.name = :name")})
public class AdminHelp implements Serializable {
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

    public AdminHelp() {
    }

    public AdminHelp(Long id) {
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
        if (!(object instanceof AdminHelp)) {
            return false;
        }
        AdminHelp other = (AdminHelp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.AdminHelp[ id=" + id + " ]";
    }
    
}
