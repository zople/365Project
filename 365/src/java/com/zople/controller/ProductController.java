package com.zople.controller;

import com.zople.controller.util.JsfUtil;
import com.zople.dao.CategoryFacade;
import com.zople.dao.EnterpriseFacade;
import com.zople.dao.ProductFacade;
import com.zople.dao.ProductMainInfoFacade;
import com.zople.domain.Category;
import com.zople.domain.Enterprise;
import com.zople.domain.OrderOrderinfo;
import com.zople.domain.Product;
import com.zople.domain.product.ProductMainInfo;
import com.zople.dto.ProductDto;
import com.zople.service.CategoryService;
import com.zople.service.ProductService;
import com.zople.service.order.DeliveryFeeServiceBeanLocal;
import com.zople.service.order.OrderServiceBeanLocal;
import java.io.Serializable;
import java.math.BigDecimal;
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
    


    public BigDecimal getReceivableAmount() {
        return receivableAmount;
    }

    public void setReceivableAmount(BigDecimal receivableAmount) {
        this.receivableAmount = receivableAmount;
    }
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
    private ProductService productService;
    @EJB
    OrderServiceBeanLocal orderServiceBeanLocal;
    @EJB
    DeliveryFeeServiceBeanLocal deliveryFeeServiceBeanLocal;   
    private List<ProductMainInfo> productMainInfos;
    private ProductDto productDto=new ProductDto();
    private int count;
    private String productId;
    private BigDecimal   subtotal;//小计
    private BigDecimal shippingCost;//运费
    private BigDecimal receivableAmount=null;//应收金额
    public List<ProductMainInfo> disMainProduct() {
        productMainInfos = productMainInfoFacade.findAll();
        return productMainInfos;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }
/**
 *  通过商品ＩＤ获得商品详情
 * @return 
 */
    public String disMainProductById() {
        String id = JsfUtil.getRequestParameter("id");
        productDto = productService.findProductDto(id, 0);
        return "productDetails";
    }

    public String path(String s) {
        String id = JsfUtil.getRequestParameter("id");
        productDto = productService.findProductDto(id, count);
        BigDecimal unitPrice=new BigDecimal(productDto.getSpecificationsPrice());
        BigDecimal amount=new BigDecimal(productDto.getCount());
        subtotal=unitPrice.multiply(amount);
        
        String path = "";
        if ("立即订购".equals(s)) {
            path = "order2";
        } else if ("去结算".equals(s)) {
            path = "order2";
        }
        return path;
    }
 /**
     * 提交订单
     * 
     */
    public String submitOrder(){
        
     try{  

      OrderOrderinfo entity = new OrderOrderinfo();  
      entity.setFreight(shippingCost);  //运费
      entity.setReceivableAmount(receivableAmount);//应收金额
      entity.setSaleAmount(subtotal);//销售总价
      orderServiceBeanLocal.SubmitOrder(entity,productDto.getId());     
     }catch(Exception e){
         e.printStackTrace();
     }
      
        return "";
    }
    /**
     * 按首重续重计算运费
     * @return 
     */
    public String getSumFreight(){  
        System.out.println("***************************************************************************id="+productDto.getCount());
        return "1";
////        String id = JsfUtil.getRequestParameter("id");
  ///       int count =Integer.parseInt(JsfUtil.getRequestParameter("count"));
////        productDto = productService.findProductDto(id, count);
////        BigDecimal amount=new BigDecimal(productDto.getCount());
//        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);   
//        //shippingCost=deliveryFeeServiceBeanLocal.getDeliveryFee(productDto.getId(),productDto.getEnterpriseId(), amount); 
//        System.out.println("***************************************************************************amount="+count);
////        System.out.println("***************************************************************************productID="+productDto.getId());
////        System.out.println("***************************************************************************enterpriseID="+productDto.getEnterpriseId());
//        shippingCost=new BigDecimal(0);
//        receivableAmount=shippingCost.add(subtotal);
        
    }
  
   /**
    *  计算小计
    * @return 
    */
    public BigDecimal countSubtotal(){
        disMainProductById();
        BigDecimal unitPrice=new BigDecimal(productDto.getSpecificationsPrice());
        BigDecimal amount=new BigDecimal(productDto.getCount());
        BigDecimal subTotal=unitPrice.multiply(amount);
        subtotal=subTotal;
        return  subTotal;

    }
    /**
     * 计算应收金额
     * @return 
     */
//    public BigDecimal countTotal(){
//        BigDecimal subTotal=countSubtotal();
//        BigDecimal cTotal=subTotal.add(shippingCost);
//        return cTotal;
//    }
    
    
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
