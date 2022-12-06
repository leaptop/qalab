package helpers;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.SessionId;

import java.io.ByteArrayInputStream;

/**
 * Переопределяю класс ChromeDriver, чтобы получить доступ к методу log из RemoteWebDriver (ChromeDriver расширяет
 * RemoteWebDriver). Метод log вызывается до и после каждого события.
 *
 * @author Алексеев Степан от 06.12.2022.
 */
public class OverridenChromeDriver extends ChromeDriver {

    /**
     * Переопределил этот метод из RemoteWebDriver чтобы в нём вызывать прикрепление скриншота к аллюр-отчёту.
     * Метод может уходить в бесконечную рекурсию, вызывая сам себя при вызове скриншотирования, поэтому отключил этот
     * вызов в самом начале по слову screenshot. Также после вызова quit() вебдрайвер начинает завершать работу и
     * скриншотирование становится невозможным, поэтому по команде quit тоже отключаю вызов метода. Если сессия ещё
     * не началась, то тоже не получится сделать скриншот.
     *
     * @param sessionId   the session id.
     * @param commandName the command that is being executed.
     * @param toLog       any data that might be interesting.
     * @param when        verb tense of "Execute" to prefix message
     * @author Алексеев Степан
     */
    @Override
    protected void log(SessionId sessionId, String commandName, Object toLog, When when) {
        if (commandName.equals("screenshot") || commandName.equals("quit") || getSessionId() == null) {
            return;
        }
        Allure.addAttachment(when + " " + commandName
                , new ByteArrayInputStream(((TakesScreenshot) this).getScreenshotAs(OutputType.BYTES)));
    }
}
