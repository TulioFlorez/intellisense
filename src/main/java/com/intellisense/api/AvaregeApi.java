package com.intellisense.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intellisense.dto.AssetDto;
import com.intellisense.dto.PeriodDto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface AvaregeApi {
	
	@ApiOperation(
			value = " set T ", 
		    notes = "Avarage Asset by T ",
		    response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "Not found"),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 400, message = "Bad Request")})
	@RequestMapping(method = RequestMethod.POST)
	public AssetDto  getAvarageAsset( @Valid @RequestBody PeriodDto beerDto, BindingResult result);

}
