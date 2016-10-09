package test.web.adverts.tests;

/**
 * Created by Vlad on 05.10.2016.
 */
import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import test.web.adverts.appmanager.ApplicationManager;

/**
 * Created by Vlad on 28.02.2016.
 */
public class TestBase {

    protected static final ApplicationManager app =
            new ApplicationManager();

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }


}