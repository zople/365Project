/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zople.service;

import com.zople.dao.OrderAuditFacade;
import com.zople.domain.OrderAudit;
import java.util.List;
import javax.ejb.EJB;

/**
 *@描   述:  订单审核流程记录
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
public class OrderAuditServer {
  
  @EJB
  OrderAuditFacade facade;
    
    
  /**
   * 添加记录流程记录
   * orderno    订单编号
   * audit_state 0（待付款|初始状态） 1（已付款|待发货） 2(已发货|待确认付款)  3（退款|等待确认退款） 4（等待确认退款） 5完成交易 6关闭 
   * 
   * content   流程审批过程中的意见内容
   *  
   */
   public void createPosition(String orderno,int state,String content) {
       
       OrderAudit orderAudit = new OrderAudit();
       orderAudit.setAuditContent(content);
       orderAudit.setAuditState(state);
       orderAudit.setOrderno(orderno);
       
        facade.create(orderAudit);
    }

   /*
    * 查看指定订单的流程
    * orderno  订单编号
    * return list;
    */
    public List<OrderAudit> findAll(String orderno) {
        String sql="select o from OrderAudit o where o.orderno='"+orderno+"'";
        return facade.getOrderAuditList(sql);
    }
    
}
