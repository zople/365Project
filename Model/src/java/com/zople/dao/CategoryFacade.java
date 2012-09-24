/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.Category;
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
public class CategoryFacade extends AbstractFacade<Category>{
    
    public CategoryFacade(){
        super(Category.class);
    }
    
    @PersistenceContext(unitName="365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }
    
    public List<Category> findByParentId(Long id,int start,int maxResults){
        String sql="select c from Category c where c.pid="+id;
        Query query=em.createQuery(sql);
        query.setMaxResults(maxResults);
        query.setFirstResult(start);
        return em.createQuery(sql).getResultList();
    }
    
}
