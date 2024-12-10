package javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class Topic_02_Loop {          // khong cho class khac ke thua no

    public static final String PI = "3.14"; // final khong cho phep gan lai gia tri moi

    public final void clickToElement() {    // Khong cho cac class khac OVERIDE lai

    }

    public static void clickToButton() throws InterruptedException {
        Thread.sleep(500);
    }

    //throws
    //throw         su dung o try catch





    public static void main(String[] args) throws InterruptedException {
        Topic_02_Loop topic02Loop = new Topic_02_Loop();
        topic02Loop.clickToElement();       // Can phai khoi tao doi tuong topic02Loop
        topic02Loop.isElementDisplayed();


        // Khi goi 1 ham co throws InterruptedException thi no yeu cau phai throws ham chua no
        Topic_02_Loop.clickToButton();      // Khong can khoi tao doi tuong topic02Loop
        System.out.println(Topic_02_Loop.PI);


        System.out.println("For");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        System.out.println("While");
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }

        System.out.println("Do While");
        i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 10);

    }

    public boolean isElementDisplayed() {
        WebDriver driver = new FirefoxDriver();
        WebElement element = driver.findElement(By.cssSelector(""));
        boolean status = false;
        try {
            status = element.isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally { // step bat buoc phai chay
            // close ket noi vao data / clear du lieu ....
        }
        return status;
    }

}
