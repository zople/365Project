/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller;

import com.zople.service.PositionService;
import com.zople.controller.util.JsfUtil;
import com.zople.domain.Position;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author think
 */
@Named(value = "positionController")
@RequestScoped
public class PositionController implements Serializable {

    @EJB
    PositionService positionService;
    List<Position> positions;
    Position position;
    Long id=1l;

    public List<Position> getPositions() {
        positions = positionService.findAll();
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public Position getPosition() {
        position = positionService.find(id);
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String verify() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        id = Long.parseLong(request.getParameter("id"));
        // Long.parseLong(JsfUtil.getRequestParameter("pid")); 
        position = positionService.find(id);
        return "/pages/recruitment/positionMessage.xhtml";
    }
}
