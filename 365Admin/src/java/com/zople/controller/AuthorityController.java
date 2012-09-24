  package com.zople.controller;

import com.zople.controller.util.JsfUtil;
import com.zople.domain.Authority;
import com.zople.service.AuthorityManagementService;
import com.zople.service.exception.ExistException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author 王文彦
 */
@Named("authorityController")
@RequestScoped
public class AuthorityController implements Serializable {

    private Authority authority;
    @EJB
    private AuthorityManagementService authorityManagementService;
    
    public AuthorityController() {
        authority=new Authority();
    }
    
    public String create(){
        try {
            authorityManagementService.createAuthority(authority);
            JsfUtil.addSuccessMessage("创建成功");
            return "List";
        } catch (ExistException ex) {
            Logger.getLogger(AuthorityController.class.getName()).log(Level.SEVERE, null, ex);
            JsfUtil.addErrorMessage(ex.getMessage());
            return null;
        }
    }
    
    public List<Authority> findAll(){
        return authorityManagementService.findAuthorities();
    }

    public String remove(){
         String id =JsfUtil.getRequestParameter("id");
         authorityManagementService.removeAuthory(Long.valueOf(id));
         return "List";
    }
    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }


}
