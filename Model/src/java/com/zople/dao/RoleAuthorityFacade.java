/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.RoleAuthority;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author wangxiu
 * 角色权限
 */
@Stateless
public class RoleAuthorityFacade extends AbstractFacade<RoleAuthority> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RoleAuthorityFacade() {
        super(RoleAuthority.class);
    }
    
}
