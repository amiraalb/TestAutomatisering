package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MyStepdefs {

    private WebDriver driver;

    //Privat metod som använder explicit wait
    private static void click(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }

    //Användning av flera browsers
    @Given("I am using {string} on the create an account page")
    public void iAmUsing(String browser) {

        if (browser.equals("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }

        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        driver.manage().window().maximize();
    }

    @When("I fill in birthdate {string}")
    public void iFillInBirthdate(String birthdate) {
       driver.findElement(By.name("DateOfBirth")).sendKeys(String.valueOf(birthdate));
       driver.findElement(By.id("dp")).sendKeys(Keys.RETURN);
    }

    @And("I fill in firstname {string}")
    public void iFillInFirstname(String firstname) {
        driver.findElement(By.name("Forename")).sendKeys(String.valueOf(firstname));
    }

    @And("I fill in lastname {string}")
    public void iFillInLastname(String lastname) {
        driver.findElement(By.name("Surname")).sendKeys(String.valueOf(lastname));
    }

    @And("I fill in email {string}")
    public void iFillInEmail(String email) {
        driver.findElement(By.name("EmailAddress")).sendKeys(String.valueOf(email));
    }

    @And("I fill in confirmEmail {string}")
    public void iFillInConfirmEmail(String confirmEmail) {
        driver.findElement(By.name("ConfirmEmailAddress")).sendKeys(String.valueOf(confirmEmail));
    }

    @And("I fill in password {string}")
    public void iFillInPassword(String password) {
        driver.findElement(By.name("Password")).sendKeys(String.valueOf(password));
    }

    @And("I fill in confirmPassword {string}")
    public void iFillInConfirmPassword(String confirmPassword) {
        driver.findElement(By.name("ConfirmPassword")).sendKeys(String.valueOf(confirmPassword));
    }

    @And("I click on the mandatory check boxes and confirm button")
    public void iClickOnTheMandatoryCheckBoxesAndConfirmButton() {

        WebElement conditions = driver.findElement(By.cssSelector("label[for=sign_up_25]"));
        conditions.click();

        WebElement age = driver.findElement(By.cssSelector("label[for=sign_up_26]"));
        age.click();

        WebElement ethics = driver.findElement(By.cssSelector("label[for=fanmembersignup_agreetocodeofethicsandconduct]"));
        ethics.click();

        click(driver, By.name("join"));
        }


    @Then("A new account is successfully created")
    public void aNewAccountIsSuccessfullyCreated() {
        WebElement confirmation = driver.findElement(By.cssSelector("body > div > div.page-content-wrapper > div > h2"));
        confirmation.getText();

        String actual = confirmation.getText();
        assertEquals("THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND", actual);

        driver.quit();
    }

    @Then("An error message is displayed.")
    public void anErrorMessageIsDisplayed() {
        WebElement lastnameError = driver.findElement(By.cssSelector("#signup_form > div:nth-child(6) > div:nth-child(2) > div > span"));
        lastnameError.getText();

        String actual = lastnameError.getText();
        assertEquals("Last Name is required", actual);

        driver.quit();
    }

    @Then("An error message is displayed and the account is not created.")
    public void anErrorMessageIsDisplayedAndTheAccountIsNotCreated() {
        WebElement passwordMissmatch = driver.findElement(By.cssSelector("span[data-valmsg-for='ConfirmPassword'] > span"));
        passwordMissmatch.getText();

        String actual = passwordMissmatch.getText();
        assertEquals("Password did not match", actual);

        driver.quit();
    }

    @And("I click on the mandatory check boxes except the terms and conditions check box")
    public void iClickOnTheMandatoryCheckBoxesExceptTheTermsAndConditionsCheckBox() {


        WebElement age = driver.findElement(By.cssSelector("label[for=sign_up_26]"));
        age.click();

        WebElement ethics = driver.findElement(By.cssSelector("label[for=fanmembersignup_agreetocodeofethicsandconduct]"));
        ethics.click();

        WebElement join = driver.findElement(By.name("join"));
        join.click();

    }

    @Then("Correct error message is displayed")
    public void correctErrorMessageIsDisplayed() {
        WebElement termsAndConditions = driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div:nth-child(1) > span > span"));
        termsAndConditions.getText();

        String actual = termsAndConditions.getText();
        assertEquals("You must confirm that you have read and accepted our Terms and Conditions", actual);

        driver.quit();
    }
}
