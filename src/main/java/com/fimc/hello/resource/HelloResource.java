package com.fimc.hello.resource;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fimc.hello.http.HttpMessageResponse;

@Component
@Path("/message")
public class HelloResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello(MesseageRequest request) {
        HttpMessageResponse httpMessageResponse = new HttpMessageResponse();
        if (StringUtils.isEmpty(request.getFirstName()) || StringUtils.isEmpty(request.getLastName())) {
            httpMessageResponse.setMessage("parameter cannot be empty!");
            return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(httpMessageResponse).build();
        } else {
            httpMessageResponse.setMessage(String.format("Hello %s %s", request.getFirstName(), request.getLastName()));
            return Response.ok().entity(httpMessageResponse).build();
        }

    }
}
