/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service;

import com.zople.dao.UserFacade;
import com.zople.domain.User;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 王文彦
 */
@Stateless
public class UserService {

    @EJB
    UserFacade userFacade;

    public void createUser(User user) {
        userFacade.create(user);
    }

    public boolean existLoginName(User user) {
        return userFacade.findByLoginName(user.getLoginName()) == null ? false : true;
    }

    public boolean existEmail(User user) {
        return userFacade.findByLoginName(user.getEmail()) == null ? false : true;
    }

    //查询所有用户
    public List<User> findAll() {
        return userFacade.findAll();
    }

    //查询单个用户
    public User findUser(String id) {
        return userFacade.find(Long.valueOf(id));
    }

    //删除用户
    public void removeUser(String id) {
        userFacade.remove(findUser(id));
    }
    
    //修改用户
    public void editUser(User user) {
        userFacade.edit(user);
    }
}



