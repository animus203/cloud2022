package com.ludens.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>{
    //错误代码
    private Integer code;
    //错误信息
    private String message;
    //data
    private T data;

    //自定义一个两参数的构造方法，为data为空做准备
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
