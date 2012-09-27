/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller;

import com.zople.controller.util.JsfUtil;
import com.zople.dao.BuyFacade;
import com.zople.dao.ContactFacade;
import com.zople.dao.EnMoneyFacade;
import com.zople.dao.EnNewsFacade;
import com.zople.dao.SupplyFacade;
import com.zople.dao.TblUserFacade;
import com.zople.domain.Buy;
import com.zople.domain.Contact;
import com.zople.domain.EnEnterprise;
import com.zople.domain.EnMoney;
import com.zople.domain.EnNews;
import com.zople.domain.Supply;
import com.zople.domain.TblUser;
import com.zople.domain.WjCategory;
import com.zople.service.EnEnterpriseService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

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
    private List<EnEnterprise> data;
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
//        data = companyService.findById(Long.valueOf(JsfUtil.getRequestParameter("id")));
        return "/pages/userManage/enterprise/commons/frontLeft";
    }

    public List<EnEnterprise> getData() {
        return data;
    }

    public void setData(List<EnEnterprise> data) {
        this.data = data;
    }
 
   
   //新闻动太
    @EJB
    EnNewsFacade eFacade;;
   public List<EnNews> getEnNewsDataMax(){
        return eFacade.getMoneyList(1, 3);
   }
   
}
