package com.fimc.hello.resource;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.fimc.hello.http.HttpMessageResponse;
import com.fimc.hello.model.CalcSuccessResponse;

@Component
@Path("/calculator")
public class CalculatorResource {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculator(CalculatorRequest calculatorRequest) {
        HttpMessageResponse httpMessageResponse = new HttpMessageResponse();
        CalculatorResponse calculatorResponse = new CalculatorResponse();
        CalcSuccessResponse calcSuccessResponse = new CalcSuccessResponse();
        if (calculatorResponse.getOperator(calculatorRequest.getOperator()).equals("invalid")) {
            httpMessageResponse.setMessage("invalid operator (sign)");
            return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(httpMessageResponse).build();
        }
        else {
            DecimalFormat df = new DecimalFormat("#.#####");
            calcSuccessResponse.setAction(calculatorResponse.getOperator(calculatorRequest.getOperator()));
            calcSuccessResponse.setResult(df.format(calculatorResponse.calculate(calculatorRequest)));
            return Response.ok().entity(calcSuccessResponse).build();
        }
    }

}
