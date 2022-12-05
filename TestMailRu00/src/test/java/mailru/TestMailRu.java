package mailru;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static properties.Properties.mainProperties;

/**
 * Класс для реализации тестирования сайта Mail.ru В соответствии с описанием в файле Task в корне проекта.
 * Драйвер браузера хром берётся по адресу, прописанному в переменной среды CHROME_DRIVER. Это задано в проперти файле.
 */
public class TestMailRu extends BaseTest {
    /**
     *
     * @throws InterruptedException
     */
    @Test
    public void checkMailSending() throws InterruptedException {
        chromedriver.get(mainProperties.baseUrl());
        MailRuMainPageObject mmpo = new MailRuMainPageObject(chromedriver);
        mmpo.pressMailButton();
        ArrayList<String> newTab = new ArrayList<>(chromedriver.getWindowHandles());
        chromedriver.switchTo().window(newTab.get(1));
        MailRuAccountPageObject mrapo = new MailRuAccountPageObject(chromedriver);
        mrapo.enterMailAddressAndPressEnter();
        mrapo.enterPasswordAndPressEnter();
        MailRuMailBoxPageObject mrmbpo = new MailRuMailBoxPageObject(chromedriver);
        mrmbpo.pressNewEmailButton();
        MailRuMailBoxComposingEmailPageObject mrmbcepo = new MailRuMailBoxComposingEmailPageObject(chromedriver);
        mrmbcepo.composeAndSendAnEmail();
       // Thread.sleep(3000000);

    }
}
