package mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailRuMainPageObject {
    WebDriver chromedriver;

    public MailRuMainPageObject(WebDriver wd) {
        chromedriver = wd;
    }
    /**
     * Нажимаем кнопку "Почта"
     */
    public void pressMailButton(){
        chromedriver.findElement(By.xpath("//a[@data-testid='logged-out-email']")).click();
    }

    /**
     * Нажимаем кнопку "Войти" на главной странице
     */
    public void pressEnterButton() {
        chromedriver.findElement(By.xpath("//button[@data-testid='enter-mail-primary']")).click();
    }
    /**
     * Вводим адрес почты и пароль из файла проперти
     */
    public void inputMailAndPass(){
        chromedriver.findElement(By.xpath("//input[@name='username']")).sendKeys("rrr");
    }
}
