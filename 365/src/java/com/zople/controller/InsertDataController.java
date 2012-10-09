package com.zople.controller;

import com.zople.dao.AdminCanvassTraderFacade;
import com.zople.dao.AdminExhibitionFacade;
import com.zople.dao.AdminHelpFacade;
import com.zople.dao.AdminImageFacade;
import com.zople.dao.AdminIndustryNewsFacade;
import com.zople.dao.AdminMagazineFacade;
import com.zople.dao.AdminMessageFacade;
import com.zople.dao.AdminOrderFacade;
import com.zople.dao.AdminOrderItemFacade;
import com.zople.dao.AdminProducetFacade;
import com.zople.dao.AdminRegisterFacade;
import com.zople.dao.AdminSpreadFacade;
import com.zople.dao.AdminStyleFacade;
import com.zople.dao.AuthenticationFacade;
import com.zople.dao.BuyFacade;
import com.zople.dao.CategoryFacade;
import com.zople.dao.CompanyFacade;
import com.zople.dao.ContactFacade;
import com.zople.dao.EnBusinessmenFacade;
import com.zople.dao.EnEnterpriseFacade;
import com.zople.dao.EnExhibitionFacade;
import com.zople.dao.EnFavoriteFacade;
import com.zople.dao.EnInquiryFacade;
import com.zople.dao.EnMoneyFacade;
import com.zople.dao.EnNewsFacade;
import com.zople.dao.EnOrderFacade;
import com.zople.dao.EnPremiumFacade;
import com.zople.dao.EnRecruitmentFacade;
import com.zople.dao.EnStorefrontFacade;
import com.zople.dao.EnUserFacade;
import com.zople.dao.FriendlyLinkFacade;
import com.zople.dao.ImageFacade;
import com.zople.dao.MMallFacade;        
import com.zople.dao.MMerchantFacade;
import com.zople.dao.MMessageFacade;
import com.zople.dao.MMymallFacade;
import com.zople.dao.MRecruitmentFacade;
import com.zople.dao.MachiningFacade;
import com.zople.dao.PavilionFacade;
import com.zople.dao.PersionFacade;
import com.zople.dao.ProcessFacade;
import com.zople.dao.QuoteFacade;
import com.zople.dao.SupplyFacade;
import com.zople.dao.TblUserFacade;
import com.zople.domain.AdminCanvassTrader;
import com.zople.domain.AdminExhibition;
import com.zople.domain.AdminHelp;
import com.zople.domain.AdminImage;
import com.zople.domain.AdminIndustryNews;
import com.zople.domain.AdminMagazine;
import com.zople.domain.AdminMessage;
import com.zople.domain.AdminOrder;
import com.zople.domain.AdminOrderItem;
import com.zople.domain.AdminProducet;
import com.zople.domain.AdminRegister;
import com.zople.domain.AdminSpread;
import com.zople.domain.AdminStyle;
import com.zople.domain.Authentication;
import com.zople.domain.Buy;
import com.zople.domain.Category;
import com.zople.domain.Company;
import com.zople.domain.Contact;
import com.zople.domain.EnBusinessmen;
import com.zople.domain.EnEnterprise;
import com.zople.domain.EnExhibition;
import com.zople.domain.EnFavorite;
import com.zople.domain.EnInquiry;
import com.zople.domain.EnMoney;
import com.zople.domain.EnNews;
import com.zople.domain.EnOrder;
import com.zople.domain.EnPremium;
import com.zople.domain.EnRecruitment;
import com.zople.domain.EnStorefront;
import com.zople.domain.EnUser;
import com.zople.domain.Image;
import com.zople.domain.MMall;
import com.zople.domain.MMerchant;
import com.zople.domain.MMessage;
import com.zople.domain.MMymall;
import com.zople.domain.MRecruitment;
import com.zople.domain.Machining;
import com.zople.domain.Pavilion;
import com.zople.domain.Persion;
import com.zople.domain.Position;
import com.zople.domain.Product;
import com.zople.domain.Property;
import com.zople.domain.Quote;
import com.zople.domain.Supply;
import com.zople.domain.TblFriendlyLink;
import com.zople.domain.TblUser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author think
 */
