package com.quasar.frameq.seguridad;

import com.quasar.frameq.db.Persistente;
import java.sql.*;
import java.util.Vector;

public class RegAcceso extends Persistente
{
    private Integer registroAcceso;
    private Integer usuario;
    private Integer perfil;
    private Integer disptivoAutentica;
    private Date fecha;
    private Date horaInicio;
    private Date horaFinal;
    private String maquina;
    private String ipMaquina;
    private String estadoAcceso;
    private String usuarioDesbloqueo;
    private Date horaDesbloqueo;

    public RegAcceso() {
      this.setRegistroAcceso(new Integer(0));
      this.setUsuario(new Integer(0));
      this.setPerfil(new Integer(0));
      this.setDisptivoAutentica(new Integer(0));
      this.setFecha(new Date(java.util.Calendar.DATE));
      this.setHoraInicio(new Date(java.util.Calendar.DATE));
      this.setHoraFinal(new Date(java.util.Calendar.DATE));
      this.setMaquina("");
      this.setIpMaquina("");
      this.setEstadoAcceso((""));
      this.setUsuarioDesbloqueo("");
      this.setHoraDesbloqueo(new Date(java.util.Calendar.DATE));
    }
    public RegAcceso(Integer registroAcceso,Integer usuario,Integer perfil,
                     Integer disptivoAtentica,Date fecha,Date horaInicio,Date horaFinal,
                     String maquina,String ipMaquina,String estadoAcceso,String usuarioDesbloqueo,
                     Date horaDesbloqueo) {
      this.setRegistroAcceso(registroAcceso);
      this.setUsuario(usuario);
      this.setPerfil(perfil);
      this.setDisptivoAutentica(disptivoAtentica);
      this.setFecha(fecha);
      this.setHoraInicio(horaInicio);
      this.setHoraFinal(horaFinal);
      this.setMaquina(maquina);
      this.setIpMaquina(ipMaquina);
      this.setEstadoAcceso(estadoAcceso);
      this.setUsuarioDesbloqueo(usuarioDesbloqueo);
      this.setHoraDesbloqueo(horaDesbloqueo);
    }
    
public void inicializar ()  {
    setPersistente(this);
    String atributos[] = {"i_regacceso","i_usuario","i_perfil","i_dispoautentica",
                          "d_fecha","dt_horainicio","dt_horafin","c_maquina",
                          "c_ipmaquina","c_estadoacceso","c_usudesbqueo","dt_horadesbqueo"};

    setAtributos(atributos);
    setNombreTabla("fqs_regacceso");
    setElementosLLave(1);
  }

public Persistente nuevo (Vector v)  {
    return new RegAcceso ((Integer)v.elementAt(0),(Integer)v.elementAt(1),
              (Integer)v.elementAt(2),(Integer)v.elementAt(3),(Date)v.elementAt(4),
              (Date)v.elementAt(5),(Date)v.elementAt(6),(String)v.elementAt(7),
              (String)v.elementAt(8),(String)v.elementAt(9),(String)v.elementAt(10),
              (Date)v.elementAt(11));
  }

public Vector getContenido ()  {
    Vector v = new Vector();
    v.add(registroAcceso);
    v.add(usuario);
    v.add(perfil);
    v.add(disptivoAutentica);
    v.add(fecha);
    v.add(horaInicio);
    v.add(horaFinal);
    v.add(maquina);
    v.add(ipMaquina);
    v.add(estadoAcceso);
    v.add(usuarioDesbloqueo);
    v.add(horaDesbloqueo);
    return v;
  }

	public final Integer getRegistroAcceso()
	{
		return registroAcceso;
	}
	public void setRegistroAcceso(Integer registroAcceso)
	{
		this.registroAcceso = registroAcceso;
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
	public final Integer getDisptivoAutentica()
	{
		return disptivoAutentica;
	}
	public void setDisptivoAutentica(Integer disptivoAutentica)
	{
		this.disptivoAutentica = disptivoAutentica;
	}
	public final Date getFecha()
	{
		return fecha;
	}
	public void setFecha(Date setfecha)
	{
		this.fecha = setfecha;
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
	public final String getMaquina()
	{
		return maquina;
	}
	public void setMaquina(String maquina)
	{
		this.maquina = maquina;
	}
	public final String getIpMaquina()
	{
		return ipMaquina;
	}
	public void setIpMaquina(String ipMaquina)
	{
		this.ipMaquina = ipMaquina;
	}
	public final String getEstadoAcceso()
	{
		return estadoAcceso;
	}
	public void setEstadoAcceso(String estadoAcceso)
	{
		this.estadoAcceso = estadoAcceso;
	}
	public final String getUsuarioDesbloqueo()
	{
		return usuarioDesbloqueo;
	}
	public void setUsuarioDesbloqueo(String usuarioDesbloqueo)
	{
		this.usuarioDesbloqueo = usuarioDesbloqueo;
	}
	public final Date getHoraDesbloqueo()
	{
		return horaDesbloqueo;
	}
	public void setHoraDesbloqueo(Date horaDesbloqueo)
	{
		this.horaDesbloqueo = horaDesbloqueo;
	}
   public void setContenido() throws SQLException {
      this.setRegistroAcceso(new Integer(rs.getInt("i_regacceso")));
      this.setUsuario(new Integer(rs.getInt("i_usuario")));
      this.setPerfil(new Integer(rs.getInt("i_perfil")));
      this.setDisptivoAutentica(new Integer(rs.getInt("i_dispoautentica")));
      this.setFecha(rs.getDate("d_fecha"));
      this.setHoraInicio(rs.getDate("dt_horainicio"));
      this.setHoraFinal(rs.getDate("dt_horafin"));
      this.setMaquina((rs.getString("c_maquina")));
      this.setEstadoAcceso((rs.getString("c_ipmaquina")));
      this.setUsuarioDesbloqueo((rs.getString("c_estadoacceso")));
      this.setHoraDesbloqueo(rs.getDate("dt_horadesbqueo"));
   }

   public void setContenido(Vector v)  {

    String auxS = (String)v.elementAt(0);
    Integer auxI = new Integer(auxS);
    if(auxI != null)
      this.setRegistroAcceso(auxI);
    else
      this.setRegistroAcceso(new Integer(0));

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
      this.setDisptivoAutentica(auxI);
    else
      this.setDisptivoAutentica(new Integer(0));

    auxS = (String)v.elementAt(4);
    Date auxDa = Date.valueOf(auxS);
    if (auxDa != null)
      this.setFecha(auxDa);
    else
      this.setFecha(new Date(java.util.Calendar.DATE));

    auxS = (String)v.elementAt(5);
    auxDa = Date.valueOf(auxS);
    if (auxDa != null)
      this.setHoraInicio(auxDa);
    else
      this.setHoraInicio(new Date(java.util.Calendar.DATE));

    auxS = (String)v.elementAt(6);
    auxDa = Date.valueOf(auxS);
    if (auxDa != null)
      this.setHoraFinal(auxDa);
    else
      this.setHoraFinal(new Date(java.util.Calendar.DATE));

    this.setMaquina((String)v.elementAt(7));
    this.setIpMaquina((String)v.elementAt(8));
    this.setEstadoAcceso((String)v.elementAt(9));
    this.setUsuarioDesbloqueo((String)v.elementAt(10));

    auxS = (String)v.elementAt(11);
    auxDa = Date.valueOf(auxS);
    if (auxDa != null)
      this.setHoraDesbloqueo(auxDa);
    else
      this.setHoraDesbloqueo(new Date(java.util.Calendar.DATE));
  }

    public boolean referencia(Vector v){
      return true;
    }
}