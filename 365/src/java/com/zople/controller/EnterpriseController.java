package com.zople.controller;

import com.zople.service.EnEnterpriseService;
import com.zople.controller.util.JsfUtil;
import com.zople.dao.EnterpriseFacade;
import com.zople.domain.EnEnterprise;
import com.zople.domain.Enterprise;
import com.zople.domain.Image;
import com.zople.domain.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

@Named("enterpriseController")
@RequestScoped
public class EnterpriseController implements Serializable {
    private  Enterprise enterprise;
    @EJB
    private EnterpriseFacade enterpriseFacade;
    private Product product=new Product();
    private UploadedFile file;
    private StreamedContent logo;

    public EnterpriseFacade getEnterpriseFacade() {
        return enterpriseFacade;
    }

    public void setEnterpriseFacade(EnterpriseFacade enterpriseFacade) {
        this.enterpriseFacade = enterpriseFacade;
    }

    public EnEnterpriseService getCompanyService() {
        return companyService;
    }

    public void setCompanyService(EnEnterpriseService companyService) {
        this.companyService = companyService;
    }
    
    public EnterpriseController(){
        enterprise=new Enterprise();
    }
    
    public String create(){
        if(file!=null){
            Image image=new Image();
            File f=new File("");
            try {
                FileInputStream fis=new FileInputStream(f);
                byte[] b=new byte[fis.available()];
                fis.read(b);
                image.setBig(b);
                fis.close();
                
            } catch (IOException ex) {
                Logger.getLogger(EnterpriseController.class.getName()).log(Level.SEVERE, null, ex);
            }
            image.setBig(file.getContents());
            image.setName(file.getFileName());
            image.setImageType(file.getContentType());
            enterprise.setLogo(image);
        }
        enterpriseFacade.create(enterprise);
        return "List";
    }
    public String view(){
            Long id=Long.valueOf(JsfUtil.getRequestParameter("id"));
            enterprise=enterpriseFacade.find(id);
            return "View";
    }
    
    public void remove(){
        Long id=Long.valueOf(JsfUtil.getRequestParameter("id"));
        enterpriseFacade.remove(enterpriseFacade.find(id));
    }
    public List<Enterprise> getAll(){
        return enterpriseFacade.findAll();
    }
    /**  联系我们信息 **/
    @EJB
    EnEnterpriseService companyService;
    public EnEnterprise getListById(){
        return companyService.findById(Long.valueOf(1));
   }
    
    
    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public StreamedContent getLogo() {
        return logo;
    }

    public void setLogo(StreamedContent logo) {
        this.logo = logo;
    }


}
