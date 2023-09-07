/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.contents;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jam
 */
public class Filtro implements FilenameFilter{
    String extension;
    String hora;
    String fecha;
    Filtro(String extension, String hora, String fecha){
        this.extension=extension;
        this.fecha=fecha;
        this.hora=hora;
    }
    public boolean accept(File dir, String name){
 
       //Filtrar por el nombre del archivo
       String nomArchivOriginal= name.toLowerCase();
       String nombreArchivo = extension.toLowerCase();   
       String fechaString = fecha.toLowerCase();
       String horaString = hora.toLowerCase();
       
       String horamod="";
       String fechapro="";

       
       Boolean validacion = false;
       
       File pathArchivos = new File(dir+"//"+name);  
       
               
         //Filtrar por la fecha  
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechapro = f.format(pathArchivos.lastModified()); 
        
                
        //Filtrar por la hora del archivo        
        SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss");
        horamod = ft.format(pathArchivos.lastModified());  
       

       //Validación de los Filtros para la carga Masiva
       
       if ((horaString.equalsIgnoreCase("") ||  horaString.equalsIgnoreCase(null)) && 
               (fechaString.equalsIgnoreCase("") ||  fechaString.equalsIgnoreCase(null)) && 
               (nombreArchivo.equalsIgnoreCase("") ||  nombreArchivo.equalsIgnoreCase(null))){
           return true;
       } else if ((!horaString.equalsIgnoreCase("") ||  !horaString.equalsIgnoreCase(null)) &&
                 (fechaString.equalsIgnoreCase("") ||  fechaString.equalsIgnoreCase(null)) &&
                 (nombreArchivo.equalsIgnoreCase("") ||  nombreArchivo.equalsIgnoreCase(null))){

           if (horamod.matches(".*"+horaString+".*")){
               return true;
           } else 
               return false;     
           
        } else if ((!horaString.equalsIgnoreCase("") || !horaString.equalsIgnoreCase(null)) &&
                  (!fechaString.equalsIgnoreCase("") ||  !fechaString.equalsIgnoreCase(null)) &&
                  (nombreArchivo.equalsIgnoreCase("") ||  nombreArchivo.equalsIgnoreCase(null))){

                 if (horamod.matches(".*"+horaString+".*")){
        
                 if (fechapro.matches(".*"+fechaString+".*")){
                     
                     return true;
                 } else {
                     return false;
                 }
                 
                } else {
                     return false;
                }

  } else if ((!horaString.equalsIgnoreCase("") ||  !horaString.equalsIgnoreCase(null)) &&
            (!fechaString.equalsIgnoreCase("") ||  !fechaString.equalsIgnoreCase(null)) &&
            (!nombreArchivo.equalsIgnoreCase("") ||  !nombreArchivo.equalsIgnoreCase(null))) {
      
                      
                 if (horamod.matches(".*"+horaString+".*")){
        
                 if (fechapro.matches(".*"+fechaString+".*")){
                     
                 if (nomArchivOriginal.matches(".*"+nombreArchivo+".*")){
                      
                     return true;
                     
                     } else {
                      return false;
                   } 
                } else {
                     return false;
                 }
           } else {
             return false;        
        }       
  } else if ((horaString.equalsIgnoreCase("") ||  horaString.equalsIgnoreCase(null)) &&
            (!fechaString.equalsIgnoreCase("") ||  !fechaString.equalsIgnoreCase(null)) &&
            (nombreArchivo.equalsIgnoreCase("") ||  nombreArchivo.equalsIgnoreCase(null))){

        
           if (fechapro.matches(".*"+fechaString+".*")){
               return true;
           } else 
               return false;     
           
        } else if ((horaString.equalsIgnoreCase("") ||  horaString.equalsIgnoreCase(null)) &&
                  (!fechaString.equalsIgnoreCase("") ||  !fechaString.equalsIgnoreCase(null)) &&
                  (!nombreArchivo.equalsIgnoreCase("") || !nombreArchivo.equalsIgnoreCase(null))) {
            
               if (fechapro.matches(".*"+fechaString+".*")){
                     
                 if (nomArchivOriginal.matches(".*"+nombreArchivo+".*")){
                      
                     return true;
                     
                     } else {
                      return false;
                   } 
                } else {
             return false;        
           }       
            
        } else if ((horaString.equalsIgnoreCase("") ||  horaString.equalsIgnoreCase(null)) &&
                  (fechaString.equalsIgnoreCase("") ||  fechaString.equalsIgnoreCase(null)) &&
                  (!nombreArchivo.equalsIgnoreCase("") ||  !nombreArchivo.equalsIgnoreCase(null))) {

           if (nomArchivOriginal.matches(".*"+nombreArchivo+".*")){
                      
                     return true;
                     
                     } else {
                      return false;
                   }   
           
        }  else if ((!horaString.equalsIgnoreCase("") ||  !horaString.equalsIgnoreCase(null)) &&
                  (fechaString.equalsIgnoreCase("") ||  fechaString.equalsIgnoreCase(null)) &&
                  (!nombreArchivo.equalsIgnoreCase("") ||  ! nombreArchivo.equalsIgnoreCase(null))){
         
           if (nomArchivOriginal.matches(".*"+nombreArchivo+".*")){
               
            if (horamod.matches(".*"+horaString+".*")){
                      
                     return true;
                     
                     } else {
                      return false;
                   }
           } else {
              return false; 
           }  
        }

        return validacion;
    }
}
