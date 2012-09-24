/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.Persion;
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
public class PersionFacade extends AbstractFacade<Persion> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersionFacade() {
        super(Persion.class);
    }
    
    public List<Persion> getPersionDataMaxSize(int start,int size){
        Query query = em.createQuery("select p from Persion p");
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.getResultList();
    }
    
    
}
