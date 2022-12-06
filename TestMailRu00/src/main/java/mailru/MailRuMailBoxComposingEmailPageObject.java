package mailru;

import io.qameta.allure.Step;
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
     *
     * @param address электронный адрес получателя
     * @param text текст отправляемого письма
     */
    @Step("Составляю письмо и шлю его")
    public void composeAndSendAnEmail(String address, String text) {
        chromedriver.findElement(By.xpath(
                        "//div[contains(@class,'contactsContainer')]//input[contains(@class, 'container') and @type='text']"))
                .sendKeys(address);
        chromedriver.findElement(By.xpath(
                        "//div[@class='focus-zone focus-zone_fluid']//div[contains(@class,'editable-container')]/div[@contenteditable='true']/div[1]"))
                .sendKeys(text + Keys.LEFT_CONTROL + Keys.ENTER);
    }
}
