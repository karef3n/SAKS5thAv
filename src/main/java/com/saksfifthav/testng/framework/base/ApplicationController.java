package com.saksfifthav.testng.framework.base;

import com.paxovision.execution.reporter.interceptor.ProxyGenerator;
import pages.AccountPage;
import pages.HomePage;

public class ApplicationController {
    private HomePage homepage ;
    private AccountPage accountPage;

    public ApplicationController() {}

    public HomePage homepage(){
        if(homepage==null){
            //homepage = new Homepage();
            homepage = ProxyGenerator.getEnhancedObject(HomePage.class);
        }
        return homepage;
    }

    public AccountPage accountPage(){
        if(accountPage==null){
            //homepage = new Homepage();
            accountPage = ProxyGenerator.getEnhancedObject(AccountPage.class);
        }
        return accountPage;
    }

}
