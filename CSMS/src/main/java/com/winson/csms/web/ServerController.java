package com.winson.csms.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServerController {
	@GetMapping("/serviceCheck")
	public String serviceCheck(){
		return "CSMS Server Is Running ! ! !";
	}

}
