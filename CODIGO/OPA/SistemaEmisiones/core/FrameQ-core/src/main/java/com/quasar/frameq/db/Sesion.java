package com.quasar.frameq.db;

import java.util.Vector;
import java.sql.SQLException;
/**
 * Clase administradora de la tabla fqs_sesion
 * <p>Title: Sesión</p>
 * <p>Description: Mantenedora de la tabla fqs_sesión.</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Quasar Software</p>
 * @author José Manuel Martínez Lozano
 * @version 1.0
 */
public class Sesion extends Persistente {
  /** Sistema de negociación.*/
    
  private Integer codigo;/* coidgo sesion*/ 
  private String sistNegcion;/** Código de la sesión. */
  private String sesion; /** Nombre de la sesión. */
  private String nombre; /** Flag que indica si la operación se excluye. */
  private Integer sube; /** Número de días al cumplimiento del título. */
  private Integer diasCumpliento;
  private String  sesionPrimaria;
  
/**
 * Constructor sin argumentos.
 */

  public Sesion() {
    setCodigo(new Integer(0));  
      
    setNombre("");
    setSistNegcion("");
    setSesion("");
    setNombre("");
    setSube(new Integer(0));
    setDiasCumpliento(new Integer(0));
    setSesionPrimaria(""); 
  }
/**
 * Constructor principal.
 * @param sistNegcion Sistema de negociación.
 * @param sesion Código de la sesión.
 * @param nombre Nombre de la sesión.
 * @param sube Indica si se excluye o no la operación.
 * @param diasCumpliento Número de días al cumplimiento del título.
 */
  public Sesion (Integer codigo, String sistNegcion,String sesion,String nombre, Integer sube,
                 Integer diasCumpliento, String sesionPrimaria) {
    setCodigo(codigo);  
    setSistNegcion(sistNegcion);
    setSesion(sesion);
    setNombre(nombre);
    setSube(sube);
    setDiasCumpliento(diasCumpliento);
    setSesionPrimaria(sesionPrimaria);
    
  }

  public Integer getCodigo(){
   return this.codigo;
  }
  
  
/**
 * Obtiene el sistema de negociación.
 * @return String que contiene el sistema de negociación.
 */

  public String getSistNegcion() {
    return this.sistNegcion;
  }
/**
 * Fija el sistema de negociación.
 * @param sistNegcion
 */
  public void setSistNegcion(String setSistNegcion) {
    this.sistNegcion = setSistNegcion;
  }

  public String getSesion() {
    return this.sesion;
  }

  public void setSesion(String setSesion) {
    this.sesion = setSesion;
  }

  public String getNombre() {
    return this.nombre;
  }
  
  public String getSesionPrimaria(){
      return this.sesionPrimaria;
  }
  
  
  public void setCodigo(Integer setCodigo){
    this.codigo=setCodigo;
  }

  public void setNombre(String setNombre) {
    this.nombre = setNombre;
  }

  public Integer getSube() {
    return this.sube;
  }

  public void setSube(Integer setSube) {
    this.sube = setSube;
  }

  public Integer getDiasCumpliento () {
    return this.diasCumpliento;
  }

  public void setDiasCumpliento (Integer setDiasCumpliento) {
    this.diasCumpliento = setDiasCumpliento;
  }
  
  public void setSesionPrimaria(String setSesionPrimaria){
      this.sesionPrimaria=setSesionPrimaria;
  }

  public Persistente nuevo(Vector v) {
    return new Sesion((Integer)v.elementAt(0),(String)v.elementAt(1),(String)v.elementAt(2),
                              (String)v.elementAt(3), (Integer)v.elementAt(4),
                              (Integer)v.elementAt(5),(String)v.elementAt(6));
  }
  public void inicializar() {
    setPersistente(this);
    String atributos[] = {"i_codigo","c_sistnegcion","c_sesion","c_nombre",
                          "i_sube","i_diascumpliento","c_sesionp"};
    setAtributos(atributos);
    setNombreTabla("fqs_sesion");
    setElementosLLave(1);
  }

  public Vector getContenido() {
    Vector v = new Vector();
    v.add(this.codigo);
    v.add(this.sistNegcion);
    v.add(this.sesion);
    v.add(this.nombre);
    v.add(this.sube);
    v.add(this.diasCumpliento);
    v.add(this.sesionPrimaria);
    return v;
  }

  public void setContenido() throws SQLException {
     this.setCodigo(new  Integer(rs.getInt("i_codigo")));
     this.setSistNegcion((rs.getString("c_sistnegcion")));
     this.setSesion((rs.getString("c_sesion")));
     this.setNombre((rs.getString("c_nombre")));
     this.setSube(new Integer(rs.getInt("i_sube")));
     this.setDiasCumpliento(new Integer(rs.getInt("i_diascumpliento")));
     this.setSesionPrimaria((rs.getString("c_sesionp")));
   }


  public void setContenido(Vector v)   {

    String auxS = v.elementAt(0).toString();
    Integer auxI = new Integer(auxS);
    if (auxI != null)
      this.setCodigo(auxI);
    else
      this.setCodigo(new Integer(0));  
      
    this.setSistNegcion((String)v.elementAt(1));
    this.setSesion((String)v.elementAt(2));
    this.setNombre((String)v.elementAt(3));

    auxS = v.elementAt(4).toString();
    auxI = new Integer(auxS);
    if (auxI != null)
      this.setSube(auxI);
    else
      this.setSube(new Integer(0));
   
    auxS = v.elementAt(5).toString();
    auxI = new Integer(auxS);
    if (auxI != null)
        this.setDiasCumpliento(auxI);
      else
       this.setDiasCumpliento(new Integer(0));
    
    this.setSesionPrimaria((String)v.elementAt(6));
    
    }
  
   
/**
 * Método de apoyo.
 * @param v
 * @return Boleano true;
 */
  public boolean referencia (Vector v){
    return true;
  }

/*
 public static void main(String[] args) {
    Vector i = new Vector();
    Sesion sesion = new Sesion(new String ("MEC"),new String("OP"),new String("basura"),new Integer(1),new Integer(3));

    sesion.inicializar();
    sesion.getContenido();
    sesion.insertar();
    sesion.consultar();
  }*/
}