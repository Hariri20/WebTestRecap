package com.iman89h.text.WebTestSuit;

import com.iman89h.text.ui.FormsPage;
import com.iman89h.text.ui.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormTest extends BaseTest
{
    @Test
    public void FormValidationErrorsDisplayed()
    {
        //Arrange
        Menu menu = new Menu(driver);
        menu.clickForms();
        FormsPage formsPage = new FormsPage(driver);

        //Act
        formsPage.clickSubmit();

        //Assert
        Assertions.assertEquals("Your name is required", formsPage.getNameValidationError());
        Assertions.assertEquals("Your email is required", formsPage.getEmailValidationError());
        Assertions.assertEquals("You must agree to continue", formsPage.getAgreeValidationError());
    }

    @Test
    public void SubmitFormAndConfirmThanksMessage()
    {
        //Arrange
        Menu menu = new Menu(driver);
        menu.clickForms();
        FormsPage formsPage = new FormsPage(driver);

        //Act
        String name = "Iman";
        String email = "name@email.com";
        String expected = "Thanks for your feedback "+name;

        formsPage.setName(name);
        formsPage.setEmail(email);
        formsPage.openDropDownMenu();

        formsPage.selectState("VIC");
        formsPage.selectAgree();
        formsPage.clickSubmit();

        new WebDriverWait(driver, 10).until(d -> formsPage.isPopUpThanksDisplayed());

        //Assert

        Assertions.assertEquals(expected, formsPage.getThanksPopUpMessage());




    }
}
