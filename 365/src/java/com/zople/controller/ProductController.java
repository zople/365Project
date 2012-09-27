 package com.zople.controller;

import com.zople.controller.util.JsfUtil;
import com.zople.dao.CategoryFacade;
import com.zople.dao.EnterpriseFacade;
import com.zople.dao.ProductFacade;
import com.zople.domain.Category;
import com.zople.domain.Enterprise;
import com.zople.domain.Product;
import com.zople.service.CategoryService;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("productController")
@RequestScoped
public class ProductController implements Serializable {

    private Product product;
    @EJB
    private ProductFacade ejbFacade;
    @EJB
    private CategoryFacade categoryFacade;
    @EJB
    private EnterpriseFacade enterpriseFacade;
    @EJB
    private CategoryService catagoryService;
    private Long catagoryId;
    private Long enterpriseId;

    public ProductController() {
        product = new Product();
    }

    public String create() {

        try {
            Category category = categoryFacade.find(catagoryId);
            Enterprise enterprise = enterpriseFacade.find(enterpriseId);
            product.setCategory(category);
            product.setEnterprise(enterprise);
            ejbFacade.create(product);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProductCreated"));
            return "List";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }
    

    public List<Product> findAll(){
        return ejbFacade.findAll();
    }
    public Product getProduct() {
        return product;
    }
    public void remove(){
        Long id=Long.valueOf(JsfUtil.getRequestParameter("id"));
        ejbFacade.remove(ejbFacade.find(id));
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(Long catagoryId) {
        this.catagoryId = catagoryId;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
    
    public List<Category> getProductCatalog(){
           List<Category> categories=catagoryService.findByParentId(0L, 0, 18);
        for(Category c:categories){
            c.setCategories(catagoryService.findByParentId(c.getId(), 0, 10));
        }
        return categories;
    }
}
