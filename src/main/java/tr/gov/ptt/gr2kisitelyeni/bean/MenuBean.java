
package tr.gov.ptt.gr2kisitelyeni.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.*;

@ManagedBean
@SessionScoped
public class MenuBean {
    
    private MenuModel menuModel;

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    public MenuBean() {
        menuModel = new DefaultMenuModel();
        initMenu();
    }

    public void initMenu(){
        
        DefaultSubMenu kisiSub = new DefaultSubMenu("Kisi İslemleri");
        DefaultSubMenu girisCikisSub = new DefaultSubMenu("Giris-Cikis İslemleri");
        
        DefaultMenuItem menuItem = new DefaultMenuItem();
        menuItem.setValue("Kisi Ekle");
        menuItem.setUrl("kisiEkle.xhtml?faces-redirect=true");
        kisiSub.addElement(menuItem);
        
        menuItem = new DefaultMenuItem();
        menuItem.setValue("Kisi Listele");
        menuItem.setCommand("#{kisiBean.listele()}");
        kisiSub.addElement(menuItem);
        
        menuItem = new DefaultMenuItem();
        menuItem.setValue("Kisi Ara");
        menuItem.setUrl("kisiAra.xhtml?faces-redirect=true");
        kisiSub.addElement(menuItem);
        
        menuItem = new DefaultMenuItem();
        menuItem.setValue("Giris");
        menuItem.setUrl("giris.xhtml?faces-redirect=true");
        girisCikisSub.addElement(menuItem);
        
        menuItem = new DefaultMenuItem();
        menuItem.setValue("Cikis");
        menuItem.setCommand("#{kisiBean}.guvenliCikis()");
        girisCikisSub.addElement(menuItem);
        
        menuModel.addElement(kisiSub);
        menuModel.addElement(girisCikisSub);
    }

   
}
