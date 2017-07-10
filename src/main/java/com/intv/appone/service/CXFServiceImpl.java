package com.intv.appone.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.intv.appone.vo.ServiceResponse;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/greet/")
@Api(value = "/greet", description = "Endpoint to greet")
@Produces({ MediaType.APPLICATION_JSON })
@Service
@RestController
public class CXFServiceImpl {
	
	@GET
	@Path("/greetings")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Greets everyone", response = ServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 406, message = "Exception from public greeting"),
			@ApiResponse(code = 200, message = "Sucess") })
	public ServiceResponse getPublicGreeting(){
			return new ServiceResponse("Hello World");
	}
	
	@GET
	@Path("/internal-greetings")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Greets only internal management", response = ServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 406, message = "Exception from management greeting"),
			@ApiResponse(code = 200, message = "Sucess") })
	public ServiceResponse getManagementMessage(){
			return new ServiceResponse("Hello World");
	}

}
