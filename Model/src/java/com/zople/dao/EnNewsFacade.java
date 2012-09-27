/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.EnMoney;
import com.zople.domain.EnNews;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
public class EnNewsFacade extends AbstractFacade<EnNews> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;
    private Query queryquery;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnNewsFacade() {
        super(EnNews.class);
    }
    
     public List<EnNews> getMoneyList(int start,int size){
        queryquery = em.createQuery("select t from EnNews t");
        queryquery.setFirstResult(start);
        queryquery.setMaxResults(size);
        return queryquery.getResultList();
        
    }
    
    
}
