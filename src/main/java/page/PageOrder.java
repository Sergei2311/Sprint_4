package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class PageOrder {
    public WebDriver driver;
    //поле Имя
    public By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //поле Фамилия
    public By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //поле Адрес
    public By adressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //поле Телефон
    public By telephoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //поле Метро выбор
    public By metroNameField = By.xpath(".//input[@placeholder='* Станция метро']");
    public By metroScroll = By.xpath(".//div[@class='select-search__select']");
    //локатор кнопки "Далее"
    public By nextButton = By.xpath(".//button[text() = 'Далее']");
    int waitTime = 10;
    Duration duration = Duration.ofSeconds(waitTime);

    public PageOrder(WebDriver driver) {
        this.driver = driver;
    }

    //заполнить поле "Имя"
    public void writeName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    //заполнить поле "Фамилия"
    public void writeSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    //заполнить поле "Адрес"
    public void writeAdress(String adress) {
        driver.findElement(adressField).sendKeys(adress);
    }

    //заполнить поле "Телефон"
    public void writePhone(String phone) {
        driver.findElement(telephoneField).sendKeys(phone);
    }

    //заполнить поле "Метро"
    public void writeMetro(String metro) {
        driver.findElement(metroNameField).sendKeys(metro);
        driver.findElement(metroScroll).click();
    }

    // шаг - заполнить карточку "Кому привезти самокат"
    public void writeOrder(String name, String surname, String adress, String metro, String phone) {
        writeName(name);
        writeSurname(surname);
        writeAdress(adress);
        writeMetro(metro);
        writePhone(phone);
    }

    // ждем и нажимаем на кнопку Далее
    public void nextButtonClick() {
        new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(nextButton));
        driver.findElement(nextButton).click();
    }

    //Проверка открытия окна заказа
    public void displeidBattonNextStatus() {
        new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(nextButton));
        assertTrue("Кнопка Далее отображается - ", driver.findElement(nextButton).isDisplayed());
    }
}
