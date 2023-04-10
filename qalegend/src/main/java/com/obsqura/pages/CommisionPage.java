package com.obsqura.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.constants.Constants;
import com.obsqura.utilities.GenericUtility;
import com.obsqura.utilities.PageUtility;

public class CommisionPage {

	WebDriver driver;
	@FindBy(xpath = "//span[text()='User Management']")
	WebElement userManagementText;
	@FindBy(xpath = "/html/body/div[2]/aside/section/ul/li[2]/ul/li[3]/a/span")
	WebElement salesCommissionText;
	@FindBy(xpath = "//button[text()=\" Delete\"]")
	WebElement deleteButton;
	@FindBy(xpath = "//td[@class='sorting_1']")
	WebElement Name;
	@FindBy(xpath = "//button[text()='OK']")
	WebElement okButton;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMessage;
	@FindBy(xpath = "/html/body/div[2]/div[1]/section[2]/div[1]/div[2]/div/div/div[1]/div/div[2]/div")
	WebElement actionButton;
	@FindBy(xpath = "//li[@class=\"dt-button buttons-csv buttons-html5 bg-info\"]")
	WebElement exporttoCSV;
	@FindBy(xpath = "//li[@class=\"dt-button buttons-excel buttons-html5 bg-info\"]")
	WebElement exporttoExcel;
	@FindBy(xpath = "//li[@class=\"dt-button buttons-pdf buttons-html5 bg-info\"]")
	WebElement exporttoPDF;

	public CommisionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void userManagementTextClick() {
		GenericUtility.clickOnElement(userManagementText);
	}

	public void salesCommissionTextClick() {
		GenericUtility.clickOnElement(salesCommissionText);
	}

	public boolean deleteCommisionAgent() {
		GenericUtility.clickOnElement(deleteButton);
		GenericUtility.clickOnElement(okButton);
		return isToastMessageLoaded().equals("Commission agent deleted successfully");
	}

	public String isToastMessageLoaded() {
		String msg = toastMessage.getText();
		return msg;
	}

	public void actionButtonClick() {
		GenericUtility.clickOnElement(actionButton);
	}

	public void exporttoCSVclick() {
		GenericUtility.clickOnElement(exporttoCSV);
	}

	public void exporttoExcelclick() {
		GenericUtility.clickOnElement(exporttoExcel);
	}

	public void exporttoPDFclick() {
		GenericUtility.clickOnElement(exporttoPDF);
	}

	public boolean fileDownloads(String extendions) {
		PageUtility pu = new PageUtility();
		pu.commisionFilesDownload(extendions);
		return true;

	}

}
