/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "m_mymall")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MMymall.findAll", query = "SELECT m FROM MMymall m"),
    @NamedQuery(name = "MMymall.findById", query = "SELECT m FROM MMymall m WHERE m.id = :id"),
    @NamedQuery(name = "MMymall.findByAd", query = "SELECT m FROM MMymall m WHERE m.ad = :ad"),
    @NamedQuery(name = "MMymall.findByDescribes", query = "SELECT m FROM MMymall m WHERE m.describes = :describes"),
    @NamedQuery(name = "MMymall.findByLogo", query = "SELECT m FROM MMymall m WHERE m.logo = :logo"),
    @NamedQuery(name = "MMymall.findByName", query = "SELECT m FROM MMymall m WHERE m.name = :name"),
    @NamedQuery(name = "MMymall.findByStyle", query = "SELECT m FROM MMymall m WHERE m.style = :style")})
public class MMymall implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "ad")
    private String ad;
    @Size(max = 255)
    @Column(name = "describes")
    private String describes;
    @Column(name = "logo")
    private BigInteger logo;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 100)
    @Column(name = "style")
    private String style;

    public MMymall() {
    }

    public MMymall(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public BigInteger getLogo() {
        return logo;
    }

    public void setLogo(BigInteger logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
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
        if (!(object instanceof MMymall)) {
            return false;
        }
        MMymall other = (MMymall) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.MMymall[ id=" + id + " ]";
    }
    
}
