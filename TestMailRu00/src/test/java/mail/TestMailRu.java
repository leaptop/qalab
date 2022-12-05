package mail;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.alexeev.Properties.mainProperties;

/**
 * Класс для реализации тестирования сайта Mail.ru.
 */
public class TestMailRu extends BaseTest {

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
        //Thread.sleep(3000000);
        mrmbpo.pressNewEmailButton();
        MailRuMailBoxComposingEmailPageObject mrmbcepo = new MailRuMailBoxComposingEmailPageObject(chromedriver);
        mrmbcepo.composeAnEmail();
        Thread.sleep(3000000);

    }
}
