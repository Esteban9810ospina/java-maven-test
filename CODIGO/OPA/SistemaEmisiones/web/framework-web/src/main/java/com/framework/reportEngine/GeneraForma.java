package com.framework.reportEngine;

import com.framework.common.service.ReportDAO;
import com.framework.common.ui.field.validator.CustomDoubleValidator;
import com.framework.common.ui.field.validator.CustomLongValidator;
import com.framework.common.ui.oferta.NumberProperty;
import com.framework.common.ui.oferta.NumberPropertyFormatter;
import com.framework.common.ui.oferta.NumberPropertyFormatterInt;
import static com.framework.reportEngine.config.Constantes.*;
import com.vaadin.data.Property;
import com.vaadin.data.util.PropertyFormatter;
import com.vaadin.data.validator.IntegerValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.server.Sizeable;

import com.vaadin.ui.Form;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * Crea las formas de vaadin de forma automatica a partir del tipo de datos y
 * vectores recibidos
 *
 * @author pedrorozo
 *
 */
@SuppressWarnings("rawtypes")
public class GeneraForma implements Serializable {

    private static final long serialVersionUID = -2356296183287373959L;
    private Form forma = new Form();
    private ReportDAO reportDAO = new ReportDAO();
    private final Logger logger = LoggerFactory.getLogger(getClass());
    Select tm;
    Select tml;

