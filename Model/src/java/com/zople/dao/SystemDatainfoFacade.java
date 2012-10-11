/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.SystemDatainfo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author wangxiu
 * 系统数据字典
 */
@Stateless
public class SystemDatainfoFacade extends AbstractFacade<SystemDatainfo> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SystemDatainfoFacade() {
        super(SystemDatainfo.class);
    }
    
}
