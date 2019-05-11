package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeClass;

import Pages.DashbordUsers;
import Pages.LoginPage;

public class DashbordUsersPageTest
{
	WebDriver dr;
	DashbordUsers dbu;
	
	@BeforeClass
	public void setEnv() throws Exception
	{
		System.out.println("in setenv");
        System.setProperty("webdriver.gecko.driver", "E:\\Java\\software\\Java jar\\geckodriver\\geckodriver.exe");
        
        System.out.println("Geko driver set in system properties");
        FirefoxOptions foption = new FirefoxOptions();
        
        System.out.println("firefox options created");

		 dr = new FirefoxDriver(foption);

		 dbu  = new DashbordUsers(dr);
		 System.out.println("users page created "+dbu);
		 
		 System.out.println("FireFox driver created");
		 String filePathString = "file:///E:/Java/software/Offline%20Website/index.html";
		 dr.get(filePathString);
	}
	
	
	

}
