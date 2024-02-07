package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {
    /**
     * The port number assigned to the runing application during test execution.
     * Set automatically during each test run by Spring Framework's test context.
     */

    @LocalServerPort
    private int serverPort;
    /**
     * The base URL for testing. Default to {ecode http://localhost}.
     */
    @Value("${app.baseUrL:http://localhost}")
    private String testBaseUrl;
    private String baseUrl;
    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d/product/create", testBaseUrl, serverPort);
    }

    @Test
    void createPage_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        // Clear field to empty it from any previous data
        WebElement nameInput = driver.findElement(By.id("nameInput"));
        nameInput.clear();
        WebElement quantityInput = driver.findElement(By.id("quantityInput"));
        quantityInput.clear();

        // Enter Text
        String name = "Sanpo Cap Bambang";
        nameInput.sendKeys(name);
        String quantity = "2";
        quantityInput.sendKeys(quantity);

        // Click on the element
        WebElement submitButton = driver.findElement(By.id("submitButton"));
        submitButton.click();

        String productName = driver.findElement(By.tagName("td")).getText();
        // Verify
        assertEquals("Sanpo Cap Bambang", productName);
    }
}
