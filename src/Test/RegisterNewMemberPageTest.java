
package Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.LoginPage;
import Pages.RegisterNewMember;
import utils.ExcelUtil;

public class RegisterNewMemberPageTest {
	WebDriver dr;
	RegisterNewMember rnm;
	LoginPage login;

	@BeforeClass
	public void setEnv() throws Exception {
		System.out.println("in RegisterNewMemberPageTest.setenv");
		System.setProperty("webdriver.gecko.driver", "E:\\Java\\software\\Java jar\\geckodriver\\geckodriver.exe");

		System.out.println("Geko driver set in system properties");
		FirefoxOptions foption = new FirefoxOptions();

		System.out.println("firefox options created");

		dr = new FirefoxDriver(foption);
		login = new LoginPage(dr);
		rnm = new RegisterNewMember(dr);

		System.out.println("login page created " + rnm);

		System.out.println("FireFox driver created");
		String filePathString = "file:///E:/Java/software/Offline%20Website/index.html";
		dr.get(filePathString);
	}

	@AfterMethod
	public void cleanData() {
		dr.navigate().refresh();
	}

	@Test (priority = 30)
	public void clickOnRegisterNewMember() throws Exception {
		System.out.println("RegisterNewMemberPageTest.clickOnRegisterNewMember");
		login.clickOnRegisterNewMember();

	}

	@Test(priority = 40, description = "Test Title")
	public void titleTestCase() {
		System.out.println("RegisterNewMemberPageTest.titleTestCase");
		Assert.assertTrue(rnm.doesRegisterPageTitleMatch());

	}

	@Test(priority = 50, description = "Test register page lable")
	public void labelTestCase() {

		System.out.println("RegisterNewMemberPageTest.labelTestCase");
		Assert.assertTrue(rnm.doesRegisterPageLabelMatch());

	}

	@Test(priority = 60, description = "Test register page heading")
	public void headingTestCase() {

		System.out.println("RegisterNewMemberPageTest.headingTestCase");
		Assert.assertTrue(rnm.doesRegisterPageHeadingMatch());

	}

	@DataProvider(name = "authentication")
	public static Object[][] credentialFromEcel() throws Exception {

		System.out.println("RegisterNewMemberPageTest.credentialFromEcel");

		ExcelUtil ee = new ExcelUtil("registerPageData.xls");
		int rows = ee.getTotalRows(0);
		System.out.println("rows" + rows);
		int column = ee.getTotalColumn(0);
		System.out.println("coumn " + column);
		Object[][] data = new Object[rows - 1][column];
		// System.out.println(data.length);

		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < column; j++) {
				data[i - 1][j] = ee.reder(j, i);
				// System.out.println(data[j][i]);
			}

		}
		return data;
	}

	@Test(priority = 70, dataProvider = "authentication")
	public void checkValidationErrorMassage(String name, String mobile, String email, String password, String nameErr,
			String mobErr, String emailErr, String passErr) {

		System.out.println("RegisterNewMemberPageTest.checkValidationErrorMassage");
		rnm.setName(name);
		rnm.setMobile(mobile);
		rnm.setEmail(email);
		rnm.setPassword(password);
		rnm.clickOnSignInButton();
		SoftAssert sa = new SoftAssert();

		sa.assertTrue(rnm.doesNameErrorMatch(nameErr));
		sa.assertTrue(rnm.doesMobileErrorMatch(mobErr));
		sa.assertTrue(rnm.doesEmailErrorMatch(emailErr));
		sa.assertTrue(rnm.doesPasswordErrorMatch(passErr));

		sa.assertAll();
	}

	@Test(priority = 80, description = "Test alredy registerd member link")
	public void testAlreadyRegisterdMemberLink() {

		System.out.println("RegisterNewMemberPageTest.testAlreadyRegisterdMemberLink");
		rnm.clickOnRegisteredMemberButton();
	}

	@Test(priority = 80, description = "Test pop up window massage")
	public void testPopUpMassage() throws Exception {

		System.out.println("RegisterNewMemberPageTest.testPopUpMassage");
		rnm.registerNewValidCredential();
		if (rnm.doesAlertExist()) {
			Assert.assertTrue(rnm.doesAlertMassgeMAtch());
			Thread.sleep(5000);
			rnm.acceptAlertMassage();
		} else
			Assert.assertTrue(false);

	}
	@AfterClass
	public void cleanEnv() {
		dr.close();

	}
}
