package com.framework.reportEngine;

//import com.bvc.martillo.common.service.MartilloDetailsService;
import com.quasar.frameq.db.DbUtil;
import com.quasar.frameq.db.Persistente;
import com.quasar.frameq.parametros.Parametro;
import com.quasar.frameq.util.DateUtil;
import com.framework.common.service.Auditoria;
import com.framework.common.ui.App;
import static com.framework.common.ui.util.ApplicationHolder.getApplication;
import static com.framework.reportEngine.config.Constantes.*;
import com.framework.reportEngine.formatter.CampoFormatter;
import com.framework.reportEngine.formatter.DefaultCampoFormatter;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * Clase principal para la visualizacion de mantenedores param茅tricos
 *
 * @author pedrorozo
 *
 */
@SuppressWarnings("serial,rawtypes")
@Configurable(preConstruction = true)                                       //linea nueva
public class JFormMD extends CustomComponent implements Button.ClickListener {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    // propiedades genericas para todas las formas
    private int colsGrilla;   //SMJ2
    private CustomLayout cLayout = new CustomLayout("forma2");
    private VerticalLayout layMaster = new VerticalLayout();
    private VerticalLayout layDetalle = new VerticalLayout();
    private HorizontalLayout barraBotones = new HorizontalLayout();
    private HorizontalLayout barraBotonesDetalle = new HorizontalLayout();
    private GrillaService grilla;
    private GrillaService grillaDetalle;
    private TextField registroIr = new TextField();
    private Form iFormaMaestro;
    private Form iFormaDetalle;
    private Button botonConsultar = new Button();
    private Button botonPrimero = new Button();
    private Button botonAnterior = new Button();
    private Button botonSiguiente = new Button();
    private Button botonUltimo = new Button();
    private Button botonAgregar = new Button();
    private Button botonEditar = new Button();
    private Button botonEliminar = new Button();
    private Button botonImprimir = new Button();
    private Button botonDeshacer = new Button();
    private Button botonGuardar = new Button();
    private Vector VRegistro = new Vector();
    private GeneraForma mForma = new GeneraForma();
//  private boolean enFormaEdicion = false;
    private boolean enFormaEdicionDetalle = false;
    private boolean agregando = false;
    // para pantalla de detalle
    private Button botonConsultarD = new Button();
    private Button botonAgregarD = new Button();
    private Button botonEditarD = new Button();
    private Button botonEliminarD = new Button();
    private Button botonImprimirD = new Button();
    private Button botonDeshacerD = new Button();
    private Button botonGuardarD = new Button();
    private Vector VRegistroD = new Vector();
    private GeneraForma mFormaD = new GeneraForma();
    private boolean agregandoDetalle = false;
    private GeneraForma mFormaDetalle = new GeneraForma();
    private Label lIra = new Label(TOOLTIP_IR);              // esta forma de detalle tiene menos botones y funcionalidad
    private Button botonIr = new Button();
    private Label lRactual = new Label(TOOLTIP_RACTUAL);
    private Label rActual = new Label("");
    private Label lRactualD = new Label(TOOLTIP_RACTUALD);
    private Label rActualD = new Label("");
    private ConfirmDialog dialog;
    // Seccion especifica para esta entidad                                        // Plantilla a personalizar - JSP
    private Persistente tabla;
    private Persistente tablaDetalle;
    //  ***************************  Datos de configuracion basica de la JSP ORIGEN  *********************************+
    private String tituloMaestro;
    private String misAlias[];
    private Map<String, CampoFormatter> aliasFormatters;
    private String misTipos[];
    private int miPresentacion[];
    private int longitudMaestro[];
    private int requerido[];
    private String tituloDetalle;
    private String aliasDetalle[];
    private String tiposDetalle[];
    private int presentacionDetalle[];
    private int longitudDetalle[];
    private int requeridoDetalle[];    /// insertado no presenta antes
    private int pa = 0;
    private String par;
    private int res = 0;
    // Variables auxiliares
    int tipo;
    int tipoR;
    //2015-05-27 lsierra
    int edit = 0;
    String forma = new String("");
    //-------------- Declaracion de llaves -----------
    private Vector llaveMaestro;   //Declaraci贸n Vector de elementos de la llave maestro
    private Vector llaveDetalle;   //Declaraci贸n Vector de elementos de la llave detalle
    //---------- Declaraci贸n de Combos ----------
    private Vector combosMaestro;   //Declaraci贸n Vector de elementos combo maestro
    private Vector tiposCombosMaestro;   //Declaraci贸n Vector de tipos de combo maestro
    private Vector valorCombosMaestro;    //Declaraci贸n Vector de valores de combo maestro Si es cadena
    private Vector combosDetalle;   //Declaraci贸n Vector de elementos combo detalle
    private Vector tiposCombosDetalle;   //Declaraci贸n Vector de tipos de combo detalle
    private Vector valorCombosDetalle;   //Declaraci贸n Vector de valores de combo detalle Si es cadena
    //---------- Declaraci贸n de RadioButton --------
    private Vector radioMaestro;   //Declaraci贸n Vector de elementos radio maestro
    private Vector tiposRadioMaestro;   //Declaraci贸n Vector de tipos de radio maestro
    private Vector radioDetalle;   //Declaraci贸n Vector de elementos radios detalle
    private Vector tiposRadioDetalle;   //Declaraci贸n Vector de tipos de radio detalle
    //Campos para manejar presentacion en pantalla de relaciones
    private boolean showColumnsListaBD = false;
    private boolean showColumnsListaFija = false;
    private boolean showColumnsListaBDDetalle = false;
    private boolean showColumnsListaFijaDetalle = false;

    private boolean query = false;
    private String queryvariante = "";

    private boolean defaultvalues = false;
    private String valores[];

    private boolean defaultvaluesDetalle = false;
    private String valoresDetalle[];


    boolean vuelta = false;

    Integer martilloActual;


    public static int conmod = 0;

    public void setDefaultvalues(boolean a) {
        this.defaultvalues = a;
    }

    public void setValores(String[] a) {
        this.valores = a;
    }

    public void setDefaultvaluesDetalle(boolean a) {
        this.defaultvaluesDetalle = a;
    }

    public void setValoresDetalle(String[] a) {
        this.valoresDetalle = a;
    }

    public String getQueryvariante() {
        return queryvariante;
    }

    public void setQueryvariante(String queryvariante) {
        this.queryvariante = queryvariante;
    }

    public boolean isQuery() {
        return query;
    }

    public void setQuery(boolean query) {
        this.query = query;
    }

    /* ****  Fin de declaraciones basicas- importadas desde la JSP  *********************************/
    public JFormMD() {
        // inicializaBasicos();
        App.setDefaultLocale();
        setCompositionRoot(cLayout);
        //this.cLayout = cLayout;
        barraBotones.setSpacing(true);
        //barraBotones.setMargin(false, true, false, false);
        botonConsultar.addListener(this);
        botonConsultar.setStyleName(BaseTheme.BUTTON_LINK);
        botonConsultar.setIcon(ICONO_CONSULTAR);
        botonConsultar.setDescription(TOOLTIP_CONSULTAR);
        barraBotones.addComponent(botonConsultar);

        botonPrimero.addListener(this);
        botonPrimero.setStyleName(BaseTheme.BUTTON_LINK);
        botonPrimero.setIcon(ICONO_PRIMERO);
        botonPrimero.setDescription(TOOLTIP_PRIMERO);
        barraBotones.addComponent(botonPrimero);

        botonAnterior.addListener(this);
        botonAnterior.setStyleName(BaseTheme.BUTTON_LINK);
        botonAnterior.setIcon(ICONO_ANTERIOR);
        botonAnterior.setDescription(TOOLTIP_ANTERIOR);
        barraBotones.addComponent(botonAnterior);

        botonSiguiente.addListener(this);
        botonSiguiente.setStyleName(BaseTheme.BUTTON_LINK);
        botonSiguiente.setIcon(ICONO_SIGUIENTE);
        botonSiguiente.setDescription(TOOLTIP_SIGUIENTE);
        barraBotones.addComponent(botonSiguiente);

        botonUltimo.addListener(this);
        botonUltimo.setStyleName(BaseTheme.BUTTON_LINK);
        botonUltimo.setIcon(ICONO_ULTIMO);
        botonUltimo.setDescription(TOOLTIP_ULTIMO);
        barraBotones.addComponent(botonUltimo);

        botonAgregar.addListener(this);
        botonAgregar.setStyleName(BaseTheme.BUTTON_LINK);
        botonAgregar.setIcon(ICONO_AGREGAR);
        botonAgregar.setDescription(TOOLTIP_AGREGAR);
        barraBotones.addComponent(botonAgregar);

        botonEditar.addListener(this);
        botonEditar.setStyleName(BaseTheme.BUTTON_LINK);
        botonEditar.setIcon(ICONO_EDITAR);
        botonEditar.setDescription(TOOLTIP_EDITAR);
        barraBotones.addComponent(botonEditar);

        botonEliminar.addListener(this);
        botonEliminar.setStyleName(BaseTheme.BUTTON_LINK);
        botonEliminar.setIcon(ICONO_ELIMINAR);
        botonEliminar.setDescription(TOOLTIP_ELIMINAR);
        barraBotones.addComponent(botonEliminar);

        botonImprimir.addListener(this);
        botonImprimir.setStyleName(BaseTheme.BUTTON_LINK);
        botonImprimir.setIcon(ICONO_IMPRIMIR);
        botonImprimir.setDescription(TOOLTIP_IMPRIMIR);
        barraBotones.addComponent(botonImprimir);

        botonDeshacer.addListener(this);
        botonDeshacer.setStyleName(BaseTheme.BUTTON_LINK);
        botonDeshacer.setIcon(ICONO_DESHACER);
        botonDeshacer.setDescription(TOOLTIP_DESHACER);
        barraBotones.addComponent(botonDeshacer);

        botonGuardar.addListener(this);
        botonGuardar.setStyleName(BaseTheme.BUTTON_LINK);
        botonGuardar.setIcon(ICONO_GUARDAR);
        botonGuardar.setDescription(TOOLTIP_GUARDAR);
        barraBotones.addComponent(botonGuardar);
        // deja estos botones deshabilitados por defecto
        botonConsultar.setVisible(false);
        botonImprimir.setVisible(false);
        botonDeshacer.setVisible(false);
        botonGuardar.setVisible(false);

        barraBotones.addComponent(lIra);

        registroIr.setMaxLength(6);
        registroIr.setWidth(40, UNITS_PIXELS);
        barraBotones.addComponent(registroIr);

        botonIr.addListener(this);
        botonIr.setStyleName(BaseTheme.BUTTON_LINK);
        botonIr.setIcon(ICONO_IR);
        botonIr.setDescription(TOOLTIP_IR);
        barraBotones.addComponent(botonIr);

        barraBotones.addComponent(lRactual);
        barraBotones.addComponent(rActual);
        cLayout.addComponent(barraBotones, "barraBotones");

        layMaster.setStyleName("ctabla");  		// layout contenedor para tabla de datos Web 2.0
        cLayout.addComponent(layMaster, "tabla1");
    }

    @Override
    // ejecutado siempre antes del rendering - por en tiempo de contruccion no siempre se conoce el objeto app y derivados (windows)
    public void attach() {
        //  super.attach(); // Must call.
        logger.debug("OPA - " + " ************ JFormFD attach - GetWindow en attach  =");

        grilla(); 		// grilla de navegacion
        posicionaGrilla(grilla, 1);  		// deja seleccionado el primer registro por defecto
        iniciaDetalle();
    }

