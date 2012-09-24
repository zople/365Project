/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.EnRecruitment;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *@描   述:   人才招聘
 *@ author:   yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Stateless
public class EnRecruitmentFacade extends AbstractFacade<EnRecruitment> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;
    private Query queryquery;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnRecruitmentFacade() {
        super(EnRecruitment.class);
    }
    
    
    public List<EnRecruitment> findAllBysql(String sql) {
        System.out.println(sql);
         queryquery = em.createQuery(sql); 
         queryquery.setFirstResult(0);
         queryquery.setMaxResults(2);
           
        return queryquery.getResultList();
    }
    
    
    
    
    
}
