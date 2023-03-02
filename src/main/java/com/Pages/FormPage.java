package com.Pages;

import com.SeleniumAction.SeleniumAction;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class FormPage {
    public WebDriver driver;
    JavascriptExecutor jse;
    SeleniumAction seleniumActions;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumActions = new SeleniumAction(driver);
        jse = (JavascriptExecutor) driver;
    }


    @FindBy(xpath = "//li[@class='rootdropdownmenuitem']//a[normalize-space()='Contact']")
    WebElement contactOnHeader;

    @FindBy(name = "name")
    WebElement nameInputBox;

    @FindBy(name = "email")
    WebElement emailInputBox;

    @FindBy(id = "139area")
    WebElement messageBox;

    @FindBy(xpath = "//div[@id='139attach']")
    WebElement attachButton;

   @FindBy(xpath = "//div[@role='checkbox']")
   WebElement checkBox;
   @FindBy(xpath = "//div[@id='sendmainButton']//div//div//div//div//div[@tabindex='0']")
   WebElement submitButton;

   @FindBy(css = ".SuccessMessageBorder")
   WebElement validationMessage;

    public void clickOnContact() {
        seleniumActions.waitAndClickOnElement(contactOnHeader);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
    }

    public void fillForms() throws InterruptedException {
        SeleniumAction.hoverOnElements(nameInputBox);
        seleniumActions.enterValueOnTextField(nameInputBox, "Sukanya Kumari");

        SeleniumAction.clickOnElement(emailInputBox);
        seleniumActions.enterValueOnTextField(emailInputBox, "sukanyakumari19@gmail.com");

        SeleniumAction.clickOnElement(messageBox);
        seleniumActions.enterValueOnTextField(messageBox, "Cucumber Framework is A BDD Framework");

    }
    public void uploadFile() throws InterruptedException, IOException {
        String text = "return arguments[0].click()";
        jse.executeScript(text, attachButton);
        Thread.sleep(3000);
        Runtime.getRuntime().exec("C:\\Users\\Sukanya Kumari\\Documents\\Fileupload.exe");
        seleniumActions.clickOnElement(checkBox);
        seleniumActions.clickOnElement(submitButton);
        System.out.println("File uploaded successfully");
        Thread.sleep(3000);
    }

    public boolean successMessageVerification()
    {
            return validationMessage.isDisplayed();
        }
    }






