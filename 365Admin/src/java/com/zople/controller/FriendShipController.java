package com.zople.controller;

import com.zople.controller.util.JsfUtil;
import com.zople.dao.FriendlyLinkFacade;
import com.zople.domain.TblFriendlyLink;
import java.io.Serializable;
import java.util.Date;
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
    
    //String id;

    public String view() {
        String id = JsfUtil.getRequestParameter("id");
        tblFriendlyLink = friendlyLinkFacade.find(Long.parseLong(id));
        return "view.xhtml";
    }

    public String toCreate() {
        return "create.xhtml";
    }

    public String create() {
        tblFriendlyLinks = getTblFriendlyLinks();
        if (tblFriendlyLinks != null) {
            tblFriendlyLink.setId(null);
        }
        tblFriendlyLink.setCreateTime(new Date());
        friendlyLinkFacade.create(tblFriendlyLink);
        return "list.xhtml";
    }

    public String toEdit() {
        String id = JsfUtil.getRequestParameter("id");
        tblFriendlyLink = friendlyLinkFacade.find(Long.parseLong(id));
        return "edit.xhtml";
    }

    public String edit() {
        String id = JsfUtil.getRequestParameter("id");
        tblFriendlyLink.setId(Long.parseLong(id));
        tblFriendlyLink.setCreateTime(new Date());
        friendlyLinkFacade.edit(tblFriendlyLink);
        return "list.xhtml";
    }

    public String delete() {
        String id = JsfUtil.getRequestParameter("id");
        friendlyLinkFacade.remove(friendlyLinkFacade.find(Long.parseLong(id)));
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
