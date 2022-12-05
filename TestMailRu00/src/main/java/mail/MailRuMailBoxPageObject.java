package mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailRuMailBoxPageObject {
    WebDriver chromedriver;
    public MailRuMailBoxPageObject(WebDriver wd){
        chromedriver=wd;
    }

    /**
     * Нажимаем кнопку написания нового письма
     */
    public void pressNewEmailButton(){
//        WebDriverWait wait = new WebDriverWait(chromedriver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/compose/']")));
        chromedriver.findElement(By.xpath("//div[contains(@class,'ph-project-promo-close-icon')]")).click();
        chromedriver.findElement(By.xpath("//a[@href='/compose/']")).click();
    }
}
