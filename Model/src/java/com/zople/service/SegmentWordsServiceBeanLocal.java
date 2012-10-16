/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service;

import javax.ejb.Local;

/**
 *
 * @author 王文彦
 */
@Local
public interface SegmentWordsServiceBeanLocal {

    public  void loadDictionary();
    
    public String segment(String text,String separator);
    
     public String segment(String text);
    
     public void loadDictionary(boolean clearDictionary);
}
