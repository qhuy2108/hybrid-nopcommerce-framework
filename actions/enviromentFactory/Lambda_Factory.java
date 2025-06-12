package enviromentFactory;

import commons.BrowserList;
import commons.GlobalConstants;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;

public class Lambda_Factory implements EnviromentFactory {
    private WebDriver driver;
    private String browserName;
    private String osName;
    private String browser_version;

    public Lambda_Factory(String browserName, String osName, String browser_version) {
        this.browserName = browserName;
        this.osName = osName;
        this.browser_version = browser_version;
    }

    public WebDriver createDriver () {
        MutableCapabilities capability = null;
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

        switch (browserList) {
            case FIREFOX:
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setPlatformName(osName);
                fOptions.setBrowserVersion(browser_version);
                capability = fOptions;
                break;
            case CHROME:
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.setPlatformName(osName);
                cOptions.setBrowserVersion(browser_version);
                capability = cOptions;
                break;
            case EDGE:
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.setPlatformName(osName);
                eOptions.setBrowserVersion(browser_version);
                capability = eOptions;
                break;
            case SAFARI:
                SafariOptions sOptions = new SafariOptions();
                sOptions.setPlatformName(osName);
                sOptions.setBrowserVersion(browser_version);
                capability = sOptions;
                break;
            default:
                throw new RuntimeException("Browser is not valid!");
        }

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

        HashMap<String, Object> lambdaOptions = new HashMap<String, Object>();
        lambdaOptions.put("username", GlobalConstants.LAMBDA_USERNAME);
        lambdaOptions.put("accessKey", GlobalConstants.LAMBDA_AUTOMATE_KEY);
        lambdaOptions.put("visual", true);
        lambdaOptions.put("video", true);
        lambdaOptions.put("build", "nopcommerce-build");
        lambdaOptions.put("project", "NopCommerce - UI Automation Testing");
        lambdaOptions.put("name", "Run on " + osName + " | " + browserName + " | " + browser_version + " | " + formater.format(calendar.getTime()));
        lambdaOptions.put("w3c", true);
        lambdaOptions.put("selenium_version", "4.23.0");
        lambdaOptions.put("resolution", "1920x1080");
        lambdaOptions.put("plugin", "java-testNG");

        capability.setCapability("LT:Options", lambdaOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.LAMBRA_URL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        return driver;
    }
}
