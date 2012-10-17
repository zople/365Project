/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zople.service.utils;

import java.util.UUID;

/**
 *@描   述: 工具类
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
public class ServiceUtils {
    
    
 public static String getOrderUuId(){
       UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    

}
