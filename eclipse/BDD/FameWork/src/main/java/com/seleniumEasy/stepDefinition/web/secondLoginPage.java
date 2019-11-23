package com.seleniumEasy.stepDefinition.web;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class secondLoginPage {
	WebDriver driver;

	@Given("^enter to the URL for second page$")
	public void enertURL() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\ANKUR MALVIYA\\eclipse\\BDD\\BDDfirst\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com");
	}

	@Then("^click on DemoBtn for second$")
	public void clickIntoSecondPage() {
		driver.findElement(By.xpath("//a[text()='Demo Website!']")).click();
	}

	@Then("^user to click on StartPractising Btn$")
	public void clickStart() {
		WebElement btn=driver.findElement(By.xpath("//a[text()=' Start Practising ']"));
		System.out.println(btn.getAttribute("text"));
		btn.click();
		Assert.assertEquals(" Start Practising " ,btn.getAttribute("text") );
		
	}

	@When("^text is visible$")
	public void textVisible() {
		WebElement tex= driver.findElement(By.xpath("//span[text()='Basic']"));
		System.out.println("123: "+tex.getTagName());
//			Assert.assertEquals("basic", tex.getAttribute("text"));
	}

	@Then("^user click on Select Drop Down List$")
	public void selectDropDown() throws InterruptedException {
		List<WebElement> list = driver.findElements(By.xpath("(//div[@class='list-group'])[1]//a"));
		System.out.println(list.size());
		
		for(WebElement a : list)
		{
			String tex = a.getAttribute("text");
			System.out.println(tex);
			
			
			if(a.getAttribute("text").equalsIgnoreCase("Select Dropdown List"))
			{
				a.click();
				System.out.println("Now we enter into Select Dropdown List");
				
				break;
			}
			
			
		}
		
		Thread.sleep(5000);
	}

	@Then("^user click and select List Demo$")
	public void selectFirstListDemo() throws InterruptedException {
		WebElement selEle= driver.findElement(By.xpath("//select[@id='select-demo']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");
		Select sel = new Select(selEle);
		sel.selectByVisibleText("Wednesday");
		Thread.sleep(5000);
		
	}

	@When("^selected day is displayed$")
	public void verifyDisplayed() {
		WebElement t= driver.findElement(By.xpath("//p[@class='selected-value']"));
		String text = t.getAttribute("text");
		System.out.println("ankur :"+text);
//		Assert.assertEquals("Day selected :- Wednesday", text);
	}

	@Then("^click and select from MultiList$")
	public void selectMultiList() {
		Actions sel = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//option[text()='Ohio']"));
		sel.click(ele).build().perform();
		
	}

	@Then("^click first selected$")
	public void clickSelectedBtn() {
		driver.findElement(By.xpath("//button[text()='First Selected']")).click();
	}

	@When("^selected option is displayed$")
	public void verifySelectedDisplayed() {
		String txt = driver.findElement(By.xpath("//p[text()='First selected option is : Ohio']")).getAttribute("text");
	}

	@And("^close the browser$")
	public void closeBrowser() {
//		driver.quit();
	}

}
