package com.zople.controller;

import com.zople.controller.util.JsfUtil;
import com.zople.dao.OrderOrderinfoFacade;
import com.zople.dao.order.OrderAuditFacade;
import com.zople.domain.OrderAudit;
import com.zople.domain.OrderOrderinfo;
import com.zople.domain.OrderOrderproduct;
import com.zople.domain.TblEnterprise;
import com.zople.dto.OrderDto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named("enterpriseOrderController")
@RequestScoped
public class EnterpriseOrderController implements Serializable {

    private String orderNo;
    private String temp = "";
    String sql = "";
    private TblEnterprise tblEnterprise;
    private List<OrderOrderinfo> orderOrderinfos;
    @EJB
    private OrderOrderinfoFacade orderOrderinfoFacade;
    @EJB
    OrderAuditFacade orderAuditFacade;

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

    //买家付款
    public String toBuy() {
        orderNo = JsfUtil.getRequestParameter("orderNo");
        return "/pages/userManage/enterprise/front/order3.xhtml";
    }
    //买家付款

    public String buy() {
        OrderAudit orderAudit = new OrderAudit();
        orderAudit.setAuditContent("已经付款");
        orderAudit.setAuditState(1);
        orderAudit.setOrderno(orderNo);
        orderAuditFacade.create(orderAudit);

        //orderAuditServer.createAudit(orderNo, 1, "已经付款");

        orderOrderinfoFacade.updateOrderState("1", orderNo);
        return "/pages/userManage/enterprise/back/enEnterprise/buyOrder.xhtml";
    }

    //买家取消订单
    public String toCancelOrder() {
        orderNo = JsfUtil.getRequestParameter("orderNo");
        return "cancelOrder";
    }
    //买家确认取消订单

    public String cancelOrder() {
        //orderAuditServer.createAudit(orderNo, 5, "取消订单");
        OrderAudit orderAudit = new OrderAudit();
        orderAudit.setAuditContent("取消订单");
        orderAudit.setAuditState(5);
        orderAudit.setOrderno(orderNo);
        orderAuditFacade.create(orderAudit);

        orderOrderinfoFacade.updateOrderState("5", orderNo);
        return "buyOrder";
    }

    //卖家发货
    public String startGoods() {
        orderNo = JsfUtil.getRequestParameter("orderNo");
        orderOrderinfoFacade.updateOrderState("2", orderNo);

        OrderAudit orderAudit = new OrderAudit();
        orderAudit.setAuditContent("已经发货");
        orderAudit.setAuditState(2);
        orderAudit.setOrderno(orderNo);
        orderAuditFacade.create(orderAudit);
        return "sellOrder";
    }

    //买家确认收货
    public String confirmGoods() {
        orderNo = JsfUtil.getRequestParameter("orderNo");
        orderOrderinfoFacade.updateOrderState("3", orderNo);

        OrderAudit orderAudit = new OrderAudit();
        orderAudit.setAuditContent("已经发货");
        orderAudit.setAuditState(3);
        orderAudit.setOrderno(orderNo);
        orderAuditFacade.create(orderAudit);
        return "sellOrder";
    }

    //评价
    public String toEvaluation() {
        orderNo = JsfUtil.getRequestParameter("orderNo");
        return "evaluate";
    }
    //评价

    public String evaluation() {
        OrderAudit orderAudit = new OrderAudit();
        orderAudit.setAuditContent("交易成功");
        orderAudit.setAuditState(4);
        orderAudit.setOrderno(orderNo);
        orderAuditFacade.create(orderAudit);

        orderOrderinfoFacade.updateOrderState("4", orderNo);
        return "/pages/userManage/enterprise/back/enEnterprise/buyOrder.xhtml";
    }

    public EnterpriseOrderController() {
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
