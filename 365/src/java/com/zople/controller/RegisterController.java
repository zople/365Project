package com.zople.controller;

import com.zople.service.UserService;
import com.zople.domain.User;
import com.zople.domain.UserType;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author 王文彦
 */
@Named(value = "registerController")
@RequestScoped
public class RegisterController {

    private User user = new User();
    @EJB
    UserService userService;

    public RegisterController() {
        user.setUserType(UserType.ENTERPRISE);
    }

    public String register() {
        userService.createUser(user);

        return "";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public void validateLoginName(FacesContext facesContext,UIComponent c,Object value){
       System.out.println(value);
    }

    public SelectItem[] getUserTypeValues() {
        SelectItem[] items = new SelectItem[UserType.values().length];
        int i = 0;
        for (UserType userType : UserType.values()) {
            items[i++] = new SelectItem(userType, userType.getName());
        }
        return items;
    }
}
