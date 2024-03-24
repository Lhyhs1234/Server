package com.example.server.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.Form.Form;
import com.example.server.Service.PicService;
import com.example.server.pojo.Poi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.server.Mapper.PicMapper;
import com.example.server.pojo.Pic;

import java.util.List;

@Service
public class PicServiceImpl extends ServiceImpl<PicMapper,Pic> implements PicService {
    @Autowired
    PicService picService;
    @Override
    public void Savemain(Form form, Poi poi) {
        List<String>urls=form.getUrls();
        for(String url:urls){
            Pic pic=new Pic();
            pic.setPoiId(poi.getId());
            pic.setUrl(url);
            picService.save(pic);
        }
    }
}