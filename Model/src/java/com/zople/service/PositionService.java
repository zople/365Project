/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service;

import com.zople.dao.PositionFacade;
import com.zople.domain.Position;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 王文彦
 */
@Stateless
public class PositionService {

    @EJB
    PositionFacade positionFacade;

    public void createPosition(Position position) {
        positionFacade.create(position);
    }

    public List<Position> findAll() {
        return positionFacade.findAll();
    }
    public Position find(Long id) {
        return positionFacade.find(id);
    }
}
