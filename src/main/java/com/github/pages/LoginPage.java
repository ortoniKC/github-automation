package com.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.base.SeleniumBase;

public class LoginPage extends SeleniumBase{

	
	public LoginPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String userName, String password) {
		type(driver.findElement(By.id(properties.getProperty("LoginPage.username.id"))), userName);
		type(driver.findElement(By.id(properties.getProperty("LoginPage.password.id"))), password);
		click(driver.findElement(By.name(properties.getProperty("LoginPage.password.name"))));
	}
}
