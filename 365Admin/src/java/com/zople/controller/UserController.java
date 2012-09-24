package com.zople.controller;

import com.zople.controller.util.JsfUtil;
import com.zople.domain.User;
import com.zople.service.UserService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author 王文彦
 */
@Named("userController")
@SessionScoped
public class UserController implements Serializable {

    @EJB
    private UserService userService;
    
    private List<User> users;
    private User user=new User();
    
    public String view() {
        String id = JsfUtil.getRequestParameter("id");
        user = userService.findUser(id);
        return "view.xhtml";
    }

//    public String toCreate() {
//        return "create.xhtml";
//    }
    
//    public String create() {
//        userService.createUser(user);
//        return "list.xhtml";
//    }

//    public String toEdit() {
//        return "edit.xhtml";
//    }

    public String delete() {
        String id = JsfUtil.getRequestParameter("id");
        userService.removeUser(id);
        return "list.xhtml";
    }
////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<User> getUsers() {
        users = userService.findAll();
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
