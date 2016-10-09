package test.web.adverts.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Vlad on 05.10.2016.
 */
public class NavigationHelper  extends HelperBase{

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void searchDialog(){
        click(By.linkText("Поиск"));
    }
}
