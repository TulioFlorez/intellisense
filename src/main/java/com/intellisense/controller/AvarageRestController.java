package com.intellisense.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intellisense.api.AvaregeApi;
import com.intellisense.dto.AssetDto;
import com.intellisense.dto.PeriodDto;
import com.intellisense.service.PeriodService;
import com.intellisense.service.exception.TestException;

@RestController
public class AvarageRestController implements AvaregeApi {

	@Autowired
	PeriodService periodServiceImpl;

	@Override
	public AssetDto getAvarageAsset(@Valid @RequestBody PeriodDto periodDto, BindingResult validation) {
		if (!validation.hasErrors()) {
			return periodServiceImpl.getAvarageAssetService(periodDto);
		}else {
			throw new TestException("Period from 0 to 180");
		}
		
	}

	

}
