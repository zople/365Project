/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.EnEnterprise;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @描   述: 联系我们   
 * @author yuzhijian
 */
@Stateless
public class EnEnterpriseFacade extends AbstractFacade<EnEnterprise> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnEnterpriseFacade() {
        super(EnEnterprise.class);
    }
    
}
