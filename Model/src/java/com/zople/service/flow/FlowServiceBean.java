/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service.flow;

import com.zople.domain.OrderOrderinfo;
import com.zople.service.order.OrderServiceBeanLocal;
import com.zople.service.utils.FlowManage;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *@描   述:  流程管理实现类
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Stateless
public class FlowServiceBean implements FlowServiceBeanLocal {
    
 
  
  @EJB
  OrderServiceBeanLocal orderServiceBeanLocal;//订单管理
    

    @Override
    public void initlFlow(int flow_no,OrderOrderinfo entity){
        
        Map flowMap=null;
        flow_no=1;
        //选择流程
        if(flow_no==1){
            //流程1
            flowMap =FlowManage.getFlowMap1();
            
        }else if(flow_no==2){
            //流程1
             flowMap =FlowManage.getFlowMap2();
        }else{
            
        }
         orderServiceBeanLocal.SubmitOrder(entity, flow_no);
         
    }

    @Override
    public String selectNextNode(int flow_no, int node_no) {
        String node_code="";
        Map flowMap=null;
         //选择流程
        if(flow_no==1){
            //流程1
            flowMap =FlowManage.getFlowMap1();
            
        }else if(flow_no==2){
            //流程1
             flowMap =FlowManage.getFlowMap2();
        }else{
            flowMap=null;
        }
        node_no+=1;
        //输出流程
        node_code= (String)flowMap.get(node_no);
        return node_code;
         
    }

    @Override
    public String returnUrl(String node_code) {
         
        if("ORDER_PAYMENT".equals(node_code)){
             return "orderPayment"; //立付款页面
        }else if("ORDER_SHIPMENTS".equals(node_code)){
             return "orderShipments"; //发货页面
        }else if("ORDER_CONFIRM".equals(node_code)){
             return "orderConfirm"; //确认收货
        }else if("ORDER_REFUND".equals(node_code)){
             return "orderrefund"; //退款
        }else{
            return "orderList";  //跳到操作失败界面
        }
       
    }

    @Override
    public String updateOrderState(int order_id,String order_state) {
        
        
        orderServiceBeanLocal.updateOrderState(order_id, order_state);
        return null;
    }

 

}
