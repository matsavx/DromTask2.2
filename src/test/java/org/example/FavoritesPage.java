package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FavoritesPage {
    WebDriver driver;

    public FavoritesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//*[@id=\"bulletinId\"]/div[2]/div[1]/a")
    private WebElement carNameString;

    @FindBy (xpath = "//*[@id=\"outerLayout\"]/div[3]/form/table/tbody/tr/td/div/div/div[3]/div[2]/div/a")
    private WebElement removeBnt;

    public boolean adding_validation(String carNameInCarPage) {
        String carNameInFavorites = carNameString.getText();
        return carNameInFavorites.equals(carNameInCarPage);
    }

    public void remove_car_from_favorites() {
        removeBnt.click();
    }
}
