package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.BarcodePage;
import com.obsqura.pages.CommisionPage;
import com.obsqura.pages.CustomerGroup;
import com.obsqura.pages.CustomerPage;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.ImportPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.UserManagePage;
import com.obsqura.utilities.GenericUtility;
import com.obsqura.utilities.RandomUtility;
import com.obsqura.utilities.WaitUtility;

public class BarcodePageTest extends TestHelper {

	String barcode = "Barcode" + RandomUtility.randomNumberGeneration();

	// @Test(priority = 1, groups = { "sanity" })
	public void verifyBarcodeCanAdd() throws InterruptedException {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		BarcodePage bp = new BarcodePage(webDriver);
		bp.settingsTextClick();
		bp.barcodeSettingsTextClick();
		bp.addBarcodeClick();
		bp.addBarcode(barcode);
		Assert.assertTrue(bp.isToastMessageLoaded().equals("Barcode setting added successfully"));
		System.out.println("Barcode Added and Test Passed !!!");
	}

	// @Test(priority = 2, groups = { "sanity" })
	public void verifyBarcodeCanSetToDefault() throws InterruptedException {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		BarcodePage bp = new BarcodePage(webDriver);
		bp.settingsTextClick();
		bp.barcodeSettingsTextClick();
		BarcodePage barcodeobj = bp.setDetaultBarCode(barcode);
		Assert.assertTrue(bp.isToastMessageLoaded().equals("Default set successfully"));
		System.out.println("Barcode Set as Default and Test Passed !!!");
	}

	// @Test(priority = 3, groups = { "smoke" })
	public void verifyBarcodeCanDelete() throws InterruptedException {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		BarcodePage bp = new BarcodePage(webDriver);
		bp.settingsTextClick();
		bp.barcodeSettingsTextClick();
		BarcodePage barcodeobj = bp.deleteBarcode(barcode);
		Assert.assertTrue(bp.isToastMessageLoaded().equals("Barcode setting deleted successfully"));
		System.out.println("Barcode Deleted and Test Passed !!!");
	}

}
