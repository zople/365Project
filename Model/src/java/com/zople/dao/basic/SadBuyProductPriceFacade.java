/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao.basic;

import com.zople.domain.basic.SadBuyProductPrice;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author wangxiu
 */
@Stateless
public class SadBuyProductPriceFacade extends AbstractFacade<SadBuyProductPrice> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SadBuyProductPriceFacade() {
        super(SadBuyProductPrice.class);
    }
    
}
