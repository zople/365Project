/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zople.dao;

import com.zople.domain.Spec;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *@描   述:   规格管理
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Stateless
public class SpecFacade extends AbstractFacade<Spec> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SpecFacade() {
        super(Spec.class);
    }

}