@Named(value = "insertDataController")
@RequestScoped
public class InsertDataController {
    private Date showDate = new Date();
    @EJB
    SupplyFacade supplyFacade;
    @EJB
    BuyFacade buyFacade;
    @EJB
    CategoryFacade categoryFacade;
    @EJB
    FriendlyLinkFacade friendlyLinkFacade;
    @EJB
    EnEnterpriseFacade enterpriseFacade;
 
    @EJB
    AuthenticationFacade  authenticationFacade;       
    @EJB
    EnRecruitmentFacade recruitmentFacade;
    
    
    @EJB
    EnBusinessmenFacade businessmenFacade;
    @EJB
    EnExhibitionFacade  exhibitionFacade; 
    @EJB
    EnFavoriteFacade    favoriteFacade;  
    @EJB
    EnInquiryFacade     inquiryFacade; 
    @EJB
    EnNewsFacade        newsFacade;  
    @EJB
    EnOrderFacade       orderFacade ;       
    @EJB
    EnPremiumFacade     premiumFacade;        
    @EJB
    EnStorefrontFacade  storefrontFacade; 
    @EJB
    EnUserFacade        userFacade;        
    
    
    
    Random random = new Random(30);
    
    String[] seeds={"天","崖","论","坛","百","事","可","乐","风","日","和","里","哈","你","风","Hello","World","非","莽","哈","非","拟","呵","晚","胡","反","笔","记","本","完","材","型","王","星","被","北","京","飞","牛","人","完","碗","次","俺","金","华","永","康","启","东","余","姚","丹","阳","模","具","黄","岩","余","姚","溪","宁","波","密","封","件","嘉","善","宁","波","刀","具","阳","江","大","足","杭","州","临","沂"};
    @EJB
    AdminCanvassTraderFacade adminCanvassTraderFacade;
    @EJB
    AdminExhibitionFacade adminExhibitionFacade;
    @EJB
    private AdminHelpFacade adminHelpFacade;
    @EJB
    private AdminImageFacade adminImageFacade;
    @EJB
    private AdminIndustryNewsFacade adminIndustryNewsFacade;
    @EJB
    private AdminMagazineFacade adminMagazineFacade;
    public void getInsertData() {
    }


    public void getInsertBuyData() {
        String namesStr = "采购玻璃石材雕刻机 ,采购气体汇流排 ,采购二手发电机 ,采购150铝合金 ,采购IS离心泵 ,采购丹佛斯DANFOSS变频,采购断桥铝门窗双头组,求购开关电源 ,采购云丝手动喷枪 ,采购滚丝机 ,采购三维扫描仪 ,采购电动卷帘 ,采购身份证阅读器 ,采购冰柜 ,采购铜平垫 ,采购全彩LED视频处理器,采购电动货车 ,采购电动货车 ";
        String[] titles = namesStr.split(",");
        Buy buy;
        for (int i = 0; i < titles.length; i++) {
            buy = new Buy();
            buy.setId(Long.valueOf(i));
            buy.setTitle(titles[i]);
            buy.setName(getText(6));
            buy.setCount(i+100);
            buy.setContent(getText(50));
            buy.setEndtime(new Date());
            buy.setCreateTime(new Date());
            buy.setFlg(i);
            buyFacade.create(buy);
        }
    }
    /**
     * 分类信息
     * 产品信息
     * 分类属性信息
     */
    public void getInsertCategoriesData() {
        String[] categories = {"机械设备", "五金工具", "建筑五金", "机电五金", "锁具安防", "日用五金", "五金材料", "通用配件", "运动休闲", "环保设施", "厨房家电", "电子电工", "通用配件", "运动休闲", "环保设施", "厨房家电", "电子电工"};
        String[] categories2 = {"不锈钢材", "普通型钢", "户外用品", "空气净化", "变压器", "普通管材", "五金材料", "健身器材", " 家居用品", "环保设施", "厨房家电", "电子电工", "厨房设备", "家用电器", "电线电缆", "厨房家电", "消防设备"};
        Category category;
        int h=1;
        int j = 1;
        for (int i = 1; i < 20; i++) {
            category = new Category();
            category.setId(Long.valueOf(i));
            category.setName(categories[random(categories.length)]);
            category.setPid(0l);
            categoryFacade.create(category);
            for (; j < 10*i; j++) {
                category = new Category();
                category.setId(Long.valueOf(System.nanoTime()));
                category.setName(categories2[random(categories2.length)]);
                category.setPid((long) i);
                for(;h<j*10;h++){
                    Product product = new Product();
                    product.setName(getText(2));
                    product.setDescription(getText(40));
                    product.setCategory(category);
                    category.getProductList().add(product);
                    
                    Property property = new Property();
                  //  property.setId(Long.valueOf(h));
                    property.setName(getText(3));
                    property.setDescription(getText(20));
                    property.setCreateTime(showDate);
                    property.setCategory(category);
                    category.getPropertyList().add(property);
                }
                categoryFacade.create(category);
            }
        }
    }
    public void getIntertFriendlyLinkData(){
        TblFriendlyLink friendlyLink;
        for(int i=0;i<200;i++){
            friendlyLink=new TblFriendlyLink();
            //friendlyLink.setId(Long.valueOf(i));
            friendlyLink.setContent(getText(10));
            friendlyLink.setDescription(getText(50));
            friendlyLink.setCreateTime(new Date());
            friendlyLink.setName(getText(2));
            friendlyLinkFacade.create(friendlyLink);
        }
    }
    
