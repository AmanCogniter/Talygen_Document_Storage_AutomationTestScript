package testcases;

import Action.LoginAction;
import Action.UserStorageAction;
import org.testng.annotations.Test;
import utils.WebTestBase;

import static reporting.ComplexReportFactory.getTest;

public class UserStorageTest extends WebTestBase {

    @Test(priority=1,enabled=true)
    public void verifyStorageCounts() {
        test = getTest("TC_User_Storage_001");
        UserStorageAction userStorage = new UserStorageAction(driver);
        LoginAction login = new LoginAction(driver);

        login.logoutLogin();
        userStorage.navigateToUserStoragePage();
        userStorage.allowedStorageFieldDisable();
        userStorage.saveAllowedStorageForOneUser();
        userStorage.saveAllowedStorageForMultiUser();
        userStorage.verifyTableAndHeaderCount();
    }

    @Test(priority=2)
    public void verifySearchFunctionality() {
        test = getTest("TC_User_Storage_002");
        UserStorageAction userStorage = new UserStorageAction(driver);
        LoginAction login = new LoginAction(driver);

        login.logoutLogin();
        userStorage.navigateToUserStoragePage();
        userStorage.searchAndVerifyDepartment();
        userStorage.searchAndVerifyDesignation();
        userStorage.searchAndVerifyUserName();
        userStorage.searchAndVerifyConsumedStorage();
    }

    @Test(priority=3)
    public void verifySortingFunctionality() {
        test = getTest("TC_User_Storage_003");
        UserStorageAction userStorage = new UserStorageAction(driver);
        LoginAction login = new LoginAction(driver);

        login.logoutLogin();
        userStorage.navigateToUserStoragePage();
        userStorage.userNameSorting();
        userStorage.designationSorting();
        userStorage.departmentSorting();
        userStorage.statusSorting();
        userStorage.consumedStorageSorting();
        userStorage.allowedStorageSorting();
    }
}
