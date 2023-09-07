//package com.quasar.frameq.data;
//
//import com.quasar.frameq.db.Persistente;
//import com.quasar.frameq.fachadas.FacadeUsuarios;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import com.quasar.frameq.interfaces.Error;
//import java.util.Collection;
//import java.util.Vector;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class Representante extends Persistente {
//    private Integer representante;
//    private Integer tipodocumento;
//    private String numdocumento;
//    private String tipopersona;
//    private String apellidos;
//    private String nombres;
//    private String pais;
//    private String email;
//    private ArrayList errores;
//    private int numFormulario;
//
//    // Campo agregado
//    private Double telefono;
//    private String direccion;
//    private Integer departamento;
//    private Integer ciudad;
//
//    public Representante() {
//        this.representante = new Integer(0);
//        this.tipodocumento = new Integer(0);
//        this.numdocumento = "";
//        this.tipopersona = "";
//        this.apellidos = "";
//        this.nombres = "";
//        this.pais = "";
//        this.email = "";
//        // Campo agregado
//        this.telefono = new Double(0);
//        this.direccion = "";
//        this.departamento = new Integer(0);
//        this.ciudad = new Integer(0);
//        errores = new ArrayList();
//    }
//
//    public void setRepresentante(String registro) {
//
//            this.setRepresentante(new Integer(0)); // Consecutivo
//            if (registro.substring(16, 17).trim().length() > 0)
//                this.tipodocumento = new Integer(registro.substring(16, 17).trim()); //
//            else
//                this.tipodocumento = new Integer(0);
//
//            if (registro.substring(6, 15).trim().length() > 0)
//                this.numFormulario = Integer.parseInt(registro.substring(6, 15));
//            else
//                this.numFormulario = 0;
//
//            if (registro.substring(17, 32).trim().length() > 0)
//                this.numdocumento = registro.substring(17, 32).trim();
//            else
//                this.numdocumento = "0";
//
//            if (registro.substring(15, 16).trim().length() > 0)
//                this.tipopersona = registro.substring(15, 16).trim();
//            else
//                this.tipopersona = "";
//
//            this.setApellidos(registro.substring(32, 62).trim());
//            this.setNombres(registro.substring(62, 92).trim());
//            if (registro.substring(92, 94).trim().length() > 0)
//                this.pais = registro.substring(92, 94).trim(); // Código del país
//            else
//                this.pais = "CO";
//
//            if (registro.substring(94, 127).trim().length() > 0)
//                this.email = registro.substring(94, 127).trim();
//            else
//                this.email = "";
//
//            // Campos agregados
//            if (registro.substring(127, 137).trim().length() > 0) {
//                this.telefono = new Double(registro.substring(127, 137).trim());
//            } else
//                this.telefono = new Double(0);
//
//    }
//
//    public void validar(String registro, String consecutivo, Collection errores) {
//
//            Error error = new Error();
//
//            this.setRepresentante(new Integer(0)); // Consecutivo
//            try {
//                error = this.setTipodocumento(new Integer(registro.substring(16, 17).trim())); //
//            } catch (NumberFormatException e) {
//                error.setTipoError(2050);
//                error.setCampo(5);
//                error.setDescripcion("El dato del tipo de documento no es nùmerico");
//            }
//
//            if (error.getTipoError() > 0) {
//                error.setRegistro(Integer.parseInt(consecutivo));
//                errores.add(error);
//            }
//
//            try {
//                error = this.setNumFormulario(Integer.parseInt(registro.substring(6, 15)));
//
//                if (error.getTipoError() > 0) {
//                        error.setRegistro(Integer.parseInt(consecutivo));
//                        errores.add(error);
//                }
//            } catch (NumberFormatException e) {
//                error.setTipoError(24);
//                error.setDescripcion("El número del formulario no es válido");
//                error.setCampo(3);
//                error.setRegistro(Integer.parseInt(consecutivo));
//                errores.add(error);
//            }
//
//            try {
//                error = this.setNumdocumento(registro.substring(17, 32).trim());
//            } catch (NumberFormatException e) {
//                error.setTipoError(18);
//                error.setDescripcion("El contenido del campo número de documento no es válido");
//                error.setCampo(6);
//            }
//
//            if (error.getTipoError() > 0) {
//                error.setRegistro(Integer.parseInt(consecutivo));
//                errores.add(error);
//            }
//
//            error = this.setTipopersona(registro.substring(15, 16).trim());
//            if (error.getTipoError() > 0) {
//                error.setRegistro(Integer.parseInt(consecutivo));
//                errores.add(error);
//            }
//
//            this.setApellidos(registro.substring(32, 62).trim());
//            this.setNombres(registro.substring(62, 92).trim());
//            error = this.setPais(registro.substring(92, 94).trim()); // Código del                                                                                                       // país
//            if (error.getTipoError() > 0) {
//                error.setRegistro(Integer.parseInt(consecutivo));
//                errores.add(error);
//            }
//            if (registro.substring(94, 127).trim().length() > 0)
//                error = this.setEmail(registro.substring(94, 127).trim());
//            if (error.getTipoError() > 0) {
//                error.setRegistro(Integer.parseInt(consecutivo));
//                errores.add(error);
//            }
//
//            // Campo agregado
//            try {
//                this.setTelefono(new Double(registro.substring(127, 137).trim()));
//            } catch (NumberFormatException e) {
//                error.setTipoError(81);
//                error.setDescripcion("El campo telefono no es numérico");
//                error.setCampo(11);
//                error.setRegistro(Integer.parseInt(consecutivo));
//                errores.add(error);
//            }
//
//    }
//
//    public Representante(Integer representante, Integer tipodocumento, String numdocumento, String tipopersona, String apellidos, String nombres, String pais, String email, Double telefono,
//                String Direccion, Integer departamento, Integer Ciudad) {
//        this.setRepresentante(representante);
//        this.setTipodocumento(tipodocumento);
//        this.setNumdocumento(numdocumento);
//        this.setTipopersona(tipopersona);
//        this.setApellidos(apellidos);
//        this.setNombres(nombres);
//        this.setPais(pais);
//        this.setEmail(email);
//        // Campo agregado
//        this.setTelefono(telefono);
//        this.setDireccion(Direccion);
//        this.setDepartamento(departamento);
//        this.setCiudad(Ciudad);
//    }
//
//
//    public void setRepresentante(Integer representante) {
//        try {
//                this.representante = representante;
//        } catch (NumberFormatException ex) {
//                Logger.getLogger(Representante.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public Error setTipodocumento(Integer tipodocumento) {
//        Connection connection = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        Error error = new Error();
//        error.setRegistro(5);
//        error.setCampo(5);
//        try {
//            connection = this.tabla.getConnection();
//            stmt = connection.createStatement();
//            rs = stmt.executeQuery("select c_nombredoc from dm_tipodocumento where i_tipodocumento = " + tipodocumento);
//            if (rs.next()) {
//                this.tipodocumento = tipodocumento;
//            } else {
//                error.setTipoError(17);
//                error.setDescripcion("El tipo de documento no existe");
//            }
//        } catch (SQLException se) {
//            Logger.getLogger(Representante.class.getName()).log(Level.SEVERE, null, se);
//        }
//        finally{
//            if( stmt != null ){
//                try{stmt.close();}catch(SQLException e ){}
//            }
//            if( rs != null ){
//                try{rs.close();}catch(SQLException e ){}				
//            }
//            if( connection != null ){
//                try{connection.close();}catch(SQLException e ){}				
//            }
//        }
//        return error;
//    }
//
//    public Error setNumdocumento(String numdocumento) {
//        Error error = new Error();
//        error.setRegistro(5);
//        error.setCampo(6);
//        try {
//            this.numdocumento = numdocumento;
//        } catch (NumberFormatException ex) {
//            error.setTipoError(18);
//            error.setDescripcion("El contenido del campo número de documento no es válido");
//            Logger.getLogger(Representante.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return error;
//    }
//
//    public Error setTipopersona(String tipopersona) {
//        Error error = new Error();
//        error.setRegistro(5);
//        error.setCampo(4);
//        if (tipopersona.equalsIgnoreCase("1") || tipopersona.equalsIgnoreCase("2") || tipopersona.equalsIgnoreCase("")) {                                                                                                                                                                                                                              // legal
//            this.tipopersona = tipopersona;
//        } else {
//            error.setTipoError(19);
//            error.setDescripcion("El tipo de persona no es válido");
//        }
//        return error;
//    }
//
//    public void setApellidos(String apellidos) {
//        this.apellidos = apellidos; // No se aplica validación
//    }
//
//    public void setNombres(String nombres) {
//        this.nombres = nombres;
//    }
//
//    // Método agregado
//    public void setTelefono(Double telefono) {
//        this.telefono = telefono;
//    }
//
//    public void setDireccion(String direccion) {
//        this.direccion = direccion;
//    }
//
//    public void setDepartamento(Integer departamento) {
//        this.departamento = departamento;
//    }
//
//    public void setCiudad(Integer ciudad) {
//        this.ciudad = ciudad;
//    }
//
//    public Error setPais(String pais) {
//        Connection connection = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        Error error = new Error();
//        error.setRegistro(5);
//        error.setCampo(9);
//        try {
//            connection = this.tabla.getConnection();
//            stmt = connection.createStatement();
//            // rs =
//            // stmt.executeQuery("select c_nombre from dm_pais where c_codigo = '"+pais+"'");
//            rs = stmt.executeQuery("select c_nombre from dm_pais where c_pais = '" + pais + "'");
//            if (rs.next()) {
//                    this.pais = pais;
//            } else {
//                    error.setTipoError(22);
//                    error.setDescripcion("El código del país no existe");
//            }
//        } catch (SQLException se) {
//            Logger.getLogger(Representante.class.getName()).log(Level.SEVERE, null, se);
//        } finally {
//            try {
//                if (rs != null){
//                    rs.close();
//                }					
//                if (stmt != null){
//                    stmt.close();
//                }
//                if( connection != null ){
//                    connection.close();
//                }
//            } catch (SQLException se) {
//                 Logger.getLogger(Representante.class.getName()).log(Level.SEVERE, null, se);
//            }
//        }
//        return error;
//    }
//
//    public Error setEmail(String email) {
//        Error error = new Error();
//        error.setRegistro(5);
//        error.setCampo(10);
//        if (email.trim().length() == 0)
//            return error;
//        if (email.indexOf("@") > 0)
//            this.email = email.trim();
//        else {
//            error.setTipoError(23);
//            error.setDescripcion("No es un e-mail válido");
//        }
//        return error;
//    }
//
//    public Error setNumFormulario(int numFormulario) {
//        Error error = new Error();
//        error.setRegistro(5);
//        error.setCampo(3);
//        try {
//            this.numFormulario = numFormulario;
//        } catch (NumberFormatException nfe) {
//            error.setTipoError(24);
//            error.setDescripcion("El número del formulario no es válido");
//        }
//        return error;
//    }
//
//    public Integer getRepresentante() {
//        return representante;
//    }
//
//    public Integer getTipodocumento() {
//        return tipodocumento;
//    }
//
//    public String getNumdocumento() {
//        return numdocumento;
//    }
//
//    public String getTipopersona() {
//        return tipopersona;
//    }
//
//    public String getApellidos() {
//        return apellidos;
//    }
//
//    public String getNombres() {
//        return nombres;
//    }
//
//    public String getPais() {
//        return pais;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    // Método agregado
//    public Double getTelefono() {
//        return telefono;
//    }
//
//    public String getDireccion() {
//        return direccion;
//    }
//
//    public Integer getDepartamento() {
//        return departamento;
//    }
//
//    public Integer getCiudad() {
//        return ciudad;
//    }
//
//    public int getNumFormulario() {
//        return numFormulario;
//    }
//
//    public Vector getContenido() {
//        Vector v = new Vector();
//        v.add(representante);
//        v.add(tipodocumento);
//        v.add(numdocumento);
//        v.add(tipopersona);
//        v.add(apellidos);
//        v.add(nombres);
//        v.add(pais);
//        v.add(email);
//        v.add(telefono);
//        v.add(direccion);
//        v.add(departamento);
//        v.add(ciudad);
//
//        return v;
//    }
//
//    public void inicializar() {
//        setPersistente(this);
//        String atributos[] = { "i_representante", "i_tipodocumento", "i_numdocumento", "c_tipopersona", "c_apellidos", "c_nombres", "c_pais", "c_email", "c_telefono", "c_direccion", "i_departamento",
//                        "i_ciudad" };
//        int precision[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
//        this.setPrecision(precision);
//        setAtributos(atributos);
//        setNombreTabla("dm_representante");
//        setElementosLLave(1);
//    }
//
//    public Persistente nuevo(Vector v) {
//        return new Representante((Integer) v.elementAt(0), (Integer) v.elementAt(1), (String) v.elementAt(2), (String) v.elementAt(3), (String) v.elementAt(4), (String) v.elementAt(5),
//                        (String) v.elementAt(6), (String) v.elementAt(7), (Double) v.elementAt(8), (String) v.elementAt(9), (Integer) v.elementAt(10), (Integer) v.elementAt(11));
//    }
//
//    public void setContenido() throws SQLException {
//        this.setRepresentante(new Integer(rs.getInt("i_representante")));
//        this.setTipodocumento(new Integer(rs.getInt("i_tipodocumento")));
//        this.setNumdocumento((rs.getString("i_numdocumento")));
//        this.setTipopersona((rs.getString("c_tipopersona")));
//        this.setApellidos((rs.getString("c_apellidos")));
//        this.setNombres((rs.getString("c_nombres")));
//        this.setPais(rs.getString("c_pais"));
//        this.setEmail((rs.getString("c_email")));
//        // Campo agregado
//        this.setTelefono(new Double(rs.getDouble("c_telefono")));
//        this.setDireccion((rs.getString("c_direccion")));
//        this.setDepartamento(new Integer(rs.getInt("i_departamento")));
//        this.setCiudad(new Integer(rs.getInt("i_ciudad")));
//    }
//
//    public void setContenido(Vector v) {
//        String auxS;
//        Integer auxI;
//        Date auxD;
//        Timestamp auxT;
//        Double auxDb;
//        Long auxL;
//        auxS = v.elementAt(0).toString();
//        auxI = new Integer(auxS);
//        if (auxI != null)
//            this.setRepresentante(auxI);
//        else
//            this.setRepresentante(new Integer(0));
//
//        auxS = v.elementAt(1).toString();
//        auxI = new Integer(auxS);
//        if (auxI != null)
//            this.setTipodocumento(auxI);
//        else
//            this.setTipodocumento(new Integer(0));
//
//        this.setNumdocumento((String) v.elementAt(2));
//
//        this.setTipopersona((String) v.elementAt(3));
//
//        this.setApellidos((String) v.elementAt(4));
//        this.setNombres((String) v.elementAt(5));
//        this.setPais((String) v.elementAt(6));
//        this.setEmail((String) v.elementAt(7));
//        // Campo agregado
//
//        auxS = v.elementAt(8).toString();
//        auxDb = new Double(auxS);
//        if (auxDb != null)
//            this.setTelefono(auxDb);
//        else
//            this.setTelefono(new Double(0L));
//
//        this.setDireccion((String) v.elementAt(9));
//
//        auxS = v.elementAt(10).toString();
//        auxI = new Integer(auxS);
//        if (auxI != null)
//            this.setDepartamento(auxI);
//        else
//            this.setDepartamento(new Integer(0));
//
//        auxS = v.elementAt(11).toString();
//        auxI = new Integer(auxS);
//        if (auxI != null)
//            this.setCiudad(auxI);
//        else
//            this.setCiudad(new Integer(0));
//
//    }
//
//    public boolean referencia(Vector v) {
//        return true;
//    }
//
//    public static void main(String[] args) {
//        try {
//            Representante prueba = new Representante();
//            prueba.consultaG("select i_representante, i_tipodocumento, i_numdocumento, c_tipopersona, c_apellidos, "
//                    + "c_nombres, c_pais, c_email, c_telefono, c_direccion, i_departamento, i_ciudad "
//                    + "from dm_representante where  i_representante in (96,97)");
//            if (prueba.first()) {
//                prueba.setContenido();                
//            }
//        } catch (Exception Ex) {
//            Logger.getLogger(Representante.class.getName()).log(Level.SEVERE, null, Ex);
//        }
//    }
//}
