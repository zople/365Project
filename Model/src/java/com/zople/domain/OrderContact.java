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
 * @author 王文彦
 */
@Entity
@Table(name = "order_contact")
@NamedQueries({
    @NamedQuery(name = "OrderContact.findAll", query = "SELECT o FROM OrderContact o"),
    @NamedQuery(name = "OrderContact.findById", query = "SELECT o FROM OrderContact o WHERE o.id = :id"),
    @NamedQuery(name = "OrderContact.findByConsignee", query = "SELECT o FROM OrderContact o WHERE o.consignee = :consignee"),
    @NamedQuery(name = "OrderContact.findByConsigneeModel", query = "SELECT o FROM OrderContact o WHERE o.consigneeModel = :consigneeModel"),
    @NamedQuery(name = "OrderContact.findByPhone", query = "SELECT o FROM OrderContact o WHERE o.phone = :phone"),
    @NamedQuery(name = "OrderContact.findByMobile", query = "SELECT o FROM OrderContact o WHERE o.mobile = :mobile"),
    @NamedQuery(name = "OrderContact.findByZipCode", query = "SELECT o FROM OrderContact o WHERE o.zipCode = :zipCode"),
    @NamedQuery(name = "OrderContact.findByAddress", query = "SELECT o FROM OrderContact o WHERE o.address = :address"),
    @NamedQuery(name = "OrderContact.findBySignUser", query = "SELECT o FROM OrderContact o WHERE o.signUser = :signUser")})
public class OrderContact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(max = 32)
    @Column(name = "consignee", length = 32)
    private String consignee;
    @Size(max = 32)
    @Column(name = "consignee_model", length = 32)
    private String consigneeModel;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 32)
    @Column(name = "phone", length = 32)
    private String phone;
    @Size(max = 32)
    @Column(name = "mobile", length = 32)
    private String mobile;
    @Size(max = 10)
    @Column(name = "zip_code", length = 10)
    private String zipCode;
    @Size(max = 32)
    @Column(name = "address", length = 32)
    private String address;
    @Size(max = 32)
    @Column(name = "sign_user", length = 32)
    private String signUser;

    public OrderContact() {
    }

    public OrderContact(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getConsigneeModel() {
        return consigneeModel;
    }

    public void setConsigneeModel(String consigneeModel) {
        this.consigneeModel = consigneeModel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSignUser() {
        return signUser;
    }

    public void setSignUser(String signUser) {
        this.signUser = signUser;
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
        if (!(object instanceof OrderContact)) {
            return false;
        }
        OrderContact other = (OrderContact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.OrderContact[ id=" + id + " ]";
    }
    
}
