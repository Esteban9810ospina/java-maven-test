package com.quasar.frameq.seguridad;


import com.quasar.frameq.db.Persistente;
import java.util.Vector;
import java.sql.SQLException;

/**
 * <p>Title: SPIVI - Desarrollo</p>
 * <p>Description: Administración de registros de la tabla DUsuaDispAut>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Quasar Software</p>
 * @author Diana Marcela Quiroga
 * @version 1.0a071102
 */

public class DUsuaDispAut extends Persistente
{
  private Integer usuario;
  private Integer perfil;
  private Integer disptivoAutentica;


  ///** Constructores

 public DUsuaDispAut() {
   setUsuario(new Integer(0));
   setPerfil(new Integer(0));
   setDisptivoAutentica(new Integer(0));

 }
 public DUsuaDispAut (Integer usuario,Integer perfil,Integer disptivoAutentica){
   setUsuario(usuario);
   setPerfil(perfil);
   setDisptivoAutentica(disptivoAutentica);

 }

  public void setUsuario(Integer setUsuario){
    this.usuario = setUsuario;
  }

  public void setDisptivoAutentica(Integer setDisptivoAutentica){
    this.disptivoAutentica = setDisptivoAutentica;
  }

  public void setPerfil(Integer setPerfil){
    this.perfil = setPerfil;
  }

  public final Integer getUsuario(){
    return this.usuario;
  }

  public final Integer getDisptivoAutentica(){
    return this.disptivoAutentica;
  }

  public final Integer getPerfil(){
    return this.perfil;
  }
  public Vector getContenido (){
    Vector v = new Vector();
    v.add(usuario);
    v.add(perfil);
    v.add(disptivoAutentica);
    return v;
  }


  public void inicializar (){
    setPersistente(this);
    String atributos[] = {"i_usuario","i_perfil","i_dispautentica"};

    setAtributos(atributos);
    setNombreTabla("fqs_dusuadispaut");
    setElementosLLave(3);
  }

  //** nuevo parametros Vector con atributos de DUsuaDispAut

  public Persistente nuevo (Vector v){
    return new DUsuaDispAut ((Integer)v.elementAt(0),(Integer)v.elementAt(1),
           (Integer)v.elementAt(2));

  }

  public final void sistnegcion(){
  }

  public final void disptivoAutentica(){
  }

  public final void usuario(){
  }

  public void setContenido() throws SQLException {
    setUsuario(new Integer(rs.getInt("i_usuario")));
    setPerfil(new Integer(rs.getInt("i_perfil")));
    setDisptivoAutentica(new Integer(rs.getInt("i_dispautentica")));
  }


  public void setContenido(Vector v)  {

    String auxS = (String)v.elementAt(0);
    Integer auxI = new Integer(auxS);
    if(auxI != null)
      this.setUsuario(auxI);
    else
      this.setUsuario(new Integer(0));

    auxS = (String)v.elementAt(1);
    auxI = new Integer(auxS);
    if(auxI != null)
      this.setPerfil(auxI);
    else
      this.setPerfil(new Integer(0));

    auxS = (String)v.elementAt(2);
    auxI = new Integer(auxS);
    if(auxI != null)
      this.setDisptivoAutentica(auxI);
    else
      this.setDisptivoAutentica(new Integer(0));
  }

    public boolean referencia(Vector v){
      return true;
    }

}

