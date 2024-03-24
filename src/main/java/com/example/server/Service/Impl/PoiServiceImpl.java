package com.example.server.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.example.server.Mapper.PoiMapper;
import com.example.server.Service.PoiService;
import com.example.server.pojo.Poi;
@Service
public class PoiServiceImpl extends ServiceImpl<PoiMapper,Poi> implements PoiService{

}
