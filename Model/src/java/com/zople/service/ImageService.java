/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service;

import com.zople.dao.ImageFacade;
import com.zople.domain.Image;
import javax.ejb.EJB;
import javax.ejb.Stateless;
/**
 *
 * @author 王文彦
 */
@Stateless
public class ImageService {
    
    @EJB
    private ImageFacade imageFacade;
    
    public Image findById(Long id){
        return imageFacade.find(id);
    }
}
