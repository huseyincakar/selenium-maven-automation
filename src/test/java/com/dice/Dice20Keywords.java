package com.dice;





import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dice20Keywords extends DiceJobSearch{

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(DiceJobSearch.url);
		
		
		List <String> keywords = new ArrayList<>();
		
		
		String[] arr = {
				"User interface (UI) developer",
				"Business intelligence developer",
				"Systems analyst",
				"Data analyst",
				"Data engineer",
				"Reliability engineer",
				"Process engineer",
				"Solutions architect",
				"User experience (UX) designer",
				"Database administrator",
				"Quality assurance (QA) manager",
				"Hardware engineer",
				"Software engineer",
				"Analytics manager",
				"Site reliability engineer",
				"Front end engineer",
				"Product manager",
				"Mobile developer",
				"Software development",
				"Data scientist"};
		
		for (int i = 0; i < arr.length; i++) {
			keywords.add(arr[i]);
			
		}
		
		
		
		
		for (int j = 0; j < keywords.size(); j++) {
			
		
			driver.findElement(By.id("search-field-keyword")).sendKeys(keywords.get(j));
			driver.findElement(By.id("search-field-location")).clear();
			
			driver.findElement(By.id("search-field-location")).sendKeys(DiceJobSearch.location);
			driver.findElement(By.id("findTechJobs")).click();
			String count = driver.findElement(By.id("posiCountId")).getText();
			
		
			
			keywords.set(j, (keywords.get(j)+ "-" + count));
			
			driver.navigate().back();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
			
			
			System.out.println(keywords.get(j));
		
		}
		
	//	System.out.println(keywords);
		
		driver.close();
		
		
	}
}
