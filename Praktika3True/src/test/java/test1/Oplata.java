//package test1;
//import java.util.concurrent.TimeUnit;
//import org.junit.*;
//import static org.junit.Assert.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

//public class Oplata {
  //  private WebDriver driver;
    //private String baseUrl;
  //  private boolean acceptNextAlert = true;
  //  private StringBuffer verificationErrors = new StringBuffer();

package test1;

import java.io.File;
import java.time.Duration;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Oplata {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty ("webdriver.chrome.driver", "D:\\Git_Shalutov\\ShishQA-ShalutovIvan\\Praktika3True\\src\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://sandbox.cardpay.com/MI/cardpayment2.html?orderXml=PE9SREVSIFdBTExFVF9JRD0nODI5OScgT1JERVJfTlVNQkVSPSc0NTgyMTEnIEFNT1VOVD0nMjkxLjg2JyBDVVJSRU5DWT0nRVVSJyAgRU1BSUw9J2N1c3RvbWVyQGV4YW1wbGUuY29tJz4KPEFERFJFU1MgQ09VTlRSWT0nVVNBJyBTVEFURT0nTlknIFpJUD0nMTAwMDEnIENJVFk9J05ZJyBTVFJFRVQ9JzY3NyBTVFJFRVQnIFBIT05FPSc4NzY5OTA5MCcgVFlQRT0nQklMTElORycvPgo8L09SREVSPg==&sha512=998150a2b27484b776a1628bfe7505a9cb430f276dfa35b14315c1c8f03381a90490f6608f0dcff789273e05926cd782e1bb941418a9673f43c47595aa7b8b0d";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    @Test
    public void test0() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("1");
        driver.findElement(By.id("card-number-field")).click();
        driver.findElement(By.id("payment-data")).click();
        // Проверка есть ли текст ошибки при вводе не корректного номера карты
        assertEquals("Card number is not valid", driver.findElement(By.xpath("//*[@id='card-number-field']/div/label")).getText());

        // driver.quit();

            }


    @Test
    public void test1() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0002");
        driver.findElement(By.id("card-number-field")).click();
        driver.findElement(By.id("payment-data")).click();
      // Проверка названия вкладки Title
        String titl = driver.getTitle();
        Assert.assertTrue(titl.equals("Unlimint Payment Page"));
                driver.findElement(By.id("payment-data")).click();
        // driver.quit();


    }

    @Test
    public void test2() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("5555 5555 5555 4444");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("VASIA VASILEV");
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("12");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2029");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("456");

//Проверка адреса доставки
        assertEquals("10001, US, NY, NY, 677 STREET, 87699090", driver.findElement(By.xpath("//*[@id=\"payment-data-shipping-copy\"]")).getText());
        driver.findElement(By.id("payment-data")).click();


        // driver.quit();


            }

    @Test
    public void test3() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0044");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("HJKHJK GHFG");
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("12");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2031");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("345");
        driver.findElement(By.id("action-submit")).click();
        driver.findElement(By.id("success")).click();
        // Проверка статуса оплаты
        assertEquals("CONFIRMED", driver.findElement(By.xpath("//*[@id=\"payment-item-status\"]/div[2]")).getText());

// //*[@id="payment-item-status"]/div[2]


        driver.quit();
    }



    @Test
    public void testScrinshot() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0036");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("IVAN IVANOV");
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("12");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2029");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("cvc-hint-toggle")).click();
        driver.findElement(By.id("cvc-hint-toggle")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("345");
        driver.findElement(By.id("payment-data")).click();
      // скриншот
                WebDriver augmentedDriver = new Augmenter().augment(driver);
        File scrFile = ((TakesScreenshot)augmentedDriver).
                getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\1\\scr.png"));

    }
        @Test
        public void test4() throws Exception {
            driver.get(baseUrl);
            driver.findElement(By.id("input-card-number")).click();
            driver.findElement(By.id("input-card-number")).clear();
            driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0036");
            driver.findElement(By.id("input-card-holder")).click();
            driver.findElement(By.id("input-card-holder")).clear();
            driver.findElement(By.id("input-card-holder")).sendKeys("IGOR PETROVSKII");
            driver.findElement(By.id("card-expires-month")).click();
            new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("12");
            driver.findElement(By.id("card-expires-month")).click();
            driver.findElement(By.id("card-expires-year")).click();
            new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2030");
            driver.findElement(By.id("card-expires-year")).click();
            driver.findElement(By.id("input-card-cvc")).click();
            driver.findElement(By.id("input-card-cvc")).clear();
            driver.findElement(By.id("input-card-cvc")).sendKeys("777");
            driver.findElement(By.id("action-submit")).click();

            // driver.quit();
        }

    @Test
    public void znakvoprosa() throws Exception {
        driver.get(baseUrl);
               driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0085");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("FGHF FGHF");
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("12");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2031");
        driver.findElement(By.id("card-expires-year")).click();
        //наведение на знак вопроса кликом
        driver.findElement(By.id("cvc-hint-toggle")).click();
        driver.findElement(By.id("cvc-hint-toggle")).click();
        driver.findElement(By.id("cvc-hint-toggle")).click();

        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //*[@id="cvc-hint-toggle"]
        //driver.quit();
    }



    @After
    public void tearDown() throws Exception {
        driver.quit();
        //String verificationErrorString = verificationErrors.toString();
        //if (!"".equals(verificationErrorString)) {
          //  fail(verificationErrorString);
        }
    }


