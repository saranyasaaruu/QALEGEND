package com.obsqura.scripts;

import com.obsqura.listeners.*;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.utilities.ExcelUtility;

@Listeners(TestNGListener.class)
public class LoginPageTest extends TestHelper {
	@DataProvider(name = "login")
	public Object[][] dpMethodlogin() {
		return new Object[][] { { "admin" }, { "123456" } };
	}

	//@Test
	public void validLoginPageTest() throws IOException {
		LoginPage loginPage = new LoginPage(webDriver);
		// String userName = ExcelUtility.readStringData(1, 0);
		// String passWord = ExcelUtility.readIntegerData(1, 1);
		// System.out.println("Username n Password:" + userName + passWord);
		HomePage homepage = loginPage.login("admin", "123456");
		// FSzSystem.out.println(user + pass);
		// HomePage homepage = loginPage.login(user, pass); // using data provider
		homepage.clickEndTour();
		System.out.println(homepage.isHomePageLoaded());
		// HomePage homepage = new HomePage(webDriver);
		Assert.assertTrue(homepage.isHomePageLoaded());

		System.out.println("Valid Login ..Test Passed..." + "resVal:" + homepage.isHomePageLoaded());

	}

	// @Test(dataProvider = "invalidlogin")
	public void invalidLoginPageTest(String u, String p) {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login(u, p);
		String errorMsg = loginPage.getErrorMessage();
		Assert.assertTrue(errorMsg.equals("These credentials do not match our records."));
		System.out.println("Invalid Login ..Test Passed..." + "resVal:"
				+ errorMsg.equals("These credentials do not match our records."));

	}

	@DataProvider(name = "invalidlogin")
	public Object[][] dpMethodreg() {
		return new Object[][] { { "Saranya", "saranya@123" } };
	}

}
