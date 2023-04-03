package com.obsqura.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class ProfilePage {
	WebDriver driver;
	@FindBy(xpath = "//input[@id='current_password']")
	WebElement currrentPass;
	@FindBy(xpath = "//input[@id='new_password']")
	WebElement newPass;
	@FindBy(xpath = "//input[@id='confirm_password']")
	WebElement confirmPass;
	@FindBy(xpath = "/html/body/div[2]/div[1]/section[2]/form[1]/div/div/div/div[2]/button")
	WebElement updatePassButton;
	@FindBy(xpath = "/html/body/div[2]/div[1]/section[2]/form[2]/div[1]/div/div/div[2]/div[4]/div/input")
	WebElement email;
	@FindBy(xpath = "/html/body/div[2]/div[1]/section[2]/form[2]/div[2]/div/button")
	WebElement updateProfileButton;
	@FindBy(xpath = "//span[text()='vishwanadhan Aanadh']")
	WebElement clickTextQAlegend;
	@FindBy(xpath = "//a[text()='Profile']")
	WebElement clickProfileText;
	@FindBy(xpath = "//a[text()='Sign Out']")
	WebElement signoutButton;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void updatePassword(String cupass, String newpass, String conpass) {
		currrentPass.sendKeys(cupass);
		newPass.sendKeys(newpass);
		confirmPass.sendKeys(conpass);
		updatePassButton.click();

	}

	public void signOut() {
		signoutButton.click();
	}

	public void clickTextQAlegend() {
		clickTextQAlegend.click();
	}

	public void clickProfileText() {
		clickProfileText.click();
	}

	public void updateProfileEmail(String emailid) {
		email.clear();
		email.sendKeys(emailid);
		updateProfileButton.click();
	}

	public String getEmail() {
		try {
			System.out.println("Email is: " + email.getAttribute("value"));
		} catch (Exception e) {
			System.out.println(e);
		}
		return email.getAttribute("value");
	}
}
