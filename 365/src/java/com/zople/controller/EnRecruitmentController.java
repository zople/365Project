package com.zople.controller;

import com.zople.controller.util.JsfUtil;
import com.zople.dao.EnRecruitmentFacade;
import com.zople.domain.EnRecruitment;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *@描   述:   人才招聘
 *@ author:   yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Named("enRecruitmentController")
@SessionScoped
public class EnRecruitmentController implements Serializable {

    private EnRecruitment current;
    private int selectedItemIndex;
    
    
    @EJB
    private EnRecruitmentFacade facade;
   
    List<EnRecruitment> dataList; 

    public EnRecruitmentController() {
    }

    /***
     * 获取实体列表
     * @return  返回列表
     */ 
     public  List<EnRecruitment> getInfoList(){
         dataList=facade.findAll();
          return dataList;
        }
     
     /***
      * 返回前台展示记录
      * 
      */
      public  List<EnRecruitment> getInfoListBySql(){
          String sql="select o from EnRecruitment o  order by o.id ";
         dataList=facade.findAllBysql(sql);
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
        return "recruitmentView";
    }
    
      
      
        public EnRecruitment getSelected() {
        if (current == null) {
            current = new EnRecruitment();
            selectedItemIndex = -1;
        }
        return current;
    }
     
   
}
