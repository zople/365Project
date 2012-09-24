/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao.utils;

import java.util.List;

/**
 *
 * @author 王文彦
 */
public class CollectionUtil {
    
    public static <T> T getFirstElement(List<T> list){
        if(list==null||list.isEmpty()){
            return null;
        }
        return list.get(1);
    }
}
