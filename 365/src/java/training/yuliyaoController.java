/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training;

import com.zople.dao.OrderOrderinfoFacade;
import com.zople.dao.OrderOrderproductFacade;
import com.zople.domain.OrderOrderinfo;
import com.zople.domain.OrderOrderproduct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
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
    @EJB
    private OrderOrderproductFacade orderproductFacade;
    @EJB
    private OrderOrderinfoFacade orderinfotFacade;
    public void buyImmediately(){
        OrderOrderinfo orderinfo;
          int j=1;
       for(int i=1;i<100;i++){
           orderinfo = new OrderOrderinfo();
           orderinfo.setId(Long.valueOf(i));
           for(;j<i*10;j++){
            OrderOrderproduct orderproduct =new OrderOrderproduct();
            orderproduct.setId(Long.valueOf(j));
            orderproduct.setProductName(getText(2));
            orderproduct.setProductPrice(String.valueOf(j*10));
            orderproduct.setProductAccount(String.valueOf(j*2));
            orderproduct.setProductTotal(orderproduct.getProductTotal());
            orderproduct.setOrderState(orderproduct.getOrderState());
            orderinfo.getOrderItemsList().add(orderproduct);
            
       }
           orderinfo.setOrderNo(orderinfo.getOrderNo());
           orderinfo.setOrderState(orderinfo.getOrderState());
           orderinfo.setStateTime(orderinfo.getStateTime());
           orderinfo.setReasonCode(orderinfo.getReasonCode());
           orderinfo.setRemark(orderinfo.getRemark());
           orderinfo.setDistributionModel(orderinfo.getDistributionModel());
           orderinfo.setPayModel(orderinfo.getPayModel());
           orderinfo.setPayState(orderinfo.getPayState());
           orderinfo.setReceivableAmount(orderinfo.getReceivableAmount());
           orderinfo.setPrePayment(orderinfo.getPrePayment());
           orderinfo.setFinishTime(orderinfo.getFinishTime());
           orderinfo.setVenderCode(orderinfo.getVenderCode());
           orderinfo.setFreight(orderinfo.getFreight());
           orderinfo.setWeight(orderinfo.getWeight());
           orderinfo.setInvoice(orderinfo.getInvoice());
           orderinfo.setEnterpriseIdBuy(orderinfo.getEnterpriseIdBuy());
           orderinfo.setOrderTime(new Date());
           orderinfo.setOrderRemaek(orderinfo.getOrderRemaek());
           orderinfo.setSaleAmount(orderinfo.getSaleAmount());
           orderinfo.setTerminateType(orderinfo.getTerminateType());
           orderinfo.setEnterpriseIdSell(orderinfo.getEnterpriseIdSell());
           orderinfo.setReceivesTime(orderinfo.getReceivesTime());
           orderinfo.setExpressId(orderinfo.getExpressId());
           orderinfo.setNeedInvoice(orderinfo.getNeedInvoice());
           orderinfo.setReceivedAmount(orderinfo.getReceivedAmount());
           orderinfotFacade.create(orderinfo); 
       }
         
                
    }
    public void submitOrder(){
        
    }
    public void payment(){
        
    }
    public void receiveProduct(){
        
    }
    public void confirmProduct(){
        
    }
    public void returnProduct(){
        
    }
    public void refundment(){
        
    }
    public void evaluate(){
        
    }
    public void arbitration(){
        
    }
    
}
