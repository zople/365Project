/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zople.dao;

import com.zople.domain.OrderAudit;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *@描   述:   订单审核流程记录
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Stateless
public class OrderAuditFacade extends AbstractFacade<OrderAudit> {
    
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;
    private Query queryquery;

    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderAuditFacade() {
        super(OrderAudit.class);
    }
    
    public List<OrderAudit> getOrderAuditList(String sql){
       queryquery = em.createQuery(sql);
        return queryquery.getResultList();
    }
    
    
    
    
    

}
