package com.intv.appone.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intv.appone.vo.ServiceResponse;
import com.wordnik.swagger.annotations.Api;

/*@Path("/service/")
@Api(value = "/deltaservice", description = "Endpoint to write mars delta information and read Delta information")
@Produces({ MediaType.APPLICATION_JSON })
@Service*/
@RestController
public class ServiceImpl {
	
	@RequestMapping(value="/greetings")
	public ServiceResponse getMessage(){
			return new ServiceResponse("Hello World");
	}
	
	@RequestMapping(value="/internal-greetings")
	public ServiceResponse getManagementMessage(){
			return new ServiceResponse("Hello World");
	}

}
