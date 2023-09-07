/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.web.security;

/**
 *
 * @author Roger Padilla C.
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedCredentialsNotFoundException;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationException;

/**
 * <tt>AuthenticationFailureHandler</tt> which performs a redirect to the value of the {@link #setBaseFailureUrl
 * defaultFailureUrl} property when the <tt>onAuthenticationFailure</tt> method is called. If the property has not been set it will send a 401
 * response to the client, with the error message from the <tt>AuthenticationException</tt> which caused the failure. <p> If the {@code useForward}
 * property is set, a {@code RequestDispatcher.forward} call will be made to the destination instead of a redirect.
 *
 * @author Luke Taylor
 * @since 3.0
 */
public class UrlAuthenticationFailureHandler implements AuthenticationFailureHandler {

  protected final Logger logger = LoggerFactory.getLogger(getClass());
  private String baseFailureUrl;
  private boolean forwardToDestination = false;
  private boolean allowSessionCreation = true;
  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

  /**
   * Performs the redirect or forward to the {@code defaultFailureUrl} if set, otherwise returns a 401 error code. <p> If redirecting or forwarding, {@code saveException}
   * will be called to cache the exception for use in the target view.
   */
  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
          AuthenticationException exc) throws IOException, ServletException {

    if (baseFailureUrl == null) {
      logger.error("No base failure URL set, sending 401 Unauthorized error");
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed: " + exc.getMessage());
    } else {

      logger.debug("OPA - " + exc.getMessage(), exc);

      saveException(request, exc);

      String failureUrl = baseFailureUrl;

      Class<? extends AuthenticationException> excClass = exc.getClass();
      
      if(excClass == PreAuthenticatedCredentialsNotFoundException.class){
          failureUrl += "?error=captchanotfound";
      }else if (excClass == UsernameNotFoundException.class || excClass == BadCredentialsException.class) {
        failureUrl += "?error=wrong";
      } else if (excClass == DisabledException.class) {
          failureUrl += "?error=status";
      } else if (excClass == LockedException.class) {
        failureUrl += "?error=locked";
      } else if (excClass == PreAuthenticatedCredentialsNotFoundException.class) {
        failureUrl += "?error=pre";
      } else if(excClass == ProviderNotFoundException.class){
        failureUrl += "?error=inactivo"; 
      } else if(excClass == InsufficientAuthenticationException.class){
        failureUrl += "?error=ip"; 
      } else if(excClass == RememberMeAuthenticationException.class){
        failureUrl += "?error=captchavacio"; 
      } else {
        failureUrl += "?error=technical";
      }

      if (forwardToDestination) {
        logger.debug("OPA - " + "Forwarding to " + failureUrl);
        request.getRequestDispatcher(failureUrl).forward(request, response);
      } else {
        logger.debug("OPA - " + "Redirecting to " + failureUrl);
        redirectStrategy.sendRedirect(request, response, failureUrl);
      }
    }
  }

  /**
   * Caches the {@code AuthenticationException} for use in view rendering. <p> If {@code forwardToDestination} is set to true, request scope will be
   * used, otherwise it will attempt to store the exception in the session. If there is no session and {@code allowSessionCreation} is {@code true} a
   * session will be created. Otherwise the exception will not be stored.
   */
  protected final void saveException(HttpServletRequest request, AuthenticationException exception) {
    if (forwardToDestination) {
      request.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
    } else {
      HttpSession session = request.getSession(false);
      if (session != null || allowSessionCreation) {
        request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
      }
    }
  }

  /**
   * The URL which will be used as the failure destination.
   *
   * @param baseFailedUr the failure URL, for example "/start/login".
   */
  public void setBaseFailureUrl(String baseFailedUr) {
    this.baseFailureUrl = baseFailedUr;
  }

  protected boolean isUseForward() {
    return forwardToDestination;
  }

  /**
   * If set to <tt>true</tt>, performs a forward to the failure destination URL instead of a redirect. Defaults to <tt>false</tt>.
   */
  public void setUseForward(boolean forwardToDestination) {
    this.forwardToDestination = forwardToDestination;
  }

  /**
   * Allows overriding of the behaviour when redirecting to a target URL.
   */
  public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
    this.redirectStrategy = redirectStrategy;
  }

  protected RedirectStrategy getRedirectStrategy() {
    return redirectStrategy;
  }

  protected boolean isAllowSessionCreation() {
    return allowSessionCreation;
  }

  public void setAllowSessionCreation(boolean allowSessionCreation) {
    this.allowSessionCreation = allowSessionCreation;
  }
}
