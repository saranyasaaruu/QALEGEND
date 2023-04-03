package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.CommisionPage;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.UserManagePage;
import com.obsqura.utilities.WaitUtility;

public class CommisionPageTest extends TestHelper {

	// @Test
	public void verifyCommisionAgentCanBeDelete() {
		// WaitUtility wu = new WaitUtility();
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		CommisionPage cpt = new CommisionPage(webDriver);
		cpt.userManagementTextClick();
		cpt.salesCommissionTextClick();
		Assert.assertTrue(cpt.deleteCommisionAgent());
		System.out.println("Commision Agent Deleted Successfully and Test Passed !!!");
	}

//	@Test
	public void verifyCommisionAgentsCanBeExportedtoACSVFile() {

		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		CommisionPage cpt = new CommisionPage(webDriver);
		cpt.userManagementTextClick();
		cpt.salesCommissionTextClick();
		cpt.actionButtonClick();
		cpt.exporttoCSVclick();
		boolean val = cpt.fileDownloads("csv");
		Assert.assertEquals(val, true);
		System.out.println("CSV file Exported and Test Passed!!!");

	}

	// @Test
	public void verifyCommisionAgentsCanBeExportedtoAnExcelFile() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		CommisionPage cpt = new CommisionPage(webDriver);
		cpt.userManagementTextClick();
		cpt.salesCommissionTextClick();
		cpt.actionButtonClick();
		cpt.exporttoExcelclick();
		boolean val = cpt.fileDownloads("xlsx");
		Assert.assertEquals(val, true);
		System.out.println("Excel file Exported and Test Passed!!!");

	}

	// @Test
	public void verifyCommisionAgentsCanBeExportedtoAPdflFile() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		CommisionPage cpt = new CommisionPage(webDriver);
		cpt.userManagementTextClick();
		cpt.salesCommissionTextClick();
		cpt.actionButtonClick();
		cpt.exporttoPDFclick();
		boolean val = cpt.fileDownloads("pdf");
		Assert.assertEquals(val, true);
		System.out.println("PDF file Exported and Test Passed!!!");

	}
}
