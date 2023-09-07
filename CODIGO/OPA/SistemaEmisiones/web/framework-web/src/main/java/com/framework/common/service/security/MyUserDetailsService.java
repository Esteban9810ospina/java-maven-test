/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.service.security;

import com.framework.common.service.Auditoria;
import com.framework.common.domain.OpcionModulo;
import com.framework.common.domain.Perfil;
import com.framework.common.domain.Usuario;
import com.framework.common.domain.UsuarioReporte;
import com.quasar.frameq.estructura.IpAutorizada;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Roger Padilla C.
 */
public interface MyUserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService {

    @Override
    Usuario loadUserByUsername(String login) throws UsernameNotFoundException;

    Usuario findUsuarioById(Integer id);

    List<Perfil> findPerfilesByUsuario(Usuario usuario);

    List<Perfil> findPerfilesOpcionesModuloUsuarioAutenticado();

    List<Usuario> findUsuarios();

    List<Usuario> findUsuariosExceptAutenticado();

    List<Perfil> findPerfiles();

    Usuario saveUsuario(Usuario usuario, Auditoria auditoria, String perfil, ArrayList<IpAutorizada> ipAutorizadas);

    Usuario saveUsuarioBloqueado(Usuario usuario, Integer autintica);

    void updateUsuarioPassword(Usuario usuario);

    String findUsuarioPassword(Integer usuarioId);

    List<String> findUsuarioPasswordsHistorial(Integer usuarioId);

    String encodePassword(String rawPassword, Usuario usuario);

    boolean isPasswordValid(String encryptedPassword, String rawPassword, String pass);
    
    String validPassword(String rawPassword, Usuario usuario);
    
    String decript(String rawPassword, String encPass, Usuario usuario, int valor);
    
    boolean paramIp();

    boolean isIpValid(String ip, int iduser);

    boolean isDateValid();

    boolean isPerfilValid(int iduser);

    public boolean isDateBefore();

    public boolean isDateAfter();

    void logAccess(String message);

    void logAccess(OpcionModulo opcionModulo);

    void logAuthenticationAttemptLocked(Usuario usuario, boolean isPasswordValid);

    boolean logAuthenticationAttemptWrongPassword(Usuario usuario);

    void logAuthenticationVerificacionLocked(Usuario usuario);

    void logAuthentication(Usuario usuario);

    Usuario getUsuarioAutenticado();

    boolean isSupervisor(Usuario usuario);

    List<Usuario> findUsuariosSupervisados(Usuario usuario);

    boolean mostrarCaptcha();

    int inactividad();

    void updateUsuarioContrasena(String contrasena, int id, Usuario usuario);

    void updateUsuarioPass(Usuario usuario);

    public String getCaptchaKeyPublic();

    public String getCaptchaKeyPrivate();

    public List<UsuarioReporte> findUsuariosReporte(String nombre, String apellido, String usuario, String codigoSCB);
}
