package org.example.selenium;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

class SeleniumTest {

	WebDriver driver;
	static ChromeOptions options = new ChromeOptions();

	@BeforeAll
	static void setupClass() {
		WebDriverManager.chromedriver().setup();
		options.addArguments("--headless");
	}

	@BeforeEach
	void setupTest() {
		driver = new ChromeDriver(options);
	}

	@AfterEach
	void teardown() {
		driver.quit();
	}

	@Test
	void test() throws InterruptedException {
		// Exercise
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
		Thread.sleep(4000);

		String title = driver.getTitle();

		// Verify
		// Assert that the actual string contains the expected substring
		assertTrue(title.contains("Selenium WebDriver"),
				"The string does not contain the expected substring.");
	}

	@Test
	@Disabled
	void checkProsSite() throws InterruptedException {

		driver.get("https://pros.unicam.it/");

		Thread.sleep(3000);
		
		String at = driver.getTitle();
		String et = "PROS";
		
		//System.out.println(at);
		Thread.sleep(4000);

		assertEquals(et,at);
		driver.close();
		driver.quit();
		
	}

}
