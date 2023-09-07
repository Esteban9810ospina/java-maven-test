/*
 * Información de Valoración framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.common.service.security;

import com.framework.common.domain.Usuario;
import com.quasar.frameq.exception.FrameworkSistemaException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import java.util.concurrent.ThreadLocalRandom;

// import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import javax.xml.bind.DatatypeConverter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/**
 *
 * @author robert - http://www.roseindia.net/answers/viewqa/Java-Beginners/26017-Java-Encryption-using-AES-with-key-password-.html
 */
public class QuasarPasswordEncoder {

 // protected final Logger logger = LoggerFactory.getLogger(getClass());
    private static final Logger logger = Logger.getLogger(QuasarPasswordEncoder.class.getName());
    private static final SecureRandom aleatorio = new SecureRandom();

  public QuasarPasswordEncoder() {
  }

  public String encodePassword(String rawPass, Object salt, Usuario usuario) {
    PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
      String output = "";
    try {
       
      
      byte bytes[] = new byte[16];
      aleatorio.nextBytes(bytes);
      byte[] byencript = encodekey(usuario, bytes);
      SecretKeySpec key = new SecretKeySpec(byencript, "AES");
      AlgorithmParameterSpec paramSpec = new IvParameterSpec(
					byencript);
      Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
      byte[] ecrypted = cipher.doFinal(rawPass.getBytes());
      output = DatatypeConverter.printBase64Binary(ecrypted);      
      
    } catch (InvalidKeyException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    } catch (IllegalBlockSizeException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    } catch (InvalidAlgorithmParameterException ex) {
        logger.error(ex.getMessage(), ex);
        throw new FrameworkSistemaException(ex.getMessage());
    } catch (BadPaddingException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    } catch (NoSuchAlgorithmException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    } catch (NoSuchPaddingException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    }
    return output;
  }
        
  public boolean isPasswordValid(String encPass, String rawPass, String pass,
			Object salt) {
    PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
      try {
      
      byte[] byteDecodificado = Base64.decodeBase64(pass);
      SecretKeySpec key = new SecretKeySpec(byteDecodificado, "AES");
      			AlgorithmParameterSpec paramSpec = new IvParameterSpec(
					byteDecodificado);
      Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);    
      byte[] ecrypted = cipher.doFinal(rawPass.getBytes());
      String output = DatatypeConverter.printBase64Binary(ecrypted);
      logger.debug("OPA - " + output);
      if (encPass.equals(output)) {
        return true;
      }
      
    } catch (InvalidKeyException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    }catch (NoSuchAlgorithmException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    } catch (InvalidAlgorithmParameterException ex) {
        logger.error(ex.getMessage(), ex);
        throw new FrameworkSistemaException(ex.getMessage());
    } catch (NoSuchPaddingException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    } catch (IllegalBlockSizeException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    } catch (BadPaddingException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    }
    return false;
  }
  
   public String validPassword(String rawPass, Usuario usuario
			) {
    PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String output;
      try {
      
      byte[] byteDecodificado = Base64.decodeBase64(usuario.getLlaveCodifi());
      SecretKeySpec key = new SecretKeySpec(byteDecodificado, "AES");
      			AlgorithmParameterSpec paramSpec = new IvParameterSpec(
					byteDecodificado);
      Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);    
      byte[] ecrypted = cipher.doFinal(rawPass.getBytes());
      output = DatatypeConverter.printBase64Binary(ecrypted);
      logger.debug("OPA - " + output);
      
    } catch (InvalidKeyException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    } catch (NoSuchAlgorithmException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    }catch (InvalidAlgorithmParameterException ex) {
        logger.error(ex.getMessage(), ex);
        throw new FrameworkSistemaException(ex.getMessage());
    }  catch (NoSuchPaddingException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    } catch (IllegalBlockSizeException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    } catch (BadPaddingException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    }
    return output;
  }
    public String decript(String rawPass, String encPass, Usuario usuario, int valor
			) {
    PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String output;
         byte[] byteDecodificadoContra= null;
      try {
      
       if(valor == 1){
           byte[] byteDecodificado = Base64.decodeBase64(usuario.getLlaveCodifi());
           SecretKeySpec key = new SecretKeySpec(byteDecodificado, "AES");
           AlgorithmParameterSpec paramSpec = new IvParameterSpec(
                   byteDecodificado);
           Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
           cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
           byte[] ecrypted = cipher.doFinal(rawPass.getBytes());
           output = DatatypeConverter.printBase64Binary(ecrypted);
           byteDecodificadoContra = DatatypeConverter.parseBase64Binary(output);
           SecretKeySpec keydec = new SecretKeySpec(byteDecodificado, "AES");
           AlgorithmParameterSpec paramSpecdec = new IvParameterSpec(
                   byteDecodificado);
           Cipher cipherdec = Cipher.getInstance("AES/GCM/NoPadding");
           cipherdec.init(Cipher.DECRYPT_MODE, keydec, paramSpecdec);
           byte[] decryted = cipherdec.doFinal(byteDecodificadoContra);
           output = DatatypeConverter.printBase64Binary(decryted);
           
       }else {
              byte[] byteDecodificado = Base64.decodeBase64(encPass);
              byteDecodificadoContra = DatatypeConverter.parseBase64Binary(rawPass);
              SecretKeySpec key = new SecretKeySpec(byteDecodificado, "AES");
              AlgorithmParameterSpec paramSpec = new IvParameterSpec(
                      byteDecodificado);
              Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
              cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
              byte[] ecrypted = cipher.doFinal(byteDecodificadoContra);
              output = DatatypeConverter.printBase64Binary(ecrypted);
          }
          
      logger.debug("OPA - " + output);
      
    } catch (InvalidKeyException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    } catch (NoSuchAlgorithmException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    }catch (InvalidAlgorithmParameterException ex) {
        logger.error(ex.getMessage(), ex);
        throw new FrameworkSistemaException(ex.getMessage());
    }  catch (NoSuchPaddingException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    } catch (IllegalBlockSizeException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    } catch (BadPaddingException ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage());
    }
    return output;
  }
  
  public static byte[] encodekey(Usuario usuario, byte[] iv) {
        try {
        	
            String randomStringValues = "";
            SecretKeySpec secretKey = new SecretKeySpec(iv, "AES");
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(
                    iv);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);
            byte[] encriptado = cipher.doFinal(randomStringValues.getBytes());
             usuario.setLlaveCodifi(DatatypeConverter.printBase64Binary(encriptado));
            return encriptado;
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
   }
        
}