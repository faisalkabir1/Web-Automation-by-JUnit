import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Check the form submitted successfully")
public class DigitaluniteTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void FormSubmit() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(200);

        driver.findElement(By.id("edit-name")).sendKeys("Faisal Kabir");

        driver.findElement(By.id("edit-number")).sendKeys("01712345678");

        driver.findElement(By.id("edit-date")).sendKeys("04/14/2025");

        driver.findElement(By.id("edit-email")).sendKeys("onlyfaisalkabir@gmail.com");

        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("I'm a automation testing learner.");

        WebElement uploadElement = driver.findElement(By.id("edit-uploadocument-upload"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        uploadElement.sendKeys("D:\\SQA- Road to SDET\\Web-Automation-JUnit\\Web-Automation-JUnit\\src\\test\\resources\\test.jpg");
        Thread.sleep(1000);

        WebElement checkBoxElement = driver.findElement(By.cssSelector("label[for='edit-age']"));
        checkBoxElement.click();

        // Find the submit button and click it
        WebElement submitButton = driver.findElement(By.id("edit-submit"));
        submitButton.click();

    }

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
