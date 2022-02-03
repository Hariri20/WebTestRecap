package com.iman89h.text.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormsPage
{
    private WebDriver driver;

    public FormsPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void clickSubmit()
    {
        var buttons =  driver.findElements(By.tagName("button"));
        WebElement submitButton = null;

        for(WebElement button : buttons)
        {
            if(button.getText().equalsIgnoreCase("submit"))
            {
                submitButton = button;
                break;
            }
        }

        if(submitButton != null)
        {
            submitButton.click();
        }

    }

    public String getNameValidationError() { return driver.findElement(By.id("name-err")).getText(); }
    public String getEmailValidationError() { return driver.findElement(By.id("email-err")).getText(); }
    public String getAgreeValidationError() { return driver.findElement(By.id("agree-err")).getText(); }


    public void setName(String name)
    {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public void setEmail(String email)
    {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void openDropDownMenu()
    {
        driver.findElement(By.cssSelector(".v-select__selections")).click();
    }

    public void selectState(String state)
    {
        driver.findElement(By.xpath("//div[contains(text(),'"+state+"')]")).click();

    }


    public void selectAgree()
    {
        driver.findElement(By.cssSelector(".v-input--selection-controls__ripple")).click();
    }

    public boolean isPopUpThanksDisplayed()
    {
        return driver.findElement(By.cssSelector(".mr-auto")).isDisplayed();
    }

    public String getThanksPopUpMessage()
    {
        return driver.findElement(By.cssSelector(".mr-auto")).getText();
    }
}
