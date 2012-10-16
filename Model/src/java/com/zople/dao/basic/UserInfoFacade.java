/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao.basic;

import com.zople.dao.utils.CollectionUtil;
import com.zople.domain.basic.UserInfo;
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
public class UserInfoFacade extends AbstractFacade<UserInfo> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserInfoFacade() {
        super(UserInfo.class);
    }
    
    public UserInfo findBuyName(String loginName){
        Query query=em.createQuery("select t from UserInfo t where t.loginName ='"+loginName+"'");
        return CollectionUtil.getFirstElement((List<UserInfo>)query.getResultList());
    }
    
}
