package com.sendkeysandrobotclass.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sendkeysandrobotclass.pageobjects.TestCase1;

import io.github.bonigarcia.wdm.WebDriverManager;

//TestCase: Upload file using sendKeys
public class TC_1 {

	@Test
	public void TC1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.monsterindia.com/");
		
		TestCase1 tc1 = new TestCase1(driver);
		tc1.clickUploadResume();
		tc1.uploadFile();
		
		//validation
		String expected = "sample.pdf"; //it should be present
		String actual = tc1.getuploadedFileName();
		if(expected.equals(actual)) {
			System.out.println("Expected file is uploaded");
		}else {
			System.out.println("Expected file is not uploaded");
			Assert.assertTrue(false);
		}
		
		
	}
	
}
