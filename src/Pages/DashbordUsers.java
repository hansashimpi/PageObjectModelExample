package Pages;

import org.openqa.selenium.WebDriver;
import utils.*;

public class DashbordUsers 
{
	WebDriver driver;
	PropertyFileUtility pfu;
	
	public DashbordUsers(WebDriver driver) throws Exception 
	{
		this.driver = driver;
		pfu =  new PropertyFileUtility("users.properties");

	}
	
	

}
