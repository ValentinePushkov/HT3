package com.epam.ta.pages;

import com.epam.ta.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends AbstractPage {
    private final String BASE_URL = "https://github.com/join";

    @FindBy(xpath = "//form[@id='signup-form']")
    private WebElement formToCreateNewAccount;

    @FindBy(xpath = "//button[@type='submit' and text()='Create an account']")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@id='user_login']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='user_email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='user_password']")
    private WebElement password;

    @FindBy(xpath = "//*[@id='signup-form']/dl[2]/dd[2]")
    private WebElement emailErrorText;

    @FindBy(xpath = "//form[@id='signup-form']/dl[3]/dd[2]")
    private WebElement passwordErrorText;

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public void fillUsernameInFormToCreateNewAccount() {
        username.sendKeys(Utils.getRandomString(5));
    }

    public void fillCorrectEmailInFormToCreateNewAccount() {
        email.sendKeys(Utils.getRandomString(5) + "@" + Utils.getRandomString(5) + "." + Utils.getRandomString(2));
    }

    public void fillIncorrectEmailInFormToCreateNewAccount() {
        email.sendKeys(Utils.getRandomString(5));
    }

    public void fillCorrectPasswordFormToCreateNewAccount() {
        password.sendKeys("a" + Utils.getRandomLettersLine(5) + Utils.getRandomNumberLine(5));
    }


    public void fillIncorrectPasswordWithoutNumbersInFormToCreateNewAccount() {
        password.sendKeys("a" + Utils.getRandomLettersLine(10));
    }

    public void fillIncorrectPasswordWithoutLettersInFormToCreateNewAccount() {
        password.sendKeys(Utils.getRandomNumberLine(10));
    }

    public void fillIncorrectShortPasswordInFormToCreateNewAccount() {
        password.sendKeys("a" + Utils.getRandomString(5));
    }

    public void fillFormToCreateNewAccountCorrectly() {
       fillUsernameInFormToCreateNewAccount();
       fillCorrectEmailInFormToCreateNewAccount();
       fillCorrectPasswordFormToCreateNewAccount();
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public String getErrorEmailMessage() {
        return emailErrorText.getText();
    }

    public String getErrorPasswordMessage() {
        return passwordErrorText.getText();
    }
}
