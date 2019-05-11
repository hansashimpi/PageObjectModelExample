package Pages;

import org.openqa.selenium.WebDriver;
import utils.*;

public class DashbordOperators
{
	WebDriver driver;
	PropertyFileUtility pfu;
	
	public DashbordOperators(WebDriver driver) throws Exception 
	{
		this.driver=driver;
		pfu = new PropertyFileUtility("operators.properties");
		
	}

}
