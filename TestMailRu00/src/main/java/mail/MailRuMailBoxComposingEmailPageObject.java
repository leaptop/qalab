package mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailRuMailBoxComposingEmailPageObject {
    WebDriver chromedriver;

    public MailRuMailBoxComposingEmailPageObject(WebDriver wd) {
        chromedriver = wd;
    }

    /**
     * Вводим адрес в адресную строку получателя
     */
    public void composeAnEmail() throws InterruptedException {
        chromedriver.findElement(By.xpath(
                        "//div[contains(@class,'contactsContainer')]//input[contains(@class, 'container') and @type='text']"))
                .sendKeys("student15@inbox.ru");
     //   Thread.sleep(5000000);
        chromedriver.findElement(By.xpath(
                "//div[@class='focus-zone focus-zone_fluid']//div[contains(@class,'editable-container')]/div[@contenteditable='true']/div[1]"))
                .sendKeys("Hi there.\n See you later alligator");
    }
}
