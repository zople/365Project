/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service.order;

import com.zople.dao.order.OrderAuditFacade;
import com.zople.domain.OrderAudit;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *@描   述:  流程审核表
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Stateless
public class OrderAuditServiceBean implements OrderAuditServiceBeanLocal {
    @EJB
    OrderAuditFacade orderAuditFacade;

    @Override
    public OrderAudit getOrderAudit(String flow_no) {
        
        OrderAudit orderAudit = new OrderAudit();
        
        orderAudit=  orderAuditFacade.getLastOrderAudit(flow_no);
        
        return orderAudit;
    }

 
}
