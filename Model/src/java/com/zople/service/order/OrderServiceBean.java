/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service.order;

import com.zople.dao.order.OrderAuditFacade;
import com.zople.dao.order.OrderinfoFacade;
import com.zople.dao.order.OrderproductFacade;
import com.zople.domain.OrderOrderinfo;
import com.zople.domain.OrderAudit;
import com.zople.domain.OrderOrderproduct;
import com.zople.service.utils.OrderStateEnum;
import com.zople.service.utils.ServiceUtils;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * 订单处理Bean
 * @author 王文彦
 */
@Stateless
public class OrderServiceBean implements OrderServiceBeanLocal {

  @EJB
  OrderAuditFacade orderAuditFacade;//订单审核流程
  
  @EJB
  OrderinfoFacade orderinfoFacade; //订单信息管理
  
  @EJB
  OrderproductFacade orderproductFacade;//订单产品管理
   

  
    @Override
    public String SubmitOrder(OrderOrderinfo entity,long productId) {
          
         try{
        //保存订单信息
        entity.setOrderNo(ServiceUtils.getOrderUuId());//生成订单编号
        entity.setId(productId); 
        orderinfoFacade.create(entity);
        
            //供应产品信息取数保存到订单产品
        OrderOrderproduct orderOrderproduct = new OrderOrderproduct();
        orderOrderproduct.setId(productId);
        orderOrderproduct.setProductName("摄像头");
        orderproductFacade.create(orderOrderproduct);  
             
        //流程审核信息
     OrderAudit orderAudit = new OrderAudit();
        orderAudit.setAuditId(productId);
        orderAudit.setAuditState(new Integer(OrderStateEnum.ORDER_INITIAL_STATE.getCode()));//初始化状态
        orderAudit.setOrderno(entity.getOrderNo());
        orderAuditFacade.create(orderAudit); 
           
             
         }catch(Exception e){
             e.printStackTrace();
         }
          
         return ""; 
          
    }
  
  
    @Override
    public OrderOrderinfo createOrder(long enterprseId, long productId) {
        
       
        
        return null;
    }

  
    
    
}
