package com.obsqura.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	private static WebDriver jsWaitDriver;
	private static WebDriverWait jsWait;
	private static JavascriptExecutor jsExec;
	WebDriver driver;

	public static  void sleeps(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void implicicteWait() {
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}

	public void waitForanElement(WebElement element) {
		System.out.println("waiting =================================");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
	}

	public void waitforElementtoBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable((By) element));
	}

	public boolean waitforElementtoLoad(WebElement element) {
		System.out.println("waiting =================================");
		System.out.println(element.getText());
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
		return true;

	}

	private void waitForJQueryLoad() {
		try {
			ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) this.driver)
					.executeScript("return jQuery.active") == 0);
			boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");
			if (!jqueryReady) {
				jsWait.until(jQueryLoad);
			}
		} catch (WebDriverException ignored) {
		}
	}

	private void waitUntilJSReady() {
		try {
			ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) this.driver)
					.executeScript("return document.readyState").toString().equals("complete");
			boolean jsReady = jsExec.executeScript("return document.readyState").toString().equals("complete");
			if (!jsReady) {
				jsWait.until(jsLoad);
			}
		} catch (WebDriverException ignored) {
		}
	}

	private void jsWaitFluentWait() {
		Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
		if (jQueryDefined) {
			poll(20);
			waitForJQueryLoad();
			poll(20);
		}
	}

	public void waitForAnimationToComplete(String css) {
		ExpectedCondition<Boolean> angularLoad = driver -> {
			int loadingElements = this.driver.findElements(By.cssSelector(css)).size();
			return loadingElements == 0;
		};
		jsWait.until(angularLoad);
	}

	private void poll(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
