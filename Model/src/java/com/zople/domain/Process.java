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

/**
 *
 * @author wangxiu
 */
@Entity
@Table(name = "tbl_process")
@NamedQueries({
    @NamedQuery(name = "Process.findAll", query = "SELECT p FROM Process p"),
    @NamedQuery(name = "Process.findById", query = "SELECT p FROM Process p WHERE p.id = :id"),
    @NamedQuery(name = "Process.findByTitle", query = "SELECT p FROM Process p WHERE p.title = :title"),
    @NamedQuery(name = "Process.findByKind", query = "SELECT p FROM Process p WHERE p.kind = :kind"),
    @NamedQuery(name = "Process.findByDevice", query = "SELECT p FROM Process p WHERE p.device = :device"),
    @NamedQuery(name = "Process.findByAbility", query = "SELECT p FROM Process p WHERE p.ability = :ability"),
    @NamedQuery(name = "Process.findByDescription", query = "SELECT p FROM Process p WHERE p.description = :description")})
public class Process implements Serializable {
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

    public Process() {
    }

    public Process(Long id) {
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
        if (!(object instanceof Process)) {
            return false;
        }
        Process other = (Process) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.Process[ id=" + id + " ]";
    }
    
}
