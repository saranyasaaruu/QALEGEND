package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.constants.Constants;
import com.obsqura.utilities.WaitUtility;

public class PrinterPage {
	WebDriver driver;

	@FindBy(xpath = "//span[text()='Settings']")
	WebElement settingsClick;

	@FindBy(xpath = "//span[text()='Receipt Printers']")
	WebElement printersClick;

	@FindBy(xpath = "//a[text()=' Add Printer']")
	WebElement addPrinterClick;

	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMessage;

	@FindBy(xpath = "//input[@id='name']")
	WebElement pname;

	@FindBy(xpath = "//input[@id='char_per_line']")
	WebElement pchar;

	@FindBy(xpath = "//input[@id='ip_address']")
	WebElement ipAddress;

	@FindBy(xpath = "//span[@id='select2-connection_type-container']")
	WebElement dropdownBox1;

	@FindBy(xpath = "//span[@id='select2-capability_profile-container']")
	WebElement dropdownBox2;

	@FindBy(xpath = "//li[text()='Windows']")
	WebElement windowsText;

	@FindBy(xpath = "//li[text()='Simple']")
	WebElement simpleText;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//input[@id='path']")
	WebElement path;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchPrinter;

	@FindBy(xpath = "//button[@class='btn btn-xs btn-danger delete_printer_button']")
	WebElement deleteButton;

	@FindBy(xpath = "//button[text()='OK']")
	WebElement okButton;

	@FindBy(xpath = "//td[text()='No matching records found']")
	WebElement norecords;

	@FindBy(xpath = "/html/body/div[2]/div[1]/section[2]/div/div[2]/div/div/table/tbody/tr")
	WebElement rowRetrieved;
	boolean flag;
	WaitUtility wu = new WaitUtility();

	public PrinterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void settingsClick() {
		settingsClick.click();
	}

	public void printersClick() {
		printersClick.click();
	}

	public void addPrinterClick() {
		addPrinterClick.click();
	}

	public void dropdownBox1() {
		dropdownBox1.click();
		windowsText.click();
	}

	public void dropdownBox2() {
		dropdownBox2.click();
		simpleText.click();
	}

	public boolean addPrinter(String n) {
		WaitUtility wu = new WaitUtility();
		pname.sendKeys(n);
		ipAddress.sendKeys("192.168.101.1");
		dropdownBox1();
		dropdownBox2();
		path.sendKeys(Constants.printerPath);
		saveButton.click();
		return isToastMessageLoaded().equals("Printer added successfully");

	}

	public String isToastMessageLoaded() {
		String msg = toastMessage.getText();
		return msg;
	}

	public boolean deletePrinter(String n) {
		WaitUtility wu = new WaitUtility();
		searchPrinter.sendKeys(n);
		deleteButton.click();
		okButton.click();
		return isPrinterDeleted().equals("Printer deleted successfully");
	}

	public String isPrinterDeleted() {
		String msg = toastMessage.getText();
		return msg;
	}

	public void searchPrinter(String name) {
		searchPrinter.sendKeys(name);
	}

	public boolean isPrinterPresent(String printer) {
		String dataRetrieve = rowRetrieved.getText();
		System.out.println("dataRetrieve:" + dataRetrieve);
		if (dataRetrieve.equals("No matching records found")) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;

	}
}
