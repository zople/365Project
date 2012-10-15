/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service;

import com.zople.domain.OrderOrderinfo;
import java.util.UUID;
import javax.ejb.Stateless;

/**
 * 订单处理Bean
 * @author 王文彦
 */
@Stateless
public class OrderServiceBean implements OrderServiceBeanLocal {
    
    

    @Override
    public OrderOrderinfo createOrder(long enterprseId, long productId) {
        OrderOrderinfo order=new OrderOrderinfo();
        
        //订单信息
        
       //供应产品信息取数保存到订单产品表
        
        
        //
        
        
        
        
        
        
        
        return null;
    }

    @Override
    public String orderCodeGenerator() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    
    
}
