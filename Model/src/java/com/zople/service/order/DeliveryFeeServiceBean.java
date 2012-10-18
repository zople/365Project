/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service.order;


import com.zople.dao.ProductMainInfoFacade;
import com.zople.dao.ShippingCostsFacade;
import com.zople.domain.product.ProductMainInfo;
import com.zople.domain.product.ShippingCosts;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author XiaoYanZi
 */
@Stateless
public class DeliveryFeeServiceBean implements DeliveryFeeServiceBeanLocal {
    
     @EJB
     ProductMainInfoFacade productMainInfoFacade;
     @EJB
     ShippingCostsFacade shippingCostsFacade;
     
     
    
    @Override
    public BigDecimal getDeliveryFee(long productId,long enterpriseId,BigDecimal amount) {
        BigDecimal totalFee = null;
        Long unitWeight=null;
        BigDecimal subAmount=amount.subtract(new BigDecimal(1));
        ShippingCosts  shippingCosts=getShippingCosts(enterpriseId);
        ProductMainInfo productMainInfo=getProductMainInfo(productId);
        unitWeight=productMainInfo.getGrossWeight().longValue();
        if(unitWeight<=1){
            totalFee=shippingCosts.getFirstPrice();
        }
        else{            
            totalFee= shippingCosts.getFirstPrice().add(subAmount.multiply(shippingCosts.getFollowPrice()));     
        }          
        
        return totalFee;
        
     
    }
    
    
      //根据产品ID获得产品对象    
   public ProductMainInfo getProductMainInfo(long productId){
       ProductMainInfo productMainInfo=new ProductMainInfo();
       productMainInfo=productMainInfoFacade.find(productId);
       return productMainInfo;
   }
       
        //根据企业ID获得与企业对应的运费表
   public ShippingCosts getShippingCosts(long enterpriseId){
       ShippingCosts shippingCosts=new ShippingCosts();
       shippingCosts=shippingCostsFacade.find(enterpriseId);
        return shippingCosts;
   }
}
