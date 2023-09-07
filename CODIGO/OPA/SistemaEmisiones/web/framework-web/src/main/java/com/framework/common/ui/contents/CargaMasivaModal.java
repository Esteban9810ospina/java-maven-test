/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.contents;

import com.framework.common.service.security.MyUserDetailsService;
import com.framework.common.ui.util.AppConstants;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import org.vaadin.dialogs.ConfirmDialog;
import com.framework.common.ui.util.ValidarCampos;
import com.quasar.frameq.db.Facade;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.jboss.util.stream.NullOutputStream;
import org.mozilla.universalchardet.UniversalDetector;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.quasar.frameq.data.SCB;
import com.quasar.frameq.fachadas.FacadeParametros;
import java.io.BufferedInputStream;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Cristian
 */
public class CargaMasivaModal extends Window {

    private static final Logger logger = Logger.getLogger(CargaMasivaModal.class.getName());
    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest req = attr.getRequest();
    HttpSession session = req.getSession();
    Facade fachada = new Facade();
    ValidarCampos validar = new ValidarCampos();
    String rutaCargue = fachada.rutaCargueMasivo();
    int maxRegistro = fachada.limiteCargaMasiva();
    File OriginalFile;
    Button btnDescargar = new Button("Descargar");
    File ModFile;
    FileDownloader fd;
    Upload upload;
    Panel panelgrilla = new Panel();
    Panel panelfiltros = new Panel();
    Panel panelPaginacion = new Panel();
    GridLayout gridFiltros = new GridLayout(4, 3);
    HorizontalLayout HLFiltros = new HorizontalLayout();
    IndexedContainer ic;
    String archivoDescarga = "";
    ProgressBar progressBar = new ProgressBar();
    Label progreso = new Label("");
    long contentLenght;
    long BytesperLinea;
    HorizontalLayout hlProgress = new HorizontalLayout();
    HorizontalLayout hlejemplo = new HorizontalLayout();
    WorkThread worker;
    WorkThreadProcessFile workerProcessFile;
    Integer idDetailsService;
    String userNameDetailsService;
    public static final String UTF8_BOM = "\uFEFF";//EF BB BF
    String nombreArchivo = "";
    String opa = "";
    File pathArchivos;
    String nomArchRuta = "";
    boolean archi = false;
    boolean consecutivo = false;
    String ano = "";
    String mesArchivo = "";
    String diaArchivo = "";
    String fechArchivo = "";
    String part1 = "";
    String numero = "";
    String numArch1 = "";
    int cadena = 0;
    int año = 0;
    int mes = 0;
    int dia = 0;
    int caracteres = 0;
    int numeroInt = 0;

    TextField txtnombreArchivo;
    TextField txthora;
    PopupDateField popudatefecha;

    PagedTableCustomscb tabla;
    IndexedContainer ic1;

    String regexhora = "^[0-9\\:]*$";
    String regexnombre = "^[0-9-A-Z-a-z\\_\\.]*$";

    //Consultar parametros para condiciones de aceptacion-Sandia
    FacadeParametros parametros = new FacadeParametros();
    String texto1 = "";
    String texto2 = "";
    String tipoOfertaPublica = "";
    int tipoPagoParametrizado = 0;
    boolean paramDireccionActivated = false;

    List<String> parametrosP = null;
    boolean condicion1 = false;
    boolean condicion2 = false;
    
    Window modalWait;
    

