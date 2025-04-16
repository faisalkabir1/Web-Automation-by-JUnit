import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class WpeverestTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void RegistrationTest() throws InterruptedException {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
        List<WebElement> elements = driver.findElements(By.tagName("input"));
        elements.get(4).sendKeys("Test"); //firstName
        //Thread.sleep(2000);
        elements.get(7).sendKeys("Name"); //LastName
        elements.get(5).sendKeys("name@gmail.com"); //email
        elements.get(8).click(); //gender

        elements.get(6).sendKeys("Abcd@$1234");  //password

        elements.get(11).click(); //DateofBirth
        Thread.sleep(2000);

      // List<WebElement> monthDropdown = driver.findElements(By.tagName("select"));
      //  monthDropdown.get(2).click();
      //  Thread.sleep(4000);
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
        elements.get(14).sendKeys("1916603009");//Phone no


        Select country = new Select(driver.findElement(By.id("country_1665629257")));//Country
        country.selectByVisibleText("Bangladesh");


    }

    @AfterAll
    public static void teardown() {

       // driver.quit();
    }
}