    /**   新增企业信息数据（en_enterprise）  **/
    public void insertEnterpriseData(){
        EnEnterprise  enterprise=new EnEnterprise();
        int j=1;
        for(int i=1;i<200;i++){
            enterprise=new EnEnterprise();
            enterprise.setId(Long.valueOf(i));
            enterprise.setName(getText(5));
            enterprise.setUrl("http://www."+i+".com");
            enterprise.setTelphone("1234567"+i+5);
            enterprise.setPhone("0800"+"1111"+i+2);
            enterprise.setFaxes(getText(6));
            enterprise.setAddress(getText(20));
            enterprise.setMainProduct(getText(10));
            enterprise.setDescription(getText(50));
            enterprise.setCreate_time(new Date());
            for(;j<i*10;j++){
               Supply supply= new Supply();
               //supply.setId(Long.valueOf(j));
               supply.setTitle(getText(6));
               supply.setDescription(getText(20));
               supply.setCompany(enterprise);
               enterprise.getSupplyList().add(supply);
            }
            enterpriseFacade.create(enterprise);
        }
    }
    /**      企业认证           */
 
    public void insertEnAuthenticationData(){
        Authentication  authentication;
        for(int i=0;i<100;i++){
            authentication=new Authentication();
            authentication.setId(Long.valueOf(i));
            authentication.setName(getText(10));
            authenticationFacade.create(authentication);
        }
    }
 
