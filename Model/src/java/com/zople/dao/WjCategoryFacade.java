/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.WjCategory;
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
public class WjCategoryFacade extends AbstractFacade<WjCategory> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WjCategoryFacade() {
        super(WjCategory.class);
    }
    
    public List<WjCategory> findByFatherId(String id){
      Query query=em.createQuery("SELECT w FROM WjCategory w WHERE w.fatherId ="+id);
         return  query.getResultList();
}
}