package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.CommisionPage;
import com.obsqura.pages.CustomerGroup;
import com.obsqura.pages.CustomerPage;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.ImportPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.UserManagePage;
import com.obsqura.utilities.GenericUtility;
import com.obsqura.utilities.WaitUtility;

public class ImportPageTest extends TestHelper {
	// @Test
	public void verifyContactsCanExport() throws InterruptedException {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		ImportPage im = new ImportPage(webDriver);
		im.contactsTextClick();
		im.importContactsTextClick();
		Thread.sleep(5000);
		Assert.assertTrue(im.exportContacts());
		System.out.println("Contacts Imported Successfully and Test Passed !!!");
	}

}
