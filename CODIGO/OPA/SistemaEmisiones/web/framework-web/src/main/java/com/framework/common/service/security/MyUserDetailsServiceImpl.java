package com.framework.common.service.security;

import com.quasar.frameq.parametros.Parametro;
import com.framework.common.service.Auditoria;
import com.quasar.frameq.util.DateUtil;
import com.framework.common.domain.OpcionModulo;
import com.framework.common.domain.Perfil;
import com.framework.common.domain.Usuario;
import com.framework.common.domain.UsuarioReporte;
import com.framework.common.persistence.jdbc.rowmapper.PerfilMapper;
import com.framework.common.persistence.jdbc.rowmapper.UsuarioMapper;
import com.framework.common.persistence.jdbc.rowmapper.UsuarioPerfilMapper;
import com.framework.common.persistence.jdbc.rowmapper.UsuarioReporteMapper;
import com.framework.common.service.AbstractServiceDao;
import com.framework.reportEngine.config.Constantes;
import com.quasar.frameq.estructura.IpAutorizada;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
// import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author Roger Padilla C.
 */
@Service
public class MyUserDetailsServiceImpl extends AbstractServiceDao implements MyUserDetailsService {
    
     
    private static final Logger logger = Logger.getLogger(MyUserDetailsServiceImpl.class.getName());
    private static final long serialVersionUID = -4060635521427547423L;

    //~ Static fields/initializers =====================================================================================
    private static final String DEF_USUARIOS_BASIC_QUERY
            = "SELECT usr.i_usuario id, usr.c_login login, usr.c_contrasena contrasena, usr.c_llave_codificada llave_codificada"
            + ", usr.c_nombre nombres, usr.c_apellidos apellidos, usr.c_email email"
            + ", usr.c_tipo_identificacion tipo_identificacion, usr.c_identificacion identificacion"
            + ", usr.dt_ultimologin ultimo_login, usr.i_numsesiones numero_sesiones"
            + ", usr.f_ult_cambio_clave ultimo_cambio_clave"
            + ", usr.c_estado estado, usr.f_ult_cambio_reintento ultimo_cambio_reintento"
            + ", usr.i_usuariosupvisor supervisor_id, usr.c_direccion direccion, usr.c_telefono telefono, usr.i_cod_agente sbolsa"
            + ", usr.c_usuario_sistema_ultima_mod, usr.c_usuario_bd_datos, usr.ts_fecha_hora_ultimo_modificacion, usr.c_tipo_modificacion, usr.ty_cambiocontrasena"
            + " FROM fqs_usuario usr";
    private static final String DEF_USUARIO_BY_USERNAME_QUERY
            = DEF_USUARIOS_BASIC_QUERY
            + " WHERE usr.c_login = ?";
    private static final String DEF_USUARIO_BY_ID_QUERY
            = DEF_USUARIOS_BASIC_QUERY
            + " WHERE usr.i_usuario = ?";
    private static final String DEF_USUARIOS_SUPERVISADOS_QUERY
            = DEF_USUARIOS_BASIC_QUERY
            + " WHERE usr.i_usuariosupvisor = ?";
    private static final String DEF_PERFILES_QUERY
            = "SELECT rol.i_perfil id, rol.c_nombre nombre"
            + " FROM fqs_perfil rol";
    private static final String DEF_PERFILES_BY_USUARIO_QUERY
            = "SELECT rol.i_perfil id, rol.c_nombre nombre, usr_rol.c_proceso proceso"
            + " FROM fqs_perfil rol"
            + " INNER JOIN fqs_usuario_has_fqs_perfil usr_rol ON rol.i_perfil = usr_rol.fqs_perfil_i_perfil"
            + " INNER JOIN fqs_usuario usr ON usr.i_usuario = usr_rol.fqs_usuario_i_usuario"
            + " WHERE usr.i_usuario = ?";
    private static final String DEF_USUARIOS_LOG_ACCESS_QUERY
            = "INSERT INTO fqs_logusuariosadmin"
            + " (c_usuario, dt_horaingreso, c_paginaingreso, c_ipingresa)"
            + " VALUES (?, ?, ?, ?)";
    private static final String DEF_USUARIO_PASSWORDS_HISTORIAL_QUERY
            = "SELECT password FROM fqs_usuario_password_historial WHERE i_usuario = ?"
            + " ORDER BY id DESC LIMIT ?, ?";
    private static final String DEF_USUARIO_PASSWORD_QUERY
            = "SELECT c_contrasena FROM fqs_usuario WHERE i_usuario = ?";
    
    
    private static final String DEF_USUARIOS_REPORT_QUERY = "SELECT u.c_nombre nombres, u.c_apellidos apellidos, scb.i_codigoentidad scb, u.c_login login, p.c_nombre perfil, u.c_estado estado, u.c_email email, u.c_telefono telefono "
            + " FROM fqs_usuario u "
            + " LEFT JOIN fqs_usuario_has_fqs_perfil up ON u.i_usuario = up.fqs_usuario_i_usuario"
            + " LEFT JOIN fqs_perfil p ON up.fqs_perfil_i_perfil = p.i_perfil"
            + " LEFT JOIN dm_scb scb ON scb.i_scb = u.i_cod_agente";
  
