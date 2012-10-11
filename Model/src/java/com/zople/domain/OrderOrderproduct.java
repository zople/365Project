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
@Table(name = "order_orderproduct")
@NamedQueries({
    @NamedQuery(name = "OrderOrderproduct.findAll", query = "SELECT o FROM OrderOrderproduct o"),
    @NamedQuery(name = "OrderOrderproduct.findById", query = "SELECT o FROM OrderOrderproduct o WHERE o.id = :id"),
    @NamedQuery(name = "OrderOrderproduct.findByOrderNo", query = "SELECT o FROM OrderOrderproduct o WHERE o.orderNo = :orderNo"),
    @NamedQuery(name = "OrderOrderproduct.findByProductName", query = "SELECT o FROM OrderOrderproduct o WHERE o.productName = :productName"),
    @NamedQuery(name = "OrderOrderproduct.findByProductPrice", query = "SELECT o FROM OrderOrderproduct o WHERE o.productPrice = :productPrice"),
    @NamedQuery(name = "OrderOrderproduct.findByProductAccount", query = "SELECT o FROM OrderOrderproduct o WHERE o.productAccount = :productAccount"),
    @NamedQuery(name = "OrderOrderproduct.findByProductTotal", query = "SELECT o FROM OrderOrderproduct o WHERE o.productTotal = :productTotal"),
    @NamedQuery(name = "OrderOrderproduct.findByOrderState", query = "SELECT o FROM OrderOrderproduct o WHERE o.orderState = :orderState")})
public class OrderOrderproduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(max = 32)
    @Column(name = "order_no", length = 32)
    private String orderNo;
    @Size(max = 32)
    @Column(name = "product_name", length = 32)
    private String productName;
    @Size(max = 32)
    @Column(name = "product_price", length = 32)
    private String productPrice;
    @Size(max = 32)
    @Column(name = "product_account", length = 32)
    private String productAccount;
    @Size(max = 32)
    @Column(name = "product_total", length = 32)
    private String productTotal;
    @Size(max = 32)
    @Column(name = "order_state", length = 32)
    private String orderState;

    public OrderOrderproduct() {
    }

    public OrderOrderproduct(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductAccount() {
        return productAccount;
    }

    public void setProductAccount(String productAccount) {
        this.productAccount = productAccount;
    }

    public String getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(String productTotal) {
        this.productTotal = productTotal;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
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
        if (!(object instanceof OrderOrderproduct)) {
            return false;
        }
        OrderOrderproduct other = (OrderOrderproduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.OrderOrderproduct[ id=" + id + " ]";
    }
    
}
