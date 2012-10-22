/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service.order;

import com.zople.service.*;
import com.zople.domain.OrderOrderinfo;
import javax.ejb.Local;

/**
 *
 * @author 王文彦
 */
@Local
public interface OrderServiceBeanLocal {

    OrderOrderinfo createOrder(long enterprseId, long productId);
    
    /****/
    String SubmitOrder(OrderOrderinfo entity,long productId);
    
    /**
     * 修改订单状态
     * @param order_id
     * @return 
     */
    public String updateOrderState(int order_id,String order_state);

    
}
