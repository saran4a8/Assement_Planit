package com.planit.qa.base;

import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.stream.FileImageInputStream;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
 public TestBase() throws IOException{
	try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:/Users/saran/Planit/Planit/src/main/java/com/planit/qa/config/config.properties");
		prop.load(ip);
		
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
 }
 public static void iniliazation() {
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--remote-allow-origins=*");
	  driver = new ChromeDriver(options);
	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().getPageLoadTimeout();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get(prop.getProperty("url"));
//	 String username = prop.getProperty("usrname");
//	 String password = prop.getProperty("password");
 }
}
