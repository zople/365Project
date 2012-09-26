/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller;

import com.zople.dao.BuyFacade;
import com.zople.dao.ContactFacade;
import com.zople.dao.SupplyFacade;
import com.zople.domain.Buy;
import com.zople.domain.Contact;
import com.zople.domain.Supply;
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
   
}
