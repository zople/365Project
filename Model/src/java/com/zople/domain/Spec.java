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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *@描   述:   
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Entity
@Table(name = "tbl_spec")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spec.findAll", query = "SELECT s FROM Spec s"),
    @NamedQuery(name = "Spec.findById", query = "SELECT s FROM Spec s WHERE s.id = :id"),
    @NamedQuery(name = "Spec.findByCreateTime", query = "SELECT s FROM Spec s WHERE s.createTime = :createTime"),
    @NamedQuery(name = "Spec.findByDescription", query = "SELECT s FROM Spec s WHERE s.description = :description"),
    @NamedQuery(name = "Spec.findByName", query = "SELECT s FROM Spec s WHERE s.name = :name")})
public class Spec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "spec_serial", allocationSize = 1, initialValue = 1, sequenceName = "spec_serial")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spec_serial")
    @Column(name = "id")
    private Long id;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private Category category;
   

    public Spec() {
    }

    public Spec(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
        if (!(object instanceof Spec)) {
            return false;
        }
        Spec other = (Spec) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.Spec[ id=" + id + " ]";
    }

}
