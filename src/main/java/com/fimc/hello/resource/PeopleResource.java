package com.fimc.hello.resource;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fimc.hello.http.HttpMessageResponse;
import com.fimc.hello.model.Person;

@Component
@Path("/people")
public class PeopleResource {

    List<Person> people = new ArrayList<>();
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person) throws ParseException {
        HttpMessageResponse httpMessageResponse = new HttpMessageResponse();
        DateFormatChecker dateFormatChecker = new DateFormatChecker();
        if (StringUtils.isEmpty(person.getFirstName()) || StringUtils.isEmpty(person.getLastName()) || StringUtils.isEmpty(person.getBirthDate())) {
            httpMessageResponse.setMessage("all fields required");
            return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(httpMessageResponse).build();
        }else if(dateFormatChecker.checkDateFormat(person.getBirthDate()).equals("invalid")){
            httpMessageResponse.setMessage("invalid date format");
            return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(httpMessageResponse).build();
        }
        else {
            people.add(person);
            httpMessageResponse.setMessage("Successfully Add Person");
            return Response.status(HttpServletResponse.SC_CREATED ).entity(httpMessageResponse).build();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPeople() throws ParseException {
        return Response.ok().entity(people).build();
    }
}
