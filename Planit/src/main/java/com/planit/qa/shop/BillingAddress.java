package com.planit.qa.shop;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.planit.qa.base.TestBase;

public class BillingAddress extends TestBase {
	
	  public BillingAddress() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "billing_address_id")
	  WebElement address;
	  
	  @FindBy(id = "BillingNewAddress_CountryId")
	  WebElement country;
	  
	  @FindBy(id = "BillingNewAddress_City")
	  WebElement city;
	  
	  @FindBy(id = "BillingNewAddress_Address1")
	  WebElement address1;
	  
	  @FindBy(id = "BillingNewAddress_ZipPostalCode")
	  WebElement postalcode;
	  
	  @FindBy(id = "BillingNewAddress_PhoneNumber")
	  WebElement phonenumber;
	  
	  @FindBy(xpath = ("(//input[contains(@class,'new-address-next-step-button')])[1]"))
	  WebElement continueBtn;
	  
	  public ShippingAddress billing() throws IOException{
		  Select select = new Select(address);
		  select.selectByVisibleText("New Address");
		  Select select1 = new Select(country);
		  select1.selectByVisibleText("India");
		  city.sendKeys("Hyderabad");
		  address1.sendKeys("Nallagandla");
		  postalcode.sendKeys("500019");
		  phonenumber.sendKeys("9986383590");
		  continueBtn.click();
		  return new ShippingAddress();
	  }
}