     /**      人才招聘           */
    public void insertEnRecruitmentData(){
        EnRecruitment  recruitment;
        for(int i=0;i<200;i++){
            recruitment=new EnRecruitment();
            recruitment.setId(Long.valueOf(i));
            recruitment.setRequire(getText(50));
            recruitment.setPhone("123456");
            recruitment.setPay(i+5000);
            recruitment.setItRequire(getText(50));
            recruitment.setExperience(i);
            recruitment.setCreateTime(new Date());
            recruitment.setCount(i+1);
            recruitment.setDescription(getText(50));
            recruitment.setSex(getText(2));
            recruitment.setAddress(getText(10));
            recruitment.setQuale(getText(4));
            recruitment.setEducation(getText(2));
            recruitment.setForeignLang(getText(2));
            recruitment.setEndTime(new Date(+i));
            recruitment.setDescription(getText(40));
            recruitmentFacade.create(recruitment);
        }
    }
    
    
    public void insertMouData(){
        EnBusinessmen businessmen;
        EnFavorite    favorite;
        EnInquiry     inquiry;
        EnNews        news;
        EnOrder       order;
        EnPremium     premium;
        EnStorefront  storefront;
        EnUser        user;
        for(int i=0;i<200;i++){
            businessmen=new EnBusinessmen();

            favorite=new EnFavorite();
            inquiry=new EnInquiry();
            news=new EnNews();
            order=new EnOrder();
            premium=new EnPremium();
            storefront=new EnStorefront();
            user=new EnUser();
            
            businessmen.setId(Long.valueOf(i));
            businessmen.setName(getText(50));

            favorite.setId(Long.valueOf(i));
            favorite.setName(getText(50));
            inquiry.setId(Long.valueOf(i));
            inquiry.setName(getText(50));
            news.setId(Long.valueOf(i));
            news.setName(getText(50));
            order.setId(Long.valueOf(i));
            order.setName(getText(4));
            order.setDescription(getText(40));
            premium.setId(Long.valueOf(i));
            premium.setName(getText(50));
            storefront.setId(Long.valueOf(i));
            storefront.setName(getText(50));
            user.setId(Long.valueOf(i));
            user.setName(getText(50));
            
            businessmenFacade.create(businessmen);

            favoriteFacade.create(favorite);
            inquiryFacade.create(inquiry);
          //  newsFacade.create(news);
            orderFacade.create(order);
            premiumFacade.create(premium);
            storefrontFacade.create(storefront);
            userFacade.create(user);

        }
    }
    public void insertExhibitionData(){
           EnExhibition  exhibition;
              for(int i=0;i<200;i++){
                     exhibition=new EnExhibition();
                     exhibition.setId(Long.valueOf(i));
                     exhibition.setUrl("http://www."+i+10+".com");
                     exhibition.setTitle(getText(6));
                     exhibition.setStartTime(new Date(+5+i));
                     exhibition.setSponsor(getText(5));
                     exhibition.setQq(i+10+9876);
                     exhibition.setPhone(i+"123998");
                     exhibition.setOrganizer(getText(5));
                     exhibition.setMsn(getText(i+1));
                     exhibition.setDescription(getText(50));
                     exhibition.setCreateTime(new Date(i));
                     exhibition.setContent(getText(50));
                     exhibition.setAuthorize(getText(5));
                     exhibition.setLine(getText(10));
                     exhibition.setAddress(getText(10));
                     exhibitionFacade.create(exhibition);
              }
    }
    
    public void getInsertAdminCanvassTraderData() {
        AdminCanvassTrader adminCanvassTrader;
        for (int i = 0; i < 200; i++) {
            adminCanvassTrader = new AdminCanvassTrader();
            adminCanvassTrader.setId(Long.valueOf(i));
            adminCanvassTrader.setDescription(getText(45));
            adminCanvassTrader.setTraderName(getText(3));
            adminCanvassTrader.setFactoryName(getText(16));
            adminCanvassTrader.setAddress(getText(6));
            adminCanvassTrader.setEndtime(new Date());
            adminCanvassTrader.setKind(getText(4));
            adminCanvassTrader.setName(getText(20));
            adminCanvassTrader.setPack(getText(5));
            adminCanvassTrader.setStandard(getText(10));
            adminCanvassTrader.setTitle(getText(3));
            adminCanvassTraderFacade.create(adminCanvassTrader);
        }
    }

    public void getInsertAdminExhibition() {
        AdminExhibition adminExhibition;
        for (int i = 0; i < 200; i++) {
            adminExhibition = new AdminExhibition();
            adminExhibition.setId(Long.valueOf(i));
            adminExhibition.setName(getText(11));
            adminExhibition.setDescription(getText(60));
            adminExhibitionFacade.create(adminExhibition);
        }
    }

    public void getInsertAdminImageData() {
        AdminImage adminImage;
        for (int i = 0; i < 200; i++) {
            adminImage = new AdminImage();
            adminImage.setId(Long.valueOf(i));
            adminImage.setDescription(getText(20));
            adminImage.setName(getText(5));
            adminImageFacade.create(adminImage);
        }
    }

