/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service;

import com.zople.dao.EnMoneyFacade;
import com.zople.domain.EnMoney;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author wangxiu
 */
@Stateless
@LocalBean
public class Money {
     
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    EnMoneyFacade moneyFacade;
    private EnMoney money;
    Random random = new Random(30);
    String[] seeds={"天","天","开","心","百","事","可","乐","风","日","和","里","万","事","大","吉","World","非","莽","哈","非","拟","呵","晚","胡","反","笔","记","本","完","材","型","王","星","被","北","京","飞","牛","人","完","碗","次","俺","金","华","永","康","启","东","余","姚","丹","阳","模","具","黄","岩","余","姚","溪","宁","波","密","封","件","嘉","善","宁","波","刀","具","阳","江","大","足","杭","州","临","沂"};
    public void add(){
         for (int i = 0; i < 200; i++) {
            money = new EnMoney();
            money.setId(Long.valueOf(i));
            money.setName(getText(50));
            money.setMoney(Integer.valueOf(i+100));
            moneyFacade.create(money);
        }
    }
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
