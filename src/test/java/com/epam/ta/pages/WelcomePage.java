package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends AbstractPage {
    private final String BASE_URL = "https://github.com/join/plan";

    @FindBy(xpath = "//h1[contains(text(), 'Welcome to GitHub')]")
    private WebElement heading;

    public WelcomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public String getHeadingText() {
        return heading.getText();
    }
}
