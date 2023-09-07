package com.quasar.frameq.seguridad;

import com.quasar.frameq.db.Persistente;
import java.util.Vector;
import java.sql.SQLException;



public class DUsuaServic extends Persistente
{
   private Integer usuario;
   private Integer perfil;
   private Integer servicio;
   private String horaInicioUso;
   private String horaFinalUso;
   private String descripcionUso;

    public DUsuaServic() {
      this.setUsuario(new Integer(0));
      this.setPerfil(new Integer(0));
      this.setServicio(new Integer(0));
      this.setHoraInicioUso("");
      this.setHoraFinalUso("");
      this.setDescripcionUso("");
    }

    public DUsuaServic(Integer usuario,Integer perfil,Integer servicio,
                       String horaInicioUso,String horaFinalUso,String descripcionUso) {
      this.setUsuario(usuario);
      this.setPerfil(perfil);
      this.setServicio(servicio);
      this.setHoraInicioUso(horaInicioUso);
      this.setHoraFinalUso(horaFinalUso);
      this.setDescripcionUso(descripcionUso);
    }

public void inicializar ()  {
    setPersistente(this);
    String atributos[] = {"i_usuario","i_perfil","i_servicio","dt_horainiciouso",
                          "dt_horafinuso","c_descripcionuso"};

    setAtributos(atributos);
    int precision[]={0,0,0,0,0,0};
    setPrecision(precision);
    setNombreTabla("fqs_dusuaservic");
    setElementosLLave(3);
  }

public Persistente nuevo (Vector v)  {
    return new DUsuaServic ((Integer)v.elementAt(0),(Integer)v.elementAt(1),
              (Integer)v.elementAt(2),(String)v.elementAt(3),(String)v.elementAt(4),
              (String)v.elementAt(5));
  }

public Vector getContenido ()  {
    Vector v = new Vector();
    v.add(usuario);
    v.add(perfil);
    v.add(servicio);
    v.add(horaInicioUso);
    v.add(horaFinalUso);
    v.add(descripcionUso);
    return v;
  }

    public final Integer getUsuario() {
            return usuario;
    }
    public void setUsuario(Integer usuario) {
            this.usuario = usuario;
    }
    public final Integer getPerfil() {
            return perfil;
    }
    public void setPerfil(Integer perfil) {
            this.perfil = perfil;
    }
    public final Integer getServicio() {
            return servicio;
    }
    public void setServicio(Integer servicio) {
            this.servicio = servicio;
    }
    public final String getHoraInicioUso() {
            return horaInicioUso;
    }
    public void setHoraInicioUso(String horaInicioUso) {
            this.horaInicioUso = horaInicioUso;
    }
    public final String getHoraFinalUso() {
            return horaFinalUso;
    }
    public void setHoraFinalUso(String horaFinalUso) {
            this.horaFinalUso = horaFinalUso;
    }
    public final String getDescripcionUso() {
            return descripcionUso;
    }
    public void setDescripcionUso(String descripcionUso) {
            this.descripcionUso = descripcionUso;
    }
    
    public void setContenido() throws SQLException {
      this.setUsuario(new Integer(rs.getInt("i_usuario")));
      this.setPerfil(new Integer(rs.getInt("i_perfil")));
      this.setServicio(new Integer(rs.getInt("i_servicio")));
      this.setHoraInicioUso((rs.getString("dt_horainiciouso")));
      this.setHoraFinalUso((rs.getString("dt_horafinuso")));
      this.setDescripcionUso((rs.getString("c_descripcionuso")));
    }
    public void setContenido(Vector v)  {

    String auxS = v.elementAt(0).toString();
    Integer auxI = new Integer(auxS);
    if(auxI != null)
      this.setUsuario(auxI);
    else
      this.setUsuario(new Integer(0));

    auxS = v.elementAt(1).toString();
    auxI = new Integer(auxS);
    if(auxI != null)
      this.setPerfil(auxI);
    else
      this.setPerfil(new Integer(0));

    auxS = v.elementAt(2).toString();
    auxI = new Integer(auxS);
    if(auxI != null)
      this.setServicio(auxI);
    else
      this.setServicio(new Integer(0));

    this.setHoraInicioUso((String)v.elementAt(3));
    this.setHoraFinalUso((String)v.elementAt(4));
    this.setDescripcionUso((String)v.elementAt(5));
  }

    public boolean referencia(Vector v){
      return true;
    }
}


