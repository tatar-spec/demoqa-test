import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setEmail("alex@egorov.com")
                .setGender("Other")
                .setUserNumber("1234567890")
                .setDateOfBirth("30", "July", "2008")
                .setSubject("Math")
                .selectHobbiesWrapper("Sports")
                .uploadPicture("1.png")
                .setAddress("Some address 1")
                .setState("NCR" ,"Delhi" )
                .checkResult("Student Name", "Alex Egorov")
                .checkResult("Student Email", "alex@egorov.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "1.png")
                .checkResult("Address", "Some address 1")
                .closeModal();


    }
    @Test
    void fillPracticeFormWithMinData(){
          registrationPage.openPage()
                .setFirstName("Maxim")
                .setLastName("Egorov")
                .setGender("Other")
                .setUserNumber("1234567890")
                .submitForm()
                .checkResult("Student Name", "Maxim Egorov")
                .checkResults("Gender", "Other")
                .checkResults("Mobile", "1234567890");



    }
     @Test
    void negativTest(){
          registrationPage.openPage()
                .setFirstName(" ")
                .setLastName("Davitovish")
                .setGender("Other")
                .setUserNumber("9234567890")
                .submitForm()
                .checkResult("Student Name", "Maxim Egorov")
                .checkResults("Gender", "Male")
                .checkResults("Mobile", "1234567890")
                .closeModal();


    }
}