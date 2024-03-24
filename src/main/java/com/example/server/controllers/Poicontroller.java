package com.example.server.controllers;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.server.Form.Form;
import com.example.server.Mapper.PicMapper;
import com.example.server.Service.PicService;
import com.example.server.Service.PoiService;
import com.example.server.exception.PoiException;
import com.example.server.pojo.Pic;
import com.example.server.pojo.Poi;
import com.example.server.vo.Field;
import com.example.server.vo.Poivo;
import com.example.server.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/poi")
public class Poicontroller {
    public List<Field>fields=new ArrayList<>();

    @Autowired
    PoiService poiService;
    @Autowired
    PicService picService;
    @Autowired
    PicMapper picMapper;
    private List<Pic> picList(Poi poi){
        QueryWrapper query=new QueryWrapper();
        query.eq("poi_id",poi.getId());
        List<Pic>pics=picService.list(query);
        return pics;
    }

    @GetMapping("/list")
    public Result list(){
        List pageResult= poiService.list();
        return Result.success(pageResult);}

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable int id ) throws Exception {
        Poi poi=poiService.getById(id);
        if(poi==null){
            throw PoiException.NoData();}
        Poivo poivo=new Poivo();
        List<Pic>pics=picList(poi);
        BeanUtils.copyProperties(poi,poivo);
        poivo.setPics(pics);
        return Result.success(poivo);
    }

    @PutMapping("/add")
    public Result add(@RequestBody Form form){
        Poi poi=new Poi();
        BeanUtils.copyProperties(form,poi);
        poiService.save(poi);
        picService.Savemain(form,poi);
        return Result.success();
    }
    @PostMapping("/edit/{id}")
    public Result edit(@RequestBody Form form,@PathVariable int id){
        Poi poi=new Poi();
        BeanUtils.copyProperties(form,poi);
        poi.setId(id);
        poiService.updateById(poi);
        picMapper.deleteByPoiId(id);
        picService.Savemain(form,poi);
        return Result.success();
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
        Poi poi=poiService.getById(id);
        picMapper.deleteByPoiId(poi.getId());
        poiService.removeById(id);
        return Result.success();
    }
}
