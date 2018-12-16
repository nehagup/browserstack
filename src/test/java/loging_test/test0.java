package loging_test;

import org.junit.*;
import org.junit.rules.Verifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;

public class test0 {

    public WebDriver driver;


    @Parameters({"email", "pass"})

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/nehagupta/Downloads/chromedriver");

        // task : 1
        driver = new ChromeDriver();

        // task : 2
        driver.get("http://www.browserstack.com");

    }

    @Rule
    public Verifier verifier;

    @Test
//    public void testDriver(String email_id, String password) throws Exception {
    public void testDriver() throws Exception {

        WebElement LocationLink = driver.findElement(By.linkText("Sign in"));
        LocationLink.click();

        // task : 3

        driver.findElement(By.id("user_email_login")).sendKeys("neha.gup@icloud.com");
        driver.findElement(By.id("user_password")).sendKeys("nehagupta");
        driver.findElement(By.name("commit")).click();


        // task : 4
        Thread.sleep(5000);

        Assert.assertEquals(driver.findElements(By.linkText("Sign in")).size(), 0);

    }

    @After

    public void cleanUp() {
        driver.quit();
    }

}
