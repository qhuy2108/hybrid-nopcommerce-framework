package enviromentFactory;

import com.sun.jna.WString;
import commons.BrowserList;
import browserFactory.ChormeDriverManager;
import browserFactory.EdgeDriverManager;
import browserFactory.FirefoxDriverManager;
import browserFactory.HeadlessChormeDriverManager;
import org.openqa.selenium.WebDriver;

public class LocalEnviromentFactory implements EnviromentFactory{
    private WebDriver driver;
    private String browserName;

    public LocalEnviromentFactory(String browserName) {
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
