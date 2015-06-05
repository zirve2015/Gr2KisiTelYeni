/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2kisitelyeni.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tr.gov.ptt.gr2kisitelyeni.entity.Giris;

/**
 *
 * @author Administrator
 */
@Stateless
public class GirisFacade extends AbstractFacade<Giris> {
    @PersistenceContext(unitName = "tr.gov.ptt_Gr2KisiTelYeni_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GirisFacade() {
        super(Giris.class);
    }
    
    public boolean girisKontrol(Giris p_giris)
    {
        try{
        Query q=em.createNamedQuery("Giris.girisKontrol");
        q.setParameter("ad", p_giris.getAd());
        q.setParameter("sifre", p_giris.getSifre());
        Giris g=(Giris)q.getSingleResult();
        if(g!=null)
        {
            return true;
        }else{
            return false;
        }
        }
        catch(NoResultException nre)
        {
            return false;
        }
    }
    
    
}
