/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao.order;

import com.zople.dao.AbstractFacade;
import com.zople.domain.OrderOrderinfo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @描 述: 订单管理实现类
 * @ author: yuzhijian_yuxia2217@163.com
 * @version: 1.0
 */
@Stateless
public class OrderinfoFacade extends AbstractFacade<OrderOrderinfo> {

    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderinfoFacade() {
        super(OrderOrderinfo.class);
    }
}
