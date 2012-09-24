/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service;

import com.zople.dao.EnNewsFacade;
import com.zople.domain.EnNews;
import java.util.List;
import javax.ejb.Stateless;
import org.jboss.weld.context.ejb.Ejb;

/**
 *@描述：企业新闻管理 
 *@author yuzhijian
 */
@Stateless
public class EnNewsService {
  
  @Ejb
  EnNewsFacade facade;
  
  /***
   * 查找所有新闻消息
   * @return  实体列表
   */
  public List<EnNews> findAll(){
        return facade.findAll();
    }
    
  
 /**
   * 保存实体信息
   * @return  null
   */
    public void save(EnNews e){
        facade.edit(e);
    }
    
    
    /***
     * 根据ID查找
     * @return  返回单个实体对像
     */
   public EnNews findById(Long id){
        return facade.find(id);
    }

  
  
    
    
    
}
