/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller;

import com.zople.authentication.SessionUser;
import com.zople.common.SessionUserHelper;
import com.zople.controller.util.JsfUtil;
import com.zople.dao.basic.UserInfoFacade;
import com.zople.domain.basic.UserInfo;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wangwy
 */
@ManagedBean(name="loginController")
@RequestScoped
public class LoginController implements Serializable {
    
    @EJB
    UserInfoFacade userInfoFacade;
    
    private String username;
    private String password;
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String login(){
        boolean flg=true;
        if(username==null){
            flg=false;
            JsfUtil.addErrorMessage("username", "用户名不能为空");
        }
        if(password==null){
            flg=false;
            JsfUtil.addErrorMessage("password", "用户名不能为空"); 
        }
        if(!flg){
            return null;
        }
        UserInfo userInfo=userInfoFacade.findBuyName(username);
        if(userInfo==null){
             JsfUtil.addErrorMessage("password", "用户名不存在"); 
             return null;
        }
        if(password.equals(userInfo.getPassword())){
             HttpSession session = (HttpSession)
             FacesContext.getCurrentInstance().getExternalContext().getSession(true);
             SessionUser user=new SessionUser();
             user.setId(password);
             session.setAttribute(SessionUserHelper.USER_SESSION_KEY, user);
            return "";
        }
        
        return null;
    }
    /**
     * <p>When invoked, it will invalidate the user's session
     * and move them to the login view.</p>
     *
     * @return <code>login</code>
     */
    public String logout() {
        HttpSession session = (HttpSession)
             FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "login";
        
    }
      
}
