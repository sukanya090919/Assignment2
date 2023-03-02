package steps;

import com.Pages.FormPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class formSteps {
    public FormPage formPage;
    public  WebDriver driver;

    @Before
    public void intilaizeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(" https://compendiumdev.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void killSession()
    {
       driver.quit();
    }
    @Given("open the URL")
    public void open_the_url() {
        System.out.println("Login screen opened");
        System.out.println("Application Opened Successfully");

    }
    @When("click on contact")
    public void click_on_contact() {
        formPage = new FormPage(driver);
        formPage.clickOnContact();
    }

    @Then("fill the form")
    public void fill_the_form() throws InterruptedException, IOException {
       System.out.println("Application Form Filling");
       formPage = new FormPage(driver);
       formPage.fillForms();
       formPage.uploadFile();
    }
    @Then("verify form submitted successfully")
    public void verify_form_submitted_successfully() {
        System.out.println("verify submitted Successfully");
        formPage = new FormPage(driver);
        Assert.assertTrue(formPage.successMessageVerification());
    }

}
