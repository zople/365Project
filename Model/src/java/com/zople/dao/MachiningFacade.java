/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zople.dao;

import com.zople.domain.AdminCanvassTrader;
import com.zople.domain.Machining;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *@描   述:   加工管理
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Stateless
public class MachiningFacade extends AbstractFacade<Machining> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;
    private Query queryquery;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    
    public List<Machining> findAllBysql(String sql,int startNum,int limitNum) {
         queryquery = em.createQuery(sql); 
         queryquery.setFirstResult(startNum);
         queryquery.setMaxResults(limitNum);
        return queryquery.getResultList();
    }
    
    
    public MachiningFacade() {
        super(Machining.class);
    }

    
        public List<Machining> getMoneyList(int start,int size){
        queryquery = em.createQuery("select t from Machining t");
        queryquery.setFirstResult(start);
        queryquery.setMaxResults(size);
        return queryquery.getResultList();
        
    }
    
    
}
