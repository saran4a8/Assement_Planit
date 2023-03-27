package com.planit.qa.shop;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.planit.qa.base.TestBase;

public class SelectComputer extends TestBase{
	public SelectComputer() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Build your own cheap computer')]")
	WebElement selectComputer;
	
	@FindBy(xpath = "//div[@class='product-price']/span")
	WebElement productPrice;
	
	@FindBy(className = "qty-input")
	WebElement quantity;
	
	@FindBy(xpath = "//input[contains(@id,'add-to-cart-button')]")
	WebElement addToCart;
	
	@FindBy(className = "content")
	WebElement addedToCart;
	
	@FindBy(xpath = "//span[text()='Shopping cart']")
	WebElement shoppinCartLink;
	
	public void selectComputer(){
		selectComputer.click();
	}
	
	public void product() throws InterruptedException{
		String price=productPrice.getText();
		System.out.println("Each product price is: "+price);
		quantity.clear();
		quantity.sendKeys("2");
		addToCart.click();
		String addedMessage = addedToCart.getText();
		System.out.println("Product added to cart: "+addedMessage);
		Thread.sleep(5000);
		
	}
	
	public Cart cart() throws IOException{
		shoppinCartLink.click();
		return new Cart();
	}

}
