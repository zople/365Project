/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller.converter;

import com.zople.domain.UserType;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author 王文彦
 */
@FacesConverter(forClass = UserType.class,value="com.zople.domain.UserType")
public class UserTypeConverter implements Converter {
    public UserTypeConverter(){
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int userType = Integer.valueOf(value);
        return UserType.valueOf(userType);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
}
