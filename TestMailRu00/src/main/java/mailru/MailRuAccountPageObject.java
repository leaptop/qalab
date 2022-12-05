package mailru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static properties.Properties.mainProperties;

/**
 * Класс, реализующий паттерн Page Object для страницы с вводом логина и пароля почты.
 */
public class MailRuAccountPageObject {
    WebDriver chromedriver;

    /**
     * Конструктор принимает драйвер для браузера.
     *
     * @param wd
     */
    public MailRuAccountPageObject(WebDriver wd) {
        chromedriver = wd;
    }

    /**
     * Вводим пароль. Жмём Enter.
     */
    @Step
    public void enterPasswordAndPressEnter() {
        chromedriver.findElement(By.xpath("//input[@name='password']")).sendKeys(
                mainProperties.mailpass() + Keys.ENTER
        );
    }

    /**
     * Вводим имя пользователя. Жмём Enter
     */
    @Step
    public void enterMailAddressAndPressEnter() {
        chromedriver.findElement(By.xpath("//input[@name='username']")).sendKeys(
                mainProperties.mailaddress() + Keys.ENTER
        );
    }
}
