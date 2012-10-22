/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dto;

import java.math.BigInteger;

/**
 *
 * @author Administrator
 */
public class ProductDto {
    private Long id;  //产品ＩＤ
    private String name;  //产品名称
    private String productType;   //产品类型
    private String spec;    //产品规格
    private Long minOrderAmount;  //最小订购量
    private Long inventoryAmount;   //
    private Integer status;      //
    private String specificationsPrice;     //产品单价
    private BigInteger speStockQuantity;    //产品库存量
    private int count;   //订购数量
    private String enterpriseName;  //企业名称
    private String contactName;   //企业联系人名称
    private Long enterpriseId;   //企业ID

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Long getMinOrderAmount() {
        return minOrderAmount;
    }

    public void setMinOrderAmount(Long minOrderAmount) {
        this.minOrderAmount = minOrderAmount;
    }

    public Long getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(Long inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSpecificationsPrice() {
        return specificationsPrice;
    }

    public void setSpecificationsPrice(String specificationsPrice) {
        this.specificationsPrice = specificationsPrice;
    }

    public BigInteger getSpeStockQuantity() {
        return speStockQuantity;
    }

    public void setSpeStockQuantity(BigInteger speStockQuantity) {
        this.speStockQuantity = speStockQuantity;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
}

