package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
       protected  static WebDriver driver;
    public static Properties prop;
    public TestBase(){

        //Check exceptions code if there is a problem in this section

            prop = new Properties();
        System.err.println("declaring FIS");
        FileInputStream ip = null;
        try {
            System.err.println("about to set chrome driver");
            ip = new FileInputStream( "src/main/java/com/crm/qa/config/config.properties");
          //  "src/main/java/com/crm/qa/config/config.properties"
            //"C:\\TryAgain\\FreeCRMTestAutomation\\src\\" +
            //                    "main\\java\\com\\crm\\qa\\config.properties"
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void initialization(){
 String browserName =prop.getProperty("browser");
 if (browserName.equals("chrome")){//chrome
     System.err.println("Browser Chrome");

//     System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vladb\\Desktop\\Drivers\\ChromeDriver91\\chromedriver.exe");
//     driver = new ChromeDriver();
     WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
     System.err.println("Browser initialized");
 }
 else if (browserName.equals("FF")){
//     System.setProperty("webdriver.gecko.driver","Users\\Vladb\\Desktop\\Drivers\\geckodriver.exe");
//     driver = new FirefoxDriver();
     WebDriverManager.firefoxdriver().setup();
     driver = new FirefoxDriver();
 }
 driver.manage().window().maximize();
 driver.manage().deleteAllCookies();
 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);

 driver.get(prop.getProperty("url"));

        System.out.println("Page title is " +driver.getTitle());
    }

}
