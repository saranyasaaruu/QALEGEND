package com.obsqura.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.constants.Constants;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class SellingPricePage {
	WebDriver driver;
	String cname;
	@FindBy(xpath = "//span[text()='Products']")
	WebElement productsText;
	@FindBy(xpath = "//span[text()='Selling Price Group']")
	WebElement sellingPriceGroupText;
	@FindBy(xpath = "//button[text()=' Add']")
	WebElement addText;
	@FindBy(xpath = "//input[@id='name']")
	WebElement name;
	@FindBy(xpath = "//textarea[@id='description']")
	WebElement desc;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//button[text()=' Edit']")
	WebElement editButton;
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
	@FindBy(xpath = "/html/body/div[4]/div/div[3]/div[2]/button")
	WebElement okButton;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBox;

	@FindBy(xpath = "//button[text()='Update']")
	WebElement updateButton;

	public SellingPricePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void productsTextClick() {
		productsText.click();
	}

	public void sellingPriceGroupTextClick() {
		sellingPriceGroupText.click();
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

	public boolean addSellingGroup(String na, String descs) {
		name.sendKeys(na);
		desc.sendKeys(descs);
		saveButton.click();
		return isToastMessageLoaded().equals("Added Successfully");
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
		pu.verifySellingGroupCanBeExportedtoCSVFile(extendions);
		return true;

	}

	public boolean deleteSellingGroup(String n, String descs) throws InterruptedException {
		name.sendKeys(n);
		desc.sendKeys(descs);
		saveButton.click();
		WaitUtility.sleeps(2000);
		searchBox.sendKeys(n);
		WaitUtility.sleeps(2000);
		deleteButton.click();
		WaitUtility.sleeps(2000);
		okButton.click();
		return isToastMessageLoaded().equals("Deleted Successfully");
	}

	public boolean editSellingGroup(String n, String descs) throws InterruptedException {
		searchBox.sendKeys(n);
		WaitUtility.sleeps(2000);
		editButton.click();
		WaitUtility.sleeps(2000);
		name.clear();
		desc.clear();
		WaitUtility.sleeps(2000);
		name.sendKeys(n + "123");
		desc.sendKeys(descs + "123");
		WaitUtility.sleeps(2000);
		updateButton.click();
		return isToastMessageLoaded().equals("Updated Successfully");
	}
}
