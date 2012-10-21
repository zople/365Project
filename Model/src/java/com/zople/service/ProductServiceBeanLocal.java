/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service;

import com.zople.common.PagingResultValue;
import com.zople.domain.product.ProductMainInfo;
import com.zople.domain.product.SadSupplyProduct;
import javax.ejb.Local;

/**
 *
 * @author 王文彦
 */
@Local
public interface ProductServiceBeanLocal {

    /**
     * 添加产品
     * @param productMainInfo 
     */
    public void addProduct(ProductMainInfo productMainInfo);
    /**
     * 添加供应
     * @param supplyProduct 
     */
    public void addSupplyProduct(SadSupplyProduct supplyProduct);

    public PagingResultValue<SadSupplyProduct> searchProduct(java.lang.String keyWords, int start, int limit);
    
}
