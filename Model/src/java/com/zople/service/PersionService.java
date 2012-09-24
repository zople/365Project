/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service;

import com.zople.dao.PersionFacade;
import com.zople.domain.Persion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 王文彦
 */
@Stateless
public class PersionService {

    @EJB
    PersionFacade persionFacade;

    public void createPosition(Persion persion) {
        persionFacade.create(persion);
    }

    public List<Persion> findAll() {
        return persionFacade.findAll();
    }
    
    public Persion find(Long id) {
        return persionFacade.find(id);
    }
}
