package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.PrinterPage;
import com.obsqura.utilities.RandomUtility;
import com.obsqura.utilities.WaitUtility;

public class PrinterPageTest extends TestHelper {
	String printer = "Printer" + RandomUtility.randomNumberGeneration();

//	@Test
	public void verifyPrinterCanBeAdd() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		PrinterPage pg = new PrinterPage(webDriver);
		pg.settingsClick();
		pg.printersClick();
		pg.addPrinterClick();
		Assert.assertTrue(pg.addPrinter(printer));
		System.out.println("Printer Added Successfully and Test Passed !!!");
	}

	// @Test
	public void verifyPrinterCanDelete() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		PrinterPage pg = new PrinterPage(webDriver);
		pg.settingsClick();
		pg.printersClick();
		Assert.assertTrue(pg.deletePrinter(printer));
		System.out.println("Printer Deleted Successfully and Test Passed !!!");
	}

	// @Test
	public void verifyPrinterCanSearchInSearchBox() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		PrinterPage pg = new PrinterPage(webDriver);
		pg.settingsClick();
		pg.printersClick();
		WaitUtility.sleeps(3000);
		pg.searchPrinter(printer);
		boolean val = pg.isPrinterPresent(printer);
		Assert.assertTrue(val);
		System.out.println("Printer Not Found and Test Failed!!!");
	}

}
