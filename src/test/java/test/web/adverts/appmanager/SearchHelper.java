package test.web.adverts.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Vlad on 06.10.2016.
 */
public class SearchHelper extends HelperBase {
    private List<String> addsIds;

    public SearchHelper(WebDriver wd) {
        super(wd);
        addsIds = new ArrayList<>();
    }

    public void customSearch(String phraseToFind, double minCost, double maxCost, String typeOfDeal, String city, String period) throws InterruptedException {
        if (phraseToFind != null) {
            type(By.id("ptxt"), phraseToFind);
            TimeUnit.SECONDS.sleep(2);
            click(By.id("cmp_1"));
        }

        enterMinMaxCost(minCost, maxCost);

        if (typeOfDeal != null) {
            selectFromDropDown(By.name("sid"), typeOfDeal);
        }

        if (city != null) {
            selectFromDropDown(By.name("search_region"), city);
        }

        if (period != null) {
            selectPeriod(period);
        }
        click(By.id("sbtn"));
    }

    public void selectRandomAddsAndAddToMemo(){
        List<WebElement> addsList;
        addsList = wd.findElements(By.xpath(".//*[@id='page_main']/tbody/tr/td/table[2]/tbody/tr"));
        addsList.remove(0);

        int []randIds = generateRandomNumber(2, addsList.size());

        for (int i =0; i<3; i++){
            wd.findElement(By.xpath(".//*[@id='page_main']/tbody/tr/td/table[2]/tbody/tr["+randIds[i]+"]/td/input")).click();
            addsIds.add(i,wd.findElement(By.xpath(".//*[@id='page_main']/tbody/tr/td/table[2]/tbody/tr["+randIds[i]+"]")).getAttribute("id"));
        }

        System.out.println("*******************************************************************************");
        System.out.println(addsIds.size());
        for (String memo: addsIds) {
            System.out.println(memo);
        }

        click(By.id("a_fav_sel"));
    }

    public void openMemoAndCompareToSelected(){
        click(By.linkText("Закладки"));

        for (String memo: addsIds) {
            Assert.assertTrue(isElementPresent(By.id(memo)));
        }
    }

    public void selectPeriod(String period) throws InterruptedException {
        selectFromDropDown(By.name("pr"), period);
    }

    public void sortByPrice() {
        click(By.linkText("Цена"));
    }

    public void selectDealType(String dealType) {
        selectFromDropDown(By.xpath(".//*[@id='page_main']/tbody/tr/td/div[2]/span[3]/select"), dealType);
    }

    public void openAdvancedSearch() {
        click(By.linkText("Расширенный поиск"));
    }

    public void enterMinMaxCost(double minCost, double maxCost) {
        type(By.name("topt[8][min]"), Double.toString(minCost));
        type(By.name("topt[8][max]"), Double.toString(maxCost));
    }
}
