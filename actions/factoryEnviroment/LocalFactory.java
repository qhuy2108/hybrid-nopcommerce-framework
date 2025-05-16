package factoryEnviroment;

import commons.BrowserList;
import factoryBrowser.ChormeDriverManager;
import factoryBrowser.EdgeDriverManager;
import factoryBrowser.FirefoxDriverManager;
import factoryBrowser.HeadlessChormeDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LocalFactory implements EnviromentFactory{
    private WebDriver driver;
    private String browserName;

    public LocalFactory (String browserName) {
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
                throw new RuntimeException(browserName);
        }

        return driver;
    }
}
