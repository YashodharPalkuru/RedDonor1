package com.reddonor.controller;
 
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reddonor.entity.LoginBean;
import com.reddonor.services.RedDonorService;

@Controller
public class RestController{

	private RedDonorService redDonorService;
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//read inputs
		int drMobile = Integer.parseInt(request.getParameter("mobile"));
		String drEmail = request.getParameter("email");
		int drciId = Integer.parseInt(request.getParameter("city"));
		int drArId = Integer.parseInt(request.getParameter("area"));
		int drCoId = Integer.parseInt(request.getParameter("country"));
		int drBgId = Integer.parseInt(request.getParameter("bloodgroup"));
		int drPswd = Integer.parseInt(request.getParameter("password"));
		
		String drFirstName = request.getParameter("firstName");
		String drLastName = request.getParameter("lastname");
		Map map = new HashMap<String,String>();
		map.put("status", "200");
		// basic validations 
		try
		{
		    redDonorService.register(drMobile, drPswd,drEmail,drciId,drArId,drCoId,drBgId,drFirstName,drLastName);
		   
		// read all names from request
		}
		catch(Exception e)
		{
		map.put("status", "104");
		}
		// call register
		return new ModelAndView("jsonView", "model",map);
 
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginUser(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		//read inputs
		
	   int drMobile = Integer.parseInt(request.getParameter("mobile"));
	   String drPswd = request.getParameter("password");
	   Map map = new HashMap<String,String>();
	   try
	   {
		   LoginBean loginBean = redDonorService.login(drMobile, drPswd);
		if(loginBean.getStatus())
		{
		map.put("status", "200");
		map.put("session", loginBean.getCsrfToken());
		}
		else
		{
	        map.put("status", "404");
		}
	   }
	   catch(Exception e)
	   {
		   map.put("status", "400");
	   }
		
		
		
		// call register
		return new ModelAndView("jsonView", "model",map);
 
	}
	
	public RedDonorService getRedDonorService()
	{
		return redDonorService;
	}
	public void setRedDonorService(RedDonorService redDonorService)
	{
		this.redDonorService = redDonorService;
	}

	
}
