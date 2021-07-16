package test1;
import java.io.File;
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


public class TestPlan {
    private WebDriver driver;
    private String baseUrl;
    private String element;
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
    public void testCardNumber1() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("1111 1111 1111 1111");
        driver.findElement(By.id("card-number-field")).click();
        driver.findElement(By.id("payment-data")).click();
        // Проверка есть ли текст ошибки при вводе не корректного номера карты
        assertEquals("Card number is not valid", driver.findElement(By.xpath("//*[@id='card-number-field']/div/label")).getText());

        // driver.quit();

    }

    @Test
    public void testCardNumber2() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000000000000002");
        driver.findElement(By.id("card-number-field")).click();
        driver.findElement(By.id("payment-data")).click();
        // Проверка есть ли текст ошибки при вводе корректного номера карты (надо закрывать окно хрома мышкой, почему-то driver.quit не срабатывает)

        //assertEquals("Card number is not valid", driver.findElement(By.xpath("//*[@id='card-number-field']/div/label")).getText());

        if (driver.findElements(By.xpath("//*[@id='card-number-field']/div/label")).size() == 0)
        {  System.out.println("номер карты верный");}
else
        {
            System.out.println("номер карты неверный");
        }

        //driver.quit();

    }

    @Test
    public void testCardholderName1() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("5555 5555 5555 4444");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("VASIA VASILEV");

         driver.findElement(By.id("payment-data")).click();
// ввод верного держателя карты
        if (driver.findElements(By.xpath("//*[@id=\"card-holder-field\"]/div/label")).size() == 0)
        {  System.out.println("ввели все правильно");}
        else
        {
            System.out.println("ввели не правильно");
        }


        // driver.quit();


    }


    @Test
    public void testCardholderName2() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("5555 5555 5555 4444");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("Вася Петров");
                driver.findElement(By.id("input-card-number")).click();

// проверка - будет ли ошибка при вводе русских букв в поле Cardholder Name
        assertEquals("Cardholder name is not valid", driver.findElement(By.xpath("//*[@id=\"card-holder-field\"]/div/label")).getText());
        {
            System.out.println("русские буквы нельзя вводить");
        }

        // driver.quit();
    }

    @Test
    public void testCardholderName3() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("5555 5555 5555 4444");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("asd");
        driver.findElement(By.id("input-card-number")).click();

// проверка - будет ли ошибка при вводе менее 4 букв на англ раскладке в поле Cardholder Name
        assertEquals("Allowed from 4 to 50 characters", driver.findElement(By.xpath("//*[@id=\"card-holder-field\"]/div/label")).getText());

        {
            System.out.println("фамилия и имя держателя карты должно быть не менее 4-х символов");
        }
        // driver.quit();
    }

    @Test
    public void testCardholderName4() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("5555 5555 5555 4444");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("QWEHDFGDFGDFGDFGDFGDFGDFGDFGDFGDFGJADSGHFS SSGRRRWG");
        driver.findElement(By.id("input-card-number")).click();

// проверка - будет ли ошибка если ввести ввести больше 50 символов, включая пробелы, на англ языке не используя знаки препинания и цифры в поле Cardholder Name
        assertEquals("Allowed from 4 to 50 characters", driver.findElement(By.xpath("//*[@id=\"card-holder-field\"]/div/label")).getText());

        {
            System.out.println("фамилия и имя держателя карты должно быть не более 50-ти символов");
        }
        // driver.quit();
    }

    @Test
    public void testCardholderName5() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("5555 5555 5555 4444");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("123 456");
        driver.findElement(By.id("input-card-number")).click();

// проверка - будет ли ошибка если вводить цифры вместо букв в поле Cardholder Name
        assertEquals("Cardholder name is not valid", driver.findElement(By.xpath("//*[@id=\"card-holder-field\"]/div/label")).getText());
        {
            System.out.println("фамилия и имя держателя карты не должно содержать цифры");
        }

        // driver.quit();
    }

    @Test
    public void testCardholderName6() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("5555 5555 5555 4444");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys(":;.,?+-");
        driver.findElement(By.id("input-card-number")).click();

