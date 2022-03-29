package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[value='email']")
    WebElement radioButtonEmail;

    @FindBy(css = "#email")
    WebElement emailInput;

    @FindBy(css = "[name='password']")
    WebElement passInput;

    @FindBy(xpath = "//span[text()='Login']")
    WebElement loginButton;

    public void login(String email, String password){
        radioButtonEmail.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        passInput.clear();
        passInput.sendKeys(password);
        loginButton.click();
    }



}
