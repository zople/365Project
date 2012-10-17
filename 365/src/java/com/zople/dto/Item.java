/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dto;

/**
 *
 * @author zhangyan
 */
public class Item {
    
    private String id;
    private String amount;

    public Item(String id, String amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    
}
