package com.framework.common.ui.util.wsclient.dto;

import java.io.Serializable;

public class FileUploadResponse implements Serializable{
    
    private static final long serialVersionUID = 8799656478674716633L;    
    private int error;
    private String mensaje;

    /**
     * @return the error
     */
    public int getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(int error) {
        this.error = error;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public FileUploadResponse() {
    }

    public FileUploadResponse(int error, String mensaje) {
        this.error = error;
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "FileUploadResponse{" + "error=" + error + ", mensaje=" + mensaje + '}';
    }
    
}
