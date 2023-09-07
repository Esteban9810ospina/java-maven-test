package com.framework.common.web.security;

/**
 *
 * @author Roger Padilla C.
 */
/**
 * Filter for capturing Captcha fields. It's purpose is to store these values internally
 */
public interface MyCaptcha {

  boolean validateCaptcha();
}