    public void getInsertAdminIndustryNewsData() {
        AdminIndustryNews adminIndustryNews;
        for (int i = 0; i < 200; i++) {
            adminIndustryNews = new AdminIndustryNews();
            adminIndustryNews.setId(Long.valueOf(i));
            adminIndustryNews.setDescription(getText(20));
            adminIndustryNews.setClassTitle(getText(7));
            adminIndustryNews.setContent(getText(60));
            adminIndustryNewsFacade.create(adminIndustryNews);
        }
    }
   //帮助
    public void getAdminHelpIndustryNewsData() {
        AdminHelp adminHelp;
        for (int i = 0; i < 200; i++) {
            adminHelp = new AdminHelp();
            adminHelp.setId(Long.valueOf(i));
            adminHelp.setDescription(getText(20));
            adminHelp.setCreateTime(new Date());
            adminHelp.setContent(getText(60));
            adminHelp.setClassName(getText(2));
            adminHelp.setName(getText(2));
            adminHelpFacade.create(adminHelp);
        }
    }

    public void getAdminMagazineData() {
        AdminMagazine adminMagazine;
        for (int i = 0; i < 200; i++) {
            adminMagazine = new AdminMagazine();
            adminMagazine.setId(Long.valueOf(i));
            adminMagazine.setDescription(getText(20));
            adminMagazine.setName(getText(10));
            adminMagazineFacade.create(adminMagazine);
        }
    }
    @EJB
    private AdminMessageFacade adminMessageFacade;
    /*商贸城基本信息管理表*/

    public void getInsertAdminMessageData() {
        AdminMessage adminMessage;
        for (int i = 0; i < 200; i++) {
            adminMessage = new AdminMessage();
            adminMessage.setId(Long.valueOf(i));
            adminMessage.setDescription(getText(20));
            adminMessage.setName(getText(10));
            adminMessageFacade.create(adminMessage);
        }
    }
    @EJB
   private AdminOrderFacade adminOrderFacade;
//    /*订单*/
//
//    public void getInsertAdminOrderData() {
//        AdminOrder adminOrder;
//        for (int i = 0; i < 200; i++) {
//            adminOrder = new AdminOrder();
//            adminOrder.setId(Long.valueOf(i));
//            adminOrder.setDescription(getText(20));
//            adminOrder.setName(getText(10));
//            adminOrderFacade.create(adminOrder);
//        }
//    }
    @EJB
    private AdminOrderItemFacade adminOrderItemFacade;
    /*订单项*/

    public void getInsertAdminOrderItemData() {
        AdminOrderItem adminOrderItem;
        AdminOrder adminOrder;
        int j=1;
        for (int i = 1; i < 200; i++) {
            adminOrder = new AdminOrder();
            adminOrder.setId(Long.valueOf(i));
            adminOrder.setDescription(getText(20));
            adminOrder.setName(getText(10));
            System.out.print("$$$"+i);
            for (; j < i*10; j++) {
                adminOrderItem = new AdminOrderItem();
                adminOrderItem.setId(Long.valueOf(j));
                adminOrderItem.setDescription(getText(20));
                adminOrderItem.setName(getText(10));
                adminOrder.getAdminOrderItemList().add(adminOrderItem);
                 System.out.print("###"+j);
            }
            adminOrderFacade.create(adminOrder);
        }

    }
    
    @EJB
    private AdminProducetFacade adminProducetFacade;
    /*产品信息*/

    public void getInsertAdminProducetOrderItemData() {
        AdminProducet adminProducet;
        for (int i = 0; i < 200; i++) {
            adminProducet = new AdminProducet();
            adminProducet.setId(Long.valueOf(i));
            adminProducet.setDescription(getText(20));
            adminProducet.setName(getText(10));
            adminProducetFacade.create(adminProducet);
        }
    }
    @EJB
    private AdminRegisterFacade adminRegisterFacade;
    /*用户注册*/

    public void insertAdminRegisterData() {
        AdminRegister adminRegister;
        for (int i = 0; i < 200; i++) {
            adminRegister = new AdminRegister();
            adminRegister.setId(Long.valueOf(i));
            adminRegister.setDescription(getText(20));
            adminRegister.setName(getText(10));
            adminRegister.setArea("北京");
            adminRegister.setEmail("wangwenyan@163.com");
            adminRegister.setIp("localhost");
            adminRegisterFacade.create(adminRegister);
        }
    }
    @EJB
    private AdminSpreadFacade adminSpreadFacade;
    /*用户推广*/

