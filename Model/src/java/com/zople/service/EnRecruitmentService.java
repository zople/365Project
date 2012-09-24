/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zople.service;

import com.zople.dao.EnRecruitmentFacade;
import com.zople.domain.EnRecruitment;
import java.util.List;
import javax.ejb.Stateless;
import org.jboss.weld.context.ejb.Ejb;

/**
 *@描   述:   人才招聘
 *@ author:   yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Stateless
public class EnRecruitmentService {
    
    
  @Ejb
  private EnRecruitmentFacade facade;
  
  /***
   * 查找所有
   * @return  实体列表
   */
  public List<EnRecruitment> findAll(){
        return facade.findAll();
    }
    
  
 /**
   * 保存实体信息
   * @return  null
   */
    public void save(EnRecruitment e){
        facade.edit(e);
    }
    
    
    /***
     * 根据ID查找
     * @return  返回单个实体对像
     */
   public EnRecruitment findById(Long id){
        return facade.find(id);
    }

    

}
