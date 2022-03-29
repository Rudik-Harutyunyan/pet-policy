package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PoliciesPage {

    WebDriver driver;

    public PoliciesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[text()='Policies']")
    WebElement policiesButton;

    @FindBy(xpath = "//a[text()='Policy list']")
    WebElement policyList;

    @FindBy(xpath = "//a[text()='Default state policies']")
    WebElement defaultStatePolicies;

    @FindBy(xpath = "//tbody/tr/td[2]")
    WebElement firstDefaultPolicy;

    @FindBy(xpath = "//span[text()='policy']")
    WebElement addPolicyButton; //When list is empty

    @FindBy(css = "[role='dialog']")
    WebElement addPolicyPopUpForm;

    @FindBy(id = "policyName")
    WebElement nameOfPolicyInput;

    @FindBy(xpath = "//p[text() = 'Name is mandatory']")
    WebElement nameOfPolicyErrorMessage;

    @FindBy(css = "[data-cy='policyState']")
    WebElement selectState;

    @FindBy(css = "[data-value='Utah']")
    WebElement stateUtah;

    @FindBy(css = "[data-testid='accept']")
    WebElement setDefaultPolicy;

    @FindBy(id = "UNAUTH_PET_FEE")
    WebElement priceInput;

    @FindBy(xpath = "//p[text()='Unauthorized pet fee is mandatory']")
    WebElement priceErrorMessage;

    @FindBy(xpath = "//span[text()='Add']")
    WebElement addButton;

    @FindBy(xpath = "//div[text()='Policy has been successfully added']")
    WebElement successfulMessageAdded;

    @FindBy(xpath = "//div[text()='Policy has been successfully deleted']")
    WebElement successfulMessageDeleted;

    @FindBy(css = "[alt='Close']")
    WebElement closeAddPolicyButton;

    @FindBy(xpath = "//td[text() ='Test']")
    WebElement firstAddedPolicyName;

    @FindBy(xpath = "//td[text()='Utah']")
    WebElement firstAddedPolicyState;

    @FindBy(css = "[data-cy='deleteTableRow']")
    WebElement deletePolicyButton;

    @FindBy(xpath = "//span[text()='Yes, remove the policy']")
    WebElement confirmDelete;


    public void goToPolicies() {
        policiesButton.click();
    }

    public void goToPolicyList() {
        policyList.click();
    }

    public void goToDefaultPolicies(){
        defaultStatePolicies.click();
    }

    public void checkAddPolicyButtonIsDisplayed() {
        Assert.assertTrue(addPolicyButton.isDisplayed(), "'Add Policy' button is not displayed");
    }

    public void clickAddPolicyButton() {
        addPolicyButton.click();
    }

    public void checkIsAddPolicyPopUpFormDisplayed() {
        Assert.assertTrue(addPolicyPopUpForm.isDisplayed(), "Add Policy PopUp is not displayed");
    }

    public void checkIsNameOfPolicyDisplayed() {
        Assert.assertTrue(nameOfPolicyInput.isDisplayed(), "'Name of the policy' is not displayed");
    }

    public void inputNameOfPolicy(String nameOfPolicy) {
        nameOfPolicyInput.sendKeys(nameOfPolicy);
    }

    public void checkIsStateDisplayed() {
        Assert.assertTrue(selectState.isDisplayed(), "'State' is not displayed");
    }

    public void setState() {
        selectState.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(stateUtah).click().perform();
    }

    public void checkIsSetPolicyDefaultDisplayed() {
        Assert.assertTrue(setDefaultPolicy.isDisplayed(), "'Set Default Policy' is not displayed");
    }

    public void checkSetDefault() {
        if (!setDefaultPolicy.isSelected()) {
            setDefaultPolicy.click();
        }
    }

    public void checkIsPriceFieldDisplayed() {
        Assert.assertTrue(priceInput.isDisplayed(), "'Pet Fee' field is not displayed ");
    }

    public void inputPetFee(String price) {
       priceInput.sendKeys(price);
    }

    public void checkIsAddButtonDisplayed(){
        Assert.assertTrue(addButton.isDisplayed(),"'Add' button is not displayed");
    }

    public void clickAddButton(){
        addButton.click();
    }

    public void checkCloseAddPolicyButton(){
        Assert.assertTrue(closeAddPolicyButton.isDisplayed(),"'Close' button is not displayed");
    }

    public void closePolicy(){
        closeAddPolicyButton.click();
    }

    public void checkSuccessfullyAddedMessage(){
       Assert.assertTrue(successfulMessageAdded.isDisplayed(),"Successful ADDED message is not working");
    }

    public void checkIsAddedPolicy(){
        Assert.assertTrue(firstAddedPolicyName.isDisplayed(),"Added policy is not displayed");
    }

    public void checkIsPolicyNotAdded(){
        Assert.assertFalse(firstAddedPolicyName.isDisplayed(),"One of required fields have validation errors");
    }



    public void checkSuccessfullyDeletedMessage(){
        Assert.assertTrue(successfulMessageDeleted.isDisplayed(),"Successful DELETED message is not working");
    }

    public void deletePolicy(){
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOf(deletePolicyButton));
        deletePolicyButton.click();
        confirmDelete.click();
    }

    public void checkNameErrorMessage(){
        Assert.assertTrue(nameOfPolicyErrorMessage.isDisplayed(),"Error massage is not displayed");
    }

    public void checkPriceErrorMessage(){
           Assert.assertTrue(priceErrorMessage.isDisplayed(), "Price is incorrect");
    }

    public void checkIsAddedDefaultPolicy(){
        Assert.assertTrue(firstDefaultPolicy.getText().length()>0,"default policy is not added");
    }

    public void checkState(){
        Assert.assertTrue(firstAddedPolicyState.getText().contains("Utah"));
    }
}
