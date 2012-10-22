/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.OrderOrderinfo;
import com.zople.domain.OrderOrderproduct;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author wangxiu 订单表
 */
@Stateless
public class OrderOrderinfoFacade extends AbstractFacade<OrderOrderinfo> {

    @PersistenceContext(unitName = "365PU")
    private EntityManager em;
    private Query queryquery;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderOrderinfoFacade() {
        super(OrderOrderinfo.class);
    }

    public List<OrderOrderinfo> findAllBysql(String sql, int startNum, int limitNum) {
        queryquery = em.createQuery(sql);
        queryquery.setFirstResult(startNum);
        queryquery.setMaxResults(limitNum);
        return queryquery.getResultList();
    }

    public List<OrderOrderinfo> findAllBysql(String sql) {
        queryquery = em.createQuery(sql);
        return queryquery.getResultList();
    }
//    public OrderOrderinfo find(Long id){
//       OrderOrderinfo orderOrderinfo=em.find(OrderOrderinfo.class, id);
//       for(OrderOrderproduct o:orderOrderinfo.getOrderItemsList()){
//           o.getId();
//       }
//        return orderOrderinfo;
//    }

    public int updateOrderState(String state, String orderNo) {
        Query query = em.createQuery("update OrderOrderinfo o set o.orderState='" + state + "' where o.orderNo='"+orderNo+"'");
        return query.executeUpdate();
    }
}
