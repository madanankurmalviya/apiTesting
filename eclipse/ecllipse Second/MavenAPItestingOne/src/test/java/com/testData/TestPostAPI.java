package com.testData;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestPostAPI 
{
	public Response resp;
	public JsonPath path;
	public JSONObject reqParam;
	
	
	
	@Test
	public void setUp()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		//request object
		RequestSpecification http = RestAssured.given();
		
		//Request Payload Along with post request
		
		reqParam = new JSONObject();
		reqParam.put("FirstName", "Ankur");
		reqParam.put("LastName", "Malviya");
		http.header("Content-Type","application/json");
		http.body(reqParam.toJSONString());
		
		//Request object
		resp = http.request(Method.POST,"/register");
		
		String respBody=resp.getBody().asString();
		System.out.println("The response Body is: "+respBody);
		
		int respCode = resp.getStatusCode();
		System.out.println("The response code is : "+respCode);
		
	}
	
}
