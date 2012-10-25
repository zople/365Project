/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service.merchant;

import com.zople.domain.basic.MachiningInfo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author XiaoYanZi
 */
@Local
public interface MachiningServiceBeanLocal {
    /**
     * 发布加工
     * @return 
     */
    public String addMachining(MachiningInfo machiningEntity);    
    /**
     * 我的全部加工
     * @return 
     */
    public List<MachiningInfo> listMachningInfoByEnterpriseId(Long enterpriseId,int start,int limit);
    
}
