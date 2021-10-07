package com.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.base.SeleniumBase;

public class HomePage extends SeleniumBase{
	
	
	public HomePage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSignIn() {
		String signInLocator = properties.get("HomePage.signIn.text").toString();
		WebElement signIn = driver.findElement(By.linkText(signInLocator));
		click(signIn);
	}

}
