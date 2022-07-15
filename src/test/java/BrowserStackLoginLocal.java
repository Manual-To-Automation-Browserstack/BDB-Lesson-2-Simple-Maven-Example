import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BrowserStackLoginLocal {
    public static void main(String[] args) throws Exception {
        // Setting the driver executable path
        System.setProperty("webdriver.chrome.driver", "/Users/garybehan/webdrivers/chromedriver");

        // Initiate the web driver as a Chrome instance.
        WebDriver driver=new ChromeDriver();

        // Set the maximum wait time for timeouts
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Maximise the browser window
        driver.manage().window().maximize();

        //Open the browser with the URL that you want to interact with
        driver.get("https://www.browserstack.com/users/sign_in");

        // Create a web element for the username text field so that you can type into it.
        WebElement usernameField = driver.findElement(By.cssSelector("#user_email_login"));
        usernameField.sendKeys(System.getenv("LOGIN_USERNAME"));

        // Create a web element for the password text field so that you can type into it.
        WebElement passwordField = driver.findElement(By.cssSelector("#user_password"));
        passwordField.sendKeys(System.getenv("LOGIN_PASSWORD"));

        // Create a web element for the Sign Me In button so that you can click on it.
        WebElement signInButton = driver.findElement(By.cssSelector("#user_submit"));
        signInButton.click();

        // Sleep for 3 seconds to allow time for the page to load - NOT BEST PRACTICE
        Thread.sleep(3000);

        // Create a web element for the account menu button to verify that the login was successful.
        WebElement accountMenuButton = driver.findElement(By.cssSelector("#account-menu-toggle"));
        assert accountMenuButton.isDisplayed();

        // Close out the web driver at the end.
        driver.quit();
    }
}
