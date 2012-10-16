/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author wangxiu
 * 订单商品表供应
 */
@Entity
@Table(name = "order_orderproduct")
@NamedQueries({
    @NamedQuery(name = "OrderOrderproduct.findAll", query = "SELECT o FROM OrderOrderproduct o"),
    @NamedQuery(name = "OrderOrderproduct.findById", query = "SELECT o FROM OrderOrderproduct o WHERE o.id = :id"),
    @NamedQuery(name = "OrderOrderproduct.findByProductName", query = "SELECT o FROM OrderOrderproduct o WHERE o.productName = :productName"),
    @NamedQuery(name = "OrderOrderproduct.findByProductPrice", query = "SELECT o FROM OrderOrderproduct o WHERE o.productPrice = :productPrice"),
    @NamedQuery(name = "OrderOrderproduct.findByProductAccount", query = "SELECT o FROM OrderOrderproduct o WHERE o.productAccount = :productAccount"),
    @NamedQuery(name = "OrderOrderproduct.findByProductTotal", query = "SELECT o FROM OrderOrderproduct o WHERE o.productTotal = :productTotal"),
    @NamedQuery(name = "OrderOrderproduct.findByOrderState", query = "SELECT o FROM OrderOrderproduct o WHERE o.orderState = :orderState")})
public class OrderOrderproduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name="ORDERORDERPRODUCT_GEN",table="TBL_PRIMARY_KEY_GENERATOR",pkColumnName="KEY",valueColumnName="VALUE",pkColumnValue="ORDERORDERINFO_ID",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="ORDERORDERPRODUCT_GEN")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 32)
    @Column(name = "product_name")
    private String productName;
    @Size(max = 32)
    @Column(name = "product_price")
    private String productPrice;
    @Size(max = 32)
    @Column(name = "product_account")
    private String productAccount;
    @Size(max = 32)
    @Column(name = "product_total")
    private String productTotal;
    @Size(max = 32)
    @Column(name = "order_state")
    private String orderState;
    
    @ManyToOne
    @JoinColumn(name="order_no",referencedColumnName="order_no")
    private OrderOrderinfo Orderinfo;

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

    public OrderOrderinfo getOrderinfo() {
        return Orderinfo;
    }

    public void setOrderinfo(OrderOrderinfo Orderinfo) {
        this.Orderinfo = Orderinfo;
    }
    
}
