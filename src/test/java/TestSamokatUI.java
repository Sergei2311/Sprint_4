import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestSamokatUI extends BaseTest {
    private final String name;
    private final String surname;
    private final String adress;
    private final String metro;
    private final String phone;
    private final boolean displeidButtonLookStatus;

    public TestSamokatUI(String name, String surname, String adress, String metro, String phone, boolean displeidButtonLookStatus) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.metro = metro;
        this.phone = phone;
        this.displeidButtonLookStatus = displeidButtonLookStatus;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderInformation() {
        return new Object[][]{
                {"Сергей", "Иванов", "Мира, 15", "Спортивная", "81112223344", true},
                {"Иван", "Бубликов", "Чехова, 23", "Университет", "81112223355", true}
        };
    }

    //Позитивный сценарий - нажимаем верхнюю кнопку Заказать, создаем заказ, подтверждение создания заказа
    @Test
    public void testUpButtonOrderSamokatMainPage() {
        samokatMainPage.openPage(); //открыть страницу самоката
        samokatMainPage.pressOrderUpButton();  //нажать верхнюю кнопку Заказать
        pageOrder.writeOrder(name, surname, adress, metro, phone); //заполнить бланк заказаа
        pageOrder.nextButtonClick(); //нажать кнопку Далее
        pageRent.writeRentPage(); //заполнить попап "Когда привезти самокат"
        pageRent.buttonOrderClick(); //нажать кнопку Заказать
        pageRent.buttonYesClick(); //Подтвердить заказ нажатием на кнопку "Да"
        assertEquals("Сообщение об ошибке", pageRent.displeidButtonLookStatus(), displeidButtonLookStatus);
    }
}
