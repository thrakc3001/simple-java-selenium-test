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


 
public class SampleSauceTest {
 
  public WebDriver driver;

  @Before
  public void setUp() throws Exception {
 
    String USERNAME = System.getenv("SAUCE_USERNAME");
    String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
    String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
    
	DesiredCapabilities capabilities = new DesiredCapabilities();
// 	capabilities.setBrowserName(System.getenv("SELENIUM_BROWSER"));
// 	capabilities.setVersion(System.getenv("SELENIUM_VERSION"));
// 	capabilities.setCapability(CapabilityType.PLATFORM, System.getenv("SELENIUM_PLATFORM"));
// 	capabilities.setCapability("tunnelIdentifier", System.getenv("TUNNEL_IDENTIFIER"));
	capabilities.setCapability("tunnelIdentifier", "jenkinstunnel");
// 	capabilities.setCapability("name", "Jenkins Test");
	capabilities.setCapability("deviceName", System.getenv("SELENIUM_DEVICE"));
    	capabilities.setCapability("platformName", System.getenv("SELENIUM_DEVICE_TYPE"));


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
    // String sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
    // SauceREST sauce = new SauceREST(System.getenv("SAUCE_USERNAME"), System.getenv("SAUCE_ACCESS_KEY"));
    // sauce.jobPassed(sessionId);
	  

//     driver.quit();
  }
}

