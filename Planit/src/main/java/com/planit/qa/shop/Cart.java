package com.planit.qa.shop;

import java.io.IOException;

import org.checkerframework.checker.index.qual.IndexFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.planit.qa.base.TestBase;

public class Cart extends TestBase{
	public Cart() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/span[@class='product-price'])[1]")
	WebElement subTotal;
	
	@FindBy(name = "termsofservice")
	WebElement tnc;
	
	@FindBy(name = "checkout")
	WebElement checkoutBtn;
	
	public BillingAddress cart() throws IOException{
		System.out.println("product subtotal:"+subTotal);
		tnc.click();
		checkoutBtn.click();
		return new BillingAddress();
	}

}
