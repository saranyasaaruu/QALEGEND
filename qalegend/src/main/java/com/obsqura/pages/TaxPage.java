package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class TaxPage {
	WebDriver driver;

	@FindBy(xpath = "//span[text()='Settings']")
	WebElement settingsClick;
	@FindBy(xpath = "//span[text()='Tax Rates']")
	WebElement taxRateText;
	@FindBy(xpath = "//button[text()=' Add']")
	WebElement addTax;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMessage;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//input[@id='name']")
	WebElement name;
	@FindBy(xpath = "//input[@id='amount']")
	WebElement taxRate;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchTax;

	@FindBy(xpath = "//td[text()='No matching records found']")
	WebElement norecords;

	@FindBy(xpath = "/html/body/div[2]/div[1]/section[2]/div[1]/div[2]/div/div/table/tbody/tr")
	WebElement rowRetrieved;

	@FindBy(xpath = "//button[@class='btn btn-xs btn-danger delete_tax_rate_button']")
	WebElement deleteButton;

	@FindBy(xpath = "/html/body/div[4]/div/div[4]/div[2]/button")
	WebElement okButton;
	boolean flag;

	public TaxPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean addTax(String n) {
		settingsClick.click();
		taxRateText.click();
		addTax.click();
		name.sendKeys(n);
		taxRate.sendKeys("5");
		saveButton.click();
		return isTaxAdded().equals("Tax rate added successfully");

	}

	public String isTaxAdded() {
		String msg = toastMessage.getText();
		return msg;

	}

	public void searchTax(String taxName) {
		settingsClick.click();
		taxRateText.click();
		searchTax.sendKeys(taxName);
	}

	public boolean isTaxPresent(String taxName) {

		String dataRetrieve = rowRetrieved.getText();
		System.out.println("dataRetrieve:" + dataRetrieve);
		if (dataRetrieve.equals("No matching records found")) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;

	}

	public boolean deleteTax(String name) {
		settingsClick.click();
		taxRateText.click();
		WaitUtility.sleeps(2000);
		searchTax.sendKeys(name);
		WaitUtility.sleeps(2000);
		deleteButton.click();
		WaitUtility.sleeps(2000);
		okButton.click();
		return isTaxDeleted().equals("Tax rate deleted successfully");
	}

	public String isTaxDeleted() {
		String msg = toastMessage.getText();
		return msg;
	}

}
