/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zople.controller.order;

import com.zople.controller.util.JsfUtil;
import com.zople.dao.ProductMainInfoFacade;
import com.zople.domain.OrderOrderinfo;
import com.zople.domain.TblEnterprise;
import com.zople.domain.product.ProductMainInfo;
import com.zople.dto.ProductDto;
import com.zople.service.ProductService;
import com.zople.service.order.DeliveryFeeServiceBeanLocal;
import com.zople.service.order.OrderServiceBeanLocal;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *@描   述:  订单管理 
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Named("orderController")
@RequestScoped
public class OrderController implements Serializable {

    
   //加载订单管理Server
    @EJB
    OrderServiceBeanLocal orderServiceBeanLocal;
    @EJB
    DeliveryFeeServiceBeanLocal deliveryFeeServiceBeanLocal;   
    @EJB
    private ProductService productService;
    //页面参数
//     private Long productId;//供应产品ID
//     private BigDecimal   price;//单价
//     private String       productName;//产品名称
//     private Long         num;//产品数量
     private BigDecimal   subtotal;//小计
     private BigDecimal shippingCost;//运费

     private ProductDto productDto;//页面显示的产品详情

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

     public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }
    
    /**
     * 提交订单
     * 
     */
    public String submitOrder(){
        
     try{  
      disMainProductById();
      OrderOrderinfo entity = new OrderOrderinfo();  
      entity.setFreight(shippingCost);  //运费
      BigDecimal receivableAmount=shippingCost.add(subtotal);
      entity.setReceivableAmount(receivableAmount);//应收金额
      entity.setSaleAmount(subtotal);//销售总价
      orderServiceBeanLocal.SubmitOrder(entity,productDto.getId());     
     }catch(Exception e){
         e.printStackTrace();
     }
      
        return "";
    }
    /**
     * 按首重续重计算运费
     * @return 
     */
    public void sumFreight(){  
        disMainProductById();
        BigDecimal amount=new BigDecimal(productDto.getCount());
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);   
        shippingCost=deliveryFeeServiceBeanLocal.getDeliveryFee(productDto.getId(),productDto.getEnterpriseId(), amount);    
        
    }
   /**
    * 通过产品ID获得页面需要的详情
    */
    public void disMainProductById() {        
        String id = JsfUtil.getRequestParameter("id");
        productDto = productService.findProductDto(id, 0);
    }
    
   /**
    *  计算小计
    * @return 
    */
    public BigDecimal countSubtotal(){
        disMainProductById();
        BigDecimal unitPrice=new BigDecimal(productDto.getSpecificationsPrice());
        BigDecimal amount=new BigDecimal(productDto.getCount());
        BigDecimal subTotal=unitPrice.multiply(amount);
        return  subTotal;
//        System.out.println();
//        return new BigDecimal(3);
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

   
    
    
    

}
