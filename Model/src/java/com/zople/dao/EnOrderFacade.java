/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.EnOrder;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 王文彦
 */
@Stateless
public class EnOrderFacade extends AbstractFacade<EnOrder> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;
    private Query queryquery;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnOrderFacade() {
        super(EnOrder.class);
    }
    
    
      public List<EnOrder> findAllBysql(String sql,int startNum,int limitNum) {
         queryquery = em.createQuery(sql); 
         queryquery.setFirstResult(startNum);
         queryquery.setMaxResults(limitNum);
        return queryquery.getResultList();
    }
}
