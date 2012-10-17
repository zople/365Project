/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.product.ShippingCosts;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



/**
 *
 * @author XiaoYanZi
 */
public class ShippingCostsFacade extends AbstractFacade<ShippingCosts> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;
    private Query queryquery;
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShippingCostsFacade(Class<ShippingCosts> entityClass) {
        super(entityClass);
    }
    
}