    /**
     * Crea formas parametricas para maestro o detalle
     *
     * @param titulo
     * @param contenidos
     * @param titulos
     * @param tipoDato
     * @param tipoCampo
     * @param longitud
     * @param requerido
     * @param combosMaestro
     * @param tiposCombosMaestro
     * @param valorCombosMaestro
     * @param radioMaestro
     * @return
     */
    public Form creaForma(String titulo, Vector contenidos, String[] titulos, String[] tipoDato, int[] tipoCampo,
            int[] longitud, int[] requerido, Vector combosMaestro, Vector tiposCombosMaestro,
            Vector valorCombosMaestro, Vector radioMaestro, int pk, boolean edicion,
            boolean maestro, Vector pkMaes, Vector pkDet, String[] valorespkMaestro,
            String[] camposTabla, int[] precisiones, boolean defaultvalues, String[] valores) {

        forma.removeAllProperties();
        forma.setCaption(titulo);
        //forma.setWriteThrough(false);  // habilita buffer de datos
        Object[] pkDetalle = new Object[0];
        Object[] pkMaestro = new Object[0];
        if (!maestro) {
            pkMaestro = pkMaes.toArray();
            pkDetalle = pkDet.toArray();
            logger.debug("OPA - " + "PK Maestro=" + StringUtils.arrayToDelimitedString(pkMaestro, " "));
            logger.debug("OPA - " + "PK Detalle=" + StringUtils.arrayToDelimitedString(pkDetalle, " "));
            //logger.debug("OPA - " + "PK Valores=" + StringUtils.arrayToDelimitedString(valorespkMaestro, " "));
        } else {
            logger.debug("OPA - " + "PK Maestro=" + StringUtils.arrayToDelimitedString(pkMaestro, " "));

        }
        int i = 0;

        for (Object contenido : contenidos) {
            int posicionLlave = -1;
            if (!maestro) {
                posicionLlave = this.buscarCampoLLave(camposTabla[i], pkDetalle);
                if (posicionLlave != -1 && !edicion) {
                    contenido = valorespkMaestro[posicionLlave];
                }
            }

            if (tipoCampo[i] == TIPOC_DATAFIELD || tipoCampo[i] == TIPOC_HIDDEN || tipoCampo[i] == TIPOC_READONLY) // crea campos
            {
                if (tipoDato[i].equalsIgnoreCase(TIPOD_DATE)) // crea campos para fechas
                {
                    PopupDateField t = new PopupDateField(titulos[i]);  // titulo

                    if (edicion && contenido != null) {

                        if (contenido.toString().length() > 8) {
                            contenido = Date.valueOf(Utiles.corrigeDatos(contenido.toString().substring(0, 10)));
                        }
                        t.setValue(Date.valueOf(contenido.toString()));
                        
                    }
                    t.setResolution(PopupDateField.RESOLUTION_DAY);
                    t.setRequired(Utiles.esRequerido(requerido[i]));
                    t.setRequiredError(ERROR_R_DATE + titulos[i]);
                    t.setWidth(SIZEPIX_DATES, Sizeable.Unit.PIXELS);
                    t.setDateFormat(FORMATOS.get("DATE"));

                    if (tipoCampo[i] == TIPOC_HIDDEN) {
                        t.setVisible(false);
                        if (defaultvalues) {
                            if (valores[i] != null) {
                               // t.setValue();
                                t.setValue(Date.valueOf(valores[i]));
                            }

                        }
                    }

                    if (tipoCampo[i] == TIPOC_READONLY) {
                        t.setEnabled(false);
                    }

                    if (edicion) {
                        if (i < pk) {
                            t.setEnabled(false);
                        }
                    }
                    if (posicionLlave != -1 && !maestro) {
                        t.setEnabled(false);
                    }

                    forma.addField(i, t);
                } else if (tipoDato[i].equalsIgnoreCase(TIPOD_STRING)) // crea campos para strings
                {
                    //

                    if (longitud[i] > COLUMNSMAX_TEXTFIELD) {
                        TextArea t = new TextArea(titulos[i]);  // titulo
                        t.setRows(2);
                        t.setColumns(COLUMNSMAX_TEXTFIELD);   // tamaño
                        t.setWordwrap(true);
                        //t.setSizeFull();
                        t.setWidth(COLUMNSMAX_TEXTFIELD, Sizeable.UNITS_EM);
                        t.setMaxLength(longitud[i]);

                        t.setValue(Utiles.corrigeDatos(contenido));   // limpia blancos innecesarios
                        t.setRequired(Utiles.esRequerido(requerido[i]));
                        t.setRequiredError(ERROR_R_STRING + titulos[i]);

                        if (tipoCampo[i] == TIPOC_HIDDEN) {
                            t.setVisible(false);
                            if (defaultvalues) {
                                if (valores[i] != null) {
                                    t.setValue(valores[i]);
                                }
                            }
                        }

                        if (tipoCampo[i] == TIPOC_READONLY) {
                            t.setEnabled(false);
                        }

                        if (edicion) {
                            if (i < pk) {
                                t.setEnabled(false);
                            }
                        }
                        if (posicionLlave != -1 && !maestro) {
                            t.setEnabled(false);
                        }

                        t.addValidator(new StringLengthValidator("El campo " + titulos[i] + " debe tener entre 1 y " + longitud[i] + " de longitud", 1, longitud[i], false));
                        forma.addField(i, t);

                    } else {
                        TextField t = new TextField(titulos[i]);  // titulo
                        //t.setRows(1);
                        t.setColumns(longitud[i]);   // tamaño
                        t.setWidth(longitud[i], Sizeable.UNITS_EM);
                        t.setMaxLength(longitud[i]);

                        t.setValue(Utiles.corrigeDatos(contenido));   // limpia blancos innecesarios
                        t.setRequired(Utiles.esRequerido(requerido[i]));
                        t.setRequiredError(ERROR_R_STRING + titulos[i]);

                        if (tipoCampo[i] == TIPOC_HIDDEN) {
                            t.setVisible(false);
                            if (defaultvalues) {
                                if (valores[i] != null) {
                                    t.setValue(valores[i]);
                                }
                            }
                        }

                        if (tipoCampo[i] == TIPOC_READONLY) {
                            t.setEnabled(false);
                        }

                        if (edicion) {
                            if (i < pk) {
                                t.setEnabled(false);
                            }
                        }
                        if (posicionLlave != -1 && !maestro) {
                            t.setEnabled(false);
                        }

                        t.addValidator(new StringLengthValidator("El campo " + titulos[i] + " debe tener entre 1 y " + longitud[i] + " de longitud", 1, longitud[i], false));
                        forma.addField(i, t);

                    }
                } else if (tipoDato[i].equalsIgnoreCase(TIPOD_INTEGER)
                        || tipoDato[i].equalsIgnoreCase(TIPOD_LONG)) // crea campos para enteros
                {

                    TextField t = obtainNumberFieldInt(titulos[i], contenido, longitud[i],
                            precisiones[i], requerido[i], tipoDato[i]);
                    if (tipoCampo[i] == TIPOC_HIDDEN) {
                        t.setVisible(false);
                        if (defaultvalues) {
                            if (valores[i] != null) {
                                t.setValue(valores[i]);
                            }

                        }
                    }

                    if (tipoCampo[i] == TIPOC_READONLY) {
                        t.setEnabled(false);
                    }

                    if (edicion) {
                        if (i < pk) {
                            t.setEnabled(false);
                        }
                    }
                    if (posicionLlave != -1 && !maestro) {
                        t.setEnabled(false);
                    }
                    if (tipoDato[i].equalsIgnoreCase(TIPOD_INTEGER)) {
                        t.addValidator(new CustomLongValidator("El campo " + titulos[i] + " debe ser un entero"));
                    } else {
                        t.addValidator(new CustomLongValidator("El campo " + titulos[i] + " debe ser un long"));
                    }
                    forma.addField(i, t);
                } else if (tipoDato[i].equalsIgnoreCase(TIPOD_DOUBLE)) // crea campos para dobles
                {
                    TextField t = obtainNumberField(titulos[i], contenido, longitud[i],
                            precisiones[i], requerido[i], tipoDato[i]);
                    if (edicion && i < pk || (posicionLlave != -1 && !maestro)) {
                        t.setEnabled(false);
                    }

                    if (tipoCampo[i] == TIPOC_HIDDEN) {
                        t.setVisible(false);
                        if (defaultvalues) {
                            if (valores[i] != null) {
                                t.setValue(valores[i]);
                            }

                        }
                    }

                    if (tipoCampo[i] == TIPOC_READONLY) {
                        t.setEnabled(false);
                    }

                    forma.addField(i, t);
                } else if (tipoDato[i].equalsIgnoreCase(TIPOD_DECIMAL)) // crea campos para dobles
                {
                    //NumberField numField = new NumberField();                    
                    TextField t = obtainNumberField(titulos[i], contenido, longitud[i],
                            precisiones[i], requerido[i], tipoDato[i]);
                    if (edicion && i < pk || (posicionLlave != -1 && !maestro)) {
                        t.setEnabled(false);
                    }

                    if (tipoCampo[i] == TIPOC_HIDDEN) {
                        t.setVisible(false);
                        if (defaultvalues) {
                            if (valores[i] != null) {
                                t.setValue(valores[i]);
                            }

                        }
                    }

                    if (tipoCampo[i] == TIPOC_READONLY) {
                        t.setEnabled(false);
                    }

                    forma.addField(i, t);
                }
            } else if (tipoCampo[i] == TIPOC_LISTBOX) // aqui procesa los combos
            {
                if (titulo.equals("Gesti�n de oferta de venta permanente")) {
                    if (titulos[i].equals("Martillo")) {
                        tm = new Select(titulos[i]);    // define combo
                        tm.setItemCaptionMode(Select.ITEM_CAPTION_MODE_EXPLICIT_DEFAULTS_ID);   // activa uso de id explicitos para el select
                        tm.setNullSelectionAllowed(false);
                        tm.setRequired(Utiles.esRequerido(requerido[i]));
                        tm.setRequiredError(ERROR_R_STRING + titulos[i]);

                        if (((Integer) tiposCombosMaestro.get(i)) == TIPOCOMBO_SQL) {
                            //logger.debug("OPA - " + "Tipo Combo SQL: "+i);
                            Vector infoSQL = (Vector) combosMaestro.get(i);
                            String tabla = (String) infoSQL.get(0);
                            String muestra = (String) infoSQL.get(1);
                            String almacena = (String) infoSQL.get(2);
                            String tipoAlmacena = (String) infoSQL.get(3);
                            String query = "SELECT " + muestra + "," + almacena + " FROM " + tabla + " ORDER BY " + muestra;
                            //logger.debug("OPA - " + query);
                            try {
                                ResultSet r1 = reportDAO.consultaBaseDatos(query);  	// efectua consulta de datos

                                while (r1.next()) {
                                    if (tipoAlmacena.equalsIgnoreCase("1")) {
                                        tm.addItem(r1.getString(almacena));            //adicional el valor a almacenar si es tipo string
                                        tm.setItemCaption(r1.getString(almacena), r1.getString(muestra));   //adiciona el valor a mostrar   
                                    }
                                    if (tipoAlmacena.equalsIgnoreCase("2")) {
                                        tm.addItem(r1.getInt(almacena));            //adicional el valor a almacenar si es tipo entero
                                        tm.setItemCaption(r1.getInt(almacena), r1.getString(muestra));   //adiciona el valor a mostrar       
                                    }
                                }

                            } catch (SQLException e) {
                                logger.error(e.getMessage(), e);
                            }
                            tm.setValue(contenido);
                            tm.setImmediate(true);

                            if (edicion) {
                                if (i < pk) {
                                    tm.setEnabled(false);
                                }
                            }
                            if (posicionLlave != -1 && !maestro) {
                                tm.setEnabled(false);
                            }

                            forma.addField(i, tm);

                        } else if (((Integer) tiposCombosMaestro.get(i)) == TIPOCOMBO_ARREGLO) {
                            Vector iMostrar = (Vector) combosMaestro.get(i);  // valores que se visualizan
                            Vector iAlmacenar = (Vector) valorCombosMaestro.get(i);
                            for (int j = 0; j < iMostrar.size(); j++) {
                                tm.addItem((String) iAlmacenar.get(j));            //adicional el valor a almacenar
                                tm.setItemCaption((String) iAlmacenar.get(j), (String) iMostrar.get(j));   //adiciona el valor a mostrar
                            }
                        }
                        tm.setValue(String.valueOf(contenido));

                        tm.setImmediate(true);
                        if (edicion) {
                            if (i < pk) {
                                tm.setEnabled(false);
                            }
                        }
                        if (posicionLlave != -1 && !maestro) {
                            tm.setEnabled(false);
                        }

                        forma.addField(i, tm);
                    } else if (titulos[i].equals("Lotes")) {
                        tml = new Select(titulos[i]);    // define combo
                        tml.setItemCaptionMode(Select.ITEM_CAPTION_MODE_EXPLICIT_DEFAULTS_ID);   // activa uso de id explicitos para el select
                        tml.setNullSelectionAllowed(false);
                        tml.setRequired(Utiles.esRequerido(requerido[i]));
                        tml.setRequiredError(ERROR_R_STRING + titulos[i]);

                        if (((Integer) tiposCombosMaestro.get(i)) == TIPOCOMBO_SQL) {
                            //logger.debug("OPA - " + "Tipo Combo SQL: "+i);
                            Vector infoSQL = (Vector) combosMaestro.get(i);
                            String tabla = (String) infoSQL.get(0);
                            String muestra = (String) infoSQL.get(1);
                            String almacena = (String) infoSQL.get(2);
                            String tipoAlmacena = (String) infoSQL.get(3);
                            String query = "SELECT " + muestra + "," + almacena + " FROM " + tabla + " ORDER BY " + muestra;
                            //logger.debug("OPA - " + query);
                            try {
                                ResultSet r1 = reportDAO.consultaBaseDatos(query);  	// efectua consulta de datos

                                while (r1.next()) {
                                    if (tipoAlmacena.equalsIgnoreCase("1")) {
                                        tml.addItem(r1.getString(almacena));            //adicional el valor a almacenar si es tipo string
                                        tml.setItemCaption(r1.getString(almacena), r1.getString(muestra));   //adiciona el valor a mostrar
                                    }
                                    if (tipoAlmacena.equalsIgnoreCase("2")) {
                                        tml.addItem(r1.getInt(almacena));            //adicional el valor a almacenar si es tipo entero
                                        tml.setItemCaption(r1.getInt(almacena), r1.getString(muestra));   //adiciona el valor a mostrar
                                    }
                                }

                            } catch (SQLException e) {
                                logger.error(e.getMessage(), e);
                            }
                            tml.setValue(contenido);
                            tml.setImmediate(true);
                            if (edicion) {
                                if (i < pk) {
                                    tml.setEnabled(false);
                                }
                            }
                            if (posicionLlave != -1 && !maestro) {
                                tml.setEnabled(false);
                            }

                            forma.addField(i, tml);

                        } else if (((Integer) tiposCombosMaestro.get(i)) == TIPOCOMBO_ARREGLO) {
                            Vector iMostrar = (Vector) combosMaestro.get(i);  // valores que se visualizan
                            Vector iAlmacenar = (Vector) valorCombosMaestro.get(i);
                            for (int j = 0; j < iMostrar.size(); j++) {
                                tml.addItem((String) iAlmacenar.get(j));            //adicional el valor a almacenar
                                tml.setItemCaption((String) iAlmacenar.get(j), (String) iMostrar.get(j));   //adiciona el valor a mostrar
                            }
                        }
                        tml.setValue(String.valueOf(contenido));

                        tml.setImmediate(true);
                        if (edicion) {
                            if (i < pk) {
                                tml.setEnabled(false);
                            }
                        }
                        if (posicionLlave != -1 && !maestro) {
                            tml.setEnabled(false);
                        }
                        tml.setValue(1);
                        tml.setEnabled(false);
                        forma.addField(i, tml);
                    } else {
                        Select t = new Select(titulos[i]);    // define combo
                        t.setItemCaptionMode(Select.ITEM_CAPTION_MODE_EXPLICIT_DEFAULTS_ID);   // activa uso de id explicitos para el select
                        t.setNullSelectionAllowed(false);
                        t.setRequired(Utiles.esRequerido(requerido[i]));
                        t.setRequiredError(ERROR_R_STRING + titulos[i]);

                        if (((Integer) tiposCombosMaestro.get(i)) == TIPOCOMBO_SQL) {
                            //logger.debug("OPA - " + "Tipo Combo SQL: "+i);
                            Vector infoSQL = (Vector) combosMaestro.get(i);
                            String tabla = (String) infoSQL.get(0);
                            String muestra = (String) infoSQL.get(1);
                            String almacena = (String) infoSQL.get(2);
                            String tipoAlmacena = (String) infoSQL.get(3);
                            String query = "SELECT " + muestra + "," + almacena + " FROM " + tabla + " ORDER BY " + muestra;
                            //logger.debug("OPA - " + query);
                            try {
                                ResultSet r1 = reportDAO.consultaBaseDatos(query);  	// efectua consulta de datos

                                while (r1.next()) {
                                    if (tipoAlmacena.equalsIgnoreCase("1")) {
                                        t.addItem(r1.getString(almacena));            //adicional el valor a almacenar si es tipo string
                                        t.setItemCaption(r1.getString(almacena), r1.getString(muestra));   //adiciona el valor a mostrar
                                    }
                                    if (tipoAlmacena.equalsIgnoreCase("2")) {
                                        t.addItem(r1.getInt(almacena));            //adicional el valor a almacenar si es tipo entero
                                        t.setItemCaption(r1.getInt(almacena), r1.getString(muestra));   //adiciona el valor a mostrar   
                                    }
                                }

                            } catch (SQLException e) {
                                logger.error(e.getMessage(), e);
                            }
     
                              if(titulos[i].equals("Tipo documento cliente vendedor")){
                                  if(contenido.toString().equals("1")){  
                                      t.select(t.getItemIds().toArray()[1]); 
                                      t.setImmediate(true);
                                  }
                                  else if(contenido.toString().equals("5")){
                                   t.select(t.getItemIds().toArray()[2]);
                                  t.setImmediate(true);
                                  }else if(contenido.toString().equals("4")){
                                   t.select(t.getItemIds().toArray()[3]);
                                  t.setImmediate(true);
                                  }else if(contenido.toString().equals("2")){
                                   t.select(t.getItemIds().toArray()[4]);
                                  t.setImmediate(true);
                                  }else if(contenido.toString().equals("6")){
                                   t.select(t.getItemIds().toArray()[5]);
                                  t.setImmediate(true);
                                  }else if(contenido.toString().equals("3")){
                                   t.select(t.getItemIds().toArray()[6]);
                                  t.setImmediate(true);
                                  }
                                 }  
                              else{
                            t.setValue(contenido);
                            t.setImmediate(true);}
                              
                            if (edicion) {
                                if (i < pk) {
                                    t.setEnabled(false);
                                }
                            }
                            if (posicionLlave != -1 && !maestro) {
                                t.setEnabled(false);
                            }
                            
                            if (titulos[i].equals("Estado")&& JFormMD.conmod==1){
                              t.setEnabled(true);
                              JFormMD.conmod=0;
                            }else{
                                if(titulos[i].equals("Estado")){
                                t.setEnabled(false);
                                JFormMD.conmod=0;}
                            }

                            forma.addField(i, t);
                        }
                    }
                } else {
                    Select t = new Select(titulos[i]);    // define combo
                    t.setItemCaptionMode(Select.ITEM_CAPTION_MODE_EXPLICIT_DEFAULTS_ID);   // activa uso de id explicitos para el select
                    t.setNullSelectionAllowed(false);
                    t.setRequired(Utiles.esRequerido(requerido[i]));
                    t.setRequiredError(ERROR_R_STRING + titulos[i]);

                    if (((Integer) tiposCombosMaestro.get(i)) == TIPOCOMBO_SQL) {
                        //logger.debug("OPA - " + "Tipo Combo SQL: "+i);
                        Vector infoSQL = (Vector) combosMaestro.get(i);
                        String tabla = (String) infoSQL.get(0);
                        String muestra = (String) infoSQL.get(1);
                        String almacena = (String) infoSQL.get(2);
                        String tipoAlmacena = (String) infoSQL.get(3);
                        String query = "SELECT " + muestra + "," + almacena + " FROM " + tabla + " ORDER BY " + muestra;
                        //logger.debug("OPA - " + query);
                        try {
                            ResultSet r1 = reportDAO.consultaBaseDatos(query);  	// efectua consulta de datos

                            while (r1.next()) {
                                if (tipoAlmacena.equalsIgnoreCase("1")) {
                                    t.addItem(r1.getString(almacena));            //adicional el valor a almacenar si es tipo string
                                    t.setItemCaption(r1.getString(almacena), r1.getString(muestra));   //adiciona el valor a mostrar
                                }
                                if (tipoAlmacena.equalsIgnoreCase("2")) {
                                    t.addItem(r1.getInt(almacena));            //adicional el valor a almacenar si es tipo entero
                                    t.setItemCaption(r1.getInt(almacena), r1.getString(muestra));   //adiciona el valor a mostrar
                                }
                            }

                        } catch (SQLException e) {
                            logger.error(e.getMessage(), e);
                        }
                        t.setValue(contenido);
                        t.setImmediate(true);
                        if (edicion) {
                            if (i < pk) {
                                t.setEnabled(false);
                            }
                        }
                        if (posicionLlave != -1 && !maestro) {
                            t.setEnabled(false);
                        }

                        forma.addField(i, t);

                    } else if (((Integer) tiposCombosMaestro.get(i)) == TIPOCOMBO_ARREGLO) {
                        Vector iMostrar = (Vector) combosMaestro.get(i);  // valores que se visualizan
                        Vector iAlmacenar = (Vector) valorCombosMaestro.get(i);
                        for (int j = 0; j < iMostrar.size(); j++) {
                            t.addItem((String) iAlmacenar.get(j));            //adicional el valor a almacenar
                            t.setItemCaption((String) iAlmacenar.get(j), (String) iMostrar.get(j));   //adiciona el valor a mostrar
                        }
                    }
                    t.setValue(String.valueOf(contenido));

                    t.setImmediate(true);
                    if (edicion) {
                        if (i < pk) {
                            t.setEnabled(false);
                        }
                    }
                    if (posicionLlave != -1 && !maestro) {
                        t.setEnabled(false);
                    }

                    forma.addField(i, t);
                }
            } else if (tipoCampo[i] == TIPOC_RADIOBUTTON) // aqui procesa los radiobuttons
            {

                OptionGroup t = new OptionGroup(titulos[i]);    // define combo
                t.setNullSelectionAllowed(false);
                t.setRequired(Utiles.esRequerido(requerido[i]));
                t.setRequiredError(ERROR_R_STRING + titulos[i]);

                Vector iMostrar = (Vector) radioMaestro.get(i);  // valores que se visualizan
                //Vector iAlmacenar = (Vector) valorCombosMaestro.get(i);
                for (int j = 0; j < iMostrar.size(); j++) {
                    t.addItem((String) iMostrar.get(j));            //adicional el valor a almacenar
                    t.setItemCaption((String) iMostrar.get(j), (String) iMostrar.get(j));   //adiciona el valor a mostrar
                }
                t.setValue(contenido);
                t.setImmediate(true);
                if (edicion) {
                    if (i < pk) {
                        t.setEnabled(false);
                    }
                }
                if (posicionLlave != -1 && !maestro) {
                    t.setEnabled(false);
                }

                forma.addField(i, t);
            } else if (tipoCampo[i] == TIPOC_MULTILINE) // campos multi - linea
            {
                TextArea t = new TextArea(titulos[i]);  // titulo
                t.setColumns(longitud[i]);   // tamaño
                t.setMaxLength(longitud[i]);
                t.setRows(3);
                t.setValue(contenido.toString());
                t.setRequired(Utiles.esRequerido(requerido[i]));
                t.setRequiredError(ERROR_R_STRING + titulos[i]);
                if (edicion) {
                    if (i < pk) {
                        t.setEnabled(false);
                    }
                }
                if (posicionLlave != -1 && !maestro) {
                    t.setEnabled(false);
                }
                forma.addField(i, t);
            }
            i++;
        }

        //forma.addValidator()
        forma.setImmediate(true);
        forma.setValidationVisible(true);
        forma.setInvalidCommitted(false);

        return forma;
    }

