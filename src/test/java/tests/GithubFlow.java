package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.base.Common;
import com.github.pages.CreateRepoPage;
import com.github.pages.HomePage;
import com.github.pages.LoginPage;
import com.github.pages.RepoCodePage;
import com.github.pages.SettingsPage;
import com.github.pages.WelcomePage;

public class GithubFlow extends Common{

	HomePage home;
	LoginPage login;
	WelcomePage welcome;
	RepoCodePage repo;
	CreateRepoPage createRepo;
	SettingsPage settings;

	String repoName = "Repo10";
	String userName;

	@BeforeClass
	void setObject() {
		userName = prop.getProperty("username");
		home = new HomePage(driver);
		login = new LoginPage(driver);
		welcome = new WelcomePage(driver);
		repo = new RepoCodePage(driver);
		createRepo = new CreateRepoPage(driver);
		settings = new SettingsPage(driver);
	}

	@Test(priority = 1)
	void login() {
		home.clickSignIn();
		login.login(prop.getProperty("username"), Cred.password);
	}
	@Test(priority = 2, enabled = false)
	void createRepo(){
		welcome.clickNewRepository();
		createRepo.enterRepoDetails(repoName, "Automated by Selenium test");
		boolean selectedRepoType = createRepo.getSelectedRepoType();
		if(selectedRepoType)
			createRepo.clickCreateRepository();
		Assert.assertTrue(repo.isRepoCreated(repoName));
	}
	@Test(priority = 3)
	void deleteRepor(){
		repoName  = "Repo9";
		welcome.clickNewRepository();
		createRepo.enterRepoDetails(repoName, "Automated by Selenium test");
		boolean selectedRepoType = createRepo.getSelectedRepoType();
		if(selectedRepoType)
			createRepo.clickCreateRepository();
		Assert.assertTrue(repo.isRepoCreated(repoName));
		repo.clickSetting();
		settings.clickDeleteRepo(repoName, userName);
		String deleteMessage = welcome.getDeleteMessage();
		System.out.println(deleteMessage);
		Assert.assertTrue(deleteMessage.contains("deleted."));
	}

}
