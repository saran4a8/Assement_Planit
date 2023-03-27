package com.planit.qa.shop;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.planit.qa.base.TestBase;

public class ShippingAddress extends TestBase{
	  
	  public ShippingAddress() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "shipping_address_id")
	  WebElement shippingaAddress;
	  
	  @FindBy(xpath = "(//input[contains(@class,'new-address-next-step-button')])[2]")
	  WebElement continueNext;
	  
	  @FindBy(id = "shippingoption_1")
	  WebElement nextAir;
	  
	  @FindBy(xpath = "//input[contains(@class,'button-1 shipping-method-next-step-button')]")
	  WebElement continueShppingMethod;
	  
	  @FindBy(id = "paymentmethod_0")
	  WebElement cod;
	  
	  @FindBy(xpath = "//input[contains(@class,'button-1 payment-method-next-step-button')]")
	  WebElement continuePayment;
	  
	  @FindBy(xpath = "//div[@class='section payment-info']//p")
	  WebElement codText;
	  
	  @FindBy(xpath = "//input[contains(@class,'button-1 payment-info-next-step-button')]")
	  WebElement paymentNext;
	  
	  public ConfirmPage shipping() throws IOException{
		  Select shipping = new Select(shippingaAddress);
		  shipping.selectByValue("2992790");
		  continueNext.click();
		  nextAir.click();
		  continueShppingMethod.click();
		  System.out.println("checking the cod is selected: "+cod.isSelected());
		  continuePayment.click();
		  System.out.println("cash on delivery: "+ codText.getText());
		  paymentNext.click();
		  return new ConfirmPage();
		  
	  }

}
