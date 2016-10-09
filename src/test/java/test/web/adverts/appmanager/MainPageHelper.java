package test.web.adverts.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Vlad on 05.10.2016.
 */
public class MainPageHelper extends HelperBase{

    public MainPageHelper (WebDriver wd) {
        super(wd);
    }

    public void changeLanguage() {
        click(By.cssSelector("a[href*='/ru/']"));
    }

    public void goToElectroTechnics(){
        click(By.linkText("Электротехника"));
    }
}
