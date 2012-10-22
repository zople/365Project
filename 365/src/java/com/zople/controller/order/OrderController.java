/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zople.controller.order;

import com.zople.domain.OrderOrderinfo;
import com.zople.service.order.OrderServiceBeanLocal;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *@描   述:  订单管理 
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Named("orderController")
@SessionScoped
public class OrderController implements Serializable {

    
   //加载订单管理Server
    @EJB
    OrderServiceBeanLocal orderServiceBeanLocal;
    
    //页面参数
     private Long productId;//供应产品ID
     private BigDecimal   price;//单价
     private String       productName;//产品名称
     private Long         num;//产品数量
     private BigDecimal   subtotal;//总金额
     
    
    /**
     * 提交订单
     * 
     */
    public String submitOrder(){
        
     try{   
      OrderOrderinfo entity = new OrderOrderinfo();  
      
      entity.setSaleAmount(subtotal);//销售总价
      orderServiceBeanLocal.SubmitOrder(entity,productId);
     
     }catch(Exception e){
         e.printStackTrace();
     }
      
        return "";
    }
    

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    
     
    
    
    
    

}
