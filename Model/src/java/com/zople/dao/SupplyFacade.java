/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.Buy;
import com.zople.domain.Supply;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author think
 */
@Stateless
public class SupplyFacade extends AbstractFacade<Supply> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;
    private Query queryquery;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SupplyFacade() {
        super(Supply.class);
    }
    public List<Supply> GetSupplyDataByMaxSize(int start,int limit){
        Query query=em.createQuery("select t from Supply t");
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }
    
    
       public List<Supply> findAllBysql(String sql,int startNum,int limitNum) {
         queryquery = em.createQuery(sql); 
         queryquery.setFirstResult(startNum);
         queryquery.setMaxResults(limitNum);
        return queryquery.getResultList();
    }
    
}