    public void insertAdminSpreadData() {
        AdminSpread adminSpread;
        for (int i = 0; i < 200; i++) {
            adminSpread = new AdminSpread();
            adminSpread.setId(Long.valueOf(i));
            adminSpread.setDescription(getText(20));
            adminSpread.setBrandName(getText(6));
            adminSpreadFacade.create(adminSpread);
        }
    }
    @EJB
    private AdminStyleFacade adminStyleFacade;
    /*网站模板*/

    public void insertAdminStyleData() {
        AdminStyle adminStyle;
        for (int i = 0; i < 200; i++) {
            adminStyle = new AdminStyle();
            adminStyle.setId(Long.valueOf(i));
            adminStyle.setDescription(getText(20));
            adminStyle.setEnterpriseStyle(getText(50));
            adminStyleFacade.create(adminStyle);
        }
    }
    /*商贸城用户基本信息*/
    @EJB
    private MMallFacade mMallFacade;

    public void insertMMall() {
        MMall mMall;
        for (int i = 0; i < 200; i++) {
            mMall = new MMall();
            mMall.setId(Long.valueOf(i));
            mMall.setDescribes(getText(33));
            mMall.setEmail("wangwenyan@134.com");
            mMall.setPhone("12345678909");
            mMallFacade.create(mMall);
        }
    }
    @EJB
    private MMerchantFacade mMerchantFacade;
    
    /*入住商户信息*/
    public void insertMMerchant() {
        MMerchant mMerchant;
        for (int i = 0; i < 200; i++) {
            mMerchant = new MMerchant();
            mMerchant.setId(Long.valueOf(i));
            mMerchant.setDescribes(getText(33));
            mMerchant.setName(getText(6));
            mMerchantFacade.create(mMerchant);
        }
    }
    @EJB
    private MMessageFacade  messageFacade;
    public void insertMessage(){
        MMessage message;
         for (int i = 0; i < 200; i++) {
            message = new MMessage();
            message.setId(Long.valueOf(i));
            message.setDescribes(getText(33));
            message.setName(getText(6));
            messageFacade.create(message);
        }
    }
    @EJB
    private MMymallFacade mymalfacade;
    public void insertMymall(){
        MMymall mymall;
        for (int i = 0; i < 200; i++) {
            mymall = new MMymall();
            mymall.setId(Long.valueOf(i));
            mymall.setDescribes(getText(33));
            mymall.setName(getText(6));
            mymalfacade.create(mymall);
        }
    }
    @EJB
    private MRecruitmentFacade recruitmentCade;
    public void insertMrecruitment(){
         MRecruitment recruitment;
        for (int i = 0; i < 200; i++) {
            recruitment = new MRecruitment();
            recruitment.setId(Long.valueOf(i));
            recruitment.setDescribes(getText(33));
            recruitment.setName(getText(6));
            recruitmentCade.create(recruitment);
        }
    }

    /**
     * 报价 *
     */
    @EJB
    private QuoteFacade quoteFacade;
    public void insertQuortData(){
        Quote quote = new Quote();
        for(int i=0;i<200;i++){
            quote.setId(Long.valueOf(i));
            quote.setDescription(getText(50));
            quote.setName(getText(50));
            quote.setGood(getText(10));
            quote.setPhone(getText(10));
            quote.setAddress(getText(50));
            quote.setPrice(i+100);
            quote.setTelPhone("123456777999");
            quoteFacade.create(quote);
        }
    }
    @EJB 
    private ProcessFacade processFacade;
    public void insertProcessDate(){
        com.zople.domain.Process process = new com.zople.domain.Process();
        for(int i=0;i<200;i++){
            process.setId(Long.valueOf(i));
            process.setTitle(getText(20));
            process.setKind(getText(5));
            process.setDevice(getText(10));
            process.setAbility(getText(20));
            process.setDescription(getText(50));
            processFacade.create(process);
        }
    }
    //加工
    @EJB
    private MachiningFacade machiningFacade;
    public void insertMachingData(){
        for(int i=1;i<200;i++){
            Machining machining = new Machining();
            machining.setId(Long.valueOf(i));
            machining.setKind(getText(3));
            machining.setTitle(getText(5));
            machining.setDevice("D00T"+i);
            machining.setAbility(getText(2));
            machining.setDescription(getText(50));
            machiningFacade.create(machining);
        }
    }
            
