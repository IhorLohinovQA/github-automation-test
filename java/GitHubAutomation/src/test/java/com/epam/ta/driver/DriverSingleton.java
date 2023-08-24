package com.epam.ta.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverSingleton {
    private static WebDriver driver;



    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (null == driver){
            switch (System.getProperty("browser")){
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case "safari": {
                    //WebDriverManager.safaridriver().setup();
                    System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
                    driver = new SafariDriver();
                    break;
                }
                case "edge": {
                    //WebDriverManager.edgedriver().setup();
                    System.setProperty("webdriver.edge.driver", "/usr/local/bin/msedgedriver");
                    driver = new EdgeDriver();
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver(){
            driver.quit();
            driver = null;
    }
}
