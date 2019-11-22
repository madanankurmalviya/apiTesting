package com.testData;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;


public class PractiseApiTestingAll
{
	@Test
	public void testAllApi()
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/todos";
		RequestSpecification http = RestAssured.given();
		Response resp = http.request(Method.GET,"/1");
		String jsonBody = resp.getBody().asString();
		System.out.println(jsonBody);
		String head = resp.getHeader("Content-Type");
		String ad =resp.getHeader("Cache-Control");
		System.out.println("The header is :"+ad +"\t"+resp.getHeader("Transfer-Encoding")+" \t "+resp.getHeader("Vary"));
		
		Headers hd = resp.headers();
		for(Header h:hd)
		{
			System.out.println(h.getName()+" \t "+h.getValue());
		}
	}
	
	
	
	
	
	@Test
	public void SecondTest()
	{
		//Declaration base setup
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		//Authentification
		
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		
		RestAssured.authentication=auth;
		
		//Input Credentials
		
		auth.setUserName("ToolsQA");
		auth.setPassword("TestPassword");
		
		//RestAssured http 
		RequestSpecification http=RestAssured.given();
		
		//Response
		Response resp=http.request(Method.GET,"/");
		
		//print Response 
		
		System.out.println("The response code is: "+resp.getStatusCode());
		
		//print Response Body
		
		String jsonBody = resp.getBody().asString();
		System.out.println(jsonBody);
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
