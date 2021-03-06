/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller;

import com.zople.controller.util.JsfUtil;
import com.zople.dao.AdminCanvassTraderFacade;
import com.zople.dao.BuyFacade;
import com.zople.dao.ContactFacade;
import com.zople.dao.EnMoneyFacade;
import com.zople.dao.EnNewsFacade;
import com.zople.dao.MachiningFacade;
import com.zople.dao.SupplyFacade;
import com.zople.dao.TblUserFacade;
import com.zople.dao.order.OrderinfoFacade;
import com.zople.domain.AdminCanvassTrader;
import com.zople.domain.Buy;
import com.zople.domain.Contact;
import com.zople.domain.EnEnterprise;
import com.zople.domain.EnMoney;
import com.zople.domain.EnNews;
import com.zople.domain.Machining;
import com.zople.domain.OrderOrderinfo;
import com.zople.domain.Supply;
import com.zople.domain.TblUser;
import com.zople.service.EnEnterpriseService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;

import javax.inject.Named;

/**
 *
 * @author wangxiu
 */
@Named(value = "getDateManagedBean")
@SessionScoped
public class GetDateManagedBean implements Serializable {
    /**
     * Creates a new instance of GetDateManagedBean
     */
    public GetDateManagedBean() {
    }
    
    @EJB
    SupplyFacade supplyFacade;
    private List items = null;
    private EnEnterprise data;
    //供应信息
    public List<Supply>  getSupplyDate(){
        items= supplyFacade.GetSupplyDataByMaxSize(1, 30);
        return items;
    }
    public List<Supply> getSupplyDataMax(){
        return  supplyFacade.GetSupplyDataByMaxSize(0, 10);
    }
    //求购信息
    @EJB
    BuyFacade buyFacade;
    public List<Buy> getBuyDataMax(){
        return buyFacade.getBuyDataMaxSize(0, 10);
    }
   //联系人信息
    @EJB
    ContactFacade contactFacade;
    public Contact getContactById(){
        return contactFacade.find(1l);
    }
   //金融动态
   @EJB
   EnMoneyFacade moneyFacade;;
   public List<EnMoney>  getMoneyDataMax(){
        return moneyFacade.getMoneyList(1, 10);
   }
 
   //最新企业登录名
   @EJB
   TblUserFacade userFacade;
   public List<TblUser> getUserList(){
        return userFacade.getUserList(1, 10);
   }
   public List<TblUser> getUserListMore(){
        return userFacade.getUserList(11, 10);
   }
    public List<TblUser> getUserListMoreLong(){
        return userFacade.getUserList(22, 10);
   }
    //企业信息
    @EJB
    EnEnterpriseService companyService;
    public List<EnEnterprise> getEnterpriseMore(){
        return companyService.getEnterprise(1, 10);
    }
    public List<EnEnterprise> getEnterpriseMoreLong(){
        return companyService.getEnterprise(11, 10);
    }
    public String getEnterpriseById(){
        data = companyService.findById(Long.valueOf(JsfUtil.getRequestParameter("id")));
        return "/pages/userManage/enterprise/front/companyInfo.xhtml";
    }
   public List<EnEnterprise> getEnterpriseLong(){
       return companyService.getEnterprise(31, 10);
   }
    
    
    public EnEnterprise getData() {
         data = companyService.findById(Long.valueOf(JsfUtil.getRequestParameter("id")));
         return data;
    }

    public void setData(EnEnterprise data) {
        this.data = data;
    }
 
   
   //新闻动太
    @EJB
    EnNewsFacade eFacade;;
   public List<EnNews> getEnNewsDataMax(){
        return eFacade.getMoneyList(1, 3);
   }
   
   //招商
   @EJB
    AdminCanvassTraderFacade canvasFacade;;
   public List<AdminCanvassTrader> getCanvasFacadeDataMax(){
        return canvasFacade.getMoneyList(0, 8);
   }

   //加工
   @EJB
   MachiningFacade mFacade;;
   public List<Machining> getMachiningDataMax(){
        return mFacade.getMoneyList(0, 8);
   }
   
   
   //订单信息
    @EJB
    OrderinfoFacade orderinfoFacade;
    public List<OrderOrderinfo> getOrderDataMax(){
        return orderinfoFacade.getOrderDataMaxSize(0, 10);
    }
   
}
