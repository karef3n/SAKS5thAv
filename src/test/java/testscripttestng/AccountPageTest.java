package testscripttestng;

import com.saksfifthav.testng.framework.base.ScriptBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AccountPageTest extends ScriptBase {

    @Test
    public void accountSignupTest1() {
        saksFifth.homepage().naviageteToHomepage();
        saksFifth.homepage().varifyHomepage();
        delayFor(2000);
        saksFifth.homepage().closePopup();
        delayFor(4000);
        //saksFifth.accountPage().varifyAccountPage();
        //delayFor(4000);
        // saksFifth.accountPage().logIn("sum10n@yahoo.com","Rajib100#");
        delayFor(9000);
        saksFifth.accountPage().createNewAccount("Kamrul",
                "Arefin",
                "sum10n@yahoo.com",
                "Rajib100#",
                "Rajib100#",
                "",
                "10022"
        );
        saksFifth.accountPage().varifyAccountPage();
        delayFor(2000);
        saksFifth.accountPage().checkCheckbox();

    }

    @Test(dataProvider = "getTestData")
    public void accountSignupTestA(String firstname, String lastname, String email,
                                   String pass, String conPass, String phone, String zipcode) {
        saksFifth.homepage().naviageteToHomepage();
        saksFifth.homepage().varifyHomepage();
        delayFor(2000);
        saksFifth.homepage().closePopup();
        delayFor(4000);
        //saksFifth.accountPage().varifyAccountPage();
        //delayFor(4000);
        // saksFifth.accountPage().logIn("sum10n@yahoo.com","Rajib100#");
        delayFor(9000);
        saksFifth.accountPage().createNewAccount( firstname, lastname, email,
                pass, conPass, phone,zipcode);


    }



        @Test
        public void accountSignupTest2 () {
            saksFifth.homepage().naviageteToHomepage();
            saksFifth.homepage().varifyHomepage();
            delayFor(2000);
            saksFifth.homepage().closePopup();
            delayFor(4000);
            saksFifth.accountPage().varifyAccountPage();
            delayFor(4000);
            saksFifth.accountPage().logIn("sum10n@yahoo.com", "Rajib100#");
            saksFifth.accountPage().login_success_message_display();
        }

    @DataProvider
    public Object[][] getTestData() {

        Object[][] data = {{"Kamrul",
                "Arefin",
                "sum10n@yahoo.com",
                "Rajib100#",
                "Rajib100#",
                "",
                "10022"}, {"Jamrul",
                "Hasan",
                "nefaur.rb@gmail.com",
                "Jajib100#",
                "Jajib100#",
                "",
                "10023"}};

        return data;
    }

    }
