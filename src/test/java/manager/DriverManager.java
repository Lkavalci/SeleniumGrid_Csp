package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
   public static WebDriver driver;

    DesiredCapabilities capabilities = new DesiredCapabilities();
    public WebDriver setUpChromeDriver(){
        capabilities.setPlatform(Platform.ANY);
        capabilities.setBrowserName("Chrome");
        capabilities.setVersion(ConfigReader.getProperty("chrome_version"));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(capabilities);
        try {
            driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("hubUrl")), chromeOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        System.out.println("*****  Setup Chrome Driver *****");

        return driver;
    }

    public WebDriver setUpFirefoxDriver(){
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setBrowserName("Firefox");
        capabilities.setVersion(ConfigReader.getProperty("firefox_version"));
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.merge(capabilities);
        try {
            driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("hubUrl")), firefoxOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        System.out.println("*****  Setup Firefox Driver *****");
        return driver;
    }

    public WebDriver setUpEdgeDriver(){
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setBrowserName("Edge");
        capabilities.setVersion(ConfigReader.getProperty("edge_version"));
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.merge(capabilities);
        try {
            driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("hubUrl")), edgeOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        System.out.println("*****  Setup Edge Driver *****");
        return driver;
    }
    public WebDriver setUpIEDriver(){
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setBrowserName("InternetExplorer");
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.merge(capabilities);
        try {
            driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("hubUrl")), ieOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        System.out.println("*****  Setup IE Driver *****");
        return driver;
    }



    public static void setDriver(String browser) {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
        System.setProperty("webdriver.msedge.driver", "src/test/resources/drivers/msedgedriver");
        System.setProperty("webdriver.IEDriverServer.exe.driver", "src/test/resources/drivers/IEDriverServer.exe");

        switch (browser) {

            case "grid_firefox": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                try {
                    driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("hubUrl")), firefoxOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("°°°°° Selenium Grid Firefox °°°°°°");
                break;
            }
            case "grid_chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                try {
                    driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("hubUrl")), chromeOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("°°°°° Selenium Grid Chrome °°°°°°");
                break;
            }
            case "grid_edge": {
                EdgeOptions edgeOptions = new EdgeOptions();
                try {
                    driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("hubUrl")), edgeOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("°°°°° Selenium Grid Edge °°°°°°");
                break;
            }
            case "grid_IE": {
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                try {
                    driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("hubUrl")), ieOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("°°°°° Selenium Grid IE °°°°°°");
                break;
            }
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                System.out.println("°°°°° Chrome WebDriver °°°°°°");
                break;
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                System.out.println("°°°°° Firefox WebDriver °°°°°°");
                break;
            }
            case "edge": {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                System.out.println("°°°°° Edge WebDriver °°°°°°");
                break;
            }
            case "IE": {
                WebDriverManager.iedriver().setup();
                driver = new EdgeDriver();
                System.out.println("°°°°° IE WebDriver °°°°°°");
                break;
            }
            default: {
                WebDriverManager.chromedriver().setup();
                System.out.println("°°°°° Default Chrome WebDriver °°°°°°");
                driver = new ChromeDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }



}