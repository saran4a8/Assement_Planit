package com.planit.qa.shop;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.planit.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(className = "email")
	WebElement username;
	
	@FindBy(className = "password")
	WebElement password;
	
	@FindBy(className = "login-button")
	WebElement loginbtn;
	
	
	public String loginPageTitle(){
		return driver.getTitle();
	}
	public ValidUserName username(String usr, String pwd) throws IOException{
		username.sendKeys(usr);
		password.sendKeys(pwd);
		loginbtn.click();
		return new ValidUserName();
	}
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	

}
