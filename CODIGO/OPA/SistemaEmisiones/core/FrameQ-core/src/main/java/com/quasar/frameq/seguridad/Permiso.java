package com.quasar.frameq.seguridad;

import com.quasar.frameq.db.Persistente;
import java.util.Vector;
import java.sql.*;


public class Permiso extends Persistente
{
    private Integer permiso;
    private Integer perfil;
    private Integer opcionModulo;
    private String horaInicioPermiso;
    private String horaFinPermiso;
    private String descripcion;

    public Permiso() {
      this.setPermiso(new Integer(0));
      this.setPerfil(new Integer(0));
      this.setOpcionModulo(new Integer(0));
      this.setHoraInicioPermiso("");
      this.setHoraFinPermiso("");
      this.setDescripcion("");
    }

    public Permiso(Integer permiso,Integer perfil,
                   Integer opcionModulo,
                   String horaInicioPermiso,String horaFinPermiso,String descripcion) {
      this.setPermiso(permiso);
      this.setPerfil(perfil);
      this.setOpcionModulo(opcionModulo);
      this.setHoraInicioPermiso(horaInicioPermiso);
      this.setHoraFinPermiso(horaFinPermiso);
      this.setDescripcion(descripcion);
    }

public void inicializar ()  {
    setPersistente(this);
    String atributos[] = {"i_permiso","i_perfil","i_opcionmodulo",
                          "dt_horainipermiso","dt_horafinpermiso",
                          "c_descripcion" };

    setAtributos(atributos);
    setNombreTabla("fqs_permiso");
    setElementosLLave(1);
  }

public Persistente nuevo (Vector v)  {
    return new Permiso ((Integer)v.elementAt(0),(Integer)v.elementAt(1),
              (Integer)v.elementAt(2),
              (String)v.elementAt(3),(String)v.elementAt(4),(String)v.elementAt(5));
  }

public Vector getContenido ()  {
    Vector v = new Vector();
    v.add( permiso);
    v.add( perfil);
    v.add( opcionModulo);
    v.add( horaInicioPermiso);
    v.add( horaFinPermiso);
    v.add(descripcion);
    return v;
  }

public Integer getPermiso() {
            return permiso;
    }
    public void setPermiso(Integer permiso) {
            this.permiso = permiso;
    }
    public Integer getPerfil() {
            return perfil;
    }
    public void setPerfil(Integer perfil) {
            this.perfil = perfil;
    }
    public Integer getOpcionModulo(){
            return opcionModulo;
    }
    public void setOpcionModulo(Integer opcionModulo) {
            this.opcionModulo = opcionModulo;
    }
    public String getHoraInicioPermiso() {
            return this.horaInicioPermiso;
    }
    public void setHoraInicioPermiso(String horaInicioPermiso) {
            this.horaInicioPermiso = horaInicioPermiso;
    }
    public void setHoraFinPermiso(String horaFinPermiso) {
      this.horaFinPermiso = horaFinPermiso;
    }
    public String getHoraFinPermiso() {
      return this.horaFinPermiso;
    }
    public String getDescripcion() {
      return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   public void setContenido() throws SQLException {
     this.setPermiso(new Integer(rs.getInt("i_permiso")));
      this.setPerfil(new Integer(rs.getInt("i_perfil")));
      this.setOpcionModulo(new Integer(rs.getInt("i_opcionmodulo")));
      this.setHoraInicioPermiso((rs.getString("dt_horainipermiso")));
      this.setHoraFinPermiso((rs.getString("dt_horafinpermiso")));
      this.setDescripcion(rs.getString("c_descripcion"));
   }

   public void setContenido(Vector v)  {

    String auxS = v.elementAt(0).toString();
    Integer auxI = new Integer(auxS);
    if(auxI != null)
      this.setPermiso(auxI);
    else
      this.setPermiso(new Integer(0));

    auxS = v.elementAt(1).toString();
    auxI = new Integer(auxS);
    if(auxI != null)
      this.setPerfil(auxI);
    else
      this.setPerfil(new Integer(0));


    auxS = v.elementAt(2).toString();
    auxI = new Integer(auxS);
    if(auxI != null)
      this.setOpcionModulo(auxI);
    else
      this.setOpcionModulo(new Integer(0));

    this.setHoraInicioPermiso(v.elementAt(3).toString());
    this.setHoraFinPermiso(v.elementAt(4).toString());
    this.setDescripcion((String)v.elementAt(5));
  }

    public boolean referencia(Vector v){
      return true;
    }
}


