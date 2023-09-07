package com.framework.common.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Roger Padilla C.
 */
public class Usuario implements UserDetails, CredentialsContainer {

  private static final long serialVersionUID = 82649870384L;

  //~ Instance fields ================================================================================================
  private Integer id;
  private String username;
  private String password;
  private List<Perfil> authorities;
  private boolean accountNonExpired;
  private boolean credentialsNonExpired;
  private String estado;
  private String tipoIdentificacion;
  private String identificacion;
  private String nombres;
  private String apellidos;
  private String email;
  private String direccion;
  private String telefono;
    //Columnas de auditoria
    private String usuariosistemaultimamod;
    private String usuariobddatos;
    private Timestamp fechahoraultimamodificacion;
    private String tipomodificacion;
    private String cambiocontrasena;

  
  /**
   * Estado del usuario: "A"=activo, "B"=bloqueado, "I"=Inactivo, "E"=Eliminado
   */
  private Integer numeroSesiones;
  private Calendar ultimoLogin;
  private Calendar ultimoCambioClave;
  private Calendar ultimoCambioReintento;
  private Integer supervisorId;
  private Integer sbolsa;
  private String llaveCodifi;

    public Integer getSbolsa() {
        return sbolsa;
    }

    public void setSbolsa(Integer sbolsa) {
        this.sbolsa = sbolsa;
    }

  public Usuario() {
//    Perfil perfil = new Perfil();
//    perfil.setAuthority("Renta Fija");
//    perfil.setId(1);
//    perfil.setProceso(true);

    authorities = new ArrayList<Perfil>(1);
//    authorities.add(perfil);
  }

  public Usuario(Integer id, String login, String password, String estado, String email, Integer sbolsa, String direccion, String telefono,String identificacion, String usuariosistemaultimamod, 
                 String usuariobddatos, Timestamp fechahoraultimamodificacion, 
                 String tipomodificacion, String cambiocontrasena, String llaveCodifi) {
    this(id, login, password, estado, email, sbolsa, direccion,telefono,identificacion, null, usuariosistemaultimamod, usuariobddatos, fechahoraultimamodificacion, tipomodificacion, cambiocontrasena, llaveCodifi);
  }

