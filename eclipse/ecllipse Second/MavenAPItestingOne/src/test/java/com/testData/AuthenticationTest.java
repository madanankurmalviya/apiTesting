package com.testData;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthenticationTest
{
	public Response resp;
	@BeforeMethod
	public void setUp()
	{
		//Specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";

		//Basic Authentication
		
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		
		auth.setUserName("ToolsQA");
		auth.setPassword("TestPassword");
		
		RestAssured.authentication=auth;
		
		//Request Object
		RequestSpecification http=RestAssured.given();
		
		//Response Object
		resp = http.request(Method.GET,"/");
		
	}
	
	@Test
	public void respBodyTest()
	{
		String respBody = resp.getBody().asString();
		System.out.println(respBody);
	}
	
	@Test
	public void respCode()
	{
		int respCode=resp.getStatusCode();
		System.out.println("The status code : "+respCode);
		Assert.assertEquals(respCode, 200);
	}
	
	@Test
	public void headerParamsTest()
	{
		Headers head = resp.headers();
		for(Header h:head)
		{
			System.out.println(h.getName()+"\t"+h.getValue());
		}
	}
	
	@Test
	public void JsonPathParams()
	{
		JsonPath path = resp.jsonPath();
		System.out.println("The server: "+path.get("Fault"));
		System.out.println("The Date : "+path.get("FaultId"));
		System.out.println("The path :"+path.get("Fault"));
	}

}
