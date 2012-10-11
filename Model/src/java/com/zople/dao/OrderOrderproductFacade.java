/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.OrderOrderproduct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author wangxiu
 * 订单商品表供应
 */
@Stateless
public class OrderOrderproductFacade extends AbstractFacade<OrderOrderproduct> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderOrderproductFacade() {
        super(OrderOrderproduct.class);
    }
    
}
