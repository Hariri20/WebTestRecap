package com.iman89h.text.WebTestSuit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;

public class BaseTest
{
    protected WebDriver driver;

    @BeforeEach
    public void Setup() throws MalformedURLException
    {
        driver = new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
        driver.manage().window().maximize();
    }


    @AfterEach
    public void CleanUp()
    {
        if(driver != null)
        {
           // driver.quit();
        }
    }
}
