package com.framework.common.service.security;

import com.framework.common.service.Auditoria;
import com.framework.common.domain.Usuario;
import com.framework.common.service.AbstractServiceDao;
import com.framework.common.web.security.MyCaptcha;
import com.quasar.frameq.fachadas.FacadeDiccionario;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedCredentialsNotFoundException;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author Roger Padilla C.
 */
@Service(value = "authenticationManager")
public class MyAuthenticationManagerImpl extends AbstractServiceDao implements MyAuthenticationManager {

    // Diccionario de contraseñas
    FacadeDiccionario facadediccionario = new FacadeDiccionario();

    @Autowired
    public MyUserDetailsService userDetailsService;

    @Autowired
    protected MyCaptcha myCaptcha;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        Auditoria au = new Auditoria();
        au.setEvento("Inicio de sesión");
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attr.getRequest();
        logger.debug("OPA - REMOTEADDR_" + req.getRemoteAddr() + "x-forwarded-For_" + req.getHeader("X-Forwarded-For"));
        // AJUSTE IP REGISTRADA
        String remoteAddr = "";
        String remoteAddrF = req.getHeader("X-Forwarded-For");
        logger.debug("OPA - REMOTEADDR_" + remoteAddrF );
//        if ((remoteAddrF = req.getHeader("X-Forwarded-For")) != null) {
//            remoteAddr = remoteAddrF;
//            int idx = remoteAddr.indexOf(',');
//            if (idx > -1) {
//                remoteAddr = remoteAddr.substring(0, idx);
//                au.setIp(remoteAddr);  
//            }
//        }else{
//            au.setIp(req.getRemoteAddr());
//        }
        
        if (remoteAddrF == null || "".equals(remoteAddrF) ){
            au.setIp(req.getRemoteAddr());
						  
        }else{
            String ips[]= remoteAddrF.split(",");
            remoteAddr= ips[0];
            au.setIp(remoteAddr);                                   
        }    
        //au.setIp(req.getHeader("X-Forwarded-For"));
        
        logger.debug("OPA - REMOTEADDR_" + req.getRemoteAddr() + "x-forwarded-For_" + req.getHeader("X-Forwarded-For") + "IP:" + remoteAddr);
        
        // 
        Usuario usuario;
        boolean validaCaptcha = userDetailsService.mostrarCaptcha();
        
            String recaptcha_response = req.getParameter("g-recaptcha-response");
                if (validaCaptcha) {
                    if (recaptcha_response.equals("")) {
                    throw new PreAuthenticatedCredentialsNotFoundException("");
                    }
                }
        try {
            // Retrieve user details from database
            usuario = userDetailsService.loadUserByUsername(auth.getName());
    
        } catch (UsernameNotFoundException exc) {
            String msg = exc.getMessage();
            logger.debug("OPA - " + msg, exc);
            throw exc;
        } catch (Exception exc) {
            String msg = exc.getMessage();
            logger.error(msg, exc);
            throw new AuthenticationServiceException(msg, exc);
        }
        au.setId_user(usuario.getId());

        //Si la fecha no esta permitida
        GregorianCalendar gc = new GregorianCalendar();
        //Revisar sabado o domingo
        if (!userDetailsService.isPerfilValid(usuario.getId())) {
            //Traer fecha de inicio
            if (!userDetailsService.isDateBefore()) {
                String msg = getMessage("error.user_date", usuario.getUsername());
                au.setResultado("Fecha/Horario previo al inicio de la operación");
                au.inserta();
                logger.debug("OPA - " + msg);
                throw new DisabledException(msg);

            }
            //Traer fecha fin
            if (!userDetailsService.isDateAfter()) {
                String msg = getMessage("error.user_date", usuario.getUsername());
                au.setResultado("Fecha/Horario despues del inicio de la operación");
                au.inserta();
                logger.debug("OPA - " + msg);
                throw new DisabledException(msg);

            }

            if (gc.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || gc.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                String msg = getMessage("error.user_date", usuario.getUsername());
                au.setResultado("Fecha/Horario no permitido");
                au.inserta();
                logger.debug("OPA - " + msg);
                throw new DisabledException(msg);
            }
        }

        // Si el usuario está inactivado
        if (!usuario.isEnabled()) {
            String msg = getMessage("error.user_inactivo", usuario.getUsername());
            au.setResultado("Usuario Inactivo");
            au.inserta();
            logger.debug("OPA - " + msg);
            throw new ProviderNotFoundException(msg);
        }

