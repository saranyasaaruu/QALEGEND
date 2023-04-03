package com.obsqura.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.constants.Constants;
import com.obsqura.utilities.PageUtility;

public class ImportPage {
	WebDriver driver;
	String cname;
	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contactsText;
	@FindBy(xpath = "/html/body/div[2]/aside/section/ul/li[3]/ul/li[4]/a")
	WebElement importContactsText;
	@FindBy(xpath = "//a[text()=' Download CSV file template']")
	WebElement downloadButton;

	public ImportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void contactsTextClick() {
		contactsText.click();
	}

	public void importContactsTextClick() {
		importContactsText.click();
	}

	public boolean exportContacts() {
		downloadButton.click();
		return true;

	}

}
