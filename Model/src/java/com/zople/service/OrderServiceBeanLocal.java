/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service;

import com.zople.domain.OrderOrderinfo;
import javax.ejb.Local;

/**
 *
 * @author 王文彦
 */
@Local
public interface OrderServiceBeanLocal {

    /**
     *
     * @param enterprseId the value of enterprseId
     * @param productId the value of productId
     * @param buyerId the value of buyerId
     */
    OrderOrderinfo createOrder(long enterprseId, long productId, long buyerId);

    String orderCodeGenerator();
    
}
