/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.EnEnterprise;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @描 述: 联系我们
 * @author yuzhijian
 */
@Stateless
public class EnEnterpriseFacade extends AbstractFacade<EnEnterprise> {

    @PersistenceContext(unitName = "365PU")
    private EntityManager em;
    private Query queryquery;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnEnterpriseFacade() {
        super(EnEnterprise.class);
    }

    public List<EnEnterprise> findAllBysql(String sql, int startNum, int limitNum) {
        queryquery = em.createQuery(sql);
        queryquery.setFirstResult(startNum);
        queryquery.setMaxResults(limitNum);
        return queryquery.getResultList();
    }
}
