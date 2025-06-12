package browserFactory;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
        if(!GlobalConstants.OS_NAME.toUpperCase().startsWith("MAC")){
            throw new BrowserNotSupportedException("Safari is not supported on: " + GlobalConstants.OS_NAME);
        }
        SafariOptions safariOptions = new SafariOptions();
        return new SafariDriver(safariOptions);
    }
}
