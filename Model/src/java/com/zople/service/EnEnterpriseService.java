/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zople.service;

import com.zople.dao.EnEnterpriseFacade;
import com.zople.domain.EnEnterprise;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *@描   述: 联系我们  
 *@ author:  Expression yuzhijian_yuxia2217@163 
 *@version: 1.0
 */
@Stateless
public class EnEnterpriseService {
    
    
      
  @EJB
  private EnEnterpriseFacade facade;

    public EnEnterpriseFacade getFacade() {
        return facade;
    }

    public void setFacade(EnEnterpriseFacade facade) {
        this.facade = facade;
    }
  
  /***
   * 查找所有
   * @return  实体列表
   */
  public List<EnEnterprise> findAll(){
        return facade.findAll();
    }
    
  
 /**
   * 保存实体信息
   * @return  null
   */
    public void save(EnEnterprise e){
        facade.edit(e);
    }
    
    
    /***
     * 根据ID查找
     * @return  返回单个实体对像
     */
   public EnEnterprise findById(Long id){
        return facade.find(id);
    }

    

}
