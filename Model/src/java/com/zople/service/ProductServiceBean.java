/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service;

import com.zople.common.PagingResultValue;
import com.zople.dao.ProductMainInfoFacade;
import com.zople.domain.product.ProductMainInfo;
import com.zople.domain.product.SupplyProduct;
import com.zople.dao.product.SupplyProductFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 王文彦
 */
@Stateless
public class ProductServiceBean implements ProductServiceBeanLocal {

    @EJB
    private ProductMainInfoFacade productMainInfoFacade;
    @EJB
    private SupplyProductFacade supplyProductFacade;
    @EJB
    private SegmentWordsServiceBeanLocal segmentWordsServiceBean;
    
    /**
     * 添加产品
     * @param productMainInfo
     */
    @Override
    public void addProduct(ProductMainInfo productMainInfo) {
        productMainInfoFacade.create(productMainInfo);
    }
   /**
    * 添加供应
    * @param supplyProduct 
    */
    @Override
    public void addSupplyProduct(SupplyProduct supplyProduct) {
        supplyProduct.setDescriptionSegmentation(segmentWordsServiceBean.segment(supplyProduct.getDescription()));
        supplyProduct.setProductNameSegmentation(segmentWordsServiceBean.segment(supplyProduct.getProductName()));
        supplyProductFacade.create(supplyProduct);
        
    } 
    
    @Override
    public PagingResultValue searchProduct(String keyWords,int start,int limit){
        PagingResultValue<SupplyProduct> value=new  PagingResultValue<SupplyProduct>();
        keyWords=segmentWordsServiceBean.segment(keyWords," & ");
        List<SupplyProduct> supplyProducts=supplyProductFacade.search(keyWords, start, limit);
        int total=supplyProductFacade.searchCount(keyWords, start, limit);
        value.setData(supplyProducts);
        value.setPageSize(limit);
        value.setTotalCount(total);
        return value;
    }
    public ProductMainInfoFacade getProductMainInfoFacade() {
        return productMainInfoFacade;
    }

    public void setProductMainInfoFacade(ProductMainInfoFacade productMainInfoFacade) {
        this.productMainInfoFacade = productMainInfoFacade;
    }

    
    
}
