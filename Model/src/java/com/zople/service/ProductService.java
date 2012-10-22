/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service;

import com.zople.dao.ProductMainInfoFacade;
import com.zople.dao.TblEnterpriseFacade;
import com.zople.dao.enterprise.EnterpriseContactFacade;
import com.zople.dao.product.ProductPriceFacade;
import com.zople.dao.product.SupplyProductFacade;
import com.zople.domain.TblEnterprise;
import com.zople.domain.TblEnterpriseContact;
import com.zople.domain.product.ProductMainInfo;
import com.zople.domain.product.SadSupplyProductprice;
import com.zople.domain.product.SupplyProduct;
import com.zople.dto.ProductDto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wangxiu
 */
@Stateless
@LocalBean
public class ProductService {
     
 @EJB
    private ProductMainInfoFacade productMainInfoFacade;
    @EJB
    private SupplyProductFacade supplyProductFacade;
    @EJB
    private ProductPriceFacade productPriceFacade;
    @EJB
    private TblEnterpriseFacade tblEnterpriseFacade;
    @EJB
    private EnterpriseContactFacade enterpriseContactFacade;
    private List<ProductMainInfo> productMainInfos;
    private ProductMainInfo productMainInfo;
    private List<SupplyProduct> supplyProducts;
    private SupplyProduct supplyProduct;
    private TblEnterpriseContact tblEnterpriseContact;
    private SadSupplyProductprice sadSupplyProductprice;
    private TblEnterprise tblEnterprise;
    private ProductDto productDto;

    public ProductDto findProductDto(String id,int count) {
        productDto = new ProductDto();

        //String id = JsfUtil.getRequestParameter("id");
        productMainInfo = productMainInfoFacade.find(Long.parseLong(id));
        productDto.setId(Long.parseLong(id));
        productDto.setName(productMainInfo.getName());
        productDto.setProductType(productMainInfo.getProductType());

        supplyProduct = supplyProductFacade.sel(id);
        tblEnterprise = tblEnterpriseFacade.findById(supplyProduct.getEnterpriseId().toString());
        productDto.setEnterpriseName(tblEnterprise.getName());
        productDto.setEnterpriseId(tblEnterprise.getId());
        tblEnterpriseContact = enterpriseContactFacade.findEnterpriseContact(tblEnterprise.getId().toString());
        productDto.setContactName(tblEnterpriseContact.getContactName());

        sadSupplyProductprice = productPriceFacade.sel(id);
        productDto.setSpecificationsPrice(sadSupplyProductprice.getSpecificationsPrice().toString());
        productDto.setSpeStockQuantity(sadSupplyProductprice.getSpeStockQuantity());
        productDto.setCount(count);

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.setAttribute("productDto", productDto);
        return productDto;
    }

}
