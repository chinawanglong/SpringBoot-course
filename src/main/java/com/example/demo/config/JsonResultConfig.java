package com.example.demo.config;


import lombok.Data;

/**
 * 返回信息封装
 *
 * @param <T>
 * @author elliot
 */
@Data
public class JsonResultConfig<T> {
    private T data; // 返回的数据
    private String code; // code码
    private String msg; // 提示信息


    public JsonResultConfig(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public JsonResultConfig(String code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }



}
