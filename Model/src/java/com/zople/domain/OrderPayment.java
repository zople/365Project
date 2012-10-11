/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "order_payment")
@NamedQueries({
    @NamedQuery(name = "OrderPayment.findAll", query = "SELECT o FROM OrderPayment o"),
    @NamedQuery(name = "OrderPayment.findById", query = "SELECT o FROM OrderPayment o WHERE o.id = :id"),
    @NamedQuery(name = "OrderPayment.findByOrderno", query = "SELECT o FROM OrderPayment o WHERE o.orderno = :orderno"),
    @NamedQuery(name = "OrderPayment.findByPayState", query = "SELECT o FROM OrderPayment o WHERE o.payState = :payState"),
    @NamedQuery(name = "OrderPayment.findByProductPrice", query = "SELECT o FROM OrderPayment o WHERE o.productPrice = :productPrice"),
    @NamedQuery(name = "OrderPayment.findByProductAccount", query = "SELECT o FROM OrderPayment o WHERE o.productAccount = :productAccount"),
    @NamedQuery(name = "OrderPayment.findByTransactionCode", query = "SELECT o FROM OrderPayment o WHERE o.transactionCode = :transactionCode"),
    @NamedQuery(name = "OrderPayment.findByOrderState", query = "SELECT o FROM OrderPayment o WHERE o.orderState = :orderState"),
    @NamedQuery(name = "OrderPayment.findByRemark", query = "SELECT o FROM OrderPayment o WHERE o.remark = :remark"),
    @NamedQuery(name = "OrderPayment.findByPayTime", query = "SELECT o FROM OrderPayment o WHERE o.payTime = :payTime")})
public class OrderPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(max = 32)
    @Column(name = "orderno", length = 32)
    private String orderno;
    @Column(name = "pay_state")
    private Short payState;
    @Size(max = 32)
    @Column(name = "product_price", length = 32)
    private String productPrice;
    @Size(max = 32)
    @Column(name = "product_account", length = 32)
    private String productAccount;
    @Size(max = 32)
    @Column(name = "transaction_code", length = 32)
    private String transactionCode;
    @Size(max = 32)
    @Column(name = "order_state", length = 32)
    private String orderState;
    @Size(max = 32)
    @Column(name = "remark", length = 32)
    private String remark;
    @Column(name = "pay_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date payTime;

    public OrderPayment() {
    }

    public OrderPayment(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public Short getPayState() {
        return payState;
    }

    public void setPayState(Short payState) {
        this.payState = payState;
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

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
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
        if (!(object instanceof OrderPayment)) {
            return false;
        }
        OrderPayment other = (OrderPayment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.OrderPayment[ id=" + id + " ]";
    }
    
}
