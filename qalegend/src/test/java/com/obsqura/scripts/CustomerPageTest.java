package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.CommisionPage;
import com.obsqura.pages.CustomerPage;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.UserManagePage;
import com.obsqura.utilities.RandomUtility;
import com.obsqura.utilities.WaitUtility;

public class CustomerPageTest extends TestHelper {
	String customer = "Customer" + RandomUtility.randomNumberGeneration();

	// @Test
	public void verifyANewCustomerCanAdd() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		CustomerPage cp = new CustomerPage(webDriver);
		cp.contactsTextClick();
		cp.customerGroupsTextClick();
		cp.addTextClick();
		Assert.assertTrue(cp.addCustomerAgents(customer));
		System.out.println("Customer Agent Added and test passed !!!");
	}

	// @Test
	public void verifyCustomersCanBeExportedtoCSVFile() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		CustomerPage cp = new CustomerPage(webDriver);
		cp.contactsTextClick();
		cp.customerGroupsTextClick();
		cp.actionButtonClick();
		cp.exporttoCSVclick();
		boolean val = cp.fileDownloads("csv");
		Assert.assertEquals(val, true);
		System.out.println("CSV file Exported and Test Passed!!!");

	}

	// @Test
	public void verifyCustomersCanBeExportedtoXlsxFile() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		CustomerPage cp = new CustomerPage(webDriver);
		cp.contactsTextClick();
		cp.customerGroupsTextClick();
		cp.actionButtonClick();
		cp.exporttoExcelclick();
		boolean val = cp.fileDownloads("xlsx");
		Assert.assertEquals(val, true);
		System.out.println("Excel file Exported and Test Passed!!!");

	}

	// @Test
	public void verifyCustomersCanBeExportedtoPdfFile() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		CustomerPage cp = new CustomerPage(webDriver);
		cp.contactsTextClick();
		cp.customerGroupsTextClick();
		cp.actionButtonClick();
		cp.exporttoPDFclick();
		boolean val = cp.fileDownloads("pdf");
		Assert.assertEquals(val, true);
		System.out.println("PDF file Exported and Test Passed!!!");

	}

	// @Test
	public void verifyCustomerCanDelete() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		CustomerPage cp = new CustomerPage(webDriver);
		cp.contactsTextClick();
		cp.customerGroupsTextClick();
		Assert.assertTrue(cp.deleteCustomerAgent(customer));
		System.out.println("Customer Group Deleted Successfully and Test Passed !!!");
	}

}
