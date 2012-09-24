/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.dao;

import com.zople.domain.TblFriendlyLink;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 王文彦
 */
@Stateless
public class FriendlyLinkFacade extends AbstractFacade<TblFriendlyLink> {
    @PersistenceContext(unitName = "365PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FriendlyLinkFacade() {
        super(TblFriendlyLink.class);
    }
    
}
