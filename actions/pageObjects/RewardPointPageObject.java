package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class RewardPointPageObject extends BasePage {
    public RewardPointPageObject(WebDriver driver) {
        this.driver = driver;
    } // // khi generate hàm này tự lên đầu vì nó sẽ chạy trước private WebDriver driver ở sau cũng dc

    private WebDriver driver;


}
