package tests;

import manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Grid_01 {

    DriverManager driverManager = new DriverManager();
    static WebDriver driver;
    public static void main(String[] args) throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://192.168.251.54:4444"),new ChromeOptions());
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    void remoteChromeDriverTest(){
        driver = driverManager.setUpChromeDriver();
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    void remoteFirefoxDriverTest(){
        driver = driverManager.setUpFirefoxDriver();
        driver.get("https://www.youtube.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }




}