package apiTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matcher.*;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ApiTestCase
{
	@Test
	public void testResponseCode()
	{
		Response res=get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		int num = res.getStatusCode();
		Assert.assertEquals(num, 200);
		System.out.println("The answer is : "+num);
	}
	
	@Test
	public void titleTest()
	{
		Response res = get("http://ergast.com/api/f1/drivers.json?callback=myParser");
		System.out.println(res.getHeader("X-Powered-By"));
		Assert.assertEquals(res.getHeader("X-Powered-By"), "PHP/5.3.3");
	}
	
	@Test
	public void titleTestCode()
	{
		String str = get("https://samples.openweathermap.org/data/2.5/history/city?lat=41.85&lon=-87.65&appid=b1b15e88fa797225412429c1c50c122a1").contentType();
		System.out.println("test 3 "+str);
	}
	@Test
	public void bookTest()
	{
		// BDD Framework : Given(). When(). Then(). assert();
		given().
		when().get("http://ergast.com/api/f1/drivers.json").
		then().assertThat().
				statusCode(200).and().headers("Content-Length", "5510	");
		System.out.println("done 123");
		
	}


	
}
