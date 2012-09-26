/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller;

import com.zople.service.BuyServer;
import com.zople.controller.util.JsfUtil;
import com.zople.controller.util.PaginationHelper;
import com.zople.dao.BuyFacade;
import com.zople.domain.Buy;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named(value = "adminBuyController")
@RequestScoped
public class AdminBuyController {
     
  private Buy current;  
  private Long id;
  private DataModel items = null;
  @EJB
  BuyFacade facade;
  private PaginationHelper pagination;
   @EJB
  private BuyServer buyServer;
  List<Buy> dataList;  //返回列表数据
  private int selectedItemIndex;
  
  
  /**根据Id获取数据**/
  public Buy getBugInfo(){
      String did="1";
     id= Long.parseLong(did);
      current=buyServer.findById(id);
      
      if(current!=null){
           return current;
      }
     return null;
  }
  
  
    /***
      * 返回前台展示记录
      * 
      */
      public  List<Buy> getInfoListBySql(){
          String sql="select o from Buy o ";
         dataList=facade.findAllBysql(sql,0,12);
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
        return "buyView";
    }
      
      
          public String link() {
        return "buy";
    }
      
      
        public String fontById() {
         String tempID=JsfUtil.getRequestParameter("id");
         Long tid=Long.parseLong(tempID);
        current =facade.find(tid);  
        return "/pages/getData/buyView.xhtml";
    }
      
      
        public Buy getSelected() {
        if (current == null) {
            current = new Buy();
            selectedItemIndex = -1;
        }
        return current;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

