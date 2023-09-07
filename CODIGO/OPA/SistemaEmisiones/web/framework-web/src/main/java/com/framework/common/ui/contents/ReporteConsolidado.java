/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.contents;

import com.framework.common.domain.Perfil;
import com.framework.common.service.security.MyUserDetailsService;
import com.framework.common.ui.GenericContent;
import com.framework.common.ui.GenericTab;
import com.framework.common.ui.Main;
import com.framework.common.ui.util.AppConstants;
import com.framework.common.ui.util.ValidarCampos;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.dialogs.ConfirmDialog;
import com.jensjansson.pagedtable.PagedTable;
import com.quasar.frameq.fachadas.FacadeParametros;
import com.quasar.frameq.fachadas.FacadeUsuarios;
import com.framework.common.ui.contents.ExcelExport;
import com.vaadin.data.Item;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.ListIterator;
import com.quasar.frameq.db.Facade;

/**
 *
 * @author jam
 */
public class ReporteConsolidado extends GenericContent {

    PagedTable tabla;
    IndexedContainer ic;
    Button Botditar = null;
    private Main main;
    private Button BtnEditar;

    private Button btlimpiar = new Button();
    private Button btbuscar = new Button();
    private Button btExportar = new Button();
//    private TextField txtnumAceptacion = new TextField();
    private TextField txtidTabla = new TextField();
    private PopupDateField datef_fechaInicioOperacion = new PopupDateField();
    private PopupDateField datef_fechaFinOperacion = new PopupDateField();

    VerticalLayout verticallayoutTotal = new VerticalLayout();

    Facade facade = new Facade();
    ValidarCampos validacion = new ValidarCampos();
    FacadeParametros parametros = new FacadeParametros();
    FacadeUsuarios facadeusaurios = new FacadeUsuarios();
    String horario = validacion.fechaIngresoSinHora();

    String pattern = "###,###,###,###,###,###";
    final DecimalFormat form2 = new DecimalFormat("###,###.00");
    final DecimalFormat form4 = new DecimalFormat("###,###.0000");
    final DecimalFormat form3 = new DecimalFormat(pattern);
    final DecimalFormat form = new DecimalFormat("###,###");

    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    Collection<Perfil> perfiles = myUserDetailsService.findPerfilesOpcionesModuloUsuarioAutenticado();

    String condicion;
    List<String> parametrosList;
    String tipoOfertaPublica;
    String muestraDireccion;
    
    int idesfila = 0;
    int select = 0;

    String numAcep = "";
    String FechAcep = "";
    String todoNada = "";
    String Acciones = "";
    String clasAcc = "";
    String ConsOft = "";
    String preacu = "";
    String NomApelli = "";
    String numDoc = "";
    String cuenInv = "";
    String espFidu = "";
    String nombRep = "";

    String fechaInicio = "";
    String fechaFin = "";
    String numAceptacion = "";
    String porcentaje = "";
    String idAceptacion = "";
    String totalAccion = "";
    String PerfilActual = "";

    Double totalMonto = 0.0;
    Double totalAcciones = 0.0;
    Double totalAcci = 0.0;

