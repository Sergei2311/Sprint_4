import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.BaseTest;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestSamokatUIQuestionAnswer extends BaseTest {
    private final String answer;
    private final String question;

    public TestSamokatUIQuestionAnswer(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    // Массив вопрос-ответ
    @Parameterized.Parameters
    public static Object[][] getQuestionAndAnswer() {
        return new Object[][]{
                {"Сколько это стоит? И как оплатить?",
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Хочу сразу несколько самокатов! Так можно?",
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."}
        };
    }

    @Test
    public void testDropListImportantQuestions() {
        samokatMainPage.openPage(); //открыть страницу самоката
        samokatMainPage.kuki(); //убрать куки
        assertEquals(samokatMainPage.scrollPushQuestionReadAnswer(question, answer), answer);
    }
}
