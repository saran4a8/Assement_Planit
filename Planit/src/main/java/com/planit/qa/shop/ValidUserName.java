package com.planit.qa.shop;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.planit.qa.base.TestBase;

public class ValidUserName extends TestBase{

	@FindBy(xpath = "//div[@class='header-links']//a[@class='account']")
	WebElement username;
	
	@FindBy(xpath = "//span[text()='Shopping cart']")
	WebElement shoppingcart;
	
	public ValidUserName() throws IOException {
		PageFactory.initElements(driver, this);
	}
	public WebElement veriyUser()
	{
		return username;
	}
	public ShoppingCart shoppingCart() throws IOException{
		shoppingcart.click();
		return new ShoppingCart();
	}

}