        if (!usuario.isAccountNonLocked()) {
            String msg = getMessage("error.user_blocked", usuario.getUsername());
            au.setResultado("Usuario Bloqueado");
            au.inserta();
            logger.debug("OPA - " + msg);
            throw new LockedException(msg);
        }

        if (usuario.getEstado().equals("E")) {
            String msg = getMessage("error.user_delete", usuario.getUsername());
            au.setResultado("Usuario Eliminado");
            au.inserta();
            throw new DisabledException(msg);
        }

        final String presentedPassword = (String) auth.getCredentials();
        boolean isPasswordValid = userDetailsService.isPasswordValid(usuario.getPassword(), presentedPassword, usuario.getLlaveCodifi());

            //Ajuste update captcha V1 to V2 2018-05-04
        logger.info("recaptcha_response__" + recaptcha_response);
        boolean captchaIsValid = false;
        // Si el usuario existe pero el password es erroneo
        if ((!isPasswordValid) || validaCaptcha) {

            if (validaCaptcha) {
                if (recaptcha_response.equals("")) {
                    throw new RememberMeAuthenticationException("");
                }
                captchaIsValid = myCaptcha.validateCaptcha();
            }
            if ((validaCaptcha && !captchaIsValid) || !isPasswordValid) {
                String msg = getMessage("error.user_wrong_password", usuario.getUsername());
                logger.debug("OPA - " + msg);
                au.setEvento("Intento fallido de acceso al sistema");
                if (!isPasswordValid) {

                    //au.setEvento("Intento fallido de acceso al sistema");
                    au.setResultado("Fallido");
                    au.inserta();

                }
                boolean accountLocked = userDetailsService.logAuthenticationAttemptWrongPassword(usuario);

                if (accountLocked) {
                    msg = getMessage("error.user_locked", usuario.getUsername());
                    logger.debug("OPA - " + msg);
                    au.setEvento("Usuario bloqueado por intentos fallidos de acceso al sistema");
                    au.setResultado("Exitoso");
                    au.inserta();
                    userDetailsService.logAuthenticationAttemptLocked(usuario, isPasswordValid);
                    throw new LockedException(msg);
                }

                if (validaCaptcha && !captchaIsValid) {
                    au.setResultado("Captcha inválido");
                    au.inserta();
                    throw new PreAuthenticatedCredentialsNotFoundException("Invalid Captcha");
                }
                userDetailsService.logAuthenticationVerificacionLocked(usuario);
                throw new BadCredentialsException(msg);
            }
        }
        boolean paraip = userDetailsService.paramIp();

        // AJUSTE IP REGISTRADA
//        String ip = req.getRemoteAddr();

        String ip = "";
        String ipf = req.getHeader("X-Forwarded-For");                       
        if (ipf == null || "".equals(ipf) ){
            ip= (req.getRemoteAddr());
						  
        }else{
            String ips[]= ipf.split(",");
            ip= ips[0];
                                             
        }                 
        
        //
        HttpSession session = req.getSession();
        session.setAttribute("ip", ip);

        session.setAttribute("scb", usuario.getSbolsa());
        session.setAttribute("fase", 1);
        session.setAttribute("emision", 1);
        session.setAttribute("entro", 1);
        session.setAttribute("usuario", usuario.getNombres());

        if (paraip) {
            boolean isIpvalida = userDetailsService.isIpValid(ip, usuario.getId());
            if (!isIpvalida) {
                String msg = getMessage("error.user_ip", usuario.getUsername());
                //au.setEvento("Intento fallido de acceso al sistema");
                au.setEvento("Intento fallido por IP no registrada");
                au.setResultado("Fallido");
                au.inserta();

                throw new InsufficientAuthenticationException(msg);
            }
        }

        // Si el usuario no tiene roles
        if (usuario.getAuthorities().isEmpty()) {
            String msg = getMessage("error.user_without_authorities", usuario.getUsername());

            logger.error(msg);
            throw new InsufficientAuthenticationException(msg);
        }

        //Diccionario de contraseñas
        //Validar que la clave no contega palabras restringidas  adm general                                           
        Boolean palpermitida = facadediccionario.validaRestringidas(presentedPassword);
        if (palpermitida) {
            userDetailsService.updateUsuarioPass(usuario);
            userDetailsService.logAuthentication(usuario);
            au.setResultado("Exitoso");
            au.inserta();
        } else {
            userDetailsService.logAuthentication(usuario);
            au.setResultado("Exitoso");
            au.inserta();

        }
        return new UsernamePasswordAuthenticationToken(
                usuario,
                presentedPassword,
                usuario.getAuthorities());
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

}
