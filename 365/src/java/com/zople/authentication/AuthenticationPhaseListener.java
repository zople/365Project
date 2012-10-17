package com.zople.authentication;

import com.zople.common.SessionUserHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationPhaseListener implements PhaseListener {
       
    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext context = event.getFacesContext();
       
        if (userExists()) {
            // allow processing of the requested view
            return;
        } else {            
            if (requestingSecureView(context)) {
                try {
                    HttpServletResponse response=(HttpServletResponse)context.getExternalContext().getResponse();
                    response.sendRedirect("/365/faces/pages/login/login.xhtml");
//                    context.responseComplete();              
//                    context.getApplication().
//                            getNavigationHandler().handleNavigation(context, 
//                                                                    null,
//                                                                    "/pages/login/login.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(AuthenticationPhaseListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {        
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
 
    /*判断用户是否已经存在*/
    private boolean userExists() {
        SessionUser user=SessionUserHelper.getSessionUser();
        System.out.print(user);
        return user==null?false:true;
    }
    
    private boolean requestingSecureView(FacesContext context) {
        List<String> unSecure=new ArrayList<String>();
        unSecure.add("/pages/login/login.xhtml");
        unSecure.add("/addData.xhtml");
        unSecure.add("/insertData.xhtml");
        unSecure.add("/index.xhtml");
        ExternalContext extContext = context.getExternalContext();       
        String path = extContext.getRequestPathInfo();
        System.out.println(path);
        return !unSecure.contains(path);              
    }
}
