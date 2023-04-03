package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.RolesPage;
import com.obsqura.utilities.RandomUtility;
import com.obsqura.utilities.WaitUtility;

public class RolesPageTest extends TestHelper {
	String role = "Role" + RandomUtility.randomNumberGeneration();

//	@Test(priority = 1)
	public void verifyRoleCanBaAdd() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		RolesPage rp = new RolesPage(webDriver);
		rp.userManagementTextClick();
		rp.rolesTextClick();
		rp.addButtonClick();
		rp.addRole(role);
		Assert.assertTrue(rp.isToastMessageLoaded().equals("Role added successfully"));
		System.out.println("Role added and Test Passed!!!");
	}

	// @Test(priority = 3)
	public void verifyRoleCanBeDelete() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		RolesPage rp = new RolesPage(webDriver);
		rp.userManagementTextClick();
		rp.rolesTextClick();
		rp.searchRole(role);
		rp.deleteRole(role);
		Assert.assertEquals(true, rp.isRoleDeleted(role));
		System.out.println("Role Deleted and Test Passed!!!");
	}

	// @Test(priority = 2)
	public void verifyRoleCanBeSearchInSearchBox() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("admin", "123456");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickEndTour();
		RolesPage rp = new RolesPage(webDriver);
		rp.userManagementTextClick();
		rp.rolesTextClick();
		rp.searchRole(role);
		boolean val = rp.isRoleDeleted(role);
		Assert.assertTrue(val);

	}
}
