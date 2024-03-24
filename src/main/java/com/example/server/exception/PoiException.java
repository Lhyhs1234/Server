package com.example.server.exception;

public class PoiException extends RuntimeException{
    public PoiException(String msg){
        super(msg);
    }
    public static PoiException OperationFailed(){
        return new PoiException("操作失败");
    }
    public static PoiException NoData(){
        return new PoiException("资源未找到");
    }
    public static PoiException UnknowError(){
        return new PoiException("未知错误");
    }

}
