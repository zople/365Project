/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zople.controller;

import com.zople.controller.util.JsfUtil;
import com.zople.controller.util.PaginationHelper;
import com.zople.dao.AdminIndustryNewsFacade;
import com.zople.domain.AdminIndustryNews;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *@描   述:  行业资讯
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Named(value = "industryNewsController")
@RequestScoped
public class IndustryNewsController {
     
  private AdminIndustryNews current;  
  private Long Id;
  private DataModel items = null;
  @EJB
  AdminIndustryNewsFacade ejbFacade;
  private PaginationHelper pagination;
  List<AdminIndustryNews> dataList;
  private int selectedItemIndex;
  
  
  private SelectItem[] pIdList;//存放父级的列表
  
  
    /***
       * 根据Id查询
       * @return  实体对象
       */ 
      public String findById() {
         String tempID=JsfUtil.getRequestParameter("id");
         Long tid=Long.parseLong(tempID);
        current =  ejbFacade.find(tid);
        return "industryNewsView";
    }
    
  
  
  
  	/**
	 * 将产品类型存放到下拉集合的get方法
	 * @return  
	 * @throws Exception
	 */
	public SelectItem[] getPIdListList() throws Exception{
               dataList=ejbFacade.findAll();
		pIdList = new SelectItem[dataList.size()];
		for (int i = 0; i < dataList.size(); i++) {
			AdminIndustryNews category = (AdminIndustryNews)dataList.get(i);
			pIdList[i] = new SelectItem(category.getId(),category.getClassTitle());
		}
		return pIdList;
	}
  
  
  
  
  
  public List<AdminIndustryNews> getDataList(){
      
      dataList=ejbFacade.findAll();
      
      return dataList;
      
  }
  
  
  
    
    /**显示页面**/
  public String prepareView() {
        current = (AdminIndustryNews)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "industryNewsView";
    }
    
      public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }
      
      
       public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
                }
            };
        }
        return pagination;
    }
       
       
    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }
    
     public String next() {
        getPagination().nextPage();
        recreateModel();
        return "industryNews";
    }
       
      public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "industryNews";
    }
       
 
        
      public AdminIndustryNews getSelected() {
        if (current == null) {
            current = new AdminIndustryNews();
            selectedItemIndex = -1;
        }
        return current;
    }
        
    private AdminIndustryNewsFacade getFacade() {
        return ejbFacade;
    }
    
    
       public String prepareCreate() {
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
       // fatherId = request.getParameter("fatherId");
        current = new AdminIndustryNews();
        selectedItemIndex = -1;
        return "industryNewsCreate";
    }
        
      
      public String create() {
        try {
            this.getFacade().create(current);
            return "industryNews";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
            
        }
    }
      
      
      
         /**编辑页面**/
        public String prepareEdit() {
//        current = (Category)getItems().getRowData();
//        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
            
         String tempID=JsfUtil.getRequestParameter("id");
         Long tid=Long.parseLong(tempID);
        current =  ejbFacade.find(tid);
             
        return "industryNewsEdit";
    }
        
        
        /**删除信息***/
        public String destroy() {
        current = (AdminIndustryNews)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "industryNews";
    }
        
        
        
        /***执行删除方法论****/
      private void performDestroy() {
        try {
            getFacade().remove(current);
        } catch (Exception e) {
        }
    }
        
      
      /**更新数据**/
    public String update() {
        try {
            getFacade().edit(current);
            return "industryNews";
        } catch (Exception e) {
            return null;
        }
    }
    
    /**返回列表**/
      public String prepareList() {
        recreateModel();
        return "industryNews";
    }

         public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "industryNewsView";
        } else {
            recreateModel();
            return "industryNews";
        }
    }
      
         
     private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            selectedItemIndex = count-1;
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex+1}).get(0);
        }
    }

}
