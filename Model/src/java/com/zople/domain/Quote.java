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
 * @author root
 */
@Entity
@Table(name = "tbl_quote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quote.findAll", query = "SELECT q FROM Quote q"),
    @NamedQuery(name = "Quote.findById", query = "SELECT q FROM Quote q WHERE q.id = :id"),
    @NamedQuery(name = "Quote.findByAddress", query = "SELECT q FROM Quote q WHERE q.address = :address"),
    @NamedQuery(name = "Quote.findByDescription", query = "SELECT q FROM Quote q WHERE q.description = :description"),
    @NamedQuery(name = "Quote.findByEnName", query = "SELECT q FROM Quote q WHERE q.enName = :enName"),
    @NamedQuery(name = "Quote.findByGood", query = "SELECT q FROM Quote q WHERE q.good = :good"),
    @NamedQuery(name = "Quote.findByName", query = "SELECT q FROM Quote q WHERE q.name = :name"),
    @NamedQuery(name = "Quote.findByPhone", query = "SELECT q FROM Quote q WHERE q.phone = :phone"),
    @NamedQuery(name = "Quote.findByPhoneName", query = "SELECT q FROM Quote q WHERE q.phoneName = :phoneName")})
public class Quote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "en_name")
    private String enName;
    @Size(max = 255)
    @Column(name = "good")
    private String good;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="电话/传真格式无效, 应为 xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "phone")
    private String phone;
    @Size(max = 255)
    @Column(name = "phone_name")
    private String phoneName;
     
    private Integer price;
    private String telPhone;
    public Quote() {
    }

    public Quote(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
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
        if (!(object instanceof Quote)) {
            return false;
        }
        Quote other = (Quote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.Quote[ id=" + id + " ]";
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }
    
}
