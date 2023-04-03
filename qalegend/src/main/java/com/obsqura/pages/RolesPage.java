package com.obsqura.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class RolesPage {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='User Management']")
	WebElement userManagementText;
	@FindBy(xpath = "/html/body/div[2]/aside/section/ul/li[2]/ul/li[2]/a/span")
	WebElement rolesText;
	@FindBy(xpath = "//td[text()='Director']")
	WebElement elementtoDelete;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBox;
	@FindBy(xpath = "//button[text()=' Delete']")
	WebElement deleteButton;
	@FindBy(xpath = "//table[@id='roles_table']")
	WebElement rolesTable;
	@FindBy(xpath = "//button[text()='OK']")
	WebElement deleteOK;
	@FindBy(xpath = "//td[text()='No matching records found']")
	WebElement norecords;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMessage;
	@FindBy(xpath = "/html/body/div[2]/div[1]/section[2]/div/div[2]/div/table/tbody/tr")
	WebElement rowRetrieved;
	boolean flag;

	@FindBy(xpath = "//a[text()=' Add']")
	WebElement addButton;

	@FindBy(xpath = "//input[@id='name']")
	WebElement name;

	@FindBy(xpath = "/html/body/div[2]/div[1]/section[2]/div/div/form/div[20]/div/button")
	WebElement saveButton;

	public RolesPage(WebDriver webDriver) {
		// TODO Auto-generated constructor stub
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	public String isToastMessageLoaded() {
		String msg = toastMessage.getText();
		return msg;
	}

	public void userManagementTextClick() {
		userManagementText.click();
	}

	public void rolesTextClick() {
		rolesText.click();
	}

	public void addButtonClick() {
		addButton.click();
	}

	public void addRole(String role) {
		name.sendKeys(role);
		saveButton.click();
	}

	public void searchRole(String role) {
		searchBox.sendKeys(role);
	}

	public void deleteRole(String role) {
		List<WebElement> rows_table = rolesTable.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		for (int row = 0; row < rows_count; row++) {
			// To locate columns(cells) of that specific row.
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			// To calculate no of columns (cells). In that specific row.
			int columns_count = Columns_row.size();
			// System.out.println("Number of cells In Row " + row + " are " +
			// columns_count);
			// Loop will execute till the last cell of that specific row.
			for (int column = 0; column < columns_count; column++) {
				// To retrieve text from that specific cell.
				String celtext = Columns_row.get(column).getText();
				if (celtext.equals(role)) {
					deleteButton.click();
					deleteOK.click();
				}

			}

		}

	}

	public boolean isRoleDeleted(String role) {
		String dataRetrieve = rowRetrieved.getText();
		System.out.println("dataRetrieve:" + dataRetrieve);
		if (dataRetrieve.equals("No matching records found")) {
			flag = false;
		}
		if (dataRetrieve.equals(role + " Edit  Delete")) {
			flag = true;
		}

		return flag;

	}

}
