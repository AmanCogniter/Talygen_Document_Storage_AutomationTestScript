package testcases;


import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import Action.ClientStorageAction;
import Action.LoginAction;
import Action.UserStorageAction;
import utils.WebTestBase;
/**
 * 
 * @author aanand
 *
 */

public class ClientStorageTest extends WebTestBase{
	static String Screenname = "<b>ClientStorage</b>";
    @Test(priority=1)
    public void verifyStorageCounts() {
    	
        test=getTest(Screenname + ": TC_Client_Storage_001");
        ClientStorageAction clientStorage = new ClientStorageAction(driver);
        new LoginAction(driver).logoutLogin();
        clientStorage.navigateToClientStoragePageAndExpand();
        clientStorage.allowedStorageFieldDisable();
        clientStorage.saveAllowedStorageForOneUser();
        clientStorage.saveAllowedStorageForMultiUser();
        clientStorage.verifyTableAndHeaderCount();
    }

    @Test(priority=2)
    public void verifySearchFunctionality() {
        test = getTest("TC_Client_Storage_002");
        ClientStorageAction clientStorage = new ClientStorageAction(driver);
        
        LoginAction login = new LoginAction(driver);
        login.logoutLogin();
        
        clientStorage.navigateToClientStoragePage();
        clientStorage.searchAndVerifyClientName();
        clientStorage.searchAndVerifyConsumedStorage();
    }

    @Test(priority=3)
    public void verifySortingFunctionality() {
        test = getTest("TC_Client_Storage_003");
        ClientStorageAction clientStorage = new ClientStorageAction(driver);
        LoginAction login = new LoginAction(driver);

        login.logoutLogin();
        clientStorage.navigateToClientStoragePageAndExpand();
        clientStorage.clientNameSorting();
        clientStorage.emailSorting();
        clientStorage.statusSorting();
        clientStorage.consumedStorageSorting();
        clientStorage.allowedStorageSorting();
    }
}
