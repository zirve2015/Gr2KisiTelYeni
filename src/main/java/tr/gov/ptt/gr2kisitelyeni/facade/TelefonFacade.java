/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2kisitelyeni.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.gr2kisitelyeni.entity.Telefon;

/**
 *
 * @author Administrator
 */
@Stateless
public class TelefonFacade extends AbstractFacade<Telefon> {
    @PersistenceContext(unitName = "tr.gov.ptt_Gr2KisiTelYeni_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TelefonFacade() {
        super(Telefon.class);
    }
    
}
