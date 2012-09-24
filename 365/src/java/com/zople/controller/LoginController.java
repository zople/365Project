/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author wangwy
 */
@ManagedBean(name="loginController")
@SessionScoped
public class LoginController implements Serializable {

    private String userName;
    private String password;
    public LoginController() {
    }

    public String login(){
        System.out.println(userName);
        return "";
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
