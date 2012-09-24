/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.Position;
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
public class PositionFacade extends AbstractFacade<Position> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PositionFacade() {
        super(Position.class);
    }
    
    public List<Position> getPositionDataMaxSize(int start,int size){
        Query query = em.createQuery("select t from Position p");
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.getResultList();
    }
    
    
}
