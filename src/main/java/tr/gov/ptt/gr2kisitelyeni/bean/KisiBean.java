/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2kisitelyeni.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import tr.gov.ptt.gr2kisitelyeni.entity.Kisi;
import tr.gov.ptt.gr2kisitelyeni.entity.Telefon;
import tr.gov.ptt.gr2kisitelyeni.service.KisiService;
import tr.gov.ptt.gr2kisitelyeni.util.JSFUtil;

/**
 *
 * @author Administrator
 */
@ManagedBean
@RequestScoped
public class KisiBean {

    private Kisi kisi;
    private Telefon evTel;
    private Telefon cepTel;
    private List<Kisi> kisiListe;

    @EJB
    private KisiService kisiService;

    public KisiBean() {

        kisi = new Kisi();
        evTel = new Telefon();
        cepTel = new Telefon();
        kisiListe=new ArrayList<Kisi>();
    }

    public List<Kisi> getKisiListe() {
        
        kisiListe=kisiService.kisiListele();
        
        return kisiListe;
    }

    public void setKisiListe(List<Kisi> kisiListe) {
        this.kisiListe = kisiListe;
    }
    
    

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    public Telefon getEvTel() {
        return evTel;
    }

    public void setEvTel(Telefon evTel) {
        this.evTel = evTel;
    }

    public Telefon getCepTel() {
        return cepTel;
    }

    public void setCepTel(Telefon cepTel) {
        this.cepTel = cepTel;
    }

    public String kisiEkle() {
        List<Telefon> telList = new ArrayList();
        telList.add(evTel);
        telList.add(cepTel);

        kisi.setTelefonList(telList);
        evTel.setKisi(kisi);
        cepTel.setKisi(kisi);

        kisiService.kisiEkle(kisi);

        JSFUtil.mesajEkle("Kişi eklendi:",kisi.getNo()+"nolu kişi eklendi.");
        return "KisiListele.xhtml?faces-redirect=true";

    }
    public String listele()
    {
       return "KisiListele.xhtml?faces-redirect=true"; 
    }
    
    public List<String> textTamamla(String sorgu){
        kisiListe= kisiService.kisiListele();
        List<String> sonuclar = new ArrayList<String>();
        for(Kisi kisi: kisiListe){
            if(kisi.getAd().toUpperCase().contains(sorgu.toUpperCase())){
                sonuclar.add(kisi.getAd());
            }
        }
        return sonuclar;
    }
    

}
