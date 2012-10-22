/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.basic.IndustryNews;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author yuliyao
 */
@Stateless
public class IndustryNewsFacade extends AbstractFacade<IndustryNews>{
    
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;
    private Query queryquery;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
     public IndustryNewsFacade() {
        super(IndustryNews.class);
    }
    public List<IndustryNews> findAllBysql(String sql, int startNum, int limitNum) {
        queryquery = em.createQuery(sql);
        queryquery.setFirstResult(startNum);
        queryquery.setMaxResults(limitNum);
        return queryquery.getResultList();
    }

    public List<IndustryNews> findAllBysql(String sql) {
        queryquery = em.createQuery(sql);
        return queryquery.getResultList();
    }
}
