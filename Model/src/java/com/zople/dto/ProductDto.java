/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dto;

/**
 *
 * @author Administrator
 */
public class ProductDto {
    private Long id;
    private String name;
    private String productType;
    private String spec;
    private Long minOrderAmount;
    private Long inventoryAmount;
    private Integer status;

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
}