    public ReporteConsolidado(GenericTab parentTab) {
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

        int hayParametrizacion = facade.validaHayParametros();

        if (hayParametrizacion == 1) {
            parametrosList = facade.RetornaParametros();
            condicion = parametrosList.get(38);
            tipoOfertaPublica = parametrosList.get(41);
            muestraDireccion = parametrosList.get(43);
        } else {
            throw new RuntimeException("No se ha realizado ninguna parametrización");
        }

        PerfilActual = facade.RetornaPerfil(userDetailsService.getUsuarioAutenticado().getId());

        List perfiles = userDetailsService.getUsuarioAutenticado().getAuthorities();
        Perfil miperfil = null;
        ListIterator a = perfiles.listIterator();
        while (a.hasNext()) {
            miperfil = (Perfil) a.next();
        }

        if (!horario.equals("") && ((miperfil.getId().intValue() == 4 || miperfil.getId().intValue() == 1))) {
            ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
            cd.setWidth("400px");
            cd.setHeight("160px");
            HorizontalLayout texto = new HorizontalLayout();
            HorizontalLayout buttons = new HorizontalLayout();
            buttons.setStyleName("btnAceptar");
            Label lblmensaje = new Label(horario, ContentMode.HTML);
            texto.addComponent(lblmensaje);
            buttons.addComponent(cd.getOkButton());
            VerticalLayout content = new VerticalLayout(lblmensaje, buttons);
            content.setStyleName("verticalDialog");
            content.setSizeFull();
            content.setSpacing(true);
            cd.setContent(content);
            cd.show(UI.getCurrent(), new ConfirmDialog.Listener() {
                @Override
                public void onClose(ConfirmDialog cd) {

                }
            }, true);

        } else {

            final Panel panel = new Panel();
            final Panel panelgrilla = new Panel();
            final Panel panelPaginacion = new Panel();

            final GridLayout gridpanel = new GridLayout(4, 4);
            final GridLayout gridbotones = new GridLayout(1, 1);
            final GridLayout gridgrilla = new GridLayout(1, 1);

            final VerticalLayout verticallayoutpanel = new VerticalLayout();

            gridpanel.setSizeFull();
            //gridpanel.setHeight(165, Sizeable.Unit.PIXELS);
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
            //Número de Aceptacón
            //**********************************************
//        Label lbnumAceptacion = new Label("Número de Aceptación");
//        gridpanel.addComponent(lbnumAceptacion, 0, 0);
//        gridpanel.setComponentAlignment(lbnumAceptacion, Alignment.MIDDLE_RIGHT);
//        txtnumAceptacion = new TextField();
//        gridpanel.addComponent(txtnumAceptacion, 1, 0);
//        gridpanel.setComponentAlignment(txtnumAceptacion, Alignment.MIDDLE_LEFT);
            //**********************************************
            //Fecha Inicio Operación
            //**********************************************               
            Label lbfechInOperacion = new Label("Fecha Inicio Radicación");
            gridpanel.addComponent(lbfechInOperacion, 0, 0);
            gridpanel.setComponentAlignment(lbfechInOperacion, Alignment.MIDDLE_CENTER);
            datef_fechaInicioOperacion = new PopupDateField();
            datef_fechaInicioOperacion.setDateFormat("dd/MM/yyyy");
            datef_fechaInicioOperacion.setTextFieldEnabled(false);
            gridpanel.addComponent(datef_fechaInicioOperacion, 1, 0);
            gridpanel.setComponentAlignment(datef_fechaInicioOperacion, Alignment.MIDDLE_CENTER);
            datef_fechaInicioOperacion.setWidth(240, Sizeable.Unit.PIXELS);

            //
            //**********************************************
            //Fecha Fin Operación
            //**********************************************               
            Label lbfechFinOperacion = new Label("Fecha Fin Radicación");
            gridpanel.addComponent(lbfechFinOperacion, 2, 0);
            gridpanel.setComponentAlignment(lbfechFinOperacion, Alignment.MIDDLE_CENTER);
            datef_fechaFinOperacion = new PopupDateField();
            datef_fechaFinOperacion.setDateFormat("dd/MM/yyyy");
            datef_fechaFinOperacion.setTextFieldEnabled(false);
            gridpanel.addComponent(datef_fechaFinOperacion, 3, 0);
            gridpanel.setComponentAlignment(datef_fechaFinOperacion, Alignment.MIDDLE_CENTER);
            datef_fechaFinOperacion.setWidth(240, Sizeable.Unit.PIXELS);
            HorizontalLayout HL = new HorizontalLayout();

            //**********************************************
            //BOTON BUSCAR
            //**********************************************
            btbuscar = new Button("Filtrar");
            btbuscar.addClickListener(new Button.ClickListener() {
                private static final long serialVersionUID = 1L;

                public void buttonClick(ClickEvent event) {
                    filtrarTabla();
                }
            });
            HL.setSpacing(true);
            HL.addComponent(btbuscar);
//        gridpanel.addComponent(btbuscar, 0, 2, 1, 2);
//        gridpanel.setComponentAlignment(btbuscar, Alignment.BOTTOM_RIGHT);

            //**********************************************
            //BOTON LIMPIAR
            //**********************************************
            btlimpiar = new Button("Limpiar");
            btlimpiar.addClickListener(new Button.ClickListener() {
                public void buttonClick(ClickEvent event) {
                    limpiarCampos();
                    cargarTabla();
                    tabla.setVisible(true);
                }
            });
            HL.addComponent(btlimpiar);
//        gridpanel.addComponent(btlimpiar, 2, 2, 3, 2);
//        gridpanel.setComponentAlignment(btlimpiar, Alignment.BOTTOM_LEFT);

            //**********************************************
            //BOTON EXPORTAR
            //**********************************************
            btExportar = new Button("Exportar");
            btExportar.addClickListener(new Button.ClickListener() {
                private static final long serialVersionUID = -73954695086117200L;
                private ExcelExport excelExport;

                public void buttonClick(final ClickEvent event) {
                    Date dNow = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
                    int countRepor = 0;
                    String Fechahoy = ft.format(dNow);
                    int idUsuario = userDetailsService.getUsuarioAutenticado().getId();
                    int cantReport = parametros.ValidarCantidadReportes();
                    countRepor = facadeusaurios.CantReportesExportados(idUsuario, Fechahoy);
                    String PerfilActual = "";
                    PerfilActual = facade.RetornaPerfil(userDetailsService.getUsuarioAutenticado().getId());
                    if (PerfilActual.equals("Administrador SCB") || (PerfilActual.equals("Operador SCB"))) {
                        if (countRepor == 0) {
                            String resultado = facadeusaurios.IngresarExpReport(1, idUsuario, Fechahoy);
                            excelExport = new ExcelExport(tabla);
                            excelExport.excludeCollapsedColumns();
                            excelExport.setReportTitle("REPORTE CONSOLIDADO DE ACEPTACIONES \n Este reporte corresponde a una copia no controlada");
                            excelExport.setDisplayTotals(true);
                            excelExport.convertTable();
                            excelExport.getTotalsRow().getCell(18).setCellValue(form.format(totalAcci));
                            excelExport.getTotalsRow().getCell(19).setCellValue(form2.format(totalMonto));
                            excelExport.sendConverted();
                        } else if (cantReport <= countRepor) {
                            Notification.show("Usted ha alcanzado la cantidad límite de reportes descargados",
                                    Notification.Type.WARNING_MESSAGE);
                        } else {
                            facadeusaurios.Actualizartablareportes(idUsuario, Fechahoy);
                            excelExport = new ExcelExport(tabla);
                            excelExport.excludeCollapsedColumns();
                            excelExport.setReportTitle("REPORTE CONSOLIDADO DE ACEPTACIONES \n Este reporte corresponde a una copia no controlada");
                            excelExport.setDisplayTotals(true);
                            //excelExport.setUseTableFormatPropertyValue(true);
                            excelExport.convertTable();
                            excelExport.getTotalsRow().getCell(18).setCellValue(form.format(totalAcci));
                            excelExport.getTotalsRow().getCell(19).setCellValue(form2.format(totalMonto));
                            excelExport.sendConverted();
                            //excelExport.export();                           
                        }

                    } else {

                        excelExport = new ExcelExport(tabla);
                        excelExport.excludeCollapsedColumns();
                        excelExport.setReportTitle("REPORTE CONSOLIDADO DE ACEPTACIONES \n Este reporte corresponde a una copia no controlada");
                        excelExport.setDisplayTotals(true);
                        excelExport.convertTable();
                        excelExport.getTotalsRow().getCell(18).setCellValue(form.format(totalAcci));
                        excelExport.getTotalsRow().getCell(19).setCellValue(form2.format(totalMonto));
                        excelExport.sendConverted();

                    }

                }
            });
            HL.addComponent(btExportar);

            gridpanel.addComponent(HL, 0, 2, 3, 2);
            gridpanel.setComponentAlignment(HL, Alignment.BOTTOM_CENTER);

            //***************************************************
            //Tabla
            //*****************************************************
            ic = new IndexedContainer();

            ic.addContainerProperty("N° de Aceptación", Integer.class, null);
            ic.addContainerProperty("Nemotécnico", String.class, null);
            ic.addContainerProperty("Fecha de Aceptación", String.class, null);
            ic.addContainerProperty("Hora de Aceptación", String.class, null);
            ic.addContainerProperty("Nombre de usuario operador SCB/Entidad", String.class, null);
            ic.addContainerProperty("Clase de Acciones", String.class, null);
            ic.addContainerProperty("Consecutivo Oferta de Venta", String.class, null);
            ic.addContainerProperty("Nombre de la SCB/Entidad", String.class, null);
            ic.addContainerProperty("Código de la SCB/Entidad", String.class, null);
            ic.addContainerProperty("Existe Preacuerdo", String.class, null);
            ic.addContainerProperty("Nombre del Representante Legal de la SCB", String.class, null);
            //ic.addContainerProperty("Nombres", String.class, null);
            ic.addContainerProperty(AppConstants.COL_NOMBRE_RAZON, String.class, null);
            ic.addContainerProperty("Tipo de Documento", String.class, null);
            ic.addContainerProperty("Número de Documento", String.class, null);
            ic.addContainerProperty("Dígito de Verificación", String.class, null);
            ic.addContainerProperty("Especial Fiduciario", String.class, null);
            ic.addContainerProperty("Cuenta Inversionista", String.class, null);
            ic.addContainerProperty("Se Vende con Condición Todo o Nada", String.class, null);
            ic.addContainerProperty("No. de Acciones que Acepto Vender", String.class, null);

            if (tipoOfertaPublica.equals("OPA")) {
                ic.addContainerProperty("Monto Solicitado", String.class, null);
                ic.addContainerProperty("Precio", String.class, null);
            } else {
                ic.addContainerProperty("Monto total de acciones que acepto vender", String.class, null);
                ic.addContainerProperty("Precio acciones a vender", String.class, null);
                ic.addContainerProperty("Porcentaje para pago en Efectivo", String.class, null);
            }

            ic.addContainerProperty("Porcentaje de Comisión", String.class, null);
            //muestraDireccion
            if (muestraDireccion.equals("1")) {
                ic.addContainerProperty("Dirección", String.class, null);
            }
            ic.addContainerProperty("Estado", String.class, null);
            ic.addContainerProperty("Observaciones", String.class, null);

            if (tipoOfertaPublica.equals("OPI")) {
                //condiciones sandia
                ic.addContainerProperty("Condiciones", String.class, null);
            }

            tabla = new PagedTableCustomscb("");
            cargarTabla();

            if (tipoOfertaPublica.equals("OPI")) {
                tabla.setColumnAlignment("Se Vende con Condición Todo o Nada", Table.Align.RIGHT);
            }
            tabla.setContainerDataSource(ic);
            tabla.setColumnAlignment("No. de Acciones que Acepto Vender", Table.Align.RIGHT);
            if (tipoOfertaPublica.equals("OPA")) {
                tabla.setColumnAlignment("Monto Solicitado", Table.Align.RIGHT);
                tabla.setColumnAlignment("Precio", Table.Align.RIGHT);
            } else {
                tabla.setColumnAlignment("Monto total de acciones que acepto vender", Table.Align.RIGHT);
            }

            tabla.setSizeFull();
            tabla.setColumnReorderingAllowed(false);
            tabla.setFooterVisible(true);

            //tabla.setHeight(345, Sizeable.Unit.PIXELS);
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
    }

    public void limpiarCampos() {
        datef_fechaInicioOperacion.setValue(null);
        datef_fechaFinOperacion.setValue(null);
        datef_fechaFinOperacion.setRequired(false);
        datef_fechaInicioOperacion.setRequired(false);
        datef_fechaFinOperacion.setRequired(false);
    }

    public void filtrarTabla() {
        String tfNumAceptaciones = "";
        String reformattedIni = "";
        String reformattedFin = "";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date Fecha1 = null;
        Date Fecha2 = null;


        try {
            reformattedFin = df.format(datef_fechaFinOperacion.getValue());

        } catch (Exception e) {
            reformattedFin = "";

        }
        //Fecha fin operacion 
        try {
            reformattedIni = df.format(datef_fechaInicioOperacion.getValue());
        } catch (Exception e) {
            reformattedIni = "";
        }

        try {
            Fecha1 = df.parse(reformattedIni);

        } catch (Exception e) {
            reformattedIni = "";
        }

        try {
            Fecha2 = df.parse(reformattedFin);

        } catch (Exception e) {
            reformattedFin = "";
        }

        if (reformattedIni.equals("") && reformattedFin.equals("")) {
            Notification.show("Por favor filtrar por un campo",
                    Notification.Type.ERROR_MESSAGE);
            tabla.setVisible(true);
        } else {
            if ((reformattedIni.equals(""))) {
                datef_fechaInicioOperacion.setRequired(true);
                datef_fechaInicioOperacion.setRequiredError("Debe seleccionar la Fecha Inicio de Radicación");
                Notification.show("Debe seleccionar la Fecha Inicio de Radicación",
                        Notification.Type.ERROR_MESSAGE);
                tabla.setVisible(true);

            } else {
                if ((reformattedFin.equals(""))) {
                    datef_fechaFinOperacion.setRequired(true);
                    datef_fechaFinOperacion.setRequiredError("Debe seleccionar la Fecha Fin de Radicación");
                    Notification.show("Debe seleccionar la Fecha Fin de Radicación",
                            Notification.Type.ERROR_MESSAGE);
                    tabla.setVisible(true);

                } else {
                    if (Fecha2.before(Fecha1)) {
                        Notification.show("La fecha inicial debe ser menor o igual a la fecha final",
                                Notification.Type.ERROR_MESSAGE);
                    } else {
                        datef_fechaFinOperacion.setRequired(false);
                        Button boton = new Button();
                        boton.setStyleName("CssBoton");

                        tabla.setVisible(true);

                        tabla.getContainerDataSource().removeAllItems();
                        String idUsuario = userDetailsService.getUsuarioAutenticado().getId().toString();
                        int i;
                        List<List<String>> listAceptaciones;

                        List perfiles = userDetailsService.getUsuarioAutenticado().getAuthorities();
                        Perfil miperfil = null;
                        ListIterator a = perfiles.listIterator();
                        while (a.hasNext()) {
                            miperfil = (Perfil) a.next();
                        }

                        listAceptaciones = facade.ListarDemandasReporteConsolidado(idUsuario, reformattedIni, reformattedFin, miperfil.getId(), userDetailsService.getUsuarioAutenticado().getSbolsa());

                        totalMonto = 0.0;
                        totalAcciones = 0.0;
                        for (i = 0; i < listAceptaciones.get(0).size(); i++) {
                            //Preacuerdo 1 Si - 2 No
                            String nomPreacuerdo = "";
                            nomPreacuerdo = listAceptaciones.get(5).get(i);

                            if (nomPreacuerdo == null) {
                                nomPreacuerdo = "";
                            } else if (nomPreacuerdo.equals("1")) {
                                nomPreacuerdo = "Si";
                            } else if (nomPreacuerdo.equals("2")) {
                                nomPreacuerdo = "No";
                            }

                            //Se vende con condición todo o nada
                            String nomConTodoNada = "";
                            nomConTodoNada = listAceptaciones.get(10).get(i);

                            if (nomConTodoNada == null) {
                                nomConTodoNada = "";
                            } else if (nomConTodoNada.equals("1")) {
                                nomConTodoNada = "Si";
                            } else if (nomConTodoNada.equals("0") || nomConTodoNada.equals("2")) {
                                nomConTodoNada = "No";
                            }

                            //Digito de verificación
                            String digVerificacion = "";
                            digVerificacion = listAceptaciones.get(13).get(i);

                            if (digVerificacion == null) {
                                digVerificacion = "";
                            } else {
                                digVerificacion = listAceptaciones.get(13).get(i);
                            }

                            Item item = ic.addItem(i);
                            item.getItemProperty("N° de Aceptación").setValue(Integer.valueOf(listAceptaciones.get(0).get(i)));
                            item.getItemProperty("Nemotécnico").setValue(listAceptaciones.get(21).get(i));
                            item.getItemProperty("Fecha de Aceptación").setValue(listAceptaciones.get(17).get(i));
                            item.getItemProperty("Hora de Aceptación").setValue(listAceptaciones.get(18).get(i));
                            item.getItemProperty("Nombre de usuario operador SCB/Entidad").setValue(listAceptaciones.get(22).get(i));
                            item.getItemProperty("Clase de Acciones").setValue(listAceptaciones.get(1).get(i));
                            item.getItemProperty("Consecutivo Oferta de Venta").setValue(listAceptaciones.get(2).get(i));
                            item.getItemProperty("Nombre de la SCB/Entidad").setValue(listAceptaciones.get(23).get(i));
                            item.getItemProperty("Código de la SCB/Entidad").setValue(listAceptaciones.get(30).get(i));
                            item.getItemProperty("Existe Preacuerdo").setValue(nomPreacuerdo);
                            item.getItemProperty("Nombre del Representante Legal de la SCB").setValue(listAceptaciones.get(25).get(i));
                            //item.getItemProperty("Nombres").setValue(listAceptaciones.get(32).get(i));
                            item.getItemProperty(AppConstants.COL_NOMBRE_RAZON).setValue(listAceptaciones.get(31).get(i));
                            item.getItemProperty("Tipo de Documento").setValue(listAceptaciones.get(11).get(i));
                            item.getItemProperty("Número de Documento").setValue(listAceptaciones.get(12).get(i));
                            item.getItemProperty("Dígito de Verificación").setValue(digVerificacion);
                            item.getItemProperty("Especial Fiduciario").setValue(listAceptaciones.get(14).get(i));
                            item.getItemProperty("Cuenta Inversionista").setValue(listAceptaciones.get(15).get(i));
                            item.getItemProperty("Se Vende con Condición Todo o Nada").setValue(nomConTodoNada);
                            
                            if (muestraDireccion.equals("1")) {
                                item.getItemProperty("Dirección").setValue(listAceptaciones.get(33).get(i));
                            }
                            
                            if (tipoOfertaPublica.equals("OPI")) {
                                item.getItemProperty("Porcentaje para pago en Efectivo").setValue(listAceptaciones.get(32).get(i).concat("%"));
                            }
                            item.getItemProperty("No. de Acciones que Acepto Vender").setValue(form3.format(Double.valueOf(listAceptaciones.get(9).get(i))));

                            if (tipoOfertaPublica.equals("OPI")) {
                                item.getItemProperty("Monto total de acciones que acepto vender").setValue(("$").concat(form2.format(Double.valueOf(listAceptaciones.get(26).get(i)))));
                                item.getItemProperty("Precio acciones a vender").setValue(form2.format(Double.valueOf(listAceptaciones.get(27).get(i))));
                            } else {
                                item.getItemProperty("Monto Solicitado").setValue(form2.format(Double.valueOf(listAceptaciones.get(26).get(i))));
                                item.getItemProperty("Precio").setValue(form4.format(Double.valueOf(listAceptaciones.get(27).get(i))));
                            }

                            if (listAceptaciones.get(29).get(i) == null || (listAceptaciones.get(29).get(i).equals("0,000")) || (listAceptaciones.get(29).get(i).equals(""))) {
                                item.getItemProperty("Porcentaje de Comisión").setValue(porcentaje);
                            } else {
                                item.getItemProperty("Porcentaje de Comisión").setValue((listAceptaciones.get(29).get(i)).concat("%"));
                            }
                            item.getItemProperty("Estado").setValue(listAceptaciones.get(20).get(i));
                            item.getItemProperty("Observaciones").setValue(listAceptaciones.get(28).get(i));
                            //totalAcciones+=Double.parseDouble(listAceptaciones.get(10).get(i));
                            //totalMonto+=Double.parseDouble(listAceptaciones.get(27).get(i)); 
                            //Lsierra 2016-04-08 Mantis 2511
                            if (tipoOfertaPublica.equals("OPI")) {
                                //Condiciones sandia
                                item.getItemProperty("Condiciones").setValue(condicion);
                            }

                        }
                        String listaTotales = (facade.Totales(idUsuario, miperfil.getId(), userDetailsService.getUsuarioAutenticado().getSbolsa(), reformattedIni, reformattedFin));

                        String[] list = listaTotales.split(";");
                        String totalSumMonto = list[0];
                        String totalAccion = list[1];

                        totalMonto = Double.parseDouble(totalSumMonto);

                        totalAcci = Double.parseDouble(totalAccion);

                        String prueba = "Totales";
                        tabla.setColumnFooter("Se Vende con Condición Todo o Nada", String.format(prueba));
                        tabla.setColumnFooter("No. de Acciones que Acepto Vender", form.format(totalAcci));

                        if (tipoOfertaPublica.equals("OPI")) {
                            tabla.setColumnFooter("Monto total de acciones que acepto vender", ("$").concat(form2.format(totalMonto)));
                        } else {
                            tabla.setColumnFooter("Monto Solicitado", form2.format(totalMonto));
                        }
                        tabla.setColumnAlignment("Totales", Table.Align.RIGHT);
                        tabla.setColumnAlignment("No. de Acciones que Acepto Vender", Table.Align.RIGHT);

                        if (tipoOfertaPublica.equals("OPI")) {
                            tabla.setColumnAlignment("Monto total de acciones que acepto vender", Table.Align.RIGHT);
                        } else {
                            tabla.setColumnAlignment("Monto Solicitado", Table.Align.RIGHT);
                        }

                        if (listAceptaciones.get(0).size() == 0) {

                            Notification.show("No hay Aceptaciones",
                                    Notification.Type.TRAY_NOTIFICATION);
                            tabla.setVisible(false);

                        }

                        //limpiarCampos();
                        //***************************************
                        //Boton Editar Tabla
                        //****************************************   
                    }
                }
            }
        }
        tabla.setContainerDataSource(ic);
        tabla.setImmediate(true);
    }

    private void exportarTabla() {

    }

    private void cargarTabla() {

        //String tfNumAceptaciones = "";
        String reformattedIni = "";
        String reformattedFin = "";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            reformattedFin = df.format(datef_fechaFinOperacion.getValue());

        } catch (Exception e) {
            reformattedFin = "";

        }
        //Fecha fin operacion 
        try {
            reformattedIni = df.format(datef_fechaInicioOperacion.getValue());
        } catch (Exception e) {
            reformattedIni = "";
        }

        tabla.getContainerDataSource().removeAllItems();
        String idUsuario = userDetailsService.getUsuarioAutenticado().getId().toString();
        int i;
        List<List<String>> listAceptaciones;

        List perfiles = userDetailsService.getUsuarioAutenticado().getAuthorities();
        Perfil miperfil = null;
        ListIterator a = perfiles.listIterator();
        while (a.hasNext()) {
            miperfil = (Perfil) a.next();
        }

        listAceptaciones = facade.ListarDemandasReporteConsolidado(idUsuario, reformattedIni, reformattedFin, miperfil.getId(), userDetailsService.getUsuarioAutenticado().getSbolsa());

        totalMonto = 0.0;
        totalAcciones = 0.0;

        if (listAceptaciones.get(0).size() != 0) {

            for (i = 0; i < listAceptaciones.get(0).size(); i++) {
                //Preacuerdo 1 Si - 2 No
                String nomPreacuerdo = "";
                nomPreacuerdo = listAceptaciones.get(5).get(i);

                if (nomPreacuerdo == null) {
                    nomPreacuerdo = "";
                } else if (nomPreacuerdo.equals("1")) {
                    nomPreacuerdo = "Si";
                } else if (nomPreacuerdo.equals("2")) {
                    nomPreacuerdo = "No";
                }

                //Se vende con condición todo o nada
                String nomConTodoNada = "";
                nomConTodoNada = listAceptaciones.get(10).get(i);

                if (nomConTodoNada == null) {
                    nomConTodoNada = "";
                } else if (nomConTodoNada.equals("1")) {
                    nomConTodoNada = "Si";
                } else if (nomConTodoNada.equals("0") || nomConTodoNada.equals("2")) {
                    nomConTodoNada = "No";
                }

                //Digito de verificación
                String digVerificacion = "";
                digVerificacion = listAceptaciones.get(13).get(i);

                if (digVerificacion == null) {
                    digVerificacion = "";
                } else {
                    digVerificacion = listAceptaciones.get(13).get(i);
                }

                Item item = ic.addItem(i);
                item.getItemProperty("N° de Aceptación").setValue(Integer.valueOf(listAceptaciones.get(0).get(i)));
                item.getItemProperty("Nemotécnico").setValue(listAceptaciones.get(21).get(i));
                item.getItemProperty("Fecha de Aceptación").setValue(listAceptaciones.get(17).get(i));
                item.getItemProperty("Hora de Aceptación").setValue(listAceptaciones.get(18).get(i));
                item.getItemProperty("Nombre de usuario operador SCB/Entidad").setValue(listAceptaciones.get(22).get(i));
                item.getItemProperty("Clase de Acciones").setValue(listAceptaciones.get(1).get(i));
                item.getItemProperty("Consecutivo Oferta de Venta").setValue(listAceptaciones.get(2).get(i));
                item.getItemProperty("Nombre de la SCB/Entidad").setValue(listAceptaciones.get(23).get(i));
                item.getItemProperty("Código de la SCB/Entidad").setValue(listAceptaciones.get(30).get(i));
                item.getItemProperty("Existe Preacuerdo").setValue(nomPreacuerdo);
                item.getItemProperty("Nombre del Representante Legal de la SCB").setValue(listAceptaciones.get(25).get(i));
                //item.getItemProperty("Nombres").setValue(listAceptaciones.get(32).get(i));
                item.getItemProperty(AppConstants.COL_NOMBRE_RAZON).setValue(listAceptaciones.get(31).get(i));
                item.getItemProperty("Tipo de Documento").setValue(listAceptaciones.get(11).get(i));
                item.getItemProperty("Número de Documento").setValue(listAceptaciones.get(12).get(i));
                item.getItemProperty("Dígito de Verificación").setValue(digVerificacion);
                item.getItemProperty("Especial Fiduciario").setValue(listAceptaciones.get(14).get(i));
                item.getItemProperty("Cuenta Inversionista").setValue(listAceptaciones.get(15).get(i));
                item.getItemProperty("Se Vende con Condición Todo o Nada").setValue(nomConTodoNada);
                if (muestraDireccion.equals("1")) {
                    item.getItemProperty("Dirección").setValue(listAceptaciones.get(33).get(i));
                }
                if (tipoOfertaPublica.equals("OPI")) {
                    item.getItemProperty("Porcentaje para pago en Efectivo").setValue(listAceptaciones.get(32).get(i).concat("%"));
                }
                item.getItemProperty("No. de Acciones que Acepto Vender").setValue((form3.format(Double.valueOf(listAceptaciones.get(9).get(i)))));
                if (tipoOfertaPublica.equals("OPI")) {
                    item.getItemProperty("Monto total de acciones que acepto vender").setValue(("$").concat(form2.format(Double.valueOf(listAceptaciones.get(26).get(i)))));
                    item.getItemProperty("Precio acciones a vender").setValue(form2.format(Double.valueOf(listAceptaciones.get(27).get(i))));
                } else {
                    item.getItemProperty("Monto Solicitado").setValue(form2.format(Double.valueOf(listAceptaciones.get(26).get(i))));
                    item.getItemProperty("Precio").setValue(form4.format(Double.valueOf(listAceptaciones.get(27).get(i))));
                }
                // if (listAceptaciones.get(30).get(i)!=null || listAceptaciones.get(30).get(i).equals("0.000"))
                //item.getItemProperty("Porcentaje de Comisión").setValue((listAceptaciones.get(30).get(i)).concat("%"));
                if (listAceptaciones.get(29).get(i) == null || (listAceptaciones.get(29).get(i).equals("0,000")) || (listAceptaciones.get(29).get(i).equals(""))) {
                    item.getItemProperty("Porcentaje de Comisión").setValue(porcentaje);
                } else {
                    item.getItemProperty("Porcentaje de Comisión").setValue((listAceptaciones.get(29).get(i)).concat("%"));
                }
                item.getItemProperty("Estado").setValue(listAceptaciones.get(20).get(i));
                item.getItemProperty("Observaciones").setValue(listAceptaciones.get(28).get(i));
                //totalAcciones+=Double.parseDouble(listAceptaciones.get(10).get(i));
                //totalMonto+=Double.parseDouble(listAceptaciones.get(27).get(i));  
                //Lsierra 2016-04-08 Mantis 2511
                if (tipoOfertaPublica.equals("OPI")) {
                    //Condiciones sandia
                    item.getItemProperty("Condiciones").setValue(condicion);
                }
            }

            String listaTotales = (facade.Totales(idUsuario, miperfil.getId(), userDetailsService.getUsuarioAutenticado().getSbolsa(), reformattedIni, reformattedFin));

            String[] list = listaTotales.split(";");
            String totalSumMonto = list[0];
            totalAccion = list[1];

            totalMonto = Double.parseDouble(totalSumMonto);

            totalAcci = Double.parseDouble(totalAccion);
            String prueba = "Totales";
            tabla.setColumnFooter("Se Vende con Condición Todo o Nada", String.valueOf(prueba));
            tabla.setColumnFooter("No. de Acciones que Acepto Vender", form.format(totalAcci));
            if (tipoOfertaPublica.equals("OPI")) {
                tabla.setColumnFooter("Monto total de acciones que acepto vender", ("$").concat(form2.format(totalMonto)));
            } else {
                tabla.setColumnFooter("Monto Solicitado", form2.format(totalMonto));
            }
            tabla.setColumnAlignment("Totales", Table.Align.RIGHT);
            tabla.setColumnAlignment("No. de Acciones que Acepto Vender", Table.Align.RIGHT);
            if (tipoOfertaPublica.equals("OPI")) {
                tabla.setColumnAlignment("Monto total de acciones que acepto vender", Table.Align.RIGHT);
            } else {
                tabla.setColumnAlignment("Monto Solicitado", Table.Align.RIGHT);
            }
        }
        tabla.setContainerDataSource(ic);
        tabla.setImmediate(true);
    }

}
