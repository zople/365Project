/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service.order;

import java.math.BigDecimal;
import javax.ejb.Local;

/**
 *
 * @author XiaoYanZi
 */
@Local
public interface DeliveryFeeServiceBeanLocal {
    //按照首重加续重的方法计算运费
    BigDecimal getDeliveryFee(long productId,long enterpriseId,BigDecimal amount);
    
}
