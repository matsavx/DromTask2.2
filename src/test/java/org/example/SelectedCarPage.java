package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectedCarPage {
    public WebDriver driver;

    public SelectedCarPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "/html/body/div[2]/div[3]/div[2]/div/div")
    private WebElement addToFavoritesBtn;

    @FindBy (xpath = "/html/body/div[2]/div[3]/div[2]/h1")
    private WebElement mainText;

    @FindBy (xpath = "/html/body/div[2]/div[2]/div[1]/div/div[3]/div[1]/div[2]/div/a[2]/div")
    private WebElement favoritesBtn;

    public void add_to_favorites() {
        addToFavoritesBtn.click();
    }

    public String read_car_name() {
        String text = mainText.getText();
        return text.substring(text.indexOf(" ") + 1, text.indexOf(",") + 6);
    }
}
