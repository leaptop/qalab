package mailru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Класс для страницы, откырваемой по адресу https://mail.ru/.
 *
 * По идее можно также создать базовый класс для всех остальных классов мейлру, т.к. сверху есть единое для
 * всех страниц меню с кнопками "Mail.ru Почта Облако Одноклассники ...".
 */
public class MailRuMainPageObject {
    WebDriver chromedriver;

    public MailRuMainPageObject(WebDriver wd) {
        chromedriver = wd;
    }
    /**
     * Нажимаем кнопку "Почта"
     */
    @Step
    public void pressMailButton(){
        chromedriver.findElement(By.xpath("//a[@data-testid='logged-out-email']")).click();
    }
}
