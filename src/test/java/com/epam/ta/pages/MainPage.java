package com.epam.ta.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
    private final String BASE_URL = "https://github.com/";

    @FindBy(xpath = "//a[contains(@aria-label, 'Create new')]")
    private WebElement buttonCreateNew;

    @FindBy(xpath = "//a[contains(text(), 'New repository')]")
    private WebElement linkNewRepository;

    @FindBy(xpath = "//*[@id='user-links']/li[3]/details/summary/img")
    private WebElement logoutImg;

    @FindBy(xpath = "//button[contains(text(), 'Sign out')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//button[contains(text(), 'Sign up for GitHub')]")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(), 'Sign up')]")
    private WebElement createAccountButton;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnCreateNewRepositoryButton() {
        buttonCreateNew.click();
        linkNewRepository.click();
    }

    public void clickOnLogoutImg() {
        logoutImg.click();
    }

    public void clickOnLogoutButton() {
        logoutButton.click();
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public boolean isSignedOut() {
        return loginButton.isDisplayed();
    }

    public void clickOnCreateAccount() {
        createAccountButton.click();
    }
}
