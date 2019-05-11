package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.PropertyFileUtility;

public class Dashbord
{
	
	WebDriver driver;
	PropertyFileUtility pfu;
	
	public Dashbord(WebDriver dr) throws Exception
	{
		this.driver=dr;
		pfu = new PropertyFileUtility("dashboard.properties");
	}

	//get all web elements
	
	public WebElement getDashbordUserElement()
	{
		return driver.findElement(By.xpath(pfu.getData("userName")));
	}
	
	public WebElement getDashbordHeading()
	{
		return driver.findElement(By.xpath(pfu.getData("dashbordHeading")));
	}
	
	public WebElement getDashbordDashbordButton()
	{
		return driver.findElement(By.xpath(pfu.getData("DashbordTab")));
	}
	public WebElement getDashbordUsersButton()
	{
		return driver.findElement(By.xpath(pfu.getData("Userstab")));
	}
	
	public WebElement getDashbordOperatorsButton()
	{
		return driver.findElement(By.xpath(pfu.getData("Operatorstab")));
	}
	
	public WebElement getDashbordLogoutButton()
	{
		return driver.findElement(By.xpath(pfu.getData("LogoutTab")));
	}
	
	public WebElement getDashbordLabel()
	{
		return driver.findElement(By.xpath(pfu.getData("dashbordLable")));
	}
	public WebElement getDashbordBluBoxHeading()
	{
		return driver.findElement(By.xpath(pfu.getData("dashbordSmallBlueBoxHeading")));
	}
	
	public WebElement getDashbordBluBoxName()
	{
		return driver.findElement(By.xpath(pfu.getData("dashbordSmallBlueBoxName")));
	}
	
	public WebElement getDashbordGreenBoxHeading()
	{
		return driver.findElement(By.xpath(pfu.getData("dashbordSmallGreenBoxHeading")));
	}
	
	public WebElement getDashbordGreenBoxName()
	{
		return driver.findElement(By.xpath(pfu.getData("dashbordSmallGreenBoxName")));
	}
	
	public WebElement getDashbordYellowBoxHeading()
	{
		return driver.findElement(By.xpath(pfu.getData("dashbordSmallYellowBoxHeading")));
	}
	
	public WebElement getDashbordYellowBoxName()
	{
		return driver.findElement(By.xpath(pfu.getData("dashbordSmallYellowBoxName")));
	}
	
	public WebElement getDashbordReadBoxHeading()
	{
		return driver.findElement(By.xpath(pfu.getData("dashbordSmallRedBoxHeading")));
	}
	
	public WebElement getDashbordRedBoxName()
	{
		return driver.findElement(By.xpath(pfu.getData("dashbordSmallRedBoxName")));
	}
	
	public WebElement getDashbordFooter()
	{
		return driver.findElement(By.xpath(pfu.getData("dashboardFooter")));
	}
	
	public WebElement getDashbordRightsideLogoutButton()
	{
		return driver.findElement(By.xpath(pfu.getData("DashbordRightsideLogOutButton")));
	}
	
	
	//set action to all webElements
	
	public void clickOnDashbordUsersButton()
	{
		getDashbordUsersButton().click();
		
	}
	public void clickOnDashbordOperatorsButton()
	{
		getDashbordOperatorsButton().click();
		
	}
	public void clickOnDashbordLogoutButton()
	{
		getDashbordLogoutButton().click();
		
	}
	public void clickOnDashbordRightSideLogoutButton()
	{
		getDashbordRightsideLogoutButton().click();
		
	}
	

	//validation
	
	static boolean compareString(String expected,String actual)
	{
		boolean result = expected.equals(actual);
		if(!result)
		{
			System.out.println("/*********************************/");
			System.out.println("below Strings are not equal ");
			System.out.println(expected);
			System.out.println(actual);
			System.out.println("/*********************************/");
		
		}

		return result;
		
	}
	public boolean doseDashbordTitleMactch()
	{
		String title=	driver.getTitle();
		return title.equals(pfu.getData("dashbordTitle"));
						
	}
	