    @EJB
    private PavilionFacade pavilionFacade;
    public void insertPrvilionData(){
        Pavilion pavilion = new Pavilion();
        File f=null;
        //String url = "C:/Users/wangxiu/Desktop/1.png";
        FileInputStream fis;
        for(int i=0;i<200;i++){
            pavilion.setWay(getText(10));
            pavilion.setUrl("http://www."+i+10+".com");
            pavilion.setTelphone("15900233"+i);
            pavilion.setLinkman(getText(2));
            pavilion.setId(Long.valueOf(i));
            pavilion.setFax(getText(5));
            pavilion.setDescription(getText(50));
            pavilion.setAddress(getText(60));
       // try {
            //f = new File(url);
           // fis = new FileInputStream(f);
            //byte[] b;
            //try {
             //   b = new byte[fis.available()];
              //  fis.read(b);
              //  pavilion.setBig(b);
             //   fis.close();
                pavilionFacade.create(pavilion);
           // } catch (IOException ex) {
              //  Logger.getLogger(InsertDataController.class.getName()).log(Level.SEVERE, null, ex);
           // }
        //} catch (FileNotFoundException ex) {
        //    Logger.getLogger(InsertDataController.class.getName()).log(Level.SEVERE, null, ex);
        //}
        }
     }
    /*** person  **/
    @EJB
    private PersionFacade personFacade;
    public void insetPersonData(){
        for(int i=0;i<200;i++){
         Persion persion=new Persion();
         persion.setContactTelephone("1234566666");
         persion.setEducationIntroduction(getText(2));
         persion.setExpectAddress(getText(10));
         persion.setExpectSalary(getText(5));
         persion.setGraduationSchool(getText(6));
         persion.setId(Long.valueOf(i));
         persion.setJobDate(new Date());
         persion.setJobIntention(getText(6));
         persion.setMaritalStatus(getText(6));
         persion.setNativePlace(getText(6));
         persion.setPersionAddress(getText(20));
         persion.setPersionAge(i);
         persion.setPersionEducation("2");
         persion.setPersionEmail("123456@qq.com");
         persion.setPersionGender(getText(2));
         persion.setPersionHonor(getText(2));
         persion.setPersionName(getText(2));
         persion.setPersionPhone("1234546777");
         persion.setPersionProfessional(getText(4));
         persion.setPersionQq("1234567");
         persion.setPersionTitle(getText(6));
         persion.setPoliticalAffiliation(getText(6));
         persion.setWorkedDate(getText(4));
         persion.setWorkedIntroduction(getText(50));
         persion.setWorkedName(getText(8));
         personFacade.create(persion);
        }
    }
    
    @EJB
    private CompanyFacade companyFacade;
   public void insertCompanyDate(){
       Company company;
       int j=1;
       for(int i=1;i<100;i++){
           company = new Company();
           company.setId(Long.valueOf(i));
           for(;j<i*10;j++){
            Position position =new Position();
            position.setAcademicRequirement(getText(6));
            position.setCreateTime(new Date());
            position.setEndTime(new Date());
            position.setGenderRequirement(getText(2));
            position.setId(Long.valueOf(j));
            position.setLanguageRequirement(getText(2));
            position.setNeedCount(i+5); 
            position.setCompanyId(company);
            company.getPositionCollection().add(position);
       }
           company.setCompanyAddress(getText(20));
           company.setCompanyName(getText(7));
           companyFacade.create(company);
       }
   } 
   public String getAllData(){
        if(tbluserFacade.count()>0){
            return "数据已存在";
        }
        insetUserData();
        //getInsertSupplyData();
        getInsertBuyData();
        getInsertCategoriesData();
        getIntertFriendlyLinkData();
        insertEnterpriseData();
        insertEnRecruitmentData();
        insertMouData();
        insertExhibitionData();
        getInsertAdminCanvassTraderData() ;
        getInsertAdminExhibition();
        getInsertAdminImageData();
        getInsertAdminIndustryNewsData();
        getAdminHelpIndustryNewsData();
        getAdminMagazineData();
        getInsertAdminMessageData();
//        getInsertAdminOrderData();
        getInsertAdminOrderItemData();
        getInsertAdminProducetOrderItemData();
        insertAdminRegisterData();
        insertAdminSpreadData();
        insertAdminStyleData();
        insertMMall();
        insertMMerchant() ;
        insertMessage();
        insertMymall();
        insertMrecruitment();
        insertQuortData();
        insertProcessDate();
        insertPrvilionData();
        insetPersonData();
        insertCompanyDate();
        insetImages();//图片
        addMoney();  //金融动态
        insertContaceData();//联系人信息
        insertMachingData();//加工信息。
        return "success";
   }

