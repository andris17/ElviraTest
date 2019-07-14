package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import driver.BrowserParameters;
import driver.DefaultEventListener;
import driver.DriverManager;
import enums.BrowserType;
import enums.ScreenshotMode;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.Log4jUtils;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@Search"},
        strict = true,
        glue = {"steps"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber/html-report", "json:target/cucumber.json"},
        features = "src/test/resources/features")

public class DefaultElviraTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Starting test suite...");
        System.setProperty("log4j.configurationFile", "src\\main\\resources\\log4j2.properties.xml");

        BrowserParameters parameters = new BrowserParameters()
                .setBrowserType(BrowserType.CHROME)
                .doNotCloseBrowsersAtStart()
                .setScreenShotMode(ScreenshotMode.FAILED);
        DriverManager.initDriver(parameters);

        if (System.getProperty("logLevel") != null) {
            Log4jUtils.setRootLevel(System.getProperty("logLevel"));
        }

        if (System.getProperty("classLogLevel") != null && System.getProperty("classLogName") != null) {
            Log4jUtils.setLevel(System.getProperty("classLogName"), System.getProperty("classLogLevel"));
        }

        DriverManager.registerEventHandler(DefaultEventListener.getInstance());
        DriverManager.setImplicitWaitSeconds(2);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test suite is finished, browser will be closed.");

        DriverManager.destroyDriver();
    }
}