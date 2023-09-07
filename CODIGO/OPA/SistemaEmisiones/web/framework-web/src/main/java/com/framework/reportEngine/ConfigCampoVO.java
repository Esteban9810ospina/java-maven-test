package com.framework.reportEngine;

import com.framework.reportEngine.config.Constantes;
import com.framework.reportEngine.config.Constantes.Alineacion;
import com.framework.reportEngine.formatter.CampoFormatter;
import com.framework.reportEngine.formatter.DefaultCampoFormatter;
import java.io.Serializable;

/**
 * Almacena configuracion de columnas (campos) para el motor de reportes
 */
public class ConfigCampoVO implements Serializable {

  private static final long serialVersionUID = 1462708909305508892L;
  private String campo;
  private String titulo;
  private Integer tamano;
  private Constantes.Alineacion alineacion;
  private String formato;
  private CampoFormatter campoFormatter;
  private int precision=0;
  //Los siguientes campos son usados para enfrentar las tablas que tienen relaciones y que requieren descriptores
  private boolean showColumnsListaBD=false;
  private boolean showColumnsListaFija=false;
  private int tipoLista=0; //0 Sin Lista //1 Lista de BD //2 Lista fija
  private String tablaLista;
  private String enlaceTablaLista;
  private String descriptorTablaLista;
  public ConfigCampoVO() {
    this(new DefaultCampoFormatter());
  }

  public ConfigCampoVO(CampoFormatter campoFormatter) {
    this.campoFormatter = campoFormatter;
    this.alineacion = Constantes.Alineacion.CENTRO;
  }

  public String getCampo() {
    return campo;
  }

  public void setCampo(String campo) {
    this.campo = campo;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Integer getTamano() {
    return tamano;
  }

  public void setTamano(Integer tamano) {
    this.tamano = tamano;
  }

  public Constantes.Alineacion getAlineacion() {
		if (alineacion == null) {
      return Alineacion.NINGUNA;
    }
    return alineacion;
	}
	public void setAlineacion(Constantes.Alineacion alineacion) {
		this.alineacion = alineacion;
	}

  public String getFormato() {
    return formato;
  }

  public void setFormato(String formato) {
    this.formato = formato;
  }

  public CampoFormatter getCampoFormatter() {
    return campoFormatter;
  }

  public void setCampoFormatter(CampoFormatter campoFormatter) {
    this.campoFormatter = campoFormatter;
  }
  
  public void setPrecision(int precision) {
      this.precision=precision;
  }

  public int getPrecision() {
      return precision;
  }
  public void setShowColumnsListaBD(boolean listaBD) {
      this.showColumnsListaBD=listaBD;
  }
  
  public boolean getShowColumnsListaBD() {
      return this.showColumnsListaBD;
  }

  
  public void setShowColumnsListaFija(boolean listaFija){
      this.showColumnsListaFija=listaFija;
  }
  public boolean getShowColumnsListaFija(){
      return this.showColumnsListaFija;
  }

  public void setTipoLista(int tipoLista){ //0 Sin Lista //1 Lista de BD //2 Lista fija
      this.tipoLista=tipoLista;
  }        
  public int getTipoLista(){ //0 Sin Lista //1 Lista de BD //2 Lista fija
      return this.tipoLista;
  }        
  
  public void setTablaLista(String tabla) {
      this.tablaLista=tabla;
  }
  public String getTablaLista() {
      return this.tablaLista;
  }

  public void setEnlaceTablaLista(String enlace) {
      this.enlaceTablaLista=enlace;
  }
  public String getenlaceTablaLista() {
      return this.enlaceTablaLista;
  }

  public void setDescriptorTablaLista(String descriptor) {
      this.descriptorTablaLista=descriptor;
  }
  public String getDescriptorTablaLista() {
      return this.descriptorTablaLista;
  }
       
  
}
