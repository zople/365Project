/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller.merchant;


import com.zople.domain.basic.MerchantsInfo;
import com.zople.service.merchant.MerchantServiceBeanLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author XiaoYanZi
 */
@Named("MerchantController")
@RequestScoped
public class MerchantController {
    private List<MerchantsInfo> myMerchants;
    private MerchantsInfo merchantsInfoEntity;
    /**
     * 跳到填写招商信息的第三步
     * @return 
     */
    public String goToStepThree(){    
        return "stepThree";
        
    }
    @EJB
    MerchantServiceBeanLocal merchantServiceBeanLocal;
    
   
   
    /**
     * 发布招商
     */
    public String submitMerchant(){
        merchantsInfoEntity=new MerchantsInfo();
        merchantsInfoEntity.setEnterpriseId(2L);
        merchantsInfoEntity.setEnterpriseContactId(2L);
        merchantsInfoEntity.setCreator("zhangyan");
        merchantsInfoEntity.setDescription("xiang xi xinxi ");
        merchantsInfoEntity.setMerchantsTitle("求购一个磨具");
        merchantsInfoEntity.setMerchantsType(1);
        merchantServiceBeanLocal.addMerchantInfo(merchantsInfoEntity);
        return "stepThree";
    }
    public void aa(){
        System.out.println("***************************************************************aa");
    }
    /**
     * 我的招商
     */
    public void listMyMerchants(){
        myMerchants=merchantServiceBeanLocal.listMerchantsByEnterpriseId(2L, 1, 10);
        System.out.println(myMerchants.size());
        for(int i=0;i<myMerchants.size();i++){
            System.out.println(myMerchants.get(i).getMerchantsInfoId());
        }
       
    }
}
