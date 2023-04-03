package com.obsqura.scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ProfilePage;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.WaitUtility;

public class ProfilePageTest extends TestHelper {

	// @Test
	public void verifyPasswordCanUpdateAndReLoginWithNewPassword() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "1234561");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		ProfilePage profilePage = new ProfilePage(webDriver);
		profilePage.clickTextQAlegend();
		profilePage.clickProfileText();
		profilePage.updatePassword("1234561", "123456", "123456");
		profilePage.clickTextQAlegend();
		profilePage.signOut();
		LoginPage loginPag1e = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage1 = new HomePage(webDriver);
		Assert.assertTrue(homepage1.isHomePageLoaded());
		System.out.println("Password Updated Successfully & Test Passed !!! ");

	}

	// @Test
	public void verifyEMailIDCanBeUpdatedAndShowingOnProfilePage() throws IOException {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		ProfilePage profilePage = new ProfilePage(webDriver);
		profilePage.clickTextQAlegend();
		profilePage.clickProfileText();
		profilePage.updateProfileEmail("Admin@Adminqalegend.com");
		Assert.assertEquals("Admin@Adminqalegend.com", profilePage.getEmail());
		System.out.println("profilePage.getEmail():" + profilePage.getEmail());
		System.out.println("Email Updated Successfully & Test Passed !!! ");

	}

}
