package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageRent {
    public WebDriver driver;
    //Поле "Когда привезти самокат" с датой календаря
    public By fieldDateDeliveryScooter = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    public By dateSelectCalendar = By.xpath("//div[contains(@class, 'react-datepicker__day--028')]");
    //Поле "Срок аренды" и выбор значения "Сутки"
    public By fieldRentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");
    public By rentalPeriod = By.xpath(".//div[@class='Dropdown-menu']/div[1]");
    //Чекбокс цвета самоката
    public By colourScooter = By.id("black");
    // Комментарий- не обязательное поле
    public By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка "Заказать"
    public By buttonOrder = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text()='Заказать']");
    // Кнопка "Да" (подтверждение заказа)
    public By buttonYesOrder = By.xpath(".//button[ text()=\"Да\"]");
    //Кнопка "Посмотреть статус"
    public By buttonLookStatus = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text()='Посмотреть статус']");
    int waitTime = 3;
    Duration duration = Duration.ofSeconds(waitTime);

    public PageRent(WebDriver driver) {
        this.driver = driver;
    }

    //Метод для заолнения карточки заказа "Про аренду"
    public void writeRentPage() {
        driver.findElement(fieldDateDeliveryScooter).click();  //нажатие на поле "Когда привезти самокат"
        driver.findElement(dateSelectCalendar).click();  // нажатие на дату календаря
        driver.findElement(fieldRentalPeriod).click();   // нажатие на поле "Срок аренды"
        driver.findElement(rentalPeriod).click();   //нажатие на "сутки"
        driver.findElement(colourScooter).click();  // чекбокс на "Черный"
        driver.findElement(comment).sendKeys("Получилось");  //необязательное заполнение поля комментарий
    }

    //Ждем появления кнопки Заказать и нажимаем на нее
    public void buttonOrderClick() {
        new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(buttonOrder));
        driver.findElement(buttonOrder).click();
    }

    //Ждем появления кнопки подтверждения "Да", нажимаем на нее
    public void buttonYesClick() {
        new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(buttonYesOrder));
        driver.findElement(buttonYesOrder).click();
    }

    //Проверяем в окне "Заказ оформлен" наличие кнопки "Посмотреть статус"
    public boolean displeidButtonLookStatus() {
        new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(buttonLookStatus));
        return driver.findElement(buttonLookStatus).isDisplayed();
    }

}
