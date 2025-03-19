package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultCompanent {
    private final SelenideElement TableResponse = $("[class=table-responsive]");
    public void CheckResult(String key, String value){

        TableResponse.$(byText(key)).parent().shouldHave(Condition.text(value));
    }
}
