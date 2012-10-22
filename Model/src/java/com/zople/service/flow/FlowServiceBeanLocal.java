/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service.flow;

import com.zople.domain.OrderOrderinfo;
import javax.ejb.Local;

/**
 *@描   述:  流程管理实现接口
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Local
public interface FlowServiceBeanLocal {
    
    
    /**
     * 初始化流程
     * 
     */
    public void initlFlow(int flow_no,OrderOrderinfo entity);
    
     /*
     * 返回当前流程的下一个节点位置
     * flow_no 当前流程名称
     * node_no 当前流程序号
     */
    public String selectNextNode(int flow_no,int node_no);
    
    /**
     * 返回页面
     * @param node_code
     * @return 
     */
    public String returnUrl(String node_code);
    
    /**
     * 修改订单状态
     * @param order_id
     * @return 
     */
    public String updateOrderState(int order_id,String order_state);
    
    
    
    
}
