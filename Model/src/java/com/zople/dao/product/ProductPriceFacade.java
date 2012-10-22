/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao.product;

import com.zople.dao.utils.CollectionUtil;
import com.zople.domain.product.AbstractFacade;
import com.zople.domain.product.SadSupplyProduct;
import com.zople.domain.product.SadSupplyProductprice;
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
public class ProductPriceFacade extends AbstractFacade<SadSupplyProduct> {

    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductPriceFacade() {
        super(SadSupplyProduct.class);
    }

    public SadSupplyProductprice sel(String id) {
        Query query = em.createQuery("select s from SadSupplyProductprice s where s.supplyProductId=" + id);
        return CollectionUtil.getFirstElement((List<SadSupplyProductprice>)query.getResultList());
    }
}
