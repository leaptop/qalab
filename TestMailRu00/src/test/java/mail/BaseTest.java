package mail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.alexeev.Properties.mainProperties;

/**
 * Базовый класс для запуска тестов. Здесь инициализируется драйвер веб браузера, указывается поведение перед
 * каждым тестом и после каждого теста.
 *
 * @author Степан Алексеев
 */
public class BaseTest {
    /**
     * Основной веб драйвер для всех классов потомков
     *
     * @author Степан Алексеев
     */
    public WebDriver chromedriver;

    /**
     * Метод для запуска перед каждым тестом. Назначает откуда брать драйвер браузера, задаёт начальное состояние
     * браузера, устанавливает таймауты.
     *
     * @author Степан Алексеев
     */
    @BeforeEach
    public void beforeEach() {

        System.setProperty(mainProperties.browser(), System.getenv(mainProperties.driver()));
        chromedriver = new ChromeDriver();
       // chromedriver = new OverridenChromeDriver();
        chromedriver.manage().deleteAllCookies();
        chromedriver.manage().window().maximize();
        chromedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromedriver.manage().timeouts().pageLoadTimeout(mainProperties.defaultTimeout30(), TimeUnit.SECONDS);
        chromedriver.manage().timeouts().setScriptTimeout(mainProperties.defaultTimeout30(), TimeUnit.SECONDS);
    }

    /**
     * Метод запускается после каждого теста.
     * Закрывает браузер и завершает тест.
     *
     * @author Степан Алексеев
     */
    @AfterEach
    public void closeBellTest() {
        chromedriver.quit();
        //chromedriver.manage().deleteAllCookies();
    }
}
