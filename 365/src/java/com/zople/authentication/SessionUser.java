/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.authentication;

/**
 *
 * @author 王文彦
 */
public class SessionUser {
    /**用户标示符*/
    private String identifier;
    /**登录实体ID*/
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
    
}
