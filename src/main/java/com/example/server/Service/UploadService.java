package com.example.server.Service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    boolean save(MultipartFile file,String filename,String filepath);
}
