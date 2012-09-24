/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller;

import com.zople.service.PersionService;
import com.zople.domain.Persion;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author think
 */
@Named(value = "persionController")
@RequestScoped
public class PersionController implements Serializable {
    
    @EJB
    PersionService persionService;
    List<Persion> persions;
    Persion persion;
    Long id=1L;
    
    public  List<Persion> getPersions(){
        persions=persionService.findAll();
        return persions;
    }
    public void setPersions(List<Persion> persions) {
        this.persions = persions;
    }
    
    public Persion getPersion() {
        return persionService.find(id);
    }
    public void setPersion(Persion persion) {
        this.persion=persion;
    }
    
}
