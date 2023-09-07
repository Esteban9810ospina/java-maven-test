package com.framework.common.ui.util.wsclient.dto;

import java.io.Serializable;

public class FileUploadRequest implements Serializable{
    
    private static final long serialVersionUID = 8799656478674716635L; 
    private FileUpload fileUpload;
    
    /**
     * @return the fileUpload
     */
    public FileUpload getFileUpload() {
        return fileUpload;
    }

    /**
     * @param fileUpload the fileUpload to set
     */
    public void setFileUpload(FileUpload fileUpload) {
        this.fileUpload = fileUpload;
    }

    public FileUploadRequest() {
    }

    public FileUploadRequest(FileUpload fileUpload) {
        this.fileUpload = fileUpload;
    }

    @Override
    public String toString() {
        return "FileUploadRequest{" + "fileUpload=" + fileUpload + '}';
    }
    
    public String toJson(){
            String FileUploadRequestJson = "";
            FileUploadRequestJson = FileUploadRequestJson +"    {";
            FileUploadRequestJson = FileUploadRequestJson +"        \"fileUpload\":{";
            FileUploadRequestJson = FileUploadRequestJson +"            \"path\":\""+this.getFileUpload().getPath()+"\"";
            FileUploadRequestJson = FileUploadRequestJson +"        }";
            FileUploadRequestJson = FileUploadRequestJson +"    }";
            return FileUploadRequestJson;
    }
    
}
