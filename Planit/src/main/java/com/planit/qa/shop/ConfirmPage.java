package com.planit.qa.shop;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.planit.qa.base.TestBase;

public class ConfirmPage extends TestBase{
	
	  public ConfirmPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[contains(@class,'button-1 confirm-order-next-step-button')]")
	  WebElement confirm;
	  
	  @FindBy(xpath = "/div[@class='title']//strong")
	  WebElement orderSuccess;
	  
	  @FindBy(xpath = "//li[contains(text(),'Order number')]")
	  WebElement orderNumber;
	  
	  @FindBy(className = "ico-logout")
	  WebElement logout;
	  
	  public void confirmAndLogout(){
		  confirm.click();
		  System.out.println("Order suucess Message: "+orderSuccess);
		  System.out.println("Order Number: "+orderNumber);
		  logout.click();
		  System.out.println("Title of Logout Page: "+driver.getTitle());
	  }

}
