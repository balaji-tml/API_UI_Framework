package org.bit.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    protected static WebDriver driver;
    protected Properties config;
    protected Properties repository;
    FileInputStream fis;

    static ExtentTest test;
    static ExtentReports report;

    @BeforeSuite
    public void setUp()
    {
        String userDir,browser,url;
        userDir = System.getProperty("user.dir");
        if(driver == null)
        {
            try {
                fis = new FileInputStream(userDir + "/src/test/resources/properties/config.properties");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            config = new Properties();
            try {
                config.load(fis);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            browser = config.getProperty("browser");
            System.out.println("Browser: "+browser);
            url = config.getProperty("url");
            if(browser.equalsIgnoreCase("CHROME"))
            {
                System.setProperty("webdriver.chrome.driver", userDir + "/src/test/resources/executables/chromedriver.exe");
                driver = new ChromeDriver();
            }
            else if(browser.equalsIgnoreCase("EDGE"))
            {
                System.setProperty("webdriver.edge.driver", userDir + "/src/test/resources/executables/msedgedriver.exe");
                driver = new EdgeDriver();
            }
            driver.manage().window().maximize();
            //driver.get(url);


        }

    }

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir") + "/src/test/resources/reports/ExtentReportResults.html");
        test = report.startTest("ExtentDemo");
    }

    @AfterSuite
    public void tearDown()
    {
        if(driver != null)
        {
           // driver.quit();
        }
    }
}
