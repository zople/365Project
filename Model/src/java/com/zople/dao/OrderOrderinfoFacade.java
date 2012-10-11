/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.OrderOrderinfo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author wangxiu
 * 订单表
 */
@Stateless
public class OrderOrderinfoFacade extends AbstractFacade<OrderOrderinfo> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderOrderinfoFacade() {
        super(OrderOrderinfo.class);
    }
    
}
