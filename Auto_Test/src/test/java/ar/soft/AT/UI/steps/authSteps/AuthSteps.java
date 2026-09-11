package ar.soft.AT.UI.steps.authSteps;

import ar.soft.AT.UI.modelPage.authorization.AuthorizationSPage;

public class AuthSteps {

    private final AuthorizationSPage authSPage = new AuthorizationSPage();

    public void login(String username, String password) {
        authSPage.enterUsername(username);
        authSPage.enterPassword(password);
        authSPage.clickBtnCheckbox();
        authSPage.clickLogin();
    }
}
