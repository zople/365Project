/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zople.controller.flow;

import com.zople.controller.util.JsfUtil;
import com.zople.domain.OrderOrderinfo;
import com.zople.service.flow.FlowServiceBeanLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *@描   述:  流程管理
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Named("flowController")
@SessionScoped
public class FlowController implements Serializable {
    
     //加载订单管理Server
    @EJB
    FlowServiceBeanLocal flowServiceBeanLocal;
    
    //流程序号
    private int  flowno;
    
    private String order_state;
    
    private int order_id;
     
    /***
     * 提交订单初始化流程
     */
    public String submitOrder(){
        
      //订单信息表  
      OrderOrderinfo entity = new OrderOrderinfo();  
      
        
       flowServiceBeanLocal.initlFlow(flowno,entity);
        
        return "orderList";
    }
    
    /**
     * 订单节点流转
     * @return 
     */
    public String flowJump(){
        
     String node_code=JsfUtil.getRequestParameter("node_code");
     
       //查询相关订单的显示信息
     
        //返回要跳转的页面
     return flowServiceBeanLocal.returnUrl(node_code);
    }
    
    
    
    
    /***
     * 进入付款页面
     */
    public String payment(){
        
      
        
        return "orderPayment";
    }
    
    
    /***
     * 进入发货页面
     */
    public String shipments(){
        
      
        
        return "orderShipments";
    }
    
    
    /***
     * 进入确认收货页面
     * 确认付款
     */
    public String confirm(){
        
      
        
        return "orderConfirm";
    }
    
    
      /***
     * 退款管理
     * 确认付款
     */
    public String refund(){
        
      
        
        return "orderrefund";
    }
    
    /**
     * 
     * @return 
     */
       public String nextState(String state){
          
           
           order_id=8;
        flowServiceBeanLocal.updateOrderState(order_id, state);
        return "orderList";
    }
    
    
    
    
      /*
     * 返回当前流程的下一个节点位置
     * flow_code 当前流程名称
     * node_no 当前流程序号
     */
    public String selectNextNode(String flow_code,int node_no){
        
        
       
        return "";
    }
     
 

    public int getFlowno() {
        return flowno;
    }

    public void setFlowno(int flowno) {
        this.flowno = flowno;
    }

    public String getOrder_state() {
        return order_state;
    }

    public void setOrder_state(String order_state) {
        this.order_state = order_state;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    
    
    
    

}
