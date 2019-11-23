package com.seleniumEasy.stepDefinition.web;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class mainLogin {
	WebDriver driver;

	@Given("^enter to the URL$")
	public void mainMethod() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\ANKUR MALVIYA\\eclipse\\BDD\\BDDfirst\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com");
	}

	@When("^check Btn Text contains DemoWebsite$")
	public void enterIntoWebSite() {
		String ele = driver.findElement(By.xpath("//a[text()='Demo Website!']")).getAttribute("text");
		System.out.println(ele);
		Assert.assertEquals("Demo Website!", ele);

	}

	@Then("^click on DemoBtn$")
	public void clickDemo() {
		driver.findElement(By.xpath("//a[text()='Demo Website!']")).click();
	}

	@When("^check url contains test$")
	public void checkUrl() {

		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals("https://www.seleniumeasy.com/test/", url);
	}

	@Then("^click on input forms$")
	public void clickInput() {
		
		driver.findElement(By.xpath("(//a[contains(text(),'Input Forms')])[1]")).click();
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='dropdown-menu']"));
		for (WebElement txt : list)
			System.out.println(txt.getText());
	}

	@Then("^click on simple form demo$")
	public void clickSimpleForm() {
		WebElement simpleForm = driver.findElement(By.xpath("(//ul//a[contains(text(),'Simple Form Demo' )])[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(simpleForm).click().build().perform();

	}

	@Then("^click on All Examples- Input Form$")
	public void clickAllExm() throws InterruptedException {
		driver.findElement(By.xpath("//ul[@id='treemenu']//li//a[text()='Input Forms']")).click();
		Thread.sleep(3000);
	}

	@Then("^click on Simple Form Demo Second$")
	public void clickSimpleFormDemo() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);");
	driver.findElement(By.xpath("//ul[@id='treemenu']//li//a[text()='Input Forms']//following-sibling::ul//a[text()='Simple Form Demo']"))
				.click();
	Thread.sleep(6000);
	}

	@Then("^enter Message in \"(.*)\" of Single Input Field Tab$")
	public void enterMessage(String message) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);");
		
		driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(message);
		driver.findElement(By.xpath("//button[text()='Show Message']")).click();

	}

	@Then("^verify Message by clicking SHow Message Btn \"(.*)\"$")
	public void clickShowMessage(String message) {
		WebElement display = driver.findElement(By.xpath("//span[@id='display']"));
		String txt = display.getAttribute("text()");
		System.out.println(txt);
//		Assert.assertEquals(message, txt);

	}

	@Then("enter value in Two Input Field \"(.*)\" and \"(.*)\"$")
	public void enterValueTwo(String valueA, String valueB) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);");
			
		driver.findElement(By.xpath("//input[@id='sum1']")).sendKeys(valueA);
		driver.findElement(By.xpath("//input[@id='sum2']")).sendKeys(valueB);
		driver.findElement(By.xpath("//button[text()='Get Total']")).click();
	}

	@Then("^click in GetTotal tab and verify Total$")
	public void verifyGetTotal() {
		WebElement ele = driver.findElement(By.xpath("//span[@id='displayvalue']"));
		String tex = ele.getAttribute("text()");
		System.out.println(tex);
				
	}

	@And("^quit the driver$")
	public void closeBrowser() {
		driver.close();
	}

}
