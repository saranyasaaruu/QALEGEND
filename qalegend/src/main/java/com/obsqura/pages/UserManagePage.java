package com.obsqura.pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.constants.Constants;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class UserManagePage {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='User Management']")
	WebElement userManagementText;
	@FindBy(xpath = "/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a/span")
	WebElement usersText;
	@FindBy(xpath = "//a[text()=' Add']")
	WebElement addText;
	@FindBy(xpath = "//input[@id='surname']")
	WebElement surName;
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstName;
	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastName;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passWord;
	@FindBy(xpath = "//input[@id='confirm_password']")
	WebElement confirmPassword;
	@FindBy(xpath = "//input[@id='cmmsn_percent']")
	WebElement commissionPercentage;
	@FindBy(xpath = "/html/body/div[2]/div[1]/section[2]/form/div[1]/div/div/div/div[6]/div/span/span[1]")
	WebElement selectRole;
	@FindBy(xpath = "//input[@class='input-icheck status' and @name='is_active']")
	WebElement checkBox;
	@FindBy(xpath = "//button[@id='submit_user_button']")
	WebElement saveButton;
	@FindBy(xpath = "//li[text()='Admin']")
	WebElement adminText;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBox;
	@FindBy(xpath = "//table[@id='users_table']")
	WebElement tableLocator;
	@FindBy(xpath = "//a[@class='btn buttons-collection btn-info']")
	WebElement actionButton;
	@FindBy(xpath = "//a[text()=' Export to CSV']")
	WebElement exporttoCSV;
	@FindBy(xpath = "//a[text()=' Export to Excel']")
	WebElement exporttoExcel;
	@FindBy(xpath = "//a[text()=' Export to PDF']")
	WebElement exporttoPDF;

	public UserManagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void userManagementTextClick() {
		userManagementText.click();
	}

	public void usersTextClick() {
		usersText.click();
	}

	public void addTextClick() {
		addText.click();
	}

	public void actionButtonClick() {
		actionButton.click();
	}

	public void addUser(String mail) {
		try {
			surName.sendKeys("MR");
			firstName.sendKeys("Deva");
			lastName.sendKeys("Nand");
			email.sendKeys(mail);
			passWord.sendKeys("dev123");
			confirmPassword.sendKeys("dev123");
			commissionPercentage.sendKeys("50");
			selectRole.click();
			adminText.click();
			saveButton.click();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public boolean isUserFound(String email) {
		WaitUtility.sleeps(3000);
		searchBox.sendKeys(email);
		List<WebElement> rows_table = tableLocator.findElements(By.tagName("tr"));
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
				if (celtext.equals(email)) {
					for (WebElement webElement : rows_table) {
						System.out.println("Inside table ");
						if (webElement.getText().contains(celtext)) {
							String rowValue = webElement.getText();
							// System.out.println(rowValue);
							String em = Columns_row.get(columns_count - 1).getText();
							System.out.println("Email: " + em);

						}
					}
				}

			}

		}
		return true;

	}

	public void exporttoCSVclick() {
		exporttoCSV.click();
	}

	public void exporttoExcelclick() {
		exporttoExcel.click();
	}

	public void exporttoPDFclick() {
		exporttoPDF.click();
	}

	public boolean fileDownloads(String extendions) {
		PageUtility pu = new PageUtility();
		pu.userFilesDownload(extendions);
		return true;

	}
}
