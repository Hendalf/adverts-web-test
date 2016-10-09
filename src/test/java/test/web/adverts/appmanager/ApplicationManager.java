package test.web.adverts.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Vlad on 05.10.2016.
 */
public class ApplicationManager {


    private final Properties properties;
    private NavigationHelper navigationHelper;
    private MainPageHelper mainPageHelper;
    private SearchHelper searchHelper;
    WebDriver wd;

    public ApplicationManager() {
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        System.setProperty("webdriver.chrome.driver", properties.getProperty("web.driver.chromeDriver"));
        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get(properties.getProperty("web.baseUrl"));
        navigationHelper = new NavigationHelper(wd);
        mainPageHelper = new MainPageHelper(wd);
        searchHelper = new SearchHelper(wd);
    }

    public void stop() {
        wd.quit();
    }
    public NavigationHelper goTo() {
        return navigationHelper;
    }
    public MainPageHelper mainPage() { return mainPageHelper; }
    public SearchHelper search() { return searchHelper; }
}
