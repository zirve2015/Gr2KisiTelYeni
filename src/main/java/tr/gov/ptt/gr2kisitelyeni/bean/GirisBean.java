/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2kisitelyeni.bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import tr.gov.ptt.gr2kisitelyeni.entity.Giris;
import tr.gov.ptt.gr2kisitelyeni.service.GirisService;
import tr.gov.ptt.gr2kisitelyeni.util.JSFUtil;

/**
 *
 * @author Administrator
 */
@ManagedBean
@RequestScoped
public class GirisBean {
    
   private Giris giris;
   
   @EJB
   private GirisService girisService;

    public GirisBean() {
        giris = new Giris();
    }

    public Giris getGiris() {
        return giris;
    }

    public void setGiris(Giris giris) {
        this.giris = giris;
    }
    
    public String girisKontrol()
    {
       boolean sonuc = girisService.girisKontrol(giris);
       
       if(sonuc){
         
           HttpSession session = JSFUtil.getSession();
           session.setAttribute("username",giris.getAd());
           
           System.out.println(session.getId() +"nolu session başladı##################");
           
           JSFUtil.mesajEkle("Session basladi", session.getId()+"nolu session basladi");
           return "menu.xhtml?faces-redirect=true";
       }else
       {
           JSFUtil.hataMEssajiEkle("Yanlis Giris:", "Kullanıcı adi ya da sifre hatali");
           return "giris.xhtml";
       }
    }
    public String guvenliCikis(){
        HttpSession session = JSFUtil.getSession();
        System.out.println(session.getId()+"nolu session sonlandırılıyor*********************");
        
        JSFUtil.mesajEkle("Session sonlandırıldı.", session.getId()+" nolu Session sonlandırıldı.");
        JSFUtil.sessionBitir();
        return "giris.xhtml?faces-redirect=true";
    }
}
