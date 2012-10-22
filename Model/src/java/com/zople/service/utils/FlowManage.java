/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zople.service.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *@描   述: 流程定义
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
public class FlowManage {
     
    
    /***
     * 流程一
     */ 
    public static Map getFlowMap1(){
        Map  map = new HashMap();
        map.put(1,"FLOW_MXDAN");//买家下单
        map.put(2,"FLOW_MXPAY");//买家付款
        map.put(3,"FLOW_MXFAHOU");//卖家发货
        map.put(4,"FLOW_MSUREPAY");//买家确认付款
        map.put(5,"FLOW_PJIA");//评价
        return map;
   }
    
     /***
     * 流程 二
     */ 
    public static Map getFlowMap2(){
        Map  map = new HashMap();
        map.put(1,"FLOW_MXDAN");//买家下单
        map.put(2,"FLOW_MXPAY");//买家付款
        map.put(3,"FLOW_MXFAHOU");//卖家发货
        map.put(4,"FLOW_MSUREPAY");//买家确认付款
        map.put(5,"FLOW_PJIA");//评价
        return map;
   }

}
