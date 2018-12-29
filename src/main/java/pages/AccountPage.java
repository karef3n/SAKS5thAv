package pages;

import com.saksfifthav.testng.framework.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

public class AccountPage extends PageBase {

    @FindBy(xpath=".//*[@id='ui-header']/div/header/div//div/div/a/span")
    protected WebElement signUp;
    @FindBy(xpath=".//*[@id='account-content-area']/div//div//div/div/button")
    protected WebElement createAccount;
    @FindBy(xpath=(".//*[@id='create-new-account-first-name']"))
    protected WebElement firstName;

    @FindBy(css=("#create-new-account-last-name"))
    protected WebElement lastName;

    @FindBy(css=("#create-new-account-email"))
    protected WebElement emailTextBox;

    @FindBy(css=("#create-new-account-password"))
    protected WebElement password;

    @FindBy(css=("#create-new-account-confirm-password"))
    protected WebElement conPassword;

    @FindBy(xpath="(//*[@id='account-content-area']/div//div//button)[1]")
    protected WebElement submitAccount;

    @FindBy(css=("#create-new-account-phone-number"))
    protected WebElement phoneNumber;

    @FindBy(css=("#create-new-account-postal-code"))
    protected WebElement zipCode;
    @FindBy(xpath=(".//*[@id='sign-into-account-email-field']"))
    protected WebElement signInEmailTextBox;
    @FindBy(xpath=(".//*[@id='sign-into-account-password-field']"))
    protected WebElement passwordTextBox;
    @FindBy(xpath=(".//*[@id='account-content-area']/div/div[2]/div[1]/div/div/div[1]/section/form/div/button"))
    protected WebElement signInTexBox;
    @FindBy(css=(".checkbox-group_fieldset"))
    protected WebElement checkBox;

    public AccountPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }


    public void logIn(String email, String password){

        signUp.click();
        delayFor(2000);
        mouseOn(signInEmailTextBox);
        signInEmailTextBox.sendKeys(email);
        mouseOn(passwordTextBox);
        passwordTextBox.sendKeys(password);
        mouseOn(signInTexBox);
        signInTexBox.click();
    }



      public void createNewAccount (String firstname, String lastname, String email,
             String pass, String conPass, String phone, String zipcode) {

         signUp.click();

          mouseOn(createAccount);
          delayFor(5000);
         createAccount.click();
         delayFor(6000);
          mouseOn(firstName);
         firstName.sendKeys(firstname);
          mouseOn(lastName);
         lastName.sendKeys(lastname);
         emailTextBox.sendKeys(email);
         password.sendKeys(pass);
         conPassword.sendKeys(conPass);
         phoneNumber.sendKeys(phone);
         zipCode.sendKeys(zipcode);
          mouseOn(submitAccount);
         submitAccount.click();

     }



    public void varifyAccountPage(){
        // Assert.assertEquals("Designer Women's Apparel, Men's Apparel, Shoes & Handbags - Saks.com", driver.getTitle());
        String title = driver.getTitle();
        assertThat(title,startsWith("Account - Saks"));
        //extentManager.log("Designer Women's Apparel, Men's Apparel, Shoes & Handbags - Saks.com" + driver.getTitle()); //for extend report
    }

    public void login_success_message_display(){

        String msg = driver.findElement(By.xpath(".//*[@id='account-content-area']/div/div[1]/div/h1")).getText();

        assertThat(msg,startsWith("Kamrul's Account"));
    }

   public void uncheckCheckbox(){
        WebElement chk1 =driver.findElement(By.xpath(".//*[@id='account-content-area']//span[text()='Saks Fifth Avenue']"));
       String isChecked = chk1.getAttribute("checked");
       chk1.click();
       WebElement chk2  = driver.findElement(By.xpath(".//*[@id='account-content-area']//span[text()='Saks OFF 5TH']"));

       chk2 .click();
   }
    public void checkCheckbox( ){
        WebElement chk1 =driver.findElement(By.xpath(".//*[@id='account-content-area']//span[text()='Saks Fifth Avenue']"));
        //String isChecked = chk1.getAttribute("checked");
        checkcheckbox(chk1);

        WebElement chk2 = driver.findElement(By.xpath(".//*[@id='account-content-area']//span[text()='Saks OFF 5TH']"));
        checkcheckbox(chk2);
        }



        public void checkcheckbox1() {

        WebElement chk1 =driver.findElement(By.xpath(".//*[@id='account-content-area']//span[text()='Saks Fifth Avenue']"));
            String isChecked = chk1.getAttribute("unchecked");

                delayFor(2000);

        chk1.click();

        WebElement chk2 = driver.findElement(By.xpath(".//*[@id='account-content-area']//span[text()='Saks OFF 5TH']"));
           // boolean isChecked = chk2.isSelected();

                delayFor(2000);
           // chk2.click();

    }

}




