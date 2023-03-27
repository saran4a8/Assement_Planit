package com.planit.qa.shop;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.planit.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(className ="ico-login")
	WebElement login;
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	public String homePageValidate(){
		return driver.getTitle();
		
	}
	
	public LoginPage login() throws IOException{
		login.click();
		return new LoginPage();
	}

}
