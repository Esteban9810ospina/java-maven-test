/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.contents;

import com.framework.common.domain.UsuarioReporte;
import com.framework.common.service.security.MyUserDetailsService;
import com.framework.common.ui.GenericContent;
import com.framework.common.ui.GenericTab;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.jensjansson.pagedtable.PagedTable;
import com.vaadin.data.Item;

public class ReporteUsuario extends GenericContent {

    PagedTable tabla;
    IndexedContainer ic;

    private Button btlimpiar = new Button();
    private Button btbuscar = new Button();
    private Button btExportar = new Button();
    private TextField txtnombres;
    private TextField txtapellidos;
    private TextField txtusuario;
    private TextField txtscbEntidad;

    VerticalLayout verticallayoutTotal = new VerticalLayout(); 

    @Autowired
    private MyUserDetailsService userDetailsService;

    public ReporteUsuario(GenericTab parentTab) {
        super(parentTab);
    }

    public VerticalLayout filtros() {
        VerticalLayout DF = new VerticalLayout();
        Panel panel = new Panel("Astronomer Panel");

        panel.setContent(DF);
        setContent(panel);
        return DF;
    }

    @Override
    public void initForm() {

        final Panel panel = new Panel();
        final Panel panelgrilla = new Panel();
        final Panel panelPaginacion = new Panel();

        final GridLayout gridpanel = new GridLayout(8, 8);
        final GridLayout gridbotones = new GridLayout(1, 1);
        final GridLayout gridgrilla = new GridLayout(1, 1);

        final VerticalLayout verticallayoutpanel = new VerticalLayout();

        gridpanel.setSizeFull();
        gridpanel.setSpacing(true);
        gridgrilla.setSizeFull();
        panelgrilla.setSizeFull();
        panelPaginacion.setSizeFull();
        panelgrilla.setWidth(100, Sizeable.Unit.PERCENTAGE);
        panelPaginacion.setWidth(100, Sizeable.Unit.PERCENTAGE);
        verticallayoutTotal.setSizeFull();
        verticallayoutTotal.setWidth(100, Sizeable.Unit.PERCENTAGE);
        gridbotones.setWidth(500, Sizeable.Unit.PIXELS);
        gridbotones.setHeight(50, Sizeable.Unit.PIXELS);

        //**********************************************
        //NOMBRE
        //**********************************************               
        Label lbnombres = new Label("Nombres");
        gridpanel.addComponent(lbnombres, 0, 0);
        gridpanel.setComponentAlignment(lbnombres, Alignment.MIDDLE_RIGHT);
        this.txtnombres = new TextField();
        gridpanel.addComponent(txtnombres, 2, 0);
        gridpanel.setComponentAlignment(txtnombres, Alignment.MIDDLE_LEFT);

        //**********************************************
        //APELLIDO
        //**********************************************               
        Label lbapellidos = new Label("Apellidos");
        gridpanel.addComponent(lbapellidos, 4, 0);
        gridpanel.setComponentAlignment(lbapellidos, Alignment.MIDDLE_RIGHT);
        this.txtapellidos = new TextField();
        gridpanel.addComponent(txtapellidos, 6, 0);
        gridpanel.setComponentAlignment(txtapellidos, Alignment.MIDDLE_LEFT);

        //**********************************************
        //USUARIO
        //**********************************************               
        Label lbusuario = new Label("Usuario");
        gridpanel.addComponent(lbusuario, 0, 2);
        gridpanel.setComponentAlignment(lbusuario, Alignment.MIDDLE_RIGHT);
        this.txtusuario = new TextField();
        gridpanel.addComponent(txtusuario, 2, 2);
        gridpanel.setComponentAlignment(txtusuario, Alignment.MIDDLE_LEFT);

        //**********************************************
        //SCB/ENTIDAD
        //**********************************************               
        Label lbscbEntidad = new Label("SCB/Entidad");
        gridpanel.addComponent(lbscbEntidad, 4, 2);
        gridpanel.setComponentAlignment(lbscbEntidad, Alignment.MIDDLE_RIGHT);
        this.txtscbEntidad = new TextField();
        gridpanel.addComponent(txtscbEntidad, 6, 2);
        gridpanel.setComponentAlignment(txtscbEntidad, Alignment.MIDDLE_LEFT);

        HorizontalLayout HL = new HorizontalLayout();

        //**********************************************
        //BOTON BUSCAR
        //**********************************************
        btbuscar = new Button("Filtrar");
        btbuscar.addStyleName("height: 37px; top: 110px; width: 2000px; left: 60px");
        btbuscar.addClickListener(new Button.ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(ClickEvent event) {
                filtrarTabla();
            }
        });
        HL.setSpacing(true);
        HL.addComponent(btbuscar);
        
