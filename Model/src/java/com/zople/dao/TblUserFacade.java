/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.TblUser;
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
public class TblUserFacade extends AbstractFacade<TblUser> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;
    private Query queryquery;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblUserFacade() {
        super(TblUser.class);
    }
    public List<TblUser> getUserList(int start ,int size){
          queryquery = em.createQuery("select t from TblUser t");
          queryquery.setFirstResult(start);
          queryquery.setMaxResults(size);
          return queryquery.getResultList();
    }
}
