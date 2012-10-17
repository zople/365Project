/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller.search;

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
    
    public SearchController() {
        
    }
    
    public void searchSupplyProduct(){}
    
}
