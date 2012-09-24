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
 *  求购服务类
 * @author yuzhijian
 */
@Stateless
public class BuyServer {
    
    @EJB
    BuyFacade facade;
    
    public List<Buy> findAll(){
        return facade.findAll();
    }
    
    public void save(Buy buy){
        facade.edit(buy);
    }
    
    
    
    public Buy findById(Long id){
        return facade.find(id);
    }
     
    
}
