package commons;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
private WebDriver driver;


    protected WebDriver getBrowserDriver(String browserName){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

        switch (browserList){
            case FIREFOX:
                String profilePath = "C:/Users/Quanghuy/AppData/Roaming/Mozilla/Firefox/Profiles/HuyTest";  // Sửa lại đường dẫn cho đúng
                FirefoxProfile profile = new FirefoxProfile(new java.io.File(profilePath));
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(profile);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--user-data-dir=C:/Users/QuangHuy/AppData/Local/Microsoft/Edge/User Data/");
                edgeOptions.addArguments("--profile-directory=Profile 1");
                driver = new EdgeDriver(edgeOptions);
                break;
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--user-data-dir=C:/Users/QuangHuy/AppData/Local/Google/Chrome/User Data/");
                chromeOptions.addArguments("--profile-directory=Profile 1");
                driver = new ChromeDriver(chromeOptions);
                break;
            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().setSize(new Dimension(1600,900));
        driver.get("https://demo.nopcommerce.com/");
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String url){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

        switch (browserList){
            case FIREFOX:
                String profilePath = "C:/Users/Quanghuy/AppData/Roaming/Mozilla/Firefox/Profiles/HuyTest";  // Sửa lại đường dẫn cho đúng
                FirefoxProfile profile = new FirefoxProfile(new java.io.File(profilePath));
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(profile);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--user-data-dir=C:/Users/QuangHuy/AppData/Local/Microsoft/Edge/User Data/");
                edgeOptions.addArguments("--profile-directory=Profile 1");
                driver = new EdgeDriver(edgeOptions);
                break;
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--user-data-dir=C:/Users/QuangHuy/AppData/Local/Google/Chrome/User Data/");
                chromeOptions.addArguments("--profile-directory=Profile 1");
                driver = new ChromeDriver(chromeOptions);
                break;
            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().setSize(new Dimension(1600,960));
        driver.get(url);
        return driver;
    }




    public int getRandomNumber() {
        return new Random().nextInt(9999);
    }
    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
