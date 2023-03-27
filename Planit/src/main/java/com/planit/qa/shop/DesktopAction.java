package com.planit.qa.shop;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.planit.qa.base.TestBase;

public class DesktopAction extends TestBase{
	public DesktopAction() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(text(),'Desktops')]")
	WebElement desktop;
	
	public SelectComputer desktop() throws IOException{
		desktop.click();
		return new SelectComputer();
	}
	

}
