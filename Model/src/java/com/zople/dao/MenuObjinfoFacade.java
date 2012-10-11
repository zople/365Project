/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.MenuObjinfo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author wangxiu
 * 菜单对应的权限对象信息
 */
@Stateless
public class MenuObjinfoFacade extends AbstractFacade<MenuObjinfo> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuObjinfoFacade() {
        super(MenuObjinfo.class);
    }
    
}
