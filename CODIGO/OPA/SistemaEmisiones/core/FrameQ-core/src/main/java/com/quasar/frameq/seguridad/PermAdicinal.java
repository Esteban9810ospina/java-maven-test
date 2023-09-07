package com.quasar.frameq.seguridad;

import com.quasar.frameq.db.Persistente;
import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

public class PermAdicinal extends Persistente {

    private Integer permisoAdicional;
    private Integer usuario;
    private Integer perfil;
    private Integer accionBD;
    private Integer tablaFuncion;
    private Integer moduloSistema;
    private Integer opcionModulo;
    private Date fecha;
    private Date horaInicio;
    private Date horaFinal;


    public PermAdicinal() {
      this.setPermisoAdicional(new Integer(0));
      this.setUsuario(new Integer(0));
      this.setPerfil(new Integer(0));
      this.setAccionBD(new Integer(0));
      this.setTablaFuncion(new Integer(0));
      this.setModuloSistema(new Integer(0));
      this.setOpcionModulo(new Integer(0));
      this.setFecha(new Date(java.util.Calendar.DATE));
      this.setHoraInicio(new Date(java.util.Calendar.DATE));
      this.setHoraFinal(new Date(java.util.Calendar.DATE));
    }

     public PermAdicinal(Integer permAdicional,Integer usuario,Integer perfil,
                         Integer accionBD,Integer tablaFuncion,Integer moduloSistema,
                         Integer opcionModulo,Date fecha,Date horaInicio,Date horaFinal) {

      this.setPermisoAdicional(permAdicional);
      this.setUsuario(usuario);
      this.setPerfil(perfil);
      this.setAccionBD(accionBD);
      this.setTablaFuncion(tablaFuncion);
      this.setModuloSistema(moduloSistema);
      this.setOpcionModulo(opcionModulo);
      this.setFecha(fecha);
      this.setHoraInicio(horaInicio);
      this.setHoraFinal(horaFinal);
    }
     
public void inicializar ()  {
    setPersistente(this);
    String atributos[] = {"i_permadicional","i_usuario","i_perfil","i_accionbd",
                          "i_tablafuncion","i_modulosistema","i_opcionmodulo",
                          "d_fecha","dt_horainicio","dt_horafin"};

    setAtributos(atributos);
    setNombreTabla("fqs_permadicinal");
    setElementosLLave(1);
  }

public Persistente nuevo (Vector v)  {
    return new PermAdicinal ((Integer)v.elementAt(0),(Integer)v.elementAt(1),
              (Integer)v.elementAt(2),(Integer)v.elementAt(3),(Integer)v.elementAt(4),
              (Integer)v.elementAt(5),(Integer)v.elementAt(6),(Date)v.elementAt(7),
              (Date)v.elementAt(8),(Date)v.elementAt(9));
  }

public Vector getContenido ()  {
    Vector v = new Vector();
    v.add( permisoAdicional);
    v.add(usuario);
    v.add(perfil);
    v.add(accionBD);
    v.add(tablaFuncion);
    v.add(moduloSistema);
    v.add(opcionModulo);
    v.add(fecha);
    v.add(horaInicio);
    v.add(horaFinal);
    return v;
  }

    public final Integer getPermisoAdicional()
    {
            return permisoAdicional;
    }
    public void setPermisoAdicional(Integer permisoAdicional)
    {
            this.permisoAdicional = permisoAdicional;
    }
    public final Integer getUsuario()
    {
            return usuario;
    }
    public void setUsuario(Integer usuario)
    {
            this.usuario = usuario;
    }
    public final Integer getPerfil()
    {
            return perfil;
    }
    public void setPerfil(Integer perfil)
    {
            this.perfil = perfil;
    }
    public final Integer getAccionBD()
    {
            return accionBD;
    }
    public void setAccionBD(Integer accionBD)
    {
            this.accionBD = accionBD;
    }
    public final Integer getTablaFuncion()
    {
            return tablaFuncion;
    }
    public void setTablaFuncion(Integer tablaFuncion)
    {
            this.tablaFuncion = tablaFuncion;
    }
    public final Integer getModuloSistema()
    {
            return moduloSistema;
    }
    public void setModuloSistema(Integer moduloSistema)
    {
            this.moduloSistema = moduloSistema;
    }
    public final Integer getOpcionModulo()
    {
            return opcionModulo;
    }
    public void setOpcionModulo(Integer opcionModulo)
    {
            this.opcionModulo = opcionModulo;
    }
    public final Date getFecha()
    {
            return fecha;
    }
    public void setFecha(Date fecha)
    {
            this.fecha = fecha;
    }
    public final Date getHoraInicio()
    {
            return horaInicio;
    }
    public void setHoraInicio(Date horaInicio)
    {
            this.horaInicio = horaInicio;
    }
    public final Date getHoraFinal()
    {
            return horaFinal;
    }
    public void setHoraFinal(Date horaFinal)
    {
            this.horaFinal = horaFinal;
    }

   public void setContenido() throws SQLException {
      this.setPermisoAdicional(new Integer(rs.getInt("i_permadicional")));
      this.setUsuario(new Integer(rs.getInt("i_usuario")));
      this.setPerfil(new Integer(rs.getInt("i_perfil")));
      this.setAccionBD(new Integer(rs.getInt("i_accionbd")));
      this.setTablaFuncion(new Integer(rs.getInt("i_tablafuncion")));
      this.setModuloSistema(new Integer(rs.getInt("i_modulosistema")));
      this.setOpcionModulo(new Integer(rs.getInt("i_opcionmodulo")));
      this.setFecha(rs.getDate("d_fecha"));
      this.setHoraInicio(rs.getDate("dt_horainicio"));
      this.setHoraFinal(rs.getDate("dt_horafin"));
   }

   public void setContenido(Vector v)  {

    String auxS = (String)v.elementAt(0);
    Integer auxI = new Integer(auxS);
    if(auxI != null)
      this.setPermisoAdicional(auxI);
    else
      this.setPermisoAdicional(new Integer(0));

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

    auxS = (String)v.elementAt(3);
    auxI = new Integer(auxS);
    if(auxI != null)
      this.setAccionBD(auxI);
    else
      this.setAccionBD(new Integer(0));

    auxS = (String)v.elementAt(4);
    auxI = new Integer(auxS);
    if(auxI != null)
      this.setTablaFuncion(auxI);
    else
      this.setTablaFuncion(new Integer(0));

    auxS = (String)v.elementAt(5);
    auxI = new Integer(auxS);
    if(auxI != null)
      this.setModuloSistema(auxI);
    else
      this.setModuloSistema(new Integer(0));

    auxS = (String)v.elementAt(6);
    auxI = new Integer(auxS);
    if(auxI != null)
      this.setOpcionModulo(auxI);
    else
      this.setOpcionModulo(new Integer(0));

    auxS = (String)v.elementAt(7);
    Date auxDa = Date.valueOf(auxS);
    if (auxDa != null)
      this.setFecha(auxDa);
    else
      this.setFecha(new Date(java.util.Calendar.DATE));

    auxS = (String)v.elementAt(8);
    auxDa = Date.valueOf(auxS);
    if (auxDa != null)
      this.setHoraInicio(auxDa);
    else
      this.setHoraInicio(new Date(java.util.Calendar.DATE));

    auxS = (String)v.elementAt(9);
    auxDa = Date.valueOf(auxS);
    if (auxDa != null)
      this.setHoraFinal(auxDa);
    else
      this.setHoraFinal(new Date(java.util.Calendar.DATE));
  }

    public boolean referencia(Vector v){
      return true;
    }
}