package com.zople.controller;

import com.zople.controller.util.JsfUtil;
import com.zople.domain.Authority;
import com.zople.domain.Role;
import com.zople.service.AuthorityManagementService;
import com.zople.service.exception.ExistException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author 王文彦
 */
@Named("roleController")
@SessionScoped
public class RoleController implements Serializable {

    private Role role= new Role();
    private long[] authoryIds;
    
    @EJB
    private AuthorityManagementService authorityManagementService;
    
    public String create(){
        try {
            Set<Authority> authorities=new HashSet<Authority>();
            for(long id:authoryIds){
                authorities.add(new Authority(id));
            }
            role.setAuthoritySet(new ArrayList(authorities));
            authorityManagementService.createRole(role);
            JsfUtil.addSuccessMessage("角色创建成功");
            return "List";
        } catch (ExistException ex) {
            Logger.getLogger(RoleController.class.getName()).log(Level.SEVERE, null, ex);
            JsfUtil.addErrorMessage(ex.getMessage());
            return null;
        }
    }
    
    public String delete(){
         String roleId =JsfUtil.getRequestParameter("id");
         authorityManagementService.removeRole(roleId);
        return "List";
    }
    
    public List<Authority> getAuthorities(){
        return authorityManagementService.findAuthorities();
    }
    
    public List<Role> getRoles(){
        return authorityManagementService.findRoles();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public long[] getAuthoryIds() {
        return authoryIds;
    }

    public void setAuthoryIds(long[] authoryIds) {
        this.authoryIds = authoryIds;
    }
    
}