    @Override
    public void close() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        try {
            UI.getCurrent().removeWindow(this);
        } catch (Exception ex) {
            logger.error("OPA - " + CargaMasivaModal.class.getName(), ex);
        }
    }

    public CargaMasivaModal(final MyUserDetailsService userDetailsService) {
        super("Carga Masiva Aceptaciones");
        super.center();
        super.setClosable(true);
        super.setModal(true);

        idDetailsService = userDetailsService.getUsuarioAutenticado().getId();
        userNameDetailsService = userDetailsService.getUsuarioAutenticado().getUsername();
        VerticalLayout vlPadre = new VerticalLayout();
        HorizontalLayout hlupload = new HorizontalLayout();

        java.util.Calendar fechahoy = new java.util.GregorianCalendar();

        año = fechahoy.get(java.util.Calendar.YEAR);
        mes = fechahoy.get(java.util.Calendar.MONTH) + 1;
        dia = fechahoy.get(java.util.Calendar.DAY_OF_MONTH);
        
        parametrosP = fachada.RetornaParametros();
        tipoOfertaPublica = parametrosP.get(41);
           
        upload = new Upload(null, new Upload.Receiver() {

            @Override
            public OutputStream receiveUpload(String filename, String mimeType) {
                PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
                try {
                    File dir = new File(rutaCargue.concat("//" + userDetailsService.getUsuarioAutenticado().getUsername()));
                    String ruta = dir.getPath();
                    if (!dir.exists()) {
                        try {
                            dir.mkdir();
                            dir = new File(ruta.concat("//") + "Original");
                            dir.mkdir();
                            dir = new File(ruta.concat("//") + "Modificado");
                            dir.mkdir();                            
                        } catch (SecurityException ex) {
                            logger.error("OPA - " + CargaMasivaModal.class.getName(), ex);
                        }
                    }
                    int dot = filename.split("\\.").length - 1;
                    if (filename.split("\\.")[dot].equals("txt")) {
                        OriginalFile = new File(ruta, "Original//" + filename);
                        return new FileOutputStream(OriginalFile);
                    } else {
                        upload.interruptUpload();
                        return new NullOutputStream();
                    }
                } catch (IOException ex) {
                    logger.error("OPA - " + CargaMasivaModal.class.getName(), ex);
                    upload.interruptUpload();
                    return new NullOutputStream();
                }
            }
        });

        upload.addStartedListener(new Upload.StartedListener() {

            @Override
            @SuppressWarnings("CallToPrintStackTrace")
            public void uploadStarted(Upload.StartedEvent event) {
                Date dNow = new Date();
                String horario = validar.fechaIngresoCarga();
                boolean moduloCm = validar.validarEstadoCargaMasiva();
                if (!moduloCm) {
                    ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
                    cd.setWidth("400px");
                    cd.setHeight("160px");
                    HorizontalLayout texto = new HorizontalLayout();
                    HorizontalLayout buttons = new HorizontalLayout();
                    buttons.setStyleName("btnAceptar");
                    Label lblmensaje = new Label("La funcionalidad de carga masiva no está habilitada para esta operación.", ContentMode.HTML);
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

                } else if (!horario.equals("")) {
                    ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
                    cd.setWidth("400px");
                    cd.setHeight("200px");
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
                            upload.interruptUpload();
                        }
                    }, true);
                    upload.interruptUpload();
                    progressBar.setValue(0f);
                    progressBar.setVisible(true);
                    progressBar.setImmediate(true);
                } else if (!event.getFilename().equals("")) {
                    int dot = event.getFilename().split("\\.").length - 1;
                    if (!event.getFilename().split("\\.")[dot].equals("txt")) {
                        ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
                        cd.setWidth("448px");
                        cd.setHeight("150px");
                        HorizontalLayout texto = new HorizontalLayout();
                        HorizontalLayout buttons = new HorizontalLayout();
                        buttons.setStyleName("btnAceptar");
                        Label lblmensaje = new Label("Formato de archivo no valido", ContentMode.HTML);
                        texto.addComponent(lblmensaje);
                        buttons.addComponent(cd.getOkButton());
                        VerticalLayout content = new VerticalLayout(lblmensaje, buttons);
                        content.setStyleName("verticalDialog");
                        content.setSizeFull();
                        content.setSpacing(true);
                        cd.setContent(content);
                        cd.show(getUI(), new ConfirmDialog.Listener() {
                            @Override
                            public void onClose(ConfirmDialog cd) {
                            }
                        }, true);
                        try {
                            upload.interruptUpload();
                        } catch (Exception e) {
                            throw new RuntimeException("No se cargo el archivo de carga masiva", e);
                        }
                    } else {
                    }
                    /*Nuevas validaciones del archivo de carga masiva Lsierra 2016-04-21*/
                    nombreArchivo = event.getFilename();
                    String[] parts = nombreArchivo.split("_");
                    String part1 = parts[0];
                    caracteres = part1.length();
                    if (nombreArchivo.length() != 17) {
                        mensaje();

                    } else {
                        /*Validar ###: debe ser un número entre 000 y 999*/
                        try {
                            numero = nombreArchivo.substring(10, 13);
                            String[] parts1 = nombreArchivo.split("\\.");
                            String part = parts1[0];
                            String[] parts2 = part.split("_");
                            numArch1 = parts2[1];

                            numeroInt = Integer.parseInt(numArch1);
                            consecutivo = true;

                        } catch (NumberFormatException nfe) {
                            nfe.printStackTrace();
                            consecutivo = false;
                        } catch (ArrayIndexOutOfBoundsException excepcion) {
                            logger.error("OPA - " + CargaMasivaModal.class.getName(), excepcion);
                            // Logger.getLogger(CargaMasivaModal.class.getName()).log(Level.SEVERE, "Error ejecutando el Query", excepcion);
                        }

                        if (numArch1.length() < 3 || numArch1.length() > 3) {
                            mensajeConsecutivo();

                        } else if (!consecutivo) {
                            mensajeConsecutivo();
                        } else if (numeroInt <= 000 && numeroInt >= 999) {
                            mensajeConsecutivo();
                        } else {
                            /*Validar la estructura del archivo inicie con el Nombre OPA*/
                            opa = nombreArchivo.substring(0, 3);
                            
                            if (!opa.equalsIgnoreCase(tipoOfertaPublica)) {
                                mensaje();
                            } else {
                                /*Validar el año*/
                                ano = nombreArchivo.substring(3, 5);
                                @SuppressWarnings("UnusedAssignment")
                                String año2 = "";
                                año2 = String.valueOf(año);
                                String año3 = año2.substring(2, 4);
                                if (!ano.equals(año3)) {
                                    mensajeFecha();
                                } else {
                                    try {
                                        mesArchivo = nombreArchivo.substring(5, 7);
                                        cadena = Integer.parseInt(mesArchivo);
                                    } catch (NumberFormatException nfe) {
                                        nfe.printStackTrace();
                                    }
                                    if (cadena != mes) {
                                        mensajeFecha();
                                    } else {
                                        try {
                                            diaArchivo = nombreArchivo.substring(7, 9);
                                            cadena = Integer.parseInt(diaArchivo);
                                        } catch (NumberFormatException nfe) {
                                            nfe.printStackTrace();
                                        }
                                        if (cadena != dia) {
                                            mensajeFecha();
                                        } else {
                                            /*Validar que la fecha del archivo sea igual a la fecha de operacion*/
                                            fechArchivo = part1.substring(3);
                                            SimpleDateFormat ft = new SimpleDateFormat("yyMMdd");
                                            String fechacreacion = ft.format(dNow);
                                            if (!fechArchivo.equals(fechacreacion)) {
                                                mensajeFecha();
                                            } else {
                                                pathArchivos = new File(rutaCargue, userNameDetailsService.concat("//Modificado"));
                                                if (pathArchivos == null) {
                                                } else {
                                                    try {
                                                        archi = false;
                                                        File[] ficheros = pathArchivos.listFiles();
                                                        for (int x = 0; x < ficheros.length; x++) {
                                                            nomArchRuta = ficheros[x].getName();
                                                            if (nomArchRuta.equals(nombreArchivo)) {
                                                                archi = true;
                                                            }
                                                        }
                                                    } catch (SecurityException ex) {
                                                        logger.error("OPA - " + CargaMasivaModal.class.getName(), ex);
                                                    } catch (NullPointerException e) {
                                                        logger.error("OPA - " + CargaMasivaModal.class.getName(), e);
                                                    }
                                                }
                                                if (archi == true) {
                                                    ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
                                                    cd.setWidth("448px");
                                                    cd.setHeight("150px");
                                                    HorizontalLayout texto = new HorizontalLayout();
                                                    HorizontalLayout buttons = new HorizontalLayout();
                                                    buttons.setStyleName("btnAceptar");
                                                    Label lblmensaje = new Label("El sistema ya ha procesado un archivo con el mismo nombre, por favor modifíquelo", ContentMode.HTML);
                                                    texto.addComponent(lblmensaje);
                                                    buttons.addComponent(cd.getOkButton());
                                                    VerticalLayout content = new VerticalLayout(lblmensaje, buttons);
                                                    content.setStyleName("verticalDialog");
                                                    content.setSizeFull();
                                                    content.setSpacing(true);
                                                    cd.setContent(content);
                                                    cd.show(getUI(), new ConfirmDialog.Listener() {
                                                        @Override
                                                        public void onClose(ConfirmDialog cd) {
                                                        }
                                                    }, true);
                                                    try {
                                                        upload.interruptUpload();
                                                    } catch (Exception e) {
                                                        throw new RuntimeException("No se cargo el archivo de carga masiva", e);
                                                    }
                                                } else {
                                                    progressBar.setValue(0f);
                                                    progressBar.setVisible(true);
                                                    progressBar.setImmediate(true);
                                                    UI.getCurrent().setPollInterval(500);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
                    cd.setWidth("448px");
                    cd.setHeight("150px");
                    HorizontalLayout texto = new HorizontalLayout();
                    HorizontalLayout buttons = new HorizontalLayout();
                    buttons.setStyleName("btnAceptar");
                    Label lblmensaje = new Label("Debe seleccionar un archivo", ContentMode.HTML);
                    texto.addComponent(lblmensaje);
                    buttons.addComponent(cd.getOkButton());
                    VerticalLayout content = new VerticalLayout(lblmensaje, buttons);
                    content.setStyleName("verticalDialog");
                    content.setSizeFull();
                    content.setSpacing(true);
                    cd.setContent(content);
                    cd.show(getUI(), new ConfirmDialog.Listener() {
                        @Override
                        public void onClose(ConfirmDialog cd) {
                        }
                    }, true);
                    try {
                        upload.interruptUpload();
                    } catch (Exception e) {
                        throw new RuntimeException("No se cargo el archivo de carga masiva", e);
                    }
                }
            }
        });

        upload.addProgressListener(new Upload.ProgressListener() {

            @Override
            public void updateProgress(long readBytes, long contentLength) {
                progressBar.setValue(readBytes / (float) contentLength);
            }
        });

        upload.addSucceededListener(new Upload.SucceededListener() {

            @Override
            public void uploadSucceeded(Upload.SucceededEvent event) {
                progressBar.setValue(0f);
                BufferedReader br = null;
                BufferedReader detectorReader = null;
                int _o = -1;
                try {
                    detectorReader = new BufferedReader(new InputStreamReader(new FileInputStream(OriginalFile), "UTF8"));
                    if(!detectarBOM(detectorReader,OriginalFile))
                        throw new Exception(); 
                    
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(OriginalFile), "UTF8"));
                    while (br.readLine() != null) {
                        _o++;
                        if (_o > maxRegistro) {
                            Notification.show("No es posible cargar el archivo, "
                                    + "debido a que supera el máximo de aceptaciones permitidas.", Notification.Type.ERROR_MESSAGE);
                            break;
                        }
                    }
                    if (!(_o > maxRegistro)) {
                        int dot = event.getFilename().split("\\.").length - 1;
                        if (event.getFilename().split("\\.")[dot].equals("txt")) {
                            ModFile = new File(rutaCargue.concat("//" + userDetailsService.getUsuarioAutenticado().getUsername()), "//Modificado//".concat(event.getFilename()));
                            worker = new WorkThread();
                            worker.start();
                            progressBar.setValue(0f);
                        }
                    }
                } catch (Exception ex) {
                    progressBar.setValue(0f);
                    upload.interruptUpload();
                    Notification.show("El archivo cargado no cuenta con la codificación requerida (UTF-8).",
                            Notification.Type.ERROR_MESSAGE);
                }
            }
        });

        ic = new IndexedContainer();

        ic.addContainerProperty("Nombre del Archivo", String.class, null);
        ic.addContainerProperty("Fecha y Hora de procesamiento", String.class, null);
        ic.addContainerProperty("Tamaño", String.class, null);

        tabla = new PagedTableCustomscb("");
        tabla.setContainerDataSource(ic);

        tabla.setColumnAlignment("Nombre del Archivo", Table.Align.LEFT);
        tabla.setColumnAlignment("Fecha y Hora de procesamiento", Table.Align.LEFT);
        tabla.setColumnAlignment("Tamaño", Table.Align.LEFT);

        traerArchivos();

        tabla.setSizeFull();
        tabla.setColumnReorderingAllowed(false);
        tabla.setFooterVisible(true);

        tabla.addValueChangeListener(new Property.ValueChangeListener() {
            public void valueChange(ValueChangeEvent event) {

                int numeroElementSelectionne = 0;

                Object selectedRow = tabla.getValue();
                if (fd != null) {
                    fd.remove();
                }
                if (selectedRow != null) {
                    try {
                        numeroElementSelectionne = (Integer) tabla.getValue();
                    } catch (NullPointerException ex) {
                        numeroElementSelectionne = 0;
                    }

                    try {
                        archivoDescarga = tabla.getContainerDataSource().getItem(numeroElementSelectionne)
                                .getItemProperty("Nombre del Archivo").toString();
                    } catch (Exception ex) {
                        archivoDescarga = "";
                    } finally {
                        descargarArchivo(archivoDescarga);
                    }

                } else {
                    numeroElementSelectionne = 0;
                    fd = null;
                }

            }
        });

        upload.setStyleName("component-upload");
        upload.setButtonCaption("Cargar");
        hlupload.addComponent(upload);
        progreso.setStyleName("lblProgreso");
        hlProgress.addComponents(progressBar, progreso);

        HorizontalLayout vlCab = new HorizontalLayout();
        vlCab.setWidth("40%");
        Label lbltitulo = new Label("Historial de Archivos cargados");
        lbltitulo.setWidthUndefined();
        lbltitulo.setStyleName("tituloInversionistatit");
        Embedded image = new Embedded(null, new ThemeResource("img/Inver.png"));
        image.setHeight("35px");
        image.setStyleName("InverImg");
        vlCab.addStyleName("tituloInversionista");
        vlCab.addComponents(image, lbltitulo);
        vlCab.setComponentAlignment(lbltitulo, Alignment.MIDDLE_CENTER);

        //*Filtros*//
        gridFiltros.setSpacing(true);
        HLFiltros.setSpacing(true);
        gridFiltros.setWidth(98, Sizeable.Unit.PERCENTAGE);
        //*Nombre del Archivo*//
        Label lblnombre = new Label("Nombre del archivo");
        gridFiltros.addComponent(lblnombre, 0, 0);
        gridFiltros.setComponentAlignment(lblnombre, Alignment.MIDDLE_CENTER);
        lblnombre.setWidth(9, Sizeable.Unit.EM);
        lblnombre.setHeight(2, Sizeable.Unit.EM);

        //*Caja de Texto*//        
        txtnombreArchivo = new TextField();
        gridFiltros.addComponent(txtnombreArchivo, 1, 0);
        gridFiltros.setComponentAlignment(txtnombreArchivo, Alignment.MIDDLE_LEFT);
        txtnombreArchivo.setWidth(12, Sizeable.Unit.EM);
        txtnombreArchivo.setHeight(2, Sizeable.Unit.EM);

        //*Fecha de Procesamiento *//
        Label lblfecha = new Label("Fecha de Procesamiento");
        gridFiltros.addComponent(lblfecha, 2, 0);
        gridFiltros.setComponentAlignment(lblfecha, Alignment.MIDDLE_RIGHT);
        lblfecha.setWidth(11, Sizeable.Unit.EM);
        lblfecha.setHeight(2, Sizeable.Unit.EM);

        //*caja fecha **//
        popudatefecha = new PopupDateField();
        popudatefecha.setDateFormat("dd/MM/yyyy");
        popudatefecha.setTextFieldEnabled(false);
        gridFiltros.addComponent(popudatefecha, 3, 0);
        gridFiltros.setComponentAlignment(popudatefecha, Alignment.MIDDLE_CENTER);
        popudatefecha.setWidth(9, Sizeable.Unit.EM);
        popudatefecha.setHeight(2, Sizeable.Unit.EM);

        //*Hora de Procesamiento*//
        Label lblhora = new Label("Hora de Procesamiento");
        gridFiltros.addComponent(lblhora, 1, 1);
        gridFiltros.setComponentAlignment(lblhora, Alignment.MIDDLE_RIGHT);
        lblhora.setWidth(11, Sizeable.Unit.EM);
        lblhora.setHeight(2, Sizeable.Unit.EM);

        //*Caja de Texto*//        
        txthora = new TextField();
        gridFiltros.addComponent(txthora, 2, 1);
        gridFiltros.setComponentAlignment(txthora, Alignment.MIDDLE_LEFT);
        txthora.setWidth(7, Sizeable.Unit.EM);
        txthora.setHeight(2, Sizeable.Unit.EM);

        //Botones//
        VerticalLayout vl = new VerticalLayout();
        Button btnFiltar = new Button("Filtrar");
        Button btnLimpiar = new Button("Limpiar");
        HLFiltros.addComponents(btnFiltar, btnLimpiar);
        vl.addComponents(HLFiltros);
        HLFiltros.addStyleName("horizontal1");
        panelfiltros.setWidth(100, Sizeable.Unit.PERCENTAGE);
        panelfiltros.setContent(gridFiltros);

        btnLimpiar.addClickListener(new Button.ClickListener() {
            public void buttonClick(final Button.ClickEvent event) {
                limpiarCampos();
                traerArchivos();
            }
        });

        btnFiltar.addClickListener(new Button.ClickListener() {
            public void buttonClick(final Button.ClickEvent event) {

                String fechProcesamiento = "";
                String nombreArchivo = "";
                String hora = "";
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date Fecha = null;

                ///Hora
                try {

                    if (txthora.getValue().matches(regexhora)) {
                        hora = txthora.getValue();
                    } else {
                        hora = "00:00:00";
                        Notification.show("Hora Inválida", Notification.Type.ERROR_MESSAGE);
                    }

                } catch (Exception e) {
                    hora = "";
                    Notification.show("Hora Inválida", Notification.Type.ERROR_MESSAGE);
                }

                //Nombre del Archivo
                try {

                    if (txtnombreArchivo.getValue().matches(regexnombre)) {
                        nombreArchivo = txtnombreArchivo.getValue();
                    } else {
                        nombreArchivo = "XXX";
                        Notification.show("Caracteres inválidos", Notification.Type.ERROR_MESSAGE);
                    }

                } catch (Exception e) {
                    nombreArchivo = "";
                    Notification.show("Caracteres inválidos", Notification.Type.ERROR_MESSAGE);
                }

                //Fecha de procesamiento
                try {
                    fechProcesamiento = df.format(popudatefecha.getValue());
                } catch (Exception e) {
                    fechProcesamiento = "";
                }

                try {
                    Fecha = df.parse(fechProcesamiento);

                } catch (Exception e) {
                    fechProcesamiento = "";
                }

                tabla.getContainerDataSource().removeAllItems();
                File pathArchivos = new File(rutaCargue, userNameDetailsService.concat("//Modificado"));

                File[] archivos = pathArchivos.listFiles();

                archivos = pathArchivos.listFiles(new Filtro(nombreArchivo, hora, fechProcesamiento));

                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (archivos != null) {
                    Arrays.sort(archivos, LastModifiedFileComparator.LASTMODIFIED_REVERSE);

                    for (int i = 0; i < archivos.length; i++) {

                        File archivo = archivos[i];
                        Item item = ic.addItem(i);

                        item.getItemProperty("Nombre del Archivo").setValue(archivo.getName());
                        item.getItemProperty("Fecha y Hora de procesamiento").setValue(ft.format(archivo.lastModified()));
                        item.getItemProperty("Tamaño").setValue(String.valueOf(archivo.length() / 1024) + " KB");

                    }
                }
                tabla.setContainerDataSource(ic);
                panelgrilla.setImmediate(true);

            }
        });

        panelgrilla.setSizeFull();
        panelgrilla.setWidth(100, Sizeable.Unit.PERCENTAGE);
        panelgrilla.setContent(tabla);
        panelgrilla.setWidth("99%");
        panelgrilla.setHeight("75%");
        //panelPaginacion.setSizeFull();
        //panelPaginacion.setWidth(100,Sizeable.Unit.PERCENTAGE);  
        panelPaginacion.setContent(tabla.createControls());
        Label lblDescarga = new Label("Descargue un archivo de ejemplo con <br>"
                + "la estructura de carga masiva ", ContentMode.HTML);
        lblDescarga.setStyleName("lblDescarga");
        Button btnEjemplo = new Button("ArchivoEjemplo.txt");
        btnEjemplo.setStyleName("link-Button");

        try {
            int hayParametrizacion = fachada.validaHayParametros();
            if (hayParametrizacion == 1) {

                texto1 = parametrosP.get(39);
                texto2 = parametrosP.get(40);
                if (parametrosP.get(43).equals("1")) {
                    paramDireccionActivated = Boolean.TRUE;
                }
                if (tipoOfertaPublica.equals(AppConstants.OPI_OPERATION)) {
                    tipoPagoParametrizado = Integer.parseInt(parametrosP.get(42));
                }
            } else {
                throw new RuntimeException("No se ha hecho ninduna parametrización");
            }
            String archivo="";
             if(("OPA").equals(tipoOfertaPublica)){
                archivo="ArchivoEjemploOpa.txt";
            }else{
                archivo="ArchivoEjemploOpi.txt";
            }
            Resource res = new FileResource(new File(rutaCargue, "//" + archivo));
            FileDownloader ejemplo = new FileDownloader(res);
            ejemplo.extend(btnEjemplo);
        } catch (Exception ex) {
            Notification.show("No se encuentra el archivo de Ejemplo", Notification.Type.ERROR_MESSAGE);
        }
        hlejemplo.setStyleName("Horizontal-EjemploDescarga");
        hlejemplo.addComponents(lblDescarga, btnEjemplo);
        vlPadre.setStyleName("v-upload");
        vlPadre.addComponents(hlupload, hlProgress, vlCab, panelfiltros, HLFiltros, panelgrilla, panelPaginacion, btnDescargar, hlejemplo);
        vlPadre.setComponentAlignment(hlupload, Alignment.MIDDLE_CENTER);
        vlPadre.setComponentAlignment(hlProgress, Alignment.MIDDLE_CENTER);
        vlPadre.setComponentAlignment(vlCab, Alignment.MIDDLE_CENTER);
        vlPadre.setComponentAlignment(panelfiltros, Alignment.MIDDLE_CENTER);
        vlPadre.setComponentAlignment(panelgrilla, Alignment.MIDDLE_CENTER);
        vlPadre.setComponentAlignment(panelPaginacion, Alignment.MIDDLE_CENTER);
        vlPadre.setComponentAlignment(btnDescargar, Alignment.MIDDLE_CENTER);
        vlPadre.setComponentAlignment(hlejemplo, Alignment.MIDDLE_CENTER);
        vlPadre.setSpacing(true);
        setContent(vlPadre);
    }

    public void traerArchivos() {
        tabla.getContainerDataSource().removeAllItems();
        File pathArchivos = new File(rutaCargue, userNameDetailsService.concat("//Modificado"));
        File[] archivos = pathArchivos.listFiles();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (archivos != null) {
            Arrays.sort(archivos, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
            for (int i = 0; i < archivos.length; i++) {
                File archivo = archivos[i];
                Item item = ic.addItem(i);
                item.getItemProperty("Nombre del Archivo").setValue(archivo.getName());
                item.getItemProperty("Fecha y Hora de procesamiento").setValue(ft.format(archivo.lastModified()));
                item.getItemProperty("Tamaño").setValue(String.valueOf(archivo.length() / 1024) + " KB");
            }
        }
        tabla.setContainerDataSource(ic);
        tabla.setImmediate(true);
    }

    public void descargarArchivo(String archivo) {
        if (!archivo.equals("")) {
            String ruta = rutaCargue + "//" + userNameDetailsService.concat("//Modificado");
            Resource res = new FileResource(new File(ruta, archivo));
            fd = new FileDownloader(res);
            fd.extend(btnDescargar);
        }
    }

    private String getEncoding(UniversalDetector detector) {
        String charset = "";
        if (detector.isDone()) {
            charset = detector.getDetectedCharset();
        }else{
            System.out.println("Detector is not done...");
        }
        return charset;
    }

    private void handleData(FileInputStream fis, UniversalDetector detector) throws IOException {
        int nread;
        final byte[] buf = new byte[4096];
        while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
            detector.handleData(buf, 0, nread);
        }
        detector.dataEnd();
    }

    public class WorkThreadProcessFile extends Thread {
        
        @Override
        public void run() {
        contentLenght = 0;
        BytesperLinea = 0;
        BufferedReader br = null;
        BufferedWriter bw = null;
        BufferedReader brAnsi = null;
        UI.getCurrent().setPollInterval(500);
        contentLenght = OriginalFile.length();
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechacreacion = ft.format(dNow);

        String datosSCB = fachada.RetornarSCBusu(idDetailsService);
        String[] resultSCB = datosSCB.split(";");
        String[] parametros = fachada.RetornarDatosPara();

        //REPRESENTANTE LEGAL 
        String nombrerep = "";
        SCB Lrep1 = new SCB();
        Lrep1.cerrarConexiones();
        Lrep1 = fachada.cargarRepresentante(String.valueOf(resultSCB[0]));

        String nombredoc = Lrep1.getNombredocr();
        String nombredoc1 = Lrep1.getNombredoc1();
        String nombredoc2 = Lrep1.getNombredoc2();
        String nomrep = Lrep1.getRepresentante();
        String nomrep1 = Lrep1.getRepresentante1();
        String nomrep2 = Lrep1.getRepresentante2();

        try {
            String CurrentLine;
            String LineAnsi;
            br = new BufferedReader(new InputStreamReader(new FileInputStream(OriginalFile), "UTF8"));
            brAnsi = new BufferedReader(new FileReader(OriginalFile));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ModFile), "UTF8"));
            String rcontrol = "";
            Boolean existeControl = false;
            Boolean guardar = true;
            int cantRegistros = 0;
            Double acciones = 0.0;
            //Validar Archivo


            //Call to populate Map with document types:
            validar.populateDocumentTypes();

            int counter = 1;

            while ((CurrentLine = br.readLine()) != null && (LineAnsi = brAnsi.readLine()) != null) {
                String cadena = "";
                String result = validar.ValidacionRegistro(CurrentLine, String.valueOf(resultSCB[0]), tipoOfertaPublica, tipoPagoParametrizado, paramDireccionActivated);
                byte[] bit = LineAnsi.getBytes();
                BytesperLinea += bit.length;
                if (CurrentLine.split(";").length == 2) {
                    existeControl = true;
                    rcontrol = validar.registroControl(CurrentLine, cantRegistros, acciones);
                    if (!rcontrol.equals("")) {
                        guardar = false;
                        bw.write(CurrentLine + ";" + rcontrol);
                    }
                } else {
                    if (!result.equals("Validación correcta: registro no cargado. ")) {
                        guardar = false;
                    }
                    try {
                        acciones += Double.parseDouble(CurrentLine.split(";")[3]);
                    } catch (Exception ex) {
                        acciones = 0.0;
                    }
                    bw.write(CurrentLine + ";" + result);
                    bw.newLine();
                    cantRegistros++;
                }
                synchronized (UI.getCurrent()) {
                    processed("Validación del archivo. ");
                }
                //logger.info("Terminó de validar línea: " + counter );
                counter++;
            }
            if (!existeControl) {
                Notification.show("El archivo no posee registro de control", Notification.Type.ERROR_MESSAGE);
                return;
            }
                
            if (guardar) {
                BytesperLinea = 0;
                br = new BufferedReader(new InputStreamReader(new FileInputStream(OriginalFile), "UTF8"));
                brAnsi = new BufferedReader(new FileReader(OriginalFile));
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ModFile), "UTF8"));

                
                while ((CurrentLine = br.readLine()) != null && (LineAnsi = brAnsi.readLine()) != null) {
                    if (!(CurrentLine.split(";").length == 2)) {
                        String[] registros = CurrentLine.split(";");
                        String preacuerdo = "";
                        
                        /*Existe Preacuerdo*/
                        if (registros[2].trim().equalsIgnoreCase("S")) {
                            preacuerdo = "1";
                        } else if (registros[2].trim().equalsIgnoreCase("N")) {
                            preacuerdo = "2";
                        } else {
                            preacuerdo = null;
                        }
                                             
                        Integer todoNada = 0;
                        if (registros[1].trim().equalsIgnoreCase("S")) {
                            todoNada = 1;
                        } else if (registros[1].trim().equalsIgnoreCase("N")) {
                            todoNada = 0;
                        } else {
                            todoNada = null;
                        }

                        Double porcentajeComision = 0.0;
                        if (registros.length > 11) {
                            if (registros[11].trim().length() > 0) {
                                porcentajeComision = Double.parseDouble(registros[11].replace(",", ".").trim());
                            } else {
                                porcentajeComision = 0.0;
                            }
                        } else {
                            porcentajeComision = 0.0;
                        }
                        
                        
                        // REPRESENTANTE LEGAL
                        String numdoc = registros[10].trim();
                        if (numdoc.equals(nombredoc)) {

                            nombrerep = nomrep;

                        } else if (numdoc.equals(nombredoc1)) {

                            nombrerep = nomrep1;
                        } else {

                            nombrerep = nomrep2;
                        }
                                             
                        String consecutivo = registros[0];
                        if (consecutivo.startsWith(UTF8_BOM)) {
                            consecutivo = consecutivo.substring(1);
                        }
                        
                        Double dig;
                        try {
                            dig = Double.valueOf(registros[7].trim());
                        } catch (Exception e) {
                            dig = null;
                        }
                        
                        byte[] bit = LineAnsi.getBytes();
                        BytesperLinea += bit.length;
                        
                        String direccion="";
                        
                        if(paramDireccionActivated){
                            direccion = registros[12].trim();
                        }

                        //OPI u OPA:
                        String resultado = "";
                    /**
                     * ORDEN DE REGISTRO
                     * 0- ConsecutivoVenta - 1- TodoNada - 2- existePreacuerdo
                     * 3- accionesAceptadas - 4- nombreRazonSocial - 5- tipoDocumento
                     * 6- nDocumento - 7- dVerificacion - 8- fiduciario
                     * 9- cuentaInversionista - 10-representanteLegal
                     * 11-porcentajeComision - 12-direccion - 13-porcentajePagoEfectivo
                     * TODO: Por favor No quemar indices en arreglo
                     */
                    if (tipoOfertaPublica.equals("OPA")) {

                        resultado = fachada.CrearAceptacionCargueMasivo(
                                parametros[2].trim(), //cclaseAcciones
                                consecutivo.trim(), // consecutivo
                                parametros[0].replace("'", "\'\'").trim(), //texto1
                                parametros[4].replace("'", "\'\'").trim(), //texto2
                                preacuerdo, //preacuerdo
                                resultSCB[2].trim(), //codigoScb
                                resultSCB[1].trim(), //nombreScb
                                nombrerep, //representante
                                registros[4].trim(), //nombreRazonSocial
                                /*registros[5].trim(),*/
                                Double.valueOf(registros[3].replace(".", "").trim()), //numAcciones
                                todoNada, //TN
                                validar.retornarIdDocumento(registros[5].trim()),//tipoDoc
                                registros[6].trim(), //numDoc
                                dig, //digVer
                                registros[8].trim(), //fiduciario
                                registros[9].trim(), //cuentaInv
                                idDetailsService,
                                fechacreacion, 
                                idDetailsService,
                                fechacreacion,
                                userNameDetailsService, 
                                porcentajeComision, 
                                Double.valueOf(parametrosP.get(9)), 
                                direccion );
                    } else {

                        //Lógica para el tipo de pago:
                        int tipoPagoIngresado = 0;
                        if (tipoPagoParametrizado == AppConstants.PORCENTAJE_PAGO_EFECTIVO_PARAM_PREDETERMINADO) {
                            //Si el porcentaje en efectivo es Cero, el tipo pago va para Acciones
                            if (Integer.parseInt(registros[13]) == 0) {
                                tipoPagoIngresado = 2;
                            } else {
                                //sino, el tipo pago (100% para Efectrivo)
                                tipoPagoIngresado = 1;
                            }
                        }
                        resultado = fachada.CrearAceptacionCargueMasivo(
                                parametros[2].trim(), 
                                consecutivo.trim(),
                                parametros[0].replace("'", "\'\'").trim(), 
                                parametros[4].replace("'", "\'\'").trim(), 
                                preacuerdo, resultSCB[2].trim(),
                                resultSCB[1], 
                                nombrerep, 
                                registros[4].trim(), 
                                /*registros[5].trim(),*/
                                Double.valueOf(registros[3].replace(".", "").trim()), 
                                todoNada, 
                                validar.retornarIdDocumento(registros[5].trim()),
                                registros[6].trim(), 
                                dig, 
                                registros[8].trim(), 
                                registros[9].trim(), 
                                idDetailsService,
                                fechacreacion, 
                                idDetailsService, 
                                fechacreacion,
                                userNameDetailsService, 
                                porcentajeComision, 
                                Double.parseDouble(registros[13].trim()), 
                                tipoPagoIngresado,
                                Double.valueOf(parametrosP.get(9)), 
                                "S", 
                                "S", 
                                direccion);
                    }
                    bw.write(CurrentLine + " ; " + resultado);
                    bw.newLine();
                } else {
                    BytesperLinea = contentLenght;
                }
                synchronized (UI.getCurrent()) {
                    processed("Creación de aceptaciones. ");
                }
            }
                Notification.show("Proceso exitoso. Se cargaron " + cantRegistros + " registros. Por favor descargue el archivo con el resultado de la carga. ");
        } else {
            Notification.show("Proceso con errores. Por favor descargue el archivo con el resultado de las validaciones. ", Notification.Type.ERROR_MESSAGE);
        }
        } catch (Exception ex) {
            logger.error("OPA - " + CargaMasivaModal.class.getName(), ex);
            Notification.show("Ocurrió un error al momento de realizar el Cargue de Aceptaciones. ", Notification.Type.ERROR_MESSAGE);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                logger.error("OPA - " + CargaMasivaModal.class.getName(), ex);
            }
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException ex) {
                logger.error("OPA - " + CargaMasivaModal.class.getName(), ex);
            }
            upload.setEnabled(true);
            progressBar.setValue((float) 0);
            progreso.setValue("");
            traerArchivos();
           }
        }
     }
    
    public class WorkThread extends Thread {

        @Override
        public void run() {

            int hayParametrizacion = fachada.validaHayParametros();

            if (hayParametrizacion == 1) {
                parametrosP = fachada.RetornaParametros();
                texto1 = parametrosP.get(39);
                texto2 = parametrosP.get(40);
                tipoOfertaPublica = parametrosP.get(41);

                if (parametrosP.get(43).equals("1")) {
                    paramDireccionActivated = Boolean.TRUE;
                }

                if (tipoOfertaPublica.equals("OPI")) {
                    tipoPagoParametrizado = Integer.parseInt(parametrosP.get(42));
                }
            } else {
                throw new RuntimeException("No se ha hecho ninduna parametrización");
            }

            if (tipoOfertaPublica.equals("OPI")) {

                ConfirmDialog.show(getUI(), "CONDICIONES DE ACEPTACIÓN DE LA EMISIÓN", texto1, "ACEPTAR",
                        "CANCELAR", new ConfirmDialog.Listener() {
                    @Override
                    public void onClose(ConfirmDialog dialog) {
                        if (dialog.isConfirmed()) {

                            //segunda condicion--sandia
                            ConfirmDialog.show(getUI(), "CONDICIONES DE ACEPTACIÓN DE LA EMISIÓN", texto2, "ACEPTAR",
                                    "CANCELAR", new ConfirmDialog.Listener() {
                                @Override
                                public void onClose(ConfirmDialog dialog) {
                                    if (dialog.isConfirmed()) {                                                        
                                       workerProcessFile = new WorkThreadProcessFile();
                                       workerProcessFile.start();
                                    } else {
                                        upload.setEnabled(true);
                                        progressBar.setValue((float) 0);
                                        progreso.setValue("");
                                    }
                                }
                            });   
                        } else {
                            upload.setEnabled(true);
                            progressBar.setValue((float) 0);
                            progreso.setValue("");
                        }
                    }
                });
            } else {
                workerProcessFile = new WorkThreadProcessFile();
                workerProcessFile.start();
            }
        }
    }

    public final void processed(String label) {
        try {
            upload.setEnabled(false);
            progressBar.setValue((float) BytesperLinea / (float) contentLenght);
            progreso.setValue(label + (int) ((float) BytesperLinea / (float) contentLenght * 100) + "%");
            hlProgress.setImmediate(true);
        } catch (Exception e) {
            processed(label);
        }
    }

    public void mensaje() {
        ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
        cd.setWidth("448px");
        cd.setHeight("150px");
        HorizontalLayout texto = new HorizontalLayout();
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setStyleName("btnAceptar");
        Label lblmensaje = new Label("Por favor verifique el nombre del archivo", ContentMode.HTML);
        texto.addComponent(lblmensaje);
        buttons.addComponent(cd.getOkButton());
        VerticalLayout content = new VerticalLayout(lblmensaje, buttons);
        content.setStyleName("verticalDialog");
        content.setSizeFull();
        content.setSpacing(true);
        cd.setContent(content);
        cd.show(getUI(), new ConfirmDialog.Listener() {
            @Override
            public void onClose(ConfirmDialog cd) {
            }
        }, true);
        try {
            upload.interruptUpload();
        } catch (Exception e) {
            throw new RuntimeException("No se cargo el archivo de carga masiva", e);
        }
    }

    public void mensajeFecha() {
        ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
        cd.setWidth("448px");
        cd.setHeight("150px");
        HorizontalLayout texto = new HorizontalLayout();
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setStyleName("btnAceptar");
        Label lblmensaje = new Label("Por favor verifique la fecha del archivo", ContentMode.HTML);
        texto.addComponent(lblmensaje);
        buttons.addComponent(cd.getOkButton());
        VerticalLayout content = new VerticalLayout(lblmensaje, buttons);
        content.setStyleName("verticalDialog");
        content.setSizeFull();
        content.setSpacing(true);
        cd.setContent(content);
        cd.show(getUI(), new ConfirmDialog.Listener() {
            @Override
            public void onClose(ConfirmDialog cd) {
            }
        }, true);
        try {
            upload.interruptUpload();
        } catch (Exception e) {
            throw new RuntimeException("No se cargo el archivo de carga masiva", e);
        }
    }

    public void mensajeConsecutivo() {
        try {
            ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
            cd.setWidth("448px");
            cd.setHeight("150px");
            HorizontalLayout texto = new HorizontalLayout();
            HorizontalLayout buttons = new HorizontalLayout();
            buttons.setStyleName("btnAceptar");
            Label lblmensaje = new Label("Por favor verifique el consecutivo del nombre del archivo", ContentMode.HTML);
            texto.addComponent(lblmensaje);
            buttons.addComponent(cd.getOkButton());
            VerticalLayout content = new VerticalLayout(lblmensaje, buttons);
            content.setStyleName("verticalDialog");
            content.setSizeFull();
            content.setSpacing(true);
            cd.setContent(content);
            cd.show(getUI(), new ConfirmDialog.Listener() {
                @Override
                public void onClose(ConfirmDialog cd) {
                }
            }, true);

            upload.interruptUpload();
        } catch (Exception e) {
            throw new RuntimeException("No se cargo el archivo de carga masiva", e);
        }
    }

    private void limpiarCampos() {
        txtnombreArchivo.setValue("");
        txthora.setValue("");
        popudatefecha.setValue(null);

    }

    public boolean isContain(List<String> lista, String clave) {

        for (int i = 0; i < lista.size(); i++) {

            SCB scb = new SCB();
            if (clave.contains(lista.get(i))) {

                return true;

            }

        }
        return false;
    }
    
     public void close(boolean force) {
         if (force) {
            super.close();
         } else {
            close();
         }
      }
     
    public boolean detectarBOM(BufferedReader br, File file) throws IOException{
        //System.out.println("<<<Validando archivo>>>");
        String charset;
        charset = getFileCharset(file);
        if(charset != null){
            //System.out.println("Codificación detectada..."+charset);
            String currentLine;
            if(charset.equals("UTF-8")){
                if((currentLine = br.readLine()) != null){
                    //System.out.println("-->> primer caracter: "+currentLine.substring(0,1));
                    String campo = currentLine.trim();
                    if(currentLine.startsWith(UTF8_BOM)){
                        //System.out.println("-->> detecta caracter BOM: "+currentLine.substring(0,1));
                        return false;       
                    }
                }
            }else{
                //System.out.println("No es UTF-8..."+charset);
                return false;
            }
        }else{
            //System.out.println("Codificación detectada... nula");
            //System.out.println("Es UTF-8 Sin BOM pero sin tildes... se acepta");
            return true;
        }
        return true;      
    }
    public static String getFileCharset(File file) throws IOException {
        byte[] buf = new byte[4096];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        final UniversalDetector universalDetector = new UniversalDetector(null);
        int numberOfBytesRead;
        while ((numberOfBytesRead = bufferedInputStream.read(buf)) > 0 && !universalDetector.isDone()) {
                universalDetector.handleData(buf, 0, numberOfBytesRead);
        }
        universalDetector.dataEnd();
        String encoding = universalDetector.getDetectedCharset();
        universalDetector.reset();
        bufferedInputStream.close();
        return encoding;
    }

}
