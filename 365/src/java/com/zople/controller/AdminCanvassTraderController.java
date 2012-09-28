package com.zople.controller;

import com.zople.controller.util.JsfUtil;
import com.zople.controller.util.PaginationHelper;
import com.zople.dao.AdminCanvassTraderFacade;
import com.zople.domain.AdminCanvassTrader;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Named;

 
/**
 *@描   述:   招商管理
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Named("adminCanvassTraderController")
@SessionScoped
public class AdminCanvassTraderController implements Serializable {


    private AdminCanvassTrader current;
    private DataModel items = null;
    @EJB 
    private AdminCanvassTraderFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    
     List<AdminCanvassTrader> dataList;  //返回列表数据

    public AdminCanvassTraderController() {
    }

    
    
    /***
      * 返回前台展示记录
      * 
      */
      public  List<AdminCanvassTrader> getInfoListBySql(){
          String sql="select o from AdminCanvassTrader o ";
         dataList=ejbFacade.findAllBysql(sql,0,2);
          return dataList;
        }
     
           /***
       * 根据Id查询
       * @return  实体对象
       */ 
      public String findById() {
         String tempID=JsfUtil.getRequestParameter("id");
         Long tid=Long.parseLong(tempID);
        current =ejbFacade.find(tid);
        return "canvassTraderView";
    }
    
    
          public String findFontById() {
         String tempID=JsfUtil.getRequestParameter("id");
         Long tid=Long.parseLong(tempID);
        current =ejbFacade.find(tid);
        return "/pages/userManage/enterprise/front/canvassTraderView.xhtml";
    }
    
    
    
    public AdminCanvassTrader getSelected() {
        if (current == null) {
            current = new AdminCanvassTrader();
            selectedItemIndex = -1;
        }
        return current;
    }

    private AdminCanvassTraderFacade getFacade() {
        return ejbFacade;
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

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (AdminCanvassTrader)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new AdminCanvassTrader();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("AdminCanvassTraderCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (AdminCanvassTrader)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("AdminCanvassTraderUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (AdminCanvassTrader)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("AdminCanvassTraderDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count-1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex+1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
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
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    @FacesConverter(forClass=AdminCanvassTrader.class)
    public static class AdminCanvassTraderControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AdminCanvassTraderController controller = (AdminCanvassTraderController)facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "adminCanvassTraderController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof AdminCanvassTrader) {
                AdminCanvassTrader o = (AdminCanvassTrader) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: "+AdminCanvassTrader.class.getName());
            }
        }

    }

}
