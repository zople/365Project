/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service.merchant;

import com.zople.domain.basic.MerchantsInfo;
import java.util.List;
import javax.ejb.Local;

/**
 *招商信息
 * @author XiaoYanZi
 */
@Local
public interface MerchantServiceBeanLocal {
    /**
     * 发布招商信息
     * @param merchantEntity
     * @return 
     */
    public String addMerchantInfo(MerchantsInfo merchantEntity);
    /**
     * 通过企业ID查询企业发布的招商信息
     */
    public List<MerchantsInfo> listMerchantsByEnterpriseId(Long enterpriseId,int start,int limit);
}
