package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.Dashbord;
import Pages.LoginPage;

public class DashbordPageTest 
{
	WebDriver dr;
	Dashbord db = null;
	LoginPage login;
	
	@BeforeClass
	public void setEnv() throws Exception
	{
		System.out.println("in setenv");
        System.setProperty("webdriver.gecko.driver", "E:\\Java\\software\\Java jar\\geckodriver\\geckodriver.exe");
        
        System.out.println("Geko driver set in system properties");
        FirefoxOptions foption = new FirefoxOptions();
        
        System.out.println("firefox options created");

		 dr = new FirefoxDriver(foption);

		 db= new Dashbord(dr);
		 System.out.println("dashbord page created "+db);
		 login = new LoginPage(dr);
		 
		 System.out.println("FireFox driver created");
		 String filePathString = "file:///E:/Java/software/Offline%20Website/index.html";
		 dr.get(filePathString);
	}
//	@AfterMethod
//	public void cleanData()
//	{
//		dr.navigate().refresh();
//	}
	
	@Test(priority=90,description = "Login with correct credential")
	public void testLoginPageSignInButton() throws Exception
	{
		login.loginWithCorrectCredential();
				
	}
	
	@Test(priority=100,description = "Test Dashbord page Title")
	public void testDashbordPageTitle()
	{
		Assert.assertTrue(db.doseDashbordTitleMactch());
		
	}
	
	@Test(priority=110,description = "Test Dashbord page Heading")
	public void testDashbordPageHeading()
	{
		Assert.assertTrue(db.doseDashbordHeadingMatch());
		
	}
	
	@Test(priority=120,description = "Test Dashbord page label")
	public void testDashbordPageLabel()
	{
		Assert.assertTrue(db.doseDashbordLabelNameMatch());
		
	}
	
	@Test(priority=140,description = "Test Dashbord page DashbordTab name")
	public void testDashbordPageDashbordTab()
	{
		Assert.assertTrue(db.doseDashbordDashbordTabNameMatch());
		
	}
	
	@Test(priority=150,description = "Test Dashbord page UsersTab name")
	public void testDashbordPageUsersTab()
	{
		Assert.assertTrue(db.doseDashbordUsersTabNameMatch());
		
	}
	
	@Test(priority=160,description = "Test Dashbord page OperatorsTab name")
	public void testDashbordPageOperatorsTab()
	{
		Assert.assertTrue(db.doseDashbordOperatorsTabNameMatch());
		
	}
	
	@Test(priority=170,description = "Test Dashbord page LogoutTab name")
	public void testDashbordPageLogoutTab()
	{
		Assert.assertTrue(db.doseDashbordLogoutTabNameMatch());
		
	}
	
	@Test(priority=180,description = "Test Dashbord page Right side LogoutTab name")
	public void testDashbordPageRightSidLogoutTab()
	{
		Assert.assertTrue(db.doseDashbordRightSideLogoutTabNameMatch());
		
	}
	
	@Test(priority=190,description = "Test Dashbord page New User Box Data")
	public void testDashbordPageNewUserBoxData()
	{
		Assert.assertTrue(db.doesNewOrderDataMatch());
		
	}
	
	@Test(priority=200,description = "Test Dashbord page Bounce Rate Box Data")
	public void testDashbordPageBounceRateBoxData()
	{
		Assert.assertTrue(db.doesBounceRateBoxDataMatch());
		
	}
	
	@Test(priority=210,description = "Test Dashbord page User Registrations Box Data")
	public void testDashbordPageUserRegistrationsBoxData()
	{
		Assert.assertTrue(db.doesuserRegistrationsBoxDataMatch());
		
	}
	
	@Test(priority=220,description = "Test Dashbord page Unique Visitors Box Data")
	public void testDashbordPageUniqueVisitorsBoxData()
	{
		Assert.assertTrue(db.doesUniqueVisitorsBoxDataMatch());
		
	}
	
	@Test(priority=230,description = "Test Dashbord page Footer")
	public void testDashbordPageFooter()
	{
		Assert.assertTrue(db.doseDashbordFooterNameMatch());
		
	}
	@Test(priority=240,description="Test Dahbord UsersButton")
	public void clickOnUsersButton()
	{
		db.clickOnDashbordUsersButton();
	}
	@Test(priority=250,description="Test Dahbord LogoutButton")
	public void clicklLogoutButton()
	{
		db.clickOnDashbordLogoutButton();
	}
	
	
	
	
	@AfterClass
	public void cleanEnv() {
		dr.close();

	}
	
	
	
	
	
	
	

}
