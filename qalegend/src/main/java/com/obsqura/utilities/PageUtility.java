package com.obsqura.utilities;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.constants.Constants;

// the code that repeats can be created as methods in page utility
public class PageUtility {
	WebDriver driver;
	public static XSSFWorkbook w;
	public static XSSFSheet sh;

	/*
	 * public PageUtility(WebDriver driver) { this.driver = driver;
	 * PageFactory.initElements(driver, this); }
	 */

	public void dragNDrop(WebElement element1, WebElement element2) {
		WaitUtility wu = new WaitUtility();
		wu.impliciteWait(10000);
		Actions builder = new Actions(driver);
		WebElement from = element1;
		WebElement to = element2;
		builder.dragAndDrop(from, to).perform();
	}

	public void gerCurrentUrl() {
		driver.getCurrentUrl();
	}

	public void getTitle() {
		driver.getTitle();
	}

	public void selectBox(WebElement mySelectedElement) {
		Select dropdown = new Select(mySelectedElement);
		dropdown.selectByVisibleText("");
	}

	public void navigatePages() {
		driver.navigate().to("");
		driver.navigate().back();
		driver.navigate().forward();
	}

	public void moveToELemenet(WebElement element) {
		Actions actions = new Actions(driver);
		WebElement mouseHover = driver.findElement((By) element);
		actions.moveToElement(mouseHover);
		actions.perform();
	}

	public void getConnection() {
		try {
			DriverManager.getConnection("", "username", "password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pageLoadTime() {
		driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
	}

	public String getExcelSheet() {
		String name = "sheet1";
		return name;
	}

	public String getCSSColor(WebElement element) {
		String s = element.getCssValue("color");
		String colorCode = Color.fromString(s).asHex();
		return colorCode;
	}

	public void commisionFilesDownload(String extensions) {
		File f = new File(Constants.downloadPath + "Sales Commission Agents - las." + extensions);
		if (f.exists()) {
			System.out.println("File exists");
		}
	}

	public void customerFilesDownload(String extensions) {
		File f = new File(Constants.downloadPath + "Customer Groups - las." + extensions);
		if (f.exists()) {
			System.out.println("File exists");
		}
	}

	public void userFilesDownload(String extensions) {
		File f = new File(Constants.downloadPath + "Users - las." + extensions);
		if (f.exists()) {
			System.out.println("File exists");
		}
	}

	public void variationsFilesDownload(String extensions) {
		File f = new File(Constants.downloadPath + "Variations - las." + extensions);
		if (f.exists()) {
			System.out.println("File exists");
		}
	}
	
	public void customerGroupFilesDownload(String extensions) {
		File f = new File(Constants.downloadPath + "Customer Groups - las." + extensions);
		if (f.exists()) {
			System.out.println("File exists");
		}
	}

	public void verifySellingGroupCanBeExportedtoCSVFile(String extensions) {
		File f = new File(Constants.downloadPath + "Selling Price Group - las." + extensions);
		if (f.exists()) {
			System.out.println("File exists");
		}
	}
}
