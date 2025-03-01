import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTest {

    @BeforeAll
    static void beforAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen =true;
        Configuration.timeout = 5000;
    }

    @Test
    void FillPracticeFormTest(){
        open("/automation-practice-form");
        $("#firstName").setValue("StopFortnumAndMasonFoieGras");
        $("#lastName").setValue("Rhoshandiatellyneshiaunneveshenk");
        $("#userEmail").setValue("firstnamelastname@domain.com");
        $("label[for='gender-radio-2']").click();
        $("#userNumber").setValue("9055647548");
        $("#dateOfBirthInput").click();
        $("div.react-datepicker__month-dropdown-container").click();
        $(byText("August")).click();
        $("option[value='7']").click();
        $("div.react-datepicker__year-dropdown-container").click();
        $(byText("1990")).click();
        $("option[value='7']").click();
        $("div.react-datepicker__day--011").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Economics").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("label[for='hobbies-checkbox-2']").click();
        File file = new File("src/test/resources/testfile.png");
        $("#uploadPicture").uploadFile(file);
        $("#uploadPicture").shouldHave(value("testfile.png"));
        $("#currentAddress").setValue("119991, Russian Federation, Moscow, 119991, Russian Federation, Moscow, Leninskie Gory, 1").pressEnter();
        $(".css-1wa3eu0-placeholder").click();
        $(byText("Haryana")).shouldBe(visible).click();
        $(".css-1wa3eu0-placeholder").click();
        $(byText("Panipat")).shouldBe(visible).click();
        $("#submit").click();
        $(".modal-content").shouldBe(visible);
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']/following-sibling::td").shouldHave(text("StopFortnumAndMasonFoieGras Rhoshandiatellyneshiaunneveshenk"));
        $x("//td[text()='Student Email']/following-sibling::td").shouldHave(text("firstnamelastname@domain.com"));
        $x("//td[text()='Gender']/following-sibling::td").shouldHave(text("Female"));
        $x("//td[text()='Mobile']/following-sibling::td").shouldHave(text("9055647548"));
        $x("//td[text()='Date of Birth']/following-sibling::td").shouldHave(text("11 August,1990"));
        $x("//td[text()='Subjects']/following-sibling::td").shouldHave(text("English, Economics, Maths"));
        $x("//td[text()='Hobbies']/following-sibling::td").shouldHave(text("Reading"));
        $x("//td[text()='Picture']/following-sibling::td").shouldHave(text("testfile.png"));
        $x("//td[text()='Address']/following-sibling::td").shouldHave(text("119991, Russian Federation, Moscow, 119991, Russian Federation, Moscow, Leninskie Gory, 1"));
        $x("//td[text()='State and City']/following-sibling::td").shouldHave(text("Haryana Panipat"));
        $("#closeLargeModal").click();
    }
}

