/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.common.ui;

//import com.framework.common.service.ReportsService;
import com.framework.common.ui.GenericTab;
import com.framework.common.ui.util.VaadinComponentFactory;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Window;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Alejandro Riveros Cruz
 * @author Roger Padilla C.
 */
public abstract class GenericContent extends BaseComponent {

 // @Autowired
//  protected ReportsService reportsService;

  @Autowired
  protected VaadinComponentFactory vaadinComponentFactory;

  protected GenericTab parentTab;
  protected Window subwindow;
  protected int opcionModuloId;

  /*protected QueryContainer generateReport(String titulo, List<ConfigCampoVO> campos, String query, Object... args) {
    return reportsService.generateReport(getApplication(), titulo, campos, query, args);
  }

  protected QueryContainer generateReport(String titulo, List<ConfigCampoVO> campos, List<Map<String, Object>> data) {
    return generateReport(titulo, campos, data, ",");
  }

  protected QueryContainer generateReport(String titulo, List<ConfigCampoVO> campos, List<Map<String, Object>> data, String fieldDelimiter) {
    String nombreArchivoSalida = StringUtil.unAccent(titulo);

    ReportService reportService = new ReportService();
    reportService.setArchivoSalida(nombreArchivoSalida);
    reportService.setConfigCampos(campos);
    reportService.setFormatoSalida("Web20");
    reportService.setTitulo(titulo);
    reportService.setFieldDelimiter(fieldDelimiter);

    QueryContainer report = reportService.creaConsultaWeb20(
            getApplication(),
            getApplication().getMainWindow(),
            data);

    report.setStyleName("report-container");

    return report;
  }*/

  protected void launchSubwindow(String message) {
    subwindow = new Window("Error");
    subwindow.setModal(true);
    subwindow.setResizable(false);
    subwindow.setDraggable(false);
    subwindow.setContent(new Label(message, Label.CONTENT_XHTML));
    getUI().addWindow(subwindow);
  }

protected void launchSubwindow(String message, String Title) {
    subwindow = new Window(Title);
    subwindow.setModal(true);
    subwindow.setResizable(false);
    subwindow.setDraggable(false);
    subwindow.setContent(new Label(message, Label.CONTENT_XHTML));
    getUI().addWindow(subwindow);
}

public NativeSelect setNativeSelectFirstValue(NativeSelect nativeSelect, String caption) {
    nativeSelect.setNullSelectionAllowed(true);
    nativeSelect.addItem(caption);
    nativeSelect.setNullSelectionItemId(caption);
    return nativeSelect;
  }
  
  public void setOpcionModuloId(int opcionModuloId) {
    this.opcionModuloId = opcionModuloId;
  }

  public GenericContent(GenericTab parentTab) {
    this.parentTab = parentTab;
  }

  public void goNextContent(GenericContent genericContent) {
    parentTab.setBodyContent(genericContent);
  }

  public GenericTab getParentTab() {
    return parentTab;
  }

  public abstract void initForm();
}