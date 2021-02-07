package com.caltech.jenkinsproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import orq.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@SpringBootTest
class JenkinsProjectApplicationTests {

	private static String Base_URL = "https://www.facebook.com";
	private WebDriver driver;

	@Before 
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.get(Base_URL);
	}

	@After
	public void after()
	{
		driver.quit();
	}

	@Test
	public void testCasePassed() 
	{
		Assert.assertTrue(driver.findElement(By.xpath("//form[@id='login_form']")).isDisplayed());
	}

	@Test
	public void testCaseFailed()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//form[@id='failed case']")).isDisplayed());
	}

	@Ignore
	@Test
	public void testCaseIgnored()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//form[@id='ignored case']")).isDisplayed());
	}
}
