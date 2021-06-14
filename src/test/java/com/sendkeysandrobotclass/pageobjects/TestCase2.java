package com.sendkeysandrobotclass.pageobjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TestCase2 {
	
	WebDriver driver;
	JavascriptExecutor js;
	public TestCase2(WebDriver driver) {
		PageFactory.initElements(driver	, this);
		js = (JavascriptExecutor)driver;
		/*
		 *If we use statement ---JavascriptExecutor js = (JavascriptExecutor)driver;--- in uploadFile function below,directly
		 * we will get error js is null. To avoid this we need to use js here
		 */
	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='btn block resume-btn btn-orange mt20']")
	WebElement uploadResume;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"file-upload\"]")
	WebElement button;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"user-signup-actions\"]/div[1]/div[1]/div[2]/div/div/section/div/form/div[1]/div[1]/div/div/p[1]")
	WebElement uploadedFileName;
	
	public void clickUploadResume() {
		
		uploadResume.click();
		
	}
	
	public void uploadFile() {
		js.executeScript("arguments[0].click();",button);
	}
	
	public String getuploadedFileName() {
		return uploadedFileName.getText();
	}
	

}
