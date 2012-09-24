/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "admin_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminOrder.findAll", query = "SELECT a FROM AdminOrder a"),
    @NamedQuery(name = "AdminOrder.findById", query = "SELECT a FROM AdminOrder a WHERE a.id = :id"),
    @NamedQuery(name = "AdminOrder.findByDescription", query = "SELECT a FROM AdminOrder a WHERE a.description = :description"),
    @NamedQuery(name = "AdminOrder.findByName", query = "SELECT a FROM AdminOrder a WHERE a.name = :name")})
public class AdminOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "orderId")
    private List<AdminOrderItem> adminOrderItemList=new ArrayList<AdminOrderItem>(0);

    public AdminOrder() {
    }

    public AdminOrder(Long id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<AdminOrderItem> getAdminOrderItemList() {
        return adminOrderItemList;
    }

    public void setAdminOrderItemList(List<AdminOrderItem> adminOrderItemList) {
        this.adminOrderItemList = adminOrderItemList;
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
        if (!(object instanceof AdminOrder)) {
            return false;
        }
        AdminOrder other = (AdminOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.AdminOrder[ id=" + id + " ]";
    }
    
}
