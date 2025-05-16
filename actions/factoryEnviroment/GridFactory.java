package factoryEnviroment;

import commons.BrowserList;
import factoryBrowser.ChormeDriverManager;
import factoryBrowser.EdgeDriverManager;
import factoryBrowser.FirefoxDriverManager;
import factoryBrowser.HeadlessChormeDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GridFactory implements EnviromentFactory {
    private WebDriver driver;
    private String browserName;
    private String ipAddress;
    private String portNumber;
    private String url;

    public GridFactory(String browserName, String ipAddress, String portNumber) {
        this.browserName = browserName;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
    }

    public WebDriver createDriver () {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        Capabilities capability = null;

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

        try {
            driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/", ipAddress, portNumber)), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}
