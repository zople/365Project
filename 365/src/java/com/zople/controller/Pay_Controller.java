/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller;

import com.zople.dao.OrderOrderinfoFacade;
import com.zople.dao.order.OrderAuditFacade;
import com.zople.domain.OrderAudit;
import com.zople.domain.OrderOrderinfo;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author WALLY
 */
@ManagedBean(name="Pay_Controller")
@SessionScoped
public class Pay_Controller implements Serializable{
     @EJB
    private OrderAuditFacade orderauditFacade;
     @EJB
    private OrderOrderinfoFacade orderinfotFacade;
    private OrderOrderinfo orderinfo = new OrderOrderinfo();
    OrderAudit orderaudit=new OrderAudit();
    private String password;

    public OrderOrderinfo getOrderinfo() {
        return orderinfo;
    }

    public void setOrderinfo(OrderOrderinfo orderinfo) {
        this.orderinfo = orderinfo;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Pay_Controller(){    
    }
    public void confirm(){
//         String tempID=JsfUtil.getRequestParameter("id");
//           Long tid=Long.parseLong(tempID);
             
            if("123".equals(password)){
            orderaudit.setAuditId(null);
            orderaudit.setOrderno("1d");
            orderaudit.setAuditState(0);
            orderaudit.setAuditContent("提交订单");
            orderaudit.setAuditTime(new Date());
            orderauditFacade.create(orderaudit); 
            
//             orderinfo.setOrderState("已经付款");
//              orderinfo.setPayState("已经付款");
//              orderinfotFacade.edit(orderinfo);
              
       }
    }
    
}
