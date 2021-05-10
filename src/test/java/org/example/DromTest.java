package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DromTest {

    public static SelectAutoPage selectAutoPage;
    public static LoginPage loginPage;
    public static SelectedCarPage selectedCarPage;
    public static FavoritesPage favoritesPage;

    @Test

    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("test_page"));

        selectAutoPage = new SelectAutoPage(driver);
        loginPage = new LoginPage(driver);
        selectedCarPage = new SelectedCarPage(driver);
        favoritesPage = new FavoritesPage(driver);

        selectAutoPage.enter_login_page();
        loginPage.login();
        selectAutoPage.select_auto();
        String carNameInCarPage = selectedCarPage.read_car_name();
        selectedCarPage.add_to_favorites();
        Thread.sleep(3000);//����� ������� ������ "�������� � ���������" ���������� �������� ����� ��������� � "���������"
        driver.get(ConfProperties.getProperty("favorites_page"));
        Assert.assertTrue(favoritesPage.adding_validation(carNameInCarPage));//�������� �� ������������ ����������
        favoritesPage.remove_car_from_favorites(); //�������� ������ �� ����������, �� ������ ���������� ������� �����
        driver.quit();
    }
}
