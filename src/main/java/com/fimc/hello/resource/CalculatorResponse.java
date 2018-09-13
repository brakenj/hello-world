package com.fimc.hello.resource;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculatorResponse implements Serializable {

    public double calculate(CalculatorRequest calculatorRequest) {
        double answer = 0;
        if (calculatorRequest.getOperator().equals("+")) {
            answer = calculatorRequest.getFirstNumber() + calculatorRequest.getSecondNumber();
        } else if (calculatorRequest.getOperator().equals("-")) {
            answer = calculatorRequest.getFirstNumber() - calculatorRequest.getSecondNumber();
        } else if (calculatorRequest.getOperator().equals("*")) {
            answer = calculatorRequest.getFirstNumber() * calculatorRequest.getSecondNumber();
        } else if (calculatorRequest.getOperator().equals("/")) {
            answer = calculatorRequest.getFirstNumber() / calculatorRequest.getSecondNumber();
        }
        return answer;
    }

    public String getOperator(String operator) {
        String result = "";
        switch (operator) {
            case "+":
                result = "addition";
                break;
            case "-":
                result = "subraction";
                break;
            case "*":
                result = "multiplication";
                break;
            case "/":
                result = "division";
                break;
            default:
                result = "invalid";
                break;
        }
        return result;
    }

}
