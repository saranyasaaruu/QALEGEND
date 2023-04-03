package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.utilities.WaitUtility;

public class HomePageTest extends TestHelper {

	// @Test
	public void verifyTwoNumbersCanAddUsingCalculatorShowingOnHomePage() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		homepage.calculatorButtonCLicked();
		Assert.assertEquals(true, homepage.iscalculatorWorking());
		System.out.println("Calculator working and test passed !!!");
	}

	// @Test
	public void VerifyDateOnHomePageAndCurrentDateAreSame() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		boolean val = homepage.verifyTodaysDate();
		Assert.assertTrue(val);
		System.out.println("Both dates are same and test passed !!!");

	}
}
