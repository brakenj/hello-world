package com.fimc.hello.http;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpMessageResponse implements Serializable {
    private String message;

}
