package com.github.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumBase {
	
	protected RemoteWebDriver driver = null;
	protected static WebDriverWait wait = null;
	protected Properties properties = null;
	
	public SeleniumBase() {
		properties = new Properties();
		try {
			properties.load(new FileInputStream("locators.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getTitle(){
		return driver.getTitle();
	}
	
	protected void click(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	}
	
	public void type(WebElement ele, String data) {
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.clear();
		ele.sendKeys(data);
	}


}
