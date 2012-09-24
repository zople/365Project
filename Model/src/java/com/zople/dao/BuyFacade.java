/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.Buy;
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
public class BuyFacade extends AbstractFacade<Buy> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;
    private Query queryquery;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BuyFacade() {
        super(Buy.class);
    }
    
    public List<Buy> getBuyDataMaxSize(int start,int size){
       queryquery = em.createQuery("select t from Buy t");
        queryquery.setFirstResult(start);
        queryquery.setMaxResults(size);
        return queryquery.getResultList();
    }
    
    
       public List<Buy> findAllBysql(String sql,int startNum,int limitNum) {
         queryquery = em.createQuery(sql); 
         queryquery.setFirstResult(startNum);
         queryquery.setMaxResults(limitNum);
        return queryquery.getResultList();
    }
    
    
}
