import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTest {
    @BeforeAll
    static void beforAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen =true;
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest(){
        open("/text-box");
        $("#userName").setValue("Alex");
        $("#userEmail").setValue("test@gmail.com");
        $("#currentAddress").setValue("Some Address 1");
        $("#permanentAddress").setValue("Another street 1");
        $("#submit").click();
        $("#output #name").shouldHave(text("Alex"));
        $("#output #email").shouldHave(text("test@gmail.com"));
        $("#output #currentAddress").shouldHave(text("Some Address 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 1"));
    }
}