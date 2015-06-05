/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2kisitelyeni.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.gr2kisitelyeni.entity.Giris;
import tr.gov.ptt.gr2kisitelyeni.facade.GirisFacade;

/**
 *
 * @author Administrator
 */
@Stateless
public class GirisService {
    
    @EJB
    public GirisFacade girisFacade;
    
    public boolean girisKontrol(Giris p_giris)
    {
     boolean sonuc = girisFacade.girisKontrol(p_giris);
     return sonuc;
    }
    
}
