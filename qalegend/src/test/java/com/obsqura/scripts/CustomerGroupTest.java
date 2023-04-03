package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.CommisionPage;
import com.obsqura.pages.CustomerGroup;
import com.obsqura.pages.CustomerPage;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.UserManagePage;
import com.obsqura.utilities.GenericUtility;
import com.obsqura.utilities.RandomUtility;
import com.obsqura.utilities.WaitUtility;

public class CustomerGroupTest extends TestHelper {

	String name = "CustomerGroup" + RandomUtility.randomNumberGeneration();

	// @Test(priority = 1)
	public void verifyANewCustomerGroupCanAdd() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		CustomerGroup cg = new CustomerGroup(webDriver);
		cg.contactsTextClick();
		cg.customerGroupsTextClick();
		cg.addTextClick();
		Assert.assertTrue(cg.addCustomerGroup(name, "40"));
		System.out.println("Customer Group Added and test passed !!!");
	}

	// @Test(priority = 4)
	public void verifyCustomersGroupCanBeExportedtoPdfFile() throws InterruptedException {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		CustomerGroup cg = new CustomerGroup(webDriver);
		cg.contactsTextClick();
		cg.customerGroupsTextClick();
		cg.actionButtonClick();
		cg.exporttoPDFclick();
		boolean val = cg.fileDownloads("pdf");
		Assert.assertEquals(val, true);
		System.out.println("PDF file Exported and Test Passed!!!");

	}

	// @Test(priority = 3)
	public void verifyCustomerGroupCanDelete() throws InterruptedException {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		CustomerGroup cg = new CustomerGroup(webDriver);
		cg.contactsTextClick();
		cg.customerGroupsTextClick();
		cg.addTextClick();
		Assert.assertTrue(cg.deleteCustomerGroup(name, "40"));
		System.out.println("Customer Group Deleted Successfully and Test Passed !!!");
	}

	// @Test(priority = 2)
	public void verifyCustomerGroupCanEdit() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		CustomerGroup cg = new CustomerGroup(webDriver);
		cg.contactsTextClick();
		cg.customerGroupsTextClick();
		Assert.assertTrue(cg.editCustomerGroup(name, "50"));
		System.out.println("Customer Group Edited Successfully and Test Passed !!!");
	}

}
