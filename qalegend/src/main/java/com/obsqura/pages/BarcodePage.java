package com.obsqura.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.constants.Constants;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.ScrollUtility;
import com.obsqura.utilities.WaitUtility;

public class BarcodePage {
	WebDriver driver;
	String cname;
	@FindBy(xpath = "//span[text()='Settings']")
	WebElement settingsText;
	@FindBy(xpath = "//span[text()='Barcode Settings']")
	WebElement barcodeSettingsText;
	@FindBy(xpath = "//a[text()=' Download CSV file template']")
	WebElement downloadButton;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBox;
	@FindBy(xpath = "//button[text()='Set as default']")
	WebElement setButton;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMessage;
	@FindBy(xpath = "/html/body/div[2]/div[1]/section[2]/div/div[2]/div/div/table/tbody/tr/td[3]/button[1]")
	WebElement deleteButton;
	@FindBy(xpath = "//button[text()='OK']")
	WebElement okButton;

	@FindBy(xpath = "//a[text()=' Add new setting']")
	WebElement addBarcode;

	@FindBy(xpath = "//input[@id='name']")
	WebElement name;

	@FindBy(xpath = "//input[@id='width']")
	WebElement width;

	@FindBy(xpath = "//input[@id='paper_width']")
	WebElement paperWidth;

	@FindBy(xpath = "//input[@id='stickers_in_one_row']")
	WebElement stickerInOneRow;

	@FindBy(xpath = "//input[@id='height']")
	WebElement height;

	@FindBy(xpath = "//input[@id='paper_height']")
	WebElement paperHeight;

	@FindBy(xpath = "//input[@id='stickers_in_one_sheet']")
	WebElement stickersinOneSheet;

	@FindBy(xpath = "/html/body/div[2]/div[1]/section[2]/form/div/div/div/div[20]/button")
	WebElement saveButton;

	public BarcodePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void settingsTextClick() throws InterruptedException {
		settingsText.click();
	}

	public void barcodeSettingsTextClick() throws InterruptedException {

		barcodeSettingsText.click();
	}

	public void addBarcodeClick() {
		addBarcode.click();
	}

	public BarcodePage setDetaultBarCode(String name) {
		searchBox.sendKeys(name);
		setButton.click();
		return new BarcodePage(driver);
	}

	public String isToastMessageLoaded() {
		String msg = toastMessage.getText();
		return msg;
	}

	public BarcodePage deleteBarcode(String name) throws InterruptedException {
		searchBox.sendKeys(name);
		Thread.sleep(3000);
		deleteButton.click();
		Thread.sleep(3000);
		okButton.click();
		Thread.sleep(3000);
		return new BarcodePage(driver);
		// return isToastMessageLoaded().equals("Barcode setting deleted successfully");
	}

	public BarcodePage addBarcode(String n) {
		name.sendKeys(n);
		width.sendKeys("" + 1);
		paperWidth.sendKeys("" + 1);
		stickerInOneRow.sendKeys("" + 1);
		height.sendKeys("" + 1);
		paperHeight.sendKeys("" + 1);
		stickersinOneSheet.sendKeys("" + 1);
		WaitUtility.sleeps(3000);
		saveButton.click();
		return new BarcodePage(driver);
	}

}
