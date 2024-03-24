package com.example.server.controllers;

import com.example.server.Service.Impl.PoiServiceImpl;
import com.example.server.Service.Impl.UploadServiceImpl;
import com.example.server.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/common")
public class Commoncontroller {
    @Value("${upload.filepath}")
    String filepath;
    @Value("${upload.webpath}")
    String webpath;
    @Autowired
    UploadServiceImpl uploadService;
    @PostMapping("/upload")
    public Result upload(HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest) request;
        MultipartFile multipartFile=multipartHttpServletRequest.getFile("file");
        String filename=multipartFile.getOriginalFilename();
        if(uploadService.save(multipartFile,filename,filepath)){
            return Result.success(webpath+filename);
        }
        else{
            return Result.error();
        }
    }
}
