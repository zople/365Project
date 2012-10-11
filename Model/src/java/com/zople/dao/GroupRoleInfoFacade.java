/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.GroupRoleInfo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author wangxiu
 * 组角色
 */
@Stateless
public class GroupRoleInfoFacade extends AbstractFacade<GroupRoleInfo> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupRoleInfoFacade() {
        super(GroupRoleInfo.class);
    }
    
}
