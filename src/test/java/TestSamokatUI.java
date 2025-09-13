import org.junit.Test;
import page.BaseTest;

public class TestSamokatUI extends BaseTest {
    //Позитивный сценарий - нажимаем верхнюю кнопку Заказать, создаем заказ, подтверждение создания заказа
    @Test
    public void testUpButtonOrderSamokatMainPage() {
        samokatMainPage.openPage(); //открыть страницу самоката
        samokatMainPage.pressOrderUpButton();  //нажать верхнюю кнопку Заказать
        pageOrder.writeOrder("Сергей", "Иванов", "Мира,15", "Спортивная", "81112223344"); //заполнить бланк заказаа
        pageOrder.nextButtonClick(); //нажать кнопку Далее
        pageRent.writeRentPage(); //заполнить попап "Когда привезти самокат"
        pageRent.buttonOrderClick(); //нажать кнопку Заказать
        pageRent.buttonYesClick(); //Подтвердить заказ нажатием на кнопку "Да"
        pageRent.displeidButtonLookStatus(); // Проверить отображение кнопки статуса заказа
    }
    // Проверка нижней кнопки Заказать.ОР - открытое окно бланка заказа с кнопкой Далее
    @Test
    public void testDownButtonOrderSamokatMainPage() {
        samokatMainPage.openPage();  //открыть страницу самоката
        samokatMainPage.pressOrderDownButton();  //нажать на нижнюю кнопку Заказать
        pageOrder.displeidBattonNextStatus();   //в открывшемся окне отображается кнопка Далее
    }

}