    public void allDate() {
        getInsertBuyData();
        getInsertCategoriesData();
        getIntertFriendlyLinkData();
        insertEnterpriseData();
        insertEnAuthenticationData();
        insertEnRecruitmentData();
        insertMouData();
        insertExhibitionData();
        getInsertAdminCanvassTraderData();
        getInsertAdminExhibition();
        getInsertAdminImageData();
        getInsertAdminIndustryNewsData();
        getAdminHelpIndustryNewsData();
        getAdminMagazineData();
        getInsertAdminMessageData();
       // getInsertAdminOrderData();
        getInsertAdminOrderItemData();
        getInsertAdminProducetOrderItemData();
        insertAdminRegisterData();
        insertAdminSpreadData();
        insertAdminStyleData();
        insertMMall();
        insertMMerchant();
        insertMessage();
        insertMymall();
        insertMrecruitment();
        insertQuortData();
        insertProcessDate();
        insertPrvilionData();
        insetPersonData();
        insertCompanyDate();
    }
    /**   图片         */
    @EJB
    ImageFacade imageFacade;
    public void insetImages() {
        Image  image;
        File f=null;
         HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url=request.getRealPath("/")+"\\resources\\images\\18.png";
        FileInputStream fis;
        for(int i=0;i<100;i++){
        try {
            f = new File(url);
            fis = new FileInputStream(f);
            byte[] b;
            try {
                image = new Image();
                b = new byte[fis.available()];
                fis.read(b);
                image.setBig(b);
                fis.close();
                imageFacade.create(image);
            } catch (IOException ex) {
                Logger.getLogger(InsertDataController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InsertDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
    }    
    
    public Date getShowDate(){
        return new Date();
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }
       
    /** 新增用户信息  **/
    @EJB
    private TblUserFacade tbluserFacade;
    public void insetUserData(){
        //int [] userType = {1,2,3};   //1，企业用户2，市场用户3个人用户
        TblUser user=new TblUser();
        String userType = "企业，市场，用户";
        for(int i=1;i<200;i++){
            user.setId(Long.valueOf(i));
            user.setUserType(random(3));
            user.setLoginName(getText(2));
            user.setPassword("123");
            user.setEmail(getText(2)+"@zmcloud.com");
            user.setCreateTime(new Date());
            user.setLastLoginTime(new Date());
            tbluserFacade.create(user);
        }
    }
   /**金融动态*/
    @EJB
    EnMoneyFacade moneyFacade;
    private EnMoney money;
    public void addMoney(){
         for (int i = 0; i < 200; i++) {
            money = new EnMoney();
            money.setId(Long.valueOf(i));
            money.setName(getText(3));
            money.setMoney(Integer.valueOf(i+100));
            moneyFacade.create(money);
        }
    }
    
    /*联系人*/
    @EJB
    ContactFacade contactFacade;
    public void insertContaceData(){
        for(int i=1;i<200;i++){
             Contact contacts=new Contact();
             contacts.setId(Long.valueOf(i));
             contacts.setContactPhone("159002222"+i);
             contacts.setContactName(getText(2));
             contacts.setContactEmail(i+"9876544@qq.com");
             contacts.setPosition(getText(4));
             contacts.setTel("0800-900-22"+i);
             contacts.setDepartment(getText(2));
             contacts.setSex("女");
             contactFacade.create(contacts);
        }
    }
   //
    public String getText(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(seeds[random(seeds.length)]);
        }
        return sb.toString();
    }

    public int random(int scope) {
        int r = random.nextInt();
        if (r < 0) {
            r = -r;
        }
        r = r % scope;
        return r;
    }
    String[] en1 = {};
    
    
    }
