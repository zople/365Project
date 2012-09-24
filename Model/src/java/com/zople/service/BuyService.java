/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service;

import com.zople.dao.BuyFacade;
import com.zople.domain.Buy;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 王文彦
 */
@Stateless
public class BuyService {
    
    @EJB
    BuyFacade buyFacade;
    
    public void createUser(Buy buy){
        buyFacade.create(buy);
    }
        
     public List<Buy> findAll(){
        return buyFacade.findAll();
    }
}
