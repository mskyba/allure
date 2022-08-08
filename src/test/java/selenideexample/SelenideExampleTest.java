package selenideexample;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SelenideExampleTest {


    @Test
    @Step(value="Logging In")
    public void loggingIn() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        open("http://the-internet.herokuapp.com/login");
        $x("//*[@id=\"username\"]")
                .setValue("tomsmith");
        $x("//*[@id=\"password\"]")
                .setValue("SuperSecretPassword!");
        $x("//i[contains(text(),'Login')]")
                .click();
        $x("//*[@id=\"flash\"]")
                .isDisplayed();


}


@Test
    @Step(value="Logging Out")
    public void loggingOut() {

    SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
       open("http://the-internet.herokuapp.com/secure");
    $x("//i[contains(text(),'You logged into a secure area!')]")
            .shouldNotBe(Condition.visible);
    $x("//a[@class='button secondary radius']")
            .click();







}

}