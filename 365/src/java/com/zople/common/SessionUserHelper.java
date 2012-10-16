/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.common;

import com.zople.authentication.SessionUser;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 王文彦
 */
public class SessionUserHelper {

    public static final String USER_SESSION_KEY = "USER_SESSION_KEY";

    public SessionUser getSessionUser() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session == null) {
            return null;
        }
        return (SessionUser) session.getAttribute(USER_SESSION_KEY);
    }
}
