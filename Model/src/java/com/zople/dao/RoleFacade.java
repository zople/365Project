/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.Role;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 王文彦
 */
@Stateless
public class RoleFacade extends AbstractFacade<Role> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RoleFacade() {
        super(Role.class);
    }
    
    public Role findByName(String name){
        if(name==null){
            return null;
        }
        String sql="select t from Role t where t.name='"+name+"'";
        List<Role> roles=em.createQuery(sql).getResultList();
        if(roles.isEmpty()){
            return null;
        }
        return roles.get(0);
    }
     
}