    private static final String DEF_USUARIOS_REPORT_AND_NOMBRE = " u.c_nombre = '";
  
    private static final String DEF_USUARIOS_REPORT_AND_APELLIDOS = " u.c_apellidos = '";
  
    private static final String DEF_USUARIOS_REPORT_AND_LOGIN = " u.c_login = '";
  
    private static final String DEF_USUARIOS_REPORT_AND_CODIGO_ENTIDAD = " scb.i_codigoentidad = '";

//  @Autowired
//  protected PasswordEncoder passwordEncoder;
    @Autowired
    protected QuasarPasswordEncoder passwordEncoder;

    @Autowired
    private OpcionModuloService opcionModuloService;

    @Override
    public Usuario loadUserByUsername(String login) throws UsernameNotFoundException {

        Usuario usuario;

        try {
           
            usuario = getJdbcTemplate().queryForObject(DEF_USUARIO_BY_USERNAME_QUERY, new UsuarioMapper(), login.toLowerCase());
            List<Perfil> perfiles = findPerfilesByUsuario(usuario);
            usuario.setAuthorities(perfiles);
            
        } catch (EmptyResultDataAccessException exc) {
            String msg = getMessage("error.user_not_found", login);
            logger.debug("OPA - " + msg);
            throw new UsernameNotFoundException(msg, exc);
        }
        
        return usuario;
    }

    @Override
    public Usuario findUsuarioById(Integer id) {

        Usuario usuario;

        try {
            
            usuario = getJdbcTemplate().queryForObject(DEF_USUARIO_BY_ID_QUERY, new UsuarioMapper(), id);
            List<Perfil> perfiles = findPerfilesByUsuario(usuario);
            usuario.setAuthorities(perfiles);
            
        } catch (EmptyResultDataAccessException exc) {
            String msg = getMessage("error.user_not_found", id);
            logger.debug("OPA - " + msg);
            throw exc;
        }

        return usuario;
    }

    /**
     * Loads authorities
     *
     * @return a list of GrantedAuthority objects for the user
     */
    @Override
    public List<Perfil> findPerfilesByUsuario(Usuario usuario) {
        
        return getJdbcTemplate().query(DEF_PERFILES_BY_USUARIO_QUERY, new UsuarioPerfilMapper(),
                usuario.getId());        
        
    }

