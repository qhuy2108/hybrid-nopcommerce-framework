package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AddressPageObject extends BasePage {
    public AddressPageObject(WebDriver driver) {
        this.driver = driver;
    } // // khi generate hàm này tự lên đầu vì nó sẽ chạy trước private WebDriver driver ở sau cũng dc

    private WebDriver driver;


}
