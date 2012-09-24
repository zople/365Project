/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller;

import com.zople.service.Money;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author wangxiu
 */
@Named(value = "moneyController")
@Dependent
public class MoneyController {

    /**
     * Creates a new instance of MoneyController
     */
    
    public MoneyController() {
    }
    @EJB
    Money moneyService;
    public void addData(){
        moneyService.add();
    }
}
