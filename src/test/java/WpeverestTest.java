import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Check user registration successfully")
public class WpeverestTest {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterAll
    public void teardown() {
        driver.quit();
    }

    @Test
    public void RegistrationTest() throws InterruptedException {

        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().cellPhone();
        String password = faker.internet().password(12, 16);
        List<WebElement> elements = driver.findElements(By.tagName("input"));
        elements.get(4).sendKeys(firstName); //firstName
        //Thread.sleep(2000);
        elements.get(7).sendKeys(lastName); //LastName
        elements.get(5).sendKeys(email); //email
        elements.get(8).click(); //gender
        elements.get(6).sendKeys(password);  //password
        Thread.sleep(1000);

        elements.get(11).click(); //Date of Birth field click

        //Select Month
        List<WebElement> selectMonth = driver.findElements(By.tagName("option"));
        selectMonth.get(254).click();
        Thread.sleep(1000);
        // Select year (input type=number)
        WebElement yearSelect = driver.findElement(By.className("numInput"));
        yearSelect.clear();
        yearSelect.sendKeys("1998");
        //SelectDay
        List<WebElement> selectDay = driver.findElements(By.className("flatpickr-day"));
        selectDay.get(10).click();
        Thread.sleep(1000);

        elements.get(16).sendKeys("Bangladeshi");//Nationality
        elements.get(14).sendKeys(phone);//Phone no

        Select country = new Select(driver.findElement(By.id("country_1665629257")));//Country
        country.selectByVisibleText("Bangladesh");
        //Scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        //Check on Terms & Conditions
        elements.get(33).click();
        //Click on submit button
        WebElement submitButton = driver.findElement(By.cssSelector("button.ur-submit-button"));
        submitButton.click();
        Thread.sleep(2000);
        // Assertion
        String confirmationMessage = driver.findElement(By.id("ur-submit-message-node")).getText();
        Assertions.assertTrue(confirmationMessage.contains("User successfully registered."));
        Thread.sleep(2000);
    }
}
