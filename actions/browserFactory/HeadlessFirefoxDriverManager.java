package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessFirefoxDriverManager implements BrowserFactory{

    @Override
    public WebDriver getBrowserDriver() {
        FirefoxOptions hffOptions = new FirefoxOptions();
        hffOptions.addArguments("-headless");
        hffOptions.addArguments("window-size=1600x900");
        return new FirefoxDriver(hffOptions);
    }
}
