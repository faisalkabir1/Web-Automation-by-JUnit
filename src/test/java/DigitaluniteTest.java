import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;

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
        List<WebElement> formFields= driver.findElements(By.className(".form-control"));
        formFields.get(0).sendKeys("Test Name");
        formFields.get(1).sendKeys("1234567890");


    }

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
