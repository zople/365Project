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
@Table(name = "tbl_pavilion")
@NamedQueries({
    @NamedQuery(name = "Pavilion.findAll", query = "SELECT p FROM Pavilion p"),
    @NamedQuery(name = "Pavilion.findById", query = "SELECT p FROM Pavilion p WHERE p.id = :id"),
    @NamedQuery(name = "Pavilion.findByDescription", query = "SELECT p FROM Pavilion p WHERE p.description = :description"),
    @NamedQuery(name = "Pavilion.findByWay", query = "SELECT p FROM Pavilion p WHERE p.way = :way"),
    @NamedQuery(name = "Pavilion.findByUrl", query = "SELECT p FROM Pavilion p WHERE p.url = :url"),
    @NamedQuery(name = "Pavilion.findByLinkman", query = "SELECT p FROM Pavilion p WHERE p.linkman = :linkman"),
    @NamedQuery(name = "Pavilion.findByTelphone", query = "SELECT p FROM Pavilion p WHERE p.telphone = :telphone"),
    @NamedQuery(name = "Pavilion.findByFax", query = "SELECT p FROM Pavilion p WHERE p.fax = :fax"),
    @NamedQuery(name = "Pavilion.findByAddress", query = "SELECT p FROM Pavilion p WHERE p.address = :address")})
public class Pavilion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 200)
    @Column(name = "description")
    private String description;
    @Size(max = 200)
    @Column(name = "way")
    private String way;
    @Size(max = 100)
    @Column(name = "url")
    private String url;
    @Size(max = 100)
    @Column(name = "linkman")
    private String linkman;
    @Size(max = 100)
    @Column(name = "telphone")
    private String telphone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="电话/传真格式无效, 应为 xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "fax")
    private String fax;
    @Size(max = 200)
    @Column(name = "address")
    private String address;
    private byte[] big;

    public Pavilion() {
    }

    public Pavilion(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        if (!(object instanceof Pavilion)) {
            return false;
        }
        Pavilion other = (Pavilion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.Pavilion[ id=" + id + " ]";
    }

    public byte[] getBig() {
        return big;
    }

    public void setBig(byte[] big) {
        this.big = big;
    }
    
}
