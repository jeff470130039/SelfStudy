package com.winson.csms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.winson.csms.model.RequestModel;
import com.winson.csms.model.Role;
import com.winson.csms.model.User;
import com.winson.csms.service.CSMSService;


@RestController
public class CSMSController {

	
	@Autowired
	private CSMSService service;
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		return service.getAllUser();
	}
	@PostMapping("/getRoleById")
	public @ResponseBody Role getRoleById(@RequestBody RequestModel requestModel){
		return service.getRoleById(requestModel.getId());
	}
}
