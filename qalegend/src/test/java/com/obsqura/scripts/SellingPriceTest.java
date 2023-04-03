package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.CommisionPage;
import com.obsqura.pages.CustomerGroup;
import com.obsqura.pages.CustomerPage;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.SellingPricePage;
import com.obsqura.pages.UserManagePage;
import com.obsqura.utilities.GenericUtility;
import com.obsqura.utilities.RandomUtility;
import com.obsqura.utilities.WaitUtility;

public class SellingPriceTest extends TestHelper {

	String name = "SellingGroup" + RandomUtility.randomNumberGeneration();
	String desc = "New" + name;

	// @Test(priority = 1)
	public void verifyNewSellingGroupCanAdd() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		SellingPricePage sp = new SellingPricePage(webDriver);
		sp.productsTextClick();
		sp.sellingPriceGroupTextClick();
		sp.addTextClick();
		Assert.assertTrue(sp.addSellingGroup(name, desc));
		System.out.println("Customer Group Added and test passed !!!");
	}

	// @Test
	public void verifySellingGroupCanBeExportedtoCSVFile() throws InterruptedException {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		SellingPricePage sp = new SellingPricePage(webDriver);
		sp.productsTextClick();
		sp.sellingPriceGroupTextClick();
		sp.actionButtonClick();
		sp.exporttoCSVclick();
		boolean val = sp.fileDownloads("csv");
		Assert.assertEquals(val, true);
		System.out.println("CSV file Exported and Test Passed!!!");

	}

	// @Test(priority=3)
	public void verifySellingGroupCanDelete() throws InterruptedException {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		SellingPricePage sp = new SellingPricePage(webDriver);
		sp.productsTextClick();
		sp.sellingPriceGroupTextClick();
		sp.addTextClick();
		Assert.assertTrue(sp.deleteSellingGroup(name, desc));
		System.out.println("Selling Group Deleted Successfully and Test Passed !!!");
	}

	//@Test(priority = 2)
	public void verifySellingGroupCanEdit() throws InterruptedException {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		SellingPricePage sp = new SellingPricePage(webDriver);
		sp.productsTextClick();
		sp.sellingPriceGroupTextClick();
		sp.addTextClick();
		sp.addSellingGroup(name, desc);
		Thread.sleep(5000);
		Assert.assertTrue(sp.editSellingGroup(name, desc));
		System.out.println("Selling Group Edited Successfully and Test Passed !!!");
	}

}
