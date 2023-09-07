package com.quasar.frameq.seguridad;

import com.quasar.frameq.db.Persistente;
import java.util.Vector;
import java.sql.SQLException;

/**
 * <p>Title: SPIVI - CampAuditado</p>
 * <p>Description: Administración de registros de la tabla CampAuditado>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Quasar Software</p>
 * @author Diana Marcela Quiroga
 * @version 1.0a071102
 * Cooreccion: Erlington Salcedo
 */

public class CampAuditado  extends Persistente {
  
  private Integer tablaAuditada;
  private String campoAuditad;
  private Integer accionBd;

  //** Constructores

  public CampAuditado() {
    setTablaAuditada(0);
    setCampAuditado("");
    setAccionBd(0);
  }

  public final String getCampAuditado(){
    return this.campoAuditad;
  }

  public void setCampAuditado(String setCampAuditado){
    this.campoAuditad = setCampAuditado;
  }

  public final Integer getTablaAuditada()	{
    return this.tablaAuditada;
  }

  public void setTablaAuditada(Integer setTablaAuditada)	{
    this.tablaAuditada = setTablaAuditada;
  }

  public final Integer getAccionBd(){
    return this.accionBd;
  }

  public void setAccionBd(Integer setAccionBd){
    this.accionBd = setAccionBd;
  }

  public CampAuditado(Integer tablaAuditada,String campoAuditad,Integer accionBd){
    setTablaAuditada(tablaAuditada); 
    setCampAuditado(campoAuditad);
    setAccionBd(accionBd);
  }

  public Vector getContenido ()  {
    Vector v = new Vector();
    v.add(tablaAuditada);
    v.add(campoAuditad);
    v.add(accionBd);
    return v;
  }

    public void inicializar ()  {
    setPersistente(this);
    String atributos[] = {"i_tablaauditada","c_campauditad","i_accionbd"};

    setAtributos(atributos);
    setNombreTabla("fqs_campauditad");
    setElementosLLave(2);
  }

   //** nuevo parametros Vector con atributos de valortasa
  public Persistente nuevo (Vector v)  {
    return new CampAuditado((Integer)v.elementAt(0),(String)v.elementAt(1),(Integer)v.elementAt(2));
  }

  public void setContenido() throws SQLException {
    setTablaAuditada(rs.getInt("i_tablaauditada"));
    setCampAuditado(rs.getString("c_campauditad"));
    setAccionBd(rs.getInt("i_accionbd"));
  }

  public void setContenido(Vector v)  {


    String auxS = v.elementAt(0).toString();
    Integer auxI = Integer.parseInt(auxS);
    if(auxI != null)
      this.setTablaAuditada(auxI);
    else
      this.setTablaAuditada(0);

    
    this.setCampAuditado((String)v.elementAt(1));

    auxS = v.elementAt(2).toString();
    auxI = new Integer(auxS);
    if(auxI != null)
      this.setAccionBd(auxI);
    else
      this.setAccionBd(0);


  }

    public boolean referencia(Vector v){
      return true;
    }
}