        //**********************************************
        //BOTON LIMPIAR
        //**********************************************
        btlimpiar = new Button("Limpiar");
        btlimpiar.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                limpiarCampos();
            }
        });
        
        HL.setSpacing(true);
        HL.addComponent(btlimpiar);

        //**********************************************
        //BOTON EXPORTAR
        //**********************************************
        btExportar = new Button("Exportar");
        btExportar.addClickListener(new Button.ClickListener() {
            private static final long serialVersionUID = -73954695086117200L;
            private ExcelExport excelExport;

            @Override
            public void buttonClick(final ClickEvent event) {

                excelExport = new ExcelExport(tabla);
                excelExport.excludeCollapsedColumns();
                excelExport.setReportTitle("REPORTE DE USUARIOS");
                excelExport.setDisplayTotals(false);
                excelExport.convertTable();
                excelExport.sendConverted();
                

            }
        });
        
        HL.setSpacing(true);
        HL.addComponent(btExportar);

        //gridpanel.addComponent(HL);
        gridpanel.addComponent(HL, 0, 4, 6, 4);
        gridpanel.setComponentAlignment(HL, Alignment.BOTTOM_CENTER);

        //***************************************************
        //Tabla
        //*****************************************************
        ic = new IndexedContainer();
        ic.addContainerProperty("Nombres", String.class, null);
        ic.addContainerProperty("Apellidos", String.class, null);
        ic.addContainerProperty("SCB/Entidad", String.class, null);
        ic.addContainerProperty("Usuario", String.class, null);
        ic.addContainerProperty("Perfil", String.class, null);
        ic.addContainerProperty("Estado", String.class, null);
        ic.addContainerProperty("Email", String.class, null);
        ic.addContainerProperty("Telefono", String.class, null);

        tabla = new PagedTableCustomscb("");

        cargarTabla(null, null, null, null);

        tabla.setSizeFull();
        tabla.setColumnReorderingAllowed(false);
        tabla.setFooterVisible(true);

        //********************************************** 
        //COMPONENTES DE LOS OBJETOSS
        //**********************************************
        verticallayoutpanel.addComponent(gridpanel);
        verticallayoutpanel.setComponentAlignment(gridpanel, Alignment.TOP_CENTER);
        panel.setContent(verticallayoutpanel);
        panelPaginacion.setContent(tabla.createControls());
        panelgrilla.setContent(tabla);
        verticallayoutTotal.setSpacing(true);
        verticallayoutTotal.addComponent(panel);
        verticallayoutTotal.addComponent(panelgrilla);
        verticallayoutTotal.addComponent(panelPaginacion);
        addComponent(verticallayoutTotal);
    }

    public void limpiarCampos() {

        Button boton = new Button();
        boton.setStyleName("CssBoton");
        tabla.setVisible(true);
        tabla.getContainerDataSource().removeAllItems();
        
        txtnombres.setValue("");
        txtapellidos.setValue("");
        txtusuario.setValue("");
        txtscbEntidad.setValue("");
        
        cargarTabla(null, null, null, null); 

    }

    public void filtrarTabla() {

        Button boton = new Button();
        boton.setStyleName("CssBoton");
        this.tabla.setVisible(true);
        this.tabla.getContainerDataSource().removeAllItems();
        cargarTabla(txtnombres.getValue(), txtapellidos.getValue(), txtusuario.getValue(), txtscbEntidad.getValue());

    }

    private void cargarTabla(String nombre, String apellido, String login, String scb) {

        List<UsuarioReporte> listaUsuarios = this.userDetailsService.findUsuariosReporte(nombre, apellido, login, scb);

        int cont = 0;

        if (!listaUsuarios.isEmpty()) {
            
            for (UsuarioReporte usuario : listaUsuarios) {
                Item item = this.ic.addItem(cont);
                item.getItemProperty("Nombres").setValue(usuario.getNombres());
                item.getItemProperty("Apellidos").setValue(usuario.getApellidos());
                item.getItemProperty("SCB/Entidad").setValue(usuario.getScb());
                item.getItemProperty("Usuario").setValue(usuario.getUsername());
                item.getItemProperty("Perfil").setValue(usuario.getPerfil());
                item.getItemProperty("Estado").setValue((usuario.getEstado() == null) ? "" : (usuario.getEstado().equalsIgnoreCase("A") ? "Activo" : (usuario.getEstado().equalsIgnoreCase("I") ? "Inactivo" : (usuario.getEstado().equalsIgnoreCase("B") ? "Bloqueado" : (usuario.getEstado().equalsIgnoreCase("E") ? "Eliminado" : "")))));
                item.getItemProperty("Email").setValue(usuario.getEmail());
                item.getItemProperty("Telefono").setValue(usuario.getTelefono());
        
                cont++;
            }
        }

        tabla.setContainerDataSource(ic);
        tabla.setImmediate(true);
    }

}