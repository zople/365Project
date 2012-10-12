/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller.util;

/**
 *@描   述:  订单状态枚举
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
public enum OrderStateEnum {
    
   
  INITIAL_STATE(0,"等待买家付款","等待买家付款","该状态为订单初始化状态，买家可以进行付款，和找人代付"),
  PAYMENT_STATE(1,"等待卖家发货","买家已经付款",""),
  SHIPMENTS_STATE(2,"卖家已经发货","等待买家确认付款","");
    
    
    
   
    //数字状态
    private int code;
    //买家显示状态
    private String buyname;
    //卖家显示状态
    private String sellname;
    //状态描述
    private String description;
    
    
    /***
     * 根据状态查询买家显示名称
     * 
     * return buyname
     */ 
     public static String getBuyname(int code) {   
        for (OrderStateEnum c : OrderStateEnum.values()) {   
             if (c.getCode() == code) {   
               return c.buyname;   
             }   
         }   
         return null;   
     }   

    
    /***
     * 根据状态 查询卖家显示名称
     * 
     * return sellname
     */ 
     public static String getSellname(int code) {   
        for (OrderStateEnum c : OrderStateEnum.values()) {   
             if (c.getCode() == code) {   
               return c.sellname;   
             }   
         }   
         return null;   
     }   

    
    
     // 构造方法   
     private OrderStateEnum(int code,String buyname,String sellname,String description) { 
       this.code = code;
       this.buyname = buyname;   
       this.sellname = sellname;  
       this.description =description;
    }   

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBuyname() {
        return buyname;
    }

    public void setBuyname(String buyname) {
        this.buyname = buyname;
    }

    public String getSellname() {
        return sellname;
    }

    public void setSellname(String sellname) {
        this.sellname = sellname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    

  
    
    
    
    
    
}
