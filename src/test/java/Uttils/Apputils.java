package Uttils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Apputils {

    public static Logger LOGGER = LogManager.getLogger(Apputils.class);;

    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
    public WebDriver driver;

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

    public static void closeApp() {

        getDriver().close();
        LOGGER.info("Closed the Browser");

    }

    public WebDriver launchApp() {
        LOGGER.info("Instate the WebBrowser");
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
        LOGGER.info("Start the WebBrowser");
        driver.manage().deleteAllCookies();
        LOGGER.info("Maximize the WebBrowse");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        tdriver.set(driver);
        return getDriver();
    }
//	public static String getScreenshot() {
//		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
//		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
//		File destination = new File(path);
//		try {
//			FileUtils.copyFile(src, destination);
//		} catch (IOException e) {
//			System.out.println("Capture Failed " + e.getMessage());
//		}
//		return path;
//	}

}
