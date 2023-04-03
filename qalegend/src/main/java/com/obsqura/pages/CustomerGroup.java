package com.obsqura.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.constants.Constants;
import com.obsqura.utilities.PageUtility;

public class CustomerGroup {
	WebDriver driver;
	String cname;
	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contactsText;
	@FindBy(xpath = "/html/body/div[2]/aside/section/ul/li[3]/ul/li[3]/a")
	WebElement customerGroupsText;
	@FindBy(xpath = "//button[text()=' Add']")
	WebElement addText;
	@FindBy(xpath = "//input[@id='name']")
	WebElement name;
	@FindBy(xpath = "//input[@id='amount']")
	WebElement amount;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//button[text()='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMessage;

	@FindBy(xpath = "//a[@class='btn buttons-collection btn-info']")
	WebElement actionButton;
	@FindBy(xpath = "//a[text()=' Export to CSV']")
	WebElement exporttoCSV;
	@FindBy(xpath = "//a[text()=' Export to Excel']")
	WebElement exporttoExcel;
	@FindBy(xpath = "//a[text()=' Export to PDF']")
	WebElement exporttoPDF;

	@FindBy(xpath = "/html/body/div[2]/div[1]/section[2]/div[1]/div[2]/div/div/table/tbody/tr/td[3]/button[2]")
	WebElement deleteButton;
	@FindBy(xpath = "//td[@class='sorting_1']")
	WebElement Name;
	@FindBy(xpath = "//button[text()='OK']")
	WebElement okButton;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBox;

	@FindBy(xpath = "//button[text()=\" Edit\"]")
	WebElement editButton;

	public CustomerGroup(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/*
	 * public String setCustometrGroupName(String cname) { this.cname = cname;
	 * return cname;
	 * 
	 * }
	 */

	public void contactsTextClick() {
		contactsText.click();
	}

	public void customerGroupsTextClick() {
		customerGroupsText.click();
	}

	public void addTextClick() {
		addText.click();
	}

	public void actionButtonClick() {
		actionButton.click();
	}

	public String isToastMessageLoaded() {
		String msg = toastMessage.getText();
		return msg;
	}

	public boolean addCustomerGroup(String na, String percentage) {
		name.sendKeys(na);
		amount.sendKeys(percentage);
		saveButton.click();
		return isToastMessageLoaded().equals("Success");
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

	public boolean fileDownloads(String extendions) throws InterruptedException {
		PageUtility pu = new PageUtility();
		Thread.sleep(5000);
		pu.customerGroupFilesDownload(extendions);
		Thread.sleep(5000);
		return true;

	}

	public boolean deleteCustomerGroup(String n, String percentage) throws InterruptedException {
		name.sendKeys(n);
		amount.sendKeys(percentage);
		saveButton.click();
		Thread.sleep(5000);
		searchBox.sendKeys(n);
		deleteButton.click();
		Thread.sleep(5000);
		okButton.click();
		return isToastMessageLoaded().equals("Success");
	}

	public boolean editCustomerGroup(String n, String percentage) {
		searchBox.sendKeys(n);
		editButton.click();
		name.clear();
		amount.clear();
		name.sendKeys(n + "123");
		amount.sendKeys(percentage);
		updateButton.click();
		return isToastMessageLoaded().equals("Success");
	}
}
