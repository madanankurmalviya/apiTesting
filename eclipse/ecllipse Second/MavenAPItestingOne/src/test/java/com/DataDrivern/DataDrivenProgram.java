package com.DataDrivern;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class DataDrivenProgram
{
	@Test(priority=1)
	public void setUp()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification http = RestAssured.given();
		
		JSONObject requestParam = new JSONObject();
		requestParam.put("name","ankurankurankurmalviyaSDET12388");
		requestParam.put("salary","1011030000");
		requestParam.put("age","330");
		
			
		//add  a header stating the request body is a JSON
		http.header("Content-Type","application/json");
		http.body(requestParam.toJSONString());
		//Specified Response
				Response resp = http.request(Method.POST,"/create");
				
		//STATUS CODE
		int respCode=resp.getStatusCode();
		System.out.println("The post response code: "+respCode);
		
	}
	@Test
	public void checkTheData()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification http= RestAssured.given();
		Response resp = http.request(Method.GET,"/employees");
		int status = resp.getStatusCode();
		System.out.println("The Status Code of Employee is :"+status);
		String respBody = resp.getBody().asString();
		System.out.println("The resBody is :"+respBody);
		Assert.assertEquals(respBody.contains("ankurankurankurmalviyaSDET12388"), true);
		
		
	}
	
}
