/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service;

import com.zople.dao.SupplyFacade;
import com.zople.domain.Supply;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Administrator
 */
@Stateless
public class SupplyService {
    @EJB
    SupplyFacade facade;
    
    public List<Supply> findAll(){
        return facade.findAll();
    }
    
    public void save(Supply category){
        facade.edit(category);
    }
    
    public Supply findById(Long id){
        return facade.find(id);
    }
    
}
