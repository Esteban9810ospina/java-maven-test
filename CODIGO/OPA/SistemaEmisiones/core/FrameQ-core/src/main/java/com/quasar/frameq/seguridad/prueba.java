package com.quasar.frameq.seguridad;


import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class prueba {
  public prueba() {
  }

  public void getDirIp (){
 try
        {
        InetAddress localaddr = InetAddress.getLocalHost();
        InetAddress[] localaddrs = InetAddress.getAllByName ( "localhost" );
       }
     catch ( UnknownHostException e )
        {
        Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, "Can't detect localhost : ", e);  
        }

 }

  public static void main(String[] args) {
    prueba prueba1 = new prueba();
    prueba1.getDirIp();
  }

}
