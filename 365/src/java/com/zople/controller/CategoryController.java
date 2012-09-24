/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller;

import com.zople.domain.Category;
import com.zople.service.CategoryService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author think
 */
@Named(value = "categoryController")
@RequestScoped
public class CategoryController implements Serializable {
    
    @EJB
    CategoryService categoryService;
    List<Category> categories;

    
    public  List<Category> getCategories(){
        categories=categoryService.findByParentId(0L, 0, 16);
        for(Category c:categories){
            c.setCategories(categoryService.findByParentId(c.getId(), 0, 10));
        }
        return categories;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
