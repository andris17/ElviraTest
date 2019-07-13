package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import static driver.DriverMethods.*;

public class LoginForm {
    private final By loginContainer = By.id("login");
    private final ByChained loginButton = new ByChained(loginContainer, By.xpath(".//input[@type='submit']"));
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By useExistingLogin = By.xpath("//input[@type='radio' and @value='belep']");

    public void enterEmail(String email) {
        clearAndSetText(emailField, email);
    }

    public void enterPassword(String password) {
        clearAndSetText(passwordField, password);
    }

    public void login() {
        clickElement(loginButton);
        if (isPresent(useExistingLogin)&&isDisplayed(useExistingLogin)){
            clickElement(useExistingLogin);
            clickElement(loginButton);
        }
    }


}
