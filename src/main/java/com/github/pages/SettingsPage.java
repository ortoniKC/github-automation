package com.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.base.SeleniumBase;

public class SettingsPage extends SeleniumBase{


	public SettingsPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	

	public void clickDeleteRepo(String repoName, String username) {
		click(driver.findElement(By.xpath(properties.getProperty("Setting.delete.xpath"))));
		type(driver.findElement(By.xpath("//form[contains(@action,'/"+username+"')]/p/input[@name='verify' and contains(@aria-label,'delete')]")), 
				username.concat("/"+repoName));
		WebElement deleteBtn = driver.findElement(By.xpath("//span[text()='I understand the consequences, delete this repository']"));
		click(deleteBtn);
	}


}
