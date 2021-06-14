package com.sendkeysandrobotclass.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sendkeysandrobotclass.pageobjects.TestCase2;

import io.github.bonigarcia.wdm.WebDriverManager;

//TestCase: Upload file using Robot class(robot class is used to handle windows based application)
public class TC_2 {
	
	@Test
	public void TC2() throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.monsterindia.com/");
		
		TestCase2 tc2 = new TestCase2(driver);
		tc2.clickUploadResume();
		
		tc2.uploadFile();
		
		Robot robo = new Robot();
		robo.delay(2000);
		
		//copy file in clipboard
		StringSelection ss = new StringSelection("C:\\Users\\Atif_\\eclipse-workspace\\SendKeysAndRobotClass\\Sample\\sample.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);//ss is path of file in local computer
		
		//press CTRL+V
		robo.keyPress(KeyEvent.VK_CONTROL);//press CTRL key
		robo.keyPress(KeyEvent.VK_V);//press V key
		
		//release CTRL+V
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		
		//press Enter and release
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		//validation
		String expected = "sample.pdf"; //it should be present
		String actual = tc2.getuploadedFileName();
		if(expected.equals(actual)) {
			System.out.println("Expected file is uploaded");
		}else {
			System.out.println("Expected file is not uploaded");
			Assert.assertTrue(false);
			}
		
		
	}

}
