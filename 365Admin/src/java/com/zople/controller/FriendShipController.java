package com.zople.controller;

import com.zople.controller.util.JsfUtil;
import com.zople.dao.FriendlyLinkFacade;
import com.zople.domain.TblFriendlyLink;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author 王文彦
 */
@Named("friendShipController")
@SessionScoped
public class FriendShipController implements Serializable {

    @EJB
    private FriendlyLinkFacade friendlyLinkFacade;
    private List<TblFriendlyLink> tblFriendlyLinks;
    private TblFriendlyLink tblFriendlyLink = new TblFriendlyLink();

    public String view() {
        String id = JsfUtil.getRequestParameter("id");
        tblFriendlyLink = friendlyLinkFacade.find(id);
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
        friendlyLinkFacade.remove(tblFriendlyLink);
        return "list.xhtml";
    }
////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<TblFriendlyLink> getTblFriendlyLinks() {
        tblFriendlyLinks = friendlyLinkFacade.findAll();
        return tblFriendlyLinks;
    }

    public void setTblFriendlyLinks(List<TblFriendlyLink> tblFriendlyLinks) {
        this.tblFriendlyLinks = tblFriendlyLinks;
    }

    public TblFriendlyLink getTblFriendlyLink() {
        return tblFriendlyLink;
    }

    public void setTblFriendlyLink(TblFriendlyLink tblFriendlyLink) {
        this.tblFriendlyLink = tblFriendlyLink;
    }
}
