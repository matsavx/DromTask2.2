package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//*[@id=\"sign\"]")
    private WebElement loginField;

    @FindBy (xpath = "//*[@id=\"password\"]")
    private WebElement passwordField;

    @FindBy (xpath = "//*[@id=\"signbutton\"]")
    private WebElement enterBtn;

    public void login() {
        loginField.sendKeys(ConfProperties.getProperty("login"));
        passwordField.sendKeys(ConfProperties.getProperty("password"));
        enterBtn.click();
    }

}
