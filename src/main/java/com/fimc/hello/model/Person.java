package com.fimc.hello.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date birthDate;
}
