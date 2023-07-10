package com.cognizant.javascriptExecutorUsage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {
	public static WebDriver getWebDriver(String browser) {
		// Set the path to the ChromeDriver executable

		WebDriver driver = null;

		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\2266531\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\2266531\\Downloads\\edgedriver_win32\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			System.err.println("Invalid browser specified.");
		}

		driver.get("https://stqatools.com/demo/Alerts.php");
		driver.manage().window().maximize();
		return driver;
	}
}