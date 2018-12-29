package pages;

import com.saksfifthav.testng.framework.base.PageBase;
import com.saksfifthav.testng.framework.base.PropertyReaderService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import utils.DriverFactory;
import utils.ExplicitWaitUtils;

import java.util.List;

import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePage extends PageBase {



    @FindBy(xpath =(".//*[@id='navigationMenu'"))
    protected List<WebElement> TOP_NAV_LIST;

    public HomePage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        //PageFactory.initElements(driver, this);
       // super.closeTriggerPopup();
    }

    public void naviageteToHomepage(){
      driver.navigate().to("http://www.saksfifthavenue.com/");
        //driver.navigate().to(PropertyReaderService.getInstance().getProperty("APP_URL"));
    }

    public void naviagetePage(String url)
    {
        driver.navigate().to(url);
    }

    public void varifyHomepage(){
      // Assert.assertEquals("Designer Women's Apparel, Men's Apparel, Shoes & Handbags - Saks.com", driver.getTitle());
        String title = driver.getTitle();
        assertThat(title,startsWith("Designer Women's Apparel, Men's Apparel, Shoes & Handbags - Saks.com"));
        //extentManager.log("Designer Women's Apparel, Men's Apparel, Shoes & Handbags - Saks.com" + driver.getTitle()); //for extend report
    }

    public void gotoTopNav(String name){
        for (WebElement topNav : TOP_NAV_LIST){

            System.out.println("Top Menu: " + topNav.getText());

            if(topNav.getText().contentEquals(name.toUpperCase())){
                mouseOn(topNav);
            }
        }
    }
    public void closePopup(){

            // saksFifth.accountPage().createNewAccount();
            WebElement poUpWindowFrame = driver.findElement(By.xpath("//*[@src ='/email_popup/EML1145Acollect.jsp']"));
            driver.switchTo().frame(poUpWindowFrame );
            delayFor(2000);
            driver.findElement(By.xpath(".//*[@id='close-button']")).click();

            driver.switchTo().defaultContent();

            //.signin link
            //driver.findElement(By.xpath(".//*[@id='ui-header']/div/header/div/div[1]/div/a/span")).click();
            driver.findElement(By.xpath (".//*[@id='ui-header']/div/header/div//div/div/a/span")).click();
            delayFor(2000);
            driver.findElement(By.xpath (".//*[@id='account-content-area']/div//div/div/div/div/div/button")).click();

        }





    }

