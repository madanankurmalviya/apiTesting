//*Header Test*
package com.employee.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;

public class TC03_get_Employee_details extends TestBase {
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		http = RestAssured.given();
		resp = http.request(Method.GET, "/employees");
	}

	@Test
	public void checkHeaders() {
		Headers h = resp.getHeaders();
		for (Header hh : h) {
			System.out.println("The header are :" + hh.getName() + "\t" + hh.getValue());
		}
	}

	@Test
	public void getResponseBody() 
	{
		String respBody = resp.getBody().asString();
		System.out.println("The resp body is :" + respBody.toString());
	}

}
