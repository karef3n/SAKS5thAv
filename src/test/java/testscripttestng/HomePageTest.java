package testscripttestng;

import com.saksfifthav.testng.framework.base.ScriptBase;
import org.testng.annotations.Test;

public class HomePageTest extends ScriptBase {

    @Test
    public void test(){

        saksFifth.homepage().naviageteToHomepage();
        saksFifth.homepage().varifyHomepage();
        saksFifth.homepage().closePopup();


    }


}
