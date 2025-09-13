package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SamokatMainPage {
    public WebDriver driver;
    // Кнопка закрытия куки
    public By kuki = By.id("rcc-confirm-button");
    //  Верхняя кнопка "Заказать"
    public By orderUpButton = By.className("Button_Button__ra12g");
    //  Нижняя кнопка "Заказать"
    public By orderDownButton = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text()='Заказать']");
    //Задаем время ожидания
    int waitTime = 3;
    Duration duration = Duration.ofSeconds(waitTime);
    public SamokatMainPage(WebDriver driver) {
        this.driver = driver;
    }

    //открыть страницу с сервисом самоката
    public void openPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, duration).until(ExpectedConditions.urlToBe("https://qa-scooter.praktikum-services.ru/"));
    }

    // Нажатие на верхнюю кнопку "Заказать"
    public void pressOrderUpButton() {
        driver.findElement(kuki).click();
        driver.findElement(orderUpButton).click();
    }

    // Скролл до нижней кнопки и нажать на кнопку "Заказать"
    public void pressOrderDownButton() {
        driver.findElement(kuki).click();
        WebElement element = driver.findElement(orderDownButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(orderDownButton));
        driver.findElement(orderDownButton).click();
    }

    // Убрать куки
    public void kuki() {
        driver.findElement(kuki).click();
        new WebDriverWait(driver, duration);
    }

    //Метод Получение ответа на воарос.(скрол до вопроса, нажатие на вопрос, найти ответ и вернуть текст ответа)
    public String scrollPushQuestionReadAnswer(String question, String answer) {
        By questionLokator = By.xpath(String.format("//div[contains(text(), '%s')]", question));
        WebElement elementQuestion = driver.findElement(questionLokator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementQuestion);
        elementQuestion.click();
        new WebDriverWait(driver, duration);
        By answerLocator = By.xpath(String.format("//p[contains(text(), '%s')]", answer));
        WebElement elementAnswer = driver.findElement(answerLocator);
        return elementAnswer.getText();
    }


}
