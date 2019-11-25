package com.employee.base;

import io.restassured.specification.RequestSpecification;

import java.util.logging.Logger;

import org.apache.logging.log4j.Level;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;

public class TestBase 
{
	public static RequestSpecification http;
	public static Response resp;
	//public static empName="";
	public Logger log;
	
	
//	@BeforeClass
//	public void setUp()
//	{
//		log=Logger.getLogger("EmpDetails");
//		PropertyConfigurator.configure("Log4j.properties");
//		log.setLevel(Level.DEBUG);
//	}
	

}
