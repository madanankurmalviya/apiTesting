package com.testData;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GoogleMapTest 
{
	public Response resp;
	
	@BeforeMethod
	public void googleApiTest()
	{
		//Specify the URI
		RestAssured.baseURI="http://ergast.com/api";
		
		//Create the request Object
		
		RequestSpecification http=RestAssured.given();
		
		resp = http.request(Method.GET,"/f1");
	}
	
	@Test
	public void heardersTest()
	{
		Headers allHeaders = resp.headers();
		for(Header head:allHeaders)
		{
			System.out.println(head.getName()+"\t"+head.getValue());
		}
	}
	
	@Test
	public void responseBody()
	{
		String responseBody = resp.getBody().asString();
		System.out.println("The response body :"+responseBody);
		Assert.assertEquals(responseBody.contains("Country"), true);
	}
}
