/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.util.security;

/**
 *
 * @author jam
 */

import java.util.Enumeration;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;




/**
 *
 * @author Raul
 */
public class VerificaFormulario {

    public VerificaFormulario(HttpServletRequest a)
    {
        parametrosEntrada = new HttpServletRequestWrapper(a);
    }

    
    public int consultaCampos()
    {
        int contador = 0;
        Enumeration a = parametrosEntrada.getParameterNames();
        for(Enumeration e = a; e.hasMoreElements();)
        {
            contador++;
        }

        return contador;
    }

    public boolean verificaCampos()
    {
        int contador = 0;
        Enumeration a = parametrosEntrada.getParameterNames();
        Map b = parametrosEntrada.getParameterMap();
        for(Enumeration e = a; e.hasMoreElements();)
        {
            String llave = e.nextElement().toString();
            String valor[] = (String[])(String[])b.get(llave);
            int i = 0;
            while(i < valor.length) 
            {
                if(valor[i].indexOf("&") != -1 || 
                		valor[i].indexOf("+") != -1 ||
                		valor[i].indexOf("(") != -1 ||  
                		valor[i].indexOf(")") != -1 ||  
                		valor[i].indexOf("%") != -1 ||  
                		valor[i].indexOf(">") != -1 || 
                		valor[i].indexOf("<") != -1 || 
                		valor[i].indexOf("?") != -1 ||
                		valor[i].indexOf("?") != -1 ||                		
                		valor[i].indexOf(";") != -1 || 
                		valor[i].indexOf("'") != -1 || 
                		valor[i].indexOf("\"") != -1 || 
                		valor[i].indexOf(" select ") != -1 || 
                		valor[i].indexOf(" update ") != -1 || 
                		valor[i].indexOf(" insert ") != -1 || 
                		valor[i].indexOf(" delete ") != -1 || 
                		valor[i].indexOf(" drop ") != -1 || 
                		valor[i].indexOf(" grant ") != -1 || 
                		valor[i].indexOf(" from ") != -1 || 
                              
                               
                		!llave.equals("condicionh") && !llave.equals("filtro") && valor[i].indexOf("'") != -1 || !llave.equals("condicionh") && !llave.equals("filtro") && valor[i].indexOf(" where ") != -1 || !llave.equals("condicionh") && !llave.equals("filtro") && valor[i].indexOf(" and ") != -1 || !llave.equals("condicionh") && !llave.equals("filtro") && valor[i].indexOf(" or ") != -1)
                {
                    return false;
                }
                i++;
            }
        }

        return true;
    }

    HttpServletRequest parametrosEntrada;
}
