/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.dao.utils.CollectionUtil;
import com.zople.domain.TblEnterprise;
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
public class TblEnterpriseFacade extends AbstractFacade<TblEnterprise> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblEnterpriseFacade() {
        super(TblEnterprise.class);
    }
    
    public TblEnterprise findByUserId(Long userId){
        Query query=em.createQuery("select u from TblEnterprise u where u.userId="+userId.toString());
        List<TblEnterprise> res=query.getResultList();
        return CollectionUtil.getFirstElement(res);
    }
    
}
