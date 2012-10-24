/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao.basic;

import com.zople.domain.basic.MachiningInfo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author wangxiu
 */
@Stateless
public class MachiningInfoFacade extends AbstractFacade<MachiningInfo> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MachiningInfoFacade() {
        super(MachiningInfo.class);
    }
     /**
     * 根据企业ID查该企业发布的全部加工信息
     */
    public List<MachiningInfo> findMachiningInfoByEnterpriseId(Long enterpriseId,int start,int limit){
     
        String sql="select c from MachiningInfo c where c.enterpriseId="+enterpriseId;
        Query query=em.createQuery(sql);        
        query.setMaxResults(limit);
        query.setFirstResult(start);
        return query.getResultList();
       
    }
}
