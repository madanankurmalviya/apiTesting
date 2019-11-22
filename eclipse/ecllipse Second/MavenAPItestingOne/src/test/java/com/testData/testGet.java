package com.testData;

import org.junit.Assert;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class testGet 
{
	public Response resp;
	public JsonPath path;
	
	@BeforeMethod
	public void setUp()
	{
		        //Specify URI
				RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city"; 
				
				//Request Object
				RequestSpecification httReq = RestAssured.given();
				
			    resp = httReq.request(Method.GET,"/Bhilai");
			    
			    path=resp.jsonPath();
	}
	
	@Test
	public void getParameters()
	{
		System.out.println("The humidty parameter is : "+ path.get("Humidity"));
		System.out.println("The wind speed is : "+path.get("WindSpeed"));
		System.out.println("The Wind Direction parameter is : "+ path.get("WindDirectionDegree"));
		System.out.println("The City is : "+path.get("City"));
	}
	
	
	@Test
	public void getWeatherTest()
	{
		//Print response Body
		String responseBody = resp.getBody().asString();
		
		System.out.println(responseBody);
	}
	
	
	@Test(priority=1)
	public void responseTest()
	{
		
		//response status
		int responseStatus = resp.getStatusCode();
		
		System.out.println("The status code is :"+responseStatus);
		Assert.assertEquals(responseStatus, 200);
	}
	
	@Test
	public void headerTest()
	{
		String header = resp.header("Date");
		System.out.println("The header Postman-Token is :"+header);
		
	}
	
	@Test
	public void statusLineTest()
	{
		String line = resp.getStatusLine();
		System.out.println("The status line :"+line);
	}
	
	@Test
	public void statusLengthTest()
	{
		String length = resp.header("Content-Length");
		System.out.println("The content length :"+length);
	}
	
	@Test
	public void statusTime()
	{
		long time =  resp.time();
		System.out.println("The time :"+time);
	}
	
	
	@AfterMethod
	public void tearOut()
	{
		System.out.println("******Here the program End*******");
		
	}
}
