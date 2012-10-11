/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author wangxiu
 * 用户基本信息
 * 用户登陆信息
 */
@Named(value = "userInfo")
@SessionScoped
public class UserInfo implements Serializable {

    /**
     * Creates a new instance of UserInfo
     */
    public UserInfo() {
    }
}
