package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.PropertyFileUtility;

public class RegisterNewMember {
	WebDriver driver;
	PropertyFileUtility pfu;
	

	public RegisterNewMember(WebDriver dr) throws Exception {
		this.driver = dr;
		pfu = new PropertyFileUtility("registerPageData.properties");
		
	}

	// get all elements
	public WebElement getRegisterPageUserNameElement() {
		return driver.findElement(By.xpath(pfu.getData("registerName")));
	}

	public WebElement getRegisterPageUserMobileElement() {
		return driver.findElement(By.xpath(pfu.getData("registerMobile")));
	}

	public WebElement getRegisterPageUserEmailElement() {
		return driver.findElement(By.xpath(pfu.getData("registerEmail")));
	}

	public WebElement getRegisterPageUserPasswordElement() {
		return driver.findElement(By.xpath(pfu.getData("registerPassword")));
	}

	public WebElement getRegisterPageHeading() {
		return driver.findElement(By.xpath(pfu.getData("registerPageHeading")));
	}

	public WebElement getRegisterSignInButton() {
		return driver.findElement(By.xpath(pfu.getData("registerSignButton")));
	}

	public WebElement getRegisteredMemberButton() {
		return driver.findElement(By.xpath(pfu.getData("registerPageButtonLink")));
	}

	public WebElement getRegisterPageLable() {
		return driver.findElement(By.xpath(pfu.getData("registerPageLable")));
	}

	public WebElement getRegisterPageNameErrorMasage() {
		return driver.findElement(By.xpath(pfu.getData("namErrorMassage")));
	}

	public WebElement getRegisterPageMobileErrorMasage() {
		return driver.findElement(By.xpath(pfu.getData("mobileErrorMassage")));
	}

	public WebElement getRegisterPageEmailErrorMasage() {
		return driver.findElement(By.xpath(pfu.getData("emailErrorMassage")));
	}

	public WebElement getRegisterPagePasswordErrorMasage() {
		return driver.findElement(By.xpath(pfu.getData("passwordErrorMassage")));
	}
	
	

	// perform operations on txtbox

	public void setName(String uName) {
		WebElement userName = getRegisterPageUserNameElement();
		userName.sendKeys(uName);

	}

	public void setMobile(String uMobile) {
		WebElement userMobile = getRegisterPageUserMobileElement();
		userMobile.sendKeys(uMobile);

	}

	public void setEmail(String uEmail) {
		WebElement userEmail = getRegisterPageUserEmailElement();
		userEmail.sendKeys(uEmail);

	}

	public void setPassword(String uPassword) {
		WebElement userPassword = getRegisterPageUserPasswordElement();
		userPassword.sendKeys(uPassword);

	}

	public void clickOnSignInButton() {
		getRegisterSignInButton().click();
	}

	public void clickOnRegisteredMemberButton() {
		getRegisteredMemberButton().click();
	}
	
	public void acceptAlertMassage() {
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
	}

	/// validation

	public boolean doesRegisterPageHeadingMatch() {
		WebElement registerPageHeading = getRegisterPageHeading();
		String heading = registerPageHeading.getText();
		return heading.equals(pfu.getData("heading"));

	}

	public boolean doesRegisterPageLabelMatch() {
		WebElement registerPageLabel = getRegisterPageLable();
		String label = registerPageLabel.getText();
		System.out.println("label is " + label);
		return label.equals("AdminLTE");

	}

	public boolean doesRegisterPageTitleMatch() {
		String title = driver.getTitle();
		return title.equals(pfu.getData("registerPageTitle"));

	}

	static boolean compareStrings(String expected, String actual) {

		boolean result = expected.equals(actual);

		if (!result) {
			System.out.println("/*********************************/");
			System.out.println("below Strings are not equal ");
			System.out.println(expected);
			System.out.println(actual);
			System.out.println("/*********************************/");
		}
		return result;
	}

	public boolean doesNameErrorMatch(String errorExpectedMsg) {
		System.out.println("in doesNameErrorMatch and expected error is ::" + errorExpectedMsg);
		WebElement nameError = getRegisterPageNameErrorMasage();
		String actualNameError = nameError.getText();
		// System.out.println("actual name msg : "+actualNameError);
		return compareStrings(errorExpectedMsg, actualNameError);

	}

	public boolean doesMobileErrorMatch(String errorExpectedMsg) {

		System.out.println("in doesMobileErrorMatch and expected error is ::" + errorExpectedMsg);
		WebElement mobileError = getRegisterPageMobileErrorMasage();
		String actualMobileError = mobileError.getText();
		// System.out.println("actual mobile msg : "+actualMobileError);
		return compareStrings(errorExpectedMsg, actualMobileError);

	}

	public boolean doesEmailErrorMatch(String errorExpectedMsg) {
		System.out.println("in doesEmailErrorMatch  and expected error is ::" + errorExpectedMsg);
		WebElement emailError = getRegisterPageEmailErrorMasage();
		String actualEmailError = emailError.getText();
		// System.out.println("actual email msg : "+actualEmailError);
		return compareStrings(errorExpectedMsg, actualEmailError);

	}

	public boolean doesPasswordErrorMatch(String errorExpectedMsg) {
		System.out.println("in doesPasswordErrorMatch  and expected error is ::" + errorExpectedMsg);
		WebElement passwordError = getRegisterPagePasswordErrorMasage();
		String actualPasswordError = passwordError.getText();
		// System.out.println("actual password msg : "+actualPasswordError);
		return compareStrings(errorExpectedMsg, actualPasswordError);

	}
	public boolean doesAlertMassgeMAtch()
	{
		String alertMassage = driver.switchTo().alert().getText();
		System.out.println(alertMassage);
		return compareStrings("User registered successfully.", alertMassage);
		
	}

	// navigation

	public LoginPage onAlreadyRegisterdMemberButtonClick() throws Exception {
		clickOnRegisteredMemberButton();
		LoginPage login = new LoginPage(driver);
		return login;
	}

	// pop up window varification and acceptance
	public void registerNewValidCredential() {
		setName("hansa");
		setMobile("7028916390");
		setEmail("hansashimpi@gmail.com");
		setPassword("12345678");
		clickOnSignInButton();
		
	}
	
	public boolean doesAlertExist()
	{
		return driver.switchTo().alert()!=null;
	}

}
