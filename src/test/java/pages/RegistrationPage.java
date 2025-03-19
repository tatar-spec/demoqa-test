package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultCompanent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectFormOpen =  $("#subjectsContainer"),
            setSubject = $("#subjectsInput"),
            selectHobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            setAddress = $("#currentAddress"),
            setState =  $("#react-select-3-input"),
            submitForm = $("#submit"),
            closeModal = $("#closeLargeModal");


    CalendarComponent calendarComponent = new CalendarComponent();
    ResultCompanent checkResultComponent = new ResultCompanent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
    public RegistrationPage setSubject(String subject){
        subjectFormOpen.click();
        setSubject.setValue(subject).pressEnter();

        return this;
    }
    public RegistrationPage selectHobbiesWrapper(String hobbie){

       selectHobbiesWrapper.$(byText("Sports")).click();

        return this;
    }

     public RegistrationPage uploadPicture (String pictureName){

       uploadPicture.uploadFromClasspath(pictureName);

        return this;
    }
     public RegistrationPage setAddress(String value) {
        setAddress.setValue(value);

        return this;
    }
    public RegistrationPage setState(String state,String city) {
        setState.setValue(state).pressEnter();

        setState.setValue(city).pressEnter();

        return this;
    }

    public  RegistrationPage checkResults(String key, String value) {
      checkResultComponent.CheckResult(key, value);
      return this;
    }
    public RegistrationPage submitForm(){
        submitForm.click();
        return this;
    }
    public RegistrationPage closeModal(){
        closeModal.click();
        return this;
    }

}