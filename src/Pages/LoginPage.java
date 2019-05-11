package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import utils.PropertyFileUtility;

public class LoginPage
{
	WebDriver driver;
	PropertyFileUtility pfu;
	
	public LoginPage(WebDriver driver) throws Exception 
	{
		this.driver = driver;
		pfu= new PropertyFileUtility("loginData.properties");
	
	}
	
	
	//get all elements
	public WebElement getUsernameElement()
	{
		return driver.findElement(By.xpath(pfu.getData("userName")));
		
		
	}
	public WebElement getPasswordElement()
	{
		return driver.findElement(By.xpath(pfu.getData("password")));
		
		
	}
	public WebElement buttonClick()
	{
		return driver.findElement(By.xpath(pfu.getData("button")));
	}
	public WebElement registerNewButton()
	{
		return driver.findElement(By.xpath(pfu.getData("registerNewPathString")));
	}
		
	public WebElement getHeading()
	{
		return driver.findElement(By.xpath(pfu.getData("heading")));
	}
	
	public WebElement getEmailError()
	{
		return driver.findElement(By.xpath(pfu.getData("emilError")));
	}
	public WebElement getPasswordError()
	{
		return driver.findElement(By.xpath(pfu.getData("passwordError")));
	}
	
	
	
	//set username to textbox
	
	public void setUserName(String struname)
	{
		WebElement uname=getUsernameElement();
		uname.sendKeys(struname);
		
		
	}
	
	public void setPassword(String strpassword)
	{
		WebElement uname=getPasswordElement();
		uname.sendKeys(strpassword);
		
		
	}
	public void onbuttnclick()
	{
		WebElement bttn=buttonClick();
		
		bttn.click();
		
	}
	public void onRegisterbuttnclick()
	{
		WebElement registerButtn=registerNewButton();
		
		registerButtn.click();
		
	}
	
	
	
	
	//for navigation
	public Dashbord loginWithCorrectCredential() throws Exception
	{
		setUserName("kiran@gmail.com");
		setPassword("123456");
		onbuttnclick();
		Dashbord db = new Dashbord(driver);
		return db;
			
	}
	public RegisterNewMember clickOnRegisterNewMember() throws Exception
	{
		onRegisterbuttnclick();
		RegisterNewMember newMember = new RegisterNewMember(driver);
		return newMember;
	
	}
	
	//validation
	public boolean isTitleMactch()
	{
		String title=	driver.getTitle();
		return title.equals("AdminLTE 2 | Log in");
						
	}
	
	public boolean isHeadingMatch()
	{
		WebElement heading=getHeading();
		String headingName=heading.getText();
		
		return headingName.equals("AdminLTE");
		
	}
	public boolean doesEmailErrorMatch(String errorExpectedMsg)
	{
		WebElement emailError=getEmailError();
		String actualEmailError=emailError.getText();
		System.out.println("actual email msg : "+actualEmailError);
		return actualEmailError.equals(errorExpectedMsg);
		
	}
	public boolean dosePasswordMatch(String expPasswordErrorMsg)
	{
		WebElement passError=getPasswordError();
		String actualPassError=passError.getText();
		System.out.println("actual pass msg : "+actualPassError);

		return actualPassError.equals(expPasswordErrorMsg);
		
	}
	
	


}
 