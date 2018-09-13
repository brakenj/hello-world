package com.fimc.hello.resource;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculatorRequest {

    private String operator;

    private double firstNumber;

    private double secondNumber;
}
