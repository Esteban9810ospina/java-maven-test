/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.fachadas;

import com.quasar.frameq.parametros.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author jam
 */
public class FacadeDiccionario {

    private static final Logger logger = Logger.getLogger(FacadeDiccionario.class.getName());
    public int validaHayPalabras() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        int VariableLocal_Resultado = 1;
        Parametro ValidarParametro = new Parametro();
        try {
            ValidarParametro.consultaLectura("SELECT LENGTH(a.palabra) AS 'RESULTADO' FROM diccionario a;");
            if (ValidarParametro.rs.first()) {
                VariableLocal_Resultado = Integer.parseInt(ValidarParametro.rs.getString("RESULTADO"));

            } else {
                VariableLocal_Resultado = 1;
                
            }
            
        } catch (Exception e) {
            VariableLocal_Resultado = 1;
            
            
        }
        ValidarParametro.cerrarConexiones();
        return VariableLocal_Resultado;
        
    }

    public List<List<String>> ListarPalabras() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Parametro Traepalabra = new Parametro();
        List<List<String>> listPalabras = new ArrayList<List<String>>();

        for (int i = 0; i <= 1; i++) {
            listPalabras.add(new ArrayList<String>());
            
        }
        try {
            Traepalabra.consultaLectura("SELECT a.palabra as PALABRA FROM diccionario a");

            while (Traepalabra.rs.next()) {

                listPalabras.get(0).add(String.valueOf(Traepalabra.rs.getString("PALABRA")));

            }
            
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeDiccionario.class.getName(), ex);	
            
        } finally {
            Traepalabra.cerrarConexiones();
        }
        return listPalabras;
    }

    public String GuardarPalabrasRestringidas(String palabra,String nomUsuario) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String query = "";
        String result = "Error";
        Parametro crearpalabra = new Parametro();
        String resultado = BorrarPalabra();

        if (!"Error".equals(resultado)) {
            try {
                crearpalabra.Insert("INSERT INTO diccionario (palabra,usuario_modificacion) VALUES ('" + palabra + "','" + nomUsuario + "')");
                result = "Diccionario actualizado correctamente";
                            
            } catch (SQLException e) {
                logger.error("OPA - " + FacadeDiccionario.class.getName(), e);	
                
                result = "Error al guardar palabras";
            } finally {
                crearpalabra.cerrarConexiones();
            }
        } else {
            crearpalabra.cerrarConexiones();
            result = "Error al guardar palabras";

        }
        return result;

    }

    public String BorrarPalabra() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String resultado = "Exito";
        Parametro borrarpalabra = new Parametro();
        try {
            borrarpalabra.actualizar("DELETE FROM diccionario;");
            
        } catch (Exception e) {
            logger.error("OPA - " + FacadeDiccionario.class.getName(), e);	
            
            resultado = "Error";
        } finally {
            borrarpalabra.cerrarConexiones();
        }

        return resultado;
    }

    public List<String> devuelveArray(String cadena) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        List<String> listarray = new ArrayList<String>();
        try {
            String[] paldiv = cadena.split(";");
            listarray = Arrays.asList(paldiv);
        } catch (Exception e) {
            logger.error("OPA - " + FacadeDiccionario.class.getName(), e);	
        }
        return listarray;
    }

    //metodo para validar que la clave no contega palabras restringidas
    public boolean isContain(List<String> lista, String clave) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        try {
            for (int i = 0; i < lista.size(); i++) {               
                if (clave.toLowerCase().contains(lista.get(i).toLowerCase())) {
                    return true;
                }
            }
        } catch (Exception e) {
            logger.error("OPA - " + FacadeDiccionario.class.getName(), e);	
            return false;
        }
        return false;
    }

    public Boolean validaRestringidas(String clave) {
        //Diccionario de contraseñas
        //Validar que la clave no contega palabras restringidas 
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        // Diccionario de contraseñas
        List<List<String>> restringidas;
        List<String> listvalidar = new ArrayList<String>();
        String listapalabras = "";

        try{
        int hayPalabras = validaHayPalabras();
        if (hayPalabras > 1) {
            restringidas = ListarPalabras();
            for (int i = 0; i < restringidas.get(0).size(); i++) {
                listapalabras = listapalabras + (restringidas.get(0).get(i));            
            }
            listvalidar = devuelveArray(listapalabras);
            Boolean resultado = isContain(listvalidar, clave);
            if (resultado) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
        }catch (Exception e) {
            logger.error("OPA - " + FacadeDiccionario.class.getName(), e);	
            return false;
        }
    }

}
