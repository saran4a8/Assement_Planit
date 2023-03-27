package Assessment.Planit;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.planit.qa.base.TestBase;
import com.planit.qa.shop.BillingAddress;
import com.planit.qa.shop.Cart;
import com.planit.qa.shop.ConfirmPage;
import com.planit.qa.shop.DesktopAction;
import com.planit.qa.shop.HomePage;
import com.planit.qa.shop.LoginPage;
import com.planit.qa.shop.SelectComputer;
import com.planit.qa.shop.ShippingAddress;
import com.planit.qa.shop.ShoppingCart;
import com.planit.qa.shop.ValidUserName;

public class HomePageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	ValidUserName validusername;
	ShoppingCart shoppingcart;
	DesktopAction desktop;
	SelectComputer selectcomputer;
	Cart cart;
	BillingAddress billingaddress;
	ShippingAddress shipping;
	ConfirmPage confirm;

	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeSuite
	public void setUp() throws IOException{
		iniliazation();
		homepage = new HomePage();
//		loginpage = new LoginPage();
	}
	@AfterSuite
	public void tearDown(){
		driver.close();
	}
	@Test(priority=0)
	public void homePageTitleTest() {
		String title=homepage.homePageValidate();
		System.out.println("Title of the page: "+title);
	}
	@Test(priority=1)
	public void loginBtn() throws IOException{
		loginpage=homepage.login();
	}  
	@Test(priority=2)
	public void loginPageTitle(){
		String loginTitle = loginpage.loginPageTitle();
		System.out.println("Title of the Login Page: "+loginTitle);
	}
	@Test(priority=3)
	public void enterCredentials() throws IOException{
		validusername=loginpage.username(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	@Test(priority=4)
	public void verifyUser() throws IOException{
		WebElement user = validusername.veriyUser();
		String profile = user.getText();
		System.out.println("proile: "+profile);
		Assert.assertEquals(profile, prop.getProperty("username"));
		shoppingcart = validusername.shoppingCart();
	}
	@Test(priority=5)
	public void removeCart() throws InterruptedException{
		shoppingcart.removeCart();
	}
	@Test(priority=6)
	public void computer() throws IOException{
		selectcomputer = shoppingcart.computer();
	}
	@Test(priority=7)
	public void selectComputer(){
		selectcomputer.selectComputer();
	}
	@Test(priority=8)
	public void product() throws InterruptedException
	{
		selectcomputer.product();	
	}
	@Test(priority=9)
	public void selectCart() throws IOException{
		cart = selectcomputer.cart();
	}
	@Test(priority=10)
	public void continueCart() throws IOException{
		billingaddress = cart.cart();
	}
	@Test(priority=11)
	public void billing() throws IOException{
		shipping = billingaddress.billing();
	}
	
	@Test(priority=12)
	public void shipping() throws IOException{
		confirm = shipping.shipping();
	}
	@Test(priority=13)
	public void confirm(){
		confirm.confirmAndLogout();
	}
}
