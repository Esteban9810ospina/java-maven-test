package com.quasar.frameq.seguridad;

import com.quasar.frameq.db.Persistente;
import java.util.Vector;
import java.sql.*;


public class AuditBdSist extends Persistente {

  private Integer auditBdSistema;
  private Integer usuario;
  private Integer perfil;
  private String campoAuditado;
  private Integer tablaAuditada;
  private Date fecha;
  private Date hora;
  private String accion;
  private String anteriorValor;
  private String nuevoValor;

  public AuditBdSist() {
    this.setAuditBdSistema(new Integer(0));
    this.setUsuario(new Integer(0));
    this.setPerfil(new Integer(0));
    this.setCampoAuditado("");
    this.setTablaAuditada(new Integer(0));
    this.setFecha(new Date(java.util.Calendar.DATE));
    this.setHora(new Date(java.util.Calendar.DATE));
    this.setAccion("");
    this.setAnteriorValor("");
    this.setNuevoValor("");
  }

  public AuditBdSist(Integer auditBdSistema,Integer usuario,Integer perfil,
                     String campoAuditado,Integer tablaAuditada,Date fecha,
                     Date hora,String accion,String anteriorValor,String nuevoValor) {
    this.setAuditBdSistema(auditBdSistema);
    this.setUsuario(usuario);
    this.setPerfil(perfil);
    this.setCampoAuditado(campoAuditado);
    this.setTablaAuditada(tablaAuditada);
    this.setFecha(fecha);
    this.setHora(hora);
    this.setAccion(accion);
    this.setAnteriorValor(anteriorValor);
    this.setNuevoValor(nuevoValor);
  }

public void inicializar ()  {
    setPersistente(this);
    String atributos[] = {"i_auditbdsistema","i_usuario","i_perfil","c_campoauditado",
                          "i_tablaauditada","d_fecha","dt_hora","c_accion","c_anteriorvalor",
                          "c_nuevovalor"};

    setAtributos(atributos);
    setNombreTabla("fqs_auditbdsist");
    setElementosLLave(1);
  }

public Persistente nuevo (Vector v)  {
    return new AuditBdSist ((Integer)v.elementAt(0),(Integer)v.elementAt(1),
              (Integer)v.elementAt(2),(String)v.elementAt(3),(Integer)v.elementAt(4),
              (Date)v.elementAt(5),(Date)v.elementAt(6),(String)v.elementAt(7),
              (String)v.elementAt(8),(String)v.elementAt(9));
  }

public Vector getContenido ()  {
    Vector v = new Vector();
    v.add(auditBdSistema);
    v.add(usuario);
    v.add(perfil);
    v.add(campoAuditado);
    v.add(tablaAuditada);
    v.add(fecha);
    v.add(hora);
    v.add(accion);
    v.add(anteriorValor);
    v.add(nuevoValor);
    return v;
  }

  public Integer getAuditBdSistema() {
    return this.auditBdSistema;
  }

  public Integer getUsuario() {
   return this.usuario;
  }
  public Integer getPerfil() {
    return this.perfil;
  }
  public String getCampoAuditado() {
    return this.campoAuditado;
  }
  public Integer getTablaAuditada() {
    return this.tablaAuditada;
  }
  public Date getFecha() {
    return this.fecha;
  }
  public Date getHora() {
    return this.hora;
  }
  public String getAccion() {
   return this.accion;
  }
  public String getAnteriorValor() {
    return this.anteriorValor;
  }
  public String getNuevoValor() {
    return this.nuevoValor;
  }

  public void setUsuario(Integer usuario) {
   this.usuario = usuario;
  }
  public void setPerfil(Integer perfil) {
     this.perfil = perfil;
  }
  public void setCampoAuditado(String campAuditado) {
    this.campoAuditado= campAuditado;
  }
  public void setTablaAuditada(Integer tablaAuditada) {
     this.tablaAuditada = tablaAuditada;
  }
  public void setFecha(Date fecha) {
     this.fecha = fecha;
  }
  public void setHora(Date hora) {
     this.hora = hora;
  }
  public void setAccion(String accion) {
    this.accion = accion;
  }
  public void setAnteriorValor(String anteriorValor) {
     this.anteriorValor = anteriorValor;
  }
  public void setNuevoValor(String nuevoValor) {
     this.nuevoValor = nuevoValor;
  }
  public void setAuditBdSistema(Integer auditBdSistema) {
     this.auditBdSistema = auditBdSistema;
  }

  public void setContenido() throws SQLException {
    this.setAuditBdSistema(new Integer(rs.getInt("i_auditbdsistema")));
    this.setUsuario(new Integer(rs.getInt("i_usuario")));
    this.setPerfil(new Integer(rs.getInt("i_perfil")));
    this.setCampoAuditado((rs.getString("c_campoauditado")));
    this.setTablaAuditada(new Integer(rs.getInt("i_tablaauditada")));
    this.setFecha(rs.getDate("d_fecha"));
    this.setHora(rs.getDate("dt_hora"));
    this.setAccion((rs.getString("c_accion")));
    this.setAnteriorValor((rs.getString("c_anteriorvalor")));
    this.setNuevoValor((rs.getString("c_nuevovalor")));
  }


  public void setContenido(Vector v)  {

    String auxS = (String)v.elementAt(0);
    Integer auxI = new Integer(auxS);
    if(auxI != null)
      this.setAuditBdSistema(auxI);
    else
      this.setAuditBdSistema(new Integer(0));

    auxS = (String)v.elementAt(1);
    auxI = new Integer(auxS);
    if(auxI != null)
      this.setUsuario(auxI);
    else
      this.setUsuario(new Integer(0));

    auxS = (String)v.elementAt(2);
    auxI = new Integer(auxS);
    if(auxI != null)
      this.setPerfil(auxI);
    else
      this.setPerfil(new Integer(0));
    this.setCampoAuditado((String)v.elementAt(3));

    auxS = (String)v.elementAt(4);
    auxI = new Integer(auxS);
    if(auxI != null)
      this.setTablaAuditada(auxI);
    else
      this.setTablaAuditada(new Integer(0));

    auxS = (String)v.elementAt(5);
    Date auxDa = Date.valueOf(auxS);
    if (auxDa != null)
      this.setFecha(auxDa);
    else
      this.setFecha(new Date(java.util.Calendar.DATE));

    auxS = (String)v.elementAt(6);
    auxDa = Date.valueOf(auxS);
    if (auxDa != null)
      this.setHora(auxDa);
    else
      this.setHora(new Date(java.util.Calendar.DATE));

    this.setAccion((String)v.elementAt(7));
    this.setAnteriorValor((String)v.elementAt(8));
    this.setNuevoValor((String)v.elementAt(9));
  }

    public boolean referencia(Vector v){
      return true;
    }
}