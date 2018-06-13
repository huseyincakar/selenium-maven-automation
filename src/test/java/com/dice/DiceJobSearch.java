package com.dice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
		String url = "https://dice.com";
		driver.get(url);
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Job Search for Technology Professionals | Dice.com";
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Step Pass: Dice homepage successfully loaded");
		}else {
			System.out.println("Step Fail: Dice homepage did not load successfully");
			throw new RuntimeException(("Step Fail: Dice homepage did not load successfully"));
		}
		
		
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("search-field-keyword")).sendKeys("Java selenium");
		driver.findElement(By.id("search-field-location")).clear();
		
		driver.findElement(By.id("search-field-location")).sendKeys("Boston");
		driver.findElement(By.id("findTechJobs")).click();
		
		String count = driver.findElement(By.id("posiCountId")).getText();
		System.out.println(count);
		
		Thread.sleep(4000);
		driver.close();
		
		System.out.println("TEST COMPLETED - " + LocalDateTime.now());
	} 

}
