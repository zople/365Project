package com.zople.controller;

import com.zople.common.SessionUserHelper;
import com.zople.controller.util.JsfUtil;
import com.zople.dao.CategoryFacade;
import com.zople.dao.EnterpriseFacade;
import com.zople.dao.ProductFacade;
import com.zople.dao.ProductMainInfoFacade;
import com.zople.dao.TblEnterpriseFacade;
import com.zople.dao.product.ProductPriceFacade;
import com.zople.dao.product.SupplyProductFacade;
import com.zople.domain.Category;
import com.zople.domain.Enterprise;
import com.zople.domain.Product;
import com.zople.domain.TblEnterprise;
import com.zople.domain.product.ProductMainInfo;
import com.zople.domain.product.SadSupplyProductprice;
import com.zople.domain.product.SupplyProduct;
import com.zople.dto.ProductDto;
import com.zople.service.CategoryService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

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

    public List<Product> findAll() {
        return ejbFacade.findAll();
    }

    public Product getProduct() {
        return product;
    }

    public void remove() {
        Long id = Long.valueOf(JsfUtil.getRequestParameter("id"));
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

    public List<Category> getProductCatalog() {
        List<Category> categories = catagoryService.findByParentId(0L, 0, 18);
        for (Category c : categories) {
            c.setCategories(catagoryService.findByParentId(c.getId(), 0, 10));
        }
        System.out.println(categories.size());
        return categories;
    }

    public List<Product> getSearchProductByCategory() {
        String id = JsfUtil.getRequestParameter("id");
        Category category = categoryFacade.find(Long.valueOf(id));
        List<Product> products = new ArrayList<Product>();
        if (category.getPid() == 0) {
            List<Category> categories = categoryFacade.findByParentId(category.getId(), 0, 100);
            for (Category c : categories) {
                products.addAll(categoryFacade.find(c.getId()).getProductList());
            }
            return products;

        }
        return categoryFacade.find(Long.valueOf(id)).getProductList();
    }

    public String getGoSearch() {
        return "/pages/index/section/ProductSearch.xhtml";
    }

    public List<Category> getProductCatalog2() {
        List<Category> categories = catagoryService.findByParentId(0L, 0, 18);
        for (Category c : categories) {
            c.setCategories(catagoryService.findByParentId(c.getId(), 0, 10));
        }
        return categories.subList(0, 2);
    }

    public List<Product> getRecommendProduct() {
        return ejbFacade.findAll().subList(0, 10);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @EJB
    private ProductMainInfoFacade productMainInfoFacade;
    @EJB
    private SupplyProductFacade supplyProductFacade;
    @EJB
    private ProductPriceFacade productPriceFacade;
    @EJB
    private TblEnterpriseFacade tblEnterpriseFacade;
    private List<ProductMainInfo> productMainInfos;
    private ProductMainInfo productMainInfo;
    private List<SupplyProduct> supplyProducts;
    private SupplyProduct supplyProduct;
    private SadSupplyProductprice sadSupplyProductprice;
    private TblEnterprise tblEnterprise;
    private ProductDto productDto;
    private int count;

    public List<ProductMainInfo> disMainProduct() {
        productMainInfos = productMainInfoFacade.findAll();
        return productMainInfos;
    }

    public String disMainProductById() {
        productDto = new ProductDto();

        String id = JsfUtil.getRequestParameter("id");
        productMainInfo = productMainInfoFacade.find(Long.parseLong(id));
        productDto.setId(Long.parseLong(id));
        productDto.setName(productMainInfo.getName());
        productDto.setProductType(productMainInfo.getProductType());

        supplyProduct = supplyProductFacade.sel(id);
        tblEnterprise = tblEnterpriseFacade.findById(supplyProduct.getEnterpriseId().toString());
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.setAttribute("sellEnterpriseId", supplyProduct.getEnterpriseId());
        session.setAttribute("productId", id);

        sadSupplyProductprice = productPriceFacade.sel(id);
        productDto.setSpecificationsPrice(sadSupplyProductprice.getSpecificationsPrice().toString());
        productDto.setSpeStockQuantity(sadSupplyProductprice.getSpeStockQuantity());
        productDto.setCount(getCount());

        System.out.println("买家企业ID：" + supplyProduct.getEnterpriseId());
        System.out.println("卖家企业ID：" + SessionUserHelper.getSessionUser().getId());
        return "productDetails";
    }

    public String path(String s) {
        String path = "";
        if ("立即订购".equals(s)) {
            path = "order2";
        } else if ("去结算".equals(s)) {
            path = "order2";
        }
        return path;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
