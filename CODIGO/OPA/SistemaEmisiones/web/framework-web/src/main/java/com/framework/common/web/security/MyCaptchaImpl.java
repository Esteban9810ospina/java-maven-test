package com.framework.common.web.security;

import com.framework.common.service.security.MyUserDetailsService;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import java.util.Properties;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import net.tanesha.recaptcha.http.HttpLoader;
import net.tanesha.recaptcha.http.SimpleHttpLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author Roger Padilla C.
 */
/**
 * Filter for capturing Captcha fields. It's purpose is to store these values
 * internally
 */
@Configurable(preConstruction=true,autowire=Autowire.BY_TYPE)
public class MyCaptchaImpl implements MyCaptcha {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private String PUBLIC_KEY = null;
    private String PRIVATE_KEY = null;
            
    private Boolean useProxy = false;
    private String proxyPort;
    private String proxyHost;
    
    public static final String HTTP_SERVER = "http://www.google.com/recaptcha/api";
    public static final String HTTPS_SERVER = "https://www.google.com/recaptcha/api";
    public static final String VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";

    private String recaptchaServer = HTTPS_SERVER;

    public static final String PROPERTY_THEME = "theme";
    public static final String PROPERTY_TABINDEX = "tabindex";


    private String privateKey;
    private String publicKey;
    private String verifyUrl = VERIFY_URL;
    private boolean includeNoscript = false;
    private HttpLoader httpLoader = new SimpleHttpLoader();
    //Ajuste update captcha V1 to V2 2018-05-04
    private final String recaptchaResponse = "g-recaptcha-response";

    @Autowired
    public MyUserDetailsService userDetailsService;
    @Override
    public boolean validateCaptcha() {
        PRIVATE_KEY = userDetailsService.getCaptchaKeyPrivate();
        boolean valid = false;

        logger.debug("OPA - " + "Validating Captcha");

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attr.getRequest();

    // Assign values only when user has submitted a Captcha value.
        // Without this condition the values will be reset due to redirection
        // and CaptchaVerifierFilter will enter an infinite loop
        if (req.getParameter(recaptchaResponse) != null) {

            String recaptcha_response = req.getParameter(recaptchaResponse);
            

            if (recaptcha_response == null || recaptcha_response.length() == 0) {
                return false;
            }

            //AJUSTE IP REGISTRADA
            // String remoteAddr = req.getRemoteAddr();
            String remoteAddr = req.getHeader("X-Forwarded-For");
            if (remoteAddr == null || "".equals(remoteAddr)) {                
                remoteAddr = req.getRemoteAddr();
            } else {
                String ips[] = remoteAddr.split(",");
                remoteAddr = ips[0];
               
            }
            //au.setIp(req.getHeader("X-Forwarded-For"));

            logger.debug("OPA - REMOTEADDR_" + req.getRemoteAddr() + "x-forwarded-For_" + req.getHeader("X-Forwarded-For") + "IP:" + remoteAddr);

            // Assign proxy if needed
            if (useProxy) {
                Properties systemSettings = System.getProperties();
                systemSettings.put("http.proxyPort", proxyPort);
                systemSettings.put("http.proxyHost", proxyHost);
                
            }

            try {

                URL verifyUrl = new URL(VERIFY_URL);
                // Open a Connection to URL above.
                HttpsURLConnection conn = (HttpsURLConnection) verifyUrl.openConnection();
                // Data will be sent to the server.
                recaptcha_response= recaptcha_response.replaceAll("[\n\r]", "_");
                logger.info("SECRET KEY" + PRIVATE_KEY + "RECAPTCHA RESPONSE" + recaptcha_response);
                String postParams = "secret=" + PRIVATE_KEY //
                        + "&response=" + recaptcha_response;
                // Send Request
                conn.setDoOutput(true);
                // Get the output stream of Connection.
                // Write data in this stream, which means to send data to Server.
                OutputStream outStream = conn.getOutputStream();
                outStream.write(postParams.getBytes());

                outStream.flush();
                outStream.close();

                // Get the Input Stream of Connection to read data sent from the Server.
                InputStream is = conn.getInputStream();
                String jsonString;

                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                jsonString = new String(buffer, "UTF-8");

                logger.info("Capctha json___" + jsonString);

                if (jsonString.contains("\"success\": true")) {
                    return true;
                }

            } catch (IOException e) {
                logger.error(e.toString());
            }

        }

        return false;
    }
    
    public String generateCaptchaHtml() {

        boolean mostrar;

        mostrar = userDetailsService.mostrarCaptcha();

        if (mostrar) {
            //return captcha.createRecaptchaHtml("Error en el captcha", props);
            PUBLIC_KEY = userDetailsService.getCaptchaKeyPublic();
            return "<div class=\"g-recaptcha\" data-sitekey=" + PUBLIC_KEY + "></div>";
        } else {
            return "";
        }

    }

    public Boolean getUseProxy() {
        return useProxy;
    }

    public void setUseProxy(Boolean useProxy) {
        this.useProxy = useProxy;
    }

    public String getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(String proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

	

    
}
