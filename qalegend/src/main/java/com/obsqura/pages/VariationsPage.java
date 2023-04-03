package com.obsqura.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.constants.Constants;
import com.obsqura.utilities.PageUtility;

public class VariationsPage {
	WebDriver driver;

	@FindBy(xpath = "//span[text()='Products']")
	WebElement productsText;
	@FindBy(xpath = "//span[text()='Variations']")
	WebElement variationsText;
	@FindBy(xpath = "//button[text()=' Add']")
	WebElement addButton;
	@FindBy(xpath = "//input[@id='name']")
	WebElement name;
	@FindBy(xpath = "/html/body/div[2]/div[1]/section[2]/div[2]/div/div/form/div[2]/div[2]/div[1]/input")
	WebElement nameValue;
	@FindBy(xpath = "//button[@id='add_variation_values']")
	WebElement nameValuePlus;
	@FindBy(xpath = "/html/body/div[2]/div[1]/section[2]/div[2]/div/div/form/div[2]/div[3]/div/div[1]/input")
	WebElement namePlus;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMessage;
	@FindBy(xpath = "//a[@class='btn buttons-collection btn-info']")
	WebElement actionButton;
	@FindBy(xpath = "//li[@class=\"dt-button buttons-csv buttons-html5 bg-info\"]")
	WebElement exporttoCSV;
	@FindBy(xpath = "//li[@class=\"dt-button buttons-excel buttons-html5 bg-info\"]")
	WebElement exporttoExcel;
	@FindBy(xpath = "//li[@class=\"dt-button buttons-pdf buttons-html5 bg-info\"]")
	WebElement exporttoPDF;

	public VariationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public VariationsPage addVariations(String variations) {
		productsText.click();
		variationsText.click();
		addButton.click();
		name.sendKeys(variations);
		nameValue.sendKeys("Red");
		nameValuePlus.click();
		namePlus.sendKeys("Green");
		saveButton.click();
		return new VariationsPage(driver);

	}

	public String isToastMessageLoaded() {
		String msg = toastMessage.getText();
		return msg;
	}

	public boolean exporttoCSV() {
		productsText.click();
		variationsText.click();
		actionButton.click();
		exporttoCSV.click();
		File f = new File(Constants.downloadPath + "Variations - las.csv");
		if (f.exists() && !f.isDirectory()) {
			System.out.println("File exists");
		}
		return true;
	}

	public void actionButtonClick() {
		actionButton.click();
	}

	public boolean exporttoExcel() {
		productsText.click();
		variationsText.click();
		actionButton.click();
		exporttoExcel.click();
		File f = new File(Constants.downloadPath + "Variations - las.xlsx");
		if (f.exists() && !f.isDirectory()) {
			System.out.println("File exists");
		}
		return true;
	}

	public boolean exporttoPDF() {
		productsText.click();
		variationsText.click();
		actionButton.click();
		exporttoPDF.click();
		File f = new File(Constants.downloadPath + "Variations - las.pdf");
		if (f.exists() && !f.isDirectory()) {
			System.out.println("File exists");
		}
		return true;
	}

	public void exporttoCSVclick() {
		productsText.click();
		variationsText.click();
		actionButton.click();
		exporttoCSV.click();
	}

	public void exporttoExcelclick() {
		productsText.click();
		variationsText.click();
		actionButton.click();
		exporttoExcel.click();
	}

	public void exporttoPDFclick() {
		productsText.click();
		variationsText.click();
		actionButton.click();
		exporttoPDF.click();
	}

	public boolean fileDownloads(String extendions) {
		PageUtility pu = new PageUtility();
		pu.variationsFilesDownload(extendions);
		return true;

	}

}
