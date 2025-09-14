import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.PageOrder;
import page.PageRent;
import page.SamokatMainPage;

public class BaseTest {
    public SamokatMainPage samokatMainPage;
    public PageOrder pageOrder;
    public PageRent pageRent;
    WebDriver driver;

    @Before
    public void startUp() {
        String browser = System.getProperty("browser", "chrome");
        if (browser.equals("chrome")) {
            startBrowseChrome();
        } else if (browser.equals("firefox")) {
            startBrowserFirefox();
        }
        samokatMainPage = new SamokatMainPage(driver);
        pageOrder = new PageOrder(driver);
        pageRent = new PageRent(driver);
    }

    public void startBrowserFirefox() {
        driver = new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
    }

    public void startBrowseChrome() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
