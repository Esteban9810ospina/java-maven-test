/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.interfaces;

import java.util.List;
import com.quasar.frameq.data.Aceptaciones;
import java.util.ArrayList;
import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author ana_pachon
 */
public class Interfaz20BO {
    
    private static final Logger logger = Logger.getLogger(Interfaz20BO.class.getName());

    public List<List<String>> Consolidacion() {
        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");
        
        Aceptaciones consol = new Aceptaciones();
        List<List<String>> listCons = new ArrayList<List<String>>();
        
        for (int i =0 ; i<=2; i++){
            listCons.add(new ArrayList<String>());
        }
            
            
            try{
                consol.consultaLectura("SELECT SUM(adj.i_acciones_adjudicadas) i_acciones_adjudicadas,"
                        + "acep.CtaInv CtaInv,"
                        + "((SUM(d_monto*(PorcentajePagoEfectivo/100))/SUM(adj.i_acciones_adjudicadas*d_precio))*100) Porcentaje_Efectivo_inicial_consolidado " 
                                        + "FROM fqs_CrearAceptacion acep, fqs_adjudicacion adj " 
                                        + "WHERE adj.i_id_aceptacion = acep.EntidadDeNegociosID GROUP BY acep.CtaInv");
                
                while (consol.rs.next()){
                    listCons.get(0).add(consol.rs.getString("i_acciones_adjudicadas"));
                    listCons.get(1).add(consol.rs.getString("CtaInv"));
                    listCons.get(2).add(consol.rs.getString("Porcentaje_Efectivo_inicial_consolidado"));
                
                }
                
            } catch (SQLException ex) {
                logger.error("OPI - "+Interfaz20BO.class.getName(), ex);

            } finally {
                consol.cerrarConexiones();
            }
            return listCons;
        }
        
    
} 



    
    

