package com.example.server.Service.Impl;

import com.example.server.Service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadServiceImpl implements UploadService {

    @Override
    public boolean save(MultipartFile file, String filename, String filepath) {
        String path=filepath+filename;
        File targetfile=new File(path);
        if(!targetfile.getParentFile().exists()){
         targetfile.getParentFile().mkdirs();
        }
        try {
            FileCopyUtils.copy(file.getBytes(), targetfile);
            return true;
        }catch (IOException e){}
        return false;
    }
}
