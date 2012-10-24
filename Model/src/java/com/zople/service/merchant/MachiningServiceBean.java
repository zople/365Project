/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service.merchant;

import com.zople.dao.basic.MachiningInfoFacade;
import com.zople.domain.basic.MachiningInfo;
import com.zople.domain.basic.MerchantsInfo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author XiaoYanZi
 */
@Stateless
public class MachiningServiceBean implements MachiningServiceBeanLocal {
    @EJB
    MachiningInfoFacade machiningInfoFacade;
    
    
    @Override
    public String addMachining(MachiningInfo machiningEntity) {
        machiningInfoFacade.create(machiningEntity);
        return "";
    }

    @Override
    public List<MachiningInfo> listMachningInfoByEnterpriseId(Long enterpriseId, int start, int limit) {
        List<MachiningInfo> machiningInfos=new ArrayList<MachiningInfo>();
        machiningInfos=machiningInfoFacade.findMachiningInfoByEnterpriseId(enterpriseId, start, limit);
        return machiningInfos;
    }


   

}
