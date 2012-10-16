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
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;
import javax.ejb.EJB;

/**
 *
 * @author Administrator
 */
@Named(value = "yuliyaoController")
@SessionScoped
public class yuliyaoController implements Serializable {

    /**
     * Creates a new instance of yuliyaoController
     */
    Random random = new Random(30);
    String[] seeds={"天","崖","论","坛","百","事","可","乐","风","日","和","里","哈","你","风","Hello","World","非","莽","哈","非","拟","呵","晚","胡","反","笔","记","本","完","材","型","王","星","被","北","京","飞","牛","人","完","碗","次","俺","金","华","永","康","启","东","余","姚","丹","阳","模","具","黄","岩","余","姚","溪","宁","波","密","封","件","嘉","善","宁","波","刀","具","阳","江","大","足","杭","州","临","沂"};
     public String getText(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(seeds[random(seeds.length)]);
        }
        return sb.toString();
    }

    public int random(int scope) {
        int r = random.nextInt();
        if (r < 0) {
            r = -r;
        }
        r = r % scope;
        return r;
    }
    
    
    public yuliyaoController() {
    }
//    @EJB
//    private OrderAuditFacade orderauditFacade;
//    @EJB
//    private OrderOrderproductFacade orderproductFacade;
    @EJB
    private OrderOrderinfoFacade orderinfotFacade;
    public void submitOrder(){
        OrderOrderinfo orderinfo;
           int j=1;
           orderinfo = new OrderOrderinfo();
           orderinfo.setId(Long.valueOf(1));
           orderinfo.setOrderNo("4321");
           for(;j<10;j++){
            OrderOrderproduct orderproduct =new OrderOrderproduct();
            orderproduct.setId(Long.valueOf(j));
            orderproduct.setProductName(getText(2));
            orderproduct.setProductPrice(String.valueOf(j*10));
            orderproduct.setProductAccount(String.valueOf(2));
            orderproduct.setProductTotal(String.valueOf(j*20));
            orderproduct.setOrderState("等待付款");
            orderproduct.setOrderinfo(orderinfo);
            OrderAudit orderaudit=new OrderAudit();
            orderaudit.setAuditId(Long.valueOf(j));
            orderaudit.setOrderno(orderinfo.getOrderNo());
            orderaudit.setAuditState(0);
            orderaudit.setAuditContent("提交订单");
            orderaudit.setAuditTime(new Date());
            orderinfo.getOrderAudit().add(orderaudit);
            
         }
          
           orderinfo.setOrderState("等待付款");
           orderinfo.setStateTime(new Date());
           orderinfo.setReasonCode(getText(2));
           orderinfo.setRemark(getText(12));
           orderinfo.setDistributionModel(getText(2));
           orderinfo.setPayModel(getText(2));
           orderinfo.setPayState("等待付款");
           orderinfo.setReceivableAmount(BigDecimal.valueOf(j*20));
           orderinfo.setPrePayment(String.valueOf(j*20));
           orderinfo.setFinishTime(new Date());
           orderinfo.setVenderCode("4567");
           orderinfo.setFreight(BigDecimal.valueOf(20));
           orderinfo.setWeight(BigDecimal.valueOf(5));
           orderinfo.setInvoice("9876000");
           orderinfo.setOrderTime(new Date());
           orderinfo.setOrderRemaek(getText(4));
           orderinfo.setSaleAmount(BigDecimal.valueOf(2));
           orderinfo.setTerminateType(getText(2));
           orderinfo.setReceivesTime(new Date());
           orderinfo.setExpressId(getText(3));
           orderinfo.setNeedInvoice(getText(2));
           orderinfo.setReceivedAmount(BigDecimal.valueOf(2));
           orderinfotFacade.create(orderinfo); 
    }
    
    public void waitForPayment(){
        
    }
    public void sendProduct(){
        
    }
    public void receiveProduct(){
        
    }
    public void applyForRefundment(){
        
    }
    public void tradeSuccess(){
        
    }
    public void tradefailure(){
        
    }
    public void tradeOver(){
        
    }
    
}
