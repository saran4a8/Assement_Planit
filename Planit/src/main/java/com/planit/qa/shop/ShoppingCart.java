package com.planit.qa.shop;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.planit.qa.base.TestBase;

public class ShoppingCart extends TestBase{
	public ShoppingCart() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "removefromcart")
	WebElement removecart;
	
	@FindBy(name = "updatecart")
	WebElement updatecartBtn;
	
	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(text(),'Computers')]")
	WebElement computer;
	
	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(text(),'Desktops')]")
	WebElement desktop;
	
	public void removeCart() throws InterruptedException{
		System.out.println(updatecartBtn.isDisplayed());
		Thread.sleep(3000);
		if(removecart.isDisplayed()){
			removecart.click();
			updatecartBtn.click();
		}
		else{
			System.out.println("your cart is empty");
		}
	}
	public SelectComputer computer() throws IOException{
		Actions action = new Actions(driver);
		action.moveToElement(computer).build().perform();
		desktop.click();
		return new SelectComputer();
	}

}
