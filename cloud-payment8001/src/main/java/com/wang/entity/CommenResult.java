package com.wang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommenResult <T>{
    private Integer code;
    private String message;
    private T data;

    public CommenResult(Integer code,String message){
        this(code,message,null);
    }
}
