package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectAutoPage {
    public WebDriver driver;

    public SelectAutoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "/html/body/div[2]/div[2]/div[1]/div/div[3]")
    private WebElement loginBtn;

    @FindBy (xpath = "/html/body/div[2]/div[4]/div/div[3]")
    private WebElement selectAutoBtn;

    public void enter_login_page() {
        loginBtn.click();
    }

    public void select_auto() {
        selectAutoBtn.click();
    }
}
