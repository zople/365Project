/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao.product;

import com.zople.dao.utils.CollectionUtil;
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
        StringBuffer sb=new StringBuffer();
        sb.append("SELECT id, category_id_path, category_name_path, create_time, creator, ");
        sb.append(" description, description_segmentation, enterprise_id, information_valid_date, ");
        sb.append(" inventory_amount, min_order_amount, passed, pcp_services, pricing_type, ");
        sb.append(" product_id, product_name, product_name_segmentation, sorts, status,");
        sb.append(" update_time, update_user");
        sb.append(" FROM sad_supply_product");
        sb.append(" where to_tsvector('simple',product_name_segmentation || ' ' || description_segmentation) @@ to_tsquery('"+keyWords+"')");
        String sql=sb.toString();
        System.out.println(sql);
        Query query =em.createNativeQuery(sql);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public int searchCount(String keyWords, int start, int limit) {
        StringBuffer sb=new StringBuffer();
        sb.append("SELECT count(id)");
        sb.append(" FROM sad_supply_product");
        sb.append(" where to_tsvector('simple',product_name_segmentation || ' ' || description_segmentation) @@ to_tsquery('"+keyWords+"')");
        String sql=sb.toString();
        Query query =em.createNativeQuery(sql);   
        return Integer.valueOf(query.getSingleResult().toString());
    }

    public SupplyProduct sel(String id) {
        Query query = em.createQuery("select s from SupplyProduct s where s.productId=" + id);
        return CollectionUtil.getFirstElement((List<SupplyProduct>)query.getResultList());
    }
}
