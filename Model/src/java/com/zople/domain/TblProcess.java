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
@Table(name = "tbl_process")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProcess.findAll", query = "SELECT t FROM TblProcess t"),
    @NamedQuery(name = "TblProcess.findById", query = "SELECT t FROM TblProcess t WHERE t.id = :id"),
    @NamedQuery(name = "TblProcess.findByAbility", query = "SELECT t FROM TblProcess t WHERE t.ability = :ability"),
    @NamedQuery(name = "TblProcess.findByDescription", query = "SELECT t FROM TblProcess t WHERE t.description = :description"),
    @NamedQuery(name = "TblProcess.findByDevice", query = "SELECT t FROM TblProcess t WHERE t.device = :device"),
    @NamedQuery(name = "TblProcess.findByKind", query = "SELECT t FROM TblProcess t WHERE t.kind = :kind"),
    @NamedQuery(name = "TblProcess.findByTitle", query = "SELECT t FROM TblProcess t WHERE t.title = :title")})
public class TblProcess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 100)
    @Column(name = "ability")
    private String ability;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @Size(max = 500)
    @Column(name = "device")
    private String device;
    @Size(max = 100)
    @Column(name = "kind")
    private String kind;
    @Size(max = 100)
    @Column(name = "title")
    private String title;

    public TblProcess() {
    }

    public TblProcess(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        if (!(object instanceof TblProcess)) {
            return false;
        }
        TblProcess other = (TblProcess) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.TblProcess[ id=" + id + " ]";
    }
    
}
