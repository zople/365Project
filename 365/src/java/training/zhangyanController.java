/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training;


import com.zople.dao.OrderOrderinfoFacade;
import com.zople.dao.OrderOrderproductFacade;
import com.zople.dao.order.OrderAuditFacade;
import com.zople.domain.OrderAudit;
import com.zople.domain.OrderOrderinfo;
import com.zople.domain.OrderOrderproduct;
import com.zople.dto.Item;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author zhangyan
 */
@Named(value = "zhangyanController")
@SessionScoped
public class zhangyanController  implements Serializable {
    java.util.Date now = new java.util.Date(); 
    DateFormat nowDate=DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL); 
    String strNowDate = nowDate.format(now);
    
    private List<Item> items=new ArrayList<Item>();

    /**
     * Creates a new instance of zhangyanController
     */
    public zhangyanController() {
    }
    
    /**
     * 提交订单
     * 
     */
    @EJB
    private OrderOrderinfoFacade orderInfoFacade;
    @EJB
    private OrderOrderproductFacade orderProductFacade;
    @EJB
    private OrderAuditFacade orderAuditFacade;
    
//    @EJB
//    @PersistenceContext(unitName = "365PU")
//    private EntityManager em;
//    
    public void submitOrder(){
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
               // orderInfo.getOrderItemsList().add(orderProduct);
            }
            
           orderInfoFacade.create(orderInfo);
//            em.persist(orderInfo);
            OrderAudit orderAudit=new OrderAudit();
            orderAudit.setAuditState(Integer.valueOf(0));    
            orderAudit.setOrderno(orderInfo.getOrderNo());
            orderAudit.setAuditContent("sdfagf");
            orderAudit.setAuditTime(nowdate);
            orderAuditFacade.create(orderAudit);
//            em.persist(orderAudit);
        }
        
        
    }
    /**
     * 等待付款
     */
    public void waitPay(){
    
        
    }
    /**
     * 发货
     */
    public void deliverGoods(String orderNo){
        
        
    }
            
    /**
     * 收货
     */
    public void takeDeliver(){
        
        
    }
    /**
     * 申请退款
     */
     public void verifyReceiveProduct(){
         
         
     }    
    /**
     * 退货
     */
    public void applicationDrawback(){
        
        
    }
    /**
     * 交易成功
     */
    public void dealSuccess(){
        
        
    }
    
    /**
     * 交易失败
     */
    public void dealFailed(){
        
        
    }
    /**
     * 交易关闭
     */
    public void dealClosed(){
        
        
    }
    
    public List<Item> getItems() {
        items=new ArrayList<Item>();
        items.add(new Item("1","2"));
        items.add(new Item("3","4"));
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public void dosonething(){
     
        HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
       
        for(String s:request.getParameterValues("id")){
             System.out.println(s);
        }
        for(String s:request.getParameterValues("sum")){
             System.out.println(s);
        }
    }
}
