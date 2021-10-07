package com.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.base.SeleniumBase;

public class CreateRepoPage extends SeleniumBase{


	public CreateRepoPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public void enterRepoDetails(String repoName, String description){
		type(driver.findElement(By.id(properties.getProperty("Repo.name.id"))), repoName);
		type(driver.findElement(By.id(properties.getProperty("Repo.description.id"))), description);
	}

	public boolean getSelectedRepoType() {
		return driver.findElement(By.id(properties.getProperty("Repo.publicInput.id"))).isSelected();
	}


	public void clickCreateRepository(){
		click(driver.findElement(By.cssSelector(properties.getProperty("Repo.createBtn.css"))));
	}



}
