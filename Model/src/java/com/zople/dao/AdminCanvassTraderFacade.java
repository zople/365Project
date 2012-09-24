/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.AdminCanvassTrader;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *   招商管理
 * @author Administrator
 */
@Stateless
public class AdminCanvassTraderFacade extends AbstractFacade<AdminCanvassTrader> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;
    private Query queryquery;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminCanvassTraderFacade() {
        super(AdminCanvassTrader.class);
    }
    
    
       public List<AdminCanvassTrader> findAllBysql(String sql,int startNum,int limitNum) {
         queryquery = em.createQuery(sql); 
         queryquery.setFirstResult(startNum);
         queryquery.setMaxResults(limitNum);
        return queryquery.getResultList();
    }
    
    
}
