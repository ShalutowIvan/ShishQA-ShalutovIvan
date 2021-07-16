package test1;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class FirstTest {

    @Test
public void test1() {
        System.setProperty ("webdriver.chrome.driver", "src/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
driver.get("https://www.google.ru/");

String tit = driver.getTitle();
     Assert.assertTrue(tit.equals("Google"));
        //Assert.assertEquals("Google"));
        driver.quit();
    }


}
