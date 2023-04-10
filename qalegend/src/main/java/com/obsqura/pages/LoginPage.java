package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.GenericUtility;
import com.obsqura.utilities.WaitUtility;

public class LoginPage {
	public String invalidLogText;
	WebDriver driver;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement button;
	@FindBy(xpath = "//strong")
	WebElement invalidLoginData;
	@FindBy(xpath = "//button[text()='End tour']")
	WebElement endTour;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String user, String pass) {
		GenericUtility.sendValues(username, user);
		GenericUtility.sendValues(password, pass);
		WaitUtility.fluentWait(10000, 2000, button, driver);
		GenericUtility.clickOnElement(button);
		return new HomePage(driver);
	}

	public String getErrorMessage() {
		String errorMsg = invalidLoginData.getText();
		return errorMsg;
	}

	public void clickEndTour() {
		endTour.click();
	}

}
