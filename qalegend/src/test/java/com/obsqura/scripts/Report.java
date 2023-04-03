package com.obsqura.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Report {

	@Test
	public void cvcvcv() {
		try {
			ExtentSparkReporter spark = new ExtentSparkReporter("Sparks.html");
			ExtentReports extent = new ExtentReports();
			extent.attachReporter(spark);
			extent.createTest("MyFirstTest").log(Status.PASS,
					"This is a logging event for MyFirstTest, and it passed!");
			extent.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/drag-drop.php");
		driver.manage().window().maximize();
		driver.close();
	}
}
