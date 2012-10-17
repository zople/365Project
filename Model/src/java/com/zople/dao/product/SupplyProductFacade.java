/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao.product;

import com.zople.domain.product.AbstractFacade;
import com.zople.domain.product.SupplyProduct;
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
public class SupplyProductFacade extends AbstractFacade<SupplyProduct> {

    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SupplyProductFacade() {
        super(SupplyProduct.class);
    }

    public List<SupplyProduct> search(String keyWords, int start, int limit) {
        Query query = em.createQuery("select s from SupplyProduct s where to_tsvector('simple', s.product_name_segmentation || ' ' ||s.description_segmentation) @@ to_tsquery('" + keyWords + "')");
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public int searchCount(String keyWords, int start, int limit) {
        Query query = em.createQuery("select count(s.id) from SupplyProduct s where to_tsvector('simple', s.product_name_segmentation || ' ' ||s.description_segmentation) @@ to_tsquery('" + keyWords + "')");
        return Integer.valueOf(query.getSingleResult().toString());
    }

    public SupplyProduct sel(String id) {
        Query query = em.createQuery("select s from SupplyProduct s where s.productId=" + id);
        return (SupplyProduct) query.getSingleResult();
    }
}
