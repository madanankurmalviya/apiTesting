package com.employee.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;
import com.employee.utilities.randDataGenRestUtils;

import io.restassured.http.Method;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;

public class TC02_post_Employee_details  extends TestBase
{
	String empName=randDataGenRestUtils.empName();
	String empSalary=randDataGenRestUtils.empSalary();
	String empAge=randDataGenRestUtils.empAge();
	@BeforeClass
	public void postEmpSetup()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		http=RestAssured.given();
		resp=http.request(Method.POST,"/create");
	
		JSONObject reqParams=new JSONObject();
		reqParams.put("name", empName);
		reqParams.put("salary", empSalary);
		reqParams.put("age", empAge);
		
		http.header("Content-Type","application/json");
		http.body(reqParams.toJSONString());
	}
	@Test
	public void checkStatus()
	{
		System.out.println(resp.getStatusCode());
	}
	
//	@Test
//	public void checkRespBody()
//	{
//		String respBody= resp.getBody().asString();
//		System.out.println("The resp body is: "+respBody);
//		Assert.assertEquals("respBody",true);
//	}
	@Test
	public void printEmpdetails()
	{
		System.out.println("The emp details are : "+empName+"\t"+empAge+"\t"+empSalary);
	}
}
