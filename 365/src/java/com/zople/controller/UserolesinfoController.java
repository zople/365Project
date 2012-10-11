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
 * 用户角色
 */
@Named(value = "userolesinfoController")
@SessionScoped
public class UserolesinfoController implements Serializable {

    /**
     * Creates a new instance of UserolesinfoController
     */
    public UserolesinfoController() {
    }
}
