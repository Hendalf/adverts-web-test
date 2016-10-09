package test.web.adverts.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

/**
 * Created by Vlad on 05.10.2016.
 */
public class HelperBase {

    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null){
            String existingText = wd.findElement(locator).getAttribute("value");
            if (! text.equals(existingText)){
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }

    protected void selectFromDropDown(By locator, String text){
        WebElement dropDownListBox = wd.findElement(locator);
        Select clickThis = new Select(dropDownListBox);
        clickThis.selectByVisibleText(text);
    }

    protected boolean isElementPresent(By locator) {
        try{
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public int[] generateRandomNumber(int minNumber, int maxNumber){
        int [] randomIds = new int[3];

        Random rand = new Random();
        for (int i=0; i<3; i++){
            randomIds[i] = rand.nextInt(maxNumber-1) + minNumber;
        }
        return randomIds;
    }
}
