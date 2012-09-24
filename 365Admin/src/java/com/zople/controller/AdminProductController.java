/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zople.controller;

import com.zople.controller.util.JsfUtil;
import com.zople.controller.util.PaginationHelper;
import com.zople.dao.CategoryFacade;
import com.zople.dao.ProductFacade;
import com.zople.domain.Category;
import com.zople.domain.Product;
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
 *@描   述:   产品管理
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Named(value = "adminProductController")
@RequestScoped
public class AdminProductController {

  
  private Product current=new Product();  
  private Long Id;
  private DataModel items = null;
  @EJB
  ProductFacade ejbFacade;
  
  @EJB
  CategoryFacade categoryfacade;
  
  public AdminProductController(){
      current.setCategory(new Category());
  }
  
  
  private PaginationHelper pagination;
  List<Category> dataList;
  
  List<Product> productList;
  
  private int selectedItemIndex;
  
  
  private SelectItem[] pIdList;//关联
  
  
    /***
       * 根据Id查询
       * @return  实体对象
       */ 
      public String findById() {
         String tempID=JsfUtil.getRequestParameter("id");
         Long tid=Long.parseLong(tempID);
        current =  ejbFacade.find(tid);
        return "productView";
    }
    
  
  
  
  	/**
	 * 将产品类型存放到下拉集合的get方法
	 * @return  
	 * @throws Exception
	 */
	public SelectItem[] getPIdListList() throws Exception{
               dataList=categoryfacade.findAll();
		pIdList = new SelectItem[dataList.size()];
		for (int i = 0; i < dataList.size(); i++) {
			Category product = (Category)dataList.get(i);
			pIdList[i] = new SelectItem(product.getId(),product.getName());
		}
		return pIdList;
	}
  
  
  
  
  
  public List<Product> getDataList(){
      
      productList=ejbFacade.findAll();
      
      return productList;
      
  }
  
  
  
    
    /**显示页面**/
  public String prepareView() {
        current = (Product)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "productView";
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
        return "product";
    }
       
      public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "product";
    }
       
 
        
      public Product getSelected() {
        if (current == null) {
            current = new Product();
            selectedItemIndex = -1;
        }
        return current;
    }
        
    private ProductFacade getFacade() {
        return ejbFacade;
    }
    
    
       public String prepareCreate() {
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
       // fatherId = request.getParameter("fatherId");
        current = new Product();
        selectedItemIndex = -1;
        return "productCreate";
    }
        
      
      public String create() {
        try {
            this.getFacade().create(current);
            return "product";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
            
        }
    }
      
      
      
         /**编辑页面**/
        public String prepareEdit() {
//        current = (Product)getItems().getRowData();
//        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
            
         String tempID=JsfUtil.getRequestParameter("id");
         Long tid=Long.parseLong(tempID);
        current =  ejbFacade.find(tid);
             
        return "productEdit";
    }
        
        
        /**删除信息***/
        public String destroy() {
        current = (Product)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "product";
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
            return "product";
        } catch (Exception e) {
            return null;
        }
    }
    
    /**返回列表**/
      public String prepareList() {
        recreateModel();
        return "product";
    }

         public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "productView";
        } else {
            recreateModel();
            return "product";
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
     
     
       public Product getCurrent() {
        return current;
    }

    public void setCurrent(Product current) {
        this.current = current;
    }
    
    

}
   
    
    
    

 