	public boolean doseDashbordHeadingMatch()
	{
		String dashbordHeading=	getDashbordHeading().getText();
		return compareString(pfu.getData("dashbordheading"),dashbordHeading);
						
	}
	public boolean doseDashbordLabelNameMatch()
	{
		String dashbordLabel=	getDashbordLabel().getText();
		return dashbordLabel.equals(pfu.getData("dashbordLabelName"));
						
	}
	public boolean doseDashbordDashbordTabNameMatch()
	{
		String dashbordTabName=	getDashbordDashbordButton().getText();
		return dashbordTabName.equals("Dashboard");
						
	}
	
	public boolean doseDashbordUsersTabNameMatch()
	{
		String usersTabName=	getDashbordUsersButton().getText();
		return usersTabName.equals("Users");
						
	}
	
	public boolean doseDashbordFooterNameMatch()
	{
		String footerName=	getDashbordFooter().getText();
		System.out.println("footer is :"+footerName);
		return compareString("Version 2.3.0\nCopyright © 2014-2015 JBK. All rights reserved.", footerName);						
	}
	
	
	
	public boolean doseDashbordOperatorsTabNameMatch()
	{
		String operatorsTabName = getDashbordOperatorsButton().getText();
		return operatorsTabName.equals("Operators");
						
	}
	
	public boolean doseDashbordLogoutTabNameMatch()
	{
		String logoutTabName = getDashbordLogoutButton().getText();
		return logoutTabName.equals("Logout");
						
	}
	
	public boolean doseDashbordRightSideLogoutTabNameMatch()
	{
		String rightSidelogoutTabName = getDashbordRightsideLogoutButton().getText();
		return rightSidelogoutTabName.equals("LOGOUT");
						
	}
		
	public boolean doesNewOrderDataMatch()
	{
		String newOrderBoxHeading = getDashbordBluBoxHeading().getText();
		String newOrderBoxName = getDashbordBluBoxName().getText();
		if(newOrderBoxHeading.equals(pfu.getData("blueboxHeading"))&& newOrderBoxName.equals(pfu.getData("blueboxName")))
		{
			return true;
			
		}
		else
		{
			return false;
		}
							
	 }
	
	public boolean doesBounceRateBoxDataMatch()
	{
		String bounceRateBoxBoxHeading = getDashbordGreenBoxHeading().getText();
		String bounceRateBoxBoxName = getDashbordGreenBoxName().getText();
		if(bounceRateBoxBoxHeading.equals(pfu.getData("greenboxHeading"))&& bounceRateBoxBoxName.equals(pfu.getData("greenboxName")))
		{
			return true;
			
		}
		else
		{
			return false;
		}
							
	 }
	public boolean doesuserRegistrationsBoxDataMatch()
	{
		String userRegistrationsBoxBoxHeading = getDashbordYellowBoxHeading().getText();
		String userRegistrationsBoxBoxName = getDashbordYellowBoxName().getText();
		if(userRegistrationsBoxBoxHeading.equals(pfu.getData("yellowboxHeading"))&& userRegistrationsBoxBoxName.equals(pfu.getData("yellowboxName")))
		{
			return true;
			
		}
		else
		{
			return false;
		}
							
	 }
	public boolean doesUniqueVisitorsBoxDataMatch()
	{
		String uniqueVisitorsBoxBoxHeading = getDashbordReadBoxHeading().getText();
		String uniqueVisitorsBoxBoxName = getDashbordRedBoxName().getText();
		if(uniqueVisitorsBoxBoxHeading.equals(pfu.getData("redboxHeading"))&& uniqueVisitorsBoxBoxName.equals(pfu.getData("redboxName")))
		{
			return true;
			
		}
		else
		{
			return false;
		}
							
	 }
	
	//navigation
	
	public DashbordUsers clickOnUsersButton() throws Exception
	{
		clickOnDashbordUsersButton();
		DashbordUsers user = new DashbordUsers(driver);
		return user;
	}
	
	public DashbordOperators clickOperatorsButton() throws Exception
	{
		clickOnDashbordOperatorsButton();
		DashbordOperators operator = new DashbordOperators(driver);
		return operator;
	}
	
	public LoginPage clickOnLogoutButton() throws Exception
	{
		clickOnDashbordLogoutButton();
		LoginPage login = new LoginPage(driver);
		return login;
	}
	
	public LoginPage clickOnRightSideLogoutButton() throws Exception
	{
		clickOnDashbordRightSideLogoutButton();
		LoginPage login = new LoginPage(driver);
		return login;
	}
	
	
	

}
