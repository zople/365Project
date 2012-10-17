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
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wangwy
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    @EJB
    UserInfoFacade userInfoFacade;
    private String username;
    private String password;
    private boolean login = false;

    public String login() {
        boolean flg = true;
        if (username == null) {
            flg = false;
            JsfUtil.addErrorMessage("username", "用户名不能为空");
        }
        if (password == null) {
            flg = false;
            JsfUtil.addErrorMessage("password", "密码不能为空");
        }
        if (!flg) {
            return null;
        }
        UserInfo userInfo = userInfoFacade.findBuyName(username);
        if (userInfo == null || userInfo.getUserType() != 1) {
            JsfUtil.addErrorMessage("username", "用户名不存在");
            return null;
        }
        if (password.equals(userInfo.getPassword())) {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            SessionUser user = new SessionUser();
            user.setId("11111111111111");
            user.setIdentifier(userInfo.getId().toString());
            session.setAttribute(SessionUserHelper.USER_SESSION_KEY, user);
            login = true;
            return "/pages/userManage/enterprise/back/main.xhtml";
        }
        JsfUtil.addErrorMessage("password", "密码错误");

        return null;
    }

    public boolean isLogin() {
        return login;
    }

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

    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        login = false;
        return "login";

    }
}
