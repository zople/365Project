/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training;

import com.zople.dao.OrderAuditFacade;
import com.zople.dao.OrderOrderinfoFacade;
import com.zople.dao.OrderOrderproductFacade;
import com.zople.domain.OrderAudit;
import com.zople.domain.OrderOrderinfo;
import com.zople.domain.OrderOrderproduct;
import java.math.BigDecimal;
import java.text.DateFormat;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
/**
 *
 * @author zhangyan
 */
@Named(value = "zhangyanController")
@Dependent
public class zhangyanController {
    java.util.Date now = new java.util.Date(); 
    DateFormat nowDate=DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL); 
    String strNowDate = nowDate.format(now);

    /**
     * Creates a new instance of zhangyanController
     */
    public zhangyanController() {
    }
    
    /**
     * 立刻购买
     * 
     */
    @EJB
    private OrderOrderinfoFacade orderInfoFacade;
    @EJB
    private OrderOrderproductFacade orderProductFacade;
    @EJB
    private OrderAuditFacade orderAuditFacade;
    
    public void buyRightNow(){
        OrderOrderinfo orderInfo=new OrderOrderinfo();
        for (int i = 1; i < 2; i++) {
            int j = 1;
            orderInfo.setPayState("未支付");
            orderInfo.setReceivedAmount(BigDecimal.valueOf(1500));
            orderInfo.setPrePayment("500");
            orderInfo.setOrderNo("456");
            orderInfo.setPrePayment(String.valueOf(500));
            java.util.Date nowdate = new java.util.Date();
            orderInfo.setOrderTime(nowdate);
            for (; j < 5; j++) {
                OrderOrderproduct orderProduct = new OrderOrderproduct();
                orderProduct.setOrderState("未支付");
                orderProduct.setProductAccount(String.valueOf(1500));
                orderProduct.setProductName("国产锤子");
                orderProduct.setProductPrice(String.valueOf(500));
                orderProduct.setProductTotal(String.valueOf(3));
                orderInfo.getOrderItemsList().add(orderProduct);
            }
            orderInfoFacade.create(orderInfo);
            OrderAudit orderAudit=new OrderAudit();
            orderAudit.setAuditState(Integer.valueOf(0));    
            orderAudit.setOrderno(orderInfo.getOrderNo());
            orderAudit.setAuditContent("sdfagf");
        }
        
        
    }
    /**
     * 提交订单
     */
    public void submitOrder(){
    
        
    }
    /**
     * 付款
     */
    public void pay(){
        OrderAudit orderAudit=new OrderAudit();
        orderAudit.setAuditState(Integer.valueOf(0));
        
       
        orderAudit.setAuditContent("sdfagf");
        
    }
            
    /**
     * 收货
     */
    public void receiveProduct(){
        
        
    }
    /**
     * 确认收货
     */
     public void verifyReceiveProduct(){
         
         
     }    
    /**
     * 退货
     */
    public void backProcduct(){
        
        
    }
    /**
     * 退款
     */
    public void backMoney(){
        
        
    }
    
    /**
     * 评价
     */
    public void evaluation(){
        
        
    }
    /**
     * 仲裁
     */
    public void arbitrate(){
        
        
    }
}
