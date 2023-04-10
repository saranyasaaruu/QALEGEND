package com.obsqura.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Random;
import java.util.TimeZone;

import org.openqa.selenium.WebElement;

import com.obsqura.constants.Constants;

// method to return timestamp in java.  whatever you need you can create utility here.
public class GenericUtility {

	public String generateTimeStamp() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		return timeStamp;
	}

	public InetAddress currentIPAddress() {
		InetAddress localHost = null;
		try {
			localHost = InetAddress.getLocalHost();
			System.out.println(localHost.getHostAddress());

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return localHost;

	}

	public String getTimeZone() {
		TimeZone timezone = TimeZone.getTimeZone("Asia/Kolkata");
		System.out.println("Value of ID is: " + timezone.getID());
		return timezone.getID();
	}

	public String getConfigFileURL() throws IOException {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(Constants.configFilePath);
		prop.load(ip);
		String url = prop.getProperty("url");
		return url;
	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static void sendValues(WebElement element, String key) {
		element.sendKeys(key);
	}
}
