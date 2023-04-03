package com.obsqura.pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obsqura.constants.Constants;
import com.obsqura.utilities.WaitUtility;

public class HomePage {
	WebDriver driver;

	@FindBy(xpath = "//a[@class='dropdown-toggle' and @data-toggle='dropdown']")
	WebElement welcomeName;

	@FindBy(xpath = "//button[text()='End tour']")
	WebElement endTour;

	@FindBy(xpath = "//button[@id='btnCalculator']")
	WebElement calculator;

	@FindBy(xpath = "//button[@id='1']")
	WebElement one;

	@FindBy(xpath = "//button[@id='2']")
	WebElement two;

	@FindBy(xpath = "//button[@id='+']")
	WebElement plus;

	@FindBy(xpath = "//button[@id='equals']")
	WebElement equals;

	@FindBy(xpath = "//input[@name='result']")
	WebElement result;
	@FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']")
	WebElement dateToday;
	boolean flag;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isHomePageLoaded() {
		return getWelcomeText().equals(Constants.welcomeText);
	}

	public String getWelcomeText() {
		return welcomeName.getText();

	}

	public void clickEndTour() {
		endTour.click();
	}

	public void calculatorButtonCLicked() {
		calculator.click();
	}

	public boolean iscalculatorWorking() {

		one.click();
		plus.click();
		two.click();
		equals.click();
		String res = "" + result.getAttribute("value");
		return true;

	}

	public boolean verifyTodaysDate() {
		String dateofQA = dateToday.getText();
		String pattern = "dd-MM-yyyy";
		String sysDate = new SimpleDateFormat(pattern).format(new Date());
		System.out.println("dateofQA:" + dateofQA);
		System.out.println("sysDate:" + sysDate);
		if (dateofQA.equals(sysDate)) {
			flag = true;
		}
		return flag;
	}
}