  public Usuario(Integer id, String username, String password, String estado, String email, Integer sbolsa, String direccion,String telefono,String identificacion,
          List<Perfil> authorities, String usuariosistemaultimamod, 
                 String usuariobddatos, Timestamp fechahoraultimamodificacion, 
                 String tipomodificacion, String cambiocontrasena, String llaveCodifi) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email= email;
    this.sbolsa = sbolsa;
    this.accountNonExpired = true;
    this.credentialsNonExpired = true;
    this.authorities = authorities;
    this.estado = estado;
    this.direccion=direccion;
    this.telefono = telefono;
    this.identificacion=identificacion;
    this.usuariosistemaultimamod=usuariosistemaultimamod;
    this.usuariobddatos=usuariobddatos;
    this.fechahoraultimamodificacion=fechahoraultimamodificacion;
    this.tipomodificacion =tipomodificacion;
    this.cambiocontrasena=cambiocontrasena;
    this.llaveCodifi=llaveCodifi;
  }

  /**
   *
   * @return El estado actual del usuario: "A"=activo, "B"=bloqueado, "I"=Inactivo, "E"=Eliminado
   */
  public String getEstado() {
    return estado;
  }

  /**
   * IMPORTANTE: Usar setEnabled(boolean) y setAccountNonLocked(boolean) en su lugar.
   *
   * @param estado El estado del Usuario: "A"=activo, "B"=bloqueado, "I"=Inactivo, "E"=Eliminado
   */
  public void setEstado(String estado) {
    this.estado = estado;
  }

  //~ Methods ========================================================================================================

  @Override
  public boolean isEnabled() {
    return !"I".equalsIgnoreCase(getEstado());
  }

  public void setEnabled(boolean enabled) {
    this.estado = enabled ? "A" : "I";
  }

  @Override
  public boolean isAccountNonLocked() {
    return !"B".equalsIgnoreCase(getEstado());
  }

  public void setAccountNonLocked(boolean nonLocked) {
    this.estado = nonLocked ? "A" : "B";
  }

  @Override
  public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String getUsername() {
    return username;
  }
  
    public void setCambioContrasena(String cambiocontrasena) {
        this.cambiocontrasena = cambiocontrasena;
    }

    public String getCambioContrasena() {
        return cambiocontrasena;
    }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public List<Perfil> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(List<Perfil> authorities) {
    this.authorities = authorities;
  }

  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public String getTipoIdentificacion() {
    return tipoIdentificacion;
  }

  public void setTipoIdentificacion(String tipoIdentificacion) {
    this.tipoIdentificacion = tipoIdentificacion;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  
  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  
  
  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public String getNombreCompleto() {

    StringBuilder sb = new StringBuilder();

    if (nombres != null) {
      sb.append(nombres);
    }

    if (apellidos != null) {
      if (sb.length() > 0) { sb.append(" "); }
      sb.append(apellidos);
    }

    return sb.toString();
  }

  public Integer getNumeroSesiones() {
    return numeroSesiones;
  }

  public void setNumeroSesiones(Integer numeroSesiones) {
    this.numeroSesiones = numeroSesiones;
  }

  public Calendar getUltimoCambioClave() {
    return ultimoCambioClave;
  }

  public void setUltimoCambioClave(Calendar ultimoCambioClave) {
    this.ultimoCambioClave = ultimoCambioClave;
  }

  public Calendar getUltimoCambioReintento() {
    return ultimoCambioReintento;
  }

  public void setUltimoCambioReintento(Calendar ultimoCambioReintento) {
    this.ultimoCambioReintento = ultimoCambioReintento;
  }

  public Calendar getUltimoLogin() {
    return ultimoLogin;
  }

  public void setUltimoLogin(Calendar ultimoLogin) {
    this.ultimoLogin = ultimoLogin;
  }

  public Integer getSupervisorId() {
    return supervisorId;
  }

  public void setSupervisorId(Integer supervisorId) {
    this.supervisorId = supervisorId;
  }

  @Override
  public void eraseCredentials() {
    this.password = "";
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 47 * hash + (this.username != null ? this.username.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Usuario other = (Usuario) obj;
    if ((this.username == null) ? (other.username != null) : !this.username.equals(other.username)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder(200);
    sb.append(super.toString()).append(": ");
    sb.append("Username: ").append(username).append("; ");
    sb.append("Password: [PROTECTED]; ");
    sb.append("Enabled: ").append(isEnabled()).append("; ");
    sb.append("AccountNonExpired: ").append(accountNonExpired).append("; ");
    sb.append("CredentialsNonExpired: ").append(credentialsNonExpired).append("; ");
    sb.append("AccountNonLocked: ").append(isAccountNonLocked()).append("; ");
    sb.append("Nombres: ").append(nombres).append("; ");
    sb.append("Apellidos: ").append(apellidos).append("; ");
    sb.append("NumeroSesiones: ").append(numeroSesiones).append("; ");
    sb.append("Estado: ").append(estado).append("; ");
    sb.append("SupervisorId: ").append(supervisorId).append("; ");
        
    
    if (authorities != null && !authorities.isEmpty()) {
      sb.append("Granted Authorities: ");
      boolean first = true;
      for (Perfil auth : authorities) {
        if (!first) {
          sb.append(", ");
        }
        first = false;
        sb.append(auth);
      }
      sb.append("; ");
    } else {
      sb.append("Not granted any authorities").append("; ");
    }

    return sb.toString();
  }
  
  //*Columnas de auditoria
  
    public void setUsuariosistemaultimamod(String usuariosistemaultimamod) {
        this.usuariosistemaultimamod = usuariosistemaultimamod;
    }

    public void setUsuariobddatos(String usuariobddatos) {
        this.usuariobddatos = usuariobddatos;
    }

    public void setFechahoraultimamodificacion(Timestamp fechahoraultimamodificacion) {
        this.fechahoraultimamodificacion = fechahoraultimamodificacion;
    }

    public void setTipomodificacion(String tipomodificacion) {
        this.tipomodificacion = tipomodificacion;
    }

    public String getUsuariosistemaultimamod() {
        return usuariosistemaultimamod;
    }

    public String getUsuariobddatos() {
        return usuariobddatos;
    }

    public Timestamp getFechahoraultimamodificacion() {
        return fechahoraultimamodificacion;
    }

    public String getTipomodificacion() {
        return tipomodificacion;
    }
    
    public String getLlaveCodifi(){
        return llaveCodifi;
    }
    
    public void setLlaveCodifi(String llaveCodifi){
        this.llaveCodifi=llaveCodifi;
    }

  
}
