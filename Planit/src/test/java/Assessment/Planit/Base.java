package Assessment.Planit;

import org.testng.annotations.Test;

import dev.failsafe.Timeout;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import javax.sound.midi.Synthesizer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;

public class Base {
	static WebDriver driver;
	String name = "planittest78@gmail.com";
	String password = "123456";
  @Test(priority = 0)
  public void title() {
	  String title = driver.getTitle();
	  System.out.println("Title of the Page: "+ title);
  }
  @Test(priority = 1)
  public void login() throws InterruptedException {
	  driver.findElement(By.cssSelector(".ico-login")).click();
	  System.out.println(driver.getTitle());
	  driver.findElement(By.cssSelector(".email")).sendKeys(name);
	  driver.findElement(By.cssSelector(".password")).sendKeys(password);
	  Thread.sleep(5000);
	  driver.findElement(By.className("login-button")).click();
	  Thread.sleep(5000);
  }
  @Test(priority = 2)
  public void validUsername() {
	  WebElement element = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
	  String userName = element.getText();
	  System.out.println(name.equals(userName));
  }
  @Test(priority = 3)
  public void shoppingCart()
  {
	  driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();;
	  WebElement removeCart = driver.findElement(By.name("removefromcart"));
	  if(removeCart.isDisplayed())
	  {
		  removeCart.click();
		  driver.findElement(By.name("updatecart")).click();
	  }
	  else{
		  System.out.println("your cart is empty");
	  }
  }
  @Test(priority = 4)
  public void desktopAction() throws InterruptedException{
	  Actions action = new Actions(driver);
	  WebElement computer = driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'computers')]"));
	  action.moveToElement(computer).build().perform();
	  driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Desktops')]")).click();
	  Thread.sleep(3000);
	  
  }
  @Test(priority = 5)
  public void selectComputer() throws InterruptedException{
	  driver.findElement(By.xpath("//a[contains(text(),'Build your own cheap computer')]")).click();
	  WebElement element = driver.findElement(By.xpath("//div[@class='product-price']/span"));
	  String price = element.getText();
	  System.out.println("price of the product:"+price);
	  WebElement quantity = driver.findElement(By.cssSelector(".qty-input"));
	  quantity.clear();
	  quantity.sendKeys("2");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[contains(@id,'add-to-cart-button')]")).click();;
	  String successMessage = "The product has been added to your shopping cart";
	  WebElement element1 = driver.findElement(By.className("content"));
	  String message = element1.getText();
	  System.out.println("successully added to cart message: "+message.equals(successMessage));
	  Thread.sleep(5000);
  }
  @Test(priority = 6)
  public void cart() throws InterruptedException{
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  WebElement cart = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
	  js.executeScript("arguments[0].scrollIntoView();",cart);
	  Thread.sleep(5000);
	  cart.click();
	  WebElement sb = driver.findElement(By.xpath("(//span[@class='product-price'])[1]"));
	  String subTotal = sb.getText();
	  System.out.println("Sub Total: "+subTotal);
	  driver.findElement(By.name("termsofservice")).click();
	  driver.findElement(By.name("checkout")).click();
	  Thread.sleep(3000);
  }
  @Test(priority = 7)
  public void billingAddress(){
	  WebElement address = driver.findElement(By.name("billing_address_id"));
	  Select select = new Select(address);
	  select.selectByVisibleText("New Address");
	  WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
	  Select select1 = new Select(country);
	  select1.selectByVisibleText("India");
	  driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Hyderabad");
	  driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Nallagandla");
	  driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("500019");
	  driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("9986383590");
	  driver.findElement(By.xpath("(//input[contains(@class,'new-address-next-step-button')])[1]")).click();
	  
  }
  @Test(priority = 8)
  public void shippingAddress(){
	  WebElement shippingAddress = driver.findElement(By.name("shipping_address_id"));
	  Select select = new Select(shippingAddress);
	  select.selectByValue("2992790");
	  driver.findElement(By.xpath("(//input[contains(@class,'new-address-next-step-button')])[2]")).click();
	  driver.findElement(By.id("shippingoption_1"));
	  driver.findElement(By.xpath("//input[contains(@class,'button-1 shipping-method-next-step-button')]")).click();
	  WebElement cod = driver.findElement(By.id("paymentmethod_0"));
	  System.out.println("checking the cod is selected: "+cod.isSelected());
	  driver.findElement(By.xpath("//input[contains(@class,'button-1 payment-method-next-step-button')]")).click();
	  WebElement pay = driver.findElement(By.xpath("//div[@class='section payment-info']//p"));
	  System.out.println("cash on delivery: "+ pay.getText());
	  driver.findElement(By.xpath("//input[contains(@class,'button-1 payment-info-next-step-button')]")).click();
	  
  }
  @Test(priority = 9)
  public void confirm(){
	  driver.findElement(By.xpath("//input[contains(@class,'button-1 confirm-order-next-step-button')]")).click();
	  WebElement orderSuccess = driver.findElement(By.xpath("//div[@class='title']//strong"));
	  String orderSuccessMesage = "Your order has been successfully processed!";
	  System.out.println("checking success message: "+orderSuccess.equals(orderSuccessMesage));
	  WebElement oderNumber = driver.findElement(By.xpath("//li[contains(text(),'Order number')]"));
	  driver.findElement(By.cssSelector(".ico-logout")).click();
	  System.out.println("Title of the page: "+driver.getTitle());
  }
  @BeforeSuite
  public void setUp() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--remote-allow-origins=*");
	  driver = new ChromeDriver(options);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().getPageLoadTimeout();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get("http://demowebshop.tricentis.com/");
	  Thread.sleep(5000);
	  
  }

  @AfterSuite
  public void tearDown() {
	  driver.quit();
  }

}
