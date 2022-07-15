// The sample test script in this section is compatible with JSON wire protocol-based 
// client bindings. Check out our W3C-based scripts in 
// the selenium-4 branch of the same repository.
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class BrowserStackLoginBS {
    // Your credentials will be used to log into BrowserStack. We are using environment variables as we don't want to hardcode login information in the code.
    public static final String AUTOMATE_USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    // Using the above credentials, create a URL for connection to BrowserStack.
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static void main(String[] args) throws Exception {
        // Set up the capabilities to tell BrowserStack what OS / Browser / Device you want to test against.
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("name", "BDB BrowserStack Login Test"); // test name
        caps.setCapability("build", "BdB Lesson 2 - Exercise"); // CI/CD job or build name

        // Using the URL we created above,create the web driver and connect to BrowserStack.
        final WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

        // Wrap the code in a try / catch block in order to catch errors if / when they occur.
        try {
            // Maximise the browser window so it is full screen.
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
        } catch (Exception e) {
            // Output the exception to the console.
            System.out.println("There was an exception: " + e);
            // Close out the web driver since there was an error.
            driver.quit();
        }
    }
} 