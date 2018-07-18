package com.epam.ta.steps;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Steps
{
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();
	private String heading;

	public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver()
	{
		DriverSingleton.closeDriver();
	}

	public void loginGithub(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	public boolean isLoggedIn(String username)
	{
		LoginPage loginPage = new LoginPage(driver);
		String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
		logger.info("Actual username: " + actualUsername);
		return actualUsername.equals(username);
	}

	public boolean createNewRepository(String repositoryName, String repositoryDescription)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnCreateNewRepositoryButton();
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		String expectedRepoName = createNewRepositoryPage.createNewRepository(repositoryName, repositoryDescription);
		return expectedRepoName.equals(createNewRepositoryPage.getCurrentRepositoryName());
	}

	public boolean currentRepositoryIsEmpty()
	{
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		return createNewRepositoryPage.isCurrentRepositoryEmpty();
	}

	public void logoutGitHub() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnLogoutImg();
		mainPage.clickOnLogoutButton();
		logger.info("Signed out github");
	}

	public boolean isSignUpForGitHubDisplayed() {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		return mainPage.isSignedOut();
	}

	public void createRandomAccountWithIncorrectEmail() {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.clickOnCreateAccount();
		SignInPage signInPage = new SignInPage(driver);
		signInPage.fillIncorrectEmailInFormToCreateNewAccount();
		signInPage.clickOnSubmitButton();
	}

	public String getErrorEmailMessage() {
		SignInPage signInPage = new SignInPage(driver);
		return signInPage.getErrorEmailMessage();
	}

	public void inputShortPassword() {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.openPage();
		signInPage.fillIncorrectShortPasswordInFormToCreateNewAccount();
	}

	public String getPasswordErrorMessage() {
		SignInPage signInPage = new SignInPage(driver);
		return signInPage.getErrorPasswordMessage();
	}

	public void inputPasswordWithoutNumbers() {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.openPage();
		signInPage.fillIncorrectPasswordWithoutNumbersInFormToCreateNewAccount();
	}


	public String getHeading() {
		WelcomePage welcomePage = new WelcomePage(driver);
		return welcomePage.getHeadingText();
	}

	public void inputCorrectData() {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.openPage();
		signInPage.fillFormToCreateNewAccountCorrectly();
		signInPage.clickOnSubmitButton();
	}
}
