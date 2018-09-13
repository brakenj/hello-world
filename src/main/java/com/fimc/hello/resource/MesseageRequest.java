package com.fimc.hello.resource;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class MesseageRequest implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3689898615090331616L;
    private String firstName;
    private String lastName;

}
