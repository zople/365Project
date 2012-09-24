/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller;

import com.zople.dao.PavilionFacade;
import com.zople.domain.Image;
import com.zople.domain.Pavilion;
import com.zople.service.ImageService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author think
 */
@Named
@RequestScoped
public class ImageController implements Serializable{
    
   @EJB 
    private ImageService service; 
 
    public StreamedContent getImage() throws IOException { 
        FacesContext context = FacesContext.getCurrentInstance(); 
 
        if (context.getRenderResponse()) { 
            return new DefaultStreamedContent(); 
        } 
        else { 
            String id = context.getExternalContext().getRequestParameterMap().get("id"); 
            Image image = service.findById(Long.valueOf(id)); 
            return new DefaultStreamedContent(new ByteArrayInputStream(image.getBig()),image.getImageType()); 
        } 
    } 
    @EJB
    private PavilionFacade pavilionFacade;
    Pavilion pavilion = new Pavilion();
    public StreamedContent getPavilion(){
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getRenderResponse()) { 
            return new DefaultStreamedContent(); 
        } 
        else { 
            String id = context.getExternalContext().getRequestParameterMap().get("id"); 
            pavilionFacade.find(id);
            return new DefaultStreamedContent(new ByteArrayInputStream(pavilion.getBig())); 
        } 
    }
    
}