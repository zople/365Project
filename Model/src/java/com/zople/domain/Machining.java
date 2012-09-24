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
 *@描   述:   加工管理
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Entity
@Table(name = "tbl_machining")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Machining.findAll", query = "SELECT m FROM Machining m"),
    @NamedQuery(name = "Machining.findById", query = "SELECT m FROM Machining m WHERE m.id = :id"),
    @NamedQuery(name = "Machining.findByTitle", query = "SELECT m FROM Machining m WHERE m.title = :title"),
    @NamedQuery(name = "Machining.findByKind", query = "SELECT m FROM Machining m WHERE m.kind = :kind"),
    @NamedQuery(name = "Machining.findByDevice", query = "SELECT m FROM Machining m WHERE m.device = :device"),
    @NamedQuery(name = "Machining.findByAbility", query = "SELECT m FROM Machining m WHERE m.ability = :ability"),
    @NamedQuery(name = "Machining.findByDescription", query = "SELECT m FROM Machining m WHERE m.description = :description")})
public class Machining implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 100)
    @Column(name = "title")
    private String title;
    @Size(max = 100)
    @Column(name = "kind")
    private String kind;
    @Size(max = 500)
    @Column(name = "device")
    private String device;
    @Size(max = 100)
    @Column(name = "ability")
    private String ability;
    @Size(max = 100)
    @Column(name = "description")
    private String description;

    public Machining() {
    }

    public Machining(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
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
        if (!(object instanceof Machining)) {
            return false;
        }
        Machining other = (Machining) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.Machining[ id=" + id + " ]";
    }

}
