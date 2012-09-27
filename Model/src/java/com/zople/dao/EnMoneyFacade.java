/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.EnMoney;
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
public class EnMoneyFacade extends AbstractFacade<EnMoney> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;
    private Query queryquery;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnMoneyFacade() {
        super(EnMoney.class);
    }
    public List<EnMoney> getMoneyList(int start,int size){
        queryquery = em.createQuery("select t from EnMoney t");
        queryquery.setFirstResult(start);
        queryquery.setMaxResults(size);
        return queryquery.getResultList();
    }
}
