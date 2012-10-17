package com.zople.authentication;

import com.zople.common.SessionUserHelper;
import java.io.IOException;
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
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        FacesContext context = event.getFacesContext();
        if (!userExists()) {
            if (requestingSecureView(context)) {
                try {
                    HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
                    response.sendRedirect("/365/faces/pages/login/login.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(AuthenticationPhaseListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

    /*判断用户是否已经存在*/
    private boolean userExists() {
        SessionUser user = SessionUserHelper.getSessionUser();
        System.out.print(user);
        return user == null ? false : true;
    }

    private boolean requestingSecureView(FacesContext context) {
        ExternalContext extContext = context.getExternalContext();
        String path = extContext.getRequestPathInfo();
        System.out.println(path);
        return !"/pages/login/login.xhtml".equals(path);
    }
}
