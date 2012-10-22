/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zople.dao.order;

import com.zople.dao.AbstractFacade;
import com.zople.domain.OrderAudit;
import com.zople.domain.OrderOrderinfo;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *@描   述:  订单审核流程记录管理
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Stateless
public class OrderAuditFacade extends AbstractFacade<OrderAudit> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;
    private Query queryquery;
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderAuditFacade() {
        super(OrderAudit.class);
    }
    
    
    /**
     * 获取最后一条记录信息
     * @param flow_no
     * @return 
     */
    public OrderAudit getLastOrderAudit(String flow_no) {
        
        OrderAudit orderAudit  = new  OrderAudit();
        
        queryquery = em.createQuery("select t from OrderAudit t where t.orderno='"+flow_no+"' order by t.auditId desc");
        
          List result =queryquery.getResultList(); 
            if (result!=null){ 
            Iterator iterator = result.iterator(); 
            while( iterator .hasNext() ){ 
             orderAudit= (OrderAudit)iterator .next();
            }
         }
        
        return orderAudit;
    }

   

}