    private TextField obtainNumberField(final String titulo, Object value,
            int longitud, final int numDecimales, int requerido, String tipo) {

        final NumberProperty property = new NumberProperty();
        property.setValue(new BigDecimal(value.toString()));
        PropertyFormatter propFormatter = new NumberPropertyFormatter();
        propFormatter.setPropertyDataSource(property);
        //propFormatter.setDecimales(numDecimales);
        //propFormatter.setDecimalFormat();

        final TextField field = new TextField();

        int numEnteros = longitud - numDecimales;
        if (numEnteros <= 0) {
            numEnteros = 1;
        }

        int longitudReal = numDecimales > 0 ? longitud + 1 : longitud;

        if (value != null) {
            field.setValue(value.toString());
            //field.setValue(Utiles.formateaDatos(value, tipo, "", longitud, Alineacion.DERECHA, numDecimales));
        }

        field.setImmediate(true);
        field.setCaption(titulo);
        field.setColumns(longitudReal);   // tamaño
        field.setMaxLength(longitudReal);
        field.setRequired(Utiles.esRequerido(requerido));
        field.setRequiredError("'" + titulo + "': es requerido");

        //field.addValidator(new CustomDoubleValidator(titulo, numEnteros, numDecimales));
        field.setPropertyDataSource(propFormatter);

        field.addListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                NumberProperty property = new NumberProperty();
                property.setValue(new BigDecimal(Utiles.retiraFormatoMiles(event.getProperty().toString())));
                NumberPropertyFormatter propFormatter = new NumberPropertyFormatter();
                propFormatter.setPropertyDataSource(property);
                propFormatter.setDecimales(numDecimales);
                propFormatter.setDecimalFormat();

                field.setPropertyDataSource(propFormatter);

            }
        });

        return field;
    }

    private TextField obtainNumberFieldInt(final String titulo, Object value,
            int longitud, int numDecimales, int requerido, String tipo) {

        NumberProperty property = new NumberProperty();
        property.setValue(new BigDecimal(value.toString()));
        NumberPropertyFormatter propFormatter = new NumberPropertyFormatter();
        propFormatter.setPropertyDataSource(property);
        propFormatter.setDecimales(0);
        propFormatter.setDecimalFormat();
//Ojo
        final TextField field = new TextField();

        int numEnteros = longitud - numDecimales;
        if (numEnteros <= 0) {
            numEnteros = 1;
        }

        int longitudReal = numDecimales > 0 ? longitud + 1 : longitud;

        if (value != null) {
            field.setValue(value.toString());
           // field.setValue(new Integer(value.toString()));
            //field.setValue(Utiles.formateaDatos(value, tipo, "", longitud, Alineacion.DERECHA, numDecimales));
        }

        field.setImmediate(true);
        field.setCaption(titulo);
        field.setColumns(longitudReal);   // tamaño
        field.setMaxLength(longitudReal);
        field.setRequired(Utiles.esRequerido(requerido));
        field.setRequiredError("'" + titulo + "': es requerido");

        field.setPropertyDataSource(propFormatter);

        field.addListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                NumberProperty property = new NumberProperty();
                property.setValue(new BigDecimal(Utiles.retiraFormatoMiles(event.getProperty().toString())));
                NumberPropertyFormatter propFormatter = new NumberPropertyFormatter();
                propFormatter.setPropertyDataSource(property);
                propFormatter.setDecimales(0);
                propFormatter.setDecimalFormat();

                field.setPropertyDataSource(propFormatter);

            }
        });

        return field;
    }

