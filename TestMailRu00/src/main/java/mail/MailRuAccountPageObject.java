package mail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import static org.alexeev.Properties.mainProperties;
public class MailRuAccountPageObject {
    WebDriver chromedriver;

    public MailRuAccountPageObject(WebDriver wd) {
        chromedriver = wd;
    }
    /**
     * Вводим пароль. Жмём Enter.
     */
    public void enterPasswordAndPressEnter(){
        chromedriver.findElement(By.xpath("//input[@name='password']")).sendKeys(
                mainProperties.mailpass() + Keys.ENTER
        );
    }
    /**
     * Вводим имя пользователя. Жмём Enter
     */
    public void enterMailAddressAndPressEnter(){
    chromedriver.findElement(By.xpath("//input[@name='username']")).sendKeys(
            mainProperties.mailaddress()+ Keys.ENTER
    );    //input[@name='username']
    }
}
