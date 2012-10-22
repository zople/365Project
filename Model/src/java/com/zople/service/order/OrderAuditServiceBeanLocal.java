/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service.order;

import com.zople.domain.OrderAudit;
import javax.ejb.Local;

/**
 *@描   述:  流程管理实现类
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Local
public interface OrderAuditServiceBeanLocal {
    
    OrderAudit getOrderAudit(String flow_no);
    
}