    protected String getUsuarioIpRemota() {
        //AJUSTE IP REGISTRADA
        
        String remoteAddr = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getHeader("X-Forwarded-For");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
        }else {
            String ips[] = remoteAddr.split(",");
            remoteAddr = ips[0];
            return remoteAddr;
        }                   
        
        
        //return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
        //
    }

    @Override
    public List<Perfil> findPerfilesOpcionesModuloUsuarioAutenticado() {
        List<Perfil> perfiles = Collections.emptyList();
        Usuario usuario = getUsuarioAutenticado();
        if (usuario != null) {
            perfiles = opcionModuloService.findPerfilesOpcionesModulo(usuario);
        }
        
        return perfiles;
    }

    @Override
    public List<Usuario> findUsuarios() {
        List<Usuario> usuarios = getJdbcTemplate().query(DEF_USUARIOS_BASIC_QUERY, new UsuarioMapper());
        return usuarios;
    }
    
    @Override
    public List<UsuarioReporte> findUsuariosReporte(String nombre, String apellido, String login, String scb) {
        
        String query = DEF_USUARIOS_REPORT_QUERY;
        boolean where = false;
        
        if (nombre != null && !nombre.isEmpty()) {
            
            if (!where) {
                query = String.valueOf(query) + " WHERE ";
                where = true;
            } else {
                query = String.valueOf(query) + " AND ";
            }
            
            query = String.valueOf(query) + " u.c_nombre LIKE '" + nombre + "%'";
            
        }
        
        if (apellido != null && !apellido.isEmpty()) {
            
            if (!where) {
                query = String.valueOf(query) + " WHERE ";
                where = true;
            } else {
                query = String.valueOf(query) + " AND ";
            }
            
            query = String.valueOf(query) + " u.c_apellidos LIKE '" + apellido + "%'";
            
        }
        
        if (login != null && !login.isEmpty()) {
            
            if (!where) {
                query = String.valueOf(query) + " WHERE ";
                where = true;
            } else {
                query = String.valueOf(query) + " AND ";
            }
            
            query = String.valueOf(query) + " u.c_login LIKE '" + login + "%'";
            
        }
        
        if (scb != null && !scb.isEmpty()) {
            
            if (!where) {
                query = String.valueOf(query) + " WHERE ";
                where = true;
            } else {
                query = String.valueOf(query) + " AND ";
            }
            
            query = String.valueOf(query) + " scb.i_codigoentidad LIKE '" + scb + "%'";
        }
        
        System.out.println("query: " + query);
        
        return getJdbcTemplate().query(query, new UsuarioReporteMapper());
    }

    @Override
    public List<Usuario> findUsuariosExceptAutenticado() {
        List<Usuario> usuarios = findUsuarios();
        return usuarios;
    }

    @Override
    public List<Perfil> findPerfiles() {
        return getJdbcTemplate().query(DEF_PERFILES_QUERY, new PerfilMapper());
    }

    @Override
    public List<Usuario> findUsuariosSupervisados(Usuario usuario) {
        return getJdbcTemplate().query(DEF_USUARIOS_SUPERVISADOS_QUERY, new Object[]{usuario.getId()}, new UsuarioMapper());
    }

    @Override
    public boolean isSupervisor(Usuario usuario) {
        List<Usuario> usuarios = findUsuarios();

        for (Usuario user : usuarios) {
            if (user.getSupervisorId().equals(usuario.getId())) {
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    @Transactional
    public Usuario saveUsuario(Usuario usuario, Auditoria auditoria, String perfil, ArrayList<IpAutorizada> ipAutorizadas) {
        
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String usuarioQuery;
        String perf= perfil;
        Integer numeroSesiones = 0;
        
        String password = usuario.getLlaveCodifi();
        System.out.println("PASSWORD KEY SAVE = " + password);
        
        String baseQuery = "fqs_usuario SET c_nombre=:nombres, c_apellidos=:apellidos"
                + ", i_numsesiones=:numeroSesiones, c_estado=:estado, c_email=:email, "
                + " i_usuariosupvisor   =:supervisorId, c_direccion=:direccion, c_telefono=:telefono, "
                + " c_identificacion=:identificacion, c_tipo_identificacion=:tipoIdentificacion, "
                + " i_cod_agente=:sbolsa, "
                + " c_usuario_sistema_ultima_mod=:usuariosistemaultimamod, "
                + " c_tipo_modificacion=:tipomodificacion";

        String baseQueryInsert = "fqs_usuario SET c_nombre=:nombres, c_apellidos=:apellidos"
                + ", i_numsesiones=:numeroSesiones, c_estado=:estado, c_email=:email, "
                + " i_usuariosupvisor=:supervisorId, c_direccion=:direccion, c_telefono=:telefono, "
                + " c_identificacion=:identificacion, c_login=LOWER(:username), c_tipo_identificacion=:tipoIdentificacion, "
                + " i_cod_agente=:sbolsa, " 
                + " c_usuario_sistema_ultima_mod=:usuariosistemaultimamod, " 
                + " c_tipo_modificacion=:tipomodificacion";

        SqlParameterSource params = new BeanPropertySqlParameterSource(usuario);

       
        
        if (usuario.getId() == null) {
            usuario.setNumeroSesiones(0);
            usuarioQuery = "INSERT INTO " + baseQueryInsert;
            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedTemplate.update(usuarioQuery, params, keyHolder);
            usuario.setId(keyHolder.getKey().intValue());

        } else {

            Parametro param = new Parametro();
            try {

                param.consultaG("select i_usuario, c_tipo_identificacion, c_identificacion, c_nombre, c_apellidos,"
                        + "c_direccion, c_telefono, c_email, c_login, c_contrasena, c_llave_codificada, dt_ultimologin, i_empresa,"
                        + "i_usuario_padre, c_estado, f_ult_cambio_clave,"
                        + "f_ult_cambio_reintento, sesion, i_cod_agente"
                        + " from fqs_usuario where i_usuario=" + usuario.getId() + " ");
               
                if (param.rs.first()) {
                    String emanu = "";
                    String emavi = "";
                    if (!(param.rs.getString("c_email") == null)) {
                        emavi = param.rs.getString("c_email");
                    }
                    if (!(usuario.getEmail() == null)) {
                        emanu = usuario.getEmail();
                    }

                    if (!emanu.equalsIgnoreCase(emavi)) {

                    }

                    String identinu = "";
                    String identivi = "";
                    if (!(param.rs.getString("c_identificacion") == null)) {
                        identivi = param.rs.getString("c_identificacion");
                    }
                    if (!(usuario.getIdentificacion() == null)) {
                        identinu = usuario.getIdentificacion();
                    }

                    if (!identivi.equalsIgnoreCase(identinu)) {

                    }
                                        
                    String ctipoant = "";
                    String ctipodes = "";
                    if (!(param.rs.getString("c_tipo_identificacion") == null)) {
                        ctipodes = param.rs.getString("c_tipo_identificacion");
                    }
                    if (!(usuario.getTipoIdentificacion()== null)) {
                        ctipoant = usuario.getTipoIdentificacion();
                    }

                    if (!ctipodes.equalsIgnoreCase(ctipoant)) {
                    }
          
                    if (!param.rs.getString("c_nombre").equalsIgnoreCase(usuario.getNombres())) {

                    }
                    if (!param.rs.getString("c_apellidos").equalsIgnoreCase(usuario.getApellidos())) {

                    }

                    String direccionnu = "";
                    String direccionvi = "";
                    if (!(param.rs.getString("c_direccion") == null)) {
                        direccionvi = param.rs.getString("c_direccion");
                    }
                    if (!(usuario.getDireccion() == null)) {
                        direccionnu = usuario.getDireccion();
                    }
                    if (!direccionnu.equalsIgnoreCase(direccionvi)) {

                    }

                    String telnnu = "";
                    String telvi = "";
                    if (!(param.rs.getString("c_telefono") == null)) {
                        telvi = param.rs.getString("c_telefono");
                    }
                    if (!(usuario.getTelefono() == null)) {
                        telnnu = usuario.getTelefono();
                    }

                    if (!telnnu.equalsIgnoreCase(telvi)) {

                    }

                }
            } catch (SQLException ex) {
                logger.error("OPA - " + MyUserDetailsServiceImpl.class.getName(), ex);	
            }finally{
                param.cerrarConexiones();
            }
            usuario.setNumeroSesiones(0);
            
            usuarioQuery = "UPDATE " + baseQuery + " WHERE i_usuario=:id";
            
            

            Parametro para = new Parametro();
            try {
                para.consultaG("select c_estado from fqs_usuario where i_usuario=" + usuario.getId().toString() + " ");
                if (para.rs.first()) {

                    String estadoantiguo = para.rs.getString("c_estado");
                    if (!estadoantiguo.equalsIgnoreCase(usuario.getEstado())) {

                        String estado = "";
                        if (usuario.getEstado().equals("B")) {
                            estado = "Bloqueado";

                        } else if (usuario.getEstado().equals("I")) {
                            estado = "Inactivo";
                        } else if (usuario.getEstado().equals("A")) {
                            estado = "Activo";
                        } else if (usuario.getEstado().equals("E")) {
                            estado = "Eliminado";
                        }
                        

                        /////  
                        if ((estadoantiguo.equals("B") && usuario.getEstado().equals("A"))) {
                            auditoria.setEvento("Desbloqueo de usuario " + usuario.getUsername().toString());
                            usuario.setNumeroSesiones(0);

                        } else if (estadoantiguo.equals("A") && usuario.getEstado().equals("B")) {
                            auditoria.setEvento("Bloqueo de usuario " + usuario.getUsername().toString());
                            usuario.setNumeroSesiones(0);
                        } else {
                            if (estadoantiguo.equals("B")) {
                                estadoantiguo = "Bloqueado";

                            } else if (estadoantiguo.equals("I")) {
                                estadoantiguo = "Inactivo";
                            } else if (estadoantiguo.equals("A")) {
                                estadoantiguo = "Activo";
                            } else if (estadoantiguo.equals("E")) {
                                estadoantiguo = "Eliminado";
                            }

                            auditoria.setEvento("Modificación de estado de usuario " + usuario.getUsername().toString() + " de " + estadoantiguo + " a " + estado);
                        }
                        auditoria.setResultado("Exitoso");

                    }
                }

            } catch (SQLException ex) {
                logger.error("OPA - " + MyUserDetailsServiceImpl.class.getName(), ex);
            }finally{
                para.cerrarConexiones();
            }

            namedTemplate.update(usuarioQuery, params);

        }

        if (usuario.getPassword() != null && !usuario.getPassword().isEmpty()) {
            updateUsuarioPassword(usuario);
        }  
        
              updateUsuarioPerfiles(usuario, perf);
         Parametro param = new Parametro();
         try {
            //Inserta IP
            Iterator<IpAutorizada> myitera = ipAutorizadas.iterator();
             param.actualiza("DELETE FROM fqs_IpAutorizada where ip_usuario=?",usuario.getId());
            while (myitera.hasNext()) {
                IpAutorizada elemento = myitera.next();
                    param.actualiza("INSERT INTO fqs_IpAutorizada (ip_usuario,ip, c_usuario_sistema_ultima_mod, ts_fecha_hora_ultima_modificacion, c_tipo_modificacion) VALUES (?,?,?,NOW(),?) ", usuario.getId(), elemento.getIp(), elemento.getUsuarioSistema(), elemento.getTipoModificacion());
            }
         } catch (SQLException ex) {
             logger.error("OPA - " + MyUserDetailsServiceImpl.class.getName(), ex);
         } finally  {
             param.cerrarConexiones();
         }
              

        return usuario;
    }

    @Override
    @Transactional
    public Usuario saveUsuarioBloqueado(Usuario usuario, Integer usuarioautentica) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String estado = "";
        String usuarioQuery;
        Integer numeroSesiones = 0;

        String baseQuery = "fqs_usuario SET c_nombre=:nombres, c_apellidos=:apellidos"
                + ", i_numsesiones=:numeroSesiones, c_estado=:estado, i_usuariosupvisor=:supervisorId";

        String baseQueryInsert = "fqs_usuario SET c_nombre=:nombres, c_apellidos=:apellidos"
                + ", i_numsesiones=:numeroSesiones, c_estado=:estado, i_usuariosupvisor=:supervisorId, c_login=:username";

        SqlParameterSource params = new BeanPropertySqlParameterSource(usuario);

        if (usuario.getId() == null) {
            usuarioQuery = "INSERT INTO " + baseQueryInsert;
            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedTemplate.update(usuarioQuery, params, keyHolder);
            usuario.setId(keyHolder.getKey().intValue());
        } else {

          //  Auditoria auditorias = new Auditoria();
        //auditorias.setIp();
            //String estado="";
            if (usuario.getEstado().equals("B")) {
                estado = "Bloqueado";

            } else if (usuario.getEstado().equals("I")) {
                estado = "Inactivo";
            } else if (usuario.getEstado().equals("A")) {
                estado = "Activo";
            } else if (usuario.getEstado().equals("E")) {
                estado = "Eliminado";
            }

            Parametro para = new Parametro();
            try {
                para.consultaG("select c_estado from fqs_usuario where i_usuario=" + usuario.getId().toString() + " ");
                if (para.rs.first()) {

                    String estadoantiguo = para.rs.getString("c_estado");
                    if (!estadoantiguo.equalsIgnoreCase(usuario.getEstado())) {

                        if (usuario.getEstado().equals("B")) {
                            estado = "Bloqueado";

                        } else if (usuario.getEstado().equals("I")) {
                            estado = "Inactivo";
                        } else if (usuario.getEstado().equals("A")) {
                            estado = "Activo";
                        } else if (usuario.getEstado().equals("E")) {
                            estado = "Eliminado";
                        }
                        /////  
                        if ((estadoantiguo.equals("B") && usuario.getEstado().equals("A"))) {
                            usuario.setNumeroSesiones(0);

                        } else if (estadoantiguo.equals("A") && usuario.getEstado().equals("B")) {
                            usuario.setNumeroSesiones(0);

                        } else {
                            if (estadoantiguo.equals("B")) {
                                estadoantiguo = "Bloqueado";
                            } else if (estadoantiguo.equals("I")) {
                                estadoantiguo = "Inactivo";
                            } else if (estadoantiguo.equals("A")) {
                                estadoantiguo = "Activo";
                            } else if (estadoantiguo.equals("E")) {
                                estadoantiguo = "Eliminado";
                            }
                        }


                    }
                }
            } catch (SQLException ex) {
                logger.error("OPA - " + MyUserDetailsServiceImpl.class.getName(), ex);
            }finally{
                para.cerrarConexiones();
            }
            usuario.setNumeroSesiones(0);
            usuarioQuery = "UPDATE " + baseQuery + " WHERE i_usuario=:id";
            namedTemplate.update(usuarioQuery, params);
        }

        return usuario;
    }

    @Override
    @Transactional
    public void updateUsuarioPassword(Usuario usuario) {

        String password = encodePassword(usuario.getPassword(), usuario);
        usuario.setPassword(password);
        usuario.setCambioContrasena("0");

        String updatePasswordQuery = "UPDATE fqs_usuario SET c_contrasena=?, f_ult_cambio_clave=? ,ty_cambiocontrasena=?, c_llave_codificada=?"
                + " WHERE i_usuario=?";

        getJdbcTemplate().update(updatePasswordQuery, usuario.getPassword(), Calendar.getInstance().getTime(),
                usuario.getCambioContrasena(),usuario.getLlaveCodifi(), usuario.getId());
        
        logUpdatePassword(usuario);

    }
    
    @Transactional
    private void updateUsuarioPerfiles(final Usuario usuario, final String perfil) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Parametro para = new Parametro();
        boolean modifica = false;
        Collection<Perfil> perfiles = usuario.getAuthorities();
        final Perfil[] perfilesArr = perfiles.toArray(new Perfil[perfiles.size()]);
        String nuevos = "";
        for (int i = 0; i < perfilesArr.length; i++) {
            if (nuevos.equalsIgnoreCase("")) {
                nuevos = nuevos + "" + perfilesArr[i].getAuthority();
            } else {
                nuevos = nuevos + ", " + perfilesArr[i].getAuthority();
            }
            try {
                para.consultaG("select fqs_usuario_i_usuario from fqs_usuario_has_fqs_perfil where fqs_usuario_i_usuario=" + usuario.getId() + " and fqs_perfil_i_perfil=" + perfilesArr[i].getId() + " and c_proceso='" + (perfilesArr[i].isProceso() ? "S" : "N") + "'");
                if (!para.rs.first()) {
                    modifica = true;
                }

            } catch (SQLException ex) {
                logger.error("OPA - " + MyUserDetailsServiceImpl.class.getName(), ex);
            }finally{
                para.cerrarConexiones();
            }

        }
        try {
            para.consultaG("select count(fqs_usuario_i_usuario) AS cuenta from fqs_usuario_has_fqs_perfil where fqs_usuario_i_usuario=" + usuario.getId());
            if (para.rs.first()) {

                if (!(para.rs.getInt("cuenta") == perfilesArr.length)) {
                    modifica = true;
                }

            }

        } catch (SQLException ex) {
            logger.error("OPA - " + MyUserDetailsServiceImpl.class.getName(), ex);
        }finally{
            para.cerrarConexiones();
        }
        String antiguos = "";
        try {
            para.consultaG("SELECT c_nombre FROM fqs_usuario_has_fqs_perfil,fqs_perfil  WHERE fqs_perfil.i_perfil=fqs_usuario_has_fqs_perfil.fqs_perfil_i_perfil AND fqs_usuario_i_usuario=?", usuario.getId());
            if (para.rs.first()) {

                do {
                    if (antiguos.equalsIgnoreCase("")) {
                        antiguos = antiguos + "" + para.rs.getString("c_nombre");
                    } else {
                        antiguos = antiguos + ", " + para.rs.getString("c_nombre");
                    }

                } while (para.rs.next());

            }
        } catch (SQLException ex) {
            logger.error("OPA - " + MyUserDetailsServiceImpl.class.getName(), ex);
        }finally{
            para.cerrarConexiones();
            
        }

        getJdbcTemplate().update("DELETE FROM fqs_usuario_has_fqs_perfil"
                + " WHERE fqs_usuario_i_usuario = ?", usuario.getId());

        String sql = "INSERT INTO fqs_usuario_has_fqs_perfil"
                + " (fqs_usuario_i_usuario, fqs_perfil_i_perfil, c_proceso) VALUES (?, ?, ?)";

        if (modifica) {

        }

        getJdbcTemplate().update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                int i = 0;
                
                ps.setInt(++i, usuario.getId());
                ps.setInt(++i, Integer.parseInt(perfil));                
                ps.setString(++i, "N");
            
            }
        });
        
        
        
        
    }

    @Override
    public String findUsuarioPassword(Integer usuarioId) {
        return getJdbcTemplate().queryForObject(DEF_USUARIO_PASSWORD_QUERY, String.class, usuarioId);
    }

    @Override
    public List<String> findUsuarioPasswordsHistorial(Integer usuarioId) {

        int historialRestriccion = appConfigParams.getGeneric().getPasswordHistorialRestriccion();

        List<String> history = getJdbcTemplate().queryForList(DEF_USUARIO_PASSWORDS_HISTORIAL_QUERY,
                String.class, usuarioId, 0, historialRestriccion);

        return history;
    }

    @Override
    public String encodePassword(String rawPassword, Usuario usuario) {
        return passwordEncoder.encodePassword(rawPassword, Constantes.SALT, usuario);
    }

    @Override
    public boolean isPasswordValid(String encryptedPassword, String rawPassword, String pass) {
        return passwordEncoder.isPasswordValid(encryptedPassword, rawPassword, pass, Constantes.SALT);
    }
    
    @Override
    public String validPassword(String rawPassword, Usuario usuario) {
        return passwordEncoder.validPassword(rawPassword, usuario);
    }
    
    @Override
    public String decript(String rawPassword, String encPass, Usuario usuario, int valor) {
        return passwordEncoder.decript(rawPassword, encPass, usuario, valor);
    }


    private void logUpdatePassword(final Usuario usuario) {
        String query = "INSERT INTO fqs_usuario_password_historial"
                + " (i_usuario, password, llave_codificada , fecha, i_usuario_modificador)"
                + " VALUES (?, ?, ?, ?, ?)";
        getJdbcTemplate().update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, usuario.getId());
                ps.setString(2, usuario.getPassword());
                ps.setString(3, usuario.getLlaveCodifi());
                ps.setString(4, DateUtil.currentDateAsDateTimeString());
                ps.setInt(5, getUsuarioAutenticado().getId());
                Auditoria audi = new Auditoria();
                audi.setid();
                audi.setResultado("Exitoso");
                audi.setEvento("Modificación de password a usuario " + usuario.getUsername());
            }
        });

    }

    @Override
    public void logAccess(final OpcionModulo opcionModulo) {
        logAccess(opcionModulo.getNombre());
    }

    @Override
    public void logAccess(final String message) {
        
        final Usuario usuario = getUsuarioAutenticado();
        final String remoteIpAddress = getUsuarioIpRemota();
        final String currentDate = DateUtil.currentDateAsDateTimeString();
        
        try {
            
            
            getJdbcTemplate().update(DEF_USUARIOS_LOG_ACCESS_QUERY, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, usuario.getUsername());
                ps.setString(2, currentDate);
                ps.setString(3, message);
                ps.setString(4, remoteIpAddress);
            }
        });
        
        getJdbcTemplate().getDataSource().getConnection().close();
        
        } catch(SQLException e) {
            logger.error(e);
        }
    }

    @Override
    public void logAuthentication(Usuario usuario) {
        getJdbcTemplate().update("UPDATE fqs_usuario SET dt_ultimologin = ?, i_numsesiones = 0"
                + " WHERE i_usuario = ?",
                Calendar.getInstance().getTime(), usuario.getId());
    }

    /**
     * Register an authentication attempt using a wrong password
     *
     * @param usuario
     * @return flag saying if the user was blocked
     */
    @Override
    public boolean logAuthenticationAttemptWrongPassword(Usuario usuario) {

        boolean locked = false;

        usuario.setNumeroSesiones(usuario.getNumeroSesiones() + 1);

        // Incrementa el numero de intentos fallidos de logueo
        StringBuilder baseQuery = new StringBuilder(
                "UPDATE fqs_usuario SET i_numsesiones = i_numsesiones+1, f_ult_cambio_reintento = ?");

        if (usuario.getNumeroSesiones() > appConfigParams.getGeneric().getAutenticacionIntentosFallidosBloqueo()) {
            locked = true;
            // Bloquea la cuenta si se supera el maximo numero de reintentos
            baseQuery.append(", c_estado = 'B'");
        }

        baseQuery.append("WHERE i_usuario = ?");

        getJdbcTemplate().update(baseQuery.toString(),
                Calendar.getInstance().getTime(),
                usuario.getId());

        return locked;
    }

    @Override
    public void logAuthenticationAttemptLocked(Usuario usuario, boolean isPasswordValid) {
        getJdbcTemplate().update("UPDATE fqs_usuario SET f_ult_cambio_reintento = ? WHERE i_usuario = ?",
                Calendar.getInstance().getTime(), usuario.getId());
    }
    
 
    public void updateUsuarioContrasena(String contrasena, int id, Usuario usuario) {
       Parametro param = new Parametro();
        
        String password = encodePassword(contrasena, usuario);
        
        String key = usuario.getLlaveCodifi();        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dNow = new java.util.Date();            
        String fechaActual = df.format(dNow); 
        
        SimpleDateFormat dj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date dNowHora = new java.util.Date();            
        String fechaHora = dj.format(dNowHora); 
        
        getJdbcTemplate().update("UPDATE fqs_usuario SET f_ult_cambio_clave=?, ty_cambiocontrasena=1, c_contrasena=?, c_llave_codificada=?"
               + " WHERE i_usuario=?", fechaActual, password, key, id);
        
         try { 
             param.actualiza("INSERT INTO fqs_usuario_password_historial (i_usuario, password, llave_codificada , fecha, i_usuario_modificador)  VALUES (?, ?, ?, ?, ?)", id ,password, key, fechaHora,id);
         } catch (SQLException ex) {
             logger.error("OPA - " + MyUserDetailsServiceImpl.class.getName(), ex);
         } finally  {
             param.cerrarConexiones();
         }

    }


    @Override
    public boolean mostrarCaptcha() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        boolean mostrar = false;
        Parametro para = new Parametro();

        try {
            para.consultaG("select c_valor from fqs_parametro where i_parametro=?", 20001);
            if (para.rs.first()) {
                if (para.rs.getBoolean("c_valor") == true) {
                    mostrar = true;
                }
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + MyUserDetailsServiceImpl.class.getName(), ex);
        } finally {
            para.cerrarConexiones();
        }

        return mostrar;
    }

    @Override
    public boolean isIpValid(String ip, int id) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        boolean validaIp = false;
        Parametro parametroIp = new Parametro();

        try {
            parametroIp.consultaG("select * from fqs_IpAutorizada where ip_usuario=? and ip=?", id, ip);
            if (parametroIp.rs.first()) {
                validaIp = true;
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + MyUserDetailsServiceImpl.class.getName(), ex);
        } finally {

            parametroIp.cerrarConexiones();
        }

        return validaIp;
    }

    @Override
    public boolean isDateValid() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        boolean validaFecha = true;
        Parametro parametroIp = new Parametro();
        Calendar gc=GregorianCalendar.getInstance();
        try {
            parametroIp.consultaG("select * from fqs_festivo where d_fecha=? ",new Date(gc.getTimeInMillis()));
            if (parametroIp.rs.first()) {
                validaFecha = false;
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + MyUserDetailsServiceImpl.class.getName(), ex);
        } finally {
            parametroIp.cerrarConexiones();
        }
        return validaFecha;
    }

    @Override
    public boolean isDateBefore() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        boolean validaFecha = true;
        Parametro parametroIp = new Parametro();
        Calendar gc=GregorianCalendar.getInstance();
        try {
            parametroIp.consultaG("select FechaIniOperacion from fqs_Parametrizacion where FechaIniOperacion > ? ",new Date(gc.getTimeInMillis()));
            if (parametroIp.rs.first()) {
                validaFecha = false;
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + MyUserDetailsServiceImpl.class.getName(), ex);
        } finally {
            parametroIp.cerrarConexiones();
        }
        return validaFecha;
    }

    @Override
    public boolean isDateAfter() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        boolean validaFecha = true;
        Parametro parametroIp = new Parametro();
        Calendar gc=GregorianCalendar.getInstance();
        try {
            parametroIp.consultaG("select FechaFinOperacion from fqs_Parametrizacion where FechaFinOperacion < ? ",new Date(gc.getTimeInMillis()));
            if (parametroIp.rs.first()) {
                validaFecha = false;
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + MyUserDetailsServiceImpl.class.getName(), ex);
        } finally {
            parametroIp.cerrarConexiones();
        }
        return validaFecha;
    }

    
    @Override
    public boolean isPerfilValid(int iduser) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        boolean validaPerfil = true;
        Parametro parametroIp = new Parametro();
        try {
            parametroIp.consultaG("select * from fqs_usuario_has_fqs_perfil where fqs_usuario_i_usuario=? and fqs_perfil_i_perfil in (1,4) ", iduser);
            if (parametroIp.rs.first()) {
                validaPerfil = false;
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + MyUserDetailsServiceImpl.class.getName(), ex);
        } finally {
            parametroIp.cerrarConexiones();
        }
        return validaPerfil;
    }

    
    @Override
    public boolean paramIp() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        boolean paramIp = false;
        Parametro parametroIp = new Parametro();

        try {
            parametroIp.consultaG("select c_valor from fqs_parametro where i_parametro=? ", 20000);
            if (parametroIp.rs.first()) {
                boolean pa = Boolean.valueOf(parametroIp.rs.getString("c_valor"));
                if (pa == true) {
                    paramIp = true;
                }
            }

        } catch (SQLException ex) {
            logger.error("OPA - " + MyUserDetailsServiceImpl.class.getName(), ex);
        } finally {

            parametroIp.cerrarConexiones();
        }

        return paramIp;
    }
    
    public int inactividad(){
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        int timeout = 0;
        Parametro parametroInactividad = new Parametro();
        try {
            parametroInactividad.consultaG2("select c_valor from fqs_parametro where i_parametro=? ", 20003);
            if (parametroInactividad.rs.first()){
                timeout = parametroInactividad.rs.getInt("c_valor");
            }
        } catch (SQLException e) {
            logger.error("OPA - " + MyUserDetailsServiceImpl.class.getName(), e);
        }finally{
            parametroInactividad.cerrarConexiones();
        }
        return timeout;
    }
    
    @Override
    public void logAuthenticationVerificacionLocked(Usuario usuario) {

        usuario.setNumeroSesiones(usuario.getNumeroSesiones());

        // Incrementa el numero de intentos fallidos de logueo
        StringBuilder baseQuery = new StringBuilder();

        if (usuario.getNumeroSesiones().equals(appConfigParams.getGeneric().getAutenticacionIntentosFallidosBloqueo())) {
            // Bloquea la cuenta si se supera el maximo numero de reintentos
            baseQuery.append("UPDATE fqs_usuario SET c_estado = 'B', f_ult_cambio_reintento = ? WHERE i_usuario = ?");
        }
        

        if (!baseQuery.toString().equals(""))
            getJdbcTemplate().update(baseQuery.toString(),
                    Calendar.getInstance().getTime(),
                    usuario.getId());
    }

    @Override
    public void updateUsuarioPass(Usuario usuario) {
        usuario.setCambioContrasena("0");

        String updatePasswordQuery = "UPDATE fqs_usuario SET ty_cambiocontrasena=?"
                + " WHERE i_usuario=?";

        getJdbcTemplate().update(updatePasswordQuery,usuario.getCambioContrasena(), usuario.getId());
    }
     
    public String getCaptchaKeyPublic() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String key = null;
        Parametro para = new Parametro();

        try {
            para.consultaG("select a.c_valor from fqs_parametro a where a.i_parametro=?", 20012);
            if (para.rs.first()) {
               return  para.rs.getString("c_valor");                  
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + MyUserDetailsServiceImpl.class.getName(), ex);
        } finally {
            para.cerrarConexiones();
        }

        return key;
    }
    
   
    public String getCaptchaKeyPrivate() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String key = null;
        Parametro para = new Parametro();

        try {
            para.consultaG("select a.c_valor from fqs_parametro a where a.i_parametro=?", 20013);
            if (para.rs.first()) {
               return  para.rs.getString("c_valor");                  
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + MyUserDetailsServiceImpl.class.getName(), ex);
        } finally {
            para.cerrarConexiones();
        }

        return key;
    }
    
}
