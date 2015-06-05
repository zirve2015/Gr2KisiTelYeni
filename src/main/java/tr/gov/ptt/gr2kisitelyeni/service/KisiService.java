/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2kisitelyeni.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.gr2kisitelyeni.entity.Kisi;
import tr.gov.ptt.gr2kisitelyeni.facade.KisiFacade;

/**
 *
 * @author Administrator
 */
@Stateless
public class KisiService {
    
    @EJB
    private KisiFacade kisiFacade;
    
    public void kisiEkle(Kisi p_kisi)
    {
        kisiFacade.create(p_kisi);
    }
    
    public List<Kisi> kisiListele(){
        
        return kisiFacade.siraliListele();
    
    }
    
}
