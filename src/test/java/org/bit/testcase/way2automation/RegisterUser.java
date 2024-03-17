package org.bit.testcase.way2automation;

import org.bit.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RegisterUser extends BaseTest {

    @Test
    public void registerUser()
    {
        String registerUser = config.getProperty("registerUser");
        driver.get(registerUser);
        System.out.println("Page title: "+driver.getTitle());
        WebElement firstName = driver.findElement(By.xpath("//*[@id='register_form']/fieldset[1]/p[1]/input"));
        firstName.sendKeys("Anand");
        WebElement lastName = driver.findElement(By.xpath("//*[@id='register_form']/fieldset[1]/p[2]/input"));
        lastName.sendKeys("Prasad");
        WebElement phoneNumber = driver.findElement(By.xpath("//*[@id='register_form']/fieldset[6]/input"));
        phoneNumber.sendKeys("9898989898");
        WebElement userName = driver.findElement(By.xpath("//*[@id='register_form']/fieldset[7]/input"));
        userName.sendKeys("AnandPrasad");
        WebElement email = driver.findElement(By.xpath("//*[@id='register_form']/fieldset[8]/input"));
        email.sendKeys("AnandPrasad@email.com");
        WebElement aboutYourself = driver.findElement(By.xpath("//*[@id='register_form']/fieldset[10]/textarea"));
        aboutYourself.sendKeys("This is Anand Prasad with 12+ years of experience in software testing.");
        WebElement password = driver.findElement(By.xpath("//*[@id='register_form']/fieldset[11]/input"));
        password.sendKeys("AnandPrasad@123");
        WebElement confirmPassword = driver.findElement(By.xpath("//*[@id='register_form']/fieldset[12]/input"));
        confirmPassword.sendKeys("AnandPrasad@123");
//        WebElement firstName = driver.findElement(By.xpath("//*[@id='register_form']/fieldset[1]/p[1]/input"));
//        firstName.sendKeys("Anand");

    }
}
