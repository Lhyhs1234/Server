package com.example.server.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.Form.Form;
import com.example.server.pojo.Pic;
import com.example.server.pojo.Poi;

import java.util.List;

public interface PicService extends IService<Pic> {
    void Savemain(Form form, Poi poi);
}
