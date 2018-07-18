package com.epam.ta;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.ta.steps.Steps;

public class GitHubAutomationTest
{
	private Steps steps;
	private final String USERNAME = "testautomationuser";
	private final String PASSWORD = "Time4Death!";
	private final String EMAIL_ERROR_TEXT = "Email is invalid or already taken";
	private final String SHORT_PASSWORD_ERROR_TEXT = "Password is too short (minimum is 7 characters)";
	private final String PASSWORD_WITHOUT_NUMBERS_ERROR_TEXT = "needs at least one number";
	private final String WELCOME_HEADING_TEXT = "Welcome to GitHub";



	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

	@Test
	public void oneCanCreateProject()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertTrue(steps.createNewRepository("testRepo", "auto-generated test repo"));
		Assert.assertTrue(steps.currentRepositoryIsEmpty());
		// do not use lots of asserts
	}

	@Test(description = "Login to Github")
	public void oneCanLoginGithub()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedIn(USERNAME));
	}

	@Test(description = "Logout to Github")
	public void oneCanLogout()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		steps.logoutGitHub();
		Assert.assertTrue(steps.isSignUpForGitHubDisplayed());
	}

	@Test(description = "Sign up with correct random password, email and username")
	public void signUpCorrectData() {
		steps.inputCorrectData();
		Assert.assertTrue(steps.getHeading().equalsIgnoreCase(WELCOME_HEADING_TEXT), "The heading is [" + steps.getHeading() + "]");
	}

	@Test(description = "Creating new account whit incorrect e-mail")
	public void createAccountWithIncorrectEmail()
	{
		steps.createRandomAccountWithIncorrectEmail();
		Assert.assertEquals(steps.getErrorEmailMessage(), EMAIL_ERROR_TEXT);
	}

	@Test(description = "Sign up with password length less than 7 symbols")
	public void signUpWithShortPassword() {
		steps.inputShortPassword();
		String errorMessage = (steps.getPasswordErrorMessage());
		Assert.assertTrue(errorMessage.contains(SHORT_PASSWORD_ERROR_TEXT), "Displayed error: [" + errorMessage + "]");
	}

	@Test(description = "Sign up with password length less than 7 symbols")
	public void signUpWithPasswordWithoutNumbers() {
		steps.inputPasswordWithoutNumbers();
		String errorMessage = (steps.getPasswordErrorMessage());
		Assert.assertTrue(errorMessage.contains(PASSWORD_WITHOUT_NUMBERS_ERROR_TEXT), "Displayed error: [" + errorMessage + "]");
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}

}
