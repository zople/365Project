/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service;

import com.zople.dao.AuthorityFacade;
import com.zople.dao.RoleFacade;
import com.zople.domain.Authority;
import com.zople.domain.Role;
import com.zople.service.exception.ExistException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author 王文彦
 */
@Stateless
@LocalBean
public class AuthorityManagementService {
    
    @EJB
    private RoleFacade roleFacade;
    @EJB
    private AuthorityFacade authorityFacade;

    public void createAuthority(Authority authority) throws ExistException{
        if(authorityFacade.findByName(authority.getName())!=null){
            throw new ExistException("权限名");
        }
        authorityFacade.create(authority);
    }
    
    public void createRole(Role role) throws ExistException{
        if(roleFacade.findByName(role.getName())!=null){
             throw new ExistException("角色名");
        }
        roleFacade.create(role);
    }
    
    public void removeRole(String id){
        roleFacade.remove(roleFacade.find(Long.valueOf(id)));
    }
    public void removeAuthory(Long id){
        authorityFacade.remove(authorityFacade.find(id));
    }
    
    public Authority findAuthoryById(Long id){
        return authorityFacade.find(id);
    }
    
    public List<Authority> findAuthorities(){
        return authorityFacade.findAll();
    }
    
    public List<Role> findRoles(){

        return roleFacade.findAll();
    }
    
    
    


}