// проверка - будет ли ошибка если ввести знаки препинания, любые знаки которые не относятся к буквам и пробелам в поле Cardholder Name
        assertEquals("Cardholder name is not valid", driver.findElement(By.xpath("//*[@id=\"card-holder-field\"]/div/label")).getText());

        {
            System.out.println("фамилия и имя держателя карты не должно содержать знаки препинания и любые спецсимволы");
        }
        // driver.quit();
    }

    @Test
    public void testCardholderName7() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("5555 5555 5555 4444");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("GHFJGHFJGHFJFGHFGHDFGHDF GHFGHFGFHSAKKSRTYRYYRRRREWWDFGDFGSHDF");
        driver.findElement(By.id("input-card-number")).click();

// проверка - будет ли ошибка если ввести больше 61 буквы на англ языке включая пробелы в поле Cardholder Name
        assertEquals("Cardholder name is not valid", driver.findElement(By.xpath("//*[@id=\"card-holder-field\"]/div/label")).getText());

        {
            System.out.println("фамилия и имя держателя карты не должно превышать 50 символов и тем более 61");
        }
        // driver.quit();
    }

    @Test
    public void testExpires1() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0044");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("HJKHJK GHFG");
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("01");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2021");
        driver.findElement(By.id("payment-data")).click();
        driver.findElement(By.id("card-expires-year")).click();
        assertEquals("Invalid date", driver.findElement(By.xpath("//*[@id=\"card-expires-field\"]/div/label")).getText());
        {
            System.out.println("Срок действия карты истек");
        }
        // driver.quit();
    }

    @Test
    public void testExpires2() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0044");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("HJKHJK GHFG");
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("06");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2021");
        driver.findElement(By.id("payment-data")).click();
        driver.findElement(By.id("card-expires-year")).click();
        assertEquals("Invalid date", driver.findElement(By.xpath("//*[@id=\"card-expires-field\"]/div/label")).getText());
        {
            System.out.println("срок действия карты истек");
        }
        // driver.quit();
    }

    @Test
    public void testExpires3() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0044");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("HJKHJK GHFG");
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("09");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2021");
        driver.findElement(By.id("payment-data")).click();
        driver.findElement(By.id("card-expires-year")).click();
// проверка даты (надо закрывать окно хрома мышкой, почему-то driver.quit не срабатывает когда условие выполняется)
        if (driver.findElements(By.xpath("//*[@id=\"card-expires-field\"]/div/label")).size() == 0)
        {  System.out.println("Дата корректная");}
        else
        {
            System.out.println("Дата не корректная");
        }


        //driver.quit();

    }

    @Test
    public void testCVC1() throws Exception {
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
        driver.findElement(By.id("input-card-cvc")).sendKeys("34");
        driver.findElement(By.id("payment-data")).click();
        assertEquals("CVV2/CVC2/CAV2 is not valid", driver.findElement(By.xpath("//*[@id=\"card-cvc-field\"]/div/label")).getText());

        {
            System.out.println("код проверки не может быть менее 3-х символов");
        }
//        driver.quit();
    }

    @Test
    public void testCVC2() throws Exception {
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
        driver.findElement(By.id("payment-data")).click();
      //  assertEquals("CVV2/CVC2/CAV2 is not valid", driver.findElement(By.xpath("//*[@id=\"card-cvc-field\"]/div/label")).getText());

        //проверка с вводом корректного кода проверки
        // (надо закрывать окно хрома мышкой, почему-то driver.quit не срабатывает)

        if (driver.findElements(By.xpath("//*[@id=\"card-cvc-field\"]/div/label")).size() == 0)
        {  System.out.println("код проверки верный");}
        else
        {
            System.out.println("код проверки верный");
        }

       // driver.quit();

        }






    @After
    public void tearDown() throws Exception {
        driver.quit();

        }
    }





