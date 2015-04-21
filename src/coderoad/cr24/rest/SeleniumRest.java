package coderoad.cr24.rest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import coderoad.cr24.main.ActionSelenium;
import coderoad.cr24.model.image.Image;
import coderoad.cr24.seleniumConnector.SeleniumConnector;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Path("/aegis")
@Api("/aegis")
public class SeleniumRest {

	
	@GET
    @Path("/service/{jsonString}")
    //@PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value="Description")
    public  Response createContact(@ApiParam(value = "jsonString",required = true)
                                   @PathParam("jsonString")String accessToken) {


        return Response.status(200).entity("HOLA MUNDO, POR QUE!!!!!!!!!!!").build();
    }
	
	
	@POST
	@Path("/services")
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
	public Response getMsg(String jsonString) throws InterruptedException, IOException {
 
 
		//ActionSelenium actionSelenium=new ActionSelenium(jsonString);
		//List<Image>listImage=actionSelenium.run();
		
		SeleniumConnector connector=new SeleniumConnector(jsonString);
		List<Image>listImage=connector.run();
		
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(listImage);
		System.out.println("*****************************");
		System.out.println("********** SALIDA **********");
		System.out.println("json:"+json);
		
		return Response.status(200).entity(json).build();
		//return Response.status(200).entity(listImage.toString()).build();
 
	}
	
}