//    private NumberField obtainNumberField2(final String titulo, Object value,
//            int longitud, int numDecimales, int requerido, String tipo) {
//
//      NumberField field = new NumberField();
//
//      int numEnteros = longitud - numDecimales;
//      if (numEnteros <= 0) {
////        numEnteros = 1;
////      }
//
//      int longitudReal = numDecimales > 0 ? longitud +1 : longitud;
//      
//      
//      
//
//      if (value != null) {
//        //field.setValue(value.toString());
//        field.setValue(Utiles.formateaDatos(value,tipo , "" , longitud, Alineacion.DERECHA, numDecimales));
//      }
//      
//      if (numDecimales>0) {
//          field.setDecimalAllowed(true);
//          field.setDecimalPrecision(numDecimales);
//          field.setDecimalSeparator('.');
//      }
//      field.setGroupingSeparator(',');
//      field.setGroupingUsed(true);
//      field.setGroupingSize(3);
//      
//      
//
//      field.setImmediate(true);
//      field.setCaption(titulo);
//      field.setColumns(longitudReal);   // tamaño
//      field.setMaxLength(longitudReal);
//      field.setRequired(Utiles.esRequerido(requerido));
//      field.setRequiredError("'" + titulo + "': es requerido");
//      field.setErrorText("Error en el campo "+titulo+ " numerico");
//      field.setNegativeAllowed(false);
//      field.addValidator(new CustomDoubleValidator(titulo, numEnteros, numDecimales));
//
//      return field;
//    }
    private int buscarCampoLLave(String campoActual, Object[] llaveDetalle) {
        int hallar = -1;
        for (int i = 0; i < llaveDetalle.length; i++) {
            if (campoActual.equals(llaveDetalle[i].toString())) {
                logger.debug("OPA - " + "Hallo la llave del campo" + campoActual + " en la posicion " + i + " campo" + llaveDetalle[i].toString());
                hallar = i;
            }
        }
        return hallar;
    }
}
