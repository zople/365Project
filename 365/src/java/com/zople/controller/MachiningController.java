/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller;

import com.zople.controller.util.JsfUtil;
import com.zople.dao.MachiningFacade;
import com.zople.domain.Machining;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *@描   述:   加工管理
 *@ author:   yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Named("machiningController")
@SessionScoped
public class MachiningController implements Serializable {
    
    private Machining current;
    private int selectedItemIndex;
    
    
    @EJB
    private MachiningFacade facade;
   
    List<Machining> dataList; 

    public MachiningController() {
    }

    /***
     * 获取实体列表
     * @return  返回列表
     */ 
     public  List<Machining> getInfoList(){
         dataList=facade.findAll();
          return dataList;
        }
     
     /***
      * 返回前台展示记录
      * 
      */
      public  List<Machining> getInfoListBySql(){
          String sql="select o from Machining o  order by o.id ";
         dataList=facade.findAllBysql(sql,0,2);
          return dataList;
        }
     
           /***
       * 根据Id查询
       * @return  实体对象
       */ 
      public String findById() {
         String tempID=JsfUtil.getRequestParameter("id");
         Long tid=Long.parseLong(tempID);
        current =facade.find(tid);
        return "machiningView";
    }
    
      
      
        public Machining getSelected() {
        if (current == null) {
            current = new Machining();
            selectedItemIndex = -1;
        }
        return current;
    }
     
    
  
}
