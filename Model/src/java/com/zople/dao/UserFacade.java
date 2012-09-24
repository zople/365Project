/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.dao.utils.CollectionUtil;
import com.zople.domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author think
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    public User findByLoginName(String loginName){
        TypedQuery query=em.createNamedQuery("User.findLoginName", User.class);
        query.setParameter("loginName", loginName);
        query.getResultList();
        return (User)CollectionUtil.getFirstElement(query.getResultList());
    }
    public User findUserByEmail(String email){
       TypedQuery query=em.createNamedQuery("User.findEmail", User.class);
        query.setParameter("email", email);
        query.getResultList();
        return (User)CollectionUtil.getFirstElement(query.getResultList());
    }
    
}
