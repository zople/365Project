/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller;

import com.zople.dao.BuyFacade;
import com.zople.dao.ContactFacade;
import com.zople.dao.EnMoneyFacade;
import com.zople.dao.SupplyFacade;
import com.zople.dao.TblUserFacade;
import com.zople.domain.Buy;
import com.zople.domain.Contact;
import com.zople.domain.EnMoney;
import com.zople.domain.Supply;
import com.zople.domain.TblUser;
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
   //最新企业
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
}
