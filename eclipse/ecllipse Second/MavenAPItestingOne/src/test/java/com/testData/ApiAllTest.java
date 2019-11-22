package com.testData;

import org.testng.annotations.BeforeMethod;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ApiAllTest 
{
	public Response resp;
	static int a=1;
	
	@BeforeMethod
	public void setUp()
	{
		//Specify Setup
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";

		// Authentication  
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		
		//Input Credentials
		RestAssured.authentication=auth;
		auth.setUserName("ToolsQA");
		auth.setPassword("TestPassword");
		
		
		//Request Object
		RequestSpecification http = RestAssured.given();
		
		//Response Object
		 resp= http.request(Method.GET,"/");
			//		int b=a+1;
			//		 System.out.println("**************"+"Start of Program : "+b+"*****************");
	}

	
//	@Test
//	public void testStatusCode()
//	
//	{
//		int respStatusCode = resp.getStatusCode();
//		System.out.println("The status code is :"+respStatusCode);
//		Assert.assertEquals(respStatusCode, 200);
//	}
//	
//	@Test
//	public void testStausLine()
//	{
//		String statusLine = resp.getStatusLine();
//		System.out.println("The status line is :"+statusLine);
//	}
//	
//	@Test
//	public void jsonPathStatus()
//	{
//		JsonPath path = resp.jsonPath();
//		System.out.println("The FaultId param  :"+path.get("FaultId"));
//		System.out.println("The Fault param  :"+path.get("Fault"));
//		
//		
//	}
//	
//	@Test
//	public void headersTest()
//	{
//		Headers head=resp.headers();
//		for(Header h :head)
//		{
//			System.out.println(h.getName()+"\t"+h.getValue());
//		}
//	}
//	
//	@Test
//	public void headerTest()
//	{
//		String head = resp.header("Content-Type");
//		System.out.println("The content type is :"+head);
//	}
//	
//	@Test
//	public void jsonBodyTest()
//	{
//		JSONObject jb = new JSONObject();
//		
//	}
	
	@Test
	public void jsonBody()
	{
		String jbody = resp.getBody().asString();
		System.out.println("The answer is: "+jbody);
	}
	
	@AfterMethod
	public void tearDown()
	
	{
		a+=1;
		System.out.println("--------------"+"End of program :"+a+"------------------");
	}
}
