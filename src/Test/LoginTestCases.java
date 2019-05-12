package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPage;
import utils.ExcelUtil;

public class LoginTestCases {
	WebDriver dr = null;
	LoginPage login = null;

	@BeforeClass
	public void setEnv() throws Exception {
		System.out.println("in LoginTestCases.setenv");
		System.setProperty("webdriver.gecko.driver", "E:\\Java\\software\\Java jar\\geckodriver\\geckodriver.exe");

		System.out.println("Geko driver set in system properties");
		FirefoxOptions foption = new FirefoxOptions();

		System.out.println("firefox options created");

		dr = new FirefoxDriver(foption);

		login = new LoginPage(dr);
		System.out.println("login page created " + login);

		System.out.println("FireFox driver created");
		String filePathString = "file:///E:/Java/software/Offline%20Website/index.html";
		dr.get(filePathString);
	}

	@AfterMethod
	public void cleanData() {
		dr.navigate().refresh();
	}

	@Test(priority = 0, description = "Tittle Check Test")
	public void titleTestCase() {
		System.out.println("in LoginTestCases.titleTestCase");
		Assert.assertTrue(login.isTitleMactch());

	}

	@Test(priority = 10, description = "Heading check test")
	public void headingTestCase() {
		System.out.println("in LoginTestCases.headingTestCase");
		Assert.assertTrue(login.isHeadingMatch());

	}

	@DataProvider(name = "Authentication2")

	public static Object[][] credentialFromEcel() throws Exception {
		System.out.println("in LoginTestCases.credentialFromEcel");

		ExcelUtil ee = new ExcelUtil("loginData.xls");
		int rows = ee.getTotalRows(0);
		int column = ee.getTotalColumn(0);
		Object[][] data = new Object[rows - 1][column - 2];
		// System.out.println(data.length);

		for (int j = 1; j < rows; j++) {
			for (int i = 2; i < column; i++) {
				data[j - 1][i - 2] = ee.reder(i, j);
				// System.out.println(data[j][i]);
			}
		}
		return data;
	}

	@Test(priority = 20, dataProvider = "Authentication2")
	public void checkErrorMassage(String uname, String spassword, String emaiErrorMsg, String passErrorMsg) {

		System.out.println("in LoginTestCases.checkErrorMassage");
		login.setUserName(uname);
		login.setPassword(spassword);
		login.onbuttnclick();
		Assert.assertTrue(login.doesEmailErrorMatch(emaiErrorMsg));
		Assert.assertTrue(login.dosePasswordMatch(passErrorMsg));

	}

	// @Test(priority =3 , description = "checking successful login credential")
	public void loginsuccess() throws Exception {
		System.out.println("in LoginTestCases.checkErrorMassage");
		login.loginWithCorrectCredential();
		Assert.assertTrue(true);
	}

	@AfterClass
	public void cleanEnv() {
		dr.close();

	}
}
