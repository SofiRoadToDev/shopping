package com.sofi.shopping.services;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.SocketException;

@Service
public class StorageService {
    private final String FTP_SERVER_ADDRESS="127.0.0.1";
    private  FTPClient ftpClient;
    private String uploadToFTPSErver(MultipartFile file) throws IOException {
        String fileName=file.getOriginalFilename();
        String imageUrl="ftp://"+FTP_SERVER_ADDRESS+"/"+fileName;
        try{
            ftpClient=new FTPClient();
            ftpClient.connect(FTP_SERVER_ADDRESS);
            ftpClient.login("one","1234");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            if(ftpClient.storeFile(fileName,file.getInputStream())){
                return imageUrl;
            }else{
                return "Failed to upload the file";
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(ftpClient.isConnected()){
                ftpClient.disconnect();
            }
        }

    }
}
