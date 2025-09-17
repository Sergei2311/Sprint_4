import org.junit.Test;

public class TestDownBattonOrder extends BaseTest {

    // Проверка нижней кнопки Заказать.ОР - открытое окно бланка заказа с кнопкой Далее
    @Test
    public void testDownButtonOrderSamokatMainPage() {
        samokatMainPage.openPage();  //открыть страницу самоката
        samokatMainPage.pressOrderDownButton();  //нажать на нижнюю кнопку Заказать
        pageOrder.displeidBattonNextStatus();   //в открывшемся окне отображается кнопка Далее
    }
}
