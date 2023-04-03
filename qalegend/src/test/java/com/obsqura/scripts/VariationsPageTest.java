package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.CommisionPage;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.VariationsPage;
import com.obsqura.utilities.RandomUtility;
import com.obsqura.utilities.WaitUtility;

public class VariationsPageTest extends TestHelper {
	String variations = "Var" + RandomUtility.randomNumberGeneration();

	@Test
	public void verifyVariationsCanAdd() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		VariationsPage vp = new VariationsPage(webDriver);
		VariationsPage vp1 = vp.addVariations(variations);
		Assert.assertTrue(vp.isToastMessageLoaded().equals("Variation added succesfully"));
		System.out.println("Variations added and Test Passed !!!");
	}

	// @Test
	public void verifyVariationsCanBeExportedtoCSVFile() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour(); // commented for checking retry test
		VariationsPage vp = new VariationsPage(webDriver);
		vp.exporttoCSVclick();
		boolean val = vp.fileDownloads("csv");
		Assert.assertEquals(val, true);
		System.out.println("CSV file Exported and Test Passed!!!");

	}

	// @Test
	public void verifyVariationsCanBeExportedtoExcelFile() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		VariationsPage vp = new VariationsPage(webDriver);
		vp.exporttoExcelclick();
		boolean val = vp.fileDownloads("xlsx");
		Assert.assertEquals(val, true);
		System.out.println("Excel file Exported and Test Passed!!!");

	}

	// @Test
	public void verifyVariationsCanBeExportedtoPDFFile() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		VariationsPage vp = new VariationsPage(webDriver);
		vp.exporttoPDFclick();
		boolean val = vp.fileDownloads("pdf");
		Assert.assertEquals(val, true);
		System.out.println("PDF file Exported and Test Passed!!!");

	}

}
