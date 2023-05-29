import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.selector.ByDeepShadow.cssSelector;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void fillFormTest() {
        open("/text-box");

        $("[id=userName]").setValue("Vlad");
        $("[id=userEmail]").setValue("vlad.nigreev@ab-soft.com");
        $("[id=currentAddress]").setValue("OAK Elm street");
        $("[id=permanentAddress]").setValue("OAK Baker street");
        $("[id=submit]").click();

        $("[id=output]").shouldHave(text("Vlad"), text("vlad.nigreev@ab-soft.com"),
                text("OAK Elm street"), text("OAK Baker street"));
    }

}
