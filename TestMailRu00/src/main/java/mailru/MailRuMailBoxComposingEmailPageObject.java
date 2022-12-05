package mailru;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Класс для страницы почты с открытой формой написания электронного письма.
 */
public class MailRuMailBoxComposingEmailPageObject {
    WebDriver chromedriver;

    public MailRuMailBoxComposingEmailPageObject(WebDriver wd) {
        chromedriver = wd;
    }

    /**
     * Вводим адрес в адресную строку получателя.
     * Вводим текст сообщения.
     */
    @Step
    @DisplayName("Составляю письмо и шлю его")
    public void composeAndSendAnEmail() {
        chromedriver.findElement(By.xpath(
                        "//div[contains(@class,'contactsContainer')]//input[contains(@class, 'container') and @type='text']"))
                .sendKeys("student15@inbox.ru");
        chromedriver.findElement(By.xpath(
                        "//div[@class='focus-zone focus-zone_fluid']//div[contains(@class,'editable-container')]/div[@contenteditable='true']/div[1]"))
                .sendKeys("Hi there.\n See you later alligator 5" + Keys.LEFT_CONTROL + Keys.ENTER);
    }
}
