package com.framework.common.ui.util.wsclient;

import com.framework.common.ui.util.wsclient.dto.FileUploadRequest;
import com.framework.common.ui.util.wsclient.dto.FileUploadResponse;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class UtilUploadIdrClient {

    public FileUploadResponse uploadFile(FileUploadRequest request) {
        FileUploadResponse response = new FileUploadResponse();
        @SuppressWarnings("UnusedAssignment")
        HttpURLConnection conn = null;
        InputStream is =null;
        try {
            Properties properties = new Properties(); 
            Properties utilProperties = new Properties(); 
            is = UtilUploadIdrClient.class.getResourceAsStream("/util.properties");
            utilProperties.load(is);
            properties.load(new FileInputStream(new File(utilProperties.get("propiedades.s3").toString())));
            URL url = new URL(properties.get("URLWS").toString());
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            OutputStream os = conn.getOutputStream();
            os.write(request.toJson().getBytes());
            os.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            Gson gson = new Gson();
            while ((output = br.readLine()) != null) {
                response = gson.fromJson(output, FileUploadResponse.class);
            }
            conn.disconnect();
        } catch (IOException e) {
            try {
                throw new IOException(e.getMessage(), e);
            } catch (IOException ex) {
            }
        }
        return response;
    }
}
