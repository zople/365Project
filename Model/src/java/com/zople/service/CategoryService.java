/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service;

import com.zople.dao.CategoryFacade;
import com.zople.domain.Category;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author think
 */
@Stateless
public class CategoryService {
    
    @EJB
    CategoryFacade facade;
    
    public List<Category> findAll(){
        return null;
    }
    
    public void save(Category category){
        facade.edit(category);
    }
    
    
    
    public Category findById(Long id){
        return facade.find(id);
    }
    
    public List<Category> findByParentId(Long id,int start,int limit){
        return facade.findByParentId(id,start,limit);
    }
    
}
