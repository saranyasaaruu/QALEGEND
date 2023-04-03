package com.obsqura.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.constants.Constants;
import com.obsqura.utilities.PageUtility;

public class CustomerPage {
	WebDriver driver;

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

	@FindBy(xpath = "//button[text()=\" Delete\"]")
	WebElement deleteButton;
	@FindBy(xpath = "//td[@class='sorting_1']")
	WebElement Name;
	@FindBy(xpath = "//button[text()='OK']")
	WebElement okButton;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBox;

	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

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

	public boolean addCustomerAgents(String n) {
		name.sendKeys(n);
		amount.sendKeys("40");
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

	public boolean fileDownloads(String extendions) {
		PageUtility pu = new PageUtility();
		pu.customerFilesDownload(extendions);
		return true;

	}

	public boolean deleteCustomerAgent(String n) {
		searchBox.sendKeys(n);
		deleteButton.click();
		okButton.click();
		return isToastMessageLoaded().equals("Success");
	}
}
