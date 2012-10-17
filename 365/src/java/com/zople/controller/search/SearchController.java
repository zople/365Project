/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller.search;

import com.zople.common.PagingResultValue;
import com.zople.domain.product.SupplyProduct;
import com.zople.service.ProductServiceBeanLocal;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author 王文彦
 */
@Named(value = "searchController")
@RequestScoped
public class SearchController {
    
    @EJB
    private ProductServiceBeanLocal productServiceBeanLocal;
    
    private String keyWords;
    
    public SearchController() {
        
    }
    
    public void searchSupplyProduct(){
        
//        PagingResultValue<SupplyProduct>  productServiceBeanLocal.searchProduct("", 0, 100);
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
    
    
}
