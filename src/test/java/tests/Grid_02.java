package tests;

import org.testng.annotations.*;
import static manager.DriverManager.*;


public class Grid_02 {

    @Parameters("browser")
    @BeforeTest
    void beforeTest(@Optional("browser") String browser){
        setDriver("firefox");
    }


    @Test
    void test01(){
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }


    @AfterTest
    void afterTest(){
        closeDriver();
    }


}