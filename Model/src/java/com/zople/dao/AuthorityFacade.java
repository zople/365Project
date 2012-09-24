/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.Authority;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 王文彦
 */
@Stateless
public class AuthorityFacade extends AbstractFacade<Authority> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuthorityFacade() {
        super(Authority.class);
    }
    
    public Authority findByName(String name){
        if(name==null){
            return null;
        }
     List<Authority> authorities=em.createQuery("select t from Authority t where t.name = '"+name+"'").getResultList();
     if(authorities.isEmpty()){
         return null;
     }
     return authorities.get(0);
    }
    
}
