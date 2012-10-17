/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author think
 */
public class OrderDto implements Serializable {

    private Long id;
    private String orderNo;
    private String productName;
    private Date finishTime;
    private String productPrice;
    private String productAccount;
    private String productTotal;
    private String orderState;

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

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
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
}
