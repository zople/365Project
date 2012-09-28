/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller;

import com.zople.dao.AdminCanvassTraderFacade;
import com.zople.dao.AdminIndustryNewsFacade;
import com.zople.dao.EnExhibitionFacade;
import com.zople.dao.MMallFacade;
import com.zople.domain.AdminCanvassTrader;
import com.zople.domain.AdminIndustryNews;
import com.zople.domain.EnExhibition;
import com.zople.domain.MMall;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author 王文彦
 */
@Named(value = "indexLoadDataController")
@RequestScoped
public class IndexLoadDataController {
    
    public IndexLoadDataController() {
        
    }
    
    @EJB
    private EnExhibitionFacade enExhibitionFacade;
    @EJB
    private AdminIndustryNewsFacade adminIndustryNewsFacade;
    @EJB 
    private AdminCanvassTraderFacade adminCanvassTraderFacade;
    @EJB
    private MMallFacade mMallFacade;
    
    public List<EnExhibition> getExhibitionList(){
        return enExhibitionFacade.findAll().subList(0, 10);
    }
    
    public List<AdminIndustryNews> getAdminIndustryNewsList(){
        return adminIndustryNewsFacade.findAll().subList(0, 15);
    }
    
    public List<AdminCanvassTrader> getAdminCanvassTraderList(){
       
        return adminCanvassTraderFacade.findAll().subList(0,adminCanvassTraderFacade.count()>10?10:adminCanvassTraderFacade.count());
    }
    public List<MMall> getMMallList(){
        return mMallFacade.findAll().subList(0, mMallFacade.count()>10?10:mMallFacade.count());
    }

}
