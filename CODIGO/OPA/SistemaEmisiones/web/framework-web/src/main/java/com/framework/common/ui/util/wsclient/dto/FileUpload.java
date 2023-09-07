package com.framework.common.ui.util.wsclient.dto;

import java.io.Serializable;

public class FileUpload implements Serializable{
    
    private static final long serialVersionUID = 8799656478674716638L;    
    private String path;

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    public FileUpload() {
    }

    public FileUpload(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "fileUploadRequest{" + "path=" + path + '}';
    }        
    
}
