/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service.merchant;

import com.zople.dao.basic.MerchantsInfoFacade;
import com.zople.domain.basic.MerchantsInfo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author XiaoYanZi
 */
@Stateless
public class MerchantServiceBean implements MerchantServiceBeanLocal {

    @EJB
    MerchantsInfoFacade merchantsInfoFacade;
    @Override
    public String addMerchantInfo(MerchantsInfo merchantEntity) {
        merchantsInfoFacade.create(merchantEntity);
        return "";
    }

    @Override
    public List<MerchantsInfo> listMerchantsByEnterpriseId(Long enterpriseId,int start,int limit) {
        List<MerchantsInfo> listMerchants=new ArrayList<MerchantsInfo>();
        listMerchants=merchantsInfoFacade.findMerchantsByEnterpriseId(enterpriseId, start, limit);
        return listMerchants;
        
    }
    
}
