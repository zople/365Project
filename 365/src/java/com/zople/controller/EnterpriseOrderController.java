package com.zople.controller;

import com.zople.controller.util.JsfUtil;
import com.zople.controller.util.PaginationHelper;
import com.zople.dao.OrderOrderinfoFacade;
import com.zople.domain.OrderOrderinfo;
import com.zople.domain.OrderOrderproduct;
import com.zople.domain.TblEnterprise;
import com.zople.dto.OrderDto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named("enterpriseOrderController")
@RequestScoped
public class EnterpriseOrderController implements Serializable {

    private String temp = "";
    String sql = "";
    private OrderOrderinfo orderOrderinfo;
    private TblEnterprise tblEnterprise;
    private List<OrderOrderinfo> orderOrderinfos;
    private DataModel items = null;
    @EJB
    private OrderOrderinfoFacade orderOrderinfoFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public List<OrderOrderinfo> getOrderOrderinfos() {
        if ("all".equals(temp)) {
            sql = "select o from OrderOrderinfo o order by o.id";
        } else if ("month".equals(temp)) {
            sql = "select o from OrderOrderinfo o order by o.id";
        } else if ("0".equals(temp)) {
            sql = "select o from OrderOrderinfo o where o.orderState='0'";
        } else if ("1".equals(temp)) {
            sql = "select o from OrderOrderinfo o where o.orderState='1'";
        } else if ("2".equals(temp)) {
            sql = "select o from OrderOrderinfo o where o.orderState='2'";
        } else if ("3".equals(temp)) {
            sql = "select o from OrderOrderinfo o where o.orderState='3'";
        } else if ("4".equals(temp)) {
            sql = "select o from OrderOrderinfo o where o.orderState='4'";
        } else if ("5".equals(temp)) {
            sql = "select o from OrderOrderinfo o where o.orderState='5'";
        } else {
            sql = "select o from OrderOrderinfo o order by o.id";
        }
        orderOrderinfos = orderOrderinfoFacade.findAllBysql(sql);
        return orderOrderinfos;
    }

    public void setOrderOrderinfos(List<OrderOrderinfo> orderOrderinfos) {
        this.orderOrderinfos = orderOrderinfos;
    }

    public List<OrderDto> disOrderDtos() {
        List<OrderDto> orderDtos = new ArrayList<OrderDto>();
        List<OrderOrderinfo> orderOrderinfos = getOrderOrderinfos();
        for (OrderOrderinfo orderOrderinfo : orderOrderinfos) {
            List<OrderOrderproduct> orderOrderproducts = (List<OrderOrderproduct>) orderOrderinfo.getOrderItemsList();
            for (int i = 0; i < orderOrderproducts.size(); i++) {
                OrderDto orderDto = new OrderDto();
                orderDto.setId(orderOrderproducts.get(i).getId());
                orderDto.setOrderNo(orderOrderinfo.getOrderNo());
                orderDto.setProductName(orderOrderproducts.get(i).getProductName());
                orderDto.setProductPrice(orderOrderproducts.get(i).getProductPrice());
                orderDto.setProductAccount(orderOrderproducts.get(i).getProductAccount());
                orderDto.setProductTotal(orderOrderproducts.get(i).getProductTotal());
                orderDto.setFinishTime(orderOrderinfo.getFinishTime());
                orderDto.setOrderState(orderOrderinfo.getOrderState());
                orderDtos.add(orderDto);
            }
        }
        return orderDtos;
    }

    public TblEnterprise getTblEnterprise() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        tblEnterprise = (TblEnterprise) session.getAttribute("sellEnterprise");
        return tblEnterprise;
    }

    public void setTblEnterprise(TblEnterprise tblEnterprise) {
        this.tblEnterprise = tblEnterprise;
    }

//    public void setOrderDtos(List<OrderDto> orderDtos) {
//        this.orderDtos = orderDtos;
//    }
    public String displayOrderOrderinfo(String s) {
        temp = s;
        return "sellOrder";
    }

    public int count() {
        return orderOrderinfoFacade.count();
    }

    //发货
    public String startGoods() {
        String id = JsfUtil.getRequestParameter("id");
        orderOrderinfoFacade.updateOrderState(id);
        return "sellOrder";
    }

//    public void findEnterprise() {
//        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//        tblEnterprise= (TblEnterprise) session.getAttribute("sellEnterprise");
//    }
    public EnterpriseOrderController() {
    }

    public OrderOrderinfo getSelected() {
        if (orderOrderinfo == null) {
            orderOrderinfo = new OrderOrderinfo();
            selectedItemIndex = -1;
        }
        return orderOrderinfo;
    }

    private OrderOrderinfoFacade getFacade() {
        return orderOrderinfoFacade;
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
        orderOrderinfo = (OrderOrderinfo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        orderOrderinfo = new OrderOrderinfo();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(orderOrderinfo);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("EnOrderCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        orderOrderinfo = (OrderOrderinfo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(orderOrderinfo);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("EnOrderUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        orderOrderinfo = (OrderOrderinfo) getItems().getRowData();
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
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(orderOrderinfo);
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
            orderOrderinfo = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
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
        return JsfUtil.getSelectItems(orderOrderinfoFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(orderOrderinfoFacade.findAll(), true);
    }
}
