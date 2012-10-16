/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao.order;

import com.zople.dao.*;
import com.zople.domain.OrderOrderproduct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *@描   述:  订单管理--订单产品管理
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Stateless
public class OrderproductFacade extends AbstractFacade<OrderOrderproduct> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderproductFacade() {
        super(OrderOrderproduct.class);
    }
    
}
