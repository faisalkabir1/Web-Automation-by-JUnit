import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebScrapingTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void DataScrapingTest() {
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");


        List<WebElement> headertext = driver.findElements(By.xpath("//th[not(contains(@class, 'floatThead-col'))]"));

        for (WebElement header : headertext) {
            String Allheadertext = header.getText().trim();
            if (!headertext.isEmpty()) {
                System.out.print(Allheadertext + " ");
            }
        }

        WebElement table = driver.findElement(By.className("table-responsive"));
        List<WebElement> allRows = table.findElements(By.tagName("tr"));
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + " ");
            }
            System.out.println();
        }
    }
}
