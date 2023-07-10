package com.cognizant.javascriptExecutorUsage;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ExecutorUsage {

	public static WebDriver driver;
	public static JavascriptExecutor jsExecutor;

	public static void main(String[] args) throws InterruptedException, IOException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your preferred browser (chrome/edge)");
		
		String browser = sc.nextLine();
		sc.close();
		
		driver = DriverSetup.getWebDriver(browser);
		
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		Thread.sleep(2000);
		WebElement basicAlertButton = driver.findElement(By.xpath("//*[@id=\"btnAlert\"]"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", basicAlertButton);
		highlightElement(basicAlertButton);
		basicAlertButton.click();

		// Wait for the custom alert to appear
		Thread.sleep(2000);
		WebElement okButton = driver.findElement(By.xpath("//*[@id=\"ezAlerts-footer\"]/button"));
		highlightElement(okButton);
		try {
		    okButton.click();
		    System.out.println("Alert Button Working");
		} catch (Exception e) {
		    System.out.println("Alert Button not working");
		    e.printStackTrace();
		}

		Thread.sleep(2000);
		driver.navigate().to("https://stqatools.com/demo/");

		Thread.sleep(2000);
		WebElement clickRegister = driver.findElement(By.xpath("//*[@id=\"navbarColor02\"]/ul/li[2]/a"));
		highlightElement(clickRegister);
		try {
		    clickRegister.click();
		    System.out.println("Registration form opened successfully.");
		} catch (Exception e) {
		    System.out.println("Registration form did not open successfully.");
		    e.printStackTrace();
		}

		Thread.sleep(2000);
		WebElement name = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		highlightElement(name);
		name.sendKeys("Amol");

		Thread.sleep(2000);
		WebElement address = driver.findElement(By.xpath("//*[@id=\"address\"]"));
		highlightElement(address);
		address.sendKeys("Mumbai");

		Thread.sleep(2000);
		WebElement genderMale = driver.findElement(By.xpath("//*[@id=\"male\"]"));
		highlightElement(genderMale);
		genderMale.click();

		Thread.sleep(2000);
		WebElement traveling = driver.findElement(By.xpath("//*[@id=\"registration-form\"]/label[8]"));
		traveling.click();
		
		Thread.sleep(2000);
		WebElement music = driver.findElement(By.xpath("//*[@id=\"registration-form\"]/label[9]"));
		music.click();

		Thread.sleep(2000);
		WebElement country = driver.findElement(By.xpath("//*[@id=\"country\"]"));
		highlightElement(country);
		country.click();

		Thread.sleep(2000);
		WebElement australia = driver.findElement(By.xpath("//*[@id=\"country\"]/option[5]"));
		highlightElement(australia);
		australia.click();

		Thread.sleep(2000);
		WebElement city = driver.findElement(By.xpath("//*[@id=\"city\"]"));
		highlightElement(city);
		city.click();
//		city.sendKeys("Delhi");
		
		Thread.sleep(2000);
		WebElement melbourne = driver.findElement(By.xpath("//*[@id=\"city\"]/option[8]"));
		highlightElement(melbourne);
		melbourne.click();

		Thread.sleep(2000);
		WebElement dateOfBirth = driver.findElement(By.xpath("//*[@id=\"dob\"]"));
		highlightElement(dateOfBirth);
		dateOfBirth.sendKeys("18-03-2001");
		
		Thread.sleep(2000);
		WebElement submit = driver.findElement(By.xpath("//*[@id=\"registration-form\"]/button"));
		highlightElement(submit);
		try {
		    submit.click();
		    System.out.println("Form submitted successfully.");
		} catch (Exception e) {
		    System.out.println("Form could not be submitted successfully.");
		    e.printStackTrace();
		}
		Thread.sleep(2000);
		
		jsExecutor.executeScript("window.scrollTo(0, 0);");

        Thread.sleep(1000);
//        WebElement successfulReg = driver.findElement(By.xpath("//*[@id=\"registration-form\"]/p"));
//        highlightElement(successfulReg);
//        Thread.sleep(1000);

		driver.quit();

	}
	
	private static void highlightElement(WebElement element) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border: 5px solid yellow;');", element);		
	}
	
//	private static void captureScreenshot(WebDriver driver, WebElement element, String fileName) throws IOException {
//		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String directoryPath = "./Screenshot/";
//		String screenshotPath = directoryPath + fileName + ".png";
//	    File destinationFile = new File(screenshotPath);
//	    File directory = new File(directoryPath);
//	    if (!directory.exists()) {
//	        directory.mkdirs();
//	    }
//		FileHandler.copy(screenshot, destinationFile);		
//		System.out.println("Screenshot captured.");
//	}

}
