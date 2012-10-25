/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller.merchant;

import com.zople.domain.basic.MachiningInfo;
import com.zople.service.merchant.MachiningServiceBeanLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author XiaoYanZi
 */
@Named("MachiningController")
@RequestScoped
public class MachiningController {
    
     private List<MachiningInfo> myMachiningInfo;
     private MachiningInfo machiningInfoEntity;
    
    @EJB
    MachiningServiceBeanLocal machiningServiceBeanLocal;
    
   
   
    /**
     * 发布加工
     */
    public String submitMachining(){
        machiningInfoEntity=new MachiningInfo();
        machiningInfoEntity.setCreator("zhang yan");
        machiningInfoEntity.setDescription("jia gong yi ge mo ju");
        machiningInfoEntity.setEnterpriseContactId(1L);
        machiningInfoEntity.setEnterpriseId(1L);
        machiningInfoEntity.setMachiningEquipment("fjdsi");
        machiningInfoEntity.setMachiningTitle("加工");
        machiningInfoEntity.setMachiningType(1);
        machiningInfoEntity.setProcessingCapability("fhsjdoia");
        machiningServiceBeanLocal.addMachining(machiningInfoEntity);
        return "";
    }
    public void aa(){
        System.out.println("***************************************************************aa");
    }
    /**
     * 全部加工（根据企业ＩＤ来查）
     */
    public void listMyMachiningInfo(){
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        myMachiningInfo=machiningServiceBeanLocal.listMachningInfoByEnterpriseId(1L, 0, 10);
        for(int i=0;i<myMachiningInfo.size();i++){
            System.out.println(myMachiningInfo.get(i).getMachiningInfoId());
        }
       
    }
    
}
