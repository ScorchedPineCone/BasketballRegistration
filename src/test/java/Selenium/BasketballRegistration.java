package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BasketballRegistration {

    private static WebDriver driver;
    private static String siteUrl = "https://membership.basketballengland.co.uk/NewSupporterAccount";


    public BasketballRegistration() {
        driver = new ChromeDriver();
    }

    public static void open() {
        driver.get(siteUrl);
    }

    public static void validRegistration() {

        WebElement dateOfBirth = driver.findElement(By.name("DateOfBirth"));
        dateOfBirth.sendKeys("10/03/1990");

        WebElement firstNameInput = driver.findElement(By.id("member_firstname"));
        firstNameInput.sendKeys("Jan");

        WebElement lastNameInput = driver.findElement(By.id("member_lastname"));
        lastNameInput.sendKeys("Hjälte");

        WebElement emailInput = driver.findElement(By.id("member_emailaddress"));
        emailInput.sendKeys("imjan19@mytestmail.com");

        WebElement confirmEmailInput = driver.findElement(By.id("member_confirmemailaddress"));
        confirmEmailInput.sendKeys("imjan19@mytestmail.com");

        WebElement passwordInput = driver.findElement(By.id("signupunlicenced_password"));
        passwordInput.sendKeys("123456!");

        WebElement confirmPasswordInput = driver.findElement(By.id("signupunlicenced_confirmpassword"));
        confirmPasswordInput.sendKeys("123456!");



    }

    public static void registrationFormWithoutLastName(){

        WebElement dateOfBirth = driver.findElement(By.name("DateOfBirth"));
        dateOfBirth.sendKeys("10/03/1990");

        WebElement bodyElement = driver.findElement(By.tagName("body"));
        bodyElement.click();

        WebElement firstNameInput = driver.findElement(By.id("member_firstname"));
        firstNameInput.sendKeys("Jan");

        WebElement emailInput = driver.findElement(By.id("member_emailaddress"));
        emailInput.sendKeys("imjan1@mytestmail.com");

        WebElement confirmEmailInput = driver.findElement(By.id("member_confirmemailaddress"));
        confirmEmailInput.sendKeys("imjan1@mytestmail.com");

        WebElement passwordInput = driver.findElement(By.id("signupunlicenced_password"));
        passwordInput.sendKeys("123456!");

        WebElement confirmPasswordInput = driver.findElement(By.id("signupunlicenced_confirmpassword"));
        confirmPasswordInput.sendKeys("123456!");



    }


    public static void registrationFormWithMismatchedPassword() {

        WebElement dateOfBirth = driver.findElement(By.name("DateOfBirth"));
        dateOfBirth.sendKeys("10/03/1990");

        WebElement bodyElement = driver.findElement(By.tagName("body"));
        bodyElement.click();

        WebElement firstNameInput = driver.findElement(By.id("member_firstname"));
        firstNameInput.sendKeys("Jan");

        WebElement lastNameInput = driver.findElement(By.id("member_lastname"));
        lastNameInput.sendKeys("Hjälte");

        WebElement emailInput = driver.findElement(By.id("member_emailaddress"));
        emailInput.sendKeys("imjan1@mytestmail.com");

        WebElement confirmEmailInput = driver.findElement(By.id("member_confirmemailaddress"));
        confirmEmailInput.sendKeys("imjan1@mytestmail.com");

        WebElement passwordInput = driver.findElement(By.id("signupunlicenced_password"));
        passwordInput.sendKeys("123456!");

        WebElement confirmPasswordInput = driver.findElement(By.id("signupunlicenced_confirmpassword"));
        confirmPasswordInput.sendKeys("1234567!");




    }


    public static void agreeToTermsAndConditions(){

        WebElement termsCheckbox = driver.findElement(By.cssSelector("label[for=\"sign_up_25\"]"));
        termsCheckbox.click();

        WebElement ageCheckbox = driver.findElement(By.cssSelector("label[for=\"sign_up_26\"]"));
        ageCheckbox.click();

        WebElement codeOfConductCheck = driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']"));
        codeOfConductCheck.click();

    }



    public static void agreeToMostTermsAndConditions(){

        WebElement termsCheckbox = driver.findElement(By.cssSelector("label[for=\"sign_up_25\"]"));
        termsCheckbox.click();

        WebElement ageCheckbox = driver.findElement(By.cssSelector("label[for=\"sign_up_26\"]"));
        ageCheckbox.click();

    }

    public static void submitRegistrationForm(){

        WebElement submitRegistration = driver.findElement(By.cssSelector("input[value='CONFIRM AND JOIN']"));
        submitRegistration.click();

    }

    public static boolean isErrorMessageDisplayedForCodeOfEthicsAndConduct(){

        WebElement codeOfConductError = driver.findElement(By.xpath("//span[@class='warning field-validation-error'][@data-valmsg-for='AgreeToCodeOfEthicsAndConduct']"));
        boolean isErrorMessageDisplayed = codeOfConductError.isDisplayed();
        String errorMessageText = codeOfConductError.getText();

        assertEquals("You must confirm that you have read, understood and agree to the Code of Ethics and Conduct",errorMessageText);
        assertTrue(isErrorMessageDisplayed);

        return true;
    }

    public static boolean isErrorMessageDisplayedForMissingLastName() {

        WebElement lastNameError = driver.findElement(By.xpath("//span[@for='member_lastname']"));
        boolean isErrorMessageDisplayed = lastNameError.isDisplayed();
        String errorMessageText = lastNameError.getText();

        assertEquals("Last Name is required", errorMessageText);
        assertTrue(isErrorMessageDisplayed);

        return true;
    }
    public static boolean isErrorMessageDisplayedForMismatchedPassword(){

        WebElement misMatchedPassword = driver.findElement(By.xpath("//span[@for='signupunlicenced_confirmpassword']"));
        boolean isErrorMessageDisplayed = misMatchedPassword.isDisplayed();
        String errorMessageText = misMatchedPassword.getText();

        assertEquals("Password did not match", errorMessageText);
        assertTrue(isErrorMessageDisplayed);

        return true;
    }

    public static boolean successMessageIsDisplayed(){

        WebElement successMessage = driver.findElement(By.xpath("//h2[contains(text(),'THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND')]"));
        boolean isSuccessMessageDisplayed = successMessage.isDisplayed();
        String successMessageText = successMessage.getText();

        assertEquals("THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND", successMessageText);
        assertTrue(isSuccessMessageDisplayed);

        return true;
    }
    public void close() {

        driver.quit();

    }
}
