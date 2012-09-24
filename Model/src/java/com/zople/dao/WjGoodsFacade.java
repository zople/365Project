/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.WjGoods;
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
public class WjGoodsFacade extends AbstractFacade<WjGoods> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WjGoodsFacade() {
        super(WjGoods.class);
    }
    public List<WjGoods> findBycategoryId(String id){
      Query query=em.createQuery("SELECT w FROM WjGoods w WHERE w.categoryId ="+id);
      return  query.getResultList();
    }
    
}
