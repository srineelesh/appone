package com.intv.appone.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intv.appone.vo.ServiceResponse;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
public class ServiceImpl {
	
	@RequestMapping(value="/greetings",method=RequestMethod.GET)
	@ApiOperation(value = "Greets everyone", response = ServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 406, message = "Exception from public greeting"),
			@ApiResponse(code = 200, message = "Sucess") })
	public @ResponseBody ServiceResponse getMessage(){
			return new ServiceResponse("Hello World");
	}
	
	@RequestMapping(value="/internal-greetings",method=RequestMethod.GET)
	@ApiOperation(value = "Greets only internal management", response = ServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 406, message = "Exception from management greeting"),
			@ApiResponse(code = 200, message = "Sucess") })
	public @ResponseBody ServiceResponse getManagementMessage(){
			return new ServiceResponse("Hello Management");
	}

}
