/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.common.ui;

import com.framework.common.domain.Usuario;
import com.framework.common.service.security.MyAuthenticationManagerImpl;
import com.quasar.frameq.util.DateUtil;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configurable
public class Main extends CustomComponent {

  public static final String NAME = ""; // primera pantalla
  private Window windows;
  private TabBuilder tabBuilder;
  private int lastIdOpcionModulo=0;
  int control=0;
  String nombre="";
  
  MyAuthenticationManagerImpl im = new MyAuthenticationManagerImpl();
  

//  public Main() {
//      
//  }

  @Override
  public void attach() {
    super.attach();
  }

  public int  getLastIdOpcionModulo() {
      return this.lastIdOpcionModulo;
  }
  public void setLastIdOpcionModulo(int item) {
      this.lastIdOpcionModulo=item;
  }

   // @Override
    //public void enter(ViewChangeListener.ViewChangeEvent event) {
  public Main(Window window){
        //To change body of generated methods, choose Tools | Templates.
         VaadinSession.getCurrent().setAttribute("entro",1);
         
        ServletRequestAttributes attri = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest reqi = attri.getRequest();
        HttpSession sessioni = reqi.getSession();
        try{
            control= (Integer)sessioni.getAttribute("entro");
        }catch(NullPointerException ex){
            control=0;
        }
        
        if(control==1) {            
            
            this.windows = new Window();
            CustomLayout content = new CustomLayout("main");
            final Usuario usuario = im.getUsuarioAutenticado();
            // panel
           // Panel panel = new Panel();
            // panel.setSizeFull();
            
            VerticalLayout vl = new VerticalLayout();
            VerticalLayout tabContainer = new VerticalLayout();          
            
           
            tabContainer.setStyleName("maincontent");
            tabBuilder = new TabBuilder(windows, this);
            tabContainer.addComponent(tabBuilder);
                  
            //panel.setContent(tabContainer);
            
            
            Label bienvenida= new Label("Bienvenido: "+usuario.getNombreCompleto()+"");
            bienvenida.addStyleName("labelestilo");
            
            String fecha ="";
            try{
               fecha = DateUtil.formatAsHumanFull(usuario.getUltimoLogin());
            }catch(NullPointerException ex){
               fecha="";
            }
            
            Label ultima= new Label("Ultima Conexión: "+fecha+"");
            ultima.addStyleName("labelestilo");

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest req = attr.getRequest();
            HttpSession session = req.getSession();
            
       

            String ipv= (String) session.getAttribute("ip");
            
            VaadinSession.getCurrent().setAttribute("idUsu",usuario.getId());

            Label ip = new Label("IP: "+ipv+"");
            ip.addStyleName("labelestilo");
           // Label Emision = new Label("Emisión: "); 
           // Emision.addStyleName("labelestilo");
           // Label fase = new Label("Fase: "); 
           // fase.addStyleName("labelestilo");

            Label central = new Label("Sistema Electrónico de Ofertas \n"
                    + "Públicas de Adquisición y/o Intercambio");
            central.addStyleName("labelcentral");

            vl.addComponents(bienvenida,ultima,ip);

            content.setStyleName("principal");
            content.addComponent(new Label("&nbsp;"), "animation");
            content.addComponent(central, "central");
            content.addComponent(vl, "usuario");           
            content.addComponent(tabContainer, "maincontent");
            //content.addComponent(panel, "maincontent");
            
            setImmediate(true);
            setCompositionRoot(content);
            VaadinSession.getCurrent().setAttribute("entro",0);
        }
        else {
            Notification.show("No Puede Entrar");
            Page.getCurrent().setLocation("/opa/start/login");
        }
    }
}