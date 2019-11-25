package com.employee.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_get_All_Employees extends TestBase
{
	@BeforeClass
	public void getAllEmployees()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		http=RestAssured.given();
		resp = http.request(Method.GET,"/employees");
	}

	@Test
	public void checkResponse()
	{
		int respStatusCode = resp.getStatusCode();
		System.out.println("The resp code is :"+respStatusCode);
	}
	
	@Test
	public void checkRespTime()
	{
		long respTime= resp.time();
		System.out.println("The resp time is :"+respTime);
		Assert.assertTrue(respTime >100);
	}
	
	@Test
	public void checkStatusLine()
	{
		String statusLine = resp.getStatusLine();
		System.out.println("The status line is : "+statusLine);
	}

}

