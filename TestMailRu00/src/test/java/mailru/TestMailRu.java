package mailru;

import io.qameta.allure.Feature;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static helpers.Properties.mainProperties;

/**
 * Класс для реализации тестирования сайта Mail.ru В соответствии с описанием в файле Task в корне проекта.
 * Драйвер браузера хром берётся по адресу, прописанному в переменной среды CHROME_DRIVER. Это задано в проперти файле.
 */
public class TestMailRu extends BaseTest {
    /**
     * Метод открывает сайт мейл ру, логинится в нём по учётным данным, предоставленным через .properties файл,
     * создаёт письмо, получает адрес получателя и текст с помощью метода, указанного для @MethdSource,
     * отправляет письмо.
     *
     * @param address куда посылаем письмо
     * @param text    текст посылаемого письма
     */
    @Feature("Проверяю отправку письма")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @MethodSource("getEmailsAndTexts")
    public void checkMailSending(String address, String text) {
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
        mrmbcepo.composeAndSendAnEmail(address, text);
    }

    /**
     * Метод возвращает стрим аргументов для тестового метода. Тест запустится столько раз,
     * сколько аргументов выдаст этот метод.
     *
     * @return
     */
    private static Stream<Arguments> getEmailsAndTexts() {
        return Stream.of(
                Arguments.of("student15@inbox.ru", "Привет, студент!")
                //, Arguments.of("grerdfvsgerfew@mail.ru", "Здравствуй, незнакомец!")
        );
    }
}
