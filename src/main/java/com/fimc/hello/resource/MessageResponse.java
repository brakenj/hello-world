package com.fimc.hello.resource;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 7466121592580620204L;
    private String message;

}
