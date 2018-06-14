package com.dice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dice20Keywords2 extends DiceJobSearch{

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(DiceJobSearch.url);
		
		
		
		List<String> newKeywords = new ArrayList<>();
		
		
		try {
			FileReader reader = new FileReader("jobs.txt");
			BufferedReader br = new BufferedReader(reader);
			
			String jobs;
			
			while ((jobs=br.readLine())!=null) {
				
					driver.findElement(By.id("search-field-keyword")).sendKeys(jobs);
					driver.findElement(By.id("search-field-location")).clear();
					driver.findElement(By.id("search-field-location")).sendKeys(DiceJobSearch.location);
					driver.findElement(By.id("findTechJobs")).click();
					String count = driver.findElement(By.id("posiCountId")).getText();
					newKeywords.add(jobs+ "-" + count);
					driver.navigate().back();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						
	 		}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (int i = 0; i < newKeywords.size(); i++) {
			System.out.println(newKeywords.get(i));
		}
		
		
		
		
		

	}

}
