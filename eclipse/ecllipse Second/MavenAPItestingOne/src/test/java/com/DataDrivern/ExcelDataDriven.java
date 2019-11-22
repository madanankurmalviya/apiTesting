package com.DataDrivern;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class ExcelDataDriven

{
	
	@Test(dataProvider="empdataprovider")
	public void setUp(String NAME,String SALARY , String AGE)
	{
	  RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	  
	  RequestSpecification http=RestAssured.given();
	  
	  Response resp = http.request(Method.PUT,"/create");
	  
	  JSONObject jsonParam = new JSONObject();
	  
	  jsonParam.put("name", NAME);
	  jsonParam.put("salary", SALARY);
	  jsonParam.put("age",AGE);
	  
	  http.header("Content-Type","application/json");
	  
	  http.body(jsonParam.toJSONString());
  
	  String respBody =resp.getBody().asString();
	  System.out.println("The resp is :"+respBody);

	}
	
	@DataProvider(name="empdataprovider")
	public String[][] dataProvider() throws IOException
	{
		String path="emp.xlsx";
		
		int rowNum=XLUtils.getRowCount(path, "Sheet1");
		int colCount=XLUtils.getCellCount(path, "Sheet1", 1);
		String empData[][]=new String[rowNum][colCount];
		for(int a=1;a<=rowNum;a++)
		{
			for(int b=1;b<=colCount;b++)
			{
				empData[a-1][b]=XLUtils.getCellData(path,"Sheet1",a,b);
			}
		}
//		String empData[][]= { {"Ankur11","100000","20"},{"Ankur21","100001","21"},{"Ankur31","100003","23"},{"Ankur41","100004","24"},{"Ankur51","100005","25"}  };
		return (empData);
	}
	
	
	
}