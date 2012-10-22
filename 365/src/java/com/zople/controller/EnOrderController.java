package com.zople.controller;

import com.zople.controller.util.JsfUtil;
import com.zople.controller.util.PaginationHelper;
import com.zople.dao.EnOrderFacade;
import com.zople.domain.EnOrder;
import com.zople.service.order.OrderServiceBeanLocal;
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
 *@描   述:  订单管理
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Named("enOrderController")
@SessionScoped
public class EnOrderController implements Serializable {

    private EnOrder current;
    private DataModel items = null;
    @EJB
    private EnOrderFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    //ycj
    private List<EnOrder> enOrders;
    
    //加载订单管理Server
    @EJB
    OrderServiceBeanLocal orderServiceBeanLocal;

    public OrderServiceBeanLocal getOrderServiceBeanLocal() {
        return orderServiceBeanLocal;
    }

    public void setOrderServiceBeanLocal(OrderServiceBeanLocal orderServiceBeanLocal) {
        this.orderServiceBeanLocal = orderServiceBeanLocal;
    }
    
    
   
    
    /**
     * 提交订单
     */
    public String SubmitOrder(){
        
    // orderServiceBeanLocal.SubmitOrder(null);
      
        return "";
    }
    
    
    
    

    public List<EnOrder> getEnOrders() {
        int num= ejbFacade.findAll().size()<10?ejbFacade.findAll().size():10;
        return enOrders = ejbFacade.findAll().subList(0,num);
    }
    public List<EnOrder> getTopEnOrders(){
        String sql = "select o from EnOrder o";
        enOrders = ejbFacade.findAllBysql(sql, 0, 5);
        return enOrders;
    }

    public void setEnOrders(List<EnOrder> enOrders) {
        this.enOrders = enOrders;
    }

    public String path(String s) {
        String path = "";
        if ("立即订购".equals(s)) {
            path = "order1";
        } else if ("去结算".equals(s)) {
            path = "order2";
            System.out.println(path);
        }
        return path;
    }
    //ycj

    public EnOrderController() {
    }

    public EnOrder getSelected() {
        if (current == null) {
            current = new EnOrder();
            selectedItemIndex = -1;
        }
        return current;
    }

    private EnOrderFacade getFacade() {
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
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
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
        current = (EnOrder) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new EnOrder();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("EnOrderCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (EnOrder) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("EnOrderUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (EnOrder) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("EnOrderDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
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

    @FacesConverter(forClass = EnOrder.class)
    public static class EnOrderControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EnOrderController controller = (EnOrderController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "enOrderController");
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
            if (object instanceof EnOrder) {
                EnOrder o = (EnOrder) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + EnOrder.class.getName());
            }
        }
    }
}
