/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao.enterprise;

import com.zople.dao.basic.*;
import com.zople.dao.utils.CollectionUtil;
import com.zople.domain.TblEnterpriseContact;
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
public class EnterpriseContactFacade extends AbstractFacade<UserInfo> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnterpriseContactFacade() {
        super(UserInfo.class);
    }
    
    public TblEnterpriseContact findEnterpriseContact(String id){
        Query query=em.createQuery("select t from TblEnterpriseContact t where t.enterpriseId ="+id);
        return CollectionUtil.getFirstElement((List<TblEnterpriseContact>)query.getResultList());
    }
    
}
