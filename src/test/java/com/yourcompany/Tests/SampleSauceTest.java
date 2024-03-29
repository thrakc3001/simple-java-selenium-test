import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.junit.*;
import java.io.IOException;
import java.io.File;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import org.junit.rules.TestName;
import com.saucelabs.saucerest.SauceREST;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.MutableCapabilities;


 
public class SampleSauceTest {
 
  public WebDriver driver;

  @Before
  public void setUp() throws Exception {
 
    String USERNAME = System.getenv("SAUCE_USERNAME");
    String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
    String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.us-west-1.saucelabs.com/wd/hub";
    
// 	DesiredCapabilities capabilities = new DesiredCapabilities();
// 	capabilities.setBrowserName(System.getenv("SELENIUM_BROWSER"));
// // 	capabilities.setBrowserName(System.getenv("SAUCE_ONDEMAND_BROWSERS")); 
// 	capabilities.setVersion(System.getenv("SELENIUM_VERSION"));
// 	capabilities.setCapability(CapabilityType.PLATFORM, System.getenv("SELENIUM_PLATFORM"));
// 	capabilities.setCapability("tunnelIdentifier", System.getenv("TUNNEL_IDENTIFIER"));
// // 	capabilities.setCapability("tunnelIdentifier", "tunnelName");
// 	capabilities.setCapability("name", "Jenkins Test");
// // 	capabilities.setCapability("deviceName", System.getenv("SELENIUM_DEVICE"));
// //     	capabilities.setCapability("platformName", System.getenv("SELENIUM_DEVICE_TYPE"));
// // 	capabilities.setCapability("build", System.getenv("JOB_NAME") + "__" + System.getenv("BUILD_NUMBER"));
// 	capabilities.setCapability("build", System.getenv("SAUCE_BUILD_NAME"));

	  
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("tunnelIdentifier", System.getenv("TUNNEL_IDENTIFIER"));
	sauceOptions.setCapability("name", "Jenkins Test");
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", System.getenv("SELENIUM_BROWSER"));
        capabilities.setCapability("browserVersion", System.getenv("SELENIUM_VERSION"));
        capabilities.setCapability("platformName", System.getenv("SELENIUM_PLATFORM"));
        capabilities.setCapability("sauce:options", sauceOptions);

    driver = new RemoteWebDriver(new URL(URL), capabilities);
  }

  @Test
  public void testMethod() throws IOException, InterruptedException {
  
    driver.get("https://www.google.com");

    // Actions action = new Actions(driver);
    // action.clickAndHold(driver.findElement(By.name("q"))).build().perform();
  }

  @After
  public void tearDown() {
    String sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
    SauceREST sauce = new SauceREST(System.getenv("SAUCE_USERNAME"), System.getenv("SAUCE_ACCESS_KEY"));
    sauce.jobPassed(sessionId);
	  
    String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",
    (((RemoteWebDriver) driver).getSessionId()).toString(), "Jenkins Test");
    System.out.println(message);
	  

    driver.quit();
  }
}
