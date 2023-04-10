package com.obsqura.scripts;

import com.obsqura.constants.Constants;
import com.obsqura.listeners.*;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.utilities.ExcelUtilities;
import com.obsqura.utilities.ExcelUtility;

@Listeners(TestNGListener.class)
public class LoginPageTest extends TestHelper {

	@Test(dataProvider = "validLogin", groups = { "sanity" })
	public void validLoginPageTest(String u, String p) throws IOException {
		LoginPage loginPage = new LoginPage(webDriver);
		// String userName = ExcelUtility.readStringData(1, 0);
		// String passWord = ExcelUtility.readIntegerData(1, 1);
		// System.out.println("Username n Password:" + userName + passWord);
		HomePage homepage = loginPage.login(u, p);
		// FSzSystem.out.println(user + pass);
		// HomePage homepage = loginPage.login(user, pass); // using data provider
		homepage.clickEndTour();
		System.out.println(homepage.isHomePageLoaded());
		HomePage homepage1 = new HomePage(webDriver);
		Assert.assertTrue(homepage.isHomePageLoaded());

		System.out.println("Valid Login ..Test Passed..." + "resVal:" + homepage.isHomePageLoaded());

	}

	// @Test(dataProvider = "invalidLogin", groups = { "smoke" })
	public void invalidLoginPageTest(String usrnme, String paswd) {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login(usrnme, paswd);
		// System.out.println("Invalid Login Credentials:" + u + "," + p);
		String errorMsg = loginPage.getErrorMessage();
		Assert.assertTrue(errorMsg.equals("These credentials do not match our records."));
		System.out.println("Invalid Login ..Test Passed..." + "resVal:"
				+ errorMsg.equals("These credentials do not match our records."));

	}

	@DataProvider(name = "invalidLogin")
	public Object[][] getinValidData() {
		Object[][] data = null;
		String path = Constants.excelPath;
		ExcelUtilities excelu = new ExcelUtilities(path);
		int totalrows;
		try {
			totalrows = excelu.getRowCount("Invalidusernameandpassword");
			int totalcols = excelu.getCellCount("Invalidusernameandpassword", 1);
			data = new String[totalrows][totalcols];
			for (int i = 1; i <= totalrows; i++) {
				for (int j = 0; j < totalcols; j++) {
					data[i - 1][j] = excelu.getCellData("Invalidusernameandpassword", i, j);
				}

			}

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}

	@DataProvider(name = "validLogin")
	public Object[][] getValidData() {
		Object[][] data = null;
		String path = Constants.excelPath;
		ExcelUtilities excelu = new ExcelUtilities(path);
		int totalrows;
		try {
			totalrows = excelu.getRowCount("ValidUsernameAndPassword");
			int totalcols = excelu.getCellCount("ValidUsernameAndPassword", 1);
			data = new String[totalrows][totalcols];
			for (int i = 1; i <= totalrows; i++) {
				for (int j = 0; j < totalcols; j++) {
					data[i - 1][j] = excelu.getCellData("ValidUsernameAndPassword", i, j);
				}

			}

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}

}
