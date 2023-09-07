package com.framework.reportEngine;

import com.quasar.frameq.db.DbUtil;
import com.framework.common.service.ReportDAO;
import com.vaadin.ui.Table;
import com.framework.reportEngine.config.Constantes;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class ConsultaWeb20 implements Button.ClickListener {

  private ReportDAO reportDAO = new ReportDAO();
  private Select selectCampos = new Select("Filtrar por Campo: ");
  private Select selectFormatosSalida = new Select("Formato de Salida:");
  private TextField patronFiltro = new TextField("Que contiene: ");
  private Button btnFiltrar = new Button("Filtrar");
  private Button btnReiniciar = new Button("Reiniciar");
  private Button btnExportar = new Button("Exportar");
  private IndexedContainer contenedor = new IndexedContainer();
  private Panel panel;// Para lograr el scroll horizontal
  private Table table = new Table();
  List<ConfigCampoVO> configCamposInterna;
  private UI app;
  private Window window;
  private String titulo;
  private String fieldDelimiter;

  public QueryContainer creaConsulta(UI app, 
          List<ConfigCampoVO> configCampos, String titulo, String query, Object[] args) {

    ResultSet rs = reportDAO.consultaBaseDatos(query, args);  	// efectua consulta de datos
    List<Map<String, Object>> data = DbUtil.extractData(rs);
    reportDAO.closeConnection();

    return creaConsulta(app, configCampos, titulo, data);
  }

  public QueryContainer creaConsulta(UI app, 
          List<ConfigCampoVO> configCampos, String titulo, List<Map<String, Object>> data) {

    selectCampos.setItemCaptionMode(Select.ITEM_CAPTION_MODE_EXPLICIT_DEFAULTS_ID);   // activa uso de id explicitos para el select
    configCamposInterna = configCampos;
   // selectFormatosSalida.addItem("PDF");
    selectFormatosSalida.addItem("XLS");
    //selectFormatosSalida.addItem("XML");
    selectFormatosSalida.addItem("CSV");
   // selectFormatosSalida.setValue("PDF");
    selectFormatosSalida.setNullSelectionAllowed(false);

    this.app = app;
 
    this.titulo = titulo;

    int numCampos = configCampos.size();

    ConfigCampoVO campo;  	// leee datos de la BD y pobla el contenedor
    for (int i = 0; i < numCampos; i++) {
      campo = configCampos.get(i);
      contenedor.addContainerProperty(campo.getCampo(), String.class, "");
      selectCampos.addItem(campo.getCampo());
      selectCampos.setItemCaption(campo.getCampo(), campo.getTitulo());
    }

    selectCampos.setImmediate(true);
    selectCampos.setNullSelectionAllowed(false);
    btnReiniciar.addListener(this);
    btnFiltrar.addListener(this);
    btnExportar.addListener(this);
    int numRegistros = data.size();

    for (Map<String, Object> dataRow : data) {
      Object itemId = contenedor.addItem();
      Item item = contenedor.getItem(itemId);
      for (int i = 0; i < numCampos; i++) {// columna por columna
        campo = configCampos.get(i);
        item.getItemProperty(campo.getCampo()).setValue(campo.getCampoFormatter().format(campo.getCampo(), dataRow));
      }
    }

    data.clear();

    if (numRegistros == 0) {
      QueryContainer qc = new QueryContainer();
      if(titulo.equals("Framework-c - Consulta histórica operaciones"))
      {
        qc.addComponent(new Label("No existen registros para la fecha. Por favor verifique la fecha." , Label.CONTENT_XHTML));
      }else{
      qc.addComponent(new Label("No existen registros para " + titulo, Label.CONTENT_XHTML));
      }
      return qc;
    }

    //Crea el panel
    panel = new Panel(titulo);
    panel.setWidth("1000px"); // we want scrollbars
    panel.setHeight("75%");
    panel.setImmediate(true);
if(titulo.contains("Gestión de portafolio"))
{
    table.setSelectable(true);
}
    table.setStyleName("tabla");
    table.setContainerDataSource(contenedor);
    table.setColumnReorderingAllowed(true);     // Habilita ordenamiento y colapso de columnas
    table.setColumnCollapsingAllowed(true);
    table.setPageLength(numRegistros > Constantes.SIZEGRILLA_CONSULTAS ? Constantes.SIZEGRILLA_CONSULTAS : numRegistros);  	// tamaÃ±o por defecto de la pagina

    // Configura titulos y tamaños de columnas
    for (int i = 0; i < configCampos.size(); i++) {
      campo = configCampos.get(i);
      table.setColumnHeader(campo.getCampo(), campo.getTitulo());
      if (campo.getTamano() != null) {
        table.setColumnWidth(campo.getCampo(), campo.getTamano());
      }
    }

    table.setHeight("100%");
    table.setImmediate(true);
    table.setWidth("100%");


    HorizontalLayout hLayoutFiltros = new HorizontalLayout();
    hLayoutFiltros.setSpacing(true);
    hLayoutFiltros.setStyleName("sfiltro");
    hLayoutFiltros.addComponent(selectCampos);
    hLayoutFiltros.addComponent(patronFiltro);
    btnFiltrar.setStyleName("btn-query-engine");
    hLayoutFiltros.addComponent(btnFiltrar);
    btnReiniciar.setStyleName("btn-query-engine");
    hLayoutFiltros.addComponent(btnReiniciar);
    HorizontalLayout hLayoutExportar = new HorizontalLayout();
    hLayoutExportar.addComponent(selectFormatosSalida);
    btnExportar.setStyleName("btn-query-engine");
    hLayoutExportar.addComponent(btnExportar);
    QueryContainer queryContainer = new QueryContainer();
    queryContainer.setNumRegistros(numRegistros);
    panel.setContent(table);
    //queryContainer.addComponent(table);
    queryContainer.setTable(table);
    queryContainer.addComponent(panel);
    queryContainer.addComponent(hLayoutFiltros);
    queryContainer.addComponent(hLayoutExportar);

    return queryContainer;
  }

  @Override
  /**
   * Maneja eventos de botones
   */
  public void buttonClick(ClickEvent event) {
    if (event.getButton().getCaption().equalsIgnoreCase("Filtrar")) {
      if (selectCampos.getValue() != null && (!((String) patronFiltro.getValue()).equalsIgnoreCase(""))) {
        Filter filtro = new SimpleStringFilter(((String) selectCampos.getValue()).trim(), ((String) patronFiltro.getValue()).trim(), true, false);
        contenedor.removeAllContainerFilters();
        contenedor.addContainerFilter(filtro);
      }
    } else if (event.getButton().getCaption().equalsIgnoreCase("Reiniciar")) {
      contenedor.removeAllContainerFilters();
      selectCampos.setValue(null);
      patronFiltro.setValue("");
      table.requestRepaintAll();
    } else if (event.getButton().getCaption().equalsIgnoreCase("Exportar")) {
      if (selectFormatosSalida.getValue() != null) {
        creaReporteObjetos((String) selectFormatosSalida.getValue());
      }
    }

  }

  /**
   * Invoca al motor de reportes, enviando como fuente de datos una coleccion de maps (filas)
   *
   */
  @SuppressWarnings("unchecked")
  private void creaReporteObjetos(String formatoSalida) {

    @SuppressWarnings("rawtypes")
    ArrayList<Map<String, ?>> cole = new ArrayList();
    Map<String, ?> fila = null;
    Iterator<?> ite = contenedor.getItemIds().iterator();

    // arma la coleccion que se le enviara al motor de reportes para exportar datos
    while (ite.hasNext()) {
      Integer id = (Integer) ite.next();
      @SuppressWarnings("rawtypes")
      HashMap filat = new HashMap<String, String>();
      fila = new HashMap<String, String>();
      for (int i = 0; i < configCamposInterna.size(); i++) {
        ConfigCampoVO campo = configCamposInterna.get(i);
        Item im = (Item) contenedor.getItem(id);
        String valor = (String) im.getItemProperty(campo.getCampo()).getValue();
        filat.put(campo.getCampo().intern(), valor);
        fila = filat;
      }
      cole.add(fila);
    }

    ReportService reporte = new ReportService();   // coleccion esta lista para envio, aqui arma el reporte

    reporte.setTitulo(titulo);
    reporte.setSubtitulo("");
    reporte.setFormatoSalida(formatoSalida);
    reporte.setArchivoSalida("framework-c." + formatoSalida.toLowerCase());
    reporte.setConfigCampos(configCamposInterna);
    reporte.setColeccion(cole);
    reporte.setFieldDelimiter(fieldDelimiter);
    reporte.creaReporteObjetos("WEB", app);
  }

  public String getFieldDelimiter() {
    return fieldDelimiter;
  }

  public void setFieldDelimiter(String fieldDelimiter) {
    this.fieldDelimiter = fieldDelimiter;
  }
}
