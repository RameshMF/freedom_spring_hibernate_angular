package com.viscount.freedom.dbconfig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectController {
	
	@RequestMapping(value = { "/view/template/{viewname}" }, method =RequestMethod.GET)
	public String redirectToPortalPage(@PathVariable("viewname") String viewname) {
		System.out.println("viewname  :"+ viewname);
		return viewname;
	}
}
