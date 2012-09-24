/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service.exception;

/**
 *
 * @author 王文彦
 */
public class ExistException extends Exception{
    
    public ExistException(String name){
        super(name+"已经存在");
    }
}
