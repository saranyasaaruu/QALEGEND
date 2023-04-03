package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ProfilePage;
import com.obsqura.pages.TaxPage;
import com.obsqura.utilities.RandomUtility;
import com.obsqura.utilities.WaitUtility;

public class TaxPageTest extends TestHelper {
	String tax = "Tax" + RandomUtility.randomTextGen();

	// @Test(priority = 1)
	public void verifyTaxCanBeAdd() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		TaxPage taxpage = new TaxPage(webDriver);
		boolean val = taxpage.addTax(tax);
		Assert.assertEquals(true, val);
		System.out.println("Tax Added and Test Passed !!!");

	}

	// @Test(priority = 2)
	public void verifytaxCanSearchInSearchBox() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		TaxPage taxpage = new TaxPage(webDriver);
		taxpage.searchTax(tax);
		boolean val = taxpage.isTaxPresent(tax);
		Assert.assertTrue(val);
	}

	// @Test(priority = 3)
	public void verifyTaxCanBeDelete() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		TaxPage taxpage = new TaxPage(webDriver);
		Assert.assertTrue(taxpage.deleteTax(tax));
		System.out.println("Tax Deleted Successfully and Test Passed !!!");
	}

}
