package factoryEnviroment;

import commons.BrowserList;
import commons.GlobalConstants;
import factoryBrowser.ChormeDriverManager;
import factoryBrowser.EdgeDriverManager;
import factoryBrowser.FirefoxDriverManager;
import factoryBrowser.HeadlessChormeDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class SaucelabFactory {
    private WebDriver driver;
    private String browserName;
    private String osName;
    private String browser_version;

    public SaucelabFactory(String browserName, String osName, String browser_version) {
        this.browserName = browserName;
        this.osName = osName;
        this.browser_version = browser_version;
    }

    public WebDriver createDriver () {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, String> sauceOptions = new HashMap<String, String>();

        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPlatformName(osName);
                firefoxOptions.setBrowserVersion(browser_version);
                capabilities = firefoxOptions;
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPlatformName(osName);
                edgeOptions.setBrowserVersion(browser_version);
                capabilities = edgeOptions;
                break;
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPlatformName(osName);
                chromeOptions.setBrowserVersion(browser_version);
                capabilities = chromeOptions;
                break;
            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        sauceOptions.put("username", GlobalConstants.SAUCELAB_USERNAME);
        sauceOptions.put("accessKey", GlobalConstants.SAUCELAB_ACCESS_KEY);
        sauceOptions.put("build", "<automate-testing>");
        sauceOptions.put("name", "Run on" + osName + " | " + browserName + " | " + browser_version);
        capabilities.setCapability("sauce:options", sauceOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.SAUCELAB_URL) , capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }
}
