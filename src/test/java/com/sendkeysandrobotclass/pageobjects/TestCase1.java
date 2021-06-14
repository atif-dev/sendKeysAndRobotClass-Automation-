package com.sendkeysandrobotclass.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TestCase1 {

	WebDriver driver;
	public TestCase1(WebDriver driver) {
		PageFactory.initElements(driver	, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='btn block resume-btn btn-orange mt20']")
	WebElement uploadResume;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"file-upload\"]")
	WebElement uploadFile;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"user-signup-actions\"]/div[1]/div[1]/div[2]/div/div/section/div/form/div[1]/div[1]/div/div/p[1]")
	WebElement uploadedFileName;
	
	
	public void clickUploadResume() {
		
		uploadResume.click();
		
	}
	
	public void uploadFile() {
		
		uploadFile.sendKeys(System.getProperty("user.dir")+ "//Sample//sample.pdf");
		/*
		 * sendKeys take path of file.It doesn't handle windows base application.
		 * windows based application is handled in TC_2 using Robot class
		 */
	}
	
	public String getuploadedFileName() {
		return uploadedFileName.getText();
	}
	
}
