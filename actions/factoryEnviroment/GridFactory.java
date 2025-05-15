package factoryEnviroment;

import commons.BrowserList;
import factoryBrowser.ChormeDriverManager;
import factoryBrowser.EdgeDriverManager;
import factoryBrowser.FirefoxDriverManager;
import factoryBrowser.HeadlessChormeDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class GridFactory {
    private WebDriver driver;
    private String browserName;

    public GridFactory(String browserName) {
        this.browserName = browserName;
    }

    public WebDriver createDriver () {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

        switch (browserList){
            case FIREFOX:
                driver = new FirefoxDriverManager().getBrowserDriver();
                break;

            case EDGE:
                driver = new EdgeDriverManager().getBrowserDriver();
                break;

            case CHROME:
                driver = new ChormeDriverManager().getBrowserDriver();
                break;

        // ------------------------------------------------------------------------------------------

            case HCHROME:
                driver = new HeadlessChormeDriverManager().getBrowserDriver();
                break;

            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().setSize(new Dimension(1600,900));
        driver.get("https://demo.nopcommerce.com/");
        return driver;
    }
}
