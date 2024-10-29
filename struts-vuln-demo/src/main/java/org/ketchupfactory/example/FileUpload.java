package org.ketchupfactory.example;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Objects;

public class FileUpload extends ExampleSupport {

    private String message;

    private File file;

    private String filehash;
    private String contentType;
    private String contentTypeMsg;
    private String filename;
    private String filenameMsg;

    public String showForm() throws Exception {
        return INPUT;
    }

    public String execute() throws Exception {
        try {
            if (Objects.isNull(file)) {
                throw new Exception("File is null");
            }
            if (Objects.isNull(contentType)) {
                throw new Exception("contentType is null");
            }
            if (Objects.isNull(filename)) {
                throw new Exception("filename is null");
            }

            setFilehash(hashFile(file));
            setContentTypeMsg(contentType);
            setFilenameMsg(filename);
            setMessage("File upload success. Summary below");
        } catch (Exception e) {
            addActionError(e.getMessage());
            setMessage("Something wrong happened. " + e.getMessage());
        }
        return SUCCESS;
    }

    public String hashFile(File file) throws NoSuchAlgorithmException, IOException {
        // Create a MessageDigest instance for SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Read the file in chunks to avoid memory issues with large files
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] byteArray = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(byteArray)) != -1) {
                digest.update(byteArray, 0, bytesRead);
            }
        }

        // Convert the byte array to a hex string
        return bytesToHex(digest.digest());
    }

    private String bytesToHex(byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    public void setUpload(File file) {
        this.file = file;
    }

    public void setUploadContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setUploadFileName(String filename) {
        this.filename = filename;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFilehash() {
        return filehash;
    }

    public void setFilehash(String filehash) {
        this.filehash = filehash;
    }

    public String getContentTypeMsg() {
        return contentTypeMsg;
    }

    public void setContentTypeMsg(String contentTypeMsg) {
        this.contentTypeMsg = contentTypeMsg;
    }

    public String getFilenameMsg() {
        return filenameMsg;
    }

    public void setFilenameMsg(String filenameMsg) {
        this.filenameMsg = filenameMsg;
    }
}