    /**
     * Logica de inicializacion de grilla y botones para forma de detalle
     */
    private void iniciaDetalle() {
        barraBotonesDetalle.setSpacing(true);
        //barraBotonesDetalle.setMargin(false, true, false, false);

        botonConsultarD.addListener(this);
        botonConsultarD.setStyleName(BaseTheme.BUTTON_LINK);
        botonConsultarD.setIcon(ICONO_CONSULTAR);
        botonConsultarD.setDescription(TOOLTIP_CONSULTARD);
        barraBotonesDetalle.addComponent(botonConsultarD);

        botonAgregarD.addListener(this);
        botonAgregarD.setStyleName(BaseTheme.BUTTON_LINK);
        botonAgregarD.setIcon(ICONO_AGREGAR);
        botonAgregarD.setDescription(TOOLTIP_AGREGARD);
        barraBotonesDetalle.addComponent(botonAgregarD);

        botonEditarD.addListener(this);
        botonEditarD.setStyleName(BaseTheme.BUTTON_LINK);
        botonEditarD.setIcon(ICONO_EDITAR);
        botonEditarD.setDescription(TOOLTIP_EDITARD);
        barraBotonesDetalle.addComponent(botonEditarD);

        botonEliminarD.addListener(this);
        botonEliminarD.setStyleName(BaseTheme.BUTTON_LINK);
        botonEliminarD.setIcon(ICONO_ELIMINAR);
        botonEliminarD.setDescription(TOOLTIP_ELIMINARD);
        barraBotonesDetalle.addComponent(botonEliminarD);

        botonDeshacerD.addListener(this);
        botonDeshacerD.setStyleName(BaseTheme.BUTTON_LINK);
        botonDeshacerD.setIcon(ICONO_DESHACER);
        botonDeshacerD.setDescription(TOOLTIP_DESHACERD);
        barraBotonesDetalle.addComponent(botonDeshacerD);

        botonGuardarD.addListener(this);
        botonGuardarD.setStyleName(BaseTheme.BUTTON_LINK);
        botonGuardarD.setIcon(ICONO_GUARDAR);
        botonGuardarD.setDescription(TOOLTIP_GUARDARD);
        barraBotonesDetalle.addComponent(botonGuardarD);
        // deja estos botones deshabilitados por defecto
        botonConsultarD.setVisible(false);
        botonDeshacerD.setVisible(false);
        botonGuardarD.setVisible(false);

        barraBotonesDetalle.addComponent(lRactualD);     // barra de botones de la forma de detalle - oculta por defecto
        barraBotonesDetalle.addComponent(rActualD);
        cLayout.addComponent(barraBotonesDetalle, "barraBotonesDetalle");
        barraBotonesDetalle.setVisible(false);
        //layDetalle.setStyleName("ctabla");  		// layout contenedor para tabla de datos Web 2.0 - detalle pro defecto oculto
        layDetalle.setVisible(false);
        cLayout.addComponent(layDetalle, "tabla2");
    }

    @Override
    /**
     * Procesa todos los eventos de la barra de botones
     */
    public void buttonClick(ClickEvent event) {
        int actualMaestro = 0;
        try {

            if (((Integer) grilla.getTable().getContainerDataSource().size()).intValue() > 0) {
                actualMaestro = getActual(grilla);
            } else {
                actualMaestro = 0;
            }
        } catch (Exception e) {
            logger.error("No se obtuvo tabla", e);
        }
        int totalMaestro = ((Integer) grilla.getTable().getContainerDataSource().size()).intValue();

        String opcion = event.getButton().getDescription();

        if (opcion.equalsIgnoreCase(TOOLTIP_PRIMERO)) {
            posicionaGrilla(grilla, 1);
        } else if (opcion.equalsIgnoreCase(TOOLTIP_ULTIMO)) {
            posicionaGrilla(grilla, totalMaestro);
        } else if (opcion.equalsIgnoreCase(TOOLTIP_SIGUIENTE)) {
            if (++actualMaestro <= totalMaestro) {
                posicionaGrilla(grilla, actualMaestro);
            }
        } else if (opcion.equalsIgnoreCase(TOOLTIP_ANTERIOR)) {
            if (--actualMaestro >= 1) {
                posicionaGrilla(grilla, actualMaestro);
            }
        } else if (opcion.equalsIgnoreCase(TOOLTIP_GUARDAR)) {
            guardarMaestro();
        } else if (opcion.equalsIgnoreCase(TOOLTIP_AGREGAR)) {
            agregarMaestro();
        } else if (opcion.equalsIgnoreCase(TOOLTIP_DESHACER)) {
            deshacerMaestro();
        } else if (opcion.equalsIgnoreCase(TOOLTIP_IMPRIMIR)) {
//            getWindow().executeJavaScript("print();");
        } else if (opcion.equalsIgnoreCase(TOOLTIP_ELIMINAR)) {
            if (totalMaestro > 0) {
                eliminaMaestro();
            }
        } else if (opcion.equalsIgnoreCase(TOOLTIP_EDITAR)) {
            if (totalMaestro > 0) {
                editarMaestro(Boolean.TRUE);
            }
        } else if (opcion.equalsIgnoreCase(TOOLTIP_CONSULTAR)) {
            consultarMaestro();
        } else if (opcion.equalsIgnoreCase(TOOLTIP_IR)) {
            int destino = Integer.parseInt((String) registroIr.getValue());
            if (destino >= 1 && destino <= totalMaestro) {
                posicionaGrilla(grilla, destino);
            }
            // Seccion de eventos para ventana de detalle
        } else if (opcion.equalsIgnoreCase(TOOLTIP_EDITARD)) {
            //2015-05-27 lsierra valida la condicion de modificar
            edit = 1;
            int totalDetalle = ((Integer) grillaDetalle.getTable().getContainerDataSource().size()).intValue();
            if (totalDetalle > 0) {
                editarDetalle(Boolean.TRUE);

            }
        } else if (opcion.equalsIgnoreCase(TOOLTIP_IMPRIMIRD)) {
//            getWindow().executeJavaScript("print();");
        } else if (opcion.equalsIgnoreCase(TOOLTIP_CONSULTARD)) {
            consultarDetalle();
        } else if (opcion.equalsIgnoreCase(TOOLTIP_ELIMINARD)) {
            int totalDetalle = ((Integer) grillaDetalle.getTable().getContainerDataSource().size()).intValue();
            if (totalDetalle > 0) {
                eliminaDetalle();
            }
        } else if (opcion.equalsIgnoreCase(TOOLTIP_AGREGARD)) {
            agregarDetalle();
        } else if (opcion.equalsIgnoreCase(TOOLTIP_DESHACERD)) {
            deshacerDetalle();
        } else if (opcion.equalsIgnoreCase(TOOLTIP_GUARDARD)) {
            guardarDetalle();
        }

        String value = String.valueOf(grilla.getTable().getValue());

        if (value == null || value.isEmpty() || "null".equalsIgnoreCase(value.trim())) {
            value = "0";
        }

        rActual.setValue(value + " de " + grilla.getTable().getContainerDataSource().size());
        grilla.getTable().requestRepaint();
    }

    /**
     * Refresca la posicion de la grilla en registro y pagina
     */
    private void posicionaGrilla(GrillaService grilla, int actual) {

        grilla.getTable().select(actual);
        grilla.getTable().setCurrentPageFirstItemIndex((actual - 1));

        String value = String.valueOf(grilla.getTable().getValue());

        if (value == null || value.isEmpty() || "null".equalsIgnoreCase(value.trim())) {
            value = "0";
        }

        rActual.setValue(value + " de " + grilla.getTable().getContainerDataSource().size());
        grilla.getTable().requestRepaint();
    }

