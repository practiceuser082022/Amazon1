package com.amazon.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	

	public WebDriver getDriver() {

		WebDriverManager.chromedriver().setup();
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return webDriver;

	}

	public Properties getUserInfo() {

		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(new File(System.getProperty("user.dir") + "\\user.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public Properties getEnvInfo() {

		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(new File(System.getProperty("user.dir") + "\\env.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	public String getEnvUrl() {
		Properties properties=getEnvInfo();
		return properties.getProperty("url");
	}
}
