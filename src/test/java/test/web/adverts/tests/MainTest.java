package test.web.adverts.tests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Vlad on 05.10.2016.
 */
public class MainTest  extends TestBase{

    @Test
    public void testContactAddress() throws InterruptedException {
        app.mainPage().changeLanguage();
        app.mainPage().goToElectroTechnics();
        app.goTo().searchDialog();
        app.search().customSearch("Computer", 0.99, 100000.99, null, "Рига", "За последний месяц");
        app.search().sortByPrice();
        app.search().selectDealType("Продажа");
        app.search().openAdvancedSearch();
        app.search().customSearch(null, 160, 300, "Продают", null, "За последний месяц");
        app.search().selectRandomAddsAndAddToMemo();
        app.search().openMemoAndCompareToSelected();
    }
}
