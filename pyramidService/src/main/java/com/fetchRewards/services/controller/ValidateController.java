package com.fetchRewards.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fetchRewards.services.service.ValidateService;

@RestController
@RequestMapping("/pyramid")
public class ValidateController {

	@Autowired
	private ValidateService validateService;
	
	// 1. http://localhost:8080/pyramid/validatePyramidString/banana  -> return true
	// 2. http://localhost:8080/pyramid/validatePyramidString/bandana  -> return false
	
	@RequestMapping(value = "/validatePyramidString/{input}" , method = RequestMethod.GET)
	public boolean checkPyramidString(@PathVariable("input") String input) {
		return validateService.validatePyramidString(input);
	}
}
