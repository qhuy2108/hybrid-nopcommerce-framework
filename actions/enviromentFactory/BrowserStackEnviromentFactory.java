package enviromentFactory;

import commons.GlobalConstants;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BrowserStackEnviromentFactory {
    private WebDriver driver;
    private String browserName;
    private String osName;
    private String osVersion;
    private String browserVersion;

    public BrowserStackEnviromentFactory(String browserName, String osName, String osVersion, String browserVersion) {
        this.browserName = browserName;
        this.osName = osName;
        this.osVersion = osVersion;
        this.browserVersion = browserVersion;
    }

    public WebDriver createDriver(){
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
        capabilities.setCapability("browserName", browserName);
        bstackOptions.put("os", osName);
        bstackOptions.put("osVersion", osVersion);
        bstackOptions.put("browserVersion", browserVersion);
        bstackOptions.put("userName", "huydoan_NvZoHw");
        bstackOptions.put("accessKey", "isyqFxAyLXLFs99dASAX");
        bstackOptions.put("consoleLogs", "info");
        bstackOptions.put("seleniumVersion", "4.2.2");
        bstackOptions.put("projectName", "Auto Browser Stack");
        bstackOptions.put("buildName", "automationfc");
        capabilities.setCapability("bstack:options", bstackOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL) , capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }
}
