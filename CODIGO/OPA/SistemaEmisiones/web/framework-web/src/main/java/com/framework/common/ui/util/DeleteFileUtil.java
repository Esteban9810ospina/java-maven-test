package com.framework.common.ui.util;

import java.io.File;   
import org.apache.log4j.Logger;
  
public class DeleteFileUtil {   
    
    private static final Logger logger = Logger.getLogger(GenerarArchivoBoletin.class.getName());

    public static boolean delete(String fileName){   
        File file = new File(fileName);   
        if(!file.exists()){   
             logger.error("OPA - " + "Error al eliminar el archivo:" + fileName + "El archivo no existe");   
            return false;   
        }else{   
            if(file.isFile()){   
                   
                return deleteFile(fileName);   
            }else{   
                return deleteDirectory(fileName);   
            }   
        }   
    }   
       
    public static boolean deleteFile(String fileName){   
        File file = new File(fileName);   
        if(file.isFile() && file.exists()){   
            file.delete();   
                         logger.info("OPA - " + "Eliminar un solo archivo" + fileName + "Success!");   
            return true;   
        }else{   
                         logger.info("OPA - " + "Eliminar un solo archivo" + fileName + "Failed!");   
            return false;   
        }   
    }   
       
    public static boolean deleteDirectory(String dir){   
        if(!dir.endsWith(File.separator)){   
            dir = dir+File.separator;   
        }   
        File dirFile = new File(dir);   
        if(!dirFile.exists() || !dirFile.isDirectory()){   
                         logger.error("OPA - " + "Error al eliminar el directorio" + dir + "¡El directorio no existe!");   
            return false;   
        }   
        boolean flag = true;   
        File[] files = dirFile.listFiles();   
        for(int i=0;i<files.length;i++){   
            if(files[i].isFile()){   
                flag = deleteFile(files[i].getAbsolutePath());   
                if(!flag){   
                    break;   
                }   
            }   
            else{   
                flag = deleteDirectory(files[i].getAbsolutePath());   
                if(!flag){   
                    break;   
                }   
            }   
        }   
           
        if(!flag){   
                         logger.error("OPA - " + "Error al eliminar el directorio");   
            return false;   
        }   
           
        if(dirFile.delete()){   
                         logger.info("OPA - " + "Eliminar directorio" + dir + "¡Éxito!");   
            return true;   
        }else{   
                         logger.info("OPA - " + "Eliminar directorio" + dir + "¡Falló!");   
            return false;   
        }   
    }   
       
}