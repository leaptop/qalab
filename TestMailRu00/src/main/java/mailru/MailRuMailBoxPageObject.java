package mailru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Класс для страницы почты, в которую залогинились
 * (с кнопками перехода по папкам "отправленные", "спам" и т.п.).
 */
public class MailRuMailBoxPageObject {
    WebDriver chromedriver;
    public MailRuMailBoxPageObject(WebDriver wd){
        chromedriver=wd;
    }

    /**
     * Нажимаем кнопку написания нового письма.
     * Для этого приходится сначала закрыть всплывающее окно с рекламой, промо-акциями.
     */
    @Step
    public void pressNewEmailButton(){
        chromedriver.findElement(By.xpath("//div[contains(@class,'ph-project-promo-close-icon')]")).click();
        chromedriver.findElement(By.xpath("//a[@href='/compose/']")).click();
    }
}
