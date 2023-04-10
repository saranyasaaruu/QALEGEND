package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.UserManagePage;
import com.obsqura.utilities.RandomUtility;
import com.obsqura.utilities.WaitUtility;

public class UserManageTest extends TestHelper {
	String email = "User" + RandomUtility.randomEmail();

	// @Test
	public void verifyUserCanAdd() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();// click end tour (name change)
		UserManagePage ump = new UserManagePage(webDriver);
		ump.userManagementTextClick();
		ump.usersTextClick();
		ump.addTextClick();
		ump.addUser(email);
		WaitUtility.sleeps(3000);
		Assert.assertEquals(true, ump.isUserFound(email));
		System.out.println("User added, searched and Test Passed !!!");

	}

	// @Test
	public void verifyUserCanSearchInSearchBox() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		UserManagePage ump = new UserManagePage(webDriver);
		ump.userManagementTextClick();
		ump.usersTextClick();
		Assert.assertEquals(true, ump.isUserFound(email));
		System.out.println("User Found and Test Passed!!!");

	}

	// @Test
	public void verifyAllUsersCanBeExportedAsCSVFile() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		UserManagePage ump = new UserManagePage(webDriver);
		ump.userManagementTextClick();
		ump.usersTextClick();
		ump.actionButtonClick();
		ump.exporttoCSVclick();
		boolean val = ump.fileDownloads("csv");
		Assert.assertEquals(val, true);
		System.out.println("CSV file Exported and Test Passed!!!");

	}

	// @Test
	public void verifyAllUsersCanBeExportedAsExcelFile() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		UserManagePage ump = new UserManagePage(webDriver);
		ump.userManagementTextClick();
		ump.usersTextClick();
		ump.actionButtonClick();
		ump.exporttoExcelclick();
		boolean val = ump.fileDownloads("xlsx");
		Assert.assertEquals(val, true);
		System.out.println("Excel file Exported and Test Passed!!!");

	}

	// @Test
	public void verifyAllUsersCanBeExportedAsPDFFile() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		UserManagePage ump = new UserManagePage(webDriver);
		ump.userManagementTextClick();
		ump.usersTextClick();
		ump.actionButtonClick();
		ump.exporttoPDFclick();
		boolean val = ump.fileDownloads("pdf");
		Assert.assertEquals(val, true);
		System.out.println("PDF file Exported and Test Passed!!!");

	}

}