    /**
     * Agregar registro a tabla maestra y la deja en modo de edicion
     */
    private void agregarMaestro() {
        logger.debug("OPA - " + "Clase de plantilla maestro: " + tabla.getClass().getName());
        Persistente nuevo = null;
        try {
            nuevo = tabla.getClass().newInstance();         // obtiene una instancia vacia del mismo javabean del maestro
        } catch (InstantiationException e) {
            logger.error(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
        }

        //Persistente nuevo = plantillaMaestro;  //  crea un nuevo javabena (con datos por defecto)       //********  CODIGO PLANTILLA  JSP a reemplazar con macro*********//
        agregando = true;
        posicionaGrilla(grilla, 1);
        tabla.setContenido(ajustaDatos(nuevo.getContenido(), misTipos, longitudMaestro, nuevo.getPrecision()));  //carga el javabean temporal en actual (tabla) para su edicion)      //SMJ2

        if (tabla.getNombreTabla().equals("ma_ofertas_permanentes")) {
            conmod = 0;
        }
        nuevo.cerrarConexiones();
        editarMaestro(Boolean.FALSE);
        iFormaMaestro.setReadOnly(false);
        botonDeshacer.setVisible(true);
        botonGuardar.setVisible(true);
        botonAgregar.setVisible(false);
        iFormaMaestro.requestRepaint();
        this.requestRepaintAll();
    }

    /**
     * Almacena cambios de edicion en la base de datos usando capa de
     * persistencia existente
     */
    private void guardarMaestro() {
        int actual = 0;
        try {
            if (tabla.getSize() > 0) {
                actual = Integer.parseInt(grilla.getTable().getValue().toString().replace("[", "").replace("]", ""));
            }
        } catch (Exception e) {
            logger.error("No pudo obtener la tabla", e);            
        }
        try {
            iFormaMaestro.commit();
            Iterator<?> ite = iFormaMaestro.getItemPropertyIds().iterator();
            Vector registro = new Vector();
            // Convierte fechas java.util.date a java.sql.Date - requisito para capa de persistencia
            while (ite.hasNext()) {
                Integer pro = (Integer) ite.next();
                Object oProp = iFormaMaestro.getItemProperty(pro).getValue();
                String tipoC = "";
                if (oProp != null) {
                    tipoC = oProp.getClass().getName().toString();
                }
                logger.debug("OPA - " + "GuardaCorrige:" + tipoC);
                if (!tipoC.equalsIgnoreCase("java.util.Date")) {
                    registro.add(iFormaMaestro.getItemProperty(pro).getValue());
                    logger.debug("OPA - " + "Propiedad salida:" + pro + "=" + iFormaMaestro.getItemProperty(pro).getValue() + "-tipo=" + tipoC);
                } else // es fecha corrige de formato largo en java.util.Date a java.sql.Date
                {                
                    String fechac = DateUtil.formatDateAsString((java.util.Date) iFormaMaestro.getItemProperty(pro).getValue());
                    registro.add(fechac);
                    logger.debug("OPA - " + "Propiedad salidaF:" + pro + "=" + fechac + "-tipofechaN=" + fechac.getClass().getName());
                }
            }
            tabla.setContenido(ajustaDatos(registro, misTipos, longitudMaestro, tabla.getPrecision()));
            // Validacion de datos usando logica del javabean existente  (Maestro)
            // sugerencias - revisar para enviar mensaje mas diciente.
      /*
             if( !(tabla.validaContenido(registro,misTipos , requerido) &&  Utiles.VerificaNulos(registro, requerido))) {    // datos validos para guardarse
             getWindow().showNotification(NOMBRE_APLICACION, MSGERROR_VALIDACION_MAESTRO,Notification.TYPE_ERROR_MESSAGE);
             }
             else   // datos fueron validos se procede a actualizar 贸 insertar segun sea el caso
             {
             */

            if (tabla.getNombreTabla().equalsIgnoreCase("fqs_parametro")) {
                Vector cont = new Vector();
                cont = tabla.getContenido();
                //Lsierra 2015-11-03 se comentarea el parametro con id 15007, c_valor 15, c_descripcion intentos fallidos, c_nombre autenticacionIntentosFallidosNotifica
                //Porque este parametro no se utiliza.
                //if (cont.elementAt(0).equals(15005) || cont.elementAt(0).equals(15006) || cont.elementAt(0).equals(15007) || cont.elementAt(0).equals(15008) || cont.elementAt(0).equals(15009)) {
                //if (cont.elementAt(0).equals(15005) || cont.elementAt(0).equals(15006) ||  cont.elementAt(0).equals(15008) || cont.elementAt(0).equals(15009)) {
                if (cont.elementAt(0).equals(15005) || cont.elementAt(0).equals(15006) ||  cont.elementAt(0).equals(15008)) {
                    //15005 15006 15007 15008 15009
                    Auditoria au = new Auditoria();
                    au.setid();
                    Parametro para = new Parametro();

                    para.consultaG("select * from fqs_parametro where i_parametro=?", cont.elementAt(0));
                    if (para.rs.first()) {
                        if (!para.rs.getString("c_valor").equalsIgnoreCase(cont.elementAt(2).toString())) {
                            au.setEvento("Modificaci髇 parametro " + cont.elementAt(3).toString() + " (valor): valor inicial: " + para.rs.getString("c_valor") + " valor final: " + cont.elementAt(2).toString());
                            au.setResultado("Exitoso");
                            au.inserta();
                        }

                        if (!para.rs.getString("i_tipodato").equalsIgnoreCase(cont.elementAt(1).toString())) {
                            au.setEvento("Modificaci髇 parametro " + cont.elementAt(3).toString() + " (tipo dato): valor inicial: " + para.rs.getString("i_tipodato") + " valor final: " + cont.elementAt(1).toString());
                            au.setResultado("Exitoso");
                            au.inserta();
                        }

                        if (!para.rs.getString("c_descripcion").equalsIgnoreCase(cont.elementAt(3).toString())) {
                            au.setEvento("Modificaci髇 parametro " + cont.elementAt(3).toString() + " (descripci髇): valor inicial: " + para.rs.getString("c_descripcion") + " valor final: " + cont.elementAt(3).toString());
                            au.setResultado("Exitoso");
                            au.inserta();
                        }

                        if (!para.rs.getString("c_nombre").equalsIgnoreCase(cont.elementAt(4).toString())) {
                            au.setEvento("Modificaci髇 parametro " + cont.elementAt(3).toString() + " (nombre): valor inicial: " + para.rs.getString("c_nombre") + " valor final: " + cont.elementAt(4).toString());
                            au.setResultado("Exitoso");
                            au.inserta();
                        }

                    }

                    //au.setEvento("modifica politica contrasena parametro "+cont.elementAt(3).toString()+" valor inicial:"++"  valor final: "+  cont.elementAt(2).toString());
                    //Lsierra 2015-11-03 Se comenta el codigo porque el parametro con id 10005, c_descripcion Minutos de bloqueo del sistema, c_nombre Minutos de bloqueo del sistema no tiene
                    //Funcionalidad en el proyecto
                    //} else if (cont.elementAt(0).equals(15000) || cont.elementAt(0).equals(15001) || cont.elementAt(0).equals(15002) || cont.elementAt(0).equals(10003) || cont.elementAt(0).equals(10005)) {
                    } else if (cont.elementAt(0).equals(15000) || cont.elementAt(0).equals(15001) || cont.elementAt(0).equals(15002) || cont.elementAt(0).equals(10003)) {
                    //15000 15001 15002 10003 10005
                    Auditoria au = new Auditoria();

                    Parametro para = new Parametro();
                    au.setid();
                    para.consultaG("select * from fqs_parametro where i_parametro=?", cont.elementAt(0));
                    if (para.rs.first()) {
                        if (!para.rs.getString("c_valor").equalsIgnoreCase(cont.elementAt(2).toString())) {
                            au.setEvento("Modificaci髇 par醡etro " + cont.elementAt(3).toString() + " (valor): valor inicial: " + para.rs.getString("c_valor") + " valor final: " + cont.elementAt(2).toString());
                            au.setResultado("Exitoso");
                            au.inserta();
                        }

                        if (!para.rs.getString("i_tipodato").equalsIgnoreCase(cont.elementAt(1).toString())) {
                            au.setEvento("Modificaci髇 par醡etro " + cont.elementAt(3).toString() + " (tipo dato): valor inicial: " + para.rs.getString("i_tipodato") + " valor final: " + cont.elementAt(1).toString());
                            au.setResultado("Exitoso");
                            au.inserta();
                        }

                        if (!para.rs.getString("c_descripcion").equalsIgnoreCase(cont.elementAt(3).toString())) {
                            au.setEvento("Modificaci髇 par醡etro " + cont.elementAt(3).toString() + " (descripci髇): valor inicial: " + para.rs.getString("c_descripcion") + " valor final: " + cont.elementAt(3).toString());
                            au.setResultado("Exitoso");
                            au.inserta();
                        }

                        if (!para.rs.getString("c_nombre").equalsIgnoreCase(cont.elementAt(4).toString())) {
                            au.setEvento("Modificaci髇 par醡etro " + cont.elementAt(3).toString() + " (nombre): valor inicial: " + para.rs.getString("c_nombre") + " valor final: " + cont.elementAt(4).toString());
                            au.setResultado("Exitoso");
                            au.inserta();
                        }

                        //au.setEvento("Modifica politica seguridad. Parametro "+cont.elementAt(3).toString()+" valor inicial:"+para.rs.getString("c_valor") +"  valor final: "+  cont.elementAt(2).toString());
                    }

                    //au.setEvento("modifica politica de seguridad");
                    //au.setResultado("exitoso");
                    //au.inserta();
                }
            }

            agregando = false;
            consultarMaestro();
        } catch (Exception ex) {
    
        }

        // }  //   validacion
    }

    /**
     * Cambia a modo grilla en el maestro, restaurando el estado de los botones
     */
    private void consultarMaestro() {
        agregando = false;
        int actual = getActual(grilla);
        logger.debug("OPA - " + "reg Actual al consultar :" + actual);

        if (iFormaMaestro != null) {
            iFormaMaestro.removeAllProperties();
        }

        layDetalle.setVisible(false);           //oculta panel de detalle al pasar a grilla de master
        barraBotonesDetalle.setVisible(false);

        cLayout.removeComponent(iFormaMaestro);
        cLayout.removeComponent(iFormaDetalle);
        cLayout.addComponent(layMaster, "tabla1");

        botonAgregar.setVisible(true);   		// habilita botones que no aplican
        botonPrimero.setVisible(true);
        botonSiguiente.setVisible(true);
        botonAnterior.setVisible(true);
        botonUltimo.setVisible(true);
        botonAgregar.setVisible(true);

        lIra.setVisible(true);
        registroIr.setVisible(true);
        botonIr.setVisible(true);
        lRactual.setVisible(true);

        botonConsultar.setVisible(false);  		// deshabilita botones que no aplican
        botonDeshacer.setVisible(false);
        botonGuardar.setVisible(false);

        if (iFormaMaestro != null) {
            iFormaMaestro.setReadOnly(true);
        }
        posicionaGrilla(grilla, actual);
    }

    /**
     * Crea forma de edici贸n, con los campos correspondientes al registro
     * actual
     */
    private void editarMaestro(boolean editar) {

        String[] props = tabla.getAtributos();
        String[] pk = new String[tabla.getAtributosLLave().size()];
        tabla.inicializar();
        try {
            if (!agregando) {
                int actual = getActual(grilla);
                // pk = grilla.getTable().getItem(actual).getItemProperty(props[0]).getValue().toString();  // obtiene valor de la llave primaria (siempre es el primer atributo)
                // obtiene llave maestra para luego usarse en grillaDetalle como fuente del join
                if (llaveMaestro != null) {         //SMJ2
                    for (int i = 0; i < tabla.getAtributosLLave().size(); i++) {
                        String CampoLlaveMaestra = llaveMaestro.get(i).toString();
                        if (grilla.getTable().getItem(actual).getItemProperty(CampoLlaveMaestra).getValue().toString().contains("|")) {
                            StringTokenizer a = new StringTokenizer(grilla.getTable().getItem(actual).getItemProperty(CampoLlaveMaestra).getValue().toString(), "|");
                            pk[i] = Utiles.retiraFormatoMiles(a.nextToken()); // obtiene el valor de la llave maestra
                        } else {
                            pk[i] = Utiles.retiraFormatoMiles(grilla.getTable().getItem(actual).getItemProperty(CampoLlaveMaestra).getValue().toString());
                        }

                        /* if (showColumnsListaBD) {
                         if (miPresentacion[i] == TIPOC_LISTBOX) {
                         if (((Integer) tiposCombosMaestro.get(i)) == TIPOCOMBO_SQL) {
                         String CampoLlaveMaestra = llaveMaestro.get(i).toString();
                         StringTokenizer a=new StringTokenizer(grilla.getTable().getItem(actual).getItemProperty(CampoLlaveMaestra).getValue().toString(),"|");
                         pk[i] = a.nextToken(); // obtiene el valor de la llave maestra
                                        
                         } else {
                         String CampoLlaveMaestra = llaveMaestro.get(i).toString();
                         pk[i] = grilla.getTable().getItem(actual).getItemProperty(CampoLlaveMaestra).getValue().toString(); // obtiene el valor de la llave maestra

                         }
                         } else {
                         String CampoLlaveMaestra = llaveMaestro.get(i).toString();
                         pk[i] = grilla.getTable().getItem(actual).getItemProperty(CampoLlaveMaestra).getValue().toString(); // obtiene el valor de la llave maestra

                         }

                         } else {
                         String CampoLlaveMaestra = llaveMaestro.get(i).toString();
                         pk[i] = grilla.getTable().getItem(actual).getItemProperty(CampoLlaveMaestra).getValue().toString(); // obtiene el valor de la llave maestra
                         }*/
                    }
                } else {    // es una forma sin detalle, en ese caso se asumen que el primer atributo es la llave maestra

                    for (int i = 0; i < tabla.getAtributosLLave().size(); i++) {
                        if (grilla.getTable().getItem(actual).getItemProperty(props[i]).getValue().toString().contains("|")) {
                            StringTokenizer a = new StringTokenizer(grilla.getTable().getItem(actual).getItemProperty(props[i]).getValue().toString(), "|");
                            pk[i] = Utiles.retiraFormatoMiles(a.nextToken()); // obtiene el valor de la llave maestra
                        } else {
                            pk[i] = Utiles.retiraFormatoMiles(grilla.getTable().getItem(actual).getItemProperty(props[i]).getValue().toString());
                        }

                        //pk[i] = 
                    }

                }

                logger.debug("OPA - " + "PK=" + StringUtils.arrayToDelimitedString(pk, " ") + "-actual=" + actual);

                String where = "WHERE 1=1 ";
                //Flag relaciones. Aqui si campo afectado es de la llave realizar apertura.
                for (int i = 0; i < tabla.getAtributosLLave().size(); i++) {
                    where = where + " and " + props[i] + "= ?";
                }
                tabla.consultaP(where, pk);  //obtiene todos los campos del campo seleccionado en la BD
                tabla.rs.next();                // carga datos en RS
                tabla.setContenido();                                       // tranfiere los datos del resulset a un vector
            }
            VRegistro = tabla.getContenido();
            Iterator ite = VRegistro.iterator();     
            int j = 0;
            while (ite.hasNext()) {
                logger.debug("OPA - " + "Propiedad entrada:" + props[j] + "=" + ite.next());
                j++;
            }
            cLayout.removeComponent(layMaster);                             // remueve grilla de pantalla

            iFormaMaestro = mForma.creaForma(tituloMaestro, VRegistro, misAlias, misTipos,
                    miPresentacion, longitudMaestro, requerido, combosMaestro,
                    tiposCombosMaestro, valorCombosMaestro, radioMaestro,
                    tabla.getElementosLLave(), editar, true, llaveMaestro, llaveDetalle,
                    pk, tabla.getAtributos(), tabla.getPrecision(), defaultvalues, valores);

            iFormaMaestro.setReadOnly(true);

            if (!agregando) {
                // crea y habilita la segunda grilla para detalle
                if (llaveMaestro != null) // valida si el maestro tine detalle
                {
                    grillaDetalle(pk);
                    layDetalle.setVisible(true);
                    barraBotonesDetalle.setVisible(true);
                }
            }
            cLayout.addComponent(iFormaMaestro, "tabla1");

            // oculta botones que no aplican
            botonAgregar.setVisible(false);
            botonPrimero.setVisible(false);
            botonSiguiente.setVisible(false);
            botonAnterior.setVisible(false);
            botonUltimo.setVisible(false);
            botonAgregar.setVisible(false);
            botonGuardar.setVisible(false);
            botonDeshacer.setVisible(false);

            lIra.setVisible(false);
            registroIr.setVisible(false);
            botonIr.setVisible(false);

            // habilita botones que si aplican
            botonConsultar.setVisible(true);
            botonImprimir.setVisible(true);

            iFormaMaestro.setReadOnly(false);
            botonDeshacer.setVisible(true);
            botonGuardar.setVisible(true);
            iFormaMaestro.requestRepaint();
            this.requestRepaintAll();

        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * Deshace cmabios (carga informacion anterior) en registro actual de codigo
     * maestro
     */
    public void deshacerMaestro() {
        
        dialog = new ConfirmDialog("Titulo" ,MSGCONFIRMA_TITULO, MSGDESHACER_PREGUNTA, new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                if (ConfirmDialog.BUTTON_OK_CAPTION.equals(event.getButton().getCaption())) {
                      //getWindow().showNotification(MSGEXITO_DESHACER);
                       Notification.show(MSGEXITO_DESHACER, Notification.Type.HUMANIZED_MESSAGE);
                     //getWindow().showNotification(NOMBRE_APLICACION, MSGEXITO_DESHACER);
                    //Mantis 2168 Lsierra 2015-12-16   
                    editarMaestro(Boolean.TRUE);    // recarga datos para evitar problemas de sincronizacion y deja registro en modo de lectura
                    consultarMaestro();
                } else {
                    logger.debug("OPA - " + "No desea descartar cambios del registro ");
                } // dialog
                dialog.hide();
            } // on Close
        });   // listener
        dialog.show();
    }

    /**
     * Eliminar el registro indicado por la llave primaria en la tabla actual
     *
     * @param primaryKey
     */
    public void eliminaMaestro() {
        final String[] props = tabla.getAtributos();
        final int actual = Integer.parseInt(grilla.getTable().getValue().toString().replace("[", "").replace("]", ""));

        final Object[] args = new Object[tabla.getElementosLLave()];
        final String[] pk = new String[tabla.getElementosLLave()];
        for (int i = 0; i < tabla.getElementosLLave(); i++) {
            pk[i] = Utiles.retiraFormatoMiles(grilla.getTable().getItem(actual).getItemProperty(props[i]).getValue().toString());
        }
        dialog = new ConfirmDialog("Titulo", MSGCONFIRMA_TITULO, MSGELIMINAR_PREGUNTA + " " + StringUtils.arrayToDelimitedString(pk, " "), new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                if (ConfirmDialog.BUTTON_OK_CAPTION.equals(event.getButton().getCaption())) {
                    logger.debug("OPA - " + "Si desea eliminar el registro con llave primaria: " + StringUtils.arrayToDelimitedString(pk, " "));
                    boolean borrado = false;
                    int estado_borra = 0;

                    if (estado_borra == 1) {
                        if (tabla.getNombreTabla().equalsIgnoreCase("fqs_perfil")) {
                            Auditoria au = new Auditoria();
                            Vector contd = new Vector();
                            contd = tabla.getContenido();
                            au.setid();
                            au.setEvento("Eliminaci髇 de perfil " + contd.elementAt(1));
                            au.setResultado("Exitoso");
                            au.inserta();
                        }
                        Notification.show(MSGEXITO_ELIMINACION, Notification.Type.HUMANIZED_MESSAGE);
                        //getWindow().showNotification(MSGEXITO_ELIMINACION);
                        //getWindow().showNotification(NOMBRE_APLICACION, MSGEXITO_ELIMINACION);
                        //Mantis 2168 Lsierra 2015-12-16 
                        grilla.actualizaDatos();
                        grilla.getTable().select(1);
                        posicionaGrilla(grilla, 1);

                    } else {
                        if (tabla.getNombreTabla().equalsIgnoreCase("fqs_perfil")) {
                            Auditoria au = new Auditoria();
                            Vector contd = new Vector();
                            contd = tabla.getContenido();
                            au.setid();
                            au.setEvento("Eliminaci髇 de perfil " + contd.elementAt(1));
                            au.setResultado("Fallido");
                            au.inserta();
                        }
                        if (estado_borra == 0) {
                            Notification.show(MSGERROR_ELIMINACION, Notification.Type.ERROR_MESSAGE);
                           // getWindow().showNotification(MSGERROR_ELIMINACION, Notification.TYPE_ERROR_MESSAGE);
                            //getWindow().showNotification(NOMBRE_APLICACION, MSGERROR_ELIMINACION, Notification.TYPE_ERROR_MESSAGE);
                            //Mantis 2168 Lsierra 2015-12-16 
                         } else if (estado_borra == 2) {
                             Notification.show(MSGERROR_ELIMINACIONFK, Notification.Type.ERROR_MESSAGE);
                             //getWindow().showNotification(MSGERROR_ELIMINACIONFK, Notification.TYPE_ERROR_MESSAGE);
                            //getWindow().showNotification(NOMBRE_APLICACION, MSGERROR_ELIMINACIONFK, Notification.TYPE_ERROR_MESSAGE);
                            //Mantis 2168 Lsierra 2015-12-16 
                         }
                    }

                    /* if (borrado) {
                     if (tabla.getNombreTabla().equalsIgnoreCase("fqs_perfil")) {
                     Auditoria au = new Auditoria();
                     Vector contd = new Vector();
                     contd=tabla.getContenido();
                     au.setid();
                     au.setEvento("Eliminaci髇 de perfil " +contd.elementAt(1));
                     au.setResultado("Exitoso");
                     au.inserta();
                     }
                     getWindow().showNotification(NOMBRE_APLICACION, MSGEXITO_ELIMINACION);
                     grilla.actualizaDatos();
                     grilla.getTable().select(1);
                     posicionaGrilla(grilla, 1);
                     // grilla.getTable().requestRepaintAll();
                     } else {
                     if (tabla.getNombreTabla().equalsIgnoreCase("fqs_perfil")) {
                     Auditoria au = new Auditoria();
                     Vector contd = new Vector();
                     contd=tabla.getContenido();
                     au.setid();
                     au.setEvento("Eliminaci髇 de perfil " +contd.elementAt(1));
                     au.setResultado("Fallido");
                     au.inserta();
                     }
                     getWindow().showNotification(NOMBRE_APLICACION, MSGERROR_ELIMINACION, Notification.TYPE_ERROR_MESSAGE);
                     }*/  // borrado
                } else {
                    logger.debug("OPA - " + "No desea borrar el registro ");
                } // dialog
                dialog.hide();
            } // on Close
        });   // listener
        dialog.show();
        consultarMaestro();
    }

    /**
     *
     * Crear una grilla de visualizacion, tomando como columnas los 4 primeros
     * campos (atributos de la tabla) Permite ordenamiento y filtraje de datos
     */
    public void grilla() {
        //SMJ2
        grilla = new GrillaService();
        ArrayList<ConfigCampoVO> configCampos = new ArrayList<ConfigCampoVO>();
        ConfigCampoVO cfgCampo;
        StringBuilder query = new StringBuilder("SELECT ");
        StringBuilder queryOVP = new StringBuilder("SELECT ");
        int cols = getColsGrilla();
        String[] attrs = tabla.getAtributos();
        StringBuilder enlace = new StringBuilder(" ");

        for (int j = 0; j < cols; j++) {
            CampoFormatter formatter = obtainCampoFormatter(misAlias[j]);
            cfgCampo = new ConfigCampoVO(formatter);
            cfgCampo.setCampo(attrs[j]);
            cfgCampo.setTitulo(misAlias[j]);
            cfgCampo.setTamano(longitudMaestro[j]);
            if (tabla.getPrecision() != null) {
                if (misTipos[j].equalsIgnoreCase("DOUBLE") || misTipos[j].equalsIgnoreCase("FLOAT") || misTipos[j].equalsIgnoreCase("DECIMAL")) {
                    if (j < (tabla.getPrecision().length)) {
                        cfgCampo.setFormato(Utiles.construirFormato(tabla.getPrecision()[j]));
                        cfgCampo.setPrecision(tabla.getPrecision()[j]);
                    }

                } else if (misTipos[j].equalsIgnoreCase("INTEGER") || misTipos[j].equalsIgnoreCase("INT")) {
                    if (j < (tabla.getPrecision().length)) {
                        cfgCampo.setFormato(Utiles.construirFormato(0));
                    }

                }
            }
            if (miPresentacion[j] == TIPOC_LISTBOX) {
                if (((Integer) tiposCombosMaestro.get(j)) == TIPOCOMBO_SQL) {
                    Vector infoSQL = (Vector) combosMaestro.get(j);
                    String tablaAlterna = (String) infoSQL.get(0);
                    String muestra = (String) infoSQL.get(1);
                    String almacena = (String) infoSQL.get(2);
                    String tipoAlmacena = (String) infoSQL.get(3);

                    cfgCampo.setShowColumnsListaBD(showColumnsListaBD);
                    cfgCampo.setTablaLista(tablaAlterna);
                    cfgCampo.setEnlaceTablaLista(almacena);
                    cfgCampo.setDescriptorTablaLista(muestra);
                }
            }

            configCampos.add(cfgCampo);
            //si flag nueva logica
            if (showColumnsListaBD) {
                if (j < (cols - 1)) {
                    if (miPresentacion[j] == TIPOC_LISTBOX) {
                        if (((Integer) tiposCombosMaestro.get(j)) == TIPOCOMBO_SQL) {
                            Vector infoSQL = (Vector) combosMaestro.get(j);
                            String tablaAlterna = (String) infoSQL.get(0);
                            String muestra = (String) infoSQL.get(1);
                            String almacena = (String) infoSQL.get(2);
                            String tipoAlmacena = (String) infoSQL.get(3);

                            String aliasAlterna = tablaAlterna + j;
                            query.append("concat_ws('" + COL_SEPARATOR + "'," + tabla.getNombreTabla() + "." + attrs[j] + ", " + aliasAlterna + "." + muestra + ") ").append(attrs[j]).append(",");
                            enlace.append(" INNER JOIN " + tablaAlterna + " " + aliasAlterna + " ON " + tabla.getNombreTabla() + "." + attrs[j] + " = " + aliasAlterna + "." + almacena + " ");
                        } else {
                            query.append(tabla.getNombreTabla() + "." + attrs[j] + " ").append(attrs[j]).append(",");
                        }
                    } else {
                        query.append(tabla.getNombreTabla() + "." + attrs[j] + " ").append(attrs[j]).append(",");
                    }
                } else {

                    if (miPresentacion[j] == TIPOC_LISTBOX) {
                        if (((Integer) tiposCombosMaestro.get(j)) == TIPOCOMBO_SQL) {
                            Vector infoSQL = (Vector) combosMaestro.get(j);
                            String tablaAlterna = (String) infoSQL.get(0);
                            String muestra = (String) infoSQL.get(1);
                            String almacena = (String) infoSQL.get(2);
                            String tipoAlmacena = (String) infoSQL.get(3);
                            tablaAlterna = tablaAlterna;
                            String aliasAlterna = tablaAlterna + j;
                            query.append("concat_ws('" + COL_SEPARATOR + "'," + tabla.getNombreTabla() + "." + attrs[j] + ", " + aliasAlterna + "." + muestra + ") ").append(attrs[j]).append(" ");
                            enlace.append(" INNER JOIN " + tablaAlterna + " " + aliasAlterna + " ON " + tabla.getNombreTabla() + "." + attrs[j] + " = " + aliasAlterna + "." + almacena + " ");
                        } else {
                            query.append(tabla.getNombreTabla() + "." + attrs[j] + " ").append(attrs[j]).append(" ");
                        }
                    } else {
                        query.append(tabla.getNombreTabla() + "." + attrs[j] + " ").append(attrs[j]).append(" ");

                    }

                }
            } else {
                if (j < (cols - 1)) {
                    query.append(attrs[j]).append(",");
                } else {
                    query.append(attrs[j]);
                }
            }
        }

        if (showColumnsListaBD) {
            if (tabla.getNombreTabla().equals("ma_ofertas_permanentes")) {
                query.append(" FROM ").append(tabla.getNombreTabla()).append(enlace).append("WHERE ma_ofertas_permanentes.i_lotes_idlotes = ma_lotes2.id_lotes AND ma_ofertas_permanentes.i_ma_martillo_i_id_martillo_op =ma_lotes2.i_ma_martillo_id_martillo_lotes").append(" ORDER BY ").append(tabla.getAtributos()[0]); // ordenados 
            } else {
                query.append(" FROM ").append(tabla.getNombreTabla()).append(enlace).append(" ORDER BY ").append(tabla.getAtributos()[0]);
            }
        } else {
            query.append(" FROM ").append(tabla.getNombreTabla()).append(" ORDER BY ").append(tabla.getAtributos()[0]); // ordenados por llave primario (0)
        }
        //Agregar order by. Pendiente
        logger.debug("OPA - " + query.toString());

        grilla.creaGrilla(getUI(), layMaster, configCampos, tituloMaestro, query.toString(),
                rActual, SIZEGRILLA_MAESTRO, true);

    }

    /**
     *
     * Crear una grilla de visualizacion para la tabla de detalla, tomando como
     * columnas los 3 primeros campos (atributos de la tabla) Permite
     * ordenamiento y filtraje de datos
     */
    public void grillaDetalle(String[] pk) {
        grillaDetalle = new GrillaService();
        ConfigCampoVO cfgCampo = null;
        ArrayList<ConfigCampoVO> configCampos = new ArrayList<ConfigCampoVO>();
        StringBuilder query = new StringBuilder("SELECT ");
        int control = NUMEROCAMPOS_GRILLADETALLE;
        StringBuilder enlace = new StringBuilder(" ");

        if (tablaDetalle.getAtributos().length < NUMEROCAMPOS_GRILLADETALLE) {
            control = tablaDetalle.getAtributos().length;
        }
        for (int j = 0; j < control; j++) {
            CampoFormatter formatter = obtainCampoFormatter(aliasDetalle[j]);
            cfgCampo = new ConfigCampoVO(formatter);
            // cfgCampo = new ConfigCampoVO();
            cfgCampo.setCampo(tablaDetalle.getAtributos()[j]);
            cfgCampo.setTitulo(aliasDetalle[j]);
            cfgCampo.setTamano(longitudDetalle[j]);
            if (tablaDetalle.getPrecision() != null) {
                if (tiposDetalle[j].equalsIgnoreCase("DOUBLE") || tiposDetalle[j].equalsIgnoreCase("FLOAT") || tiposDetalle[j].equalsIgnoreCase("DECIMAL")) {
                    if (j < (tablaDetalle.getPrecision().length)) {
                        cfgCampo.setFormato(tiposDetalle[j] + tablaDetalle.getPrecision()[j]);
                        cfgCampo.setPrecision(tablaDetalle.getPrecision()[j]);
                    }

                }
            }

            if (presentacionDetalle[j] == TIPOC_LISTBOX) {
                if (((Integer) tiposCombosDetalle.get(j)) == TIPOCOMBO_SQL) {
                    Vector infoSQL = (Vector) combosDetalle.get(j);
                    String tablaAlterna = (String) infoSQL.get(0);
                    String muestra = (String) infoSQL.get(1);
                    String almacena = (String) infoSQL.get(2);
                    String tipoAlmacena = (String) infoSQL.get(3);

                    cfgCampo.setShowColumnsListaBD(showColumnsListaBDDetalle);
                    cfgCampo.setTablaLista(tablaAlterna);
                    cfgCampo.setEnlaceTablaLista(almacena);
                    cfgCampo.setDescriptorTablaLista(muestra);

                }
            }

            configCampos.add(cfgCampo);
//Desde
            //si flag nueva logica
            if (showColumnsListaBDDetalle) {
                if (j != (control - 1)) {

                    if (presentacionDetalle[j] == TIPOC_LISTBOX) {
                        if (((Integer) tiposCombosDetalle.get(j)) == TIPOCOMBO_SQL) {
                            Vector infoSQL = (Vector) combosDetalle.get(j);
                            String tablaAlterna = (String) infoSQL.get(0);
                            String muestra = (String) infoSQL.get(1);
                            String almacena = (String) infoSQL.get(2);
                            String tipoAlmacena = (String) infoSQL.get(3);
                            String aliasAlterna = tablaAlterna + j;
                            query.append("concat_ws('" + COL_SEPARATOR + "'," + tablaDetalle.getNombreTabla() + "." + tablaDetalle.getAtributos()[j] + ", " + aliasAlterna + "." + muestra + ") ").append(tablaDetalle.getAtributos()[j]).append(",");
                            if (tablaDetalle.getNombreTabla().toString().equals("ma_lotes") && tablaDetalle.getAtributos()[j].toString().equals("estadolote_idestadolote")) {
                                enlace.append(" INNER JOIN " + tablaAlterna + " " + aliasAlterna + " ON " + tablaDetalle.getNombreTabla() + "." + tablaDetalle.getAtributos()[j] + " = " + aliasAlterna + "." + almacena + " ");
                                enlace.append(" INNER JOIN ma_martillo ma_martillo ON ma_lotes.i_ma_martillo_id_martillo_lotes = ma_martillo.i_id_martillo" + " ");
                            } else {
                                enlace.append(" INNER JOIN " + tablaAlterna + " " + aliasAlterna + " ON " + tablaDetalle.getNombreTabla() + "." + tablaDetalle.getAtributos()[j] + " = " + aliasAlterna + "." + almacena + " ");
                            }
                        } else {
                             if (tablaDetalle.getNombreTabla().toString().equals("ma_lotes") && tablaDetalle.getAtributos()[j].toString().equals("b_es_todo_o_nada"))
                            query.append(" CASE ma_lotes.b_es_todo_o_nada  WHEN 0 THEN 'No' ELSE 'Si' END AS TN" + " ").append(",");          
                             else
                            query.append(tablaDetalle.getNombreTabla() + "." + tablaDetalle.getAtributos()[j] + " ").append(tablaDetalle.getAtributos()[j]).append(",");
                             
                             }
                    } else {
                        if (tablaDetalle.getNombreTabla().toString().equals("ma_lotes") && tablaDetalle.getAtributos()[j].toString().equals("i_ma_martillo_id_martillo_lotes")) 
                            query.append("ma_martillo.c_nemotecnico" + " ").append(",");
                         else 
                            query.append(tablaDetalle.getNombreTabla() + "." + tablaDetalle.getAtributos()[j] + " ").append(tablaDetalle.getAtributos()[j]).append(",");
                    }
                } else {

                    if (presentacionDetalle[j] == TIPOC_LISTBOX) {
                        if (((Integer) tiposCombosDetalle.get(j)) == TIPOCOMBO_SQL) {
                            Vector infoSQL = (Vector) combosDetalle.get(j);
                            String tablaAlterna = (String) infoSQL.get(0);
                            String muestra = (String) infoSQL.get(1);
                            String almacena = (String) infoSQL.get(2);
                            String tipoAlmacena = (String) infoSQL.get(3);
                            tablaAlterna = tablaAlterna;
                            String aliasAlterna = tablaAlterna + j;             
                            query.append("concat_ws('" + COL_SEPARATOR + "'," + tablaDetalle.getNombreTabla() + "." + tablaDetalle.getAtributos()[j] + ", " + aliasAlterna + "." + muestra + ") ").append(tablaDetalle.getAtributos()[j]).append(" ");
                            enlace.append(" INNER JOIN " + tablaAlterna + " " + aliasAlterna + " ON " + tablaDetalle.getNombreTabla() + "." + tablaDetalle.getAtributos()[j] + " = " + aliasAlterna + "." + almacena + " ");
                        } else {
                            query.append(tablaDetalle.getNombreTabla() + "." + tablaDetalle.getAtributos()[j] + " ").append(tablaDetalle.getAtributos()[j]).append(" ");
                        }
                    } else {
                        query.append(tablaDetalle.getNombreTabla() + "." + tablaDetalle.getAtributos()[j] + " ").append(tablaDetalle.getAtributos()[j]).append(" ");
                    }

                }
            } else {
                if (j != (control - 1)) {
                query.append(tablaDetalle.getAtributos()[j] + ",");
                } else {
                    query.append(tablaDetalle.getAtributos()[j]);
                }

            }
        }

//Hasta            
        if (showColumnsListaBDDetalle) {
            query.append(" FROM " + tablaDetalle.getNombreTabla()).append(enlace).append(" WHERE 1=1");

        } else {
            query.append(" FROM " + tablaDetalle.getNombreTabla()
                    + " WHERE 1=1");
        }

        for (int i = 0; i < llaveDetalle.size(); i++) {
            query.append(" and " + llaveDetalle.get(i) + " = '" + pk[i] + "'");
        }
        if (this.query) {
            query.append(this.queryvariante);
        } else {

            query.append(" ORDER BY ");
            for (int i = 0; i < llaveDetalle.size(); i++) {
                query.append(tablaDetalle.getAtributosLLave().elementAt(i));
            }   // ordenados por llave primario (0)
        }
        logger.debug("OPA - " + query.toString());
        grillaDetalle.creaGrilla(getApplication(),  layDetalle, configCampos, tituloDetalle, query.toString(), rActualD, SIZEGRILLA_DETALLE, true);
        posicionaGrilla(grillaDetalle, 1);  		// deja seleccionado el primer registro por defecto

    }

    /**
     * Crea forma de edici贸n, con los campos correspondientes al registro
     * actual de detalle
     */
    private void editarDetalle(boolean editar) {
        boolean hayDatos = false;
        if (grillaDetalle.getTable().size() > 0 || agregandoDetalle) {
            hayDatos = true;
        }
        if (enFormaEdicionDetalle && hayDatos) // si ya esta en detalle solo le habilita el acceso
        {
            iFormaDetalle.setReadOnly(false);
            botonDeshacerD.setVisible(true);
            botonGuardarD.setVisible(true);
            iFormaDetalle.requestRepaint();
        } else {
            String[] props = tablaDetalle.getAtributos();
            String[] pk = new String[tablaDetalle.getAtributosLLave().size()];
            tablaDetalle.inicializar();
            try {
                if (editar) {

                    int actual = getActual(grillaDetalle);
                    for (int i = 0; i < tablaDetalle.getAtributosLLave().size(); i++) {
                        if (grillaDetalle.getTable().getItem(actual).getItemProperty(props[i]).getValue().toString().contains("|")) {
                            StringTokenizer a = new StringTokenizer(grillaDetalle.getTable().getItem(actual).getItemProperty(props[i]).getValue().toString(), "|");
                            pk[i] = Utiles.retiraFormatoMiles(a.nextToken()); // obtiene el valor de la llave maestra
                        } else {
                            pk[i] = Utiles.retiraFormatoMiles(grillaDetalle.getTable().getItem(actual).getItemProperty(props[i]).getValue().toString());  // obtiene valor de la llave primaria (siempre es el primer atributo)
                        }     
                    }

                    logger.debug("OPA - " + "PK=" + StringUtils.arrayToDelimitedString(pk, " ") + "-actual=" + actual);
                    String where = "WHERE 1=1 ";
                    for (int i = 0; i < tablaDetalle.getAtributosLLave().size(); i++) {
                        where += " and " + props[i] + "=?";
                    }
                    tablaDetalle.consultaP(where, pk);  //obtiene todos los campos del campo seleccionado en la BD
                    tablaDetalle.rs.next();                // carga datos en RS
                    tablaDetalle.setContenido();                                       // tranfiere los datos del resulset a un vector
                    VRegistroD = tablaDetalle.getContenido();
                } else // esta agregando un registro nuevo
                {
                    VRegistroD = tablaDetalle.getContenido();
                    // aqui se le inserta la llave primario del maestro por defecto, a la primera posicion del vector
                    //VRegistroD.set(0, VRegistro.get(0));
                }

                Iterator ite = VRegistroD.iterator();
                int j = 0;
                while (ite.hasNext()) {
                    logger.debug("OPA - " + "Propiedad entrada:" + props[j] + "=" + ite.next());
                    j++;
                }
                cLayout.removeComponent(layDetalle);                             // remueve grilla de pantalla
                iFormaDetalle = mFormaDetalle.creaForma(tituloDetalle, VRegistroD, aliasDetalle,
                        tiposDetalle, presentacionDetalle, longitudDetalle, requeridoDetalle,
                        combosDetalle, tiposCombosDetalle, valorCombosDetalle, radioDetalle,
                        tablaDetalle.getElementosLLave(), editar, false, llaveMaestro, llaveDetalle,
                        obtienePkMaestro(), tablaDetalle.getAtributos(), tablaDetalle.getPrecision(), defaultvaluesDetalle, valoresDetalle);
                iFormaDetalle.setReadOnly(true);

                cLayout.addComponent(iFormaDetalle, "tabla2");

                // oculta botones que no aplican
                botonAgregarD.setVisible(false);
                botonGuardarD.setVisible(false);
                botonDeshacerD.setVisible(false);

                lRactualD.setVisible(false);
                rActualD.setVisible(false);

                // habilita botones que si aplican
                botonConsultarD.setVisible(true);
                botonImprimirD.setVisible(true);
                enFormaEdicionDetalle = true;

            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }
        }  // enFormaEdicionDetalle
/*
         } // if tama帽o de grilla > 0
         else {
         getWindow().showNotification(NOMBRE_APLICACION,MSGERROR_EDICIONVACIO,Notification.TYPE_WARNING_MESSAGE);
         }
         */
    }

    /**
     * Cambia a modo grilla en el detalle, restaurando el estado de los botones
     */
    private void consultarDetalle() {
        int actual = getActual(grillaDetalle);
        logger.debug("OPA - " + "reg Actual al consultar :" + actual);
        if (enFormaEdicionDetalle) {
            iFormaDetalle.removeAllProperties();
        }

        cLayout.removeComponent(iFormaDetalle);
        cLayout.addComponent(layDetalle, "tabla2");

        botonAgregarD.setVisible(true);   		// habilita botones que no aplican

        rActualD.setVisible(true);
        lRactualD.setVisible(true);

        botonConsultarD.setVisible(false);  		// deshabilita botones que no aplican
        botonDeshacerD.setVisible(false);
        botonGuardarD.setVisible(false);
        enFormaEdicionDetalle = false;
        if (iFormaDetalle != null) {
            iFormaDetalle.setReadOnly(true);
        }
        posicionaGrilla(grillaDetalle, actual);
    }

    /**
     * Eliminar el registro indicado por la llave primaria en la tabla de
     * detalle
     *
     * @param primaryKey
     */
    public void eliminaDetalle() {

        if (grillaDetalle.getTable().size() > 0) {

            final String[] props = tablaDetalle.getAtributos();
            final int actual = Integer.parseInt(grillaDetalle.getTable().getValue().toString().replace("[", "").replace("]", ""));

            final Object[] args = new Object[tablaDetalle.getElementosLLave()];
            final String[] pk = new String[tablaDetalle.getElementosLLave()];
            for (int i = 0; i < tablaDetalle.getElementosLLave(); i++) {
                pk[i] = Utiles.retiraFormatoMiles(grillaDetalle.getTable().getItem(actual).getItemProperty(props[i]).getValue().toString());
            }

            dialog = new ConfirmDialog("Titulo", MSGCONFIRMA_TITULO, MSGELIMINAR_PREGUNTA + " " + StringUtils.arrayToDelimitedString(pk, " "), new Button.ClickListener() {
                @Override
                public void buttonClick(ClickEvent event) {
                    boolean borrado = false;
                    int estado_borra = 0;
                    if (ConfirmDialog.BUTTON_OK_CAPTION.equals(event.getButton().getCaption())) {
                        logger.debug("OPA - " + "Si desea eliminar el registro con llave primaria: " + StringUtils.arrayToDelimitedString(pk, " "));
                        try {
                            String nombreLlave = "";
                            for (int i = 0; i < tablaDetalle.getElementosLLave(); i++) {
                                nombreLlave = nombreLlave + " and " + props[i] + " =? ";
                                args[i] = Utiles.retiraFormatoMiles(grillaDetalle.getTable().getItem(actual).getItemProperty(props[i]).getValue().toString());
                            }
                            //borrado = tablaDetalle.eliminar(nombreLlave, args);//Camilo 22.01.2014
                            estado_borra = tablaDetalle.eliminarFK(nombreLlave, args);//Diana 06.06.2014
                            if (tablaDetalle.getNombreTabla().equalsIgnoreCase("fqs_permiso")) {
                                Auditoria au = new Auditoria();
                  //au.setid();
                                //au.setEvento("elimina permiso");
                                //au.setResultado("exitoso");
                                //au.inserta();

                                /////

                                /*Vector contd = new Vector();
                                 contd = tablaDetalle.getContenido();
                                 //Auditoria au = new Auditoria();
                                 contd.elementAt(0);//permiso
                                 contd.elementAt(1);//perfil
                                 contd.elementAt(2);//opcionmodulo
                                 contd.elementAt(3);//hora inicio
                                 contd.elementAt(4);//hora fin
                                 contd.elementAt(5);//descrip*/
                                Parametro parame = new Parametro();
                                Vector conts = new Vector();
                                conts = tablaDetalle.getContenido();
                                conts.elementAt(0);
                                conts.elementAt(1);
                                String opconmodulo = "";
                                String permiso = "";
                                try {
                                    //Camilo 27.12.2013 Modificacion para el registro de Auditoria
                                    String moduloAntiguo = "";
                                    parame.consultaG("select * from fqs_permiso where i_permiso=?", pk[0]);
                                    if (parame.rs.first()) {
                                        moduloAntiguo = parame.rs.getString("i_opcionmodulo");
                                    }
                                    parame.consultaG("select * from fqs_opcionmodulo where i_opcionmodulo=?", moduloAntiguo);//conts.elementAt(2));//parame.rs.getString("i_opcionmodulo"));
                                    if (parame.rs.first()) {
                                        opconmodulo = parame.rs.getString("c_nombre");
                                    }
                                    parame.consultaG("select * from fqs_permiso where i_permiso=?", pk[0]);
                                    if (parame.rs.first()) {
                                        permiso = parame.rs.getString("i_perfil");
                                    }
                                    parame.consultaG("select * from fqs_perfil where i_perfil=?", permiso);
                                    if (parame.rs.first()) {
                                        permiso = parame.rs.getString("c_nombre");
                                    }
                                    /*parame.consultaG("select * from fqs_opcionmodulo where i_opcionmodulo=?", contd.elementAt(2));
                                     if (parame.rs.first()) {
                                     opconmodulo = parame.rs.getString("c_nombre");
                                     }*/
                                } catch (SQLException ex) {
                                    java.util.logging.Logger.getLogger(JFormMD.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                //borrado = tablaDetalle.eliminar(nombreLlave, args);
                                estado_borra = tablaDetalle.eliminarFK(nombreLlave, args);//Diana 06.06.2014
                                au.setid();
                                au.setEvento("Modificaci髇 de permisos perfil " + permiso + ": elimina permiso " + opconmodulo);
                                //au.setEvento("elimina permiso "+contd.elementAt(0) +" con el perfil "+permiso+" opcion modulo "+opconmodulo  );
                                au.setResultado("Exitoso");
                                au.inserta();
                            }
                            if (tablaDetalle.getNombreTabla().equalsIgnoreCase("fqs_perfil")) {

                                Auditoria au = new Auditoria();
                  //au.setid();
                                //au.setEvento("elimina perfil");
                                //au.setResultado("exitoso");
                                //au.inserta();

                                ////
                                Vector contd = new Vector();
                                contd = tablaDetalle.getContenido();
                                //Auditoria au = new Auditoria();
                                contd.elementAt(0);//permiso
                                contd.elementAt(1);//perfil
                                //Solicitud BVC Correo Martillo - Conclusiones reuni髇 16709/2015: Punto 2
                                //Lsierra 2015-09-23
                                contd.elementAt(2);//opcionmodulo
                                //contd.elementAt(3);//hora inicio
                                //contd.elementAt(4);//hora fin
                                //contd.elementAt(5);//descrip
                                contd.elementAt(3);//descrip
                                Parametro parame = new Parametro();
                                String opconmodulo = "";

                                au.setid();
                                au.setEvento("elimina perfil " + contd.elementAt(0) + " " + contd.elementAt(1) + " ");
                                au.setResultado("Exitoso");
                                au.inserta();

                                ////
                            }

                        } catch (Exception e) {
                            logger.debug("OPA - " + "Error al borrar registro con llave:" + pk + "En tabla:" + tablaDetalle.getNombreTabla() + e.getMessage());
                            //borrado = false;
                            estado_borra = 0;
                        }
                        /*if (borrado) {
                         getWindow().showNotification(NOMBRE_APLICACION, MSGEXITO_ELIMINACION);
                         grillaDetalle.actualizaDatos();
                         grillaDetalle.getTable().select(1);
                         posicionaGrilla(grillaDetalle, 1);
                         // grilla.getTable().requestRepaintAll();
                         } else {
                         getWindow().showNotification(NOMBRE_APLICACION, MSGERROR_ELIMINACION, Notification.TYPE_ERROR_MESSAGE);
                         }  // borrado*/

                        if (estado_borra == 1) {
                            //getWindow().showNotification(MSGEXITO_ELIMINACION);
                            Notification.show(MSGEXITO_ELIMINACION, Notification.Type.HUMANIZED_MESSAGE);
                            //getWindow().showNotification(NOMBRE_APLICACION, MSGEXITO_ELIMINACION);
                            //Mantis 2168 Lsierra 2015-12-16
                            grillaDetalle.actualizaDatos();
                            grillaDetalle.getTable().select(1);
                            posicionaGrilla(grillaDetalle, 1);
                            // grilla.getTable().requestRepaintAll();
                        } else if (estado_borra == 0) {
                            Notification.show(MSGERROR_ELIMINACION, Notification.Type.ERROR_MESSAGE);
                           // getWindow().showNotification(MSGERROR_ELIMINACION, Notification.TYPE_ERROR_MESSAGE);
                            //getWindow().showNotification(NOMBRE_APLICACION, MSGERROR_ELIMINACION, Notification.TYPE_ERROR_MESSAGE);
                            //Mantis 2168 Lsierra 2015-12-16
                        } else if (estado_borra == 2) {
                            Notification.show(MSGERROR_ELIMINACIONFK, Notification.Type.ERROR_MESSAGE);
                            //getWindow().showNotification(MSGERROR_ELIMINACIONFK, Notification.TYPE_ERROR_MESSAGE);
                            //getWindow().showNotification(NOMBRE_APLICACION, MSGERROR_ELIMINACIONFK, Notification.TYPE_ERROR_MESSAGE);
                            //Mantis 2168 Lsierra 2015-12-16
                        }
                    }
                    dialog.hide();
                }
            });

            dialog.show();

            consultarDetalle();
        } // if tama帽o de grilla > 0
        else {
           // getWindow().showNotification(MSGERROR_ELIMINACIONVACIO, Notification.TYPE_WARNING_MESSAGE);
            Notification.show(MSGERROR_ELIMINACIONVACIO, Notification.Type.WARNING_MESSAGE);
            //getWindow().showNotification(NOMBRE_APLICACION, MSGERROR_ELIMINACIONVACIO, Notification.TYPE_WARNING_MESSAGE);
            //Mantis 2168 Lsierra 2015-12-16
        }

    }

    /**
     * Deshace cmabios (carga informacion anterior) en registro actual de tabla
     * detalle
     */
    public void deshacerDetalle() {
        dialog = new ConfirmDialog("Tirulo", MSGCONFIRMA_TITULO, MSGDESHACER_PREGUNTA, new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                if (ConfirmDialog.BUTTON_OK_CAPTION.equals(event.getButton().getCaption())) {
                    Notification.show(MSGEXITO_DESHACER, Notification.Type.HUMANIZED_MESSAGE);
                    //getWindow().showNotification(MSGEXITO_DESHACER);
                    //getWindow().showNotification(NOMBRE_APLICACION, MSGEXITO_DESHACER);
                    //Mantis 2168 Lsierra 2015-12-16
                    editarDetalle(Boolean.TRUE);    // recarga datos para evitar problemas de sincronizacion y deja registro en modo de lectura
                    consultarDetalle();
                } else {
                    logger.debug("OPA - " + "No desea descartar cambios del registro ");
                } // dialog
                dialog.hide();
            } // on Close
        });   // listener
        dialog.show();
    }

    /**
     * Almacena cambios de edicion en la base de datos usando capa de
     * persistencia existente (tabla detalle)
     */
    private void guardarDetalle() {

        iFormaDetalle.commit();
        Iterator<?> ite = iFormaDetalle.getItemPropertyIds().iterator();
        Vector registro = new Vector();
        // Convierte fechas java.util.date a java.sql.Date - requisito para capa de persistencia
            while (ite.hasNext()) {
                Integer pro = (Integer) ite.next();

                Object oProp = iFormaDetalle.getItemProperty(pro).getValue();
                String tipoC = "";
                if (oProp != null) {
                    tipoC = oProp.getClass().getName().toString();
                }

                //logger.debug("OPA - " + "GuardaCorrige:"+tipoC);
                if (!tipoC.equalsIgnoreCase("java.util.Date")) {
                    registro.add(iFormaDetalle.getItemProperty(pro).getValue());
                    logger.debug("OPA - " + "Propiedad salida:" + pro + "=" + iFormaDetalle.getItemProperty(pro).getValue() + "-tipo=" + tipoC);
                } else // es fecha corrige de formato largo en java.util.Date a java.sql.Date
                {
                    java.sql.Date fechac = Utiles.corrigeFecha((java.util.Date) iFormaDetalle.getItemProperty(pro).getValue());
                    registro.add(fechac);
                    logger.debug("OPA - " + "Propiedad salidaF:" + pro + "=" + fechac + "-tipofechaN=" + fechac.getClass().getName());
                }

            }
       
        tablaDetalle.setContenido(ajustaDatos(registro, tiposDetalle, longitudDetalle, tablaDetalle.getPrecision()));

        // Validacion de datos usando logica del javabean existente  (detalle)
        // sugerencias - revisar para enviar mensaje mas diciente.
		/*
         if( !(tabla.validaContenido(registro,tiposDetalle , requeridoDetalle) &&  Utiles.VerificaNulos(registro, requeridoDetalle))) {    // datos validos para guardarse
         getWindow().showNotification(NOMBRE_APLICACION, MSGERROR_VALIDACION_DETALLE,Notification.TYPE_ERROR_MESSAGE);
         }
         else   // datos fueron validos se procede a actualizar 贸 insertar segun sea el caso
         {
         */
        if (!agregandoDetalle) {   // acualizando: update
            int actual = Integer.parseInt(grillaDetalle.getTable().getValue().toString().replace("[", "").replace("]", ""));

            if (tablaDetalle.getNombreTabla().equalsIgnoreCase("fqs_permiso")) {
                Parametro parame = new Parametro();
                Vector conts = new Vector();
                conts = tablaDetalle.getContenido();
                conts.elementAt(0);//permiso
                conts.elementAt(1);//perfil
                //Solicitud BVC Correo Martillo - Conclusiones reuni髇 16709/2015: Punto 2
                //Lsierra 2015-09-23   
                //conts.elementAt(3);//hora inicio
                //conts.elementAt(4);//hora fin
                //conts.elementAt(5);//descripcion
                conts.elementAt(2);//descripcion
                String opconmodulo = "";
                Auditoria au = new Auditoria();
                au.setid();

                try {
                    parame.consultaG("select * from fqs_perfil where i_perfil=?", conts.elementAt(1));
                    if (parame.rs.first()) {
                        opconmodulo = parame.rs.getString("c_nombre");
                    }
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(JFormMD.class.getName()).log(Level.SEVERE, null, ex);
                }
                String antiguo = "";
                try {
                    //Camilo 27.12.2013, Modificacion para el previo registro en Auditoria
                    String moduloAntiguo = "";
                    parame.consultaG("select * from fqs_permiso where i_permiso=?", conts.elementAt(0));
                    if (parame.rs.first()) {
                        moduloAntiguo = parame.rs.getString("i_opcionmodulo");
                    }
                    parame.consultaG("select * from fqs_opcionmodulo where i_opcionmodulo=?", moduloAntiguo);//conts.elementAt(2));//parame.rs.getString("i_opcionmodulo"));
                    if (parame.rs.first()) {
                        antiguo = parame.rs.getString("c_nombre");
                    }

                    parame.consultaG("select * from fqs_permiso where i_permiso=? and i_perfil=?", conts.elementAt(0), conts.elementAt(1));
                    if (parame.rs.first()) {
                        conts.elementAt(2);//opcionmodulo
                        //Solicitud BVC Correo Martillo - Conclusiones reuni髇 16709/2015: Punto 2
                        //Lsierra 2015-09-23
                        //conts.elementAt(3);//hora inicio
                        //conts.elementAt(4);//hora fin
                        //conts.elementAt(5);//descripcion
                        conts.elementAt(3);//descripcion
                       // if (!conts.elementAt(5).toString().equalsIgnoreCase(parame.rs.getString("c_descripcion"))) {
                       //au.setEvento("Modificaci髇 de permisos perfil " + opconmodulo + ": modifica permiso " + antiguo + " campo descripci髇 de valor inicial: " + parame.rs.getString("c_descripcion") + " valor final:" + conts.elementAt(5));  
                            if (!conts.elementAt(3).toString().equalsIgnoreCase(parame.rs.getString("c_descripcion"))) {
                            au.setEvento("Modificaci髇 de permisos perfil " + opconmodulo + ": modifica permiso " + antiguo + " campo descripci髇 de valor inicial: " + parame.rs.getString("c_descripcion") + " valor final:" + conts.elementAt(3));
                            au.setResultado("Exitoso");
                            au.inserta();
                        }
                         //Solicitud BVC Correo Martillo - Conclusiones reuni髇 16709/2015: Punto 2
                         //Lsierra 2015-09-23  
                         /*  if (!conts.elementAt(4).toString().equalsIgnoreCase(parame.rs.getString("dt_horafinpermiso"))) {
                            //au.setEvento("modifica permiso "+conts.elementAt(0)+" de perfil " +opconmodulo+" campo hora final valor inicial:" + parame.rs.getString("dt_horafinpermiso") +" valor final:"+ conts.elementAt(4) );
                            au.setEvento("Modificaci髇 de permisos perfil " + opconmodulo + ": modifica permiso " + antiguo + " campo hora final de valor inicial: " + parame.rs.getString("dt_horafinpermiso") + " valor final:" + conts.elementAt(4));
                            au.setResultado("Exitoso");
                            au.inserta();
                        }

                        if (!conts.elementAt(3).toString().equalsIgnoreCase(parame.rs.getString("dt_horainipermiso"))) {
                            //au.setEvento("modifica permiso "+conts.elementAt(0)+" de perfil " +opconmodulo+" campo hora inicio valor inicial:" + parame.rs.getString("dt_horainipermiso") +" valor final:"+conts.elementAt(3)  );
                            au.setEvento("modificaci髇 de permisos perfil " + opconmodulo + ": modifica permiso " + antiguo + " campo hora inicio de valor inicial: " + parame.rs.getString("dt_horainipermiso") + " valor final: " + conts.elementAt(3));
                            au.setResultado("Exitoso");
                            au.inserta();
                        } */
                        if (!conts.elementAt(2).toString().equalsIgnoreCase(parame.rs.getString("i_opcionmodulo"))) {
                            String nuevo = "";

                            parame.consultaG("select * from fqs_opcionmodulo where i_opcionmodulo=?", conts.elementAt(2));
                            if (parame.rs.first()) {
                                nuevo = parame.rs.getString("c_nombre");
                            }
                            parame.consultaG("select * from fqs_opcionmodulo where i_opcionmodulo=?", parame.rs.getString("i_opcionmodulo"));
              //Camilo 27.12.2013, Modificacion para el previo registro en Auditoria
              /*if (parame.rs.first()) {
                             antiguo = parame.rs.getString("c_nombre");
                             }*/

                            // au.setEvento("modifica permiso "+conts.elementAt(0)+" de perfil " +opconmodulo+" campo opcion modulo valor inicial:" + antiguo +" valor final:"+ nuevo );
                            au.setEvento("Modificaci髇 de permisos perfil " + opconmodulo + ": modifica permiso " + antiguo + ", por nuevo permiso " + nuevo);
                            au.setResultado("Exitoso");
                            au.inserta();
                        }

                    }
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(JFormMD.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            boolean actualizo = tablaDetalle.actualizar();
            if (actualizo) {
                if (tablaDetalle.getNombreTabla().equalsIgnoreCase("fqs_perfil")) {
                    Auditoria au = new Auditoria();
                    au.setid();

                    Vector conts = new Vector();
                    conts = tablaDetalle.getContenido();
                    Parametro parames = new Parametro();
                    try {
                        parames.consultaG("select * from fqs_perfil where i_perfil=? ", conts.elementAt(0));

                        if (parames.rs.first()) {
                            
                               //Solicitud BVC Correo Martillo - Conclusiones reuni髇 16709/2015: Punto 2
                               //Lsierra 2015-09-23
                                /*if (!conts.elementAt(4).toString().equalsIgnoreCase(parames.rs.getString("c_descripcion"))) {
                                au.setEvento("modifica perfil " + conts.elementAt(0) + " campo descripci髇 valor inicial:" + parames.rs.getString("c_descripcion") + " valor final:" + conts.elementAt(4));
                                au.setResultado("exitoso");
                                au.inserta();
                            }
                            if (!conts.elementAt(3).toString().equalsIgnoreCase(parames.rs.getString("dt_horafinsesion"))) {
                                au.setEvento("modifica perfil " + conts.elementAt(0) + " campo hora final valor inicial:" + parames.rs.getString("dt_horafinsesion") + " valor final:" + conts.elementAt(3));
                                au.setResultado("exitoso");
                                au.inserta();
                                } */

                            if (!conts.elementAt(2).toString().equalsIgnoreCase(parames.rs.getString("dt_horainisesion"))) {
                                au.setEvento("modifica perfil " + conts.elementAt(0) + " campo hora inicio valor inicial:" + parames.rs.getString("dt_horainisesion") + " valor final:" + conts.elementAt(2));
                                au.setResultado("exitoso");
                                au.inserta();
                            }
                            if (!conts.elementAt(1).toString().equalsIgnoreCase(parames.rs.getString("c_nombre"))) {
                                au.setEvento("modifica perfil " + conts.elementAt(0) + " campo nombre valor inicial:" + parames.rs.getString("c_nombre") + " valor final:" + conts.elementAt(1));
                                au.setResultado("exitoso");
                                au.inserta();
                            }
                        }
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(JFormMD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                  //getWindow().showNotification(MSGEXITO_ACTUALIZACION);
                  Notification.show(MSGEXITO_ACTUALIZACION,Notification.Type.HUMANIZED_MESSAGE);
                //getWindow().showNotification(NOMBRE_APLICACION, MSGEXITO_ACTUALIZACION);
                //Mantis 2168 Lsierra 2015-12-16
                grillaDetalle.actualizaDatos();
                posicionaGrilla(grillaDetalle, actual);
            } else {
                if (tablaDetalle.getNombreTabla().equalsIgnoreCase("fqs_perfil")) {

                    Auditoria au = new Auditoria();
                    au.setid();

                    au.setEvento("modifica perfil");
                    au.setResultado("fallido");
                    au.inserta();
                }
                Notification.show(MSGERROR_ACTUALIZACION, Notification.Type.ERROR_MESSAGE);
                //getWindow().showNotification(MSGERROR_ACTUALIZACION, Notification.TYPE_ERROR_MESSAGE);
                //getWindow().showNotification(NOMBRE_APLICACION, MSGERROR_ACTUALIZACION, Notification.TYPE_ERROR_MESSAGE);
                //Mantis 2168 Lsierra 2015-12-16
            }  // actualizacion
        } else //  agregando (insert)
        {

            boolean inserto = false;
            boolean existe = false;
            String pk = "";
            for (int i = 0; i < tablaDetalle.getAtributosLLave().size(); i++) {
                pk += tablaDetalle.getAtributosLLave().elementAt(i) + " = " + tablaDetalle.getContenido().elementAt(i).toString() + " ";
            }
            try {
                tablaDetalle.consultaP();
                if (!tablaDetalle.rs.next()) {
                    inserto = tablaDetalle.insertar();
                    existe = false;
                } else {
                    inserto = false;
                    existe = true;
                }
                if (inserto) {

                    if (tablaDetalle.getNombreTabla().equalsIgnoreCase("fqs_permiso")) {
                        Vector contd = new Vector();
                        contd = tablaDetalle.getContenido();
                        Auditoria au = new Auditoria();
                        contd.elementAt(0);//permiso
                        contd.elementAt(1);//perfil
                        contd.elementAt(2);//opcionmodulo
                        //Solicitud BVC Correo Martillo - Conclusiones reuni髇 16709/2015: Punto 2
                        //Lsierra 2015-09-23
                        //contd.elementAt(3);//hora inicio
                        //contd.elementAt(4);//hora fin
                        //contd.elementAt(5);//descrip
                        contd.elementAt(3);//descrip
                        Parametro parame = new Parametro();
                        String opconmodulo = "";
                        String perfil = "";
                        try {
                            parame.consultaG("select * from fqs_perfil where i_perfil=?", contd.elementAt(1));
                            if (parame.rs.first()) {
                                perfil = parame.rs.getString("c_nombre");
                            }
                            parame.consultaG("select * from fqs_opcionmodulo where i_opcionmodulo=?", contd.elementAt(2));
                            if (parame.rs.first()) {
                                opconmodulo = parame.rs.getString("c_nombre");
                            }
                        } catch (SQLException ex) {
                            java.util.logging.Logger.getLogger(JFormMD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        au.setid();
                        //au.setEvento("agrega permiso "+contd.elementAt(0) +" con el perfil "+perfil+" opcion modulo " + opconmodulo );
                        au.setEvento("Modificaci髇 de permisos perfil " + perfil + ": agrega permiso " + opconmodulo);
                        au.setResultado("Exitoso");
                        au.inserta();
                    }
                    //getWindow().showNotification(MSGEXITO_CREACION);
                    Notification.show(MSGEXITO_CREACION, Notification.Type.HUMANIZED_MESSAGE);
                    //getWindow().showNotification(NOMBRE_APLICACION, MSGEXITO_CREACION);
                    //Mantis 2168 Lsierra 2015-12-16
                    grillaDetalle.actualizaDatos();
                    posicionaGrilla(grillaDetalle, 1);
                } else {

                    if (tablaDetalle.getNombreTabla().equalsIgnoreCase("fqs_permiso")) {
                        Vector contd = new Vector();
                        contd = tablaDetalle.getContenido();
                        Auditoria au = new Auditoria();
                        contd.elementAt(0);//permiso
                        contd.elementAt(1);//perfil
                        contd.elementAt(2);//opcionmodulo
                        //Solicitud BVC Correo Martillo - Conclusiones reuni髇 16709/2015: Punto 2
                        //Lsierra 2015-09-23
                        //contd.elementAt(3);//hora inicio
                        //contd.elementAt(4);//hora fin
                        //contd.elementAt(5);//descrip
                        contd.elementAt(3);//descrip
                        Parametro parame = new Parametro();
                        String opconmodulo = "";
                        String perfil = "";
                        try {
                            parame.consultaG("select * from fqs_perfil where i_perfil=?", contd.elementAt(1));
                            if (parame.rs.first()) {
                                perfil = parame.rs.getString("c_nombre");
                            }
                            parame.consultaG("select * from fqs_opcionmodulo where i_opcionmodulo=?", contd.elementAt(2));
                            if (parame.rs.first()) {
                                opconmodulo = parame.rs.getString("c_nombre");
                            }
                        } catch (SQLException ex) {
                            java.util.logging.Logger.getLogger(JFormMD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        au.setid();
                        //au.setEvento("agrega permiso "+contd.elementAt(0) +" con el perfil "+perfil+" opcion modulo " + opconmodulo );
                        //au.setResultado("fallido");
                        au.setEvento("Modificaci髇 de permisos perfil " + perfil + ": agrega permiso " + opconmodulo);
                        au.setResultado("Fallido");
                        au.inserta();
                    }

                    if (existe) {
                        
                        Notification.show(MSGERROR_CREACION_PK + pk, Notification.Type.ERROR_MESSAGE);
                        //getWindow().showNotification, Notification.TYPE_ERROR_MESSAGE);
                        //getWindow().showNotification(NOMBRE_APLICACION, MSGERROR_CREACION_PK + pk, Notification.TYPE_ERROR_MESSAGE);
                        //Mantis 2168 Lsierra 2015-12-16
                    } else {
                        Notification.show(MSGERROR_CREACION, Notification.Type.ERROR_MESSAGE);
                         // getWindow().showNotification(MSGERROR_CREACION, Notification.TYPE_ERROR_MESSAGE);
                        //getWindow().showNotification(NOMBRE_APLICACION, MSGERROR_CREACION, Notification.TYPE_ERROR_MESSAGE);
                        //Mantis 2168 Lsierra 2015-12-16
                    }
                }  // actualizacion
            } catch (SQLException e) {
                logger.error("Error consultando llave primaria para detalle" + pk, e);
            } finally {
                DbUtil.closeResultSet(tablaDetalle.rs);
            }

        }
        agregandoDetalle = false;
        enFormaEdicionDetalle = false;
        consultarDetalle();
    }
    // } // valdiacion  del detalle

    /**
     * Agregar registro a tabla maestra y la deja en modo de edicion
     */
    private void agregarDetalle() {
        //Persistente nuevo = plantillaDetalle;  //  crea un nuevo javabena (con datos por defecto)       //********  CODIGO PLANTILLA  JSP a reemplazar con macro*********//

        logger.debug("OPA - " + "Clase de plantilla detalle: " + tablaDetalle.getClass().getName());
        Persistente nuevo = null;
        try {
            nuevo = tablaDetalle.getClass().newInstance();         // obtiene una instancia vacia del mismo javabean del maestro
        } catch (InstantiationException e) {
            logger.error(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
        }
        agregandoDetalle = true;
        posicionaGrilla(grillaDetalle, 1);
        tablaDetalle.setContenido(ajustaDatos(nuevo.getContenido(), tiposDetalle, longitudDetalle, nuevo.getPrecision()));  //carga el javabean temporal en actual (tabla) para su edicion)
        editarDetalle(Boolean.FALSE);
        enFormaEdicionDetalle = true;
        iFormaDetalle.setReadOnly(false);
        botonDeshacerD.setVisible(true);
        botonGuardarD.setVisible(true);
        botonAgregarD.setVisible(false);
        iFormaDetalle.requestRepaint();
        this.requestRepaintAll();     // en estudio si es necesario
    }

    @Override
    // ejecutado siempre antes del rendering - por en tiempo de contruccion no siempre se conoce el objeto app y derivados (windows)
    public void detach() {
        logger.debug("OPA - " + " ************ JFormFD detach ");
        if (tabla != null) {
            tabla.cerrarConexiones();
        }
        if (tablaDetalle != null) {
            tablaDetalle.cerrarConexiones();
        }
        //DbUtil.closeRecurso(tabla);
        //DbUtil.closeRecurso(tablaDetalle);
        super.detach(); // Must call.
    }

    public void cerrarConexiones() {
        tabla.cerrarConexiones();
        if (tablaDetalle == null) {
            tablaDetalle.cerrarConexiones();
        }
    }

    /**
     * Returna la posicion (fila) actual de la grilla enviada
     *
     * @param grilla
     * @return
     */
    int getActual(GrillaService grilla) {
        int act = 0;

        if (((Integer) grilla.getTable().getContainerDataSource().size()).intValue() > 0) {
            if (grilla.getTable().getValue() != null) {
                act = Integer.parseInt(grilla.getTable().getValue().toString().replace("[", "").replace("]", ""));
            } else {
                act = 0;
            }
            rActual.setValue(grilla.getTable().getValue() + " de " + grilla.getTable().getContainerDataSource().size());
        } else {
            act = 0;
            rActual.setValue("0" + " de " + grilla.getTable().getContainerDataSource().size());
        }
        if (act <= 0) {
            act = 1;
        }
        return act;
    }

    public void setcLayout(CustomLayout cLayout) {
        this.cLayout = cLayout;
    }

    public VerticalLayout getLayMaster() {
        return layMaster;
    }

    public VerticalLayout getLayDetalle() {
        return layDetalle;
    }

    public HorizontalLayout getBarraBotones() {
        return barraBotones;
    }

    public HorizontalLayout getBarraBotonesDetalle() {
        return barraBotonesDetalle;
    }

    public GrillaService getGrilla() {
        return grilla;
    }

    public GrillaService getGrillaDetalle() {
        return grillaDetalle;
    }

    public void setTituloMaestro(String tituloMaestro) {
        this.tituloMaestro = tituloMaestro;
    }

    public void setMisAlias(String[] misAlias) {
        this.misAlias = misAlias;
    }

    public void setMisTipos(String[] misTipos) {
        this.misTipos = misTipos;
    }

    public void setMiPresentacion(int[] miPresentacion) {
        this.miPresentacion = miPresentacion;
    }

    public void setLongitudMaestro(int[] longitudMaestro) {
        this.longitudMaestro = longitudMaestro;
    }

    public void setRequerido(int[] requerido) {
        this.requerido = requerido;
    }

    public void setTituloDetalle(String tituloDetalle) {
        this.tituloDetalle = tituloDetalle;
    }

    public void setAliasDetalle(String[] aliasDetalle) {
        this.aliasDetalle = aliasDetalle;
    }

    public void setTiposDetalle(String[] tiposDetalle) {
        this.tiposDetalle = tiposDetalle;
    }

    public void setPresentacionDetalle(int[] presentacionDetalle) {
        this.presentacionDetalle = presentacionDetalle;
    }

    public void setLongitudDetalle(int[] longitudDetalle) {
        this.longitudDetalle = longitudDetalle;
    }

    public void setRequeridoDetalle(int[] requeridoDetalle) {
        this.requeridoDetalle = requeridoDetalle;
    }

    public String getForma() {
        return forma;
    }

    public void setLlaveMaestro(Vector llaveMaestro) {
        this.llaveMaestro = llaveMaestro;
    }

    public void setLlaveDetalle(Vector llaveDetalle) {
        this.llaveDetalle = llaveDetalle;
    }

    public void setCombosMaestro(Vector combosMaestro) {
        this.combosMaestro = combosMaestro;
    }

    public void setTiposCombosMaestro(Vector tiposCombosMaestro) {
        this.tiposCombosMaestro = tiposCombosMaestro;
    }

    public void setValorCombosMaestro(Vector valorCombosMaestro) {
        this.valorCombosMaestro = valorCombosMaestro;
    }

    public void setCombosDetalle(Vector combosDetalle) {
        this.combosDetalle = combosDetalle;
    }

    public void setTiposCombosDetalle(Vector tiposCombosDetalle) {
        this.tiposCombosDetalle = tiposCombosDetalle;
    }

    public void setValorCombosDetalle(Vector valorCombosDetalle) {
        this.valorCombosDetalle = valorCombosDetalle;
    }

    public void setRadioMaestro(Vector radioMaestro) {
        this.radioMaestro = radioMaestro;
    }

    public void setTiposRadioMaestro(Vector tiposRadioMaestro) {
        this.tiposRadioMaestro = tiposRadioMaestro;
    }

    public void setRadioDetalle(Vector radioDetalle) {
        this.radioDetalle = radioDetalle;
    }

    public void setTiposRadioDetalle(Vector tiposRadioDetalle) {
        this.tiposRadioDetalle = tiposRadioDetalle;
    }

    public Persistente getTabla() {
        return tabla;
    }

    public void setTabla(Persistente tabla) {
        this.tabla = tabla;
    }

    public Persistente getTablaDetalle() {
        return tablaDetalle;
    }

    public void setTablaDetalle(Persistente tablaDetalle) {
        this.tablaDetalle = tablaDetalle;
    }

    public void setColsGrilla(int colsGrilla) {
        //this.colsGrilla = colsGrilla;
        this.colsGrilla = tabla.getElementos();
    }

    public int getColsGrilla() {
        return colsGrilla;
    }

    public String[] obtienePkMaestro() {
        String[] props = tabla.getAtributos();
        String[] pk = new String[tabla.getAtributosLLave().size()];
        tabla.inicializar();
        int actual = getActual(grilla);

        if (llaveMaestro != null) {         //SMJ2
            for (int i = 0; i < tabla.getAtributosLLave().size(); i++) {
                String CampoLlaveMaestra = llaveMaestro.get(i).toString();
                if (grilla.getTable().getItem(actual).getItemProperty(CampoLlaveMaestra).getValue().toString().contains("|")) {
                    StringTokenizer a = new StringTokenizer(grilla.getTable().getItem(actual).getItemProperty(CampoLlaveMaestra).getValue().toString(), "|");

                    pk[i] = Utiles.retiraFormatoMiles(a.nextToken()); // obtiene el valor de la llave maestra
                } else {
                    pk[i] = Utiles.retiraFormatoMiles(grilla.getTable().getItem(actual).getItemProperty(CampoLlaveMaestra).getValue().toString());
                }
            }
        } else {

            for (int i = 0; i < tabla.getAtributosLLave().size(); i++) {
                if (grilla.getTable().getItem(actual).getItemProperty(props[i]).getValue().toString().contains("|")) {
                    StringTokenizer a = new StringTokenizer(grilla.getTable().getItem(actual).getItemProperty(props[i]).getValue().toString(), "|");
                    pk[i] = Utiles.retiraFormatoMiles(a.nextToken()); // obtiene el valor de la llave maestra
                } else {

                }
                pk[i] = Utiles.retiraFormatoMiles(grilla.getTable().getItem(actual).getItemProperty(props[i]).getValue().toString());
            }

        }

        logger.debug("OPA - " + "PK=" + StringUtils.arrayToDelimitedString(pk, " ") + "-actual=" + actual);
        return pk;
    }

    private Vector ajustaDatos(Vector entrada, String[] misTipos, int[] longitud, int[] precision) {
        Vector resultado = new Vector();

        for (int i = 0; i < entrada.size(); i++) {
            int preci = 0;
            if (precision != null) {
                if (i < precision.length) {
                    preci = precision[i];
                }
            }
            resultado.add(Utiles.formateaDatos(entrada.elementAt(i), misTipos[i], null, longitud[i], null, preci));
        }
        return resultado;
    }

    public void setAliasFormatter(String alias, CampoFormatter formatter) {
        if (this.aliasFormatters == null) {
            this.aliasFormatters = new HashMap<String, CampoFormatter>(2);
        }
        this.aliasFormatters.put(alias, formatter);
    }

    protected CampoFormatter obtainCampoFormatter(String tituloCampo) {
        if (this.aliasFormatters == null || !this.aliasFormatters.containsKey(tituloCampo)) {
            return new DefaultCampoFormatter();
        }
        return this.aliasFormatters.get(tituloCampo);
    }

    public void setShowColumnsListaBD(boolean listaBD) {
        this.showColumnsListaBD = listaBD;
    }

    public boolean getShowColumnsListaBD() {
        return this.showColumnsListaBD;
    }

    public void setShowColumnsListaFija(boolean listaFija) {
        this.showColumnsListaFija = listaFija;
    }

    public boolean getShowColumnsListaFija() {
        return this.showColumnsListaFija;
    }

    public void setShowColumnsListaBDDetalle(boolean listaBD) {
        this.showColumnsListaBDDetalle = listaBD;
    }

    public boolean getShowColumnsListaBDDetalle() {
        return this.showColumnsListaBDDetalle;
    }

    public void setShowColumnsListaFijaDetalle(boolean listaFija) {
        this.showColumnsListaFijaDetalle = listaFija;
    }

    public boolean getShowColumnsListaFijaDetalle() {
        return this.showColumnsListaFijaDetalle;
    }

}